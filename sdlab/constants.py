#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园协议常量（全部来自本项目既有逆向成果，经服务端验证）

来源：
  · report/05  字段级加密（smali: com.zj.adlib.h33 / com.zj.adlib.cq）
  · report/06  signKey 字符串表还原
  · report/13  签名算法完全攻破（离线预言机 5/5 一致）
  · report/15  服务端端到端验证（服务端回显逐字节一致）
  · report/07  阳光跑链路（状态位 / 打卡 / 结算字段）

本文件是整个工程唯一的常量出口：改协议只改这里。
"""
from __future__ import annotations

from typing import Any, Dict, NamedTuple, Tuple

# ══════════════════ 版本信息 ══════════════════
APP_VERSION = "8.7.7"
BUILD_VERSION = "26101017"
APP_CODE = "SD001"
PACKAGE_NAME = "com.huachenjie.shandong_school"
USER_AGENT_PREFIX = "ShanDong"

# ══════════════════ 服务端 ══════════════════
API_HOST = "api.huachenjie.com"
BASE_URL = f"https://{API_HOST}/run-front"
OSS_CDN = "https://oss-cdn.huachenjie.com"
H5_ORIGIN = "https://mh5.huachenjie.com"

# ══════════════════ 加密密钥 ══════════════════
# 固定 IV —— 所有 AES-CBC 共用（包括签名、字段加密）
AES_IV = b"01234ABCDEF56789"

# ★ 请求签名密钥（AES-256：16 字节可见前缀 + 16 个 0x00）
#   env ∈ {9, 11} 用测试密钥，其余用生产密钥
SIGN_KEY_PROD = b"09L8MJRMJKXW8TPF" + bytes(16)
SIGN_KEY_TEST = b"Z3MDTC9JATA1SSYB" + bytes(16)
SIGN_ENV_TEST = (9, 11)

# 敏感字段加密密钥（手机号 / 密码 / 姓名 / 学号 / 学校名）
FIELD_KEY = b"F44B0282BEA83557" + bytes(16)

# 滑块验证码坐标（AES-128-ECB）
SLIDER_KEY = b"Ukp3hmSe7BmMcgbE"

# 滑块坐标补偿：先减图片基础边距取整，再加协议位移
SLIDER_MARGIN = 6.5
SLIDER_OFFSET = 16.5

# 跑步防篡改静态盐
RUN_IMG_RECORD_KEY = "2V8BQ8MYXWU10Y9Z"

# 多媒体资源解密 DES 密钥组（8 个轮换）
DES_KEYS: Tuple[bytes, ...] = (
    b"c6bd901f", b"0ddf44be", b"950e5927", b"6460d8df",
    b"11fb887f", b"117e4900", b"bd113950", b"a99f6f97",
)

# ══════════════════ 请求头默认值 ══════════════════
DEFAULT_MODEL = "SM-A5460"
DEFAULT_SYS_VER = "14"
DEFAULT_PLATFORM = "2"
DEFAULT_CHANNEL = "other"
HEADER_APP = "run-front"
HEADER_PV = "2"
HEADER_E = "0"

# ══════════════════ 上传状态位（report/07 §4.2）══════════════════
STATE_INIT = 1        # 待上传
STATE_UPLOADING = 2   # 上传中（进程崩溃后需复位为 INIT）
STATE_FAIL = 4        # 失败（可重试）
STATE_SUCC = 8        # 成功

# ══════════════════ 运动类型 ══════════════════
SPORT_TYPE_SUN = 1     # 阳光跑
SPORT_TYPE_FREE = 2    # 自由跑

SPORT_TYPE_NAME = {SPORT_TYPE_SUN: "阳光跑", SPORT_TYPE_FREE: "自由跑"}

# ══════════════════ 无效原因（report/07 §6）══════════════════
INVALID_CHECKPOINT = 1   # 打卡点缺失
INVALID_DISTANCE = 2     # 距离不足
INVALID_PACE = 3         # 配速越界
INVALID_GPS = 25         # GPS 异常
INVALID_STRIDE = 58      # 步幅异常

INVALID_REASON_NAME = {
    INVALID_CHECKPOINT: "打卡点缺失",
    INVALID_DISTANCE: "距离不足",
    INVALID_PACE: "配速越界",
    INVALID_GPS: "GPS 异常",
    INVALID_STRIDE: "步幅异常",
}

# ══════════════════ 暂停类型（report/07 §4.6）══════════════════
PAUSE_TYPES = ("AUTO", "REST", "FACE_RECOGNITION", "NFC_CHECK")

# ══════════════════ 采集与判定参数 ══════════════════
GPS_STALE_MS = 15_000     # LocationService 定位失效阈值
DEFAULT_SAMPLE_S = 3.0    # 轨迹采样间隔（与客户端一致）
DEFAULT_UPLOAD_BATCH = 50  # 轨迹分批上传粒度（与客户端一致）

# 打卡点判定半径（米）：进入该半径内视为打卡成功
CHECKPOINT_HIT_RADIUS_M = 12.0

# ══════════════════ 易盾风控常量（report/07）══════════════════
HT_PROTECT_PRODUCT_ID = "YD00717730319426"
HT_PROTECT_BUSINESS_ID = "f82ca827669c5cea035c25041e0d270e"

# ══════════════════ 服务端返回码 ══════════════════
CODE_OK = 0
CODE_NEED_LOGIN = 1516       # 未登录 / 未知路径
CODE_MISSING_PARAM = 1002    # 参数缺失

# ══════════════════ 接口表 ══════════════════
class Endpoint(NamedTuple):
    """一个业务接口：路径 + 请求头 v/api + 是否需要 sign"""

    path: str
    v: str
    api: str
    need_sign: bool = False


# fmt: off
EP = {
    # ── 登录 ──
    "login_check":      Endpoint("auth/loginCheck",          "loginCheck",        "auth"),
    "login_password":   Endpoint("auth/loginPassword",       "loginPassword",     "auth"),
    "login_sms_send":   Endpoint("auth/sendLoginSms",        "sendLoginSms",      "auth"),
    "login_sms":        Endpoint("auth/loginSms",            "loginSms",          "auth"),
    "logout":           Endpoint("auth/logout",              "logout",            "auth"),
    "sync_time":        Endpoint("syncTime",                 "syncTime",          "sync"),

    # ── 用户 / 学校 ──
    "user_info":        Endpoint("account/queryCommonUserInfo", "queryCommonUserInfo", "account"),
    "school_details":   Endpoint("api/school/details",       "details",           "api"),
    "semesters":        Endpoint("attend/semesterSelector",  "semesterSelector",  "attend"),

    # ── 围栏 / 规则 ──
    "fence_list":       Endpoint("school/querySchoolFences", "querySchoolFences", "school"),
    "fence_filter":     Endpoint("school/filterUsableFence", "filterUsableFence", "school"),
    "sunrun_rule":      Endpoint("run/querySunRunRule",      "querySunRunRule",   "run"),
    "sunrun_abstract":  Endpoint("run/querySunRunAbstractInfoV2", "querySunRunAbstractInfoV2", "run"),
    "sunrun_config":    Endpoint("run/checkSunRunConfig",    "checkSunRunConfig", "run"),
    "plan_list":        Endpoint("run/plan/selectList",      "selectList",        "run/plan"),

    # ── 跑步主链路 ──
    "start_sun_run":    Endpoint("run/startSunRun_v2",       "startSunRun_v2",    "run"),
    "upload_record":    Endpoint("run/uploadRunRecord",      "uploadRunRecord",   "run", True),
    "upload_pace":      Endpoint("run/uploadPaceRecord",     "uploadPaceRecord",  "run"),
    "upload_step":      Endpoint("run/uploadStepsRecord",    "uploadStepsRecord", "run"),
    "upload_stride":    Endpoint("run/uploadStrideRecord",   "uploadStrideRecord", "run"),
    "upload_passpoint": Endpoint("run/uploadPassPoint",      "uploadPassPoint",   "run"),
    "finish_sun_run":   Endpoint("run/finishSunRun_v2",      "finishSunRun_v2",   "run"),
    "finish_free_run":  Endpoint("run/finishFreeRun",        "finishFreeRun",     "run"),
    "unfinish_run":     Endpoint("run/queryUnFinishRun",     "queryUnFinishRun",  "run"),
    "nfc_status":       Endpoint("nfc/verification-status",  "verification-status", "nfc"),

    # ── 记录 / 排行 ──
    "run_summary":      Endpoint("run/queryRunSummary",      "queryRunSummary",   "run"),
    "sunrun_list":      Endpoint("run/querySunRunList",      "querySunRunList",   "run"),
    "freerun_list":     Endpoint("run/queryFreeRunList",     "queryFreeRunList",  "run"),
    "rank_distance":    Endpoint("rank/distance",            "distance",          "rank"),
    "rank_progress":    Endpoint("rank/runProgress",         "runProgress",       "rank"),

    # ── 验证码（不经 run-front 前缀，见 captcha 模块）──
    "captcha_get":      Endpoint("captcha/get",              "get",               "captcha"),
    "captcha_check":    Endpoint("captcha/check",            "check",             "captcha"),
}
# fmt: on


def endpoint(name: str) -> Endpoint:
    """按名字取接口定义，未知名字直接抛错（避免静默打错接口）"""
    try:
        return EP[name]
    except KeyError:
        raise KeyError(f"未知接口名 {name!r}；可用：{', '.join(sorted(EP))}") from None


# ══════════════════ 结算报文默认骨架 ══════════════════
def finish_payload_skeleton() -> Dict[str, Any]:
    """finishSunRun_v2 的字段骨架（值由 runner 按本次跑步填充）

    report/07 §5.3：distance 与 dis 同时发送以兼容不同版本。
    """
    return {
        "distance": 0,
        "dis": 0,
        "duration": 0,
        "totalStep": 0,
        "sportType": SPORT_TYPE_SUN,
        "stepInterval": 60,
        "paceInterval": 1000,
        "alignType": 3,
        "status": 1,
        "runImgRecord": "",
        "timestamp": "",
        "targetPoints": [],
        "pois": [],
        "stepList": [],
        "paceList": [],
        "faceCheckRecordList": [],
    }
