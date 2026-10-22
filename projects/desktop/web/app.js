/* ══════════════════════════════════════════════════════════════
   闪动校园 · 阳光跑工作台 —— 前端逻辑
   后端桥：pywebview 桌面壳（window.pywebview.api）或 HTTP 降级（POST /api）
   ══════════════════════════════════════════════════════════════ */
'use strict';

// ── 全局错误可见化（界面里直接能看到哪里炸了，不用开 devtools）────
window.addEventListener('unhandledrejection', (e) => {
  const msg = (e.reason && (e.reason.message || e.reason)) || '未知错误';
  console.error('[shandong-school_cracked] 未处理的 Promise 异常：', e.reason);
  try { toast('内部错误：' + msg, 'err'); } catch (_) { /* 界面还没建好 */ }
});
window.addEventListener('error', (e) => {
  console.error('[shandong-school_cracked] JS 错误：', e.message);
  try { toast('脚本错误：' + e.message, 'err'); } catch (_) { /* 同上 */ }
});

// ── 桥接层 ────────────────────────────────────────────────
const Bridge = {
  ready: false,
  mode: '未知',            // desktop / http

  // pywebview 注入 window.pywebview 的时机不确定：早期它可能已经存在，
  // 但 api 代理还没接好（这时调用会静默返回 undefined）——更新一下：
  // 必须用一次真实的 ping 调用来确认真的通了。
  async waitReady(timeoutMs = 15000) {
    if (this.ready) return true;
    const t0 = Date.now();
    while (Date.now() - t0 < timeoutMs) {
      if (window.pywebview && window.pywebview.api && typeof window.pywebview.api.ping === 'function') {
        try {
          const r = await window.pywebview.api.ping();
          if (r && r.ok) { this.ready = true; this.mode = 'desktop'; return true; }
        } catch (_) { /* 代理还没接好，继续等 */ }
      }
      await new Promise((r) => setTimeout(r, 120));
    }
    if (location.protocol.startsWith('http')) {   // 降级：本地 HTTP 桥
      this.ready = true; this.mode = 'http'; return true;
    }
    return false;
  },



  async call(method, ...args) {
    if (!this.ready) await this.waitReady();
    if (window.pywebview && window.pywebview.api && typeof window.pywebview.api[method] === 'function') {
      const out = await window.pywebview.api[method](...args);
      if (out !== undefined) return out;
      // 代理尚未就绪时会得到 undefined：等一次握手再重试
      this.ready = false;
      if (await this.waitReady(5000)) return await window.pywebview.api[method](...args);
    }
    if (!location.protocol.startsWith('http')) {
      throw new Error('桌面桥未就绪（window.pywebview 不存在，且非 HTTP 模式）');
    }

    const r = await fetch('/api', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ method, args }),
    });
    return await r.json();
  },
};

// ── 全局状态 ──────────────────────────────────────────────
const S = {
  seq: 0,
  status: null,
  currentRun: '',
  detail: null,
  showState: true,
  fit: true,
  logCount: 0,
  tiles: 'amap',
  // ── 手动实走（摇杆）──
  walk: null,            // 最近一次 walk_status 快照
  walkSince: 0,          // 已拉取到的轨迹点数（增量拉取用）
  livePoints: [],        // 本次实走已经推出来的轨迹点
  route: [],             // 规划路线 [[lat,lng], …]
  waypoints: [],         // 手动点选的路点
  pickMode: false,       // 地图点击添加路点
  pickStart: false,      // 地图点击设置跑步起点（与 pickMode 互斥）
  startPoint: null,      // 跑步起点 {lat,lng}；null = 没选过，一律按围栏中心
  previewPoints: [],     // 高级里「只规划路径」按围栏预估的预览点（开跑前地图上不画打卡点）
  autoRun: false,        // 自动跑：沿规划路线自动走；false = 手动（右下角摇杆控制），默认手动
  paused: false,         // 手动实走是否已暂停（后端 walker.paused 的镜像，只用于按钮文案）
  walkMsg: '',           // 主流程状态行上的临时文案（跑步中/刚规划完），空则按登录与围栏状态推导
  progress: {},          // 轮询里的实时进度（不是 S.status.progress 那个快照）
  walkTimer: null,
  joyKey: null,          // 方向键当前方向
  // 服务器记录分页（数据源：run/pageSunRunRecord）
  runsPage: 1,
  runsHasNext: false,
  pickedRecord: null,    // 用户点选/自动选中的服务端记录（非空时左卡不被“最近一次”覆盖）
};
const $ = (id) => document.getElementById(id);

// ══════════════════ 日志与提示 ══════════════════
function appendEvents(events) {
  const box = $('log');
  if (!events || !events.length) return;
  const frag = document.createDocumentFragment();
  for (const ev of events) {
    const div = document.createElement('div');
    const kind = String(ev.kind || 'log');
    const level = String(ev.level || 'info');
    div.className = `line k-${kind} lv-${level}`;
    // bus 事件里的 time 是 "HH:MM:SS" 字符串，new Date() 得不到有效日期（会渲染成 NaN）；
    // 真正的时间基准是 ts（毫秒）
    const t = new Date(Number(ev.ts) || Date.now());
    const hh = String(t.getHours()).padStart(2, '0');
    const mm = String(t.getMinutes()).padStart(2, '0');
    const ss = String(t.getSeconds()).padStart(2, '0');
    const ms = String(t.getMilliseconds()).padStart(3, '0');
    div.innerHTML = `<span class="t">${hh}:${mm}:${ss}.${ms}</span>` +
      `<span class="m"></span>`;
    div.querySelector('.m').textContent = ev.message || '';
    frag.appendChild(div);
    S.logCount++;
  }
  box.appendChild(frag);
  while (box.childElementCount > 800) box.removeChild(box.firstChild);
  if ($('in-autoscroll').checked) box.scrollTop = box.scrollHeight;
}

function toast(msg, kind = '') {
  const el = document.createElement('div');
  el.className = `toast ${kind}`;
  el.textContent = msg;
  $('toast-wrap').appendChild(el);
  setTimeout(() => el.remove(), 4200);
}

// ══════════════════ 渲染：状态 ══════════════════
function kv(obj) {
  return Object.entries(obj).map(([k, v]) =>
    `<span class="k">${k}</span><span class="v ${v && v.cls ? v.cls : ''}">${v && v.html !== undefined ? v.html : (v === null || v === undefined ? '--' : v)}</span>`
  ).join('');
}
function esc(s) {
  return String(s === null || s === undefined ? '' : s)
    .replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
}

function renderStatus(st) {
  S.status = st;
  const mode = st.mode === 'mock' ? '本地 Mock（离线调试）' : '真实服务端';
  $('pill-mode').textContent = `模式：${mode}`;
  $('pill-mode').className = 'pill ' + (st.mode === 'mock' ? 'on' : 'warn');
  const modeSel = $('in-login-mode');
  // 永远跟后端对齐：下拉框的值只有 renderStatus 说了算，
  // 不然 HTML 里的初值（real）会被当成用户选择，一点登录就把 Mock 会话切成真实模式。
  if (modeSel && modeSel.value !== st.mode) modeSel.value = st.mode || 'real';
  syncLoginHint(st.mode);
  $('pill-login').textContent = st.logged_in ? '已登录' : '未登录';
  $('pill-login').className = 'pill ' + (st.logged_in ? 'on' : '');
  $('pill-device').textContent = '设备：' + String(st.device_id || '--').slice(0, 12);
  $('pill-version').textContent = 'v' + (st.version || '--');

  // 用户信息
  const u = st.user || {};
  $('user-info').innerHTML = st.logged_in ? kv({
    '姓名': u.userName || '--',
    '学校': u.schoolName || '--',
    '学号': u.userId || '--',
    '上次登录': u.loginAt ? new Date(Number(u.loginAt)).toLocaleString('zh-CN') : '--',
    'token': { html: esc(String(u.token || '').slice(0, 18)) + '…', cls: 'mono' },
  }) : `<span class="v">未登录${st.mode === 'mock' ? '（本地 Mock 模式任意手机号可登录）' : ''}</span>`;

  // 历史账号：能选一个以前登过的账号直接开工，不用重新输密码
  const accounts = st.accounts || [];
  const accSel = $('in-account');
  const keepUid = accSel.value || (accounts.find(a => a.current) || {}).userId || '';
  accSel.innerHTML = accounts.length
    ? accounts.map(a => `<option value="${a.userId}">${esc(a.userName || a.loginName || a.userId)}`
        + `${a.schoolName ? ' · ' + esc(a.schoolName) : ''}${a.current ? '（当前）' : ''}</option>`).join('')
    : '<option value="">（本机登录过的账号会出现在这里）</option>';
  if (keepUid && accounts.some(a => a.userId === keepUid)) accSel.value = keepUid;
  const hasAcc = !!accSel.value && accounts.length > 0;
  $('btn-account-use').disabled = !hasAcc;
  $('btn-account-del').disabled = !hasAcc;

  // 规则
  const r = st.rule || {};
  $('rule-info').innerHTML = r.singleMinDistance !== undefined ? kv({
    '单次距离': `${r.singleMinDistance} – ${r.singleMaxDistance} 米`,
    '配速区间': `${Math.round(r.minPace)} – ${Math.round(r.maxPace)} 秒/公里`,
    '步幅基准': `${r.segmentStrideAvg} 米（异常段上限 ${r.segmentStrideExceptionNum}）`,
    '必经点': `${r.requiredPointCounts} 个`,
  }) : '尚未加载';

  // 围栏下拉
  const sel = $('in-fence');
  const fences = st.fences || [];
  if (fences.length && sel.options.length !== fences.length) {
    sel.innerHTML = fences.map((f, i) =>
      `<option value="${i}">${esc(f.fenceName || f.fenceCode || ('围栏 ' + (i + 1)))}</option>`).join('');
    sel.value = String(st.fence_index || 0);
  }

  // 跑步起点：后端说了算（存在本地库里），前端只回显
  S.startPoint = st.start_point || null;
  syncStartUi();

  // 参数回填（仅首次）
  if (!S.paramsLoaded) {
    const rc = st.run_cfg || {}, sc = st.sim_cfg || {}, wc = st.walk_cfg || {};
    if (rc.target_distance_m) $('in-distance').value = rc.target_distance_m;
    if (rc.stride_m) $('in-stride').value = rc.stride_m;
    if (sc.min_cadence) $('in-cad-lo').value = sc.min_cadence;
    if (sc.max_cadence) $('in-cad-hi').value = sc.max_cadence;
    $('in-realtime').checked = !!sc.realtime;
    if (sc.speed) $('in-speed').value = sc.speed;
    // 摇杆速度（m/s）：从 walk 段回填，否则界面上的值只是默认值、与后端不一致
    if (wc.speed_mps && $('in-walk-speed')) $('in-walk-speed').value = wc.speed_mps;
    // 到达目标自动结算（后端 walk.auto_settle，默认开）
    if ($('in-auto-settle')) $('in-auto-settle').checked = (wc.auto_settle !== false);
    S.paramsLoaded = true;
  }

  renderProgress(st.progress || {});
  // 只有用户没在查看某条服务器记录时，才用「最近一次跑步」刷新左卡
  if (st.last && st.last.run_code && st.last.run_code !== S.currentRun && !S.pickedRecord) {
    S.currentRun = st.last.run_code;
    renderRunInfo(st.last);
  }
  // ★ 每次状态回来后重画叠加层：电子围栏是「拉取配置」的产品结果，
  //   不在这里重画的话，围栏要等到下一次别的 drawMap 触发（规划/摇杆/详情）才出现，
  //   镜头也就不会在拿到围栏的当下就飞过去。
  //   重绘本身有围栏指纹 + 用户手动的双重护栏，不会每秒抢镜头。
  drawMap();
}

function renderProgress(p) {
  // 轮询拿到的实时进度存一份：S.status.progress 只是 refreshStatus 时的快照，
  // 跑步中真正在变的是这里（700ms 一次），排查与自检都应该看这个。
  S.progress = Object.assign({}, p || {});
  const pct = Math.max(0, Math.min(100, Number(p.percent || 0)));
  $('progress-fill').style.width = pct + '%';
  $('progress-text').textContent = `${pct}% · ${p.message || '就绪'}`
    + (p.running ? '（运行中）' : '');
  const busy = !!p.running;
  $('btn-run').disabled = busy;
  $('btn-prepare').disabled = busy;
  $('btn-resume').disabled = busy;
  syncFlowInfo();          // 主流程状态行也跟着走（上传结算期间显示“进行中 xx%”）
}

function fmtDur(sec) {
  const s = Math.max(0, Math.round(Number(sec) || 0));
  const mm = Math.floor(s / 60);
  return `${mm}分${String(s % 60).padStart(2, '0')}秒`;
}

// 配速 = 每公里多少秒；实跑时是实时算出来的带小数秒，直接取整再格式化
function fmtPace(secPerKm) {
  const v = Number(secPerKm) || 0;
  if (!v) return '--';
  const s = Math.round(v);
  return `${Math.floor(s / 60)}'${String(s % 60).padStart(2, '0')}"/公里`;
}

function renderRunInfo(last) {
  const v = last.valid || {};
  $('run-code-label').textContent = last.run_code || '--';
  $('run-info').innerHTML = kv({
    '距离': `${(last.distance_m || 0).toFixed(1)} 米`,
    '时长': fmtDur(last.duration_s),
    '配速': fmtPace(last.pace_s_per_km),
    '总步数': last.total_step || 0,
    '步幅': `${Number(last.stride_m || 0).toFixed(3)} 米`,
    '打卡点': `${last.checkpoints_done || 0}/${last.checkpoints_total || 0}`,
    '有效性': {
      html: v.isValid ? '✓ 有效' : '✗ ' + (v.reasons || []).map(x => x.name).join('、'),
      cls: v.isValid ? 'ok' : 'err',
    },
    '计时': fmtDur(last.elapsed_s || last.total_elapsed_s || 0),
  });
  drawMap();
}

// 点击服务器记录：把这条记录的信息显示到「本次跑步」卡
// 字段只取服务端 SportRecord 有的东西（本地实跑的步幅/打卡点/计时这里没有）
function renderServerRecord(rec) {
  if (!rec) return;
  $('run-code-label').textContent = rec.run_code || '--';
  $('run-info').innerHTML = kv({
    '距离': `${Number(rec.distance_m || 0).toFixed(1)} 米`,
    '有效距离': `${Number(rec.valid_distance_m || 0).toFixed(1)} 米`,
    '时长': fmtDur(rec.duration_s),
    '配速': rec.pace_s_per_km ? fmtPace(rec.pace_s_per_km) : '--',
    '总步数': rec.total_step || 0,
    '开始': fmtDateTime(rec.start_ms),
    '状态': { html: rec.state || '--', cls: rec.state_kind || '' },
  });
}

// ══════════════════ 记录列表 ══════════════════
// 数据源是服务端的 run/pageSunRunRecord：只读，不读本地库。
// 本地库仍由引擎 / 续传使用，但界面不再展示（记录以服务器为准）。
async function refreshRuns(autoOpen = false, page = null) {
  const box = $('runs');
  if (page != null) S.runsPage = Math.max(1, Number(page) || 1);
  box.innerHTML = '<div class="hint">正在从服务器加载…</div>';
  let r = null;
  try {
    r = await Bridge.call('server_records', S.runsPage, 20);
  } catch (e) {
    box.innerHTML = `<div class="hint">拉取失败：${esc((e && e.message) || e)}</div>`;
    return;
  }
  if (!r || !r.ok) {
    box.innerHTML = `<div class="hint">${esc((r && r.error) || '拉取失败')}</div>`;
    syncRunsPager(r);
    return;
  }
  const runs = r.items || [];
  S.runsHasNext = !!r.has_next;
  if (!runs.length) {
    box.innerHTML = `<div class="hint">${S.runsPage > 1 ? '这一页没有记录了'
      : '服务器上暂无记录：先登录，再完成一次跑步'}</div>`;
    syncRunsPager(r);
    return;
  }
  // 刚跑完一次时自动展开最新一条（此时详情是服务端数据，不驱动地图）
  if (autoOpen && !S.currentRun && runs[0]) S.currentRun = runs[0].run_code;
  box.innerHTML = runs.map((x) => {
    const d = x.distance_m ? `${Number(x.distance_m).toFixed(0)} 米` : '--';
    const t = x.duration_s ? `${Math.round(x.duration_s / 60)} 分` : '--';
    const when = x.start_ms ? fmtDateTime(x.start_ms) : '';
    return `<div class="run-item" data-code="${esc(x.run_code)}" data-semester="${esc(x.semester_code || '')}">
      <div class="rc">${esc(x.run_code)}</div>
      <div class="meta"><span>${d}</span><span>${t}</span>${when ? `<span>${when}</span>` : ''}
      <span class="badge ${esc(x.state_kind || '')}">${esc(x.state || '')}</span></div></div>`;
  }).join('');
  box.querySelectorAll('.run-item').forEach((el, i) => {
    el.addEventListener('click', () => {
      box.querySelectorAll('.run-item').forEach(x => x.classList.remove('active'));
      el.classList.add('active');
      const x = runs[i];
      if (!x) return;
      S.pickedRecord = x.run_code;
      renderServerRecord(x);
    });
  });
  syncRunsPager(r);
  if (autoOpen) {
    const first = runs[0];
    if (first) {
      S.pickedRecord = first.run_code;
      box.querySelector('.run-item')?.classList.add('active');
      renderServerRecord(first);
    }
  }
}

// 分页状态：上一页/下一页按钮与页码文案
function syncRunsPager(r) {
  $('runs-page').textContent = `第 ${S.runsPage} 页`;
  $('btn-runs-prev').disabled = S.runsPage <= 1;
  $('btn-runs-next').disabled = !(r && r.has_next);
}

// 记录时间（服务端给毫秒时间戳，本地时区展示）
function fmtDateTime(ms) {
  const t = Number(ms) || 0;
  if (!t) return '--';
  const d = new Date(t), p = (n) => String(n).padStart(2, '0');
  return `${d.getMonth() + 1}/${d.getDate()} ${p(d.getHours())}:${p(d.getMinutes())}`;
}

// 两点球面距离（米）——与后端 protocol.haversine 同一公式，用于跑步中实时累计距离。
function haversine(lat1, lng1, lat2, lng2) {
  const R = 6371008.8, rad = Math.PI / 180;
  const dLat = (lat2 - lat1) * rad, dLng = (lng2 - lng1) * rad;
  const a = Math.sin(dLat / 2) ** 2
    + Math.cos(lat1 * rad) * Math.cos(lat2 * rad) * Math.sin(dLng / 2) ** 2;
  return 2 * R * Math.asin(Math.min(1, Math.sqrt(a)));
}

// 跑步进行中只刷地图，不动详情面板（详情面板重绘会打断用户点击）。
async function refreshLiveMap(code) {
  const d = await Bridge.call('run_detail', code);
  if (!d || !d.run) return;
  S.detail = d;
  S.currentRun = code;
  // 跑步中“本次跑步”面板也实时跟：距离/步数/已落盘点数都从本地库里现算。
  const run = d.run, pts = d.points || [];
  let dist = 0;
  for (let i = 1; i < pts.length; i++) {
    dist += haversine(pts[i - 1].lat, pts[i - 1].lng, pts[i].lat, pts[i].lng);
  }
  renderRunInfo({
    run_code: code,
    distance_m: dist || run.distance_m || 0,
    duration_s: run.duration_s || 0,
    total_step: run.total_step || 0,
    valid: run.valid || {},
  });
  drawMap();
}



// ══════════════════ 地图（Leaflet 真实底图 + 矢量叠加） ══════════════════
// 坐标系：原 APP 用百度定位 SDK，并在 com.huachenjie.base.util.ThirdUtil 里显式
// `SDKInitializer.setCoordType(CoordType.GCJ02)`，所以记下来的经纬度是 GCJ-02。
// 高德瓦片同样是 GCJ-02 → 直接叠加即对齐。换成 OSM（WGS-84）会有几百米偏移，
// 调试时以矢量叠加层为准（底图只是参考）。
const TILES = {
  amap: {
    url: 'https://webrd0{s}.is.autonavi.com/appmaptile?lang=zh_cn&size=1&scale=1&style=8&x={x}&y={y}&z={z}',
    label: '高德路网',
    subdomains: '1234', maxZoom: 18, attribution: '&copy; 高德地图',
  },
  'amap-sat': {
    url: 'https://webst0{s}.is.autonavi.com/appmaptile?style=6&x={x}&y={y}&z={z}',
    subdomains: '1234', maxZoom: 18, attribution: '&copy; 高德地图（卫星）',
    label: '高德卫星',
  },
  osm: {
    url: 'https://{s}.tile.openstreetmap.de/{z}/{x}/{y}.png',
    subdomains: 'abc', maxZoom: 19, attribution: '&copy; OpenStreetMap contributors',
    label: 'OSM（WGS-84，与记录有偏移）',
  },
  none: null,          // 无底图：只看矢量叠加（离线时也能用）
};
// Mock 围栏中心（济南附近）：一点数据都没有时先把地图落在这里，免得一片黑
const MAP_HOME = [36.6615, 117.0265];

const MAP = { obj: null, tile: null, layers: {}, bounds: null, fitKey: '', tileError: false, blank: false,
              userMoved: false, runId: '' };

function tileSetting() {
  try { return localStorage.getItem('shandong_school_cracked.tiles') || 'amap'; } catch (e) { return 'amap'; }
}

// 幂等建图：容器尺寸由卡片决定，瓦片负责“真实地图”，轨迹/围栏/打卡点都是叠加层
function ensureMap() {
  if (MAP.obj) return MAP.obj;
  const el = $('map');
  if (!window.L) {
    el.innerHTML = '<div class="map-fallback">Leaflet 资源没加载成功（web/vendor/leaflet/），'
      + '底图和矢量都画不了。确认文件随仓库一起拉下来了。</div>';
    return null;
  }
  const m = L.map(el, {
    center: MAP_HOME, zoom: 16,
    zoomControl: true, attributionControl: true, preferCanvas: true,
  });
  for (const k of ['fence', 'route', 'wpt', 'track', 'cps', 'start']) MAP.layers[k] = L.layerGroup().addTo(m);
  m.on('tileerror', () => {
    if (MAP.tileError) return;
    MAP.tileError = true;
    toast('底图瓦片加载失败（网络不可达或瓦片源不可用），矢量轨迹不受影响', 'err');
  });
  // 用户自己拖了/缩了地图之后，实时重绘不再抢镜头（下一次跑步开始时自动恢复）
  m.on('dragstart zoomstart', () => { MAP.userMoved = true; });
  // 地图点击：“设起点”与“点选路点”两种模式互斥，都没开就什么都不做
  m.on('click', (e) => {
    if (S.pickStart) {
      setStartPoint(e.latlng.lat, e.latlng.lng);
      return;
    }
    if (!S.pickMode) return;
    S.waypoints.push([e.latlng.lat, e.latlng.lng]);
    drawMap();
    toast(`已加第 ${S.waypoints.length} 个路点（点“完成点选”结束）`, 'ok');
  });
  MAP.obj = m;
  setTiles(m);
  // 卡片一变尺寸就要告诉 Leaflet，否则瓦片会错位、四周留白
  if (window.ResizeObserver) {
    new ResizeObserver(() => m.invalidateSize()).observe(el.parentElement);
  }
  return m;
}

function setTiles(m) {
  m = m || MAP.obj;
  if (!m) return;
  if (MAP.tile) { m.removeLayer(MAP.tile); MAP.tile = null; }
  const conf = TILES[S.tiles];
  const hint = document.getElementById('map-hint');
  if (!conf) {
    if (hint) hint.textContent = '无底图 · 仅矢量叠加';
    return;                    // “无底图”：只留矢量叠加
  }
  MAP.tileError = false;
  MAP.tile = L.tileLayer(conf.url, {
    subdomains: conf.subdomains, maxZoom: conf.maxZoom, attribution: conf.attribution,
  }).addTo(m);
  if (hint) hint.textContent = conf.label + ' · GCJ-02';
}

// 重画叠加层；forceFit=true 或内容变化时才移动镜头（否则会抢用户的拖动）
function drawMap(forceFit) {
  const m = ensureMap();
  if (!m) return;
  // 切换记录时重置“用户已手动移动”标记，否则新记录不会自动定位
  const rid = (S.detail && S.detail.run && S.detail.run.run_code) || S.currentRun || '';
  if (rid !== MAP.runId) { MAP.runId = rid; MAP.userMoved = false; }
  const st = S.status || {};
  const fence = st.fence_polygon || [];
  // ★ 电子围栏一到手就把镜头挪到围栏上：指纹只跟“哪块围栏”有关，与 MAP.userMoved 无关——
  //   用户拖过地图也不该阻止这一次自动定位；登录/刷新/换围栏拿到新围栏才触发，
  //   之后每秒的实时重绘不会再抢镜头。
  const fencePts = (fence || []).map(([la, ln]) => [Number(la), Number(ln)])
    .filter(([la, ln]) => isFinite(la) && isFinite(ln));
  const fi = st.fence || {};
  const fenceKey = fencePts.length
    ? String(fi.fenceCode || fi.fenceName || '') + '@' + L.latLngBounds(fencePts).toBBoxString()
    : '';
  let fitFence = null;
  if (fenceKey && fenceKey !== MAP.fenceKey) {
    MAP.fenceKey = fenceKey;
    fitFence = L.latLngBounds(fencePts);
    MAP.userMoved = false;      // 换围栏等于换场景，重新允许自动跟随
  }
  const pts = (S.detail && S.detail.points) || [];
  // 打卡点优先用实时快照：实跑时 walk_status.targets 会立刻翻转 passed，
  // 而 S.detail 要等下一次 run_detail 回来才刷新，否则地图上绿点要晚好几秒
  const liveCp = (S.walk && S.walk.targets) || [];
  // 打卡点只来自「开跑下发」：实走实时快照（S.walk.targets）或历史记录详情。
  // 开跑前 status.checkpoints 是空的（服务端要到 startSunRun_v2 才给 targetPoints），
  // S.previewPoints 只在高级里点过「只规划路径」后才有——那是按围栏预估的预览点。
  const runCp = (S.walk && S.walk.run_code) ? (st.checkpoints || []) : [];
  const cps = liveCp.length
    ? liveCp
    : ((S.detail && S.detail.checkpoints) || runCp || (S.previewPoints || []));

  for (const k of Object.keys(MAP.layers)) MAP.layers[k].clearLayers();
  MAP.bounds = null;

  // P() 负责“转成坐标 + 顺手收集包围盒”，后面的图层全部靠它；
  // 必须先定义——下面的路线块比围栏块先画，而它是 const。
  const corners = [];
  const P = (la, ln) => {
    const a = Number(la), b = Number(ln);
    if (isFinite(a) && isFinite(b)) corners.push([a, b]);
    return [a, b];
  };
  // 规划路线与手动路点优先画：它们不依赖本地记录（“只渲染路径点不跑完”就靠这一层）
  const route = S.route || [];
  if (route.length > 1) {
    L.polyline(route.map(([la, ln]) => P(la, ln)), {
      color: '#ffd166', weight: 2, opacity: .85, dashArray: '6 5',
    }).addTo(MAP.layers.route);
    route.forEach(([la, ln], i) => {
      L.circleMarker(P(la, ln), {
        radius: 3.5, color: '#ffd166', weight: 1.5, fillColor: '#0c1120', fillOpacity: .9,
      }).bindTooltip('路线点 ' + (i + 1), { direction: 'top' }).addTo(MAP.layers.route);
    });
  }
  (S.waypoints || []).forEach(([la, ln], i) => {
    L.marker(P(la, ln), {
      icon: L.divIcon({
        className: 'cp-icon', iconSize: [18, 18], iconAnchor: [9, 9],
        html: '<span class="wp-label">' + (i + 1) + '</span>',
      }),
      title: '路点 ' + (i + 1) + '（拖不了，用“清路点”重来）', keyboard: false,
    }).addTo(MAP.layers.wpt);
  });
  // 实走轨迹（尚未落库的实时点）也要能看见，否则干跑时地图是空的
  const live = S.livePoints || [];
  if (live.length > 1) {
    L.polyline(live.map((p) => P(p.lat, p.lng)), {
      color: '#7ee0b0', weight: 3, opacity: .95,
    }).addTo(MAP.layers.track);
    const last = live[live.length - 1];
    L.circleMarker(P(last.lat, last.lng), {
      radius: 5, color: '#0c1120', weight: 2, fillColor: '#7ee0b0', fillOpacity: 1,
    }).bindTooltip('当前位置', { direction: 'top' }).addTo(MAP.layers.track);
  }
  if (!fence.length && !pts.length && !cps.length
      && !(S.route || []).length && !(S.waypoints || []).length
      && !(S.livePoints || []).length && !S.startPoint) {
    if (!MAP.blank) { MAP.blank = true; m.setView(MAP_HOME, 16); }
    return;
  }
  MAP.blank = false;


  // 围栏（服务端下发的多边形）
  if (fence.length) {
    L.polygon(fence.map(([la, ln]) => P(la, ln)), {
      color: '#3ecf8e', weight: 1.8, opacity: .95,
      fillColor: '#3ecf8e', fillOpacity: .10,
    }).addTo(MAP.layers.fence);
  }

  // 轨迹：按上传状态着色；同色连续点合成一条 polyline（几百个点也不卡）
  if (pts.length > 1) {
    const colorOf = (s) => (S.showState
      ? (Number(s) === 8 ? '#3ecf8e' : (Number(s) === 4 ? '#ef6a6a' : '#5b7fff'))
      : '#5b7fff');
    let cur = null, seg = [];
    const flush = () => {
      if (seg.length > 1) L.polyline(seg, { color: cur, weight: 3, opacity: .92 }).addTo(MAP.layers.track);
      seg = [];
    };
    for (const p of pts) {
      const ll = P(p.lat, p.lng);
      const c = colorOf(p.state);
      if (cur === null) { cur = c; seg = [ll]; continue; }
      if (c !== cur) { seg.push(ll); flush(); cur = c; seg = [ll]; } else { seg.push(ll); }
    }
    flush();
    L.circleMarker(P(pts[0].lat, pts[0].lng), {
      radius: 4.5, color: '#0c1120', weight: 1.5, fillColor: '#ffffff', fillOpacity: 1,
    }).addTo(MAP.layers.start);
  }

  // 跑步起点（图上选的）：和轨迹首点分开画，带“起”字的青标
  if (S.startPoint && isFinite(Number(S.startPoint.lat))) {
    L.marker(P(S.startPoint.lat, S.startPoint.lng), {
      icon: L.divIcon({
        className: 'cp-icon', iconSize: [22, 22], iconAnchor: [11, 11],
        html: '<span class="start-label">起</span>',
      }),
      title: '跑步起点（“设置起点”可改，“清除起点”回到围栏中心）',
      keyboard: false,
    }).addTo(MAP.layers.start);
  }

  // 打卡点：带序号的圆点，命中后由紫转绿
  cps.forEach((c, i) => {
    const passed = Number(c.passed) === 1;
    L.marker(P(c.lat, c.lng), {
      icon: L.divIcon({
        className: 'cp-icon', iconSize: [18, 18], iconAnchor: [9, 9],
        html: '<span class="cp-label' + (passed ? ' passed' : '') + '">' + (i + 1) + '</span>',
      }),
      title: '打卡点 ' + (i + 1) + (passed ? '（已打卡）' : ''),
      keyboard: false,
    }).addTo(MAP.layers.cps);
  });

  MAP.bounds = corners.length ? L.latLngBounds(corners) : null;
  const key = (MAP.bounds ? MAP.bounds.toBBoxString() : '') + '|' + pts.length + '|' + cps.length
    + '|' + (S.livePoints || []).length + '|' + (S.route || []).length
    + '|' + (S.waypoints || []).length + '|' + cps.filter((c) => Number(c.passed) === 1).length
    + '|' + (S.startPoint ? 'S' : '');
  if (fitFence) {                       // ★ 刚拿到电子围栏：这一帧的镜头直接对准围栏
    MAP.fitKey = key;
    S.fit = false;
    m.fitBounds(fitFence, { padding: [28, 28], maxZoom: 17, animate: false });
    return;
  }
  if (!MAP.bounds) return;
  if (forceFit || S.fit || (key !== MAP.fitKey && !MAP.userMoved)) {
    MAP.fitKey = key;
    S.fit = false;
    m.fitBounds(MAP.bounds, { padding: [28, 28], maxZoom: 18, animate: false });
  }
}

// ══════════════════ 事件绑定 ══════════════════
function busy(btn, on) { btn.disabled = on; }

// ══════════════════ 摇杆与手动实走 ══════════════════
// 一个 0..1 的推杆向量，方向用东(x)/北(y) 分量。轮询发给后端的是单位方向 + 幅度，
// 后端 Walker 自己乘满速，所以这里只管“杆在哪里”。
const JOY = { dx: 0, dy: 0, mag: 0, dragging: false, id: null };

function joyApply(e) {
  const box = $('joy');
  const r = box.getBoundingClientRect();
  const cx = r.left + r.width / 2, cy = r.top + r.height / 2;
  let dx = (Number(e.clientX) - cx), dy = (Number(e.clientY) - cy);
  const rad = r.width / 2 - 10;
  let mag = Math.sqrt(dx * dx + dy * dy) / rad;
  if (mag < 0.02) { joyReset(); return; }
  // 手动推杆即接管：后端 joystick() 已经关掉路径跟随，界面按钮得跟着回到「手动」
  if (S.autoRun) { S.autoRun = false; syncAutoUi(); }
  if (mag > 1) { dx = dx / mag; dy = dy / mag; mag = 1; }
  JOY.dx = dx / rad; JOY.dy = -dy / rad; JOY.mag = Math.min(1, mag);
  const kx = JOY.dx * rad * JOY.mag, ky = -JOY.dy * rad * JOY.mag;
  $('joy-knob').style.transform = `translate(${kx.toFixed(1)}px, ${ky.toFixed(1)}px)`;
  box.classList.add('active');
  Bridge.call('walk_joystick', JOY.dx, JOY.dy, JOY.mag).catch(() => { /* 未开始时后端会拒，忽略 */ });
}

function joyReset() {
  JOY.dx = 0; JOY.dy = 0; JOY.mag = 0;
  $('joy-knob').style.transform = '';
  $('joy').classList.remove('active');
  Bridge.call('walk_joystick', 0, 0, 0).catch(() => { /* 同上 */ });
}

function bindJoystick() {
  const box = $('joy');
  box.addEventListener('pointerdown', (e) => {
    JOY.dragging = true; JOY.id = e.pointerId;
    try { box.setPointerCapture(e.pointerId); } catch (_) { /* 老 WebKit 没有 */ }
    joyApply(e);
    e.preventDefault();
  });
  box.addEventListener('pointermove', (e) => { if (JOY.dragging) joyApply(e); });
  const up = (e) => {
    if (!JOY.dragging) return;
    JOY.dragging = false;
    joyReset();
    if (e && e.pointerId !== undefined) { try { box.releasePointerCapture(e.pointerId); } catch (_) {} }
  };
  box.addEventListener('pointerup', up);
  box.addEventListener('pointercancel', up);
  box.addEventListener('pointerleave', up);

  // 方向键：按下就开始推，松开就停（与摇杆走同一条通路）
  const KEYMAP = {
    ArrowUp: [0, 1], ArrowDown: [0, -1], ArrowLeft: [-1, 0], ArrowRight: [1, 0],
    w: [0, 1], s: [0, -1], a: [-1, 0], d: [1, 0],
  };
  window.addEventListener('keydown', (e) => {
    const tag = (e.target && e.target.tagName) || '';
    if (tag === 'INPUT' || tag === 'SELECT' || tag === 'TEXTAREA') return;
    const k = KEYMAP[e.key];
    if (!k) return;
    e.preventDefault();
    S.joyKey = e.key;
    JOY.dx = k[0]; JOY.dy = k[1]; JOY.mag = 1;
    $('joy').classList.add('active');
    const rad = $('joy').getBoundingClientRect().width / 2 - 10;
    $('joy-knob').style.transform = `translate(${(k[0] * rad * 0.72).toFixed(1)}px, ${(-k[1] * rad * 0.72).toFixed(1)}px)`;
    Bridge.call('walk_joystick', JOY.dx, JOY.dy, 1).catch(() => { /* 同上 */ });
  });
  window.addEventListener('keyup', (e) => {
    if (!S.joyKey || e.key !== S.joyKey) return;
    S.joyKey = null;
    joyReset();
  });
}

// ── 路径规划（只画不跑）───────────────────────────────
// “只规划路径”不需要升跑、不落库、不上传：后端只做几何（最近邻排序 + 闭环）
// 然后把线交给地图；“点选路点”则是用鼠标在地图上自己画一条线。
let PLAN_INFO = null;      // 最近一次规划的摘要，供界面显示

async function planPaths() {
  const r = await Bridge.call('walk_plan');
  const d = (r && r.data) || null;
  if (!d) { toast('规划失败：' + ((r && r.message) || '?'), 'err'); return; }
  PLAN_INFO = d;
  S.route = d.route || [];
  S.fit = true;
  // 开跑前规划用的是围栏预估点：画出来只为看路线，开跑后以服务端下发的打卡点为准
  S.previewPoints = (d.estimated && (d.checkpoints || []).length) ? d.checkpoints : [];
  if (d.start && isFinite(Number(d.start.lat))) {
    S.livePoints = [];      // 重新规划时把上一次的实走残迹清掉，免得两套线混在一起
  }
  drawMap(true);
  const est = Number(d.est_duration_s || 0);
  S.walkMsg = `已规划 ${S.route.length} 个点 / ${Number(d.route_length_m || 0).toFixed(0)} 米`
    + `（预计 ${Math.floor(est / 60)}分${String(est % 60).padStart(2, '0')}秒走完`
    + (d.estimated ? '；按围栏预估打卡点，开跑后以服务端下发为准' : '') + '）';
  syncFlowInfo();
  toast(`已规划路线：${S.route.length} 个点，${Number(d.route_length_m || 0).toFixed(0)} 米（未开跑`
    + (d.estimated ? '，按围栏预估打卡点' : '') + '）', 'ok');
}

function togglePick() {
  S.pickMode = !S.pickMode;
  $('btn-pick').textContent = S.pickMode ? '完成点选' : '点选路点';
  $('btn-pick').classList.toggle('primary', S.pickMode);
  if (S.pickMode) {
    S.waypoints = [];
    toast('点选模式：在地图上依次点击即可加路点', 'ok');
  } else {
    applyWaypoints();
  }
}

async function applyWaypoints() {
  if (!S.waypoints.length) { toast('还没有路点', 'err'); return; }
  const r = await Bridge.call('walk_route', JSON.stringify(S.waypoints), true, false);
  const d = (r && r.data) || {};
  S.route = (d.route && d.route.length) ? d.route : S.waypoints;
  drawMap(true);
  toast(`已设置 ${S.waypoints.length} 个路点（干跑/实跑时可以自动沿它们走）`, 'ok');
}

function clearWaypoints() {
  S.waypoints = [];
  S.route = [];
  S.pickMode = false;
  $('btn-pick').textContent = '点选路点';
  $('btn-pick').classList.remove('primary');
  Bridge.call('walk_route', '[]', false, false).catch(() => {});
  drawMap();
}

// ── 跑步起点（在图上选，存后端）────────────────────
function startPointText() {
  const p = S.startPoint;
  if (!p || p.lat === undefined || p.lat === null) return '起点：围栏中心';
  return `起点：${Number(p.lat).toFixed(6)}, ${Number(p.lng).toFixed(6)}`;
}

function syncStartUi() {
  const b = $('btn-pick-start');
  if (b) {
    b.textContent = S.pickStart ? '点地图…（取消）' : '② 选择起始点';
    b.classList.toggle('primary', S.pickStart);
  }
  const cb = $('btn-clear-start');
  if (cb) cb.disabled = !S.startPoint;
  syncFlowInfo();                      // 起点变了，主流程状态行也要跟着变
}

function togglePickStart() {
  S.pickStart = !S.pickStart;
  if (S.pickStart && S.pickMode) {     // 两种点选互斥：免得一次点击既加路点又设起点
    S.pickMode = false;
    $('btn-pick').textContent = '点选路点';
    $('btn-pick').classList.remove('primary');
  }
  if (S.pickStart) {
    toast('设点模式：在地图上点一下就是跑步起点（点在围栏外会自动吸附进围栏）', 'ok');
  }
  syncStartUi();
}

async function setStartPoint(lat, lng) {
  const r = await Bridge.call('set_start_point', Number(lat), Number(lng));
  if (!r || r.code !== 0) {
    toast('设起点失败：' + ((r && r.message) || '未知错误'), 'err');
    return;
  }
  S.startPoint = ((r.data || {}).start_point) || null;
  S.pickStart = false;
  S.fit = true;                        // 镜头跟到新起点上，好确认选对没有
  syncStartUi();
  drawMap(true);
  refreshStatus();                   // 后端已换起点：让顶栏/详情那些读 S.status 的地方立刻跟上
  toast(r.message || '起点已设置', 'ok');
}

async function clearStartPoint() {
  const r = await Bridge.call('set_start_point', null, null);
  if (!r || r.code !== 0) {
    toast('清除起点失败：' + ((r && r.message) || '未知错误'), 'err');
    return;
  }
  S.startPoint = null;
  S.pickStart = false;
  S.fit = true;
  syncStartUi();
  drawMap(true);
  refreshStatus();
  toast('已回到围栏中心起点', 'ok');
}

// ── 主流程状态行：① 拉取配置 → ② 选择起始点 → ③ 开始跑步 → ④ 结束跑步 ──
// 只讲“下一步做什么”，免得每加一个按钮就得让人自己找路。
function flowInfoText() {
  const st = S.status || {};
  const pg = st.progress || {};
  let base;
  if (pg.running) base = `进行中：${pg.message || '处理中'}（${Math.round(Number(pg.percent || 0))}%）`;
  else if (S.walk && S.walk.running) base = `${S.walk.mode === 'real' ? '跑步中' : '干跑中'}｜${startPointText()}`;
  else if (!st.logged_in) base = '第 ① 步：先在左栏登录';
  else if (!((st.fences || []).length)) base = '第 ① 步：点「拉取配置」，把电子围栏拉下来并自动定位到围栏';
  else base = `已就绪｜${startPointText()}｜点「③ 开始跑步」`;
  // 动作回执（规划结果、跑步实时数据）永远拼在后面：「起点 / 下一步该点哪个」不能被它顶掉
  return S.walkMsg ? `${base}｜${S.walkMsg}` : base;
}

function syncFlowInfo() {
  const info = $('flow-info');
  if (info) info.textContent = flowInfoText();
  const end = $('btn-flow-end');
  if (end) end.disabled = !(S.walk && S.walk.running);
}

// ══════════════════ 布局自愈与界面自检 ══════════════════
// 摇杆簇「永不消失」兜底 + 把实测几何上报后端（写进事件流 / app.log）。
// 背景：2026-10-18 用户报「点开始跑步后摇杆被裁掉」——窗口矮、或 ③ 之后提示行变长把工具行撑高，
// 都能把地图区压扁，绝对定位的摇杆会被地图区 overflow:hidden 整块裁掉。
// 这里无论布局怎么变都把摇杆夹回卡片可见区（必要时整体缩一档），并把 card/body/ctl 的实测矩形发去存档。
function reportGeometry(tag) {
  const card = document.querySelector('.map-card');
  const body = document.querySelector('.map-body');
  const ctl = $('run-ctl');
  const joy = $('joy');
  if (!card || !ctl) return null;
  const R = (e) => {
    if (!e) return null;
    const r = e.getBoundingClientRect();
    return { top: Math.round(r.top), bottom: Math.round(r.bottom),
             left: Math.round(r.left), right: Math.round(r.right),
             w: Math.round(r.width), h: Math.round(r.height) };
  };
  ctl.style.transform = '';
  const a = R(card), c = R(ctl);
  let dx = 0, dy = 0, scale = 1;
  if (c.bottom > a.bottom - 4) dy = a.bottom - 4 - c.bottom;       // 越出卡片下边 → 上移
  if (c.top + dy < a.top + 4) dy = a.top + 4 - c.top;              // 越出上边 → 下移
  if (c.right > a.right - 4) dx = a.right - 4 - c.right;
  if (c.left + dx < a.left + 4) dx = a.left + 4 - c.left;
  if (c.h > a.h - 8) scale = Math.max(0.55, (a.h - 8) / c.h);      // 卡片太矮 → 整体缩一档
  if (dx || dy || scale !== 1) {
    ctl.style.transformOrigin = 'bottom right';
    ctl.style.transform = `translate(${Math.round(dx)}px, ${Math.round(dy)}px) scale(${scale.toFixed(3)})`;
  }
  const info = {
    tag: tag || '', vw: innerWidth, vh: innerHeight, dpr: window.devicePixelRatio,
    card: a, body: R(body), ctl: R(ctl),
    joyVisible: !!(joy && joy.offsetParent),
    autoBtnVisible: !!($('btn-auto-run') && $('btn-auto-run').offsetParent),
    advOpen: !!($('adv-tools') && $('adv-tools').open),
    fixed: !!(dx || dy || scale !== 1),
  };
  try { Bridge.call('ui_report', JSON.stringify(info)); } catch (e) { /* 桥未就绪就算了 */ }
  return info;
}

// 「自动跑」按钮：手动（默认）↔ 自动沿规划路线走。开跑后点也能切（后端 walk_auto 立即生效）
function syncAutoUi() {
  const b = $('btn-auto-run');
  if (!b) return;
  b.textContent = S.autoRun ? '自动跑中（点此转手动）' : '手动（摇杆）';
  b.classList.toggle('primary', !!S.autoRun);
  b.title = S.autoRun
    ? '正在自动沿规划路线走；点一下交回摇杆（推杆也会自动接管）'
    : '默认手动：用右下角摇杆控制方向。点这里切到自动沿规划路线跑';
}

async function toggleAutoRun() {
  const want = !S.autoRun;
  S.autoRun = want;
  syncAutoUi();
  if (S.walk && S.walk.running) {
    const r = await Bridge.call('walk_auto', want);
    if (!r || r.code !== 0) {          // 后端没切成功就把按钮回滚，别骗人
      S.autoRun = !want;
      syncAutoUi();
      toast('切换失败：' + ((r && r.message) || '?'), 'err');
      return;
    }
  }
  toast(want ? '自动跑：沿规划路线自动走' : '手动模式：用右下角摇杆控制方向', 'ok');
  syncFlowInfo();
  refreshStatus();
}

// ── 实走：升跑 / 叫停 / 上传 ────────────────────────
async function walkStart(mode) {
  S.pickedRecord = null;      // 开跑后左卡回到实时数据，不再停在某条历史记录
  busy($('btn-walk-dry'), true); busy($('btn-walk-real'), true);
  try {
    const target = Number($('in-distance').value) || 0;
    const auto = !!S.autoRun;   // 「自动跑」按钮说了算：默认手动，靠摇杆控制方向
    // 第 4 个参数是摇杆速度（m/s），第 7 个是时间倍速——实走固定 1 倍速，
    // 传统上误把「仿真倍速」当摇杆速度传进去，会让实跑飙到 20 m/s
    const mps = Number($('in-walk-speed') && $('in-walk-speed').value) || 0;
    const r = await Bridge.call('walk_start', mode, target, Number($('in-fence').value),
      mps, auto, true, 1);
    if (!r || r.code !== 0) { toast('启动失败：' + ((r && r.message) || '?'), 'err'); return; }
    S.walkSince = 0;
    S.livePoints = [];
    S.walk = r.data || {};
    S.autoRun = !!auto;                    // 开跑就用按钮上的手动 / 自动，不等下一次轮询
    syncAutoUi();
    $('map').closest('.map-card').classList.add('walking');
    $('btn-walk-stop').disabled = false;
    $('btn-walk-pause').disabled = false;
    S.paused = false;
    $('btn-walk-pause').textContent = '暂停';
    S.walkMsg = '';                       // 交给实时数据（pumpWalk 每 500ms 刷一次）
    syncFlowInfo();
    toast(mode === 'real' ? '已开跑，轨迹实时入库（结束跑步会顺带上传结算）' : '干跑已开始（不落库、不上传）', 'ok');
    startWalkTimer();
    refreshStatus();                       // 开跑后后端才拿到真实打卡点，status 立刻跟上
  } finally {
    busy($('btn-walk-dry'), false); busy($('btn-walk-real'), false);
  }
}

// 暂停 / 继续：后端 walk_pause 停止计时与采样，结算时上报实际 pauseCount/pauseTimes
async function walkPause() {
  const want = !S.paused;
  const r = await Bridge.call('walk_pause', want);
  if (!r || r.code !== 0) { toast('切换失败：' + ((r && r.message) || '?'), 'err'); return; }
  S.paused = want;
  $('btn-walk-pause').textContent = want ? '继续' : '暂停';
  toast(want ? '已暂停：计时与计步都停' : '已继续', 'ok');
  refreshStatus();
}

async function walkStop() {
  const r = await Bridge.call('walk_stop');
  S.walk = r || S.walk;
  $('btn-walk-stop').disabled = true;
  $('btn-walk-pause').disabled = true;
  S.paused = false;
  $('btn-walk-pause').textContent = '暂停';
  $('map').closest('.map-card').classList.remove('walking');
  S.walkMsg = '';
  syncFlowInfo();
  const st = (r && r.state) || {};
  toast(`已停止：${Number(st.dist_m || 0).toFixed(0)} 米 / ${st.steps || 0} 步`
    + `（本地已落库 ${r && r.stored || 0} 点）`, 'ok');
  refreshRuns();
}

async function walkUpload() {
  const r = await Bridge.call('walk_upload', true);
  toast((r && r.message) || '已提交', r && r.code === 0 ? 'ok' : 'err');
}

async function walkSave() {
  const r = await Bridge.call('walk_save', '');
  toast((r && r.message) || '已保存', r && r.code === 0 ? 'ok' : 'err');
  if (r && r.code === 0) refreshRuns();
}

// ③ 开始跑步：先把打卡路径画到地图上，再升跑并开始记录（轨迹实时入库）
async function startRun() {
  S.pickedRecord = null;      // 开跑后左卡回到实时数据
  const st = S.status || {};
  if (!st.logged_in) { toast('请先在左栏 ① 登录', 'err'); return; }
  if (!((st.fences || []).length)) { toast('请先点「① 拉取配置」，把电子围栏拉下来', 'err'); return; }
  if (S.walk && S.walk.running) { toast('已经在跑了：等它跑完，或点「④ 结束跑步」', 'err'); return; }
  await saveParams(true);
  // 先清掉图上画过的旧路线，让这次开跑按服务端下发的真实打卡点重算路线
  S.previewPoints = [];
  await Bridge.call('walk_route', '[]', !!S.autoRun, false);
  await walkStart('real');
  reportGeometry('run');                       // 开跑后把布局几何上报一次（写进事件流）
}

// ④ 结束跑步：停止记录 → 上传轨迹 → 结算（上传走后台线程，进度看状态行）
async function walkEnd() {
  if (!(S.walk && S.walk.running)) { toast('现在没有在跑', 'err'); return; }
  const b = $('btn-flow-end');
  busy(b, true);
  try {
    const r = await Bridge.call('walk_stop');
    S.walk = r || S.walk;
    stopWalkTimer();
    $('map').closest('.map-card').classList.remove('walking');
    $('btn-walk-stop').disabled = true;
    $('btn-walk-pause').disabled = true;
    S.paused = false;
    $('btn-walk-pause').textContent = '暂停';
    const st = (r && r.state) || {};
    S.walkMsg = '';
    syncFlowInfo();
    const up = await Bridge.call('walk_upload', true);
    toast(`已结束：${Number(st.dist_m || 0).toFixed(0)} 米 / ${st.steps || 0} 步 · `
      + ((up && up.message) || '已提交上传结算'), (up && up.code === 0) ? 'ok' : 'err');
    refreshRuns();
    refreshStatus();
  } finally {
    busy(b, false);
    syncFlowInfo();                   // 能不能再点，由真实运行态决定
    reportGeometry('end');
  }
}

// 实走进行中：从后端增量拉点（S.walkSince = 已拉到的点数），描到地图上。
// 干跑时后端不落库，只能靠这条通道把轨迹送过来。
function startWalkTimer() {
  if (S.walkTimer) return;
  S.walkTimer = setInterval(pumpWalk, 500);
}
function stopWalkTimer() {
  if (S.walkTimer) { clearInterval(S.walkTimer); S.walkTimer = null; }
}

async function pumpWalk() {
  let r = null;
  try { r = await Bridge.call('walk_status', S.walkSince); } catch (_) { return; }
  if (!r) return;
  S.walk = r;
  if (typeof r.auto === 'boolean' && r.auto !== S.autoRun) { S.autoRun = r.auto; syncAutoUi(); }
  const pts = r.points || [];
  if (pts.length) {
    S.walkSince = Number(r.total || (S.walkSince + pts.length));
    for (const p of pts) {
      S.livePoints.push({ lat: Number(p.lat), lng: Number(p.lng) });
      if (S.livePoints.length > 4000) S.livePoints.shift();
    }
  }
  const st = r.state || {};
  const done = !r.running;
  const segs = r.segments || {};
  const stepLine = r.mode === 'real'
    ? `　已落库 ${r.stored || 0} 点 / ${r.steps || 0} 个步频段 / ${r.paces || 0} 个配速段 / ${r.strides || 0} 个步幅段`
    : `　（调试不落库；内存已切 ${segs.steps || 0} 个步频段 / ${segs.strides || 0} 个步幅段）`;
  S.walkMsg = `${Number(st.dist_m || 0).toFixed(0)} 米 / ${st.steps || 0} 步 / `
    + `速度 ${st.speed_mps ? Number(st.speed_mps).toFixed(2) : '0.00'} m/s / `
    + `打卡 ${st.passed || 0}/${st.targets || 0}`
    + stepLine;
  if (Array.isArray(r.route) && r.route.length) {   // 后端真正在走的那条线，才是地图上该画的线
    S.route = r.route.map((p) => [Number(p[0]), Number(p[1])]);
  }
  syncFlowInfo();
  if (r.run_code) { S.currentRun = r.run_code; $('run-code-label').textContent = r.run_code; }
  // 跑步中“本次跑步”面板实时跟距离、步数、打卡
  // 时长/配速取 elapsed_sec（原版 DataComponent.Q0()：站着不动也照走表），
  // 配速 = 时长 / 公里数（原版 J0()，Q0()/max(0.01, km)）——不能拿 move_sec（只在移动时累加），
  // 否则一停下时长与配速都冻住。
  const durSec = Number(st.elapsed_sec || st.move_sec || 0);
  renderRunInfo({
    run_code: r.run_code || '--', distance_m: st.dist_m, duration_s: durSec,
    elapsed_s: durSec,   // 草稿/记录里的「计时」也是墙钟口径，实时面板别显示成 0
    total_step: st.steps, stride_m: st.steps ? (st.dist_m / st.steps) : 0,
    pace_s_per_km: st.dist_m > 0 ? (durSec / (st.dist_m / 1000)) : 0,
    checkpoints_done: st.passed, checkpoints_total: st.targets,
    valid: { isValid: true, reasons: [] },
  });
  drawMap();
  if (done) {
    stopWalkTimer();
    $('btn-walk-stop').disabled = true;
    $('btn-walk-pause').disabled = true;
    S.paused = false;
    $('btn-walk-pause').textContent = '暂停';
    $('map').closest('.map-card').classList.remove('walking');
    S.walkMsg = '';
    syncFlowInfo();
    if (st.arrived) {
      // 到达目标里程 = 自动结束。后端收到 walk_arrived 会自己走「上传 + 结算」
      // （walk.auto_settle，默认开），这里只负责把结果刷出来：
      // 结算线程要跑几秒，所以隔一段时间补两次刷新。
      toast('实走结束：' + st.arrived + (r.mode === 'real' ? '，正在自动上传结算…' : ''), 'ok');
      refreshRuns();
      if (r.mode === 'real') {
        setTimeout(() => { refreshRuns(); refreshStatus(); }, 3000);
        setTimeout(() => { refreshRuns(); refreshStatus(); }, 9000);
      }
    }
  }
}
// 登录面板两个模式长相不同：真实登录要密码、提示说明验证码；本地登录随便填
function syncLoginHint(mode) {
  const mock = mode === 'mock';
  const hint = $('login-hint');
  if (hint) {
    hint.textContent = mock ? '本地 Mock：任意手机号即可，不联网'
                            : '真实服务端登录，验证码会自动求解';
  }
  const pwd = $('in-password');
  if (pwd) pwd.placeholder = mock ? '任意（Mock 模式不校验）' : '账号密码（必填）';
}

// 下拉框的值是 renderStatus 按后端模式同步的，读早了只会拿到 HTML 里的初值，
// 然后拿着它去切模式——所以先确保状态已拉取。
async function currentModeChoice() {
  if (!S.status) await refreshStatus();
  const sel = $('in-login-mode');
  return (sel && sel.value) || (S.status && S.status.mode) || 'real';
}

// 切模式：先问后端切没切成功再继续，否则会拿着旧连接去请求新服务端
async function ensureMode(want) {
  want = want || (await currentModeChoice());
  const cur = (S.status && S.status.mode) || 'real';
  if (!want || want === cur) return true;
  const r = await Bridge.call('switch_mode', want);
  if (!r || (r.mode !== want)) {
    toast('切换登录方式失败：' + ((r && r.message) || '未知错误'), 'err');
    return false;
  }
  toast(want === 'mock' ? '已切换到本地登录（离线）' : '已切换到真实登录', 'ok');
  return true;
}

async function init() {
  await Bridge.waitReady();
  if (!(window.pywebview && window.pywebview.api) && !location.protocol.startsWith('http')) {
    toast('未检测到 Python 桥接，请用桌面入口启动', 'err');
  }

  // 底图：记住用户上次选的瓦片源（localStorage，不写后端配置）
  S.tiles = tileSetting();
  $('in-tiles').value = S.tiles;
  ensureMap();

  // 顶栏
  $('btn-data-dir').addEventListener('click', async () => {
    const r = await Bridge.call('open_data_dir');
    toast('数据目录：' + (r.path || ''), 'ok');
  });


$('in-login-mode').addEventListener('change', async () => {
  const sel = $('in-login-mode');
  if (!(await ensureMode(sel.value))) { sel.value = (S.status && S.status.mode) || 'real'; }
  await refreshStatus();
});

$('btn-login').addEventListener('click', async () => {
  const b = $('btn-login');
  // 先切模式再登录；mock 取切完之后后端的真实模式，不信任下拉框
  if (!(await ensureMode())) { busy(b, false); return; }
  const mock = ((S.status || {}).mode === 'mock');
  busy(b, true);
  const phone = $('in-phone').value.trim();
  const password = $('in-password').value;
  if (!phone) {                       // 别把空手机号送进去，那样后端只会回“预检失败：手机号缺失”
    busy(b, false);
    toast('请先填手机号', 'err');
    return;
  }
  if (!mock && !password) {           // 真实登录必须带密码，否则服务端只会回一个含糊的失败
    busy(b, false);
    toast('真实登录需要填密码', 'err');
    return;
  }
  try {
    const res = await Bridge.call('login', phone, password, $('in-captcha').checked);
    if (res && res.code === 0) toast('登录成功', 'ok');
    else toast('登录失败：' + ((res && res.message) || '未知错误'), 'err');
  } finally { busy(b, false); refreshStatus(); }
});
  $('btn-logout').addEventListener('click', async () => {
    await Bridge.call('logout'); toast('已退出登录'); refreshStatus();
  });

  // 历史账号：不重新输密码，直接换 token 开工
  $('in-account').addEventListener('change', () => {
    const has = !!$('in-account').value;
    $('btn-account-use').disabled = !has;
    $('btn-account-del').disabled = !has;
  });
  $('btn-account-use').addEventListener('click', async () => {
    const uid = $('in-account').value;
    if (!uid) return;
    const r = await Bridge.call('switch_account', uid);
    if (r && r.code === 0) {
      toast('已切换账号：' + ((r.data && r.data.userName) || '该账号'), 'ok');
      refreshStatus();
    } else toast('切换失败：' + ((r && r.message) || '未知错误'), 'err');
  });
  $('btn-account-del').addEventListener('click', async () => {
    const uid = $('in-account').value;
    if (!uid) return;
    const r = await Bridge.call('forget_account', uid);
    if (r && r.code === 0) { toast('已移除该账号', 'ok'); refreshStatus(); }
    else toast('移除失败：' + ((r && r.message) || '未知错误'), 'err');
  });

  // 跑步
  $('btn-prepare').addEventListener('click', async () => {
    const b = $('btn-prepare'); busy(b, true);
    try {
      await saveParams(true);
      const r = await Bridge.call('prepare');
      toast(r.code === 0 ? '配置已拉取' : ('失败：' + r.message), r.code === 0 ? 'ok' : 'err');
    } finally { busy(b, false); refreshStatus(); }
  });
  $('btn-run').addEventListener('click', async () => {
    await saveParams(true);
    const r = await Bridge.call('run_auto', Number($('in-distance').value),
      Number($('in-fence').value), true, true, 1);
    toast(r.message || '已启动', r.code === 0 ? 'ok' : 'err');
  });
  $('btn-resume').addEventListener('click', async () => {
    const r = await Bridge.call('resume', S.currentRun || '');
    toast(r.message || '已触发', r.code === 0 ? 'ok' : 'err');
  });
  $('btn-save-cfg').addEventListener('click', async () => {
    await saveParams(false); toast('参数已保存', 'ok');
  });
  $('btn-reset-device').addEventListener('click', async () => {
    const r = await Bridge.call('reset_device');
    toast('新 deviceId：' + (r.device_id || ''), 'ok');
    refreshStatus();
  });
  $('btn-load-rule').addEventListener('click', async () => {
    await Bridge.call('prepare'); refreshStatus();
  });

  // 路径规划 / 摇杆实走（这一块全部不依赖登录状态，先接上，免得按钮点了没反应）
  $('btn-plan').addEventListener('click', async () => {
    const b = $('btn-plan'); busy(b, true);
    try {
      if (!S.status || !S.status.logged_in) toast('建议先登录：规划本身不需要网络，但需要已经拉过的围栏与打卡点', 'err');
      await planPaths();
    } finally { busy(b, false); }
  });
  $('btn-pick').addEventListener('click', togglePick);
  $('btn-clear-wp').addEventListener('click', clearWaypoints);
  $('btn-walk-dry').addEventListener('click', () => walkStart('dry'));
  $('btn-walk-real').addEventListener('click', startRun);   // ③ 开始跑步（先画路径再开跑）
  $('btn-flow-end').addEventListener('click', walkEnd);      // ④ 结束跑步（停止 + 上传结算）
  $('btn-walk-stop').addEventListener('click', walkStop);
  $('btn-walk-pause').addEventListener('click', walkPause);
  $('btn-walk-up').addEventListener('click', walkUpload);
  $('btn-walk-save').addEventListener('click', walkSave);
  bindJoystick();

  // 页面刷新/重启时可能还有一次实走在跑，接上轮询不要断
  try {
    const w = await Bridge.call('walk_status', -1);
    if (w && w.running) {
      S.walk = w; S.walkSince = Number(w.points || 0);
      $('btn-walk-stop').disabled = false;
      syncFlowInfo();                    // 接管后「④ 结束跑步」也得可用
      $('map').closest('.map-card').classList.add('walking');
      startWalkTimer();
      toast('检测到正在进行的实走，已重新接管', 'ok');
    }
  } catch (_) { /* 后端没这接口时忽略 */ }

  // 地图 / 日志
  $('in-show-state').addEventListener('change', (e) => { S.showState = e.target.checked; drawMap(); });
  $('btn-fit').addEventListener('click', () => { S.fit = true; drawMap(true); });
  // 跑步起点：点“设置起点”后在图上点一下，或点“清除起点”回到围栏中心
  $('btn-pick-start').addEventListener('click', togglePickStart);
  $('btn-clear-start').addEventListener('click', clearStartPoint);
  // 摇杆与「自动跑」：常驻右下角，默认手动
  $('btn-auto-run').addEventListener('click', toggleAutoRun);
  syncAutoUi();
  $('in-tiles').addEventListener('change', (e) => {
    S.tiles = e.target.value;
    try { localStorage.setItem('shandong_school_cracked.tiles', S.tiles); } catch (err) { /* 隐私模式等 */ }
    setTiles(MAP.obj);
  });
  $('btn-clear-log').addEventListener('click', () => { $('log').innerHTML = ''; S.logCount = 0; });
  $('btn-refresh-runs').addEventListener('click', () => refreshRuns());
  $('btn-runs-prev').addEventListener('click', () => refreshRuns(false, S.runsPage - 1));
  $('btn-runs-next').addEventListener('click', () => refreshRuns(false, S.runsPage + 1));
  // 尺寸变化：Leaflet 必须收到 invalidateSize，否则瓦片错位、底图留白
  window.addEventListener('resize', () => {
    if (MAP.obj) MAP.obj.invalidateSize();
    drawMap();
    reportGeometry('resize');
  });

  // 首次渲染 + 轮询事件流（失败一定要看得见，否则界面会静默地全空）
  try {
    await refreshStatus();
    await refreshRuns();
  } catch (e) {
    toast('初始化失败：' + ((e && e.message) || e), 'err');
  }
  setInterval(poll, 700);
  reportGeometry('load');                        // 首屏自检：摇杆簇有没有被裁，直接写进事件流
}

async function saveParams(silent) {
  const patch = {
    run: {
      target_distance_m: Number($('in-distance').value),
      stride_m: Number($('in-stride').value),
    },
    sim: {
      min_cadence: Number($('in-cad-lo').value),
      max_cadence: Number($('in-cad-hi').value),
      realtime: $('in-realtime').checked,          // 实时推进仿真（调试时看轨迹一笔笔画）
      speed: Number($('in-speed').value) || 8,
    },
    walk: {
      // 摇杆推满时的速度（m/s）；实走倍速固定 1，不在这里暴露
      speed_mps: Number($('in-walk-speed') && $('in-walk-speed').value) || 2.5,
      auto_settle: $('in-auto-settle') ? $('in-auto-settle').checked : true,
    },
    mock_fail_rate: Number($('in-failrate').value),
  };
  await Bridge.call('patch_config', JSON.stringify(patch));
  if (!silent) refreshStatus();
}

async function refreshStatus() {
  const st = await Bridge.call('status');
  if (st) renderStatus(st);
}

async function poll() {
  try {
    const r = await Bridge.call('poll', S.seq);
    if (!r) return;
    (r.events || []).forEach((e) => { S.seq = Math.max(S.seq, e.seq || 0); });
    appendEvents(r.events || []);
    renderProgress(r.progress || {});
    // 跑步中：每两次轮询（约 1.4 秒）拉一次轨迹，让地图“一笔一笔”长出来。
    if (r.running && r.progress && r.progress.run_code) {
      S.liveTick = (S.liveTick || 0) + 1;
      if (S.liveTick % 2 === 0) refreshLiveMap(r.progress.run_code);
    }
    if (r.logged_in !== undefined && S.status && r.logged_in !== S.status.logged_in) {
      refreshStatus();
    }
    const done = (r.events || []).some(e => e.kind === 'auto_done' || e.kind === 'run_finished');
    if (done) {
      S.currentRun = null;      // 让最新一条自动展开
      S.pickedRecord = null;    // 结束跑步后回到“最新一次”的显示
      await refreshStatus();
      await refreshRuns(true);
    }
  } catch (err) {
    /* 轮询失败静默重试 */
  }
}

document.addEventListener('DOMContentLoaded', init);
