/**
 * 决定性定位：同进程内找到 "signRequest" 字符串所在段，报告段基址与大小，
 * 并把该段整体读出回传宿主（分片）。
 *
 * 这是 report/08 钓鱼法的延伸：
 *   · 钓鱼法解决「SO 被匿名映射、无路径名」
 *   · 本法解决「不知道目标 SO 在哪一段」—— 用字符串反查
 *
 * 注意：字符串可能出现在 .rodata（只读段），而实现代码在其 r-x 兄弟段。
 * 因此找到字符串所在段后，会把**同基址附近的连续映射**一并报告。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const FIRST = 0x27000, DC = 0x11c7d8;
const art = Process.findModuleByName('libart.so');
const MAX_ONESHOT = 32 * 1024 * 1024;

function asciiPattern(str) {
  let out = [];
  for (let i = 0; i < str.length; i++) out.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  out.push('00');
  return out.join(' ');
}

function findInAllRanges(str) {
  const pat = asciiPattern(str);
  const res = [];
  let ranges = [];
  try { ranges = Process.enumerateRanges('r--'); } catch (e) { return res; }
  for (let i = 0; i < ranges.length; i++) {
    const r = ranges[i];
    if (r.size < str.length + 1 || r.size > 128 * 1024 * 1024) continue;
    let hits = null;
    try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { continue; }
    if (hits && hits.length) {
      hits.slice(0, 4).forEach(function (h) {
        res.push({ addr: h.address, range: r });
      });
    }
  }
  return res;
}

function grabRange(r, tag) {
  if (!r) return;
  s('  ★ dump 段 ' + r.base + '  ' + (r.size/1024).toFixed(0) + 'KB  ' + r.protection);
  let data = null;
  try { data = r.base.readByteArray(r.size); } catch (e) { s('    读取失败: ' + e); return; }
  if (!data) { s('    读出 null'); return; }
  if (r.size <= MAX_ONESHOT) {
    send({ t: 'seg', tag: tag, base: r.base.toString(), size: r.size,
           prot: r.protection, part: 0, total: 1 }, data);
  } else {
    const n = Math.ceil(r.size / MAX_ONESHOT);
    for (let i = 0; i < n; i++) {
      const off = i * MAX_ONESHOT;
      const sz = Math.min(MAX_ONESHOT, r.size - off);
      let chunk = null;
      try { chunk = r.base.add(off).readByteArray(sz); } catch (e) { continue; }
      if (chunk) send({ t: 'seg', tag: tag, base: r.base.toString(), size: r.size,
                        prot: r.protection, part: i, total: n, off: off }, chunk);
    }
  }
}

let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      s('════ 用字符串反查 signRequest 所在段 ════');

      // 先触发一次确保 native 已加载
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        s('  调用: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 32) + '...');
      } catch (e) { s('  调用失败: ' + e); }

      ['signRequest', 'buildFlutterSecParams', 'encodeRun'].forEach(function (name) {
        s('');
        s('  ── 搜索 "' + name + '" ──');
        const hits = findInAllRanges(name);
        if (!hits.length) { s('    未找到'); return; }
        hits.forEach(function (h) {
          s('    命中 @ ' + h.addr + '  所在段 ' + h.range.base +
            ' (' + (h.range.size/1024).toFixed(0) + 'KB ' + h.range.protection + ')');
        });
        // dump 第一个命中所在段
        const uniq = {};
        hits.forEach(function (h) { uniq[h.range.base.toString()] = h.range; });
        Object.keys(uniq).slice(0, 2).forEach(function (k) {
          grabRange(uniq[k], name + '_' + k);
        });
      });

      // 另外：把与该字符串地址同区域的**所有**映射列出（含 r-x）
      s('');
      s('  ── 目标地址附近的全部映射（含可执行）──');
      const h0 = findInAllRanges('signRequest')[0];
      if (h0) {
        const T = h0.addr;
        let all = [];
        try { all = Process.enumerateRanges('---'); } catch (e) {}
        // enumerateRanges('---') 可能不支持，改用逐个权限
        ['r--', 'rw-', 'r-x', 'rwx'].forEach(function (p) {
          try {
            Process.enumerateRanges(p).forEach(function (r) {
              const s0 = r.base, e0 = r.base.add(r.size);
              if (s0.sub(T).abs().toInt32() < 8 * 1024 * 1024) {
                s('    ' + r.base + ' - ' + e0 + '  ' + r.protection +
                  '  ' + (r.size/1024).toFixed(0) + 'KB');
              }
            });
          } catch (e) {}
        });
      }
      s('════ 完成 ════');
    });
  }
});
s('[boot] 字符串反查就绪');
