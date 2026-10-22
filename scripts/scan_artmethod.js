/**
 * 用「ArtMethod 特征扫描」定位 signRequest 的 JNI 入口。
 *
 * 前次失败：Frida 的 Java 包装器不暴露 ArtMethod 指针，fromReflectedMethod 拿不到
 * JNI handle；而 findClass 走 boot loader 找不到壳的类。
 *
 * 换思路（更稳）：
 *   ① 壳的类加载后，ArtMethod 对象在 ART 堆里
 *   ② 用 Java 反射拿到 Method 对象 → Frida 的 $handle 是 jobject（全局引用）
 *   ③ jobject 指向的是 art::mirror::Method（反射对象），其内部有个字段指向
 *      art::ArtMethod（Frida 有 Java.api 但这里用底层读）
 *   ④ 更简单可靠的办法：**扫描以 "signRequest" 字符串被引用的位置**——
 *      JNI 动态注册时会把 name/signature/fnPtr 存入一张表。
 *
 * 本脚本用最实用的路径：
 *   A. 反射拿 Method 对象 → 读 mirror::Method 的 art_method_ 字段（偏移 0x10/0x8）
 *   B. 从 ArtMethod 读多个候选偏移，找落在可执行段的那个指针
 *   C. 逐个验证：哪个偏移处的指针指向的代码「看起来是 JNI 函数」
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

// 所有可执行内存范围（懒加载）
let execRanges = null;
function getExecRanges() {
  if (execRanges) return execRanges;
  execRanges = [];
  try {
    Process.enumerateRanges('r-x').forEach(function (r) { execRanges.push(r); });
  } catch (e) {}
  return execRanges;
}
function inExec(p) {
  const rs = getExecRanges();
  for (let i = 0; i < rs.length; i++) {
    const r = rs[i];
    if (p.compare(r.base) >= 0 && p.compare(r.base.add(r.size)) < 0) return r;
  }
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
      s('════ ArtMethod 特征扫描定位 signRequest ════');
      let meth = null, handle = null;
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        const ms = N.class.getDeclaredMethods();
        for (let i = 0; i < ms.length; i++)
          if (ms[i].getName() === 'signRequest') { meth = ms[i]; break; }
        if (!meth) { s('未找到方法'); return; }
        handle = meth.$handle;
        s('  Method 对象 handle = ' + handle);
      } catch (e) { s('  反射失败: ' + e); return; }

      // ── 方案 A：把 handle 当作 mirror::Method*，扫前 64 字节找指向可执行段的指针 ──
      s('');
      s('  ── 扫描 mirror::Method 内的指针 ──');
      let found = [];
      try {
        const m = ptr(handle.toString());
        for (let off = 0; off < 64; off += 8) {
          let p = null;
          try { p = m.add(off).readPointer(); } catch (e) { continue; }
          if (p.isNull()) continue;
          const r = inExec(p);
          const tag = r ? ('★ 可执行段 ' + r.base + ' +0x' + p.sub(r.base).toString(16)) : '';
          s('    +0x' + off.toString(16) + '  ' + p + '  ' + tag);
          if (r) found.push({ off: off, p: p, r: r });
        }
      } catch (e) { s('    读取失败: ' + e); }

      // ── 方案 B：对每个可执行指针，尝试读 ArtMethod 的 data_ 字段 ──
      found.forEach(function (f) {
        s('');
        s('  ── 候选 ArtMethod @handle+0x' + f.off.toString(16) + ' = ' + f.p + ' ──');
        const cand = f.p;   // 可能指向 mirror::Method 或 ArtMethod
        // 尝试多个已知偏移
        [0x08, 0x10, 0x18, 0x20, 0x28, 0x30].forEach(function (o) {
          let q = null;
          try { q = cand.add(o).readPointer(); } catch (e) { return; }
          if (q.isNull()) return;
          const r2 = inExec(q);
          if (r2) {
            s('      +0x' + o.toString(16) + ' → ' + q +
              '  ★ 可执行 (段 ' + r2.base + ' +0x' + q.sub(r2.base).toString(16) + ')');
          }
        });
      });

      // ── 方案 C：直接在所有 r-x 段里搜 "signRequest" 字符串引用（JNI 注册表）──
      s('');
      s('  ── 在所有可执行段搜索 JNI 方法名指针 ──');
      const rs = getExecRanges();
      s('    可执行段数: ' + rs.length);
      // 找 "signRequest\0" 字符串（在任意可读内存）
      let strAddr = null;
      try {
        const pat = '73 69 67 6e 52 65 71 75 65 73 74 00';   // "signRequest"
        const all = Process.enumerateRanges('r--');
        for (let i = 0; i < all.length && !strAddr; i++) {
          const r = all[i];
          if (r.size > 64 * 1024 * 1024) continue;
          try {
            const res = Memory.scanSync(r.base, r.size, pat);
            if (res && res.length) { strAddr = res[0].address; break; }
          } catch (e) {}
        }
      } catch (e) {}
      if (strAddr) {
        s('    "signRequest" 字符串 @ ' + strAddr);
        // 搜指向它的指针（JNINativeMethod 表的 name 字段）
        let hits = 0;
        const needle = strAddr.toString().replace('0x', '');
        const bytes = [];
        for (let i = needle.length - 2; i >= 0; i -= 2) bytes.push(needle.substr(i, 2));
        const pat2 = bytes.join(' ');
        s('    搜索指向它的指针 (模式 ' + pat2 + ') ...');
        const all = Process.enumerateRanges('rw-');
        for (let i = 0; i < all.length && hits < 5; i++) {
          const r = all[i];
          if (r.size < 8 || r.size > 32 * 1024 * 1024) continue;
          try {
            const res = Memory.scanSync(r.base, r.size, pat2);
            if (res && res.length) {
              res.slice(0, 3).forEach(function (x) {
                hits++;
                // JNINativeMethod { name; signature; fnPtr; } = 24 字节
                let sig = null, fn = null;
                try { sig = x.address.add(8).readPointer().readCString(); } catch (e) {}
                try { fn = x.address.add(16).readPointer(); } catch (e) {}
                s('      ★ JNINativeMethod 候选 @ ' + x.address);
                s('         name = "signRequest"');
                s('         signature = ' + sig);
                s('         fnPtr = ' + fn);
                if (fn && !fn.isNull()) {
                  const rr = inExec(fn);
                  s('         fnPtr 所属: ' + (rr ? ('可执行段 ' + rr.base +
                      ' +0x' + fn.sub(rr.base).toString(16) + '  大小 ' + (rr.size/1024).toFixed(0) + 'KB')
                      : '(非可执行)'));
                }
              });
            }
          } catch (e) {}
        }
        if (hits === 0) s('    未找到指向它的指针');
      } else {
        s('    未找到 "signRequest" 字符串');
      }

      // 确认调用
      try {
        const N2 = Java.use('com.huachenjie.c.HcjNative');
        s('');
        s('  实测: ' + String(N2.signRequest('{"probe":1}', 0)).substring(0, 36) + '...');
      } catch (e) {}
    });
  }
});
s('[boot] ArtMethod 扫描就绪');
