/**
 * 精确取出 signRequest 的 native 实现地址，并判断它属于哪个内存段。
 *
 * 方法：通过 JNI 拿 jmethodID（即 art::ArtMethod*），读 ArtMethod 布局中的
 *      entry_point_from_jni_ 字段。Android 9 (SDK 28) arm64 的 ArtMethod 布局：
 *
 *       0x00  GcRoot<Class> declaring_class_   (4B)
 *       0x04  uint32 access_flags_
 *       0x08  uint32 dex_code_item_offset_
 *       0x0c  uint32 dex_method_index_
 *       0x10  uint16 method_index_
 *       0x12  uint16 hotness_count_
 *       0x18  void*  data_                     ← native 方法时为 entry_point_from_jni_
 *       0x20  void*  entry_point_from_quick_compiled_code_
 *
 * 拿到地址后枚举所有映射段，报出它落在哪一段。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function findExport(n){
  try { if (typeof Module.findGlobalExportByName==='function'){const a=Module.findGlobalExportByName(n); if(a)return a;} } catch(e){}
  try { if (typeof Module.getGlobalExportByName==='function'){const a=Module.getGlobalExportByName(n); if(a)return a;} } catch(e){}
  return null;
}

const FIRST = 0x27000, DC = 0x11c7d8;
const art = Process.findModuleByName('libart.so');

// 记录所有「变为可执行」的段，便于反查
const execSegs = [];

const mp = findExport('mprotect');
if (mp) {
  Interceptor.attach(mp, {
    onEnter: function (a) { this.addr=a[0]; this.len=a[1].toInt32(); this.prot=a[2].toInt32(); },
    onLeave: function () {
      if (this.prot === 5 || this.prot === 7) {
        execSegs.push({ base: this.addr, size: this.len, prot: this.prot });
      }
    }
  });
}

function resolveAddr(addr) {
  // 在已记录的 execSegs 里找
  for (let i = 0; i < execSegs.length; i++) {
    const seg = execSegs[i];
    const end = seg.base.add(seg.size);
    if (addr.compare(seg.base) >= 0 && addr.compare(end) < 0) {
      return { seg: seg, off: addr.sub(seg.base) };
    }
  }
  // 退而求其次：枚举所有 range
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) return { range: r, off: addr.sub(r.base) };
  } catch (e) {}
  return null;
}

let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      s('════ 定位 signRequest 的 native 实现 ════');
      let mid = null;
      // 壳用自定义 ClassLoader，boot loader 找不到 → 从 Java 层反射拿 Method 再取指针
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        const ms = N.class.getDeclaredMethods();
        let meth = null;
        for (let i = 0; i < ms.length; i++) {
          if (ms[i].getName() === 'signRequest') { meth = ms[i]; break; }
        }
        if (!meth) { s('  未找到 signRequest 方法'); return; }
        s('  反射得到 Method: ' + meth);
        // Frida 的 Java 包装器不直接暴露 ArtMethod，改用 env 的 FromReflectedMethod
        const env = Java.vm.getEnv();
        mid = env.fromReflectedMethod(meth.$handle || meth);
        if (!mid || mid.isNull()) { s('  fromReflectedMethod 失败'); return; }
        s('  ArtMethod* (jmethodID) = ' + mid);
      } catch (e) { s('  取 methodId 失败: ' + e); return; }

      // 读 ArtMethod 各字段
      const base = mid;
      const dump = {};
      const FIELDS = {
        'declaring_class(4B)': 0x00,
        'access_flags': 0x04,
        'dex_code_item_offset': 0x08,
        'dex_method_index': 0x0c,
        'method_index(2B)': 0x10,
        'hotness(2B)': 0x12,
        'data_/jni_entry(8B)': 0x18,
        'quick_compiled(8B)': 0x20,
      };
      Object.keys(FIELDS).forEach(function (k) {
        try {
          const off = FIELDS[k];
          const v = base.add(off);
          const ptr = v.readPointer();
          const u32 = v.readU32();
          dump[k] = 'ptr=' + ptr + ' u32=0x' + u32.toString(16);
        } catch (e) { dump[k] = '(读失败)'; }
      });
      Object.keys(dump).forEach(function (k) { s('  ' + k.padEnd(22) + dump[k]); });

      // 取 JNI 入口
      let jniEntry = null;
      try { jniEntry = base.add(0x18).readPointer(); } catch (e) {}
      if (jniEntry && !jniEntry.isNull()) {
        s('');
        s('  ★ JNI 实现地址 = ' + jniEntry);
        const loc = resolveAddr(jniEntry);
        if (loc && loc.seg) {
          s('    属于钓到的段: base=' + loc.seg.base + ' size=' + (loc.seg.size/1024).toFixed(0) + 'KB');
          s('    段内偏移 = 0x' + loc.off.toString(16));
        } else if (loc && loc.range) {
          s('    属于内存范围: ' + loc.range.base + ' - ' + loc.range.base.add(loc.range.size) +
            '  ' + loc.range.protection);
          s('    段内偏移 = 0x' + loc.off.toString(16));
        } else {
          s('    未能解析所属段');
        }
        // 顺便看 quick compiled 入口
        try {
          const q = base.add(0x20).readPointer();
          s('    quick_compiled 入口 = ' + q);
          const lo2 = resolveAddr(q);
          if (lo2) s('      → 属于 ' + (lo2.seg ? ('钓到的段 ' + lo2.seg.base) : (lo2.range ? lo2.range.base : '?')));
        } catch (e) {}
      }

      // 触发一次并确认
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        const r = String(N.signRequest('{"probe":1}', 0));
        s('');
        s('  实测调用: ' + r.substring(0, 40) + '...');
      } catch (e) { s('  调用失败: ' + e); }

      // 输出所有钓到的段供宿主比对
      send({ t: 'segs', segs: execSegs.map(function (x) {
        return { base: x.base.toString(), size: x.size, prot: x.prot };
      })});
    });
  }
});
s('[boot] native 实现定位就绪');
