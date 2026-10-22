/**
 * liby.so 运行时内存取证。
 *
 * 背景：liby.so 静态熵 6.88、284 个导出名加密、所有标准密码学常量（MD5/SHA/SM3/AES）
 * 在文件里都搜不到 —— 说明代码段被加密（SMC 自修改），需在运行时才可见。
 * 本脚本：
 *   ① 报告 liby.so 的映射区间（哪些段可读/可写/可执行）
 *   ② 在运行时内存中搜索标准密码学常量（IV 表 / 轮常量）
 *   ③ 搜索签名相关的明文（RSA/SM2 曲线参数、PEM 头、密钥格式）
 *   ④ 定位 h33/cq 用的密钥是否也在其中
 *
 * 注意：只读扫描，不修改任何内存。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

var FIRST = 0x27000, DC = 0x11c7d8;
var art = Process.findModuleByName('libart.so');
var tried = false;

// 密码学常量签名表：名称 → hex 字节串
var SIGS = [
  // MD5
  ['MD5-IV-A',        '01234567'],
  ['MD5-IV-B',        '89abcdef'],
  ['MD5-T1',          '78a46ad7'],
  ['MD5-T2',          '56b7c7e8'],
  // SHA1
  ['SHA1-IV-A',       '01234567'],
  ['SHA1-IV-E',       'c3d2e1f0'],
  // SHA256
  ['SHA256-IV-A',     '67e6096a'],
  ['SHA256-IV-B',     '85ae67bb'],
  ['SHA256-K0',       '982f8a42'],
  // SHA512
  ['SHA512-IV-A',     '08c9bcf367e6096a'],
  // SM3（国密）
  ['SM3-IV-0',        '6f168073'],
  ['SM3-IV-1',        'b9b21449'],
  ['SM3-T0',          '1945cc79'],
  // AES
  ['AES-Te0-0',       'a56363c6'],
  ['AES-Te0-1',       '7c7c7c84'],
  // 国密 SM2/SM4
  ['SM4-FK',          'a3b1bac6'],
  ['SM4-CK',          '00070e15'],
  // 常见魔数
  ['PKCS1-PEM',       '2d2d2d2d2d424547494e'],   // "-----BEGIN"
  ['SM2-前缀',         '04'],                     // 未压缩点（太短，仅记录）
];

function doScan() {
  if (tried) return;
  tried = true;

  var m = null;
  try { m = Process.findModuleByName('liby.so'); } catch (e) {}
  if (!m) { s('liby.so 未加载（可能尚未调用 native）'); return; }

  s('════ liby.so 运行时映射 ════');
  s('  base = ' + m.base + '   size = 0x' + m.size.toString(16) +
    ' (' + (m.size / 1024 / 1024).toFixed(2) + ' MB)');
  s('  path = ' + m.path);

  // 枚举该模块的所有区间
  var ranges = [];
  try {
    ranges = Process.enumerateRanges('r--');
  } catch (e) { s('  enumerateRanges 失败: ' + e); }

  var inMod = [];
  for (var i = 0; i < ranges.length; i++) {
    var r = ranges[i];
    var rb = r.base, re = r.base.add(r.size);
    if (rb.compare(m.base) >= 0 && re.compare(m.base.add(m.size)) <= 0) {
      inMod.push(r);
    }
  }
  s('  模块内可读区间: ' + inMod.length + ' 个');
  inMod.forEach(function (r) {
    s('    ' + r.base + ' - ' + r.base.add(r.size) + '  ' + r.protection +
      '  ' + (r.size / 1024).toFixed(0) + ' KB');
  });
  s('');

  // 在模块内搜常量
  s('════ 运行时密码学常量扫描 ════');
  var hits = {};
  inMod.forEach(function (r) {
    SIGS.forEach(function (sig) {
      var pat = sig[1];
      if (pat.length < 8) return;   // 太短的跳过（误报多）
      var res = null;
      try { res = Memory.scanSync(r.base, r.size, pat.match(/../g).join(' ')); }
      catch (e) { return; }
      if (res && res.length) {
        if (!hits[sig[0]]) hits[sig[0]] = [];
        res.slice(0, 3).forEach(function (x) { hits[sig[0]].push(x.address); });
      }
    });
  });

  var found = Object.keys(hits);
  if (found.length === 0) {
    s('  模块内未找到任何标准密码学常量');
  } else {
    found.forEach(function (k) {
      s('  ✓ ' + k + '  命中 ' + hits[k].length + ' 处  @' + hits[k][0]);
    });
  }
  s('');

  // 全进程范围再扫一遍（有些实现把常量放在匿名页）
  s('════ 全进程扫描（只读段，限定前 400 个区间）════');
  var allHits = {};
  var lim = Math.min(ranges.length, 400);
  for (var j = 0; j < lim; j++) {
    var rr = ranges[j];
    if (rr.size < 4096 || rr.size > 32 * 1024 * 1024) continue;
    SIGS.forEach(function (sig) {
      var pat = sig[1];
      if (pat.length < 16) return;   // 只扫长签名，避免误报
      var res = null;
      try { res = Memory.scanSync(rr.base, rr.size, pat.match(/../g).join(' ')); }
      catch (e) { return; }
      if (res && res.length) {
        if (!allHits[sig[0]]) allHits[sig[0]] = [];
        allHits[sig[0]].push(res[0].address + ' @' + rr.protection);
      }
    });
  }
  var f2 = Object.keys(allHits);
  if (f2.length === 0) s('  未找到');
  else f2.forEach(function (k) { s('  ✓ ' + k + '  ' + allHits[k].slice(0, 3).join(', ')); });

  s('════ 扫描结束 ════');
}

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (tried) return;
    var desc = '';
    try { desc = a[2].readCString(); } catch (e) { return; }
    if (!desc) return;
    if (desc.indexOf('Lcom/huachenjie') !== 0 && desc.indexOf('Lcom/zj/adlib') !== 0) return;
    // 不用 setTimeout（Frida QuickJS 在 native 回调里不可靠）——直接同步扫
    s('[native] 触发，立即扫描');
    doScan();
  }
});
s('[boot] liby 内存取证就绪');
