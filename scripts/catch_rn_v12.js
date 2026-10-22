/**
 * v12：绕开加密的方法名 —— 用**函数指针**定位 signRequest。
 *
 * v11 关键发现：
 *   · ✓ vtable[215] RegisterNatives hook 完全成功，捕获 11 个批次
 *   · ✗ 方法名被壳加密（读出来是乱码 y8�� 等），无法按名匹配
 *   · 批次#1 = 11 个方法（对应 report/02 分析的壳的 11 个 native）
 *
 * 新思路：名字不可信，但 **fnPtr 真实可读**。
 *   ① 收集所有批次的 (idx, name?, sig?, fnPtr)
 *   ② 对每个 fnPtr 求 locate，筛出落在「非系统库」的
 *   ③ 对筛选出的指针**逐个 hook**，验证哪个是 signRequest
 *      （hook 全装 + 调用一次 signRequest，命中的即目标）
 *   ④ 报告命中者的 fnPtr / 归属 / 32 字节
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function locate(addr) {
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) return r.protection + ' ' + (r.file ? r.file.path.split('/').pop() : '[anon]') +
      '@' + r.base + '+0x' + addr.sub(r.base).toString(16);
  } catch (e) {}
  return '?';
}
function isSys(addr) {
  try {
    const r = Process.findRangeByAddress(addr);
    if (!r) return true;
    const p = r.file ? r.file.path : '';
    if (!p) return false;                        // 匿名段 → 非系统
    return p.indexOf('/system/') >= 0 || p.indexOf('/apex/') >= 0 ||
           p.indexOf('/vendor/') >= 0 || p.indexOf('libart') >= 0 ||
           p.indexOf('libc') >= 0 || p.indexOf('frida') >= 0;
  } catch (e) { return true; }
}
function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

const records = [];        // {batch, idx, name, sig, fn}
let batches = 0;

Java.perform(function () {
  let table = null;
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    const ver = gv(table) >>> 0;
    s('[cal] GetVersion=0x' + ver.toString(16));
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败'); return; }
  } catch (e) { s('[cal] err: ' + e); return; }

  try {
    const rn = table.add(215 * 8).readPointer();
    Interceptor.attach(rn, {
      onEnter: function (a) {
        try {
          const methods = a[2], count = a[3].toInt32();
          if (count <= 0 || count > 500) return;
          batches++;
          for (let i = 0; i < count; i++) {
            const e2 = methods.add(i * 24);
            let nm = '', sig = '', fn = null;
            try { nm = e2.readCString() || ''; } catch (err) {}
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) {}
            try { fn = e2.add(16).readPointer(); } catch (err) {}
            records.push({ batch: batches, idx: i, name: nm, sig: sig,
                           fn: fn && !fn.isNull() ? fn : null });
          }
          s('[RN] 批次#' + batches + '  ' + count + ' 个方法   累计 ' + records.length);
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RegisterNatives hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

// DefineClass 触发点：等到 HcjNative 之后仍继续收集，最后统一收网
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let phase2 = false;

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (phase2) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    phase2 = true;
    s('[DC] 触发: ' + d);

    Java.perform(function () {
      // 触发 HcjNative 加载
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('[probe] ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24));
      } catch (e) { s('[probe] err: ' + String(e).substring(0, 90)); }

      // ── ① 汇总所有记录 ──
      s('');
      s('════ 全部注册记录 ════');
      s('  批次总数 ' + batches + '，方法总数 ' + records.length);
      records.forEach(function (r) {
        const loc = r.fn ? locate(r.fn) : '(null)';
        const isS = r.fn ? isSys(r.fn) : true;
        s('  #' + r.batch + '.' + r.idx + '  name=' + JSON.stringify(r.name.substring(0, 24)) +
          '  sig=' + JSON.stringify(r.sig.substring(0, 40)) + '  fn=' + r.fn +
          (isS ? '' : '  ★非系统') + '  ' + loc);
      });

      // ── ② 筛出非系统库的 fnPtr ──
      const targets = [];
      const seen = {};
      records.forEach(function (r) {
        if (!r.fn || isSys(r.fn)) return;
        const k = r.fn.toString();
        if (seen[k]) return;
        seen[k] = 1;
        targets.push(r);
      });
      s('');
      s('════ 非系统库的 fnPtr: ' + targets.length + ' 个 ════');
      targets.forEach(function (r) { s('  ' + r.fn + '  ' + locate(r.fn) + '  bytes=' + hex(r.fn, 16)); });

      // ── ③ 逐个 hook 验证 ──
      const hitList = [];
      targets.forEach(function (r) {
        try {
          const o = { n: 0 };
          Interceptor.attach(r.fn, { onEnter: function () { o.n++; } });
          r._ctr = o;
        } catch (e) {}
      });
      s('');
      s('  已 hook ' + targets.filter(function (t) { return t._ctr; }).length + ' 个候选，调 signRequest ...');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        ['{"probe":11}', '{}'].forEach(function (inp) {
          const out = String(H2.signRequest(inp, 0));
          s('  ' + inp + ' → ' + out.substring(0, 36));
        });
      } catch (e) { s('  调用 err: ' + e); }

      s('');
      s('════ 命中验证 ════');
      targets.forEach(function (r) {
        if (r._ctr && r._ctr.n > 0) {
          hitList.push(r);
          s('  ★★★ 命中! fn=' + r.fn + '  ×' + r._ctr.n + '  批#' + r.batch + '.' + r.idx);
          s('       name=' + JSON.stringify(r.name) + '  sig=' + JSON.stringify(r.sig));
          s('       归属=' + locate(r.fn));
          s('       bytes=' + hex(r.fn, 32));
        }
      });
      if (!hitList.length) s('  （无命中）');
      send({ t: 'DONE', batches: batches, total: records.length,
             targets: targets.length,
             hits: hitList.map(function (r) {
               return { fn: String(r.fn), batch: r.batch, idx: r.idx,
                        name: r.name, sig: r.sig, loc: locate(r.fn), bytes: hex(r.fn, 32) };
             }),
             all: records.map(function (r) {
               return { b: r.batch, i: r.idx, nm: r.name, sg: r.sig,
                        fn: r.fn ? String(r.fn) : null,
                        sys: r.fn ? isSys(r.fn) : true };
             })});

      // ── ④ dump 命中者所在段 ──
      if (hitList.length) {
        try {
          const r0 = Process.findRangeByAddress(hitList[0].fn);
          if (r0) {
            const total = Math.min(r0.size, 512 * 1024);
            send({ t: 'dumpmeta', base: String(r0.base), size: total });
            s('dump ' + r0.base + ' size=' + total);
            const CHUNK = 200 * 1024;
            for (let off = 0; off < total; off += CHUNK) {
              const sz = Math.min(CHUNK, total - off);
              send({ t: 'chunk', off: off, size: sz }, r0.base.add(off).readByteArray(sz));
            }
          }
        } catch (e) { s('  dump err: ' + e); }
      }
    });
  }
});
s('[boot] v12 就绪');
