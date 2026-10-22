/**
 * 用「@FastNative/@CriticalNative 入口扫描」定位 signRequest 的 JNI 函数地址。
 *
 * 前次失败：
 *   · env.findClass 走 boot loader
 *   · meth.$handle 为 undefined（Frida 17）
 *   · env.getStaticMethodId 需要 JNI handle 而非 Frida 包装
 *
 * 本次改用**最可靠**的路径：hook `art::JNI::GetStaticMethodID` 的原生实现，
 * 它在 libart 里是导出符号（我们已在 report/09 用过类似的 vaddr 定位）。
 * 或者更简单：**在 signRequest 被调用时，通过返回地址反查**。
 *
 * 最终方案（本脚本）：利用「所有 JNI 方法都从同一处跳转」的特性 ——
 * hook libart 里处理 JNI 调用的关键函数，抓 (ArtMethod*, 参数) 对。
 *
 * 但最直接的是：**在 liby.so 的映射范围内穷举 hook 每个 4 字节对齐的地址**
 * 是不现实的。改用：**对 liby 范围内所有「函数序言模式」下 hook**。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const SIG = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840b9';
const SIG_VADDR = 0x5b5f0;
const ANCHORS = [
  ['/proc/self/maps', 0x5f780],
  ['LD_PRELOAD',      0x5f7d8],
  ['dl_iterate_phdr', 0x5f860],
];
function pattern(str) {
  let o = [];
  for (let i = 0; i < str.length; i++) o.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  return o.join(' ');
}
function verifyBase(b) {
  try {
    const p = b.add(SIG_VADDR), n = SIG.length / 2;
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h === SIG;
  } catch (e) { return false; }
}
function findBase() {
  for (let i = 0; i < ANCHORS.length; i++) {
    const nm = ANCHORS[i][0], va = ANCHORS[i][1], pat = pattern(nm);
    let rs = [];
    try { rs = Process.enumerateRanges('r--'); } catch (e) { break; }
    for (let j = 0; j < rs.length; j++) {
      const r = rs[j];
      if (r.size < nm.length || r.size > 64*1024*1024) continue;
      let hits = null;
      try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { continue; }
      if (!hits) continue;
      for (let k = 0; k < hits.length; k++) {
        const b = hits[k].address.sub(va);
        if (verifyBase(b)) return b;
      }
    }
  }
  return null;
}

// AArch64 函数序言模式
const PROLOGUES = [
  'fd 7b bf a9',      // stp x29, x30, [sp, #-0x10]!
  'fd 7b 01 a9',      // stp x29, x30, [sp, #-0x10]!  (变体)
  'ff 83 00 d1',      // sub sp, sp, #0x20
  'ff 43 00 d1',      // sub sp, sp, #0x10
  'ff c3 00 d1',      // sub sp, sp, #0x30
  'f5 0b 00 f9',      // str x21, [sp, #0x10]
  'fd 03 00 aa',      // mov x29, sp
  'f6 57 bd a9',      // stp x22, x21, [sp, #-0x30]!
];

const hooked = {};
const hits = {};
let base = null;
let fired = false;
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        N.signRequest('{"probe":1}', 0);
        s('native 已加载');
      } catch (e) {}

      base = findBase();
      if (!base) { s('✗ 未定位基址'); return; }
      s('★ 基址 = ' + base);

      // 把 liby 范围按 4 字节对齐扫描序言
      const LO = 0, HI = 0x72000;
      let found = [];
      for (let pat of PROLOGUES) {
        let off = LO;
        while (off < HI) {
          let r = null;
          try { r = Memory.scanSync(base.add(off), HI - off, pat); } catch (e) { break; }
          if (!r || !r.length) break;
          r.forEach(function (m) {
            const o = m.address.sub(base);
            // 只要 4 字节对齐的
            if (o.toInt32() % 4 === 0) found.push(o.toInt32());
          });
          off = r[r.length - 1].address.sub(base).toInt32() + 4;
        }
      }
      // 去重排序
      found = Array.from(new Set(found)).sort(function (x, y) { return x - y; });
      s('  扫描到 ' + found.length + ' 个候选函数入口');

      // 只 hook 前 N 个（太多会拖慢）
      const MAX = 400;
      const sel = found.slice(0, MAX);
      s('  对前 ' + sel.length + ' 个下 hook');

      let ok = 0;
      sel.forEach(function (o) {
        if (hooked[o]) return;
        hooked[o] = 1;
        try {
          Interceptor.attach(base.add(o), {
            onEnter: function () {
              const k = '0x' + o.toString(16);
              hits[k] = (hits[k] || 0) + 1;
            }
          });
          ok++;
        } catch (e) {}
      });
      s('  已装 ' + ok + ' 个');

      s('');
      s('════ 调用 signRequest ════');
      try {
        const N2 = Java.use('com.huachenjie.c.HcjNative');
        const out = String(N2.signRequest('{"probe":1}', 0));
        s('  结果: ' + out.substring(0, 40) + '...');
      } catch (e) { s('  失败: ' + e); }

      s('');
      s('════ 被触发的地址（liby 内）════');
      const ks = Object.keys(hits).sort(function (x, y) { return hits[y] - hits[x]; });
      if (!ks.length) s('  （无）');
      ks.slice(0, 40).forEach(function (k) {
        let extra = '';
        try {
          const by = new Uint8Array(base.add(parseInt(k, 16)).readByteArray(16));
          let h = ''; for (let i = 0; i < 16; i++) h += ('0' + by[i].toString(16)).slice(-2);
          extra = '  ' + h;
        } catch (e) {}
        s('    ' + k + '  ×' + hits[k] + extra);
      });
      send({ t: 'hits', base: base.toString(), hits: hits });
    });
  }
});
s('[boot] 序言扫描追踪就绪');
