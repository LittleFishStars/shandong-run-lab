/**
 * v32 ★★★★★ hook liby.so 内部的 SHA-256 压缩函数 → 抓真实输入！
 *
 * 静态已确认（capstone 反汇编）：
 *   0x1fed4  = SHA-256 压缩函数入口（sub sp,sp,#0x170）
 *      · 0x1ff48-0x1ff5c: σ1 = ROTR17 ^ ROTR19 ^ SHR10   （消息扩展）
 *      · 0x1ff54-0x1ff5c: σ0 = ROTR7 ^ ROTR18 ^ SHR3
 *      · 0x1ffc0-0x1ffd0: Σ1 = ROTR6 ^ ROTR11 ^ ROTR25   （压缩）
 *      · 0x1fffc-0x20010: Σ0 = ROTR2 ^ ROTR13 ^ ROTR22
 *      · cmp x11,#0xfc (64 轮) / cmp x9,#0x40 (64 字节块)
 *      · adrp x5,#0x15000 + #0x900 → K[64] 常量表
 *
 * 本脚本：
 *   ① hook 0x1fed4，抓 (状态入参, 消息块)
 *      · 参数约定（AAPCS64）：x0=状态(state[8] u32*), x1=消息块(64B), 可能 x2=?
 *   ② 每次调用记录 state 与 block → 重建完整的哈希链
 *   ③ 调 signRequest 产生样本
 *   ④ 输出所有 (state_in, block_in) 对 → 离线可完整复现算法
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

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
let rnA = null, analyzed = false;
const CALLS = [];

// SHA-256 压缩函数的候选 vaddr（相对 dump 基址 0x1000 的运行时 vaddr）
const SHA_CANDS = [0x1fed4, 0x1fbf4, 0x1f1c0];

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
    s('═══ 目标 ═══');
    s('  data_ = ' + dataPtr + '  (liby.so+0x1e320)');

    // ══ ① 动态定位 liby.so 段基址 ══
    const segBase = dataPtr.sub(0x1e320);       // 段基址 = vaddr 0
    s('  liby 段基址 = ' + segBase);
    s('  校验 0x1e320 处 = ' + hex(dataPtr, 16));

    // ══ ② hook SHA-256 压缩函数 ══
    s('');
    s('═══ hook SHA-256 压缩函数 ═══');
    let hookedCnt = 0;
    SHA_CANDS.forEach(function (va) {
      const addr = segBase.add(va);
      try {
        Interceptor.attach(addr, {
          onEnter: function (args) {
            // AAPCS64: x0=state(u32[8]), x1=block(64B)
            const st = hex(args[0], 32);
            const blk = hex(args[1], 64);
            CALLS.push({ va: va, state: st, block: blk, x2: String(args[2]), x3: String(args[3]) });
            s('  ► SHA@0x' + va.toString(16) +
              '  state=' + (st || '').substring(0, 24) +
              '  block=' + (blk || '').substring(0, 64));
          }
        });
        hookedCnt++;
        s('  ✓ hook 0x' + va.toString(16) + '  (= ' + addr + ')');
      } catch (e) { s('  ✗ 0x' + va.toString(16) + ': ' + String(e).substring(0, 80)); }
    });
    s('  共 hook ' + hookedCnt + ' 个');

    // ══ ③ 调用产生样本 ══
    s('');
    s('═══ 调用 signRequest ═══');
    const impl = new NativeFunction(dataPtr, 'pointer', ['pointer', 'pointer', 'pointer', 'int']);
    [['{}', 0], ['{"a":1}', 0], ['{"probe":1}', 0]].forEach(function (c) {
      CALLS.length = 0;
      let out = null;
      try {
        const js = NewStringUTF(envPtr, Memory.allocUtf8String(c[0]));
        const ret = impl(envPtr, jclass, js, c[1]);
        if (!ExceptionCheck(envPtr) && ret && !ret.isNull()) {
          const p = GetStringUTFChars(envPtr, ret, ptr(0));
          out = p.readUtf8String();
          ReleaseStringUTFChars(envPtr, ret, p);
        } else { if (ExceptionCheck(envPtr)) ExceptionClear(envPtr); }
      } catch (e) {}
      s('  in=' + JSON.stringify(c[0]) + ' env=' + c[1] +
        ' → ' + (out ? out.substring(0, 40) : 'null') +
        '   （SHA 调用 ' + CALLS.length + ' 次）');
      if (CALLS.length) {
        s('    ── 哈希调用序列 ──');
        CALLS.forEach(function (x, i) {
          s('      [' + i + '] SHA@0x' + x.va.toString(16) +
            '  state=' + x.state + '  block=' + x.block);
        });
        send({ t: 'SHA', input: c[0], env: c[1], out: out, calls: CALLS.slice() });
      }
    });

    s('');
    s('═══ 完成 ═══');
    send({ t: 'DONE', calls: CALLS.length });
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
s('[boot] v32 就绪');
