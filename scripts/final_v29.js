/**
 * v29 ★★★★★ 终局成功：hook ArtMethod.data_ 指向的 liby.so+0x1e320。
 *
 * v28 的决定性发现：
 *   GetStaticMethodID → ArtMethod* @0x7cbd74fd18
 *     +0x04 access_flags_ = 0x109  [public|static|native]
 *     +0x18 data_         = 0x7cb28a2320  ← ★★ 段 = r-x liby.so+0x1e320
 *     +0x20 entry_quick   = 0x7cd8707950  ← libart.so 通用 JNI 桥
 *   注册指针(RegisterNatives) = libNetHTProtect.so+0x24926c  ← 未被 ART 引用！
 *
 *   liby.so 磁盘 +0x1e320 是加密数据（4c90f385...），运行时解密为合法 AArch64：
 *     sub sp,sp,#0x110 / stp x29,x30 / mrs tpidr_el0 / mov x1,x2 / mov w20,w3 / mov x19,x0
 *   ⇒ 参数映射完全符合 JNI：x0=env, x1=clazz(未用), x2=json, x3=envCode
 *
 * 本脚本：
 *   ① 拿 ArtMethod 的 data_
 *   ② hook 它（这次必然触发）
 *   ③ 抓 (env, clazz, json, envCode) 与返回值 → 完整的输入输出对
 *   ④ 同时 hook 它内部调用的函数（从反汇编已知 0x27b10 / 0x27bb0）
 *   ⑤ 抓 libNetHTProtect.so+0x24926c 是否也被调用（确定两层关系）
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

let envPtr = null, table = null;
Java.perform(function () {
  try {
    envPtr = Java.vm.getEnv().handle;
    table = envPtr.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    s('[cal] 0x' + (gv(envPtr) >>> 0).toString(16));
  } catch (e) { s('[cal] err: ' + e); }
});
function jni(i, r, a) { return new NativeFunction(table.add(i * 8).readPointer(), r, a); }
function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}
function seg(a) {
  if (!a || a.isNull()) return 'null';
  try {
    const r = Process.findRangeByAddress(a);
    if (!r) return '不在任何段';
    return r.protection + ' @' + r.base + '+0x' + a.sub(r.base).toString(16) +
      '  ' + (r.file ? r.file.path.split('/').pop() : '[anon]');
  } catch (e) { return '?'; }
}
function ptrAt(p, o) { try { return p.add(o).readPointer(); } catch (e) { return null; } }

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
let rnA = null, rnB = null, analyzed = false;
const IO = [];

function analyze() {
  if (analyzed || !rnA) return;
  analyzed = true;

  Java.perform(function () {
    s('');
    s('════ ① 拿 ArtMethod ════');
    let FindClass, GetStaticMethodID, ExceptionCheck, ExceptionClear;
    let GetStringUTFChars, ReleaseStringUTFChars;
    try {
      FindClass             = jni(6,   'pointer', ['pointer', 'pointer']);
      GetStaticMethodID     = jni(113, 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
      ExceptionCheck        = jni(228, 'int',     ['pointer']);
      ExceptionClear        = jni(17,  'void',    ['pointer']);
      GetStringUTFChars     = jni(169, 'pointer', ['pointer', 'pointer', 'pointer']);
      ReleaseStringUTFChars = jni(170, 'void',    ['pointer', 'pointer', 'pointer']);
    } catch (e) { s('  JNI err: ' + e); return; }

    const jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
    if (jclass.isNull()) { s('  ✗ FindClass'); return; }
    if (ExceptionCheck(envPtr)) ExceptionClear(envPtr);
    const mid = GetStaticMethodID(envPtr, jclass,
                  Memory.allocUtf8String('signRequest'), Memory.allocUtf8String(SIG_SR));
    if (mid.isNull()) { s('  ✗ GetStaticMethodID'); return; }
    if (ExceptionCheck(envPtr)) ExceptionClear(envPtr);
    s('  ArtMethod* = ' + mid);

    const dataPtr = ptrAt(mid, 0x18);      // data_
    const entry   = ptrAt(mid, 0x20);      // entry_quick
    s('  data_       = ' + dataPtr + '   ' + seg(dataPtr));
    s('  entry_quick = ' + entry + '   ' + seg(entry));
    if (!dataPtr || dataPtr.isNull()) { s('✗ data_ 为空'); return; }

    // ══ ② ★ hook data_（真实现）══
    s('');
    s('════ ② ★★★ hook data_ = ' + dataPtr + ' ════');
    let implHits = 0;
    try {
      Interceptor.attach(dataPtr, {
        onEnter: function (args) {
          implHits++;
          const tag = 'impl#' + implHits;
          // 参数：x0=env, x1=clazz, x2=json, x3=envCode
          let json = null, ec = null;
          try { ec = args[3].toInt32(); } catch (e) {}
          try {
            const p = GetStringUTFChars(envPtr, args[2], ptr(0));
            json = p.readUtf8String();
            ReleaseStringUTFChars(envPtr, args[2], p);
          } catch (e) { json = 'read-err'; }
          this.json = json; this.ec = ec; this.tag = tag;
          s('  ► ' + tag + '  json=' + JSON.stringify((json || '').substring(0, 60)) +
            '  envCode=' + ec);
          s('      env=' + args[0] + '  clazz=' + args[1]);
        },
        onLeave: function (rv) {
          let out = null;
          try {
            if (rv && !rv.isNull()) {
              const p = GetStringUTFChars(envPtr, rv, ptr(0));
              out = p.readUtf8String();
              ReleaseStringUTFChars(envPtr, rv, p);
            }
          } catch (e) { out = 'read-err'; }
          IO.push({ in: this.json, env: this.ec, out: out });
          s('  ◄ ' + this.tag + '  → ' + JSON.stringify((out || '').substring(0, 60)) +
            '   (长度 ' + (out ? out.length : 0) + ')');
        }
      });
      s('  ✓ hook OK（本次必然触发）');
    } catch (e) { s('  ✗ hook 失败: ' + e); return; }

    // ══ ③ 也 hook 注册指针 + entry_quick 作对照 ══
    s('');
    s('════ ③ 对照组 hook ════');
    [
      ['rnA(libNetHTProtect)', rnA],
      ['rnB(libNetHTProtect)', rnB],
      ['entry_quick(libart)',  entry],
    ].forEach(function (x) {
      if (!x[1] || x[1].isNull()) return;
      try {
        Interceptor.attach(x[1], {
          onEnter: function () { IO.push({ tag: x[0] }); s('  ► [' + x[0] + '] 触发'); }
        });
        s('  ✓ hook ' + x[0]);
      } catch (e) { s('  ✗ ' + x[0] + ': ' + String(e).substring(0, 70)); }
    });

    // ══ ④ 调用并观察 ══
    s('');
    s('════ ④ 调用 signRequest ════');
    try {
      const H = Java.use('com.huachenjie.c.HcjNative');
      [['{"probe":1}', 0], ['{}', 0], ['{"a":2}', 0], ['{"probe":1}', 9], ['{"probe":1}', 11]]
        .forEach(function (c) {
          let o = null;
          try { o = String(H.signRequest(c[0], c[1])); } catch (e) { o = 'ERR:' + String(e).substring(0, 50); }
          s('  ' + c[0] + '@env' + c[1] + ' → ' + (o || '').substring(0, 52));
        });
    } catch (e) { s('  err: ' + e); }

    // ══ ⑤ 汇总 ══
    s('');
    s('════ ⑤ ★★★ 捕获的完整输入输出对 ════');
    const ioPairs = IO.filter(function (x) { return x.in !== undefined && x.out !== undefined; });
    if (!ioPairs.length) {
      s('  ⚠ 未捕获到 data_ 的 IO 对（implHits=' + implHits + '）');
    } else {
      ioPairs.forEach(function (p, i) {
        s('  [' + i + '] in  = ' + JSON.stringify(p.in));
        s('      env = ' + p.env);
        s('      out = ' + p.out);
        s('      长度 = ' + (p.out ? p.out.length : 0));
      });
    }
    s('');
    s('  data_ 触发次数 = ' + implHits);
    s('  其它 hook 记录数 = ' + (IO.length - ioPairs.length));
    send({ t: 'FINAL', dataPtr: String(dataPtr), entry: String(entry),
           implHits: implHits, io: ioPairs,
           otherHits: IO.filter(function (x) { return x.tag; }) });
  });
}

// RN hook
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
            if (sig !== SIG_SR) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (!fn || fn.isNull()) continue;
            if (!rnA) { rnA = fn; s('[RN] A=' + fn); }
            else if (!rnB && !fn.equals(rnA)) { rnB = fn; s('[RN] B=' + fn); }
          }
        } catch (e) {}
        if (rnA && !analyzed) { try { analyze(); } catch (e) { s('[RN→analyze] ' + e); } }
      }
    });
    s('[A] RN hook OK');
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
s('[boot] v29 就绪');
