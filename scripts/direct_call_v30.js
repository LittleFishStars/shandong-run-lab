/**
 * v30 ★★★★★ 直接调用 ArtMethod.data_ → 确认它就是真实现 + dump 解密后的 liby.so。
 *
 * v29 结果：
 *   data_       = liby.so+0x1e320   ← hook 它 **不触发**
 *   entry_quick = libart.so 通用 JNI 桥  ← 触发 46 次
 *   ⇒ ART 走通用桥，但桥内不直接跳到 data_（或跳转方式绕过 hook）
 *
 * 本脚本（决定性）：
 *   ① 读 data_ 处的字节 → 确认是解密后的 AArch64 代码（非全零/非加密）
 *   ② 用 NativeFunction **直接调用 data_**（原型来自反汇编：
 *        jstring f(JNIEnv* x0, jclass x1, jstring x2, int x3)）
 *      · 成功 → 它就是真实现，且我们拿到可自由调用的预言机
 *      · 与 Java 层输出对比
 *   ③ dump liby.so 运行时解密后的代码区（供 Ghidra 分析）
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
      ' sz=0x' + r.size.toString(16);
  } catch (e) { return '?'; }
}
function ptrAt(p, o) { try { return p.add(o).readPointer(); } catch (e) { return null; } }

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
const SIG_PAT = 'ff4304d1fd7b0ca9fc670da9f85f0ea9';   // liby.so+0x1e320 运行时序言
let rnA = null, analyzed = false;

function analyze() {
  if (analyzed || !rnA) return;
  analyzed = true;

  Java.perform(function () {
    s('');
    s('════ ① 拿 ArtMethod.data_ ════');
    let FindClass, GetStaticMethodID, ExceptionCheck, ExceptionClear;
    let GetStringUTFChars, ReleaseStringUTFChars, NewStringUTF;
    try {
      FindClass             = jni(6,   'pointer', ['pointer', 'pointer']);
      GetStaticMethodID     = jni(113, 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
      ExceptionCheck        = jni(228, 'int',     ['pointer']);
      ExceptionClear        = jni(17,  'void',    ['pointer']);
      GetStringUTFChars     = jni(169, 'pointer', ['pointer', 'pointer', 'pointer']);
      ReleaseStringUTFChars = jni(170, 'void',    ['pointer', 'pointer', 'pointer']);
      NewStringUTF          = jni(167, 'pointer', ['pointer', 'pointer']);
    } catch (e) { s('  JNI err: ' + e); return; }

    const jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
    if (jclass.isNull()) { s('  ✗ FindClass'); return; }
    if (ExceptionCheck(envPtr)) ExceptionClear(envPtr);
    const mid = GetStaticMethodID(envPtr, jclass, Memory.allocUtf8String('signRequest'),
                                  Memory.allocUtf8String(SIG_SR));
    if (mid.isNull()) { s('  ✗ GetStaticMethodID'); return; }
    if (ExceptionCheck(envPtr)) ExceptionClear(envPtr);

    const dataPtr = ptrAt(mid, 0x18);
    s('  ArtMethod* = ' + mid);
    s('  data_      = ' + dataPtr + '   ' + seg(dataPtr));
    if (!dataPtr || dataPtr.isNull()) { s('✗ data_ 空'); return; }

    // ══ ①b 读 data_ 处字节 ══
    s('');
    s('════ ①b data_ 处字节（应为解密后的 AArch64）════');
    const b32 = hex(dataPtr, 32);
    s('  前 32B: ' + b32);
    s('  期望序言: ' + SIG_PAT);
    s('  匹配: ' + (b32 && b32.indexOf(SIG_PAT) === 0 ? '★ 是 ✓' : '✗'));

    // ══ ② ★ 直接调用 data_ ══
    s('');
    s('════ ② ★★★ 直接调用 data_ ════');
    let impl = null;
    try {
      impl = new NativeFunction(dataPtr, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);
      s('  NativeFunction 构建成功');
    } catch (e) { s('  ✗ 构建失败: ' + e); return; }

    const CASES = [['{"probe":1}', 0], ['{}', 0], ['{"a":2}', 0],
                   ['{"probe":1}', 9], ['{"probe":1}', 11]];
    const natOut = {};
    CASES.forEach(function (c) {
      const inp = c[0], ec = c[1];
      let out = null, err = null;
      try {
        const js = NewStringUTF(envPtr, Memory.allocUtf8String(inp));
        const ret = impl(envPtr, jclass, js, ec);
        if (ExceptionCheck(envPtr)) { err = 'JNI 异常'; ExceptionClear(envPtr); }
        else if (ret && !ret.isNull()) {
          const p = GetStringUTFChars(envPtr, ret, ptr(0));
          out = p.readUtf8String();
          ReleaseStringUTFChars(envPtr, ret, p);
        } else err = '返回 null';
      } catch (e) { err = String(e).substring(0, 100); }
      natOut[inp + '@env' + ec] = out;
      s('  direct(' + inp + '@env' + ec + ') → ' +
        (out ? JSON.stringify(out.substring(0, 60)) : ('失败: ' + err)));
    });
    send({ t: 'direct', out: natOut });

    // ══ ③ 与 Java 层对比 ══
    s('');
    s('════ ③ 与 Java 层对比 ════');
    const javaOut = {};
    try {
      const H = Java.use('com.huachenjie.c.HcjNative');
      CASES.forEach(function (c) {
        const k = c[0] + '@env' + c[1];
        let o = null;
        try { o = String(H.signRequest(c[0], c[1])); } catch (e) { o = 'ERR'; }
        javaOut[k] = o;
        s('  java(' + k + ') → ' + JSON.stringify((o || '').substring(0, 60)));
      });
    } catch (e) { s('  ' + e); }

    s('');
    s('════ ④ 一致性判定 ════');
    let same = 0, tot = 0;
    Object.keys(natOut).forEach(function (k) {
      if (!(k in javaOut)) return;
      tot++;
      const eq = natOut[k] && natOut[k] === javaOut[k];
      if (eq) same++;
      s('  ' + k + '  ' + (eq ? '★★★ 完全一致' : '✗ 不同'));
    });
    s('  一致 ' + same + ' / ' + tot);

    // ══ ⑤ dump liby.so 解密区 ══
    s('');
    s('════ ⑤ dump liby.so 解密后的代码区 ════');
    try {
      const r = Process.findRangeByAddress(dataPtr);
      if (r) {
        const total = Math.min(r.size, 768 * 1024);
        send({ t: 'dumpmeta', base: String(r.base), size: total });
        s('  dump ' + r.base + ' size=' + total + ' (' + (total/1024).toFixed(0) + ' KB)');
        const CHUNK = 240 * 1024;
        for (let off = 0; off < total; off += CHUNK) {
          const sz = Math.min(CHUNK, total - off);
          send({ t: 'chunk', off: off, size: sz }, r.base.add(off).readByteArray(sz));
          s('    chunk +0x' + off.toString(16) + ' (' + sz + 'B)');
        }
      }
    } catch (e) { s('  dump err: ' + e); }

    send({ t: 'FINAL', dataPtr: String(dataPtr), same: same, total: tot });
  });
}

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
            if (fn && !fn.isNull() && !rnA) { rnA = fn; s('[RN] ' + fn); }
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
s('[boot] v30 就绪');
