import React, { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import { message, Modal } from 'antd';
import { Bridge } from './bridge';
import {
  parsePace, paceToSpeed, fmtPaceInput, fmtPaceShort, fmtDur, fmtKm, fmtDateTime,
} from './format';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import PickPage from './pages/PickPage';
import RunPage from './pages/RunPage';
import MorePage from './pages/MorePage';
import AccountPage from './pages/AccountPage';

const toast = (text, kind) => {
  const fn = kind === 'err' ? message.error : kind === 'ok' ? message.success : message.info;
  fn(text);
};

const pad = (n, w = 2) => String(n).padStart(w, '0');
const fmtEventTime = (ts) => {
  const d = new Date(ts || Date.now());
  return `${pad(d.getHours())}:${pad(d.getMinutes())}:${pad(d.getSeconds())}.${pad(d.getMilliseconds(), 3)}`;
};

export default function App() {
  const [status, setStatus] = useState(null);
  const [view, setView] = useState('login');
  const [accounts, setAccounts] = useState([]);
  const [savedOpen, setSavedOpen] = useState(false);
  const [fencePickOpen, setFencePickOpen] = useState(false);
  const [phone, setPhone] = useState('');
  const [password, setPassword] = useState('');
  const [busy, setBusy] = useState(false);
  const [log, setLog] = useState([]);
  const [progress, setProgress] = useState({ percent: 0, text: '就绪' });
  const [runs, setRuns] = useState({ items: [], page: 1, hasNext: false });
  const [detail, setDetail] = useState(null);
  const [walk, setWalk] = useState(null);
  const [walkPoints, setWalkPoints] = useState([]);
  const [fitNonce, setFitNonce] = useState(0);
  const [serverPoints, setServerPoints] = useState(null);
  const [ghostPath, setGhostPath] = useState([]);
  const [planRemain, setPlanRemain] = useState(0);
  const [params, setParams] = useState({
    distance: 2000, fence: 0, cadAvg: 177, cadVar: 5, stride: 0.85,
    pace: `6'40"`, autoSettle: true, auto: false, mode: 'real',
    tiles: 'amap', showState: true,
  });

  const seqRef = useRef(0);
  const walkSinceRef = useRef(0);
  const walkTimerRef = useRef(null);
  const walkTickRef = useRef(0);
  const walkRef = useRef(null);
  const ghostPathRef = useRef([]);
  const ghostIdxRef = useRef(0);
  const ghostLastMsRef = useRef(0);
  const ghostDragRef = useRef({ active: false, baseLat: 0, baseLng: 0, startLat: 0, startLng: 0 });
  const sentDirRef = useRef(null);
  const speedRef = useRef(2.5);
  speedRef.current = paceToSpeed(parsePace(params.pace)) || 2.5;
  walkRef.current = walk;
  ghostPathRef.current = ghostPath;
  const paramsLoadedRef = useRef(false);
  const statusRef = useRef(null);
  const viewRef = useRef(view);
  statusRef.current = status;
  viewRef.current = view;

  const refreshStatus = useCallback(async () => {
    try {
      const st = await Bridge.call('status');
      if (!st) return null;
      setStatus(st);
      setAccounts(st.accounts || []);
      if (!paramsLoadedRef.current) {
        paramsLoadedRef.current = true;
        const rc = st.run_cfg || {};
        const sc = st.sim_cfg || {};
        const wc = st.walk_cfg || {};
        const min = Number(sc.min_cadence) || 160;
        const max = Number(sc.max_cadence) || 200;
        setParams((p) => ({
          ...p,
          distance: Number(rc.target_distance_m) || p.distance,
          stride: Number(rc.stride_m) || p.stride,
          cadAvg: Math.round((min + max) / 2) || p.cadAvg,
          cadVar: Math.round(Math.abs(max - min) / 2),
          pace: wc.speed_mps ? fmtPaceInput(1000 / Number(wc.speed_mps)) : p.pace,
          autoSettle: wc.auto_settle !== false,
          auto: !!wc.auto_route,
          mode: st.mode || 'real',
        }));
      }
      return st;
    } catch (_) { return null; /* 桥未就绪 */ }
  }, []);

  const autoPrepare = useCallback(async () => {
    try {
      const st = await Bridge.call('status');
      if (!st || !st.logged_in) return;
      const needFence = !(st.fences || []).length;
      const needRule = !String(st.rule_source || '').trim();   // 默认 RuleSet 的来源是空串，说明还没从服务端拉到真实规则
      if (needFence) await Bridge.call('prepare');
      if (needRule) await Bridge.call('reload_rule');   // 规则没拉到就补一次，目标距离选项才有正确区间
      if (needFence || needRule) await refreshStatus();
    } catch (_) { /* 忽略 */ }
  }, [refreshStatus]);

  const refreshRuns = useCallback(async (page = 1) => {
    try {
      const r = await Bridge.call('server_records', page, 20);
      if (r && r.ok) {
        setRuns({ items: r.items || [], page: r.page || page, hasNext: !!r.has_next });
        // 打卡点实际数量：服务端开跑时下发 targetPoints（真实记录 5 个），围栏 requiredPointCounts 只有 2
        const first = (r.items || [])[0];
        if (first) {
          const d = await Bridge.call('server_record_detail', first.run_code, first.semester_code || '');
          setServerPoints(d && d.ok && d.target_points != null ? d.target_points : null);
        } else setServerPoints(null);
      } else setRuns({ items: [], page, hasNext: false, error: (r && r.error) || '拉取失败' });
    } catch (e) {
      setRuns({ items: [], page, hasNext: false, error: String((e && e.message) || e) });
    }
  }, []);

  /* 启动：有上次的登录会话就直接进选起始点页；会话失效才回登录页 */
  useEffect(() => {
    (async () => {
      await Bridge.waitReady();
      const st = await refreshStatus();
      if (st && st.logged_in) {
        try {
          const r = await Bridge.call('refresh_user');   // 顺带校验会话是否还有效
          if (r && r.code === 0) {
            await autoPrepare();
            const st2 = await refreshStatus();
            setView('pick');
            if (st2 && (st2.fences || []).length > 1) setFencePickOpen(true);
            refreshRuns(1);
            return;
          }
        } catch (_) { /* 会话失效，回登录页 */ }
      }
      setView('login');
    })();
  }, [refreshStatus, autoPrepare, refreshRuns]);

  /* 事件流 / 进度轮询 */
  useEffect(() => {
    let stop = false;
    const loop = async () => {
      if (stop) return;
      try {
        const r = await Bridge.call('poll', seqRef.current);
        if (r) {
          if (Array.isArray(r.events) && r.events.length) {
            const items = r.events.map((e) => ({
              key: `${e.seq || Date.now()}`,
              time: fmtEventTime(e.ts),
              kind: e.kind || 'log',
              level: e.level || 'info',
              message: e.message || '',
            }));
            seqRef.current = Math.max(seqRef.current, ...r.events.map((e) => Number(e.seq) || 0));
            setLog((prev) => [...prev, ...items].slice(-800));
          }
          if (r.progress) setProgress({ percent: r.progress.percent || 0, text: r.progress.message || '就绪' });
        }
      } catch (_) { /* 忽略轮询错误 */ }
      setTimeout(loop, 700);
    };
    loop();
    return () => { stop = true; };
  }, []);

  /* 右键从「人」的位置拉出复制点轨迹：起点取当前人的位置，之后跟随鼠标 */
  const onGhostStart = useCallback((lat, lng) => {
    const w = walkRef.current;
    const st = (w && w.state) || {};
    const bl = Number(st.lat), bg = Number(st.lng);
    const path = ghostPathRef.current || [];
    // 再次拖动从「复制点当前所在的位置」（轨迹终点）继续延长；第一次拖动从人的位置开始
    const base = path.length ? path[path.length - 1] : [bl, bg];
    if (!path.length) {
      if (!Number.isFinite(bl) || !Number.isFinite(bg)) return;
      setGhostPath([[bl, bg]]);
    }
    ghostDragRef.current = { active: true, baseLat: base[0], baseLng: base[1], startLat: lat, startLng: lng };
    ghostLastMsRef.current = 0;
  }, []);

  const onGhostMove = useCallback((lat, lng) => {
    const d = ghostDragRef.current;
    if (!d.active) return;
    const now = Date.now();
    if (now - ghostLastMsRef.current < 60) return;      // 节流，避免拖动时疯狂重绘
    ghostLastMsRef.current = now;
    // 相对鼠标位移：拖动点始终从复制点（轨迹终点）接出去
    const pl = d.baseLat + (lat - d.startLat);
    const pg = d.baseLng + (lng - d.startLng);
    const speed = Math.max(1.5, Number(speedRef.current) || 2.5);
    const step = speed * 1.0;                           // 一秒步长（米）一个路径点
    const cos = Math.cos(pl * Math.PI / 180);
    setGhostPath((prev) => {
      const last = prev.length ? prev[prev.length - 1] : [d.baseLat, d.baseLng];
      const dLat = pl - last[0];
      const dLng = pg - last[1];
      const distM = Math.hypot(dLat * 111320, dLng * 111320 * cos);
      if (distM < step) return prev;
      const n = Math.floor(distM / step);
      const out = [...prev];
      for (let i = 1; i <= n; i += 1) {
        const k = (i * step) / distM;
        out.push([last[0] + dLat * k, last[1] + dLng * k]);
      }
      return out;
    });
  }, []);

  const onGhostEnd = useCallback(() => { ghostDragRef.current.active = false; }, []);

  /* 沿计划路径点运动：朝下一个点走，指向该点的矢量反向（内积 < 0）就标记已过并前进 */
  useEffect(() => {
    if (view !== 'run') return undefined;
    const timer = setInterval(() => {
      const path = ghostPathRef.current || [];
      const w = walkRef.current;
      if (!path.length || !w || !w.running || !w.state) return;
      const lat = Number(w.state.lat), lng = Number(w.state.lng);
      if (!Number.isFinite(lat) || !Number.isFinite(lng)) return;
      const cosLat = Math.cos(lat * Math.PI / 180);
      // 跳过「已经站在上面」或「已经越过（目标在前进方向后方，内积 < 0）」的路径点
      const dir = sentDirRef.current;
      let idx = ghostIdxRef.current;
      while (idx < path.length) {
        const east = (path[idx][1] - lng) * cosLat;
        const north = path[idx][0] - lat;
        const d = Math.hypot(east * 111320, north * 111320);
        if (d < 0.5) { idx += 1; continue; }             // 已在点上
        if (dir && east * dir[0] + north * dir[1] < 0) { idx += 1; continue; }  // 已越过
        break;
      }
      ghostIdxRef.current = idx;
      // 没有下一个路径点：停下等待（继续拖动/摇杆再动）
      if (ghostIdxRef.current >= path.length) {
        Bridge.call('walk_joystick', 0, 0, 0).catch(() => {});
        setPlanRemain(0);
        return;
      }
      const tgt = path[ghostIdxRef.current];
      const east = (tgt[1] - lng) * cosLat;
      const north = tgt[0] - lat;
      const len = Math.hypot(east, north);
      if (len < 1e-9) return;
      // 计划距离 = 已走 + 到目标的剩余 + 后续路径点间距
      let remain = len;
      for (let i = ghostIdxRef.current + 1; i < path.length; i += 1) {
        remain += Math.hypot((path[i][0] - path[i - 1][0]) * 111320,
                             (path[i][1] - path[i - 1][1]) * 111320 * cosLat);
      }
      setPlanRemain(remain);
      const mag = 0.85 + Math.random() * 0.15;         // 设定速度上叠加一点随机波动
      sentDirRef.current = [east / len, north / len];
      Bridge.call('walk_joystick', east / len, north / len, mag).catch(() => {});
    }, 250);
    return () => clearInterval(timer);
  }, [view]);

  /* 跑步状态轮询 */
  const startWalkPoll = useCallback(() => {
    if (walkTimerRef.current) return;
    walkTimerRef.current = setInterval(async () => {
      try {
        const r = await Bridge.call('walk_status', walkSinceRef.current);
        if (!r) return;
        setWalk(r);
        // 真实服务端的打卡点偶尔比开跑晚一点下发：targets 还空时定时补一次 status
        if (!(Array.isArray(r.targets) && r.targets.length)) {
          walkTickRef.current += 1;
          if (walkTickRef.current % 4 === 0) {
            try { const st = await Bridge.call('status'); if (st) setStatus(st); } catch (_) { /* 忽略 */ }
          }
        }
        if (Array.isArray(r.points) && r.points.length) {
          walkSinceRef.current = Number(r.total) || (walkSinceRef.current + r.points.length);
          setWalkPoints((prev) => [...prev, ...r.points]);
        }
        if (!r.running) {
          clearInterval(walkTimerRef.current);
          walkTimerRef.current = null;
          setView('home');
          refreshStatus();
          refreshRuns(1);
        }
      } catch (_) { /* 忽略 */ }
    }, 500);
  }, [refreshStatus, refreshRuns]);

  const stopWalkPoll = () => {
    if (walkTimerRef.current) {
      clearInterval(walkTimerRef.current);
      walkTimerRef.current = null;
    }
  };

  /* 登录 / 账号 */
  const login = async () => {
    setBusy(true);
    try {
      const want = params.mode || 'real';
      const cur = (statusRef.current && statusRef.current.mode) || 'real';
      if (want !== cur) { await Bridge.call('switch_mode', want); await refreshStatus(); }
      const r = await Bridge.call('login', phone, password, true);
      if (r && r.code === 0) {
        toast('登录成功', 'ok');
        await refreshStatus();
        await autoPrepare();        // 先把围栏拉下来，才能判断是否有多个
        const st0 = await refreshStatus();
        setView('pick');            // 登录后先进选起始点页，确认再回首页
        if (st0 && (st0.fences || []).length > 1) setFencePickOpen(true);
        refreshRuns(1);
      } else toast((r && r.message) || '登录失败', 'err');
    } finally { setBusy(false); }
  };

  /* 已保存的账号：弹窗里选一个，直接切换；token 失效就用保存的密码重登 */
  const loginSaved = async (uid) => {
    if (!uid) return;
    setBusy(true);
    try {
      let r = await Bridge.call('switch_account', uid);
      if (!(r && r.code === 0)) {
        r = await Bridge.call('relogin_account', uid);
        if (!(r && r.code === 0)) {
          toast((r && r.message) || '登录失败', 'err');
          return;
        }
        toast('历史登录已失效，已用保存的账号密码重新登录', 'ok');
      } else {
        toast('已切换账号', 'ok');
      }
      await refreshStatus();
      await autoPrepare();
      const st0 = await refreshStatus();
      setView('pick');            // 登录后先进选起始点页，确认再回首页
      if (st0 && (st0.fences || []).length > 1) setFencePickOpen(true);
      refreshRuns(1);
    } finally { setBusy(false); }
  };

  const removeSaved = async (uid) => {
    const r = await Bridge.call('forget_account', uid);
    if (r && r.code === 0) {
      toast('已移除该账号', 'ok');
      await refreshStatus();
    } else toast((r && r.message) || '移除失败', 'err');
  };

  const selectFence = async (index) => {
    setFencePickOpen(false);
    setParams((p) => ({ ...p, fence: index }));
    try { await Bridge.call('prepare', index); } catch (_) { /* 忽略 */ }
    await refreshStatus();
    toast('已选择围栏', 'ok');
  };

  const openSavedAccounts = () => {
    if (!accounts.length) { toast('本机还没有保存的账号', 'err'); return; }
    setSavedOpen(true);
  };

  const logout = async () => {
    await Bridge.call('logout');
    toast('已退出登录');
    setView('login');
    setDetail(null);
    await refreshStatus();
  };

  /* 参数 */
  const saveParams = async () => {
    const avg = Number(params.cadAvg) || 177;
    const v = Math.abs(Number(params.cadVar) || 0);
    const pace = parsePace(params.pace);
    const patch = {
      run: { target_distance_m: params.distance, stride_m: Number(params.stride) || 0.85 },
      sim: { min_cadence: Math.max(120, Math.round(avg - v)), max_cadence: Math.round(avg + v), realtime: false },
      walk: {
        speed_mps: pace ? paceToSpeed(pace) : 2.5,
        auto_settle: !!params.autoSettle,
      },
      mock_fail_rate: 0,
    };
    // patch_config 成功时返回的是整份配置（没有 code 字段），失败才是 {error}
    const r = await Bridge.call('patch_config', JSON.stringify(patch));
    if (r && r.error) toast('保存失败：' + r.error, 'err');
    else toast('参数已保存', 'ok');
    await refreshStatus();
  };

  const resetDevice = async () => {
    const r = await Bridge.call('reset_device');
    if (r && r.device_id) toast('新 deviceId：' + r.device_id, 'ok');
    else toast((r && r.error) || '换设备失败', 'err');
    await refreshStatus();
  };

  const openDataDir = async () => {
    const r = await Bridge.call('open_data_dir');
    if (r && r.code !== 0) toast((r && r.message) || '打开失败', 'err');
  };

  const reloadRule = async () => {
    const r = await Bridge.call('reload_rule');
    toast(r && r.code === 0 ? '学校规则已刷新' : ((r && r.message) || '刷新失败'), r && r.code === 0 ? 'ok' : 'err');
    await refreshStatus();
  };

  const setMode = async (v) => {
    setParams((p) => ({ ...p, mode: v }));
    const cur = (statusRef.current && statusRef.current.mode) || 'real';
    if (v !== cur) {
      await Bridge.call('switch_mode', v);
      await refreshStatus();
      toast(v === 'mock' ? '已切到本地 Mock' : '已切到真实服务端', 'ok');
    }
  };

  /* 跑步 */
  const startRun = async () => {
    setBusy(true);
    try {
      await saveParams();
      const speed = paceToSpeed(parsePace(params.pace));
      await Bridge.call('walk_route', '[]', !!params.auto, false);
      const r = await Bridge.call('walk_start', 'real', params.distance, params.fence, speed, !!params.auto, true, 1);
      if (!r || r.code !== 0) { toast((r && r.message) || '启动失败', 'err'); return; }
      setWalk(r.data || {});
      walkSinceRef.current = 0;
      setWalkPoints([]);
      setView('run');
      startWalkPoll();
    } finally { setBusy(false); }
  };

  const endRun = async () => {
    setBusy(true);
    try {
      const r = await Bridge.call('walk_stop');
      setWalk(r || null);
      stopWalkPoll();
      const up = await Bridge.call('walk_upload', true);
      toast((up && up.message) || '已提交上传结算', up && up.code === 0 ? 'ok' : 'err');
      setView('home');
      await refreshStatus();
      refreshRuns(1);
    } finally { setBusy(false); }
  };

  const dryRun = async () => {
    const r = await Bridge.call('walk_start', 'dry', params.distance, params.fence,
      paceToSpeed(parsePace(params.pace)), !!params.auto, true, 1);
    if (r && r.code === 0) {
      setWalk(r.data || {});
      walkSinceRef.current = 0;
      setWalkPoints([]);
      setView('run');
      startWalkPoll();
    } else toast((r && r.message) || '干跑启动失败', 'err');
  };

  const stopWalk = async () => {
    const r = await Bridge.call('walk_stop');
    setWalk(r || null);
    stopWalkPoll();
    setView('home');
    await refreshStatus();
  };

  const pauseWalk = async () => {
    const paused = !!(walk && walk.state && walk.state.paused);
    const r = await Bridge.call('walk_pause', !paused);
    if (r && r.code === 0) {
      toast(!paused ? '已暂停' : '已继续', 'ok');
      setWalk((w) => (w ? { ...w, state: { ...(w.state || {}), paused: !paused } } : w));
    } else toast((r && r.message) || '操作失败', 'err');
  };

  const uploadWalk = async () => {
    const r = await Bridge.call('walk_upload', true);
    toast((r && r.message) || '已上传结算', r && r.code === 0 ? 'ok' : 'err');
    await refreshStatus();
    refreshRuns(1);
  };

  const saveDraft = async () => {
    const r = await Bridge.call('walk_save', '');
    toast((r && r.message) || '草稿已保存', r && r.code === 0 ? 'ok' : 'err');
  };

  const runAuto = async () => {
    const r = await Bridge.call('run_auto', params.distance, params.fence, true, true, 1);
    toast((r && r.message) || '一键跑已启动', r && r.code === 0 ? 'ok' : 'err');
    if (r && r.code === 0) refreshStatus();
  };

  const resumeRun = async () => {
    const r = await Bridge.call('resume', '');
    toast((r && r.message) || '断点续传已启动', r && r.code === 0 ? 'ok' : 'err');
  };

  const toggleAuto = async () => {
    if (!walk || !walk.running) { toast('先开始跑步，再切换手动/自动', 'err'); return; }
    const on = !params.auto;
    const r = await Bridge.call('walk_auto', on);
    if (r && r.code === 0) {
      setParams((p) => ({ ...p, auto: on }));
      toast(on ? '已切到自动跑' : '已交回摇杆', 'ok');
    } else toast((r && r.message) || '切换失败', 'err');
  };

  /* 摇杆 */
  const joystick = (dx, dy, mag) => {
    // 用户推摇杆：清掉所有计划路径点，复制点回到人的位置
    if (ghostPathRef.current.length) {
      ghostPathRef.current = [];
      ghostIdxRef.current = 0;
      sentDirRef.current = null;
      setGhostPath([]);
      setPlanRemain(0);
    }
    Bridge.call('walk_joystick', dx, dy, mag).catch(() => {});
  };
  const joystickEnd = () => {
    Bridge.call('walk_joystick', 0, 0, 0).catch(() => {});
  };

  /* 选点 */
  const onMapClick = async (lat, lng) => {
    if (viewRef.current !== 'pick') return;
    const r = await Bridge.call('set_start_point', lat, lng);
    if (r && r.code === 0) {
      await refreshStatus();
      toast('起点已设置', 'ok');
    } else if (r && r.code !== 0) toast((r && r.message) || '设置失败', 'err');
  };

  const toPick = () => { setView('pick'); };
  const confirmPick = () => { setView('home'); };
  const clearStart = async () => {
    const r = await Bridge.call('set_start_point', null, null);
    if (r && r.code === 0) { await refreshStatus(); toast('已清除起点，回到围栏中心', 'ok'); }
    else toast((r && r.message) || '清除失败', 'err');
  };
  const fitHome = () => { setFitNonce((n) => n + 1); setView('home'); };

  /* 记录 */
  const pickRun = async (item) => {
    try {
      const d = await Bridge.call('server_record_detail', item.run_code, item.semester_code || '');
      if (d && d.ok) setDetail(d);
      else toast((d && d.error) || '取记录详情失败', 'err');
    } catch (e) { toast(String((e && e.message) || e), 'err'); }
  };

  /* 目标距离选项：规则单次区间内、从高到低每 1 km */
  const distanceOptions = useMemo(() => {
    const r = (status && status.rule) || {};
    const ruleReady = !!(status && String(status.rule_source || '').trim());
    const maxM = Number(r.singleMaxDistance) || 0;
    const minM = Number(r.singleMinDistance) || 0;
    const vals = [];
    if (ruleReady && maxM > 0 && minM > 0) {
      // 按学校规则的单次距离区间，从高到低每 1 km 一项（真实规则 2000–3000 → 3 km、2 km）
      const hi = Math.floor(maxM / 1000);
      const lo = Math.ceil(minM / 1000);
      for (let km = hi; km >= lo; km -= 1) vals.push(km * 1000);
    }
    if (params.distance && !vals.includes(params.distance)) {
      vals.push(params.distance);
      vals.sort((a, b) => b - a);
    }
    return vals.map((v) => ({ value: v, label: `${v / 1000} km` }));
  }, [status, params.distance]);

  const ruleRows = useMemo(() => {
    const r = (status && status.rule) || {};
    const fence = (status && (status.fence || (status.fences || [])[0])) || {};
    const pointCount = Number(fence.requiredPointCounts ?? r.requiredPointCounts ?? 0);
    const rows = [];
    if (r.singleMinDistance || r.singleMaxDistance) {
      rows.push(['单次距离', `${fmtKm(r.singleMinDistance || 0)} – ${fmtKm(r.singleMaxDistance || 0)} km`]);
    }
    if (r.minPace || r.maxPace) {
      rows.push(['配速区间', `${fmtPaceShort(r.minPace || 0)} – ${fmtPaceShort(r.maxPace || 0)}`]);
    }
    if (r.strideBase) rows.push(['步幅基准', `${r.strideBase} 厘米`]);
    const livePoints = (status && status.checkpoints ? status.checkpoints.length : 0);
    const shownPoints = livePoints || (serverPoints != null ? serverPoints : pointCount);
    const pointNote = livePoints ? '本次' : (serverPoints != null ? '最近一次记录' : '围栏');
    if (shownPoints) rows.push(['打卡点', `${shownPoints} 个（${pointNote}）`]);
    if (r.dayMaxDistance) rows.push(['每日上限', `${fmtKm(r.dayMaxDistance)} km`]);
    if (status && status.rule_loaded_at) rows.push(['更新于', fmtDateTime(status.rule_loaded_at)]);
    return rows;
  }, [status, serverPoints]);

  const userRows = useMemo(() => {
    const u = (status && status.user) || {};
    return [
      ['姓名', u.userName || '--'],
      ['学校', u.schoolName || '--'],
      ['学号', u.studentNo || '--'],
      ['设备', String((status && status.device_id) || '--').slice(0, 12)],
      ['版本', `v${(status && status.version) || '--'}`],
    ];
  }, [status]);

  const runRows = useMemo(() => {
    if (detail && detail.record) {
      const r = detail.record;
      return [
        ['记录码', r.run_code || '--'],
        ['距离', r.distance_m ? `${Number(r.distance_m).toFixed(0)} 米` : '--'],
        ['有效距离', r.valid_distance_m ? `${Number(r.valid_distance_m).toFixed(0)} 米` : '--'],
        ['时长', r.duration_s ? fmtDur(r.duration_s) : '--'],
        ['配速', r.pace_s_per_km ? `${fmtPaceShort(r.pace_s_per_km)}/公里` : '--'],
        ['步数', r.total_step || '--'],
        ['开始', r.start_ms ? fmtDateTime(r.start_ms) : '--'],
        ['状态', r.state || '--'],
      ];
    }
    const last = status && status.last;
    if (last && (last.valid || last.distance_m)) {
      const v = last.valid || last;
      return [
        ['记录码', last.run_code || '--'],
        ['距离', v.distance_m ? `${Number(v.distance_m).toFixed(0)} 米` : '--'],
        ['有效距离', v.valid_distance_m ? `${Number(v.valid_distance_m).toFixed(0)} 米` : '--'],
        ['时长', v.duration_s ? fmtDur(v.duration_s) : '--'],
        ['配速', v.pace_s_per_km ? `${fmtPaceShort(v.pace_s_per_km)}/公里` : '--'],
        ['步数', v.total_step || '--'],
      ];
    }
    return [];
  }, [detail, status]);

  // 跑步时打卡点以实时快照为准（walk_status.targets），开跑后才有
  const mapCheckpoints = (walk && Array.isArray(walk.targets) && walk.targets.length)
    ? walk.targets
    : ((status && status.checkpoints) || (status && status.preview_points) || []);

  const mapProps = {
    status,
    walkPoints,
    checkpoints: mapCheckpoints,
    ghostPath,
    ghostEnabled: view === 'run' && !!(walk && walk.running),
    onGhostStart,
    onGhostMove,
    onGhostEnd,
    tiles: params.tiles,
    onTiles: (v) => setParams((p) => ({ ...p, tiles: v })),

    fitKey: `${(status && status.fence_code) || ''}|${(status && status.fences && status.fences.length) || 0}|${(status && status.start_point && status.start_point.lat) || ''}|${fitNonce}`,
    onClick: view === 'pick' ? onMapClick : undefined,
  };

  const actions = {
    setPhone, setPassword, login, logout,
    setDistance: (v) => setParams((p) => ({ ...p, distance: v })),
    setParam: (k, v) => setParams((p) => ({ ...p, [k]: v })),
    setMode, setFence: (v) => setParams((p) => ({ ...p, fence: v })), setTiles: (v) => setParams((p) => ({ ...p, tiles: v })),
    saveParams, resetDevice, openDataDir, reloadRule,
    startRun, endRun, dryRun, stopWalk, pauseWalk, uploadWalk, saveDraft,
    runAuto, resumeRun, toggleAuto,
    joystick, joystickEnd,
    toPick, confirmPick, clearStart, fitHome,
    loadRuns: refreshRuns, pickRun,
    clearLog: () => setLog([]),
    toMore: () => setView('more'),
    refreshUser: async () => {
      try {
        const r = await Bridge.call('refresh_user');
        if (r && r.code === 0 && r.data) {
          setStatus((prev) => (prev ? { ...prev, user: { ...(prev.user || {}), ...r.data } } : prev));
        }
      } catch (_) { /* 忽略 */ }
    },
    openSavedAccounts,
    loginSaved,
    removeSaved,
    selectFence,
    openAccount: () => { refreshRuns(1); setView('account'); },
    back: () => setView(walk && walk.running ? 'run' : 'home'),
  };

  return (
    <div className="app-root">
      <Modal
        title="已保存的账号"
        open={savedOpen}
        onCancel={() => setSavedOpen(false)}
        footer={null}
        destroyOnClose
      >
        {accounts.length ? (
          <div className="saved-list">
            {accounts.map((a) => (
              <div key={a.userId} className="saved-item">
                <button
                  type="button"
                  className="saved-main"
                  onClick={() => { setSavedOpen(false); loginSaved(a.userId); }}
                >
                  <span className="saved-name">{a._account_name || a.loginName || a.userId}</span>
                  {a.current ? <span className="saved-current">当前</span> : null}
                </button>
                <button type="button" className="saved-del" onClick={() => removeSaved(a.userId)}>移除</button>
              </div>
            ))}
          </div>
        ) : (
          <div className="saved-empty">本机还没有保存的账号</div>
        )}
      </Modal>

      <Modal
        title="选择围栏"
        open={fencePickOpen}
        closable={false}
        footer={null}
      >
        <div className="fence-list">
          {((status && status.fences) || []).map((f, i) => (
            <button key={i} type="button" className="fence-item" onClick={() => selectFence(i)}>
              <span>{f.fenceName || f.fenceCode || `围栏 ${i + 1}`}</span>
            </button>
          ))}
        </div>
      </Modal>

      {view === 'login' && (
        <LoginPage
          phone={phone}
          password={password}
          busy={busy}
          actions={actions}
        />
      )}
      {view === 'home' && (
        <HomePage
          mapProps={mapProps}
          params={params}
          distanceOptions={distanceOptions}
          busy={busy}
          actions={actions}
        />
      )}
      {view === 'pick' && <PickPage mapProps={mapProps} actions={actions} />}
      {view === 'run' && (
        <RunPage mapProps={mapProps} walk={walk} planDistance={(Number(walk && walk.state && walk.state.dist_m) || 0) + planRemain} actions={actions} />
      )}
      {view === 'account' && (
        <AccountPage status={status} runs={runs} actions={actions} />
      )}
      {view === 'more' && (
        <MorePage
          status={status}
          params={params}
          distanceOptions={distanceOptions}
          ruleRows={ruleRows}
          userRows={userRows}
          runRows={runRows}
          runCode={(detail && detail.record && detail.record.run_code) || (status && status.last && status.last.run_code) || ''}
          log={log}
          runs={runs}
          detail={detail}
          busy={busy}
          actions={actions}
        />
      )}
    </div>
  );
}
