/* ══════════════════════════════════════════════════════════════
   闪动校园 · 阳光跑工作台 —— 前端逻辑
   后端桥：pywebview 桌面壳（window.pywebview.api）或 HTTP 降级（POST /api）
   ══════════════════════════════════════════════════════════════ */
'use strict';

// ── 桥接层 ────────────────────────────────────────────────
const Bridge = {
  ready: false,
  useHttp: location.protocol.startsWith('http') && !/pywebview/i.test(navigator.userAgent),

  async waitReady() {
    if (window.pywebview && window.pywebview.api) { this.ready = true; return; }
    if (this.useHttp) { this.ready = true; return; }
    await new Promise((resolve) => {
      const t = setTimeout(resolve, 2500);
      window.addEventListener('pywebviewready', () => { clearTimeout(t); this.ready = true; resolve(); }, { once: true });
    });
  },

  async call(method, ...args) {
    if (!this.ready) await this.waitReady();
    if (window.pywebview && window.pywebview.api && typeof window.pywebview.api[method] === 'function') {
      return await window.pywebview.api[method](...args);
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
    const t = new Date(ev.time || Date.now());
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
  const mode = st.mode === 'mock' ? '本地 Mock（离线）' : '真实服务端';
  $('pill-mode').textContent = `模式：${mode}`;
  $('pill-mode').className = 'pill ' + (st.mode === 'mock' ? 'on' : 'warn');
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
    'token': { html: esc(String(u.token || '').slice(0, 18)) + '…', cls: 'mono' },
  }) : '<span class="v">未登录（Mock 模式任意手机号可登录）</span>';

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

  // 参数回填（仅首次）
  if (!S.paramsLoaded) {
    const rc = st.run_cfg || {}, sc = st.sim_cfg || {};
    if (rc.target_distance_m) $('in-distance').value = rc.target_distance_m;
    if (rc.stride_m) $('in-stride').value = rc.stride_m;
    if (sc.min_cadence) $('in-cad-lo').value = sc.min_cadence;
    if (sc.max_cadence) $('in-cad-hi').value = sc.max_cadence;
    S.paramsLoaded = true;
  }

  renderProgress(st.progress || {});
  if (st.last && st.last.run_code && st.last.run_code !== S.currentRun) {
    S.currentRun = st.last.run_code;
    renderRunInfo(st.last);
    refreshDetail(st.last.run_code);
  }
}

function renderProgress(p) {
  const pct = Math.max(0, Math.min(100, Number(p.percent || 0)));
  $('progress-fill').style.width = pct + '%';
  $('progress-text').textContent = `${pct}% · ${p.message || '就绪'}`
    + (p.running ? '（运行中）' : '');
  const busy = !!p.running;
  $('btn-run').disabled = busy;
  $('btn-prepare').disabled = busy;
  $('btn-resume').disabled = busy;
}

function renderRunInfo(last) {
  const v = last.valid || {};
  const mm = Math.floor((last.duration_s || 0) / 60);
  const ss = (last.duration_s || 0) % 60;
  $('run-code-label').textContent = last.run_code || '--';
  $('run-info').innerHTML = kv({
    '距离': `${(last.distance_m || 0).toFixed(1)} 米`,
    '时长': `${mm}分${String(ss).padStart(2, '0')}秒`,
    '配速': last.pace_s_per_km ? `${Math.floor(last.pace_s_per_km / 60)}'${String(Math.round(last.pace_s_per_km % 60)).padStart(2, '0')}"/公里` : '--',
    '总步数': last.total_step || 0,
    '步幅': `${last.stride_m || 0} 米`,
    '打卡点': `${last.checkpoints_done || 0}/${last.checkpoints_total || 0}`,
    '有效性': {
      html: v.isValid ? '✓ 有效' : '✗ ' + (v.reasons || []).map(x => x.name).join('、'),
      cls: v.isValid ? 'ok' : 'err',
    },
    '计时': `${last.elapsed_s || last.total_elapsed_s || 0} 秒`,
  });
  drawMap();
}

// ══════════════════ 记录列表 ══════════════════
async function refreshRuns() {
  const runs = await Bridge.call('list_runs', 100);
  const box = $('runs');
  if (!Array.isArray(runs) || !runs.length) {
    box.innerHTML = '<div class="hint">暂无本地记录</div>';
    return;
  }
  box.innerHTML = runs.map((r) => {
    const uploaded = r.uploaded ? '<span class="badge ok">已结算</span>'
      : (r.distance_m ? '<span class="badge warn">未结算</span>' : '<span class="badge">草稿</span>');
    const valid = (r.valid && r.valid.isValid === false)
      ? `<span class="badge err">${esc((r.valid.reasons || []).map(x => x.name).join('、'))}</span>` : '';
    const d = r.distance_m ? `${Number(r.distance_m).toFixed(0)} 米` : '--';
    const t = r.duration_s ? `${Math.round(r.duration_s / 60)} 分` : '--';
    return `<div class="run-item" data-code="${esc(r.run_code)}">
      <div class="rc">${esc(r.run_code)}</div>
      <div class="meta"><span>${d}</span><span>${t}</span><span>${esc(r.source || '')}</span>
      ${uploaded}${valid}</div></div>`;
  }).join('');
  box.querySelectorAll('.run-item').forEach((el) => {
    el.addEventListener('click', () => {
      box.querySelectorAll('.run-item').forEach(x => x.classList.remove('active'));
      el.classList.add('active');
      refreshDetail(el.dataset.code);
    });
  });
}

async function refreshDetail(code) {
  const d = await Bridge.call('run_detail', code);
  if (!d || !d.run) { $('run-detail').innerHTML = ''; return; }
  S.detail = d;
  S.currentRun = code;
  const run = d.run, c = d.counts || {};
  const reasons = (run.valid && run.valid.reasons || []);
  const uploadRows = (d.upload_log || []).slice(-8).reverse().map(l =>
    `<tr><td class="mono">${esc((l.endpoint || '').replace('run/', ''))}</td>
     <td class="${l.ok ? '' : 'err'}">${l.ok ? '成功' : '失败'}</td>
     <td>${esc(l.message || '')}</td></tr>`).join('');
  $('run-detail').innerHTML = `
    <h3>${esc(code)}</h3>
    ${kvTable([
      ['距离', `${Number(run.distance_m || 0).toFixed(1)} 米`],
      ['时长', `${run.duration_s || 0} 秒`],
      ['配速', run.pace_s_per_km ? `${Number(run.pace_s_per_km).toFixed(1)} 秒/公里` : '--'],
      ['总步数', run.total_step || 0],
      ['已上传轨迹', `${c.points_uploaded || 0} / ${c.points || 0}（失败 ${c.points_failed || 0}）`],
      ['状态位', `init=${c.points_pending || 0}`],
      ['有效性', (run.valid && run.valid.isValid) ? '有效' : ('无效：' + reasons.map(x => x.name).join('、'))],
    ])}
    <h3>上传记录</h3>
    <table><thead><tr><th>接口</th><th>结果</th><th>说明</th></tr></thead>
    <tbody>${uploadRows || '<tr><td colspan="3" class="hint">无</td></tr>'}</tbody></table>
    <h3>操作</h3>
    <div class="row">
      <button class="btn small" data-act="export-json" data-code="${esc(code)}">导出 JSON</button>
      <button class="btn small" data-act="export-gpx" data-code="${esc(code)}">导出 GPX</button>
      <button class="btn small" data-act="resume" data-code="${esc(code)}">续传</button>
      <button class="btn small" data-act="delete" data-code="${esc(code)}">删除</button>
    </div>`;
  $('run-detail').querySelectorAll('button[data-act]').forEach((b) => {
    b.addEventListener('click', async () => {
      const act = b.dataset.act, rc = b.dataset.code;
      if (act === 'export-json' || act === 'export-gpx') {
        const r = await Bridge.call('export', rc, act === 'export-gpx' ? 'gpx' : 'json');
        toast('已导出：' + (r.path || '?'), 'ok');
      } else if (act === 'resume') {
        const r = await Bridge.call('resume', rc);
        toast(r.message || '已触发续传', r.code === 0 ? 'ok' : 'err');
      } else if (act === 'delete') {
        await Bridge.call('delete_run', rc);
        toast('已删除 ' + rc, 'ok');
        refreshRuns();
        $('run-detail').innerHTML = '';
      }
    });
  });
  drawMap();
}

function kvTable(rows) {
  return '<table>' + rows.map(([k, v]) =>
    `<tr><th>${esc(k)}</th><td>${esc(v)}</td></tr>`).join('') + '</table>';
}

// ══════════════════ 地图绘制 ══════════════════
const canvas = () => $('map');
function drawMap() {
  const cv = canvas();
  const wrap = cv.parentElement;
  const dpr = window.devicePixelRatio || 1;
  const w = wrap.clientWidth, h = wrap.clientHeight;
  cv.width = Math.max(1, w * dpr);
  cv.height = Math.max(1, h * dpr);
  cv.style.width = w + 'px';
  cv.style.height = h + 'px';
  const ctx = cv.getContext('2d');
  ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
  ctx.clearRect(0, 0, w, h);
  ctx.fillStyle = '#0c1120';
  ctx.fillRect(0, 0, w, h);

  const st = S.status || {};
  const fence = st.fence_polygon || [];
  const pts = (S.detail && S.detail.points) || [];
  const cps = (S.detail && S.detail.checkpoints) || st.checkpoints || [];
  if (!fence.length && !pts.length) {
    ctx.fillStyle = '#47536e';
    ctx.font = '13px system-ui';
    ctx.fillText('暂无轨迹数据：先登录并点击「一键跑完整链路」', 20, 30);
    return;
  }

  // 经纬度 → 平面（等距圆柱，按纬度压缩经度）
  const all = []
    .concat(fence.map(p => [p[0], p[1]]))
    .concat(pts.map(p => [p.lat, p.lng]))
    .concat(cps.map(p => [Number(p.lat), Number(p.lng)]));
  let latMin = Infinity, latMax = -Infinity, lngMin = Infinity, lngMax = -Infinity;
  for (const [la, ln] of all) {
    if (!isFinite(la) || !isFinite(ln)) continue;
    latMin = Math.min(latMin, la); latMax = Math.max(latMax, la);
    lngMin = Math.min(lngMin, ln); lngMax = Math.max(lngMax, ln);
  }
  if (!isFinite(latMin)) return;
  const kx = Math.cos(((latMin + latMax) / 2) * Math.PI / 180);
  const spanLat = Math.max(1e-6, latMax - latMin);
  const spanLng = Math.max(1e-6, (lngMax - lngMin) * kx);
  const pad = 34;
  const scale = Math.min((w - pad * 2) / spanLng, (h - pad * 2) / spanLat);
  const ox = pad + ((w - pad * 2) - spanLng * scale) / 2;
  const oy = pad + ((h - pad * 2) - spanLat * scale) / 2;
  const P = (la, ln) => [
    ox + ((ln - lngMin) * kx) * scale,
    oy + (latMax - la) * scale,
  ];

  // 围栏
  if (fence.length) {
    ctx.beginPath();
    fence.forEach(([la, ln], i) => {
      const [x, y] = P(la, ln);
      i ? ctx.lineTo(x, y) : ctx.moveTo(x, y);
    });
    ctx.closePath();
    ctx.fillStyle = 'rgba(62,207,142,.10)';
    ctx.fill();
    ctx.strokeStyle = '#3ecf8e';
    ctx.lineWidth = 1.6;
    ctx.stroke();
  }

  // 轨迹
  if (pts.length > 1) {
    ctx.lineWidth = 2.4;
    if (S.showState) {
      let prev = null;
      for (const p of pts) {
        const [x, y] = P(p.lat, p.lng);
        if (prev) {
          ctx.beginPath();
          ctx.moveTo(prev[0], prev[1]);
          ctx.lineTo(x, y);
          ctx.strokeStyle = p.state === 8 ? '#3ecf8e' : (p.state === 4 ? '#ef6a6a' : '#5b7fff');
          ctx.stroke();
        }
        prev = [x, y];
      }
    } else {
      ctx.beginPath();
      pts.forEach((p, i) => {
        const [x, y] = P(p.lat, p.lng);
        i ? ctx.lineTo(x, y) : ctx.moveTo(x, y);
      });
      ctx.strokeStyle = '#5b7fff';
      ctx.stroke();
    }
    const [sx, sy] = P(pts[0].lat, pts[0].lng);
    ctx.fillStyle = '#fff';
    ctx.beginPath(); ctx.arc(sx, sy, 3.6, 0, Math.PI * 2); ctx.fill();
  }

  // 打卡点
  cps.forEach((c, i) => {
    const [x, y] = P(Number(c.lat), Number(c.lng));
    ctx.beginPath();
    ctx.arc(x, y, 6, 0, Math.PI * 2);
    ctx.fillStyle = Number(c.passed) === 1 ? 'rgba(62,207,142,.9)' : 'rgba(176,124,240,.85)';
    ctx.fill();
    ctx.strokeStyle = '#0c1120'; ctx.lineWidth = 1.4; ctx.stroke();
    ctx.fillStyle = '#0c1120';
    ctx.font = 'bold 8px system-ui';
    ctx.textAlign = 'center'; ctx.textBaseline = 'middle';
    ctx.fillText(String(i + 1), x, y + 0.5);
    ctx.textAlign = 'start'; ctx.textBaseline = 'alphabetic';
  });
}

// ══════════════════ 事件绑定 ══════════════════
function busy(btn, on) { btn.disabled = on; }

async function init() {
  await Bridge.waitReady();
  if (!(window.pywebview && window.pywebview.api) && !location.protocol.startsWith('http')) {
    toast('未检测到 Python 桥接，请用桌面入口启动', 'err');
  }

  // 顶栏
  $('btn-data-dir').addEventListener('click', async () => {
    const r = await Bridge.call('open_data_dir');
    toast('数据目录：' + (r.path || ''), 'ok');
  });

  // 登录
  $('btn-login').addEventListener('click', async () => {
    const b = $('btn-login'); busy(b, true);
    try {
      const res = await Bridge.call('login', $('in-phone').value.trim(),
        $('in-password').value, $('in-captcha').checked);
      if (res && res.code === 0) toast('登录成功', 'ok');
      else toast('登录失败：' + ((res && res.message) || '未知错误'), 'err');
    } finally { busy(b, false); refreshStatus(); }
  });
  $('btn-logout').addEventListener('click', async () => {
    await Bridge.call('logout'); toast('已退出登录'); refreshStatus();
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

  // 地图 / 日志
  $('in-show-state').addEventListener('change', (e) => { S.showState = e.target.checked; drawMap(); });
  $('btn-fit').addEventListener('click', drawMap);
  $('btn-clear-log').addEventListener('click', () => { $('log').innerHTML = ''; S.logCount = 0; });
  $('btn-refresh-runs').addEventListener('click', refreshRuns);
  window.addEventListener('resize', drawMap);

  await refreshStatus();
  await refreshRuns();
  setInterval(poll, 700);
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
    if (r.logged_in !== undefined && S.status && r.logged_in !== S.status.logged_in) {
      refreshStatus();
    }
    const done = (r.events || []).some(e => e.kind === 'auto_done' || e.kind === 'run_finished');
    if (done) { await refreshStatus(); await refreshRuns(); }
  } catch (err) {
    /* 轮询失败静默重试 */
  }
}

document.addEventListener('DOMContentLoaded', init);
