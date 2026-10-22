/**
 * 把 HcjNative.signRequest / encodeRun 变成"预言机"。
 *
 * 目的：签名算法在 liby.so 里（284 个导出名全加密、熵 6.88、无 JNI_OnLoad/Java_* 导出），
 * 静态啃成本高。这里改用黑盒方式：**主动调用** native 方法并喂已知输入，
 * 收集 (输入, 输出) 对，用于：
 *   ① 判定算法家族（输出长度/字符集/是否 base64/是否含时间戳）
 *   ② 验证输出是否确定（同输入两次调用是否一致 → 是否含随机数/nonce）
 *   ③ 验证输入的各个部分是否参与签名（逐字段扰动，看输出是否变化）
 *   ④ 为后续 IDA 逆向提供已知明文-密文对
 *
 * 注意：全部为只读探测，不修改任何数据、不发送任何网络请求。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

// 用 DefineClass 等 HcjNative 出现（它是应用类，早期不可用）
var FIRST = 0x27000, DC = 0x11c7d8;
var art = Process.findModuleByName('libart.so');
var fired = false;

function hex(s) {
  var out = '';
  for (var i = 0; i < s.length; i++) {
    var c = s.charCodeAt(i);
    out += ('0' + c.toString(16)).slice(-2);
  }
  return out;
}

function probe() {
  if (fired) return;
  fired = true;
  Java.perform(function () {
    var N = null;
    try { N = Java.use('com.huachenjie.c.HcjNative'); }
    catch (e) { s('取 HcjNative 失败: ' + e); return; }

    // ── 1) signRequest 的输入输出对 ──
    var inputs = [
      '{}',
      '{"a":1}',
      '{"a":1,"b":2}',
      '{"runRecordCode":"TEST001"}',
      '{"pois":[],"runRecordCode":"TEST001"}',
      '{"pois":[],"runRecordCode":"TEST002"}',
      '{"pois":[],"runRecordCode":"TEST001","timestamp":"1"}'
    ];
    var base = null;
    s('════ signRequest 探测（env 固定为 0）════');
    for (var i = 0; i < inputs.length; i++) {
      var out = '';
      try { out = String(N.signRequest(inputs[i], 0)); }
      catch (e) { s('  [' + i + '] 调用异常: ' + e); continue; }
      s('  in  = ' + inputs[i]);
      s('  out = ' + out + '   (len=' + out.length + ')');
      if (i === 0) base = out;
      s('');
    }

    // ── 2) 确定性检验：同输入连调 3 次 ──
    s('════ 确定性检验（同输入调 3 次）════');
    for (var k = 0; k < 3; k++) {
      try { s('  第' + (k+1) + '次: ' + String(N.signRequest('{"a":1}', 0))); }
      catch (e) { s('  异常: ' + e); }
    }

    // ── 3) env 参数影响 ──
    s('════ env 参数影响 ════');
    [0, 1, 9, 11, 99, -1].forEach(function (env) {
      try { s('  env=' + env + ' → ' + String(N.signRequest('{"a":1}', env))); }
      catch (e) { s('  env=' + env + ' 异常: ' + e); }
    });

    // ── 4) encodeRun 探测 ──
    s('════ encodeRun 探测 ════');
    try {
      var r1 = String(N.encodeRun('{"x":1}', '26101017', '8.7.7', 'A', 0));
      s('  encodeRun(in={"x":1}, 26101017, 8.7.7, A, 0) = ' + r1 + '  (len=' + r1.length + ')');
      var r2 = String(N.encodeRun('{"x":1}', '26101017', '8.7.7', 'B', 0));
      s('  encodeRun(..., D=B, 0)                          = ' + r2);
      var r3 = String(N.encodeRun('{"x":1}', '26101018', '8.7.7', 'A', 0));
      s('  encodeRun(..., versionCode=26101018, A, 0)      = ' + r3);
    } catch (e) { s('  encodeRun 异常: ' + e); }

    // ── 5) buildFlutterSecParams 探测 ──
    s('════ buildFlutterSecParams 探测 ════');
    try {
      s('  = ' + String(N.buildFlutterSecParams('a', 'b', 'c', 0)));
    } catch (e) { s('  异常: ' + e); }

    s('════ 探测结束 ════');
  });
}

// 触发策略：什么类被定义都行 —— 只要出现应用类就试一次 probe()
// （HcjNative 由 System.loadLibrary("y") 在静态块里加载，实际很早可用，
//   但 Frida 的 Java.use 需要类已进入 ClassLoader，故用"首次应用类"作时机）
var tried = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (tried) return;
    var desc = '';
    try { desc = a[2].readCString(); } catch (e) { return; }
    if (!desc) return;
    // 任意应用类都触发（HcjNative/h33/cq 之一出现时，liby.so 通常已加载）
    if (desc.indexOf('Lcom/huachenjie') !== 0 && desc.indexOf('Lcom/zj/adlib') !== 0) return;
    tried = true;
    s('[native] 首次应用类: ' + desc + ' → 开始探测');
    probe();
  }
});
s('[boot] 就绪（任意应用类触发）');
