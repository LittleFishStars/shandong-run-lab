/**
 * v2：修 Frida17 API + env.findClass。
 * A) 顶层 hook RegisterNatives（libart 全局导出 / 枚举匹配 / vtable 215 三路兜底）
 * B) 触发后 env.findClass + GetStaticMethodID(vtable 113) 拿 ArtMethod*，
 *    dump 结构并定位 entry_point_from_jni_ 的真实归属。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const SIG = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840b9';
const SIG_VADDR = 0x5b5f0;
const ANCHORS = [
  ['/proc/self/maps', 0x5f780],
  ['LD_PRELOAD',      0x5f7d8],
  ['dl_iterate_phdr', 0x5f860],
];
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
function verifyBase(b) { return hex(b.add(SIG_VADDR), SIG.length/2) === SIG; }
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
function locate(addr, bases) {
  let desc = '?';
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) desc = r.protection + ' ' + (r.file ? r.file.path : '[anon]') + ' @' + r.base + '+0x' + addr.sub(r.base).toString(16) + ' sz=0x' + r.size.toString(16);
  } catch (e) { desc = 'locate-err'; }
  let rel = '';
  (bases || []).forEach(function (b) {
    const d = addr.sub(b);
    if (d.compare(0) > 0 && d.compare(0x72000) < 0) rel = '  ⊕ liby@' + b + '+0x' + d.toString(16);
  });
  return desc + rel;
}

let fired = false;
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

// ── A) RegisterNatives 三路兜底 ──
function hookRegisterNatives() {
  let target = null;
  const MANGLED = '_ZN3art3JNI15RegisterNativesEP7_JNIEnvP7_jclassPK15JNINativeMethodi';
  try { target = Module.getGlobalExportByName(MANGLED); } catch (e) {}
  if (!target) { try { target = Module.getGlobalExportByName('RegisterNatives'); } catch (e) {} }
  if (!target) {
    try {
      const m = Process.getModuleByName('libart.so');
      const exps = m.enumerateExports();
      for (let i = 0; i < exps.length; i++) {
        if (exps[i].name.indexOf('RegisterNatives') >= 0) { target = exps[i].address; s('  [A] 枚举命中: ' + exps[i].name); break; }
      }
    } catch (e) {}
  }
  if (!target) { s('  [A] ✗ 找不到 RegisterNatives 导出'); return; }
  try {
    Interceptor.attach(target, {
      onEnter: function (a) {
        try {
          const methods = a[2], count = a[3].toInt32();
          for (let i = 0; i < count; i++) {
            const rec = methods.add(i * 24);
            const nm = rec.readCString() || '';
            if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams') {
              const sig = rec.add(8).readCString();
              const fn = rec.add(16).readPointer();
              const bases = findAllBases();
              s('★★ RegisterNatives: ' + nm + sig);
              s('   fn=' + fn + '  ' + locate(fn, bases));
              s('   bytes: ' + hex(fn, 32));
            }
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[boot] [A] RegisterNatives hook OK @' + target);
  } catch (e) { s('  [A] attach 失败: ' + e); }
}
hookRegisterNatives();

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
      s('★★ base 数: ' + bases.length);
      bases.forEach(function (b, i) { s('  base[' + i + '] = ' + b); });

      // ── B) ArtMethod ──
      s('════ [B] ArtMethod 解析 ════');
      try {
        const env = Java.vm.getEnv();
        const envPtr = env.handle;
        const fnTable = envPtr.readPointer();
        const FindClass = new NativeFunction(fnTable.add(6 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
        const GetStaticMethodID = new NativeFunction(fnTable.add(113 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
        const NewStringUTF = new NativeFunction(fnTable.add(167 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
        const jclass = FindClass(envPtr, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
        s('  jclass=' + jclass);
        if (!jclass.isNull()) {
          const nmS = NewStringUTF(envPtr, Memory.allocUtf8String('signRequest'));
          const sigS = NewStringUTF(envPtr, Memory.allocUtf8String('(Ljava/lang/String;I)Ljava/lang/String;'));
          const mid = GetStaticMethodID(envPtr, jclass, nmS, sigS);
          s('  signRequest ArtMethod* = ' + mid + '  ' + locate(mid, bases));
          s('  结构[0..0x40]: ' + hex(mid, 0x40));
          // Android 9: data_ = ptr_sized_fields_.data_（0x18 或 0x20 视 imt_index_ 有无）
          [0x18, 0x20, 0x28].forEach(function (off) {
            try {
              const p = mid.add(off).readPointer();
              if (p.compare(ptr(0x10000)) > 0) s('  +0x' + off.toString(16) + ' → ' + p + '  ' + locate(p, bases));
            } catch (e) {}
          });
          send({ t: 'mid', mid: String(mid) });
        }
      } catch (e) { s('  [B] err: ' + e); }
    });
  }
});
s('[boot] v2 就绪');
