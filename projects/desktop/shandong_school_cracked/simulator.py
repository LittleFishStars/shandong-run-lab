#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""运动仿真引擎 —— 移植自 BieFan1029/FUCK-RUN-

原项目（GPL-3.0）是一个 LSPosed 模块：Hook `SensorManager.registerListener`，
拦截目标应用的 `onSensorChanged`，用正弦波伪造加速度、用「时间 × 步频」
伪造计步器，并把 `event.timestamp` 改写成 `SystemClock.elapsedRealtimeNanos()`
以保持数据时效性。关键实现（`JoyrunHook.java`）：

    float elapsedSecs = (now - mockStartTime) / 1000f;
    float freq        = currentCadence / 60.0f;            // 175 步/分 ≈ 2.92 Hz
    float zWave       = 9.81f + sin(elapsedSecs * 2π * freq) * 3.5f;
    float yWave       = cos(elapsedSecs * 2π * freq) * 1.5f;
    event.values[0] = 0.0f;                                 // X 轴置零
    event.values[1] = yWave + jitterY;                      // jitter ±0.15
    event.values[2] = zWave + jitterZ;
    event.values[0] = baseStepOffset + elapsedSecs * freq;   // 计步器
    event.timestamp = SystemClock.elapsedRealtimeNanos();

本文件把这套逻辑复刻成**纯 Python 可离线运行**的仿真器：给定时间轴就能
产出传感器采样序列，再喂给协议层生成上传报文。相比原版额外做了三件事：

  1. 步频不是一次性随机定死，而是「区间内随机基准 + 慢漂移 + 疲劳衰减」，
     避免整段步频恒定被 `maxFrequency` 类规则识别；
  2. 支持**暂停门控**（对齐客户端 `StepComponent` 的暂停标志：非跑步状
     态下步态检测出的步数直接被丢弃）；
  3. 支持采样丢包（隧道 / 丢星）与丢步，用于测试上传层的容错与续传。
"""
from __future__ import annotations

import math
import random
from dataclasses import dataclass
from typing import Any, Dict, Iterator, List, Optional, Tuple

# 传感器类型（对齐 android.hardware.Sensor）
TYPE_ACCELEROMETER = 1
TYPE_STEP_DETECTOR = 18
TYPE_STEP_COUNTER = 19

GRAVITY = 9.81
DEFAULT_HZ = 25.0               # 传感器上报频率（真实设备约 20–50 Hz）
DEFAULT_MIN_CADENCE = 172.0     # FUCK-RUN- 默认区间下限（步/分）
DEFAULT_MAX_CADENCE = 182.0


@dataclass
class SensorSample:
    """一帧传感器数据（等价于一次 onSensorChanged 回调）"""

    t_ms: int                   # 相对 start 的毫秒（elapsedRealtime 语义）
    x: float = 0.0
    y: float = 0.0
    z: float = GRAVITY
    steps_cum: float = 0.0      # TYPE_STEP_COUNTER 的值
    step_detected: bool = False  # TYPE_STEP_DETECTOR 是否触发
    timestamp_ns: int = 0       # 伪造后的 event.timestamp
    cadence: float = 0.0        # 当前步频（步/分）
    dropped: bool = False       # 本帧是否被模拟丢包

    def to_dict(self) -> Dict[str, Any]:
        return {
            "t": self.t_ms, "x": round(self.x, 4),
            "y": round(self.y, 4), "z": round(self.z, 4),
            "stepsCum": round(self.steps_cum, 3),
            "stepDetected": self.step_detected,
            "cadence": round(self.cadence, 2),
            "dropped": self.dropped,
        }


@dataclass
class SimState:
    """仿真器的可序列化状态（便于 GUI 保存/恢复一次仿真）"""

    running: bool = False
    start_ms: int = 0
    base_steps: float = 0.0
    base_cadence: float = 176.0
    elapsed_s: float = 0.0
    suspended: bool = False
    dropped_samples: int = 0
    total_samples: int = 0

    def to_dict(self) -> Dict[str, Any]:
        return {
            "running": self.running, "startMs": self.start_ms,
            "baseSteps": self.base_steps, "baseCadence": self.base_cadence,
            "elapsedS": round(self.elapsed_s, 2), "suspended": self.suspended,
            "dropped": self.dropped_samples, "samples": self.total_samples,
        }


class FuckRunSim:
    """步频 / 加速度 / 计步仿真核心（FUCK-RUN- 移植版）

    用法：
        sim = FuckRunSim(min_cadence=172, max_cadence=182)
        sim.start(base_steps=12000)
        for s in sim.timeline(duration_s=720, hz=25):
            ...
        print(sim.state().to_dict())
    """

    def __init__(self, min_cadence: float = DEFAULT_MIN_CADENCE,
                 max_cadence: float = DEFAULT_MAX_CADENCE,
                 accel_amplitude: float = 3.5,
                 lateral_amplitude: float = 1.5,
                 jitter: float = 0.15,
                 dropout_rate: float = 0.0,
                 step_loss_rate: float = 0.0,
                 hz: float = DEFAULT_HZ,
                 drift: float = 0.03,
                 fatigue: float = 0.05,
                 seed: Optional[int] = None):
        if min_cadence > max_cadence:
            min_cadence, max_cadence = max_cadence, min_cadence
        self.min_cadence = float(min_cadence)
        self.max_cadence = float(max_cadence)
        self.accel_amplitude = float(accel_amplitude)
        self.lateral_amplitude = float(lateral_amplitude)
        self.jitter = float(jitter)
        self.dropout_rate = max(0.0, min(1.0, float(dropout_rate)))
        self.step_loss_rate = max(0.0, min(1.0, float(step_loss_rate)))
        self.hz = max(1.0, float(hz))
        self.drift = float(drift)
        self.fatigue = float(fatigue)
        self.rng = random.Random(seed)

        self._state = SimState()
        self._next_step_at = 0.0     # 下一次 STEP_DETECTOR 触发的时间点（秒）

    # ══════════════════ 生命周期 ══════════════════
    def start(self, start_ms: Optional[int] = None, base_steps: float = 0.0) -> SimState:
        """开始仿真

        base_steps 对应原版捕获到的真实计步基准 `baseStepOffset`。
        """
        st = self._state
        st.running = True
        st.start_ms = int(start_ms if start_ms is not None else 0)
        st.base_steps = float(base_steps)
        st.elapsed_s = 0.0
        st.suspended = False
        st.dropped_samples = 0
        st.total_samples = 0
        # 区间内随机一个基准步频（等价于原版的 currentCadence 随机生成）
        st.base_cadence = self.rng.uniform(self.min_cadence, self.max_cadence)
        self._next_step_at = 0.0
        return st

    def stop(self) -> SimState:
        self._state.running = False
        return self._state

    def resume(self) -> None:
        self._state.running = True

    def suspend(self) -> None:
        """暂停计步（对齐 StepComponent 的暂停标志：暂停期步数直接丢弃）"""
        self._state.suspended = True

    def unsuspend(self) -> None:
        self._state.suspended = False

    def state(self) -> SimState:
        return self._state

    def set_cadence_range(self, lo: float, hi: float) -> None:
        """运行中调整步频区间（等价于原版悬浮窗广播下发的新区间）"""
        if lo > hi:
            lo, hi = hi, lo
        self.min_cadence, self.max_cadence = float(lo), float(hi)
        self._state.base_cadence = self.rng.uniform(self.min_cadence, self.max_cadence)

    def set_cadence(self, cadence: float) -> None:
        self._state.base_cadence = max(self.min_cadence,
                                       min(self.max_cadence, float(cadence)))

    # ══════════════════ 步频曲线 ══════════════════
    def cadence_at(self, t_s: float) -> float:
        """t 秒时刻的瞬时步频（步/分）

        构成：基准（区间内随机）+ 慢漂移（±drift）+ 疲劳衰减（随时间下降），
        结果被夹在 [min_cadence, max_cadence] 区间内 —— 原版靠随机基准避免
        规律检测，这里再叠一层缓变，更接近真人跑步曲线。
        """
        st = self._state
        phase = 2 * math.pi * t_s / 90.0            # 约 1.5 分钟一个慢周期
        drift = 1.0 + self.drift * math.sin(phase)
        warm = 1.0
        if t_s < 30.0:                              # 前 30 秒热身爬升
            warm = 0.90 + 0.10 * (t_s / 30.0)
        fatigued = 1.0 - self.fatigue * min(1.0, t_s / 1800.0)   # 30 分钟衰减上限
        c = st.base_cadence * drift * warm * fatigued
        return max(self.min_cadence, min(self.max_cadence, c))

    def freq_hz(self, t_s: float) -> float:
        """步频对应的加速度振荡频率（Hz）：175 步/分 ≈ 2.92 Hz"""
        return self.cadence_at(t_s) / 60.0

    # ══════════════════ 单帧采样 ══════════════════
    def sample_at(self, t_s: float, elapsed_s: Optional[float] = None) -> SensorSample:
        """取 t 秒（相对时间轴）处的一帧传感器数据

        elapsed_s 用于暂停语义：暂停期间**时间轴继续走**，但步数不累加，
        与客户端「暂停时步态回调被丢弃」的行为一致。
        """
        st = self._state
        moving_s = st.elapsed_s if elapsed_s is None else float(elapsed_s)
        cadence = self.cadence_at(t_s)
        freq = cadence / 60.0
        phase = 2 * math.pi * freq * t_s

        # ── 加速度：与原版逐式对应 ──
        z = GRAVITY + math.sin(phase) * self.accel_amplitude
        y = math.cos(phase) * self.lateral_amplitude
        jy = self.rng.uniform(-self.jitter, self.jitter)
        jz = self.rng.uniform(-self.jitter, self.jitter)

        # ── 计步器：base + 有效运动时长 × 步频 ──
        steps = st.base_steps + moving_s * freq

        # ── 步检测器：每跨过一个整步触发一次 ──
        detected = False
        if t_s >= self._next_step_at and not st.suspended:
            detected = True
            step_period = 1.0 / freq if freq > 0 else 1.0
            self._next_step_at = t_s + step_period

        dropped = self.rng.random() < self.dropout_rate
        st.total_samples += 1
        if dropped:
            st.dropped_samples += 1

        return SensorSample(
            t_ms=int(t_s * 1000),
            x=0.0,
            y=y + jy,
            z=z + jz,
            steps_cum=steps,
            step_detected=detected,
            timestamp_ns=int((st.start_ms + t_s * 1000) * 1_000_000),
            cadence=cadence,
            dropped=dropped,
        )

    # ══════════════════ 时间线 ══════════════════
    def timeline(self, duration_s: float, hz: Optional[float] = None,
                 advance_elapsed: bool = True) -> Iterator[SensorSample]:
        """按频率产出整段采样序列

        暂停（suspend）期间仍按频率产出数据（模拟传感器照常上报），
        但计步值冻结——这正是客户端 StepComponent 的门控语义。
        """
        rate = float(hz if hz is not None else self.hz)
        dt = 1.0 / rate
        t = 0.0
        end = float(duration_s)
        while t <= end + 1e-9:
            st = self._state
            s = self.sample_at(t)
            if advance_elapsed and not st.suspended:
                st.elapsed_s += dt
            yield s
            t += dt

    def steps_at(self, t_s: float) -> float:
        """到 t 秒为止的累计步数（不含暂停扣减，等价于原有实现）"""
        return self._state.base_steps + t_s * (self._state.base_cadence / 60.0)

    def step_timeline(self, duration_s: float, interval_s: float = 3.0,
                      start_ms: Optional[int] = None) -> List[Tuple[int, int]]:
        """产出 (相对毫秒, 累计步数) 序列，供协议层切成 run_step 段

        按步检测器逐拍推进，因此累计步数是整数且单调；
        interval_s 与客户端轨迹采样间隔一致（默认 3 秒）。
        """
        st = self._state
        out: List[Tuple[int, int]] = []
        t = 0.0
        cum = int(st.base_steps)
        next_seg = 0.0
        seg = max(0.5, float(interval_s))
        while t <= duration_s + 1e-9:
            if t >= next_seg:
                out.append((int(t * 1000), cum))
                next_seg += seg
            if not st.suspended:
                freq = self.cadence_at(t) / 60.0
                cum += 1 if self.rng.random() < freq * (1.0 / self.hz) else 0
            t += 1.0 / self.hz
        if out and out[-1][0] < int(duration_s * 1000):
            out.append((int(duration_s * 1000), cum))
        return out

    # ══════════════════ 反作弊自检 ══════════════════
    def self_check(self) -> Dict[str, Any]:
        """对照 SchoolRule 的关键阈值给出仿真数据的体检结果

        对齐客户端可能判定的三类问题：步幅异常（58）、配速越界（3）、
        步频抖动过大（对应 swingAmplitudeThreshold 的量级参考）。
        """
        cadences = [self.cadence_at(t) for t in range(0, 600, 5)]
        lo, hi = min(cadences), max(cadences)
        jitter_ratio = (hi - lo) / max(1e-6, (hi + lo) / 2)
        return {
            "cadenceRange": [round(lo, 2), round(hi, 2)],
            "cadenceMean": round(sum(cadences) / len(cadences), 2),
            "jitterRatio": round(jitter_ratio, 4),
            "accelAmplitude": self.accel_amplitude,
            "lateralAmplitude": self.lateral_amplitude,
            "verdict": {
                "cadenceInRange": self.min_cadence <= lo and hi <= self.max_cadence,
                "jitterReasonable": jitter_ratio < 0.10,
                "amplitudeReasonable": 1.0 <= self.accel_amplitude <= 6.0,
            },
        }


# ══════════════════ 设备指纹 ══════════════════
def build_device_fingerprint(cfg: Optional[Dict[str, Any]] = None) -> Dict[str, str]:
    """按客户端 deviceId 三层降级算法生成设备指纹

    客户端实现（报告 07 §2，`om2.b`）：
      ① 缓存值 → ② ANDROID_ID → ③ 12 个 Build 字段的**长度取个位数**拼接，
      再与 `new UUID(finger.hashCode(), "35".hashCode())` 组合。
    第 ③ 步不依赖任何硬件 ID，同机型同系统得到相同前缀——这里完整复刻。
    """
    d = cfg or {}
    fields = [
        d.get("board", "a54x"), d.get("bootloader", "unknown"), d.get("brand", "samsung"),
        d.get("device", "a54x"), d.get("display", "RP1A.200720.012"),
        d.get("fingerprint", "samsung/a54xnsxx/a54x:14/TP1A.220624.014:user/release-keys"),
        d.get("hardware", "mt6985"), d.get("model", "SM-A5460"),
        d.get("manufacturer", "samsung"), d.get("product", "a54xnsxx"),
        d.get("system_version", "14"), d.get("id", "TP1A.220624.014"),
    ]
    finger = "".join(str(len(str(f)) % 10) for f in fields)
    # UUID(finger.hashCode(), "35".hashCode()) 的等价物：用稳定哈希替代 Java hashCode
    h1 = _java_hash(finger)
    h2 = _java_hash("35")
    device_id = f"{h1:08x}{h2:08x}"[:16]
    return {
        "finger": finger,
        "deviceId": device_id.lower()[:16],
        "fields": {k: str(v) for k, v in d.items()},
    }


def _java_hash(s: str) -> int:
    """Java String.hashCode 的等价位运算（int32 溢出语义）"""
    h = 0
    for ch in s:
        h = (31 * h + ord(ch)) & 0xFFFFFFFF
    if h >= 0x80000000:
        h -= 0x100000000
    return h & 0xFFFFFFFF


def random_device_id(seed: Optional[int] = None) -> str:
    """16 位小写 hex 设备 ID（与 Android ID 格式一致）"""
    rng = random.Random(seed)
    return "".join(rng.choice("0123456789abcdef") for _ in range(16))
