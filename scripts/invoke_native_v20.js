/**
 * v20 ★主动调用 signRequest 的 native 实现（绕过 Java2C 阻隔）。
 *
 * 逻辑链条：
 *   ① 通过 RegisterNatives 按 JNI 签名拿到 signRequest 的 fnPtr（已验证 = base+0x24926c）
 *   ② 用 JNINativeInterface 的 NewStringUTF 构造入参 jstring
 *   ③ 用 NativeFunction 直接调用该 fnPtr —— 不经过 Java 层，因此不受 Java2C 影响
 *   ④ 读回返回值；与 Java 层 HcjNative.signRequest 的结果对比
 *      · 一致 ⇒ 这就是真实现，且我们获得了可自由调用的「预言机」
 *      · 不一致 ⇒ Java2C 走的是另一条 native 路径（需继续追 CallStaticObjectMethod）
 *   ⑤ 调用会触发 .bss 中 4 张表的惰性初始化 → 立刻 dump 这些表
 *
 * 函数原型（来自 Ghidra 反编译 FUN_0034926c）：
 *     jstring FUN(long *env, jclass cls, jstring json, int envCode)
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
    s('[cal] GetVersion=0x' + ver.toString(16));
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败'); table = null; }
  } catch (e) { s('[cal] err: ' + e); table = null; }
});

// JNI 函数（按 vtable 索引）
function mk(idx, ret, args) {
  return new NativeFunction(table.add(idx * 8).readPointer(), ret, args);
}

function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFFSET_GUESS = 0x24926c;
let handled = false;

function work(fnPtr) {
  if (handled) return;
  handled = true;

  s('');
  s('════ ① 目标 fnPtr ════');
  s('  fnPtr = ' + fnPtr);
  const r = Process.findRangeByAddress(fnPtr);
  s('  段 = ' + (r ? r.base + ' sz=0x' + r.size.toString(16) + ' ' + r.protection : '?'));
  const base = fnPtr.sub(OFFSET_GUESS);
  s('  推算 base = ' + base);
  const sig = hex(base.add(0x24926c), 16);
  s('  base+0x24926c 前 16 字节 = ' + sig + (sig === 'ff8301d1f85f02a9f65703a9f44f04a9' ? '  ✓ 与磁盘一致' : '  ⚠ 不一致'));

  // ══ 构造 JNI 工具 ══
  let NewStringUTF, GetStringUTFChars, ReleaseStringUTFChars, ExceptionCheck, ExceptionDescribe;
  try {
    NewStringUTF          = mk(167, 'pointer', ['pointer', 'pointer']);
    GetStringUTFChars     = mk(169, 'pointer', ['pointer', 'pointer', 'pointer']);
    ReleaseStringUTFChars = mk(170, 'void',    ['pointer', 'pointer', 'pointer']);
    ExceptionCheck        = mk(228, 'int',     ['pointer']);
    ExceptionDescribe     = mk(218, 'void',    ['pointer']);
    s('  JNI 工具就绪');
  } catch (e) { s('  ✗ JNI 工具构建失败: ' + e); return; }

  // ══ ② 直接调用 native 实现 ══
  s('');
  s('════ ② 主动调用 native 实现 ════');
  const targetFn = new NativeFunction(fnPtr, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);
  const CASES = [
    ['{"probe":1}', 0],
    ['{}',          0],
    ['{"a":2}',     0],
    ['{"probe":1}', 9],     // 测试环境 env
    ['{"probe":1}', 11],
  ];
  const nativeOut = {};
  CASES.forEach(function (c) {
    const inp = c[0], ec = c[1];
    let out = null, err = null;
    try {
      const js = NewStringUTF(table, Memory.allocUtf8String(inp));
      const ret = targetFn(table, ptr(0), js, ec);
      if (ExceptionCheck(table)) {
        err = 'JNI 异常';
        try { ExceptionDescribe(table); } catch (e2) {}
      } else if (ret && !ret.isNull()) {
        const cc = GetStringUTFChars(table, ret, ptr(0));
        out = cc.readUtf8String();
        ReleaseStringUTFChars(table, ret, cc);
      }
    } catch (e) { err = String(e).substring(0, 120); }
    const key = inp + '@env' + ec;
    nativeOut[key] = out;
    s('  native(' + key + ') → ' + (out ? JSON.stringify(out.substring(0, 60)) : ('失败: ' + err)));
  });
  send({ t: 'native', out: nativeOut });

  // ══ ③ 对比 Java 层 ══
  s('');
  s('════ ③ 与 Java 层对比 ════');
  const javaOut = {};
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    CASES.forEach(function (c) {
      const inp = c[0], ec = c[1];
      let out = null;
      try { out = String(H.signRequest(inp, ec)); } catch (e) { out = 'ERR:' + String(e).substring(0, 60); }
      const key = inp + '@env' + ec;
      javaOut[key] = out;
      s('  java(' + key + ') → ' + (out ? JSON.stringify(out.substring(0, 60)) : 'null'));
    });
  } catch (e) { s('  Java 调用 err: ' + e); }

  s('');
  s('════ ④ 一致性判定 ════');
  let same = 0, diff = 0, total = 0;
  Object.keys(nativeOut).forEach(function (k) {
    if (!(k in javaOut)) return;
    total++;
    const a = nativeOut[k], b = javaOut[k];
    const eq = a && b && a === b;
    if (eq) same++; else diff++;
    s('  ' + k + '  ' + (eq ? '✓ 一致' : '✗ 不同'));
    if (!eq) {
      s('     native = ' + JSON.stringify(String(a).substring(0, 50)));
      s('     java   = ' + JSON.stringify(String(b).substring(0, 50)));
    }
  });
  s('  一致 ' + same + ' / 不同 ' + diff + ' / 共 ' + total);
  send({ t: 'cmp', same: same, diff: diff, total: total, native: nativeOut, java: javaOut });

  // ══ ⑤ 表初始化后 dump ══
  s('');
  s('════ ⑤ .bss 密钥表 dump（调用后）════');
  [['delta_key', 0x47c970, 0x40], ['whiteT0', 0x47c9b0, 0x10],
   ['T1', 0x47c9b8, 0x400], ['T2', 0x47cdb8, 0x400],
   ['T3', 0x47d1b8, 0x400], ['T4', 0x47d5b8, 0x400]].forEach(function (t) {
    const h = hex(base.add(t[1]), t[2]);
    if (h) {
      const allZero = h === '0'.repeat(h.length);
      s('  ' + t[0].padEnd(10) + ' +0x' + t[1].toString(16) + '  ' +
        (allZero ? '（仍全零）' : h.substring(0, 64) + '…'));
      if (!allZero) send({ t: 'table', name: t[0], off: t[1], hex: h });
    } else s('  ' + t[0] + ' 读取失败');
  });

  s('');
  s('════ 完成 ════');
}

// ══ RegisterNatives ══
Java.perform(function () {
  if (!table) { s('✗ 无 JNI 表'); return; }
  try {
    const rn = table.add(215 * 8).readPointer();
    s('[A] RegisterNatives = ' + rn);
    Interceptor.attach(rn, {
      onEnter: function (a) {
        if (handled) return;
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
            if (fn && !fn.isNull()) { work(fn); return; }
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] hook 已装');
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
    });
  }
});
s('[boot] v20 主动调用就绪');
