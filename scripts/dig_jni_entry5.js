/**
 * v5：自校准 JNIEnv 布局 + 完整取回 signRequest 的真实 native 入口。
 *
 * 前几轮失败的根因：
 *   v2: table = env.handle.readPointer()          → FindClass 返回 0x0
 *   v3: table = env.handle                        → access violation 0x9
 *   两次都是「猜布局」。本版**实测两种解释**，用 GetVersion() 的返回值
 *   （应为 0x10006 = JNI 1.6）判定哪种正确，再继续。
 *
 * 拿到入口后：
 *   1) locate 所属映射
 *   2) Interceptor.attach 验证 + 用 GetStringUTFChars 抓 jstring 参数
 *   3) 分片 dump 入口所在映射（宿主落盘）
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
function verifyBase(b) { return hex(b.add(SIG_VADDR), SIG.length / 2) === SIG; }
function locate(addr) {
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) return r.protection + ' ' + (r.file ? r.file.path : '[anon]') +
      ' @' + r.base + '+0x' + addr.sub(r.base).toString(16) + ' sz=0x' + r.size.toString(16);
  } catch (e) {}
  return '?';
}

// ══ 自校准：找出真正的 JNINativeInterface* ══
function calibrate() {
  const env = Java.vm.getEnv();
  const h = env.handle;
  s('[cal] env.handle = ' + h);
  const tries = [
    ['A: table = handle.readPointer()', (function () { try { return h.readPointer(); } catch (e) { return null; } })()],
    ['B: table = handle', h],
  ];
  for (let i = 0; i < tries.length; i++) {
    const name = tries[i][0], table = tries[i][1];
    if (!table || table.isNull()) { s('  ' + name + ' → null'); continue; }
    let ver = -1, err = '';
    try {
      const GetVersion = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
      ver = GetVersion(table) >>> 0;
    } catch (e) { err = String(e); }
    s('  ' + name + ' → table=' + table + '  GetVersion=0x' + ver.toString(16) +
      (err ? '  err=' + err : ''));
    if (ver === 0x10006 || ver === 0x10008 || (ver > 0x10000 && ver < 0x20000)) {
      s('  ★ 校准成功：采用 ' + name);
      send({ t: 'jit', mode: name, table: String(table) });
      return table;
    }
  }
  s('  ✗ 两种解释都失败');
  return null;
}

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
      try { s('warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24)); } catch (e) { s('warm err: ' + e); }

      const table = calibrate();
      if (!table) { return; }

      // fromReflectedMethod 是最稳的 ArtMethod 获取方式（不需要 FindClass）
      let mid = null;
      try {
        const env = Java.vm.getEnv();
        const meth = H.class.getDeclaredMethods().find(function (m) {
          return String(m.getName()) === 'signRequest';
        });
        s('[B] 反射 Method: ' + meth);
        if (meth) {
          // frida-java-bridge 的 JavaMethod 包装器内部持 handle（jobject）
          const cand = meth.handle || meth.$handle || null;
          s('[B] 包装器 handle = ' + cand);
          const FromReflectedMethod = new NativeFunction(
            table.add(7 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
          if (cand) {
            mid = FromReflectedMethod(table, cand);
            s('[B] FromReflectedMethod → ' + mid);
          }
        }
      } catch (e) { s('[B] err: ' + e); }

      // 兜底：FindClass + vtable 113
      if (!mid || mid.isNull()) {
        try {
          const FindClass = new NativeFunction(table.add(6 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
          const GetStaticMethodID = new NativeFunction(table.add(113 * 8).readPointer(), 'pointer',
            ['pointer', 'pointer', 'pointer', 'pointer']);
          const jc = FindClass(table, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
          s('[B2] FindClass → ' + jc);
          if (jc && !jc.isNull()) {
            mid = GetStaticMethodID(table, jc,
              Memory.allocUtf8String('signRequest'),
              Memory.allocUtf8String('(Ljava/lang/String;I)Ljava/lang/String;'));
            s('[B2] GetStaticMethodID → ' + mid);
          }
        } catch (e) { s('[B2] err: ' + e); }
      }
      if (!mid || mid.isNull()) { s('✗ ArtMethod 未取得'); send({ t: 'nomid' }); return; }

      s('[B] ArtMethod* = ' + mid + '  ' + locate(mid));
      s('[B] 结构[0..0x30]: ' + hex(mid, 0x30));

      // data_ 候选（native 方法 = entry_point_from_jni_）
      let fn = null;
      [0x18, 0x20, 0x28, 0x10].forEach(function (off) {
        try {
          const p = mid.add(off).readPointer();
          if (p.compare(ptr(0x10000)) < 0) return;
          const lc = locate(p);
          const by = hex(p, 16);
          s('  +0x' + off.toString(16) + ' = ' + p + '  ' + lc + '  ' + by);
          if (!fn && lc.indexOf('r-x') >= 0 && lc.indexOf('libart') < 0) fn = p;
        } catch (e) {}
      });
      if (!fn) { s('✗ 无可执行 data_ 候选'); send({ t: 'nofn' }); return; }
      s('★★★ 真实入口 = ' + fn + '  ' + locate(fn));

      // hook 验证 + 抓参数
      let hits = 0, argJson = '';
      const GetStringUTFChars = new NativeFunction(table.add(169 * 8).readPointer(), 'pointer',
        ['pointer', 'pointer', 'pointer']);
      const ReleaseStringUTFChars = new NativeFunction(table.add(170 * 8).readPointer(), 'void',
        ['pointer', 'pointer', 'pointer']);
      try {
        Interceptor.attach(fn, {
          onEnter: function (args) {
            hits++;
            try {
              const c = GetStringUTFChars(table, args[2], ptr(0));
              argJson = c.readUtf8String();
              ReleaseStringUTFChars(table, args[2], c);
            } catch (e) { argJson = 'read-err'; }
          }
        });
        s('  hook 已装，调 signRequest {"probe2":1}');
        const out = String(H.signRequest('{"probe2":1}', 0));
        s('  out: ' + out.substring(0, 44));
        s('  触发: ' + hits + ' 次   参数: ' + argJson);
        send({ t: 'fn', fn: String(fn), hits: hits, arg: argJson });
      } catch (e) { s('  验证 err: ' + e); }

      // dump 入口所在映射
      try {
        const r = Process.findRangeByAddress(fn);
        if (r) {
          const total = Math.min(r.size, 768 * 1024);
          send({ t: 'dumpmeta', base: String(r.base), size: total, prot: r.protection });
          s('dump ' + r.base + ' size=' + total + ' prot=' + r.protection);
          const CHUNK = 200 * 1024;
          for (let off = 0; off < total; off += CHUNK) {
            const sz = Math.min(CHUNK, total - off);
            send({ t: 'chunk', off: off, size: sz }, r.base.add(off).readByteArray(sz));
          }
        }
      } catch (e) { s('  dump err: ' + e); }
    });
  }
});
s('[boot] v5 就绪');
