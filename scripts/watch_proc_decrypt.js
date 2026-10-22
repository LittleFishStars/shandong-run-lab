/**
 * 对 `.note.gnu.proc` 的加密代码区下硬件内存断点，抓取解密时机与明文。
 *
 * 依据（report/11 §6.1d）：
 *   liby.so 基址 base（用签名校验得到）
 *   加密代码区 = base + 0x23000 .. base + 0x46000  (140 KB)
 *   该区在磁盘上熵 5.8-7.0（部分加密），运行时必然被解密
 *
 * 策略：
 *   ① 定位 base
 *   ② 用 MemoryAccessMonitor 监控该区（读/写）
 *   ③ 触发 signRequest
 *   ④ 记录首次访问的时机 → 即解密完成点
 *   ⑤ 在解密后 dump 该区
 *
 * 注意：MemoryAccessMonitor 会在**访问瞬间**回调，是最准的时机捕获手段。
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

// 加密代码区（相对 base）
const PROC_LO = 0x23000, PROC_HI = 0x46000;
// 低熵数据区
const DATA_LO = 0x14000, DATA_HI = 0x23000;

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

function hexOf(addr, len) {
  try {
    const bytes = new Uint8Array(addr.readByteArray(len));
    let hex = '';
    for (let i = 0; i < len; i++) hex += ('0' + bytes[i].toString(16)).slice(-2);
    return hex;
  } catch (e) { return null; }
}

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

      // ── 先对比磁盘与运行时的加密区 ──
      s('');
      s('════ 磁盘 vs 运行时（加密代码区 前 64 字节）════');
      const procAddr = base.add(PROC_LO);
      const rtHex = hexOf(procAddr, 64);
      if (rtHex) {
        s('  运行时: ' + rtHex);
        s('  （磁盘值见宿主输出的 proc 段 0x23000 处）');
        send({ t: 'runtime', addr: procAddr.toString(), hex: rtHex });
      } else {
        s('  读取失败');
      }

      // ── 检查该区是否已被解密（熵/可打印性）──
      s('');
      s('════ 加密区可执行性检查 ════');
      try {
        const r = Process.findRangeByAddress(procAddr);
        s('  段权限: ' + (r ? r.protection : '?'));
      } catch (e) {}

      // ── 装 MemoryAccessMonitor 抓解密时机 ──
      s('');
      s('════ 对加密区下内存访问监控 ════');
      try {
        const ranges = [];
        // 分成 16KB 一块监控（避免一次监控太大区域）
        for (let off = PROC_LO; off < PROC_HI; off += 0x4000) {
          ranges.push({ base: base.add(off), size: 0x4000 });
        }
        s('  监控 ' + ranges.length + ' 个 16KB 块（共 ' +
          ((PROC_HI - PROC_LO)/1024) + ' KB）');

        MemoryAccessMonitor.enable(ranges, {
          onAccess: function (details) {
            // 只报第一次访问
            if (this.reported) return;
            this.reported = true;
            const k = details.address.toString();
            s('  ★★ 首次访问加密区: ' + details.address +
              '  操作=' + details.operation +
              '  来自=' + details.from);
            send({ t: 'access', addr: details.address.toString(),
                   op: details.operation, from: details.from.toString() });
            // 立即 dump 该块
            try {
              const blk = details.address.and(ptr('0xffffffffffffc000'));
              const h = hexOf(blk, 4096);
              if (h) send({ t: 'block', addr: blk.toString(), hex: h });
            } catch (e) {}
          }
        });
        s('  ✓ 监控已启用');
      } catch (e) { s('  监控启用失败: ' + e); }

      // ── 触发并观察 ──
      s('');
      s('════ 触发 signRequest ════');
      try {
        const N2 = Java.use('com.huachenjie.c.HcjNative');
        const out = String(N2.signRequest('{"probe":1}', 0));
        s('  结果: ' + out.substring(0, 40) + '...');
      } catch (e) { s('  失败: ' + e); }

      // ── 再次对比（看是否被解密了）──
      setTimeout(function () {
        s('');
        s('════ 触发后再次对比加密区 ════');
        const h2 = hexOf(base.add(PROC_LO), 64);
        if (h2) {
          s('  运行时: ' + h2);
          send({ t: 'runtime_after', addr: base.add(PROC_LO).toString(), hex: h2 });
        }
        try { MemoryAccessMonitor.disable(); } catch (e) {}
      }, 3000);
    });
  }
});
s('[boot] 内存断点监控就绪');
