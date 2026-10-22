/**
 * v27 ★★★★ 决定性实验：从 ArtMethod 直接读出 Java 调用 native 时的真实跳转地址。
 *
 * 背景（累积）：
 *   · v23 修正 env 传参后，FindClass 成功（返回 0xe5）→ GetStaticMethodID 现在可用
 *   · v24 证明 init(+0x24a644) **能被 Java 层触发** ⇒ 地址计算正确
 *   · v25 守卫=1、输出正确，但表全零
 *   · v26 全内存签名搜索命中 8 处（含 6 处疑似内联副本），22 个入口全 hook 仍 0 命中
 *
 * 本脚本（一次问清 ART）：
 *   ① FindClass + GetStaticMethodID → 拿 signRequest 的 ArtMethod*
 *   ② dump ArtMethod 完整结构（0x40 字节）
 *   ③ 解析关键字段（Android 9 / API 28 布局）：
 *        0x00 declaring_class_ (GcRoot<Class>, 4B)
 *        0x04 access_flags_    (4B)
 *        0x08 dex_code_item_offset_ (4B)
 *        0x0c dex_method_index_     (4B)
 *        0x10 method_index_ (2B) / hotness_count_ (2B)  (+ 4B padding on 64-bit)
 *        0x18 ptr_sized_fields_.data_                          ← native 数据 / 入口
 *        0x20 ptr_sized_fields_.entry_point_from_quick_compiled_code_
 *      ★ 对照 base+0x24926c：若 data_ 不指向它 ⇒ Java 根本不调用该函数
 *   ④ 用 FromReflectedMethod 交叉验证
 *   ⑤ 把 data_ 指向的地址也 dump 出来 + 反查所属段
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
    s('[cal] envPtr=' + envPtr + ' table=' + table +
      ' GetVersion=0x' + (gv(envPtr) >>> 0).toString(16));
  } catch (e) { s('[cal] err: ' + e); }
});
function jni(i, r, a) { return new NativeFunction(table.add(i * 8).readPointer(), r, a); }
function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}
function u32(p, o) { try { return p.add(o).readU32(); } catch (e) { return null; } }
function u64(p, o) { try { return p.add(o).readU64().toString(); } catch (e) { return null; } }
function ptrAt(p, o) { try { return p.add(o).readPointer(); } catch (e) { return null; } }

function seg(addr) {
  if (!addr || addr.isNull()) return 'null';
  try {
    const r = Process.findRangeByAddress(addr);
    if (!r) return '不在任何段';
    return r.protection + ' @' + r.base + '+0x' + addr.sub(r.base).toString(16) +
      ' sz=0x' + r.size.toString(16) + '  ' + (r.file ? r.file.path.split('/').pop() : '[anon]');
  } catch (e) { return '?'; }
}

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFF_SIGN = 0x24926c, OFF_INIT = 0x24a644;
const g = {};

// ══ RegisterNatives：拿注册指针（作为对照基准）══
Java.perform(function () {
  if (!table) { s('✗ 无 table'); return; }
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
            if (fn && !fn.isNull() && !g.rnA) { g.rnA = fn; s('[RN] 注册指针 = ' + fn); try { analyze(fn, null); } catch (e) { s('[RN→analyze] ' + e); } }
            else if (fn && !fn.isNull() && !g.rnB && !fn.equals(g.rnA)) { g.rnB = fn; s('[RN] 注册指针B = ' + fn); }
          }
        } catch (e) {}
      }
    });
    s('[A] RN hook OK');
  } catch (e) { s('[A] err: ' + e); }
});


// ══ 主分析（由 RegisterNatives 捕获后触发）══
let analyzed = false;
function analyze(rnA, rnB) {
  if (analyzed) return; analyzed = true;
  const base = rnA.sub(OFF_SIGN);
  Java.perform(function () {

      const H = Java.use('com.huachenjie.c.HcjNative');
      try { s('[DC] warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20)); } catch (e) {}

      
      
      s('');
      s('════ ① 基准 ════');
      s('  注册指针 A = ' + g.rnA + (g.rnB ? ('  B = ' + g.rnB) : ''));
      s('  base = ' + base);
      s('  校验 base+0x24926c = ' + hex(base.add(OFF_SIGN), 16));
      s('  段信息: ' + seg(g.rnA));

      // ══ ② 拿 ArtMethod* ══
      s('');
      s('════ ② ArtMethod 解析 ════');
      let FindClass, GetStaticMethodID, ExceptionCheck, ExceptionClear, FromReflectedMethod;
      try {
        FindClass             = jni(6,   'pointer', ['pointer', 'pointer']);
        GetStaticMethodID     = jni(113, 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
        ExceptionCheck        = jni(228, 'int',     ['pointer']);
        ExceptionClear        = jni(17,  'void',    ['pointer']);
        FromReflectedMethod   = jni(7,   'pointer', ['pointer', 'pointer']);
      } catch (e) { s('  JNI 工具 err: ' + e); return; }

      let jclass = ptr(0), mid = ptr(0);
      try {
        jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
        s('  FindClass → ' + jclass + (jclass.isNull() ? ' ✗' : ' ✓'));
        if (ExceptionCheck(envPtr)) { s('  异常'); ExceptionClear(envPtr); }
        if (!jclass.isNull()) {
          mid = GetStaticMethodID(envPtr, jclass,
                  Memory.allocUtf8String('signRequest'),
                  Memory.allocUtf8String(SIG_SR));
          s('  GetStaticMethodID → ' + mid + (mid.isNull() ? ' ✗' : ' ✓'));
          if (ExceptionCheck(envPtr)) { s('  异常'); ExceptionClear(envPtr); }
        }
      } catch (e) { s('  err: ' + e); }

      if (!mid || mid.isNull()) {
        // 回退：FromReflectedMethod
        try {
          const ms = H.class.getDeclaredMethods();
          for (let i = 0; i < ms.length; i++) {
            if (String(ms[i].getName()) === 'signRequest') {
              s('  反射 Method = ' + ms[i]);
              const h = ms[i].$handle || ms[i].handle;
              s('  包装器 handle = ' + h);
              if (h) { mid = FromReflectedMethod(envPtr, h); s('  FromReflectedMethod → ' + mid); }
              break;
            }
          }
        } catch (e) { s('  回退 err: ' + e); }
      }
      if (!mid || mid.isNull()) { s('  ✗ ArtMethod 拿不到'); return; }

      // ══ ③ dump ArtMethod ══
      s('');
      s('════ ③ ArtMethod 结构 ════');
      s('  ArtMethod* = ' + mid + '   ' + seg(mid));
      const dump = hex(mid, 0x40);
      s('  [0x00..0x40] = ' + (dump || '不可读'));
      s('  ── 逐字段（API 28 / 64 位布局）──');
      s('    +0x00 declaring_class_ (GcRoot, 4B)  = 0x' + (u32(mid, 0) || 0).toString(16));
      s('    +0x04 access_flags_                 = 0x' + (u32(mid, 4) || 0).toString(16) +
        '  ' + (function (f) {
          const bits = [];
          if (f & 0x1) bits.push('public');
          if (f & 0x8) bits.push('static');
          if (f & 0x100) bits.push('native');
          if (f & 0x1000) bits.push('synchronized');
          return bits.join('|');
        })(u32(mid, 4) || 0));
      s('    +0x08 dex_code_item_offset_         = 0x' + (u32(mid, 8) || 0).toString(16));
      s('    +0x0c dex_method_index_             = 0x' + (u32(mid, 12) || 0).toString(16));
      s('    +0x10 method_index_ (2B)            = 0x' + (function () {
        try { return mid.add(16).readU16().toString(16); } catch (e) { return '?'; }
      })());
      s('    +0x12 hotness_count_ (2B)           = 0x' + (function () {
        try { return mid.add(18).readU16().toString(16); } catch (e) { return '?'; }
      })());
      s('    ──────── ptr_sized_fields_ ────────');
      s('    +0x18 data_                         = ' + u64(mid, 0x18));
      s('    +0x20 entry_point_from_quick_compiled_code_ = ' + u64(mid, 0x20));
      s('    +0x28                              = ' + u64(mid, 0x28));
      s('    +0x30                              = ' + u64(mid, 0x30));
      s('    +0x38                              = ' + u64(mid, 0x38));

      // ══ ④ ★ 决定性对照 ══
      s('');
      s('════ ④ ★★★ 决定性对照 ════');
      const cands = [];
      [[0x18, 'data_'], [0x20, 'entry_point_from_quick_compiled_code_'],
       [0x28, '+0x28'], [0x30, '+0x30']].forEach(function (x) {
        const p = ptrAt(mid, x[0]);
        if (p && !p.isNull() && p.compare(ptr(0x1000)) > 0) {
          cands.push({ off: x[0], name: x[1], p: p });
        }
      });
      cands.forEach(function (c) {
        const isRN = g.rnA && c.p.equals(g.rnA);
        s('  ' + c.name.padEnd(42) + ' = ' + c.p);
        s('      归属: ' + seg(c.p) + (isRN ? '   ★★ 与注册指针相同！' : ''));
        s('      前 16B: ' + (hex(c.p, 16) || '不可读'));
      });

      s('');
      if (cands.some(function (c) { return c.p.equals(g.rnA); })) {
        s('  ⇒ ★ 注册指针确实被 ART 使用（Java 调它会走到 base+0x24926c）');
        s('     ⇒ 但我们的 hook 不触发，说明执行前代码被改写 / 跳过了函数入口');
      } else {
        s('  ⇒ ★★★ 注册指针【未】被 ART 引用！');
        s('     ⇒ Java 层调用走的是另一个地址 —— Java2C 替换了 ArtMethod 入口');
      }

      // ══ ⑤ hook 所有候选指针（验证哪个真被执行）══
      s('');
      s('════ ⑤ hook ArtMethod 里的所有候选指针 ════');
      s('  （先 hook，再调用）');
      const hookCnt = {};
      cands.forEach(function (c, ci) {
        try {
          Interceptor.attach(c.p, {
            onEnter: function () {
              const k = c.name + '@' + c.p;
              hookCnt[k] = (hookCnt[k] || 0) + 1;
              s('  ►►► 触发 ' + k);
            }
          });
          s('  ✓ hook ' + c.name + ' @' + c.p);
        } catch (e) { s('  ✗ hook ' + c.name + ': ' + e); }
      });

      s('');
      s('  调 signRequest ×3 ...');
      try {
        ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
          s('    ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 44));
        });
      } catch (e) { s('    err: ' + e); }

      s('  ── 命中: ' +
        (Object.keys(hookCnt).length ? JSON.stringify(hookCnt) : '（全 0）'));

      send({ t: 'R', base: String(base), rnA: String(g.rnA),
             mid: String(mid), dump: dump,
             cands: cands.map(function (c) {
               return { name: c.name, p: String(c.p), seg: seg(c.p), bytes: hex(c.p, 16) };
             }), hits: hookCnt });
    });

  });
}

// ══ 兜底：DefineClass 触发一次（若 RN 还没到，仅作占位）══
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

s('[boot] v27 就绪');
