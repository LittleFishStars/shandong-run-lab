/**
 * v33 ★★★★★ 追踪回调分发 —— 抓 JSON 解析器实际调用的所有回调地址。
 *
 * 静态发现（capstone）：
 *   0x419a0 核心 → 0x41a28 分发器
 *     0x41a50  mov x19, x3        ← x3 来自 0x419dc 的 ldr x4,[x19,#0x18] 系
 *     0x41a94  blr x19            ← ★ 回调调用点 1
 *     0x41a9c  ldr x8, [sp, #0x20]
 *     0x41ab8  blr x8             ← ★ 回调调用点 2
 *     参数: w0=1, w1=0xa, x2=token, x3=?, x4=ctx, x5=?
 *
 * 本脚本：
 *   ① 直接调用 data_（绕开一切，路径必然正确）
 *   ② hook 0x41a94 / 0x41ab8 两处 blr，记录 x19/x8 的实际值
 *   ③ 对每个被调用的回调地址再装 hook，递归追踪
 *   ④ 输出完整回调链 → 定位真正的算法实现函数
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
function ptrAt(p, o) { try { return p.add(o).readPointer(); } catch (e) { return null; } }
function seg(a, segBase) {
  if (!a || a.isNull()) return 'null';
  try {
    const d = a.sub(segBase);
    if (d.compare(0) >= 0 && d.compare(0x46000) < 0) return 'liby+0x' + d.toString(16);
    const r = Process.findRangeByAddress(a);
    if (r) return r.protection + ' @' + r.base + '+0x' + a.sub(r.base).toString(16) +
      '  ' + (r.file ? r.file.path.split('/').pop() : '[anon]');
  } catch (e) {}
  return '?';
}

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
let rnA = null, analyzed = false;
const CALLBACKS = {};    // addr -> {count, args[]}

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
    const segBase = dataPtr.sub(0x1e320);
    s('');
    s('═══ 目标 ═══');
    s('  data_ = ' + dataPtr + '   liby 段基址 = ' + segBase);

    // ══ ① hook 两处 blr（回调分发点）══
    s('');
    s('═══ ① hook 回调分发点 ═══');
    // 0x41a94 的 blr x19：在 blr 前的指令处 hook，抓 x19
    // 0x41ab8 的 blr x8：抓 x8
    let blrCnt = 0;
    [
      ['blr1@0x41a94', 0x41a90, 'x19', 19],
      ['blr2@0x41ab8', 0x41ab4, 'x8', 8],
    ].forEach(function (x) {
      const addr = segBase.add(x[1]);
      try {
        Interceptor.attach(addr, {
          onEnter: function (args) {
            let cb = null;
            try {
              // 该指令是 mov 系列，回调指针在目标寄存器里；用上下文读
              cb = this.context[x[3]];
            } catch (e) {}
            if (!cb) return;
            blrCnt++;
            const k = 'liby+0x' + cb.sub(segBase).toString(16);
            if (!CALLBACKS[k]) CALLBACKS[k] = { count: 0, addr: cb, samples: [] };
            CALLBACKS[k].count++;
            if (CALLBACKS[k].samples.length < 3) {
              CALLBACKS[k].samples.push({
                w0: args[0].toInt32(), w1: args[1].toInt32(),
                x2: String(args[2]), x3: String(args[3]),
                x4: String(args[4]), x5: String(args[5])
              });
            }
            s('  ► ' + x[0] + '  → 回调 ' + k + '  (×' + CALLBACKS[k].count + ')');
            // ★ 首次发现该回调就给它装 hook
            if (CALLBACKS[k].count === 1) {
              try {
                Interceptor.attach(cb, {
                  onEnter: function (a2) {
                    s('    ★ 回调被调用: ' + k +
                      '  x0=' + a2[0] + ' x1=' + a2[1] + ' x2=' + a2[2]);
                  },
                  onLeave: function (rv) {
                    s('    ★ 回调返回: ' + k + '  w0=0x' + (rv.toInt32() >>> 0).toString(16));
                  }
                });
                s('    ✓ 已 hook 回调 ' + k);
              } catch (e) { s('    ✗ 无法 hook ' + k + ': ' + String(e).substring(0, 60)); }
            }
          }
        });
        s('  ✓ hook 分发点 ' + x[0] + ' @' + addr);
      } catch (e) { s('  ✗ ' + x[0] + ': ' + String(e).substring(0, 70)); }
    });

    // ══ ② 直接调用（路径必然正确）══
    s('');
    s('═══ ② 直接调用 data_ ═══');
    const impl = new NativeFunction(dataPtr, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);
    [['{"probe":1}', 0], ['{}', 0]].forEach(function (c) {
      let out = null;
      try {
        const js = NewStringUTF(envPtr, Memory.allocUtf8String(c[0]));
        const ret = impl(envPtr, jclass, js, c[1]);
        if (!ExceptionCheck(envPtr) && ret && !ret.isNull()) {
          const p = GetStringUTFChars(envPtr, ret, ptr(0));
          out = p.readUtf8String();
          ReleaseStringUTFChars(envPtr, ret, p);
        } else { if (ExceptionCheck(envPtr)) ExceptionClear(envPtr); }
      } catch (e) { s('  调用异常: ' + String(e).substring(0, 80)); }
      s('  in=' + JSON.stringify(c[0]) + ' → ' + (out ? out.substring(0, 44) : 'null'));
    });

    // ══ ③ 回调汇总 ══
    s('');
    s('═══ ③ ★★★ 捕获的回调 ═══');
    const ks = Object.keys(CALLBACKS);
    s('  回调总数: ' + ks.length + '   分发点触发 ' + blrCnt + ' 次');
    ks.forEach(function (k) {
      const c = CALLBACKS[k];
      s('  ' + k + '  ×' + c.count + '   (' + c.addr + ')');
      c.samples.forEach(function (sm, i) {
        s('      [' + i + '] w0=' + sm.w0 + ' w1=0x' + sm.w1.toString(16) +
          ' x2=' + sm.x2 + ' x3=' + sm.x3 + ' x4=' + sm.x4);
      });
    });
    send({ t: 'CB', callbacks: ks.map(function (k) {
      return { k: k, addr: String(CALLBACKS[k].addr), count: CALLBACKS[k].count,
               samples: CALLBACKS[k].samples };
    }), blrCnt: blrCnt });
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
            if (fn && !fn.isNull() && !rnA) rnA = fn;
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
s('[boot] v33 就绪');
