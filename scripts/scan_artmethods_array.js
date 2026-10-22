/**
 * 最终手段：扫描 ART 堆里的 ArtMethod，按「access_flags 含 native 位 + entry 落在可执行段」
 * 特征筛出全部 native 方法，再与 signRequest 的特征比对。
 *
 * 更稳的做法：hook art::ClassLinker::DefineClass（我们已知道 vaddr 0x11c7d8），
 * 在定义 Lcom/huachenjie/c/HcjNative; 时，从返回的 mirror::Class* 里读
 * art_methods_ 数组 —— 那是该类所有 ArtMethod 的连续数组。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

function inExec(p) {
  try {
    const r = Process.findRangeByAddress(p);
    if (r && r.protection.indexOf('x') >= 0) return r;
  } catch (e) {}
  return null;
}

// 在 mirror::Class 里找 art_methods_ 数组（长度 = num_methods_）
function findArtMethods(classPtr, tag) {
  s('  [' + tag + '] mirror::Class* = ' + classPtr);
  // 扫描 Class 对象前 256 字节，找「指针 + 合理长度」的组合
  for (let off = 0; off < 256; off += 4) {
    let cnt = 0, arr = null;
    try { cnt = classPtr.add(off).readU32(); } catch (e) { continue; }
    if (cnt === 0 || cnt > 4096) continue;
    // 长度后面紧跟指针（或前一个位置是指针）
    for (const po of [off + 4, off - 4, off + 8]) {
      if (po < 0 || po > 256) continue;
      let p = null;
      try { p = classPtr.add(po).readPointer(); } catch (e) { continue; }
      if (p.isNull()) continue;
      // 数组元素 32 字节（ArtMethod），检查首元素 access_flags 是否为合理值
      try {
        const af = p.add(4).readU32();
        if (af === 0 || af > 0x100000) continue;
        // 检查第一、二个元素的 entry（+0x18 / +0x20）是否在可执行段或为 0
        let okc = 0;
        for (let i = 0; i < Math.min(cnt, 8); i++) {
          const e1 = p.add(i * 32 + 0x18).readPointer();
          const e2 = p.add(i * 32 + 0x20).readPointer();
          if (inExec(e1) || inExec(e2) || e2.isNull()) okc++;
        }
        if (okc >= Math.min(cnt, 8) - 2) {
          s('    ★ 候选 art_methods_: cnt=' + cnt + ' @Class+0x' + off.toString(16) +
            '  数组=' + p);
          return { ptr: p, cnt: cnt, cntOff: off, ptrOff: po };
        }
      } catch (e) {}
    }
  }
  s('    未找到 art_methods_ 数组');
  return null;
}

let fired = false;
let targetClass = null;

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (d && d.indexOf('Lcom/huachenjie/c/HcjNative;') === 0) {
      s('[DefineClass] 命中 HcjNative');
      // x0 = 返回值（mirror::Class*）的存放地址（ArtMethod 调用约定：sret 或寄存器返回）
      // 这里在 onLeave 读返回寄存器 x0
      this.isTarget = true;
    }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    if (fired) return;
    fired = true;
    Java.perform(function () {
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        s('实测: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 30) + '...');
      } catch (e) {}
    });
  },
  onLeave: function (retval) {
    if (!this.isTarget) return;
    s('[DefineClass] HcjNative 返回 mirror::Class* = ' + retval);
    const am = findArtMethods(retval, 'HcjNative');
    if (!am) return;
    s('  ── 遍历 art_methods_（' + am.cnt + ' 个）──');
    const found = [];
    for (let i = 0; i < Math.min(am.cnt, 64); i++) {
      const base = am.ptr.add(i * 32);
      let af = 0, jni = null, quick = null, idx = 0;
      try {
        af = base.add(4).readU32();
        idx = base.add(0x10).readU16 ? base.add(0x10).readU16() : 0;
        jni = base.add(0x18).readPointer();
        quick = base.add(0x20).readPointer();
      } catch (e) { continue; }
      const rj = inExec(jni), rq = inExec(quick);
      if (rj || rq) {
        const r = rj || rq;
        s('    #' + i + '  af=0x' + af.toString(16) +
          '  jni=' + jni + (rj ? ' (段 ' + rj.base + ' +0x' + jni.sub(rj.base).toString(16) + ')' : '') +
          '  quick=' + quick + (rq ? ' (段 ' + rq.base + ')' : ''));
        found.push({ i: i, af: af, jni: jni, seg: r.base, off: (rj ? jni.sub(rj.base) : quick.sub(rq.base)) });
      }
    }
    s('  ── 可执行入口共 ' + found.length + ' 个 ──');
    send({ t: 'methods', cnt: am.cnt,
           items: found.map(function (x) {
             return { i: x.i, af: '0x' + x.af.toString(16), seg: x.seg.toString(),
                      off: '0x' + x.off.toString(16) };
           })});
  }
});
s('[boot] ArtMethod 数组扫描就绪');
