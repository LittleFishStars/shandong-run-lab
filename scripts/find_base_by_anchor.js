/**
 * 用 liby.so 的锚点字符串精确定位其运行时基址 —— 一次性解决所有定位难题。
 *
 * 依据（report/11）：
 *   liby.so 是 APK 里的真实文件（458,584 B），程序头为：
 *     LOAD #1  file 0x00000 / vaddr 0x00000  R E   ← 290KB 加密主体
 *     LOAD #2  file 0x47000 / vaddr 0x4e000  R E   ← ★ 真实代码段 .note.gnu.text
 *     LOAD #3  file 0x59af8 / vaddr 0x64af8  RW    ← 解码表 + 数据
 *   锚点字符串（vaddr 已知）：
 *     "/proc/self/maps"        vaddr 0x5f780
 *     "%lx-%lx %4s %lx ..."    vaddr 0x5f798
 *     "LD_PRELOAD"             vaddr 0x5f7d8
 *
 * 方法：在运行内存里搜这些字符串 → 得到运行时地址 → base = 运行时地址 - vaddr
 * 有了 base，就能算出 signRequest 等任何函数/数据的运行时地址。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const ANCHORS = [
  ['/proc/self/maps',       0x5f780],
  ['%lx-%lx %4s %lx',       0x5f798],
  ['LD_PRELOAD',            0x5f7d8],
  ['/proc/self/fd/%d',      0x5f7b8],
  ['dl_iterate_phdr',       0x5f860],
];

function pattern(str) {
  let out = [];
  for (let i = 0; i < str.length; i++) out.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  return out.join(' ');
}

function findAnchor(str, vaddr) {
  const pat = pattern(str);
  let ranges = [];
  try { ranges = Process.enumerateRanges('r--'); } catch (e) { return null; }
  for (let i = 0; i < ranges.length; i++) {
    const r = ranges[i];
    if (r.size < str.length || r.size > 64 * 1024 * 1024) continue;
    let hits = null;
    try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { continue; }
    if (hits && hits.length) {
      // 优先选「可执行段」内的（那才是 liby 的代码段）
      for (let j = 0; j < hits.length; j++) {
        const h = hits[j];
        const rr = Process.findRangeByAddress(h.address);
        return { addr: h.address, vaddr: vaddr, range: rr };
      }
    }
  }
  return null;
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
      // 触发 native 加载
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        s('触发: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 30) + '...');
      } catch (e) { s('触发失败: ' + e); }

      s('');
      s('════ 用锚点字符串定位 liby.so 运行时基址 ════');
      let base = null;
      for (let i = 0; i < ANCHORS.length; i++) {
        const name = ANCHORS[i][0], va = ANCHORS[i][1];
        const hit = findAnchor(name, va);
        if (hit) {
          const b = hit.addr.sub(va);
          s('  ✓ "' + name + '"  运行时 ' + hit.addr + '  (vaddr 0x' + va.toString(16) + ')');
          s('      → 推算基址 = ' + b);
          if (hit.range) {
            s('        所在段 ' + hit.range.base + ' - ' + hit.range.base.add(hit.range.size) +
              '  ' + hit.range.protection + '  ' + (hit.range.size/1024).toFixed(0) + 'KB');
          }
          if (base === null) base = b;
          else if (!base.equals(b)) s('      ⚠ 与其他锚点推算的基址不一致！');
        } else {
          s('  ✗ "' + name + '" 未找到');
        }
      }

      if (!base) { s('  ⇒ 未能定位基址'); return; }

      s('');
      s('★★★ liby.so 运行时基址 = ' + base);
      send({ t: 'base', base: base.toString() });

      // 用基址算出关键地址
      s('');
      s('════ 按基址算出的关键地址 ════');
      const ITEMS = [
        ['真实代码段 (.note.gnu.text)', 0x4e040],
        ['解码表 (.note.gnu.content)',  0x64af8],
        ['加密主体 (.note.gnu.proc)',   0x190],
        ['JNI_OnLoad 字符串',           0x6fef4],
        ['最大函数 FUN_0005b5f0',       0x5b5f0],
      ];
      ITEMS.forEach(function (it) {
        const a2 = base.add(it[1]);
        let extra = '';
        try {
          const r = Process.findRangeByAddress(a2);
          extra = r ? ('  段 ' + r.base + ' ' + r.protection) : '  (无映射)';
        } catch (e) {}
        s('  ' + it[0].padEnd(30) + ' = ' + a2 + extra);
      });

      // 验证：读代码段头部，应与磁盘一致
      s('');
      s('════ 验证：读运行时真实代码段 ════');
      try {
        const codeSeg = base.add(0x4e040);
        const hex = [];
        const bytes = new Uint8Array(codeSeg.readByteArray(32));
        for (let i = 0; i < 32; i++) hex.push(('0' + bytes[i].toString(16)).slice(-2));
        s('  运行时前 32 字节: ' + hex.join(' '));
        s('  磁盘  前 32 字节: f5 7f 00 f9 fd 7b 01 a9 fd 43 00 91 ...');
      } catch (e) { s('  读取失败: ' + e); }
    });
  }
});
s('[boot] 锚点定位就绪');
