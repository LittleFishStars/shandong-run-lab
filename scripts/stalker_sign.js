/**
 * 暴力定位 signRequest 的实现地址。
 *
 * 现状（报告 11 + 本轮）：
 *   · liby.so 基址可精确定位（锚点+签名双验证）
 *   · 但 160 KB 代码区（248 函数）+ 候选 JSON 函数全部未触发
 *   ⇒ 实现可能在：
 *       (a) 低熵数据区（0x19000-0x23000）被当作代码执行
 *       (b) .note.gnu.text（72 KB，那个 FSE 解码器所在段）
 *       (c) 运行时新生成的 JIT 页
 *
 * 方法：**Stalker 追踪** —— 这是唯一能覆盖「任意地址被执行」的手段。
 *   用 Stalker.follow 跟随调用 signRequest 的线程，记录其执行的所有基本块，
 *   过滤出落在 liby.so 映射范围内的地址。
 *
 * Stalker 比逐地址 hook 可靠：无需预知入口，且能捕获间接调用/跳转。
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

let base = null;
const seenBlocks = {};       // liby 范围外的执行地址
const libyBlocks = {};       // ★ liby 范围内的执行地址
let stalking = false;

function hexOf(a, n) {
  try {
    const by = new Uint8Array(a.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

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
      send({ t: 'base', base: base.toString() });

      // liby.so 的映射范围：base .. base+0x72000
      const LIBY_LO = base;
      const LIBY_HI = base.add(0x72000);

      s('');
      s('════ 启动 Stalker 追踪 ════');
      s('  监听 liby 范围: ' + LIBY_LO + ' .. ' + LIBY_HI);

      const tid = Process.getCurrentThreadId();
      s('  当前线程 tid=' + tid);

      try {
        Stalker.follow(tid, {
          onReceive: function (events) {
            // exec 事件：每个被执行的基本块
            const n = events.length / 8;
            for (let i = 0; i < n; i++) {
              const lo = events.readU32 ? null : null;
            }
          },
          // ★ onCallSummary：每次调用汇总，同步回调（不依赖 setTimeout）
          onCallSummary: function (summary) {
            Object.keys(summary).forEach(function (tgt) {
              const a = ptr(tgt);
              if (a.compare(LIBY_LO) >= 0 && a.compare(LIBY_HI) < 0) {
                const off = a.sub(LIBY_LO);
                const k = '0x' + off.toString(16);
                libyBlocks[k] = (libyBlocks[k] || 0) + summary[tgt];
              }
            });
          },
          events: { call: true, ret: false, exec: false, block: false, compile: false },
          // 记录所有被执行的基本块（exec 事件流）
          transform: function (iterator) {
            let ins = iterator.next();
            if (ins === null) return;
            const addr = ins.address;
            if (addr.compare(LIBY_LO) >= 0 && addr.compare(LIBY_HI) < 0) {
              const off = addr.sub(LIBY_LO);
              const k = '0x' + off.toString(16);
              libyBlocks[k] = (libyBlocks[k] || 0) + 1;
            }
          }
        });
        stalking = true;
        s('  ✓ Stalker 已启动（transform 模式）');
      } catch (e) { s('  Stalker 启动失败: ' + e); }

      // 触发调用
      s('');
      s('════ 在 Stalker 下调用 signRequest ════');
      try {
        const N2 = Java.use('com.huachenjie.c.HcjNative');
        const out = String(N2.signRequest('{"probe":1}', 0));
        s('  结果: ' + out.substring(0, 40) + '...');
      } catch (e) { s('  失败: ' + e); }

      // ★ 同步汇总（不用 setTimeout —— Frida QuickJS 在 native 回调里不可靠）
      (function () {
        try { if (stalking) Stalker.unfollow(tid); } catch (e) {}
        try { Stalker.flush(); } catch (e) {}
        s('');
        s('════ Stalker 结果：liby 范围内执行的块 ════');
        const ks = Object.keys(libyBlocks);
        s('  共 ' + ks.length + ' 个不同地址');
        ks.sort(function (x, y) {
          return parseInt(y, 16) - parseInt(x, 16);
        }).slice(0, 60).forEach(function (k) {
          const addr = LIBY_LO.add(parseInt(k, 16));
          let extra = '';
          const h = hexOf(addr, 16);
          if (h) extra = '  ' + h;
          s('    ' + k + '  ×' + libyBlocks[k] + extra);
        });
        send({ t: 'blocks', base: base.toString(), blocks: libyBlocks });
      })();
    });
  }
});
s('[boot] Stalker 追踪就绪');
