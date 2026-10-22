/**
 * v34 ★★★★★ 解码 GOT 表 —— 抓 PLT 跳板的真实目标地址。
 *
 * 静态发现（capstone）：
 *   0x45e00-0x45f60 = PLT 跳板区（384 字节，24 项）
 *   每项 16 字节：
 *     adrp x16, #0x4a000          ← 页基址
 *     ldr  x17, [x16, #0xdNN]     ← ★ 从 GOT 读函数指针
 *     add  x16, x16, #0xdNN
 *     br   x17                    ← ★★ 真实跳转
 *   GOT 表: 0x4a000 + 0xd40 .. 0xdd0（每项 8 字节）
 *
 *   0x1e320（signRequest）调用的 10 个目标全部在这些跳板上：
 *     0x45e30←0x1e358  0x45ed0←0x1e364  0x45ee0←0x1e398/0x1e3c4/0x1e3f0
 *     0x45e40←0x1e45c  0x45e50←6 处     0x45ef0←0x1e41c
 *     0x45f00←0x1e510  0x45f10←0x1e52c  0x45f20←0x1e56c  0x45f30←0x1e57c
 *
 * 本脚本：
 *   ① 读 GOT 表中这 10 项的运行时值 → 得到真实函数地址
 *   ② 对每个真实地址：locate + 前 16 字节 + 装 hook
 *   ③ 直接调用 signRequest → 看哪些被触发
 *   ④ 命中的函数：dump 其完整代码（→ 交给离线反汇编）
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
function loc(a, segBase) {
  if (!a || a.isNull()) return 'null';
  try {
    const d = a.sub(segBase);
    if (d.compare(0) >= 0 && d.compare(0x46000) < 0) return '★ liby+0x' + d.toString(16);
    const r = Process.findRangeByAddress(a);
    if (r) return r.protection + ' ' + (r.file ? r.file.path.split('/').pop() : '[anon]') +
      '+0x' + a.sub(r.base).toString(16);
  } catch (e) {}
  return '不在段内';
}

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
let rnA = null, analyzed = false;
const HIT = {};

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
    s('═══ ① 目标与段基址 ═══');
    s('  data_ = ' + dataPtr);
    s('  segBase = ' + segBase);

    // ══ ② 解码 GOT 表 ══
    s('');
    s('═══ ② ★★★ GOT 表解码（0x4a000 + 0xd40..0xdd0）═══');
    const GOT_OFFS = [0xd40, 0xd48, 0xd50, 0xd58, 0xd60, 0xd68, 0xd70,
                      0xd78, 0xd80, 0xd88, 0xd90, 0xd98, 0xda0, 0xda8,
                      0xdb0, 0xdb8, 0xdc0, 0xdc8, 0xdd0];
    const GOT = {};
    GOT_OFFS.forEach(function (o) {
      const p = ptrAt(segBase.add(0x4a000), o);
      const pltVA = 0x45e00 + ((o - 0xd40) / 8) * 0x10;
      GOT[o] = p;
      s('  GOT[0x' + o.toString(16) + '] = ' + p + '   ← PLT 0x' + pltVA.toString(16));
      s('      目标: ' + loc(p, segBase));
      s('      前 16B: ' + hex(p, 16));
    });

    // ══ ③ 给 0x1e320 用到的 10 个跳板目标装 hook ══
    s('');
    s('═══ ③ hook 跳板目标 ═══');
    // (GOT偏移, PLT vaddr, 调用点)
    const USED = [
      [0xd58, 0x45e30, '0x1e358'],
      [0xda8, 0x45ed0, '0x1e364'],
      [0xdb0, 0x45ee0, '0x1e398/0x1e3c4/0x1e3f0'],
      [0xd60, 0x45e40, '0x1e45c'],
      [0xd68, 0x45e50, '×6 处'],
      [0xdb8, 0x45ef0, '0x1e41c'],
      [0xdc0, 0x45f00, '0x1e510'],
      [0xdc8, 0x45f10, '0x1e52c'],
      [0xdd0, 0x45f20, '0x1e56c'],
      [0xdd8, 0x45f30, '0x1e57c'],
    ];
    const hooked = {};
    USED.forEach(function (x) {
      const p = GOT[x[0]];
      if (!p || p.isNull()) { s('  ✗ GOT[0x' + x[0].toString(16) + '] 空'); return; }
      const k = p.toString();
      if (hooked[k]) { s('  （重复目标 ' + k + '，跳过）'); return; }
      try {
        Interceptor.attach(p, {
          onEnter: function (args) {
            HIT[k] = (HIT[k] || 0) + 1;
            if (HIT[k] <= 2) {
              s('  ►►► 命中 PLT0x' + x[1].toString(16) + ' → ' + loc(p, segBase) +
                '   x0=' + args[0] + ' x1=' + args[1] + ' x2=' + args[2]);
            }
          }
        });
        hooked[k] = { plt: x[1], site: x[2] };
        s('  ✓ hook ' + loc(p, segBase) + '  (PLT 0x' + x[1].toString(16) + ', 调用点 ' + x[2] + ')');
      } catch (e) { s('  ✗ hook ' + k + ': ' + String(e).substring(0, 60)); }
    });

    // ══ ④ 直接调用 ══
    s('');
    s('═══ ④ 直接调用 signRequest ═══');
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
      } catch (e) {}
      s('  in=' + JSON.stringify(c[0]) + ' → ' + (out ? out.substring(0, 44) : 'null'));
    });

    // ══ ⑤ 命中汇总 + dump 命中函数 ══
    s('');
    s('═══ ⑤ ★★★ 命中汇总 ═══');
    const ks = Object.keys(HIT);
    if (!ks.length) s('  （全 0）');
    ks.forEach(function (k) {
      const h = hooked[k] || {};
      s('  ' + loc(ptr(k), segBase) + '  ×' + HIT[k] +
        '   (PLT 0x' + (h.plt || 0).toString(16) + ')');
    });

    // dump 命中目标的代码
    ks.forEach(function (k) {
      const p = ptr(k);
      const d = p.sub(segBase);
      if (d.compare(0) >= 0 && d.compare(0x46000) < 0) {
        const off = d.toInt32();
        s('  ★ 命中目标在 liby 内: +0x' + off.toString(16) + '  → 已 dump 全部代码区，可离线反汇编');
      }
    });

    send({ t: 'GOT', got: Object.keys(GOT).map(function (o) {
      return { off: o, ptr: String(GOT[o]), loc: loc(GOT[o], segBase), bytes: hex(GOT[o], 16) };
    }), hit: HIT });
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
s('[boot] v34 就绪');
