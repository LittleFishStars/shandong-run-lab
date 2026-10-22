/**
 * v4 终极版：
 *  A) 顶层 Java.perform（早于壳初始化）：从 JNIEnv 函数表 vtable[215] 拿
 *     RegisterNatives 直接 attach —— 不依赖 libart 导出符号名。
 *  B) 触发后：H.signRequest.overload(...).handle 试取 jmethodID(ArtMethod*)，
 *     失败再走 env.getStaticMethodId（frida-java-bridge 自带）。
 *  C) 拿到入口 → hook 验证 → dump 所在映射（分片落盘 work/real_impl/）。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const SIG = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840f9ab0040f9';
const SIG_VADDR = 0x5b5f0;
const ANCHORS = [
  ['/proc/self/maps', 0x5f780],
  ['LD_PRELOAD',      0x5f7d8],
  ['dl_iterate_phdr', 0x5f860],
];
const SIG2 = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840b9';
function pattern(str) {
  let o = [];
  for (let i = 0; i < str.length; i++) o.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  return o.join(' ');
}
function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}
function verifyBase(b) { return hex(b.add(SIG_VADDR), SIG2.length/2) === SIG2; }
function findAllBases() {
  const seen = {}, out = [];
  ANCHORS.forEach(function (anc) {
    const nm = anc[0], va = anc[1], pat = pattern(nm);
    let rs = [];
    try { rs = Process.enumerateRanges('r--'); } catch (e) { return; }
    rs.forEach(function (r) {
      if (r.size < nm.length || r.size > 16*1024*1024) return;
      let hits = null;
      try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { return; }
      if (!hits) return;
      hits.forEach(function (h) {
        const b = h.address.sub(va);
        const k = b.toString();
        if (seen[k]) return;
        if (verifyBase(b)) { seen[k] = 1; out.push(b); }
      });
    });
  });
  return out;
}
function locate(addr) {
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) return r.protection + ' ' + (r.file ? r.file.path : '[anon]') + ' @' + r.base + '+0x' + addr.sub(r.base).toString(16) + ' sz=0x' + r.size.toString(16);
  } catch (e) {}
  return '?';
}

// ── A) vtable[215] = RegisterNatives，加载期即挂 ──
let rnHooked = false;
Java.perform(function () {
  try {
    const env = Java.vm.getEnv();
    const table = env.handle;
    s('[A] fnTable=' + table + '  GetVersion=' + (function () {
      try { const f = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']); return '0x' + (f(table) >>> 0).toString(16); } catch (e) { return 'err:' + e; }
    })());
    const rn = table.add(215 * 8).readPointer();
    s('[A] RegisterNatives vtable ptr = ' + rn);
    Interceptor.attach(rn, {
      onEnter: function (a) {
        try {
          const methods = a[2], count = a[3].toInt32();
          for (let i = 0; i < count; i++) {
            const rec = methods.add(i * 24);
            const nm = rec.readCString() || '';
            if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams') {
              const sig = rec.add(8).readCString();
              const fn = rec.add(16).readPointer();
              s('★★ RegisterNatives: ' + nm + sig + '  fn=' + fn);
              s('   归属: ' + locate(fn));
              s('   bytes: ' + hex(fn, 32));
              send({ t: 'rn', name: nm, fn: String(fn) });
            }
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    rnHooked = true;
    s('[A] RegisterNatives hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

let fired = false;
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      const H = Java.use('com.huachenjie.c.HcjNative');
      try { s('  warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24)); } catch (e) { s('  warm err: ' + e); }

      const bases = findAllBases();
      s('★★ base 数: ' + bases.length + ' → ' + bases.map(String).join(', '));

      // ── B) 拿 ArtMethod* ──
      let mid = null;
      try {
        const m = H.signRequest.overload('java.lang.String', 'int');
        const keys = Object.keys(m);
        s('[B] 包装器 keys: ' + keys.join(','));
        if (m.handle) { mid = m.handle; s('[B] .handle = ' + mid); }
        else if (m.$handle) { mid = m.$handle; s('[B] .$handle = ' + mid); }
      } catch (e) { s('[B] 包装器 err: ' + e); }
      if (!mid) {
        try {
          const env = Java.vm.getEnv();
          const jc = env.findClass('com/huachenjie/c/HcjNative');
          s('[B] env.findClass → ' + jc);
          if (jc && !jc.isNull()) {
            mid = env.getStaticMethodId(jc, 'signRequest', '(Ljava/lang/String;I)Ljava/lang/String;');
            s('[B] env.getStaticMethodId → ' + mid);
          }
        } catch (e) { s('[B] env 路 err: ' + e); }
      }
      if (!mid) { s('✗ ArtMethod 拿不到'); return; }
      s('[B] ArtMethod* = ' + mid + '  归属: ' + locate(mid));
      s('[B] 结构: ' + hex(mid, 0x30));

      // ── C) data_ 候选 ──
      let fn = null;
      [0x18, 0x20, 0x28].forEach(function (off) {
        try {
          const p = mid.add(off).readPointer();
          if (p.compare(ptr(0x10000)) < 0) return;
          const lc = locate(p);
          s('  +0x' + off.toString(16) + ' = ' + p + '  ' + lc + '  bytes: ' + hex(p, 16));
          if (!fn && lc.indexOf('r-x') >= 0 && lc.indexOf('libart') < 0) fn = p;
        } catch (e) {}
      });
      if (!fn) { s('✗ 无可执行 data_ 候选'); return; }
      s('★★★ 真实入口 = ' + fn + '  ' + locate(fn));

      // hook 验证 + 参数捕获
      let hitCount = 0, argJson = '';
      const env = Java.vm.getEnv(), fnTable = env.handle;
      const GetStringUTFChars = new NativeFunction(fnTable.add(169 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer']);
      const ReleaseStringUTFChars = new NativeFunction(fnTable.add(170 * 8).readPointer(), 'void', ['pointer', 'pointer', 'pointer']);
      try {
        Interceptor.attach(fn, {
          onEnter: function (args) {
            hitCount++;
            try {
              const c = GetStringUTFChars(fnTable, args[2], ptr(0));
              argJson = c.readUtf8String();
              ReleaseStringUTFChars(fnTable, args[2], c);
            } catch (e) { argJson = 'read-err:' + e; }
          }
        });
        s('  hook 已装，调 signRequest {"probe2":1} ...');
        const out = String(H.signRequest('{"probe2":1}', 0));
        s('  out: ' + out.substring(0, 44));
        s('  触发: ' + hitCount + ' 次  参数: ' + argJson);
        send({ t: 'fn', fn: String(fn), hits: hitCount, arg: argJson });
      } catch (e) { s('  验证 err: ' + e); }

      // dump 入口所在映射
      try {
        const r = Process.findRangeByAddress(fn);
        if (r) {
          const total = Math.min(r.size, 1024 * 1024);
          s('════ dump ' + r.base + ' sz=' + total + ' prot=' + r.protection + ' ════');
          send({ t: 'dumpmeta', base: String(r.base), size: total, prot: r.protection });
          const CHUNK = 240 * 1024;
          for (let off = 0; off < total; off += CHUNK) {
            const sz = Math.min(CHUNK, total - off);
            send({ t: 'chunk', off: off, size: sz }, r.base.add(off).readByteArray(sz));
            s('  chunk +0x' + off.toString(16) + ' (' + sz + 'B) 已发');
          }
        }
      } catch (e) { s('  dump err: ' + e); }
    });
  }
});
s('[boot] v4 就绪');
