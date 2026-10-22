/**
 * 严格版基址定位：对每个锚点候选，用**磁盘镜像逐字节比对**验证。
 *
 * 上次的教训：锚点字符串在 ART 堆里有副本（Java String），
 * 直接取第一个命中会得到错误基址。必须用「多锚点 + 内容比对」双重验证。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

// 磁盘镜像里 .note.gnu.text 的一段独特字节（用于逐字节校验）
// 取代码段开头 64 字节（由宿主注入）
var DISK_SIG = null;
try { DISK_SIG = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840b9'; } catch (e) {}

// 锚点：(字符串, 磁盘 vaddr, 字符串在磁盘 .note.gnu.text 里的字节偏移)
// .note.gnu.text: file_off 0x47040 → vaddr 0x4e040
const ANCHORS = [
  ['/proc/self/maps',   0x5f780],
  ['LD_PRELOAD',        0x5f7d8],
  ['/proc/self/fd/%d',  0x5f7b8],
  ['dl_iterate_phdr',   0x5f860],
  ['libandroid.so',     0x5f850],
  ['/dev/null',         0x5f840],
];

function pattern(str) {
  let out = [];
  for (let i = 0; i < str.length; i++) out.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  return out.join(' ');
}

function findAll(str) {
  const pat = pattern(str);
  const out = [];
  let ranges = [];
  try { ranges = Process.enumerateRanges('r--'); } catch (e) { return out; }
  for (let i = 0; i < ranges.length; i++) {
    const r = ranges[i];
    if (r.size < str.length || r.size > 64 * 1024 * 1024) continue;
    let hits = null;
    try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { continue; }
    if (hits) hits.forEach(function (h) { out.push(h.address); });
  }
  return out;
}

// 校验：假设基址为 b，读 b+vaddr(代码段) 处的字节，与磁盘签名比对
function verify(b, codeVaddr, diskHex) {
  if (!diskHex) return null;
  try {
    const p = b.add(codeVaddr);
    const n = diskHex.length / 2;
    const bytes = new Uint8Array(p.readByteArray(n));
    let hex = '';
    for (let i = 0; i < n; i++) hex += ('0' + bytes[i].toString(16)).slice(-2);
    // 统计匹配字节数
    let same = 0;
    for (let i = 0; i < n; i++) {
      if (hex.substr(i*2,2) === diskHex.substr(i*2,2)) same++;
    }
    return { hex: hex, match: same, total: n };
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
        s('触发: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 28) + '...');
      } catch (e) { s('触发失败: ' + e); }

      s('');
      s('════ 收集所有锚点候选并推算基址 ════');
      const bases = {};
      ANCHORS.forEach(function (a2) {
        const name = a2[0], va = a2[1];
        const hits = findAll(name);
        s('  "' + name + '" 命中 ' + hits.length + ' 处');
        const uniq = {};
        hits.forEach(function (h) {
          const b = h.sub(va).toString();
          uniq[b] = (uniq[b] || 0) + 1;
          if (!bases[b]) bases[b] = { n: 0, from: [] };
          bases[b].n++;
          bases[b].from.push(name);
        });
        Object.keys(uniq).forEach(function (b) {
          s('     基址候选 ' + b + '  (来自 ' + uniq[b] + ' 处命中)');
        });
      });

      s('');
      s('════ 逐字节校验每个候选基址 ════');
      const keys = Object.keys(bases).sort(function (x, y) { return bases[y].n - bases[x].n; });
      let best = null;
      keys.forEach(function (k) {
        const b = ptr(k);
        const v = verify(b, 0x5b5f0, DISK_SIG);
        const tag = bases[k].from.length + ' 个锚点';
        if (v) {
          s('  ' + k + '  (' + tag + ')  代码段比对: ' + v.match + '/' + v.total + ' 字节匹配');
          s('      实读: ' + v.hex);
          if (!best || v.match > best.match) best = { base: k, match: v.match, total: v.total };
        } else {
          s('  ' + k + '  (' + tag + ')  代码段不可读');
        }
      });

      s('');
      if (best && best.match >= best.total * 0.9) {
        s('★★★ 确认基址 = ' + best.base + '  （' + best.match + '/' + best.total + ' 字节匹配）');
        send({ t: 'base', base: best.base, match: best.match, total: best.total });
        // 输出关键地址
        const B = ptr(best.base);
        s('');
        s('════ 关键地址 ════');
        [['代码段', 0x4e040], ['解码表', 0x64af8], ['加密主体', 0x190],
         ['JNI_OnLoad串', 0x6fef4], ['FUN_0005b5f0', 0x5b5f0]].forEach(function (it) {
          const a3 = B.add(it[1]);
          let r = null;
          try { r = Process.findRangeByAddress(a3); } catch (e) {}
          s('  ' + it[0].padEnd(16) + ' = ' + a3 + '  ' + (r ? r.protection : '?'));
        });
      } else if (best) {
        s('⚠ 最佳候选 ' + best.base + ' 只匹配 ' + best.match + '/' + best.total + ' —— 可能是加密/未加载');
        send({ t: 'base', base: best.base, match: best.match, total: best.total, partial: true });
      } else {
        s('✗ 无有效候选');
      }
    });
  }
});
s('[boot] 严格基址定位就绪');
