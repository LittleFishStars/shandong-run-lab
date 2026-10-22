/**
 * v23 ★★ 修正 JNIEnv 传参 —— v20 abort 的真正原因。
 *
 * 根因分析：
 *   JNI 约定：typedef const struct JNINativeInterface* JNIEnv;
 *   native 函数第一个参数是 **env**（指向函数表的指针），不是函数表本身。
 *   ART 内部会做 down_cast<JNIEnvExt*>(env)->GetSelf() 取线程对象；
 *   我此前传 table（函数表）→ 从错误内存读 self_ → abort。
 *   （这也解释了为何 GetVersion 能成功：它不碰 env。）
 *
 * 本脚本：
 *   ① envPtr = env.handle（JNIEnv*，正确）；table = envPtr.readPointer()
 *   ② 所有 JNI 调用都传 envPtr（不再传 table）
 *   ③ FindClass / GetStaticMethodID 也重试（此前失败同因）
 *   ④ 主动调用 fnPtr → 期望不再 abort，拿到真实输出
 *   ⑤ 成功则 dump 已被初始化的 .bss 4 张密钥表
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) { s('[keep] exit'); }; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

let envPtr = null, table = null;
Java.perform(function () {
  try {
    envPtr = Java.vm.getEnv().handle;        // ★ JNIEnv*
    table  = envPtr.readPointer();           // ★ 函数表
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    s('[cal] envPtr=' + envPtr + '  table=' + table +
      '  GetVersion=0x' + (gv(envPtr) >>> 0).toString(16));   // ★ 传 envPtr
  } catch (e) { s('[cal] err: ' + e); }
});

function jni(idx, ret, args) { return new NativeFunction(table.add(idx * 8).readPointer(), ret, args); }
function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFFSET = 0x24926c;
let done = false;

function work(fnPtr) {
  if (done) return; done = true;

  s('');
  s('════ ① 基础信息 ════');
  s('  fnPtr = ' + fnPtr);
  const base = fnPtr.sub(OFFSET);
  s('  base  = ' + base);
  s('  校验 base+0x24926c = ' + hex(base.add(OFFSET), 16) +
    (hex(base.add(OFFSET), 16) === 'ff8301d1f85f02a9f65703a9f44f04a9' ? '  ✓' : '  ⚠'));

  // JNI 函数（★ 全部传 envPtr）
  let FindClass, NewStringUTF, GetStringUTFChars, ReleaseStringUTFChars, ExceptionCheck, ExceptionClear;
  try {
    FindClass             = jni(6,   'pointer', ['pointer', 'pointer']);
    NewStringUTF          = jni(167, 'pointer', ['pointer', 'pointer']);
    GetStringUTFChars     = jni(169, 'pointer', ['pointer', 'pointer', 'pointer']);
    ReleaseStringUTFChars = jni(170, 'void',    ['pointer', 'pointer', 'pointer']);
    ExceptionCheck        = jni(228, 'int',     ['pointer']);
    ExceptionClear        = jni(17,  'void',    ['pointer']);
    s('  JNI 工具就绪');
  } catch (e) { s('  ✗ ' + e); return; }

  // ══ ② FindClass（此前失败同因，重试）══
  s('');
  s('════ ② FindClass 重试 ════');
  let jclass = ptr(0);
  try {
    jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
    s('  HcjNative jclass = ' + jclass + (jclass.isNull() ? '  (失败)' : '  ✓'));
    if (ExceptionCheck(envPtr)) { s('  有 JNI 异常'); ExceptionClear(envPtr); }
  } catch (e) { s('  FindClass err: ' + e); }

  // ══ ③ 直接调用 native 实现 ══
  s('');
  s('════ ③ 主动调用 native（★ 传 envPtr）════');
  const target = new NativeFunction(fnPtr, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);
  const CASES = [['{"probe":1}', 0], ['{}', 0], ['{"a":2}', 0], ['{"probe":1}', 9], ['{"probe":1}', 11]];
  const nativeOut = {};
  CASES.forEach(function (c) {
    const inp = c[0], ec = c[1];
    let out = null, err = null;
    try {
      const js = NewStringUTF(envPtr, Memory.allocUtf8String(inp));      // ★ envPtr
      const ret = target(envPtr, jclass, js, ec);                        // ★ envPtr
      if (ExceptionCheck(envPtr)) {
        err = 'JNI 异常'; ExceptionClear(envPtr);
      } else if (ret && !ret.isNull()) {
        const p = GetStringUTFChars(envPtr, ret, ptr(0));                // ★ envPtr
        out = p.readUtf8String();
        ReleaseStringUTFChars(envPtr, ret, p);
      } else err = '返回 null';
    } catch (e) { err = String(e).substring(0, 110); }
    nativeOut[inp + '@env' + ec] = out;
    s('  native(' + inp + '@env' + ec + ') → ' +
      (out ? JSON.stringify(out.substring(0, 64)) : ('失败: ' + err)));
  });
  send({ t: 'native', out: nativeOut });

  // ══ ④ 与 Java 层对比 ══
  s('');
  s('════ ④ 对比 Java 层 ════');
  const javaOut = {};
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    CASES.forEach(function (c) {
      const k = c[0] + '@env' + c[1];
      let o = null;
      try { o = String(H.signRequest(c[0], c[1])); } catch (e) { o = 'ERR'; }
      javaOut[k] = o;
      s('  java(' + k + ') → ' + JSON.stringify((o || '').substring(0, 64)));
    });
  } catch (e) { s('  ' + e); }

  s('');
  s('════ ⑤ 一致性 ════');
  let same = 0, tot = 0;
  Object.keys(nativeOut).forEach(function (k) {
    if (!(k in javaOut)) return;
    tot++;
    const eq = nativeOut[k] && nativeOut[k] === javaOut[k];
    if (eq) same++;
    s('  ' + k + '  ' + (eq ? '★★★ 一致' : '✗ 不同'));
  });
  s('  一致 ' + same + ' / ' + tot);
  send({ t: 'cmp', same: same, total: tot });

  // ══ ⑥ 表 dump ══
  s('');
  s('════ ⑥ .bss 密钥表 ════');
  [['delta_key', 0x47c970, 0x40], ['whiteT0', 0x47c9b0, 0x10],
   ['T1', 0x47c9b8, 0x400], ['T2', 0x47cdb8, 0x400],
   ['T3', 0x47d1b8, 0x400], ['T4', 0x47d5b8, 0x400]].forEach(function (t) {
    const h = hex(base.add(t[1]), t[2]);
    if (!h) { s('  ' + t[0] + ' 读失败'); return; }
    const z = h === '0'.repeat(h.length);
    s('  ' + t[0].padEnd(10) + (z ? '（全零）' : h.substring(0, 80) + '…'));
    if (!z) send({ t: 'table', name: t[0], off: t[1], hex: h });
  });
}

Java.perform(function () {
  if (!table) { s('✗ 无 JNI 表'); return; }
  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a) {
        if (done) return;
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
            if (fn && !fn.isNull()) { s('[RN] fn = ' + fn); work(fn); return; }
          }
        } catch (e) {}
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
      } catch (e) {}
    });
  }
});
s('[boot] v23 就绪（修正 JNIEnv 传参）');
