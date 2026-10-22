/**
 * 用 JNIEnv.getStaticMethodId 精确取得 signRequest 的 ArtMethod*，
 * 再读 entry_point_from_jni_，得到实现地址与所属段。
 *
 * 前几次失败的原因：
 *   · env.findClass() 走 boot class loader → 找不到壳的类
 *   · meth.$handle 在 Frida 17 下是 undefined
 *
 * 本次改用：Java.use(...).class 拿到 jclass 包装 → 传给 env.getStaticMethodId，
 * 返回的 jmethodID 就是 art::ArtMethod*（Android 上 jmethodID 即 ArtMethod 指针）。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

function inExec(p) {
  try {
    const r = Process.findRangeByAddress(p);
    if (!r) return null;
    if (r.protection.indexOf('x') < 0) return null;
    return r;
  } catch (e) { return null; }
}

function analyze(mid, label) {
  s('════ ' + label + '  ArtMethod @ ' + mid + ' ════');
  const F = [
    ['declaring_class', 0x00, 4],
    ['access_flags',    0x04, 4],
    ['dex_code_item',   0x08, 4],
    ['dex_method_idx',  0x0c, 4],
    ['method_index',    0x10, 2],
    ['hotness',         0x12, 2],
    ['data_/jni_entry', 0x18, 8],
    ['quick_compiled',  0x20, 8],
  ];
  F.forEach(function (f) {
    try {
      const v = mid.add(f[1]);
      if (f[2] === 8) {
        const p = v.readPointer();
        s('   ' + f[0].padEnd(18) + ' = ' + p);
        if (!p.isNull()) {
          const r = inExec(p);
          if (r) {
            s('        ★ 可执行段 ' + r.base + ' (' + (r.size/1024).toFixed(0) + 'KB)  偏移 0x' +
              p.sub(r.base).toString(16) + '  prot=' + r.protection);
            send({ t: 'impl', label: label, field: f[0], addr: p.toString(),
                   segBase: r.base.toString(), segSize: r.size, segProt: r.protection,
                   offset: p.sub(r.base).toString(16) });
          } else {
            const r2 = Process.findRangeByAddress(p);
            s('        非可执行: ' + (r2 ? r2.protection + ' @' + r2.base : '(无映射)'));
          }
        }
      } else {
        s('   ' + f[0].padEnd(18) + ' = 0x' + v.readU32().toString(16));
      }
    } catch (e) { s('   ' + f[0] + '  读失败'); }
  });
  s('');
}

let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      let cls = null;
      try {
        cls = Java.use('com.huachenjie.c.HcjNative').class;
        s('jclass 包装 = ' + cls);
      } catch (e) { s('取 jclass 失败: ' + e); return; }

      const env = Java.vm.getEnv();
      s('JNIEnv = ' + env);

      const METHODS = [
        ['signRequest',          '(Ljava/lang/String;I)Ljava/lang/String;'],
        ['encodeRun',            '(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;'],
        ['buildFlutterSecParams','(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;'],
      ];

      METHODS.forEach(function (m) {
        let mid = null;
        try {
          mid = env.getStaticMethodId(cls, m[0], m[1]);
        } catch (e) {
          s('  getStaticMethodId(' + m[0] + ') 失败: ' + e);
        }
        if (mid && !mid.isNull && !mid.isNull()) {
          analyze(mid, m[0]);
        } else if (mid) {
          s('  ' + m[0] + ' → mid=' + mid);
        }
      });

      // 顺带确认调用仍正常
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        s('实测 signRequest: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 32) + '...');
      } catch (e) { s('调用失败: ' + e); }
    });
  }
});
s('[boot] getStaticMethodId 定位就绪');
