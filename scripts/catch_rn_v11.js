/**
 * v11：RegisterNatives 捕获（修正时机）。
 *
 * v10 结果分析：
 *   · ✅ vtable[215] 拿到 RegisterNatives = libart+0x106860，校准成功
 *   · ❌ 同步 probe 太早（com.huachenjie.c.HcjNative 尚未加载）
 *   → 需用 DefineClass 钩子等到应用类真正加载后再收网
 *
 * 本法：
 *   ① 顶层装 RegisterNatives hook（尽早）
 *   ② DefineClass 钩子在 HcjNative 被定义时打标记
 *   ③ 之后立即触发 signRequest，收集本轮及之前所有注册名
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function locate(addr) {
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) return r.protection + ' ' + (r.file ? r.file.path : '[anon]') +
      ' @' + r.base + '+0x' + addr.sub(r.base).toString(16);
  } catch (e) {}
  return '?';
}
function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

const batches = [];      // {n, names:[], target:{}}
let rnHookOK = false;

// ══ ① 尽早装 RegisterNatives hook（顶层同步） ══
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
          const rec = { n: count, names: [], target: null };
          for (let i = 0; i < count; i++) {
            const e2 = methods.add(i * 24);
            let nm = '';
            try { nm = e2.readCString() || ''; } catch (err) { continue; }
            if (nm) rec.names.push(nm);
            if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams') {
              let sig = '', fn = null;
              try { sig = e2.add(8).readPointer().readCString(); } catch (err) {}
              try { fn = e2.add(16).readPointer(); } catch (err) {}
              rec.target = {
                name: nm, sig: sig, fn: fn ? String(fn) : null,
                loc: fn ? locate(fn) : '?', bytes: fn ? hex(fn, 32) : null
              };
              s('════════ ★★★ 命中 ' + nm + ' ★★★ ════════');
              s('  sig  = ' + sig);
              s('  fn   = ' + fn + '   ' + (fn ? locate(fn) : ''));
              s('  bytes= ' + rec.target.bytes);
              send({ t: 'TARGET', target: rec.target });
            }
          }
          batches.push(rec);
          s('[RN] 批次#' + batches.length + '  ' + count + ' 个方法');
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    rnHookOK = true;
    s('[A] RegisterNatives hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

// ══ ② DefineClass 钩子：等 HcjNative 出现 ══
let fired = false;
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d) return;
    // 命中 HcjNative 或任意 huachenjie 类
    if (d.indexOf('Lcom/huachenjie/c/HcjNative;') === 0) {
      s('[DC] ★ 捕获 HcjNative 定义');
    }
    if (d.indexOf('Lcom/huachenjie/') !== 0) return;
    if (fired) return;
    fired = true;
    s('[DC] 首个应用类: ' + d);

    Java.perform(function () {
      // ③ 触发 native 注册完成
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('[probe] ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24));
      } catch (e) { s('[probe] err: ' + String(e).substring(0, 80)); }

      // ④ 汇总
      s('');
      s('════ 注册批次汇总 ════');
      let allNames = [];
      batches.forEach(function (b, i) {
        s('  批次#' + (i + 1) + '  ' + b.n + ' 个: ' + b.names.slice(0, 12).join(',') +
          (b.names.length > 12 ? ' …' : ''));
        allNames = allNames.concat(b.names);
      });
      const uniq = Array.from(new Set(allNames));
      s('');
      s('  去重总计 ' + uniq.length + ' 个方法名');
      s('  ' + uniq.join(', '));
      send({ t: 'ALL', batches: batches.length, uniq: uniq });

      if (!batches.length) s('  ⚠ 未捕获任何注册批次（可能注册发生在 hook 之前）');
    });
  }
});
s('[boot] v11 就绪（RN hook=' + rnHookOK + '）');
