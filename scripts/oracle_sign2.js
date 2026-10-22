/**
 * 预言机第二轮：针对第一轮发现的三个线索做定向探测。
 *
 * 第一轮的发现：
 *   ① signRequest 输出 108 字符 base64（81 字节），完全确定性，env∈{9,11} 走另一套密钥
 *   ② encodeRun 输出 32 字符 hex（16 字节 = MD5 长度），所有入参都参与
 *   ③ buildFlutterSecParams("a","b","c",0) 返回
 *        {"signKey":"09L8MJRMJKXW8TPF","encKey":"a","userToken":"b","satoken":"c"}
 *      → signKey 是新增的 16 字符！需要查它的来源与是否随 env 变化
 *
 * 本轮目标：
 *   A. signKey 的来源：换 env、多次调用看是否变化；是否与设备/时间相关
 *   B. signRequest 的输入敏感度：逐字节扰动，确认是否覆盖全部输入
 *   C. encodeRun 是否等价 MD5（用已知算法对比）
 *   D. signRequest 输出长度分析：81 字节的构成（是否 = 若干段拼接）
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

var FIRST = 0x27000, DC = 0x11c7d8;
var art = Process.findModuleByName('libart.so');
var tried = false;

function probe() {
  if (tried) return;
  tried = true;
  Java.perform(function () {
    var N = null;
    try { N = Java.use('com.huachenjie.c.HcjNative'); }
    catch (e) { s('取 HcjNative 失败: ' + e); return; }

    // ═══ A. signKey 的来源 ═══
    s('════ A. buildFlutterSecParams / signKey 来源 ════');
    [0, 1, 9, 11, 99].forEach(function (env) {
      try {
        s('  env=' + env + ' → ' + String(N.buildFlutterSecParams('X', 'Y', 'Z', env)));
      } catch (e) { s('  env=' + env + ' 异常: ' + e); }
    });
    s('  -- 同 env 连调 3 次（看 signKey 是否变化）--');
    for (var k = 0; k < 3; k++) {
      try { s('    第' + (k+1) + '次: ' + String(N.buildFlutterSecParams('X', 'Y', 'Z', 0))); } catch (e) {}
    }
    s('  -- 输入长度影响 --');
    try { s('    空串: ' + String(N.buildFlutterSecParams('', '', '', 0))); } catch (e) {}
    try { s('    长串: ' + String(N.buildFlutterSecParams('AAAA', 'BBBB', 'CCCC', 0))); } catch (e) {}

    // ═══ B. signRequest 输入敏感度 ═══
    s('════ B. signRequest 输入敏感度 ════');
    var cases = [
      ['空串', ''],
      ['单空格', ' '],
      ['单字符', 'a'],
      ['"a"', '"a"'],
      ['"b"', '"b"'],
      ['"a" 尾部多个空格', '"a" '],
      ['大小写同语义', '{"A":1}'],
      ['顺序不同', '{"b":2,"a":1}'],
      ['重复键', '{"a":1,"a":1}'],
      ['长输入200', JSON.stringify({ d: 'x'.repeat(200) })],
      ['长输入400', JSON.stringify({ d: 'x'.repeat(400) })],
    ];
    cases.forEach(function (c) {
      try { s('  ' + c[0] + ' (len=' + c[1].length + ') → ' + String(N.signRequest(c[1], 0))); }
      catch (e) { s('  ' + c[0] + ' 异常: ' + e); }
    });

    // ═══ C. 输出结构分析（把 108 字符 base64 解码成 hex 便于分析）═══
    s('════ C. signRequest 输出解码 ════');
    function b64ToHex(b64) {
      var tbl = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
      var out = '', bits = 0, val = 0;
      for (var i = 0; i < b64.length; i++) {
        var idx = tbl.indexOf(b64.charAt(i));
        if (idx < 0) continue;
        val = (val << 6) | idx; bits += 6;
        if (bits >= 8) { bits -= 8; out += ('0' + ((val >> bits) & 0xff).toString(16)).slice(-2); }
      }
      return out;
    }
    ['{}', '{"a":1}'].forEach(function (inp) {
      try {
        var o = String(N.signRequest(inp, 0));
        var h = b64ToHex(o);
        s('  in=' + inp);
        s('    b64len=' + o.length + ' bytes=' + (h.length / 2));
        s('    hex=' + h);
      } catch (e) {}
    });

    // ═══ D. encodeRun 多组样本（供离线比对 MD5）═══
    s('════ D. encodeRun 样本集 ════');
    var er = [
      ['{"x":1}', '26101017', '8.7.7', 'A', 0],
      ['{"x":1}', '26101017', '8.7.7', 'A', 1],
      ['', '26101017', '8.7.7', 'A', 0],
      ['a', '26101017', '8.7.7', 'A', 0],
      ['a', '', '', '', 0],
      ['a', '1', '2', '3', 0],
    ];
    er.forEach(function (c) {
      try {
        s('  encodeRun(' + JSON.stringify(c) + ') = ' + String(N.encodeRun(c[0], c[1], c[2], c[3], c[4])));
      } catch (e) { s('  异常: ' + e); }
    });

    s('════ 第二轮探测结束 ════');
  });
}

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (tried) return;
    var desc = '';
    try { desc = a[2].readCString(); } catch (e) { return; }
    if (!desc) return;
    if (desc.indexOf('Lcom/huachenjie') !== 0 && desc.indexOf('Lcom/zj/adlib') !== 0) return;
    s('[native] 触发类: ' + desc);
    probe();
  }
});
s('[boot] 第二轮就绪');
