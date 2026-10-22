/**
 * v28 ★★★★ 问清 ART：Java 调用 signRequest 时到底跳到哪个地址。
 *
 * 累积事实：
 *   · v23 修正 JNIEnv 传参（envPtr 而非 table）后，FindClass 成功 → GetStaticMethodID 可用
 *   · v24 证明 init(+0x24a644) 能被 Java 层触发 ⇒ 地址计算正确
 *   · v25 守卫=1、输出正确，但 base+0x47c9b8 的表全零
 *   · v26 全内存 32B 签名搜索命中 8 处（6 个疑似内联副本），22 个入口全 hook 仍 0 命中
 *
 * 本脚本：解析 ArtMethod（API 28 / 64 位），看 entry/data 字段到底指向哪，
 *         并 hook 这些字段指向的地址，验证哪个真正被执行。
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
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}
function seg(addr) {
  if (!addr || addr.isNull()) return 'null';
  try {
    const r = Process.findRangeByAddress(addr);
    if (!r) return '不在任何段';
    return r.protection + ' @' + r.base + '+0x' + addr.sub(r.base).toString(16) +
      ' sz=0x' + r.size.toString(16) + '  ' + (r.file ? r.file.path.split('/').pop() : '[anon]');
  } catch (e) { return '?'; }
}
function u32(p, o) { try { return p.add(o).readU32(); } catch (e) { return 0; } }
function u64s(p, o) { try { return p.add(o).readU64().toString(); } catch (e) { return '?'; } }
function ptrAt(p, o) { try { return p.add(o).readPointer(); } catch (e) { return null; } }

const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFF_SIGN = 0x24926c;
let rnA = null, rnB = null, analyzed = false;

// ══════════ 主分析 ══════════
function analyze() {
  if (analyzed) return;
  if (!rnA) return;
  analyzed = true;

  Java.perform(function () {
    const base = rnA.sub(OFF_SIGN);
    s('');
    s('════ ① 基准 ════');
    s('  注册指针 A = ' + rnA + (rnB ? ('   B = ' + rnB) : ''));
    s('  base       = ' + base);
    s('  校验       = ' + hex(base.add(OFF_SIGN), 16));
    s('  段信息     = ' + seg(rnA));

    // ── ② 拿 ArtMethod* ──
    s('');
    s('════ ② ArtMethod 解析 ════');
    let FindClass, GetStaticMethodID, ExceptionCheck, ExceptionClear, FromReflectedMethod;
    try {
      FindClass           = jni(6,   'pointer', ['pointer', 'pointer']);
      GetStaticMethodID   = jni(113, 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
      ExceptionCheck      = jni(228, 'int',     ['pointer']);
      ExceptionClear      = jni(17,  'void',    ['pointer']);
      FromReflectedMethod = jni(7,   'pointer', ['pointer', 'pointer']);
    } catch (e) { s('  JNI 工具 err: ' + e); return; }

    let mid = ptr(0);
    try {
      const jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
      s('  FindClass          = ' + jclass + (jclass.isNull() ? ' ✗' : ' ✓'));
      if (ExceptionCheck(envPtr)) { s('  (有异常)'); ExceptionClear(envPtr); }
      if (!jclass.isNull()) {
        mid = GetStaticMethodID(envPtr, jclass,
                Memory.allocUtf8String('signRequest'),
                Memory.allocUtf8String(SIG_SR));
        s('  GetStaticMethodID  = ' + mid + (mid.isNull() ? ' ✗' : ' ✓'));
        if (ExceptionCheck(envPtr)) { s('  (有异常)'); ExceptionClear(envPtr); }
      }
    } catch (e) { s('  err: ' + e); }

    if (!mid || mid.isNull()) {
      s('  → 回退 FromReflectedMethod');
      try {
        const H0 = Java.use('com.huachenjie.c.HcjNative');
        const ms = H0.class.getDeclaredMethods();
        for (let i = 0; i < ms.length; i++) {
          if (String(ms[i].getName()) === 'signRequest') {
            const h = ms[i].$handle || ms[i].handle;
            s('    包装器 handle = ' + h);
            if (h) { mid = FromReflectedMethod(envPtr, h); s('    FromReflectedMethod = ' + mid); }
            break;
          }
        }
      } catch (e) { s('    回退 err: ' + e); }
    }
    if (!mid || mid.isNull()) { s('✗ ArtMethod 拿不到 —— 终止'); return; }

    // ── ③ dump ──
    s('');
    s('════ ③ ArtMethod 结构 ════');
    s('  ArtMethod* = ' + mid);
    s('  归属       = ' + seg(mid));
    s('  [0x00..0x40] = ' + (hex(mid, 0x40) || '不可读'));
    s('  ── 字段（API 28 / 64 位）──');
    s('    +0x00 declaring_class_ (4B) = 0x' + u32(mid, 0).toString(16));
    const af = u32(mid, 4);
    const bits = [];
    if (af & 0x1) bits.push('public');
    if (af & 0x2) bits.push('private');
    if (af & 0x8) bits.push('static');
    if (af & 0x100) bits.push('native');
    if (af & 0x1000) bits.push('synchronized');
    s('    +0x04 access_flags_         = 0x' + af.toString(16) + '  [' + bits.join('|') + ']');
    s('    +0x08 dex_code_item_offset_ = 0x' + u32(mid, 8).toString(16));
    s('    +0x0c dex_method_index_     = 0x' + u32(mid, 12).toString(16));
    s('    +0x10 method_index_/hotness = ' + (function () {
      try { return hex(mid.add(16), 4); } catch (e) { return '?'; }
    })());
    s('    ──────── ptr_sized_fields_ ────────');
    s('    +0x18 data_                           = ' + u64s(mid, 0x18));
    s('    +0x20 entry_point_from_quick_compiled_code_ = ' + u64s(mid, 0x20));
    s('    +0x28                                 = ' + u64s(mid, 0x28));
    s('    +0x30                                 = ' + u64s(mid, 0x30));
    s('    +0x38                                 = ' + u64s(mid, 0x38));

    // ── ④ 决定性对照 ──
    s('');
    s('════ ④ ★★★ 关键对照 ════');
    s('  注册指针 rnA = ' + rnA);
    const cands = [];
    [[0x18, 'data_'], [0x20, 'entry_quick'], [0x28, '+0x28'], [0x30, '+0x30']].forEach(function (x) {
      const p = ptrAt(mid, x[0]);
      if (p && !p.isNull() && p.compare(ptr(0x1000)) > 0) cands.push({ off: x[0], name: x[1], p: p });
    });
    cands.forEach(function (c) {
      const same = c.p.equals(rnA);
      s('  ' + c.name.padEnd(14) + ' = ' + c.p + (same ? '   ★★ 等于注册指针' : ''));
      s('     段: ' + seg(c.p));
      s('     前16B: ' + (hex(c.p, 16) || '不可读'));
    });

    s('');
    const hitRN = cands.some(function (c) { return c.p.equals(rnA); });
    if (hitRN) {
      s('  ⇒ 注册指针被 ART 引用 —— Java 调用会到 base+0x24926c');
      s('     但 hook 不触发 ⇒ 执行前代码被改写，或从中部进入');
    } else if (cands.length) {
      s('  ⇒ ★★★ 注册指针【未】出现在 ArtMethod 中！');
      s('     ⇒ ART 执行的是上面这些地址 —— Java2C 替换了入口');
    } else {
      s('  ⇒ 所有 ptr 字段都为空/异常 —— ArtMethod 布局可能不同，需换偏移试');
    }

    // ── ⑤ hook 候选并验证 ──
    s('');
    s('════ ⑤ hook 候选地址并调用 ════');
    const hookCnt = {};
    const hooked = [];
    cands.forEach(function (c) {
      try {
        Interceptor.attach(c.p, {
          onEnter: function () {
            const k = c.name + '@' + c.p;
            hookCnt[k] = (hookCnt[k] || 0) + 1;
            s('  ►►► 触发 ' + k);
          }
        });
        hooked.push(c.name);
        s('  ✓ hook ' + c.name);
      } catch (e) { s('  ✗ hook ' + c.name + ': ' + e); }
    });
    // 同时 hook 注册指针本身作对照
    try {
      Interceptor.attach(rnA, {
        onEnter: function () { hookCnt['rnA'] = (hookCnt['rnA'] || 0) + 1; s('  ►►► 触发 rnA'); }
      });
      hooked.push('rnA');
    } catch (e) {}

    s('');
    s('  调 signRequest ×3 ...');
    try {
      const H = Java.use('com.huachenjie.c.HcjNative');
      ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
        s('    ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 44));
      });
    } catch (e) { s('    err: ' + e); }

    s('');
    s('  hook 了: ' + hooked.join(', '));
    s('  命中: ' + (Object.keys(hookCnt).length ? JSON.stringify(hookCnt) : '（全 0）'));

    send({ t: 'R', base: String(base), rnA: String(rnA), mid: String(mid),
           dump: hex(mid, 0x40),
           cands: cands.map(function (c) {
             return { name: c.name, p: String(c.p), seg: seg(c.p), bytes: hex(c.p, 16) };
           }),
           hits: hookCnt });
  });
}

// ══════════ RegisterNatives ══════════
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
            if (!fn || fn.isNull()) continue;
            if (!rnA) { rnA = fn; s('[RN] 注册指针 A = ' + fn); }
            else if (!rnB && !fn.equals(rnA)) { rnB = fn; s('[RN] 注册指针 B = ' + fn); }
          }
        } catch (e) {}
        // ★ 同步在主回调内分析（v22 验证过的可靠模式）
        if (rnA && !analyzed) { try { analyze(); } catch (e) { s('[RN→analyze] ' + e); } }
      }
    });
    s('[A] RN hook OK');
  } catch (e) { s('[A] err: ' + e); }
});

// ══════════ 兜底触发 ══════════
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
s('[boot] v28 就绪');
