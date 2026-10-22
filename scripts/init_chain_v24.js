/**
 * v24 ★★ 打通全链路：主动调用 init 函数 → 4 张表初始化 → 再调 signRequest。
 *
 * 已确认（v23 + Ghidra）：
 *   · JNIEnv 传参修正后，native 调用**不再 abort**，但返回**空串**
 *   · 原因 = FUN_0034b820 开头的惰性初始化守卫：
 *         if ((DAT_005d26c8 & 1) == 0) { 输出空串; return; }
 *   · 写该守卫的唯一函数 = FUN_0034a644（运行时偏移 **0x24a644**）
 *         void FUN_0034a644(char *key_material, u64 p2, u64 p3, u64 p4, long extra)
 *         末尾：DAT_005d26c8 = 1;
 *   · 该函数内的 XOR 字符串已解出："ioos" / "product number illegal " / "lse_"
 *   · 4 张表的生成器 = FUN_001780dc（运行时偏移 **0x780dc**，有 WRITE 引用）
 *
 * 策略：
 *   ① 先试**直接调用 init(+0x24a644)**，用从 Java 层已知的信息构造参数：
 *        · 参数1 = 授权串候选（"ioos" / 包名 / 空）
 *        · 观察守卫是否被置位（读 base+0x4d26c8）
 *   ② 若守卫置位但表仍零 → 再调 FUN_00348470（配置注入）
 *   ③ 表就绪后调 signRequest，与 Java 层对比
 *
 * 兜底：同时 hook init(+0x24a644) 与表生成器(+0x780dc)，
 *       观察 Java 层调用时是否走到（若走到 → 抓参数即可复现）
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
    s('[cal] GetVersion=0x' + (gv(envPtr) >>> 0).toString(16));
  } catch (e) { s('[cal] err: ' + e); }
});

function jni(i, r, a) { return new NativeFunction(table.add(i * 8).readPointer(), r, a); }
function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}
function u8(p) { try { return p.readU8(); } catch (e) { return -1; } }

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFF_SIGN = 0x24926c, OFF_INIT = 0x24a644, OFF_GUARD = 0x4d26c8, OFF_T1 = 0x47c9b8;
let base = null, done = false;

function work(fnPtr) {
  if (done) return; done = true;
  base = fnPtr.sub(OFF_SIGN);

  s('');
  s('════ ① 环境 ════');
  s('  fnPtr = ' + fnPtr + '   base = ' + base);
  s('  校验 = ' + hex(base.add(OFF_SIGN), 16));
  s('  守卫 DAT_005d26c8 (base+0x4d26c8) 当前 = 0x' + (u8(base.add(OFF_GUARD)) & 0xff).toString(16));
  s('  T1 表 (base+0x47c9b8) 前 32B = ' + hex(base.add(OFF_T1), 32));

  let FindClass, NewStringUTF, GetStringUTFChars, ReleaseStringUTFChars, ExceptionCheck, ExceptionClear;
  try {
    FindClass             = jni(6,   'pointer', ['pointer', 'pointer']);
    NewStringUTF          = jni(167, 'pointer', ['pointer', 'pointer']);
    GetStringUTFChars     = jni(169, 'pointer', ['pointer', 'pointer', 'pointer']);
    ReleaseStringUTFChars = jni(170, 'void',    ['pointer', 'pointer', 'pointer']);
    ExceptionCheck        = jni(228, 'int',     ['pointer']);
    ExceptionClear        = jni(17,  'void',    ['pointer']);
  } catch (e) { s('  JNI 工具 err: ' + e); return; }

  let jclass = ptr(0);
  try {
    jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
  } catch (e) {}
  s('  jclass = ' + jclass);

  // ══ ② hook init + 表生成器（观察 Java 层调用是否走到）══
  s('');
  s('════ ② hook init(+0x24a644) 与表生成器(+0x780dc) ════');
  let initHits = 0, genHits = 0, initArgs = null;
  try {
    Interceptor.attach(base.add(OFF_INIT), {
      onEnter: function (a) {
        initHits++;
        let p1 = null;
        try { p1 = a[0].readCString(); } catch (e) {}
        initArgs = { a0: String(a[0]), cstr: p1, a1: String(a[1]), a2: String(a[2]), a3: String(a[3]), a4: String(a[4]) };
        s('  ► init 被调用! arg0=' + a[0] + '  cstr=' + JSON.stringify(p1));
        s('     arg1=' + a[1] + ' arg2=' + a[2] + ' arg3=' + a[3] + ' arg4=' + a[4]);
      },
      onLeave: function () {
        s('  ◄ init 返回，守卫=' + (u8(base.add(OFF_GUARD)) & 0xff) +
          '  T1=' + (hex(base.add(OFF_T1), 16) || '').substring(0, 32));
      }
    });
    s('  ✓ init hook OK');
  } catch (e) { s('  ✗ init hook: ' + e); }
  try {
    Interceptor.attach(base.add(0x780dc), {
      onEnter: function (a) {
        genHits++;
        s('  ► 表生成器 被调用! self=' + a[0] + ' arg1=0x' + a[1].toInt32().toString(16) +
          ' arg2=0x' + a[2].toInt32().toString(16));
      },
      onLeave: function () {
        s('  ◄ 表生成器返回，T1=' + (hex(base.add(OFF_T1), 32) || ''));
      }
    });
    s('  ✓ 生成器 hook OK');
  } catch (e) { s('  ✗ 生成器 hook: ' + e); }

  // ══ ③ 主动调用 init（多组候选参数）══
  s('');
  s('════ ③ 主动调用 init(+0x24a644) ════');
  let initFn = null;
  try { initFn = new NativeFunction(base.add(OFF_INIT), 'void',
            ['pointer', 'pointer', 'pointer', 'pointer', 'pointer']); } catch (e) { s('  构建失败: ' + e); }

  const CAND = ['ioos', 'com.huachenjie.shandong_school', '', '0123456789abcdefghij'];
  CAND.forEach(function (k) {
    if (initHits > 0) return;    // 已被 Java 层调用过就跳过
    s('  尝试 key=' + JSON.stringify(k));
    try {
      initFn(Memory.allocUtf8String(k), ptr(0), ptr(0), ptr(0), ptr(0));
      s('    → 返回，守卫=' + (u8(base.add(OFF_GUARD)) & 0xff) +
        '  T1前16=' + (hex(base.add(OFF_T1), 16) || ''));
    } catch (e) { s('    → 异常: ' + String(e).substring(0, 100)); }
  });

  // ══ ④ 调 Java 层（若 init 由 Java 触发，这里能抓到）══
  s('');
  s('════ ④ 调 Java 层 signRequest（抓 init 触发）════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    ['{"probe":1}', '{}'].forEach(function (inp) {
      s('  ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 48));
    });
  } catch (e) { s('  ' + e); }

  s('');
  s('════ ⑤ 状态汇总 ════');
  s('  init 被调用 ' + initHits + ' 次');
  if (initArgs) s('  init 参数: ' + JSON.stringify(initArgs));
  s('  表生成器被调用 ' + genHits + ' 次');
  s('  守卫 = ' + (u8(base.add(OFF_GUARD)) & 0xff));
  s('  T1 前 64B = ' + (hex(base.add(OFF_T1), 64) || ''));
  ['delta_key:0x47c970', 'whiteT0:0x47c9b0', 'T2:0x47cdb8', 'T3:0x47d1b8', 'T4:0x47d5b8'].forEach(function (x) {
    const p = x.split(':'), nm = p[0], off = parseInt(p[1]);
    const h = hex(base.add(off), 32);
    if (h) s('  ' + nm + ' = ' + h + (h === '0'.repeat(64) ? '（全零）' : ' ★非零'));
  });
  send({ t: 'state', initHits: initHits, genHits: genHits, initArgs: initArgs,
         guard: u8(base.add(OFF_GUARD)) & 0xff,
         t1: hex(base.add(OFF_T1), 64) });
}

Java.perform(function () {
  if (!table) return;
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
            if (fn && !fn.isNull()) { work(fn); return; }
          }
        } catch (e) {}
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
s('[boot] v24 就绪');
