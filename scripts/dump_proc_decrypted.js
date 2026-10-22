/**
 * dump liby.so 运行时已解密的 `.note.gnu.proc` 代码区（140 KB）。
 *
 * 依据（report/11 §6.1d + 本轮实测）：
 *   磁盘 base+0x23000:  a1 00 00 00 a1 00 00 00 ...   ← 加密填充
 *   运行时 base+0x23000: d6 02 80 52 08 00 00 14 ...   ← ★ 已解密为真实代码
 *   ⇒ 自定义 linker 在加载时解密了该区
 *
 * 本脚本：定位 base → 分片 dump base+0x1000 .. base+0x47000（含数据表与代码）
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
  return null;
}

// 分段 dump：避开单次 send 上限
const CHUNK = 0x8000;   // 32 KB
const LO = 0x1000;      // 从 first LOAD 内开始
const HI = 0x47000;     // 到 .note.gnu.text 之前

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
      // 触发加载
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        N.signRequest('{"probe":1}', 0);
        N.encodeRun('a','b','c','d',0);
        s('native 已加载并调用');
      } catch (e) { s('触发失败: ' + e); }

      const base = findBase();
      if (!base) { s('✗ 未定位基址'); return; }
      s('★ liby.so 基址 = ' + base);
      send({ t: 'base', base: base.toString() });

      // ── dump first LOAD 段（0x1000 .. 0x47000）──
      s('');
      s('════ dump 第一个 LOAD 段（含解密后的代码区）════');
      const total = HI - LO;
      const n = Math.ceil(total / CHUNK);
      s('  范围 ' + (LO/1024) + 'KB .. ' + (HI/1024) + 'KB   共 ' +
        (total/1024).toFixed(0) + ' KB，分 ' + n + ' 片');
      let ok = 0;
      for (let i = 0; i < n; i++) {
        const off = LO + i * CHUNK;
        const sz = Math.min(CHUNK, HI - off);
        let data = null;
        try { data = base.add(off).readByteArray(sz); } catch (e) { continue; }
        if (data) {
          send({ t: 'chunk', off: off, size: sz, part: i, total: n }, data);
          ok++;
        }
      }
      s('  已发送 ' + ok + '/' + n + ' 片');

      // ── 同时 dump 代码段（.note.gnu.text）与解码表 ──
      ['0x4e040:0x20000', '0x64af8:0x2360'].forEach(function (spec) {
        const parts = spec.split(':');
        const a0 = parseInt(parts[0], 16), sz = parseInt(parts[1], 16);
        let data = null;
        try { data = base.add(a0).readByteArray(sz); } catch (e) { return; }
        if (data) {
          send({ t: 'extra', addr: a0, size: sz, tag: a0 === 0x4e040 ? 'text' : 'content' }, data);
          s('  已发送额外段 ' + parts[0] + ' (' + (sz/1024) + 'KB)');
        }
      });
      s('════ dump 完成 ════');
    });
  }
});
s('[boot] proc 段 dump 就绪');
