/**
 * 突破：diff_maps 发现 signRequest 首调新增 8 段全部紧贴 liby 基址区：
 *   0x7cb2784000  284KB  r-x   ← 与 report/11 base=0x7cb2783000 相邻！(base+0x1000)
 *   0x7cb27cb000   24KB  rw-
 *   0x7cb27d1000    4KB  r-x
 *   0x7cb27d2000   60KB  r-x   ← base+0x4f000
 *   0x7cb27e1000   12KB  r-x
 *   0x7cb27e4000   16KB  ---
 *   0x7cb27e8000   92KB  rw-
 *   0x7cb2f73000  128KB  rw-
 * 也就是说 signRequest 的实现**就在 liby 映射内**（之前 hook 0 命中是地址算错了）。
 *
 * 本脚本：对这些段做**函数级全量 hook**：
 *   1. 以 4 字节对齐扫描所有 5 种 AArch64 函数序言 → 得到入口集合
 *   2. Interceptor.attach 全部（分段，r-x 段数百个可以接受）
 *   3. 调 signRequest → 记录哪些函数被触发、参数（尝试按 std::string 解析）
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

// AArch64 函数序言（覆盖绝大多数编译器输出）
const PROLOGUES = [
  'fd 7b bf a9',      // stp x29, x30, [sp, #-0x10]!
  'fd 7b 01 a9',      // stp x29, x30, [sp, #0x10]
  'ff 03 01 d1',      // sub sp, sp, #0x40
  'ff 83 00 d1',      // sub sp, sp, #0x20
  'ff 43 00 d1',      // sub sp, sp, #0x10
  'ff c3 00 d1',      // sub sp, sp, #0x30
  'f6 57 bf a9',      // stp x22, x21, [sp, #-0x10]!
  'f6 57 bd a9',      // stp x22, x21, [sp, #-0x30]!
  'f4 4f bf a9',      // stp x20, x19, [sp, #-0x10]!
  'fd 03 00 aa',      // mov x29, sp
];

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
        Java.use('com.huachenjie.c.HcjNative').signRequest('{"warm":1}', 0);
      } catch (e) {}

      base = findBase();
      if (!base) { s('✗ 未定位基址'); return; }
      s('★ base = ' + base);

      // 目标段（相对 base 偏移）
      const SEGS = [
        [0x1000,  0x47000],  // 284KB r-x 主代码
        [0x4e000, 0x5d000],  // 60KB r-x
        [0x5e000, 0x61000],  // 12KB r-x
      ];
      let found = [];
      SEGS.forEach(function (sg) {
        const LO = sg[0], HI = sg[1];
        PROLOGUES.forEach(function (pat) {
          try {
            const r = Memory.scanSync(base.add(LO), HI - LO, pat);
            r.forEach(function (m) {
              const o = m.address.sub(base).toInt32();
              if (o % 4 === 0) found.push(o);
            });
          } catch (e) {}
        });
      });
      found = Array.from(new Set(found)).sort(function (x, y) { return x - y; });
      s('  序言候选: ' + found.length);

      let ok = 0;
      found.forEach(function (o) {
        try {
          Interceptor.attach(base.add(o), {
            onEnter: function (args) {
              hits[o] = (hits[o] || 0) + 1;
            }
          });
          ok++;
        } catch (e) {}
      });
      s('  已 hook: ' + ok);

      s('');
      s('════ 调用 signRequest {"probe":1} ════');
      try {
        const out = String(Java.use('com.huachenjie.c.HcjNative').signRequest('{"probe":1}', 0));
        s('  out: ' + out.substring(0, 44));
      } catch (e) { s('  err: ' + e); }

      s('');
      s('════ 触发统计（按频次）════');
      const ks = Object.keys(hits).sort(function (x, y) { return hits[y] - hits[x]; });
      if (!ks.length) s('  （无）');
      ks.forEach(function (k) {
        s('    +0x' + Number(k).toString(16) + '  ×' + hits[k]);
      });
      send({ t: 'hits', base: base.toString(), hits: hits });
    });
  }
});
s('[boot] 全量序言 hook 就绪');
