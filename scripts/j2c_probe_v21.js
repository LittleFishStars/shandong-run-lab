/**
 * v21：查 Java2C 破绽 —— 「两个 signRequest 指针」+「是否存在多个 HcjNative 类」。
 *
 * v13 观察：RegisterNatives 按签名匹配到 **两个** signRequest：
 *   批次#6.2 → libNetHTProtect+0x24926c
 *   批次#6.3 → libNetHTProtect+0x2493ac   （相差 0x140）
 *
 * v20 结果：主动调用第一个 → abort；而 Java 层调用正常。
 *
 * 本脚本：
 *   ① 主动调用**第二个**指针（+0x2493ac），看是否也是 abort
 *   ② 枚举所有 ClassLoader，找 HcjNative 有几个实例 / 是否被替换
 *   ③ 列出 HcjNative 上所有 native 方法的声明（看是否为 Java2C 后的形态）
 *   ④ 同时检查 libOSETSDKProtected.so 是否加载
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) { s('[keep] exit'); }; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

let table = null;
Java.perform(function () {
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    const ver = gv(table) >>> 0;
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败'); table = null; }
    else s('[cal] OK 0x' + ver.toString(16));
  } catch (e) { s('[cal] err: ' + e); table = null; }
});

const fnPtrs = [];
const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
let reported = false;

function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}

function fullReport() {
  if (reported) return; reported = true;
  s('');
  s('════ ① 捕获到的 signRequest 指针 ════');
  fnPtrs.forEach(function (f, i) {
    const r = Process.findRangeByAddress(f);
    s('  [' + i + '] ' + f + '  ' + (r ? r.base + '+0x' + f.sub(r.base).toString(16) : '?') +
      '  bytes=' + hex(f, 16));
  });

  // ══ ② 主动调用每个指针 ══
  if (table) {
    s('');
    s('════ ② 主动调用每个指针 ════');
    const NewStringUTF = new NativeFunction(table.add(167 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
    const GetStringUTFChars = new NativeFunction(table.add(169 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer']);
    const ReleaseStringUTFChars = new NativeFunction(table.add(170 * 8).readPointer(), 'void', ['pointer', 'pointer', 'pointer']);
    const ExceptionCheck = new NativeFunction(table.add(228 * 8).readPointer(), 'int', ['pointer']);
    fnPtrs.forEach(function (f, i) {
      let out = null, err = null;
      try {
        const tf = new NativeFunction(f, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);
        const js = NewStringUTF(table, Memory.allocUtf8String('{"probe":1}'));
        const ret = tf(table, ptr(0), js, 0);
        if (ExceptionCheck(table)) err = 'JNI 异常';
        else if (ret && !ret.isNull()) {
          const c = GetStringUTFChars(table, ret, ptr(0));
          out = c.readUtf8String();
          ReleaseStringUTFChars(table, ret, c);
        } else err = '返回 null';
      } catch (e) { err = String(e).substring(0, 90); }
      s('  [' + i + '] ' + f + ' → ' + (out ? JSON.stringify(out.substring(0, 56)) : ('失败: ' + err)));
    });
  }

  // ══ ③ 枚举 ClassLoader 找 HcjNative ══
  s('');
  s('════ ③ 枚举 ClassLoader 找 HcjNative ════');
  let n = 0, found = [];
  try {
    Java.enumerateClassLoaders({
      onMatch: function (loader) {
        n++;
        try {
          const c = loader.loadClass('com.huachenjie.c.HcjNative');
          found.push({ idx: n, loader: loader.getClass().getName(), cls: c });
          s('  ★ loader#' + n + ' (' + loader.getClass().getName() + ') 找到 HcjNative');
        } catch (e) {}
      },
      onComplete: function () { s('  共扫 ' + n + ' 个 loader，命中 ' + found.length + ' 个 HcjNative'); }
    });
  } catch (e) { s('  枚举失败: ' + e); }

  // ══ ④ HcjNative 的方法声明 ══
  s('');
  s('════ ④ HcjNative 的方法声明 ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    const ms = H.class.getDeclaredMethods();
    s('  声明方法数: ' + ms.length);
    ms.forEach(function (m) {
      const nm = String(m.getName());
      const mod = java.lang.reflect.Modifier.toString(m.getModifiers());
      const isNat = (m.getModifiers() & 0x100) !== 0;   // ACC_NATIVE
      if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams' || isNat) {
        s('    ' + (isNat ? '[native] ' : '[      ] ') + mod + ' ' + m);
      }
    });
  } catch (e) { s('  失败: ' + e); }

  // ══ ⑤ 检查 OSET / 其他 360 库是否加载 ══
  s('');
  s('════ ⑤ 相关库加载情况 ════');
  const WANT = ['libOSETSDKProtected', 'liboset-pine-lib', 'libosetutil', 'libjiagu_sdk',
                'libNetHTProtect', 'liball_in_one', 'libnesec', 'libsecsdk', 'liby.so', 'libzxprotect'];
  const loaded = {};
  try {
    Process.enumerateModules().forEach(function (mod) {
      WANT.forEach(function (w) {
        if (mod.name.indexOf(w) >= 0) { loaded[w] = mod.base.toString(); }
      });
    });
  } catch (e) {}
  WANT.forEach(function (w) {
    s('  ' + w.padEnd(22) + (loaded[w] ? ('已加载 @' + loaded[w]) : '未加载'));
  });
  send({ t: 'R', ptrs: fnPtrs.map(String), hcj: found.length, loaded: loaded });
}

// ══ RegisterNatives ══
Java.perform(function () {
  if (!table) return;
  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a) {
        try {
          const arr = a[2], cnt = a[3].toInt32();
          if (cnt <= 0 || cnt > 600) return;
          for (let i = 0; i < cnt; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            if (sig !== SIG) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (fn && !fn.isNull() && fnPtrs.indexOf(fn) < 0) fnPtrs.push(fn);
          }
          // 捕获到 2 个后就做完整分析（同步，不用 setTimeout）
          if (fnPtrs.length >= 2 && !reported) fullReport();
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RN hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;
    Java.perform(function () {
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('[DC] warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) { s('[DC] warm err: ' + String(e).substring(0, 60)); }
      s('  （此刻捕获 ' + fnPtrs.length + ' 个 signRequest 指针）');
      if (!reported && fnPtrs.length) fullReport();
    });
  }
});
s('[boot] v21 就绪');
