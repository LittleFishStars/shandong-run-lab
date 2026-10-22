/**
 * v31 ★★ 用预言机抓大量 IO 对 → 离线验证 SHA-256 假设。
 *
 * 已知：
 *   · 真实现 = ArtMethod.data_ = liby.so+0x1e320（可直接 NativeFunction 调用）
 *   · 静态反汇编确认内部有**标准 SHA-256**（Σ0/Σ1/σ0/σ1 常量全命中）
 *   · 输出恒 108 字符 base64 = 80 字节
 *   · env∈{9,11} 与 env=0 走不同密钥；env=9 与 11 相同
 *
 * 目标：抓足够多的 IO 对（含边界长度），供离线穷举验证：
 *   · SHA256(json) 的前 80 字节？
 *   · SHA256(key || json) / SHA256(json || key)？
 *   · HMAC-SHA256(key, json)？
 *   · SHA512/384/224 截断？
 *   · 多轮 SHA-256 / SHA-256(SHA-256(...))？
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
function ptrAt(p, o) { try { return p.add(o).readPointer(); } catch (e) { return null; } }

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
let rnA = null, analyzed = false;
const PAIRS = [];

function analyze() {
  if (analyzed || !rnA) return;
  analyzed = true;

  Java.perform(function () {
    let FindClass, GetStaticMethodID, NewStringUTF, GetStringUTFChars, ReleaseStringUTFChars;
    let ExceptionCheck, ExceptionClear;
    try {
      FindClass             = jni(6,   'pointer', ['pointer', 'pointer']);
      GetStaticMethodID     = jni(113, 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
      NewStringUTF          = jni(167, 'pointer', ['pointer', 'pointer']);
      GetStringUTFChars     = jni(169, 'pointer', ['pointer', 'pointer', 'pointer']);
      ReleaseStringUTFChars = jni(170, 'void',    ['pointer', 'pointer', 'pointer']);
      ExceptionCheck        = jni(228, 'int',     ['pointer']);
      ExceptionClear        = jni(17,  'void',    ['pointer']);
    } catch (e) { s('JNI err: ' + e); return; }

    const jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
    if (jclass.isNull()) { s('✗ FindClass'); return; }
    if (ExceptionCheck(envPtr)) ExceptionClear(envPtr);
    const mid = GetStaticMethodID(envPtr, jclass, Memory.allocUtf8String('signRequest'),
                                  Memory.allocUtf8String(SIG_SR));
    if (mid.isNull()) { s('✗ GetStaticMethodID'); return; }
    if (ExceptionCheck(envPtr)) ExceptionClear(envPtr);

    const dataPtr = ptrAt(mid, 0x18);
    s('');
    s('═══ 预言机就绪 ═══');
    s('  data_ = ' + dataPtr);
    const impl = new NativeFunction(dataPtr, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);

    function call(json, ec) {
      try {
        const js = NewStringUTF(envPtr, Memory.allocUtf8String(json));
        const ret = impl(envPtr, jclass, js, ec);
        if (ExceptionCheck(envPtr)) { ExceptionClear(envPtr); return null; }
        if (!ret || ret.isNull()) return null;
        const p = GetStringUTFChars(envPtr, ret, ptr(0));
        const o = p.readUtf8String();
        ReleaseStringUTFChars(envPtr, ret, p);
        return o;
      } catch (e) { return null; }
    }

    // ══ 抓样本：覆盖多长度 + 多内容 + 多 env ══
    const CASES = [];
    // 基础
    ['{}', '{"a":1}', '{"a":2}', '{"probe":1}', '{"probe":2}'].forEach(function (j) {
      CASES.push([j, 0]);
    });
    // 长度扫描（关键：找长度依赖规律）
    for (let n = 0; n <= 40; n++) {
      CASES.push(['{"k":"' + 'a'.repeat(n) + '"}', 0]);
    }
    // 空串与单字符
    ['', 'a', '0'].forEach(function (j) { CASES.push([j, 0]); });
    // env 变体
    [0, 1, 9, 11, 255].forEach(function (e) { CASES.push(['{"probe":1}', e]); });

    CASES.forEach(function (c) {
      const out = call(c[0], c[1]);
      if (out !== null) PAIRS.push({ in: c[0], env: c[1], out: out });
    });

    s('  捕获 ' + PAIRS.length + ' 组 IO 对');
    s('');
    s('═══ 样本（前 20 组）═══');
    PAIRS.slice(0, 20).forEach(function (p, i) {
      s('  [' + i + '] in=' + JSON.stringify(p.in) + ' env=' + p.env);
      s('       out=' + p.out);
    });

    // ══ 统计 ══
    s('');
    s('═══ 输出特征 ═══');
    const lens = {};
    PAIRS.forEach(function (p) { lens[p.out.length] = (lens[p.out.length] || 0) + 1; });
    s('  长度分布: ' + JSON.stringify(lens));

    // 长度依赖检测
    s('');
    s('═══ 长度扫描（in 长度 → out 前 24 字符）═══');
    const lenScan = PAIRS.filter(function (p) { return p.in.indexOf('{"k":"') === 0; });
    lenScan.forEach(function (p) {
      s('  in.len=' + String(p.in.length).padStart(3) + '  →  ' + p.out.substring(0, 24));
    });

    send({ t: 'PAIRS', pairs: PAIRS });
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
            if (fn && !fn.isNull() && !rnA) { rnA = fn; }
          }
        } catch (e) {}
        if (rnA && !analyzed) { try { analyze(); } catch (e) { s('analyze err: ' + e); } }
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
        s('[DC] warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 16));
      } catch (e) {}
    });
  }
});
s('[boot] v31 就绪');
