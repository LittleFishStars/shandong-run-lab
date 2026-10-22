/**
 * 终极一步：用已验证的 liby.so 运行时基址，hook 真实代码段的所有函数，
 * 定位 signRequest 的实现，并抓取其内部数据流。
 *
 * 已确认（report/11）：
 *   基址 = 0x7cb2780000（32/32 字节签名匹配，每次运行不同需重算）
 *   代码段 = base + 0x4e040   (r-x)
 *   函数 FUN_0005b5f0 = base + 0x5b5f0  ← 位流解码器（最大函数）
 *
 * 策略：
 *   ① 用锚点签名重算基址（ASLR 每次不同）
 *   ② 在代码段内的所有「函数入口」下 hook（用 Ghidra 导出的入口列表）
 *   ③ 调用 signRequest，观察哪些函数被触发 → 得到调用链
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

// 磁盘签名（file 0x545f0 = vaddr 0x5b5f0，32 字节）
const SIG = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840b9';
const SIG_VADDR = 0x5b5f0;

// 锚点（用于快速定位）
const ANCHORS = [
  ['/proc/self/maps',   0x5f780],
  ['LD_PRELOAD',        0x5f7d8],
  ['dl_iterate_phdr',   0x5f860],
];

function pattern(str) {
  let out = [];
  for (let i = 0; i < str.length; i++) out.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  return out.join(' ');
}

function verify(b) {
  try {
    const p = b.add(SIG_VADDR);
    const n = SIG.length / 2;
    const bytes = new Uint8Array(p.readByteArray(n));
    let hex = '';
    for (let i = 0; i < n; i++) hex += ('0' + bytes[i].toString(16)).slice(-2);
    return hex === SIG;
  } catch (e) { return false; }
}

function findBase() {
  // 方式 A：锚点
  for (let i = 0; i < ANCHORS.length; i++) {
    const name = ANCHORS[i][0], va = ANCHORS[i][1];
    const pat = pattern(name);
    let ranges = [];
    try { ranges = Process.enumerateRanges('r--'); } catch (e) { break; }
    for (let j = 0; j < ranges.length; j++) {
      const r = ranges[j];
      if (r.size < name.length || r.size > 64 * 1024 * 1024) continue;
      let hits = null;
      try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { continue; }
      if (!hits) continue;
      for (let k = 0; k < hits.length; k++) {
        const b = hits[k].address.sub(va);
        if (verify(b)) return b;
      }
    }
  }
  // 方式 B：直接搜代码签名
  const sp = SIG.match(/../g).join(' ');
  let ranges = [];
  try { ranges = Process.enumerateRanges('r-x'); } catch (e) { return null; }
  for (let j = 0; j < ranges.length; j++) {
    const r = ranges[j];
    if (r.size < 64 || r.size > 64 * 1024 * 1024) continue;
    let hits = null;
    try { hits = Memory.scanSync(r.base, r.size, sp); } catch (e) { continue; }
    if (hits && hits.length) {
      for (let k = 0; k < hits.length; k++) {
        const b = hits[k].address.sub(SIG_VADDR);
        if (verify(b)) return b;
      }
    }
  }
  return null;
}

// ── 代码段内的函数入口（vaddr 列表，来自 Ghidra 的 73 个函数）──
const FUNCS = [0x4f390, 0x4f430, 0x4f460, 0x4f4b0, 0x51014, 0x51220, 0x512f4, 0x512fc, 0x51314, 0x51480, 0x516d0, 0x51740, 0x51790, 0x5181c, 0x51fb0, 0x520f0, 0x522cc, 0x523a0, 0x5241c, 0x52494, 0x524c8, 0x52540, 0x525fc, 0x526f8, 0x53780, 0x53f08, 0x54058, 0x54248, 0x5425c, 0x5442c, 0x54550, 0x545c4, 0x554ec, 0x555f0, 0x55760, 0x55930, 0x55948, 0x55980, 0x55aac, 0x55c0c, 0x56330, 0x56a94, 0x56ab8, 0x56b00, 0x580a4, 0x58240, 0x58568, 0x585f4, 0x58658, 0x58de4, 0x595a8, 0x595b0, 0x59628, 0x59710, 0x5982c, 0x598a8, 0x59928, 0x599d8, 0x59a68, 0x59a90, 0x59b44, 0x59b88, 0x59bd4, 0x59c14, 0x59c24, 0x59c34, 0x59f44, 0x5adec, 0x5ae48, 0x5b5c8, 0x5b5f0, 0x5d204];

let base = null;
const hits = {};

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
      // 先触发加载
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        N.signRequest('{"probe":1}', 0);
        s('native 已加载');
      } catch (e) { s('触发失败: ' + e); }

      base = findBase();
      if (!base) { s('✗ 未定位基址'); return; }
      s('★★ liby.so 基址 = ' + base);
      send({ t: 'base', base: base.toString() });

      // 在代码段所有函数入口装 hook
      s('');
      s('════ 在 ' + FUNCS.length + ' 个函数入口装 hook ════');
      let ok = 0;
      FUNCS.forEach(function (va) {
        try {
          Interceptor.attach(base.add(va), {
            onEnter: function () {
              const k = va.toString(16);
              hits[k] = (hits[k] || 0) + 1;
            }
          });
          ok++;
        } catch (e) {}
      });
      s('  已装 ' + ok + ' 个');

      // 调用 signRequest 观察触发
      s('');
      s('════ 调用 signRequest，观察触发的函数 ════');
      try {
        const N2 = Java.use('com.huachenjie.c.HcjNative');
        const out = String(N2.signRequest('{"probe":1}', 0));
        s('  结果: ' + out.substring(0, 40) + '...');
      } catch (e) { s('  调用失败: ' + e); }

      s('');
      s('  ── 被触发的函数 ──');
      const keys = Object.keys(hits).sort(function (x, y) { return hits[y] - hits[x]; });
      if (!keys.length) s('    （无）');
      keys.forEach(function (k) {
        s('    +0x' + k + '  ×' + hits[k]);
      });
      send({ t: 'hits', base: base.toString(), hits: hits });
    });
  }
});
s('[boot] liby 函数追踪就绪');
