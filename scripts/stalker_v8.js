/**
 * v8：Stalker 全地址追踪 —— 筛出所有「不属于系统库」的执行块。
 *
 * 前版错误：classify 只匹配 libnesec.so（findModuleByName 找不到 liby.so，
 * 尽管 enumerateRanges 能看到它的 3 个 r-x 映射）。
 *
 * 本版不再依赖模块名，改为：
 *   ① 收集所有「系统库范围」（/system、/apex、libart、libc、libc++、jit-cache）
 *   ② Stalker transform 记录每个 block 首地址
 *   ③ 报告所有**不在**系统库范围内的执行地址（去重、按频次排序）
 *      → 这些就是目标实现所在位置
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const seen = {};        // addr -> count（非系统库）
const sysRanges = [];   // 系统库/框架范围

function collectSys() {
  let n = 0;
  try {
    Process.enumerateRanges('r-x').forEach(function (r) {
      const p = r.file ? r.file.path : '';
      const isSys = (p.indexOf('/system/') >= 0 || p.indexOf('/apex/') >= 0 ||
                     p.indexOf('/vendor/') >= 0 || p.indexOf('/data/dalvik-cache') >= 0 ||
                     p.indexOf('odex') >= 0 || p.indexOf('vdex') >= 0 || p.indexOf('oat') >= 0 ||
                     p.indexOf('libart') >= 0 || p.indexOf('frida') >= 0 ||
                     p.indexOf('/dev/ashmem') >= 0);
      sysRanges.push({ base: r.base, hi: r.base.add(r.size), sys: isSys, path: p });
      n++;
    });
  } catch (e) {}
  s('  r-x 段总数: ' + n + '，其中系统库 ' + sysRanges.filter(function (x) { return x.sys; }).length);
}
function isSys(addr) {
  for (let i = 0; i < sysRanges.length; i++) {
    const r = sysRanges[i];
    if (addr.compare(r.base) >= 0 && addr.compare(r.hi) < 0) return r.sys ? true : false;
  }
  return true;   // 未收录 → 当系统处理（避免噪声）
}

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;
let stalking = false;
const THREADS = [];

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      const H = Java.use('com.huachenjie.c.HcjNative');
      try { s('warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20)); } catch (e) {}
      collectSys();

      s('');
      s('════ 启动 Stalker（当前线程 + 后续线程）════');
      try {
        const tid = Process.getCurrentThreadId();
        THREADS.push(tid);
        Stalker.follow(tid, {
          events: { call: false, ret: false, exec: false, block: false, compile: true },
          transform: function (iterator) {
            let ins = iterator.next();
            if (ins === null) return;
            const a2 = ins.address;
            if (isSys(a2)) return;
            const k = a2.toString();
            seen[k] = (seen[k] || 0) + 1;
          }
        });
        stalking = true;
        s('  ✓ 已 follow tid=' + tid);
      } catch (e) { s('  启动失败: ' + e); }

      s('');
      s('  调 signRequest ...');
      try {
        const out = String(H.signRequest('{"probe":1}', 0));
        s('  out: ' + out.substring(0, 44));
      } catch (e) { s('  err: ' + e); }

      // 同步停止
      if (stalking) {
        THREADS.forEach(function (t) { try { Stalker.unfollow(t); } catch (e) {} });
        try { Stalker.flush(); } catch (e) {}
        stalking = false;
        s('  ✓ 已停止');
      }

      s('');
      s('════ 非系统库执行地址 ════');
      const ks = Object.keys(seen).sort(function (x, y) { return seen[y] - seen[x]; });
      if (!ks.length) {
        s('  （无）');
      } else {
        ks.slice(0, 80).forEach(function (k) {
          const a3 = ptr(k);
          let rng = '?';
          try {
            const r = Process.findRangeByAddress(a3);
            if (r) rng = (r.file ? r.file.path.split('/').pop() : '[anon]') +
              '@' + r.base + '+0x' + a3.sub(r.base).toString(16);
          } catch (e) {}
          s('  ' + k + '  ×' + seen[k] + '  ' + rng);
        });
      }
      send({ t: 'exec', addrs: seen, total: ks.length });

      // dump 最高频地址所在段
      if (ks.length) {
        try {
          const top = ptr(ks[0]);
          const r = Process.findRangeByAddress(top);
          if (r) {
            const total = Math.min(r.size, 512 * 1024);
            send({ t: 'dumpmeta', base: String(r.base), size: total });
            s('dump ' + r.base + ' size=' + total);
            const CHUNK = 200 * 1024;
            for (let off = 0; off < total; off += CHUNK) {
              const sz = Math.min(CHUNK, total - off);
              send({ t: 'chunk', off: off, size: sz }, r.base.add(off).readByteArray(sz));
            }
          }
        } catch (e) { s('  dump err: ' + e); }
      }
    });
  }
});
s('[boot] v8 全地址 Stalker 就绪');
