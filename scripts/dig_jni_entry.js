/**
 * ★从 ART 层直接挖 signRequest 的真实 native 入口指针。
 * 两路并进：
 *  A) hook RegisterNatives（libart 导出），过滤含 signRequest 的注册批
 *  B) Java 层预热后，从 HcjNative.signRequest 的 ArtMethod 结构读
 *     entry_point_from_jni_（ArtMethod 布局按 Android 10/11）。
 * 拿到指针后：反查所属内存区间 + 回推相对 liby base 的偏移（若在）。
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
  // 返回地址所属区间描述 + 若落在某 base 内则给偏移
  let desc = '未知';
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) desc = (r.protection) + ' ' + (r.file ? r.file.path : '[anon]') + ' base=' + r.base + ' size=0x' + r.size.toString(16);
  } catch (e) {}
  let rel = '';
  bases.forEach(function (b) {
    const d = addr.sub(b);
    const n = d.toUInt32 ? d.toUInt32() : null;
    if (d.compare(0) > 0 && d.compare(0x72000) < 0) rel = '  ⊕ liby@' + b + ' +0x' + d.toString(16);
  });
  return desc + rel;
}

let fired = false;
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

// A) RegisterNatives hook（装在启动钩子前，全局生效）
try {
  Interceptor.attach(Module.findExportByName('libart.so', 'JNI RegisterNatives') ||
                     Module.findExportByName('libart.so', '_ZN3art3JNI15RegisterNativesEP7_JNIEnvP7_jclassPK15JNINativeMethodi'), {
    onEnter: function (a) {
      try {
        const env = a[0], clazz = a[1], methods = a[2], count = a[3].toInt32();
        for (let i = 0; i < count; i++) {
          const rec = methods.add(i * 24);
          const nm = rec.readCString() || '';
          if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams') {
            const sig = rec.add(8).readCString();
            const fn = rec.add(16).readPointer();
            const bases = findAllBases();
            s('★★ RegisterNatives: ' + nm + sig);
            s('   fn=' + fn + '  ' + locate(fn, bases));
            // dump 入口前 32 字节
            s('   bytes: ' + hex(fn, 32));
          }
        }
      } catch (e) { s('  RN err: ' + e); }
    }
  });
  s('[boot] RegisterNatives hook OK');
} catch (e) { s('[boot] RegisterNatives hook 失败: ' + e); }

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      const N = Java.use('com.huachenjie.c.HcjNative');
      try { N.signRequest('{"warm":1}', 0); } catch (e) {}

      const bases = findAllBases();
      s('★★ base 数: ' + bases.length);
      bases.forEach(function (b, i) { s('  base[' + i + '] = ' + b); });

      // B) ArtMethod 解析
      s('════ ArtMethod entry_point 挖掘 ════');
      try {
        const cls = Java.use('java.lang.Class');
        const H = Java.use('com.huachenjie.c.HcjNative').getClass(); // java.lang.Class 对象
        // Frida 惯用法：通过 artMethod 字段
        const methods = H.getDeclaredMethods();
        s('  HcjNative 方法数: ' + methods.length);
        for (let i = 0; i < methods.length; i++) {
          const m0 = methods[i];
          const nm = String(m0.getName());
          if (nm !== 'signRequest' && nm !== 'encodeRun' && nm !== 'buildFlutterSecParams') continue;
          try {
            const artMethod = m0.getArtMethod ? m0.getArtMethod() : null;
            if (artMethod) {
              s('  ' + nm + ' artMethod=' + artMethod);
            }
          } catch (e) {}
          // 反射拿 entry：Frida 的 Java.MethodHandle 不直接暴露；改用隐藏 API
          try {
            const EP = Java.use('java.lang.reflect.Executable');
          } catch (e) {}
        }
      } catch (e) { s('  B err: ' + e); }

      // 简单可靠路：读 ArtMethod 结构。Android 10/11 ArtMethod 布局：
      // 0x00 declaring_class_(GcRoot,4B) 0x04 access_flags_(4B)
      // 0x08 dex_code_item_offset_(4B) 0x0c dex_method_index_(4B)
      // 0x10 method_index_(2B) 0x12 hotness_count_(2B)
      // 0x14 imt_index_(2B)+padding  —— Android 10 后无
      // ptr_sized_fields: data_ / entry_point_from_quick_compiled_code_
      //jni 入口在 data_ 里（static native 时 data_=jni entry 或 JNI stub）
      // 用 frida-java-bridge 内部 API 最稳：Java.api ? 不可用。
      // 改用：hook Method.invoke 前 SetNative —— 太复杂。
      // 实战：从 GetMethodID 返回的 jmethodID 就是 ArtMethod*（ART 无包装）。
      try {
        const env = Java.vm.getEnv();
        const H = Java.use('com.huachenjie.c.HcjNative');
        // 用 JNIEnv->GetMethodID：需 jclass。通过 H.getClass() 的反射对象拿
        const jcls = H.getClass(); // java.lang.Class
        // GetMethodID 在 env 对象表 vtable 偏移：GetStaticMethodID = 0x.../8
        // frida 提供 env.getMethodId? 无。手动：
        const envPtr = env.handle;
        const fnTable = envPtr.readPointer();
        // JNIEnv vtable: GetStaticMethodID 是第 113 项（Android 头文件 jni.h 排序）
        const GetStaticMethodID = new NativeFunction(fnTable.add(113 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
        const NewStringUTF = new NativeFunction(fnTable.add(167 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
        const nmS = NewStringUTF(envPtr, Memory.allocUtf8String('signRequest'));
        const sigS = NewStringUTF(envPtr, Memory.allocUtf8String('(Ljava/lang/String;I)Ljava/lang/String;'));
        const jclass = env.findClass('com/huachenjie/c/HcjNative');
        const mid = GetStaticMethodID(envPtr, jclass, nmS, sigS);
        s('  signRequest jmethodID(ArtMethod*) = ' + mid);
        // dump ArtMethod 结构
        s('  ArtMethod[0..0x40]: ' + hex(mid, 0x40));
        // Android 10/11: offset 0x18 = data_? 0x20 = entry?
        const candPtrs = [];
        for (let off = 0x18; off <= 0x38; off += 8) {
          try {
            const p = mid.add(off).readPointer();
            if (p.compare(ptr(0x1000)) > 0) candPtrs.push([off, p]);
          } catch (e) {}
        }
        candPtrs.forEach(function (cp) {
          s('  +0x' + cp[0].toString(16) + ' → ' + cp[1] + '  ' + locate(cp[1], bases));
        });
        send({ t: 'mid', mid: String(mid) });
      } catch (e) { s('  jmethodID err: ' + e); }

      // 对照：调一次确认
      try { s('  warm out: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24)); } catch (e) {}
    });
  }
});
s('[boot] JNI 入口挖掘就绪');
