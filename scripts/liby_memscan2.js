/**
 * liby.so 运行时取证（修正版）。
 *
 * 第一版失败原因：触发时机太早 —— 应用类刚定义时 liby.so 还没被
 * System.loadLibrary("y") 加载（那是 HcjNative 静态块的事）。
 *
 * 本版策略：
 *   ① 先主动调用一次 HcjNative.signRequest，**强制** liby.so 加载并初始化
 *   ② 加载后立即扫描其运行时内存，找标准密码学常量（验证 SMC 自解密假设）
 *   ③ 把模块映射区间与命中情况完整报出
 *
 * 只读操作，不修改内存。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

var FIRST = 0x27000, DC = 0x11c7d8;
var art = Process.findModuleByName('libart.so');
var tried = false;

var SIGS = [
  ['MD5-IV-A',       '01234567'],
  ['MD5-IV-B',       '89abcdef'],
  ['MD5-T1',         '78a46ad7'],
  ['MD5-T2',         '56b7c7e8'],
  ['MD5-T3',         '242070db'],
  ['SHA1-IV-A',      '01234567'],
  ['SHA1-IV-E',      'c3d2e1f0'],
  ['SHA256-IV-A',    '67e6096a'],
  ['SHA256-IV-B',    '85ae67bb'],
  ['SHA256-IV-C',    '3c6ef372'],
  ['SHA256-K0',      '982f8a42'],
  ['SHA512-IV-A',    '08c9bcf367e6096a'],
  ['SM3-IV-0',       '6f168073'],
  ['SM3-IV-1',       'b9b21449'],
  ['SM3-IV-2',       '172f81f4'],
  ['SM3-T0',         '1945cc79'],
  ['AES-Te0-0',      'a56363c6'],
  ['AES-Te0-1',      '7c7c7c84'],
  ['AES-Sbox-0',     '637c777bf26b6fc5'],
  ['SM4-FK',         'a3b1bac6'],
  ['SM4-CK0',        '00070e15'],
  ['BASE64表',        '4142434445464748'],   // "ABCDEFGH"
  ['RSA-65537',      '010001'],
  ['SM2-曲线-a',      'fffffffeffffffff'],   // SM2 p 的高位
];

function dumpModule(tag) {
  var m = null;
  try { m = Process.findModuleByName('liby.so'); } catch (e) {}
  if (!m) { s('[' + tag + '] liby.so 仍未加载'); return null; }
  s('[' + tag + '] liby.so base=' + m.base + ' size=' + (m.size / 1024 / 1024).toFixed(2) + ' MB');
  return m;
}

function scanModule(m, tag) {
  if (!m) return;
  var lo = m.base, hi = m.base.add(m.size);
  var ranges = [];
  try { ranges = Process.enumerateRanges('r--'); } catch (e) { s('枚举失败: ' + e); return; }

  var inMod = [];
  for (var i = 0; i < ranges.length; i++) {
    var r = ranges[i];
    if (r.base.compare(lo) >= 0 && r.base.add(r.size).compare(hi) <= 0) inMod.push(r);
  }
  s('[' + tag + '] 模块内可读区间 ' + inMod.length + ' 个');
  inMod.forEach(function (r) {
    s('    ' + r.base + '  ' + r.protection + '  ' + (r.size / 1024).toFixed(0) + ' KB');
  });

  s('[' + tag + '] 常量扫描:');
  var any = false;
  inMod.forEach(function (r) {
    SIGS.forEach(function (sg) {
      var pat = sg[1];
      if (pat.length < 8) return;
      var res = null;
      try { res = Memory.scanSync(r.base, r.size, pat.match(/../g).join(' ')); } catch (e) { return; }
      if (res && res.length) {
        any = true;
        s('    ✓ ' + sg[0] + '  ' + res.length + ' 处  @' + res[0].address + ' (' + r.protection + ')');
      }
    });
  });
  if (!any) s('    （模块内未找到任何标准密码学常量）');
}

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (tried) return;
    var desc = '';
    try { desc = a[2].readCString(); } catch (e) { return; }
    if (!desc) return;
    if (desc.indexOf('Lcom/huachenjie') !== 0 && desc.indexOf('Lcom/zj/adlib') !== 0) return;
    tried = true;
    s('[native] 触发类: ' + desc);

    Java.perform(function () {
      // ── ① 强制加载 liby.so ──
      s('① 主动调用 signRequest 以强制加载 liby.so ...');
      try {
        var N = Java.use('com.huachenjie.c.HcjNative');
        var r = String(N.signRequest('{"probe":1}', 0));
        s('  调用成功，签名 = ' + r.substring(0, 40) + '...');
      } catch (e) { s('  调用失败: ' + e); }

      // ── ② 确认模块已加载 ──
      var m = dumpModule('② 加载后');
      if (!m) return;

      // ── ③ 扫描 ──
      scanModule(m, '③ 扫描');
      s('════ 完成 ════');
    });
  }
});
s('[boot] 修正版就绪');
