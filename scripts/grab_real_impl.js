/**
 * ★抓真实实现：GetStaticMethodID → ArtMethod → data_ 指针 →
 *   1) locate（哪个映射）
 *   2) Interceptor.attach 验证（调 signRequest 看是否触发）
 *   3) dump 入口所在整个映射（分片 send，落盘 work/real_impl/）
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

      // ArtMethod
      const env = Java.vm.getEnv();
      const fnTable = env.handle;
      const FindClass = new NativeFunction(fnTable.add(6 * 8).readPointer(), 'pointer', ['pointer', 'pointer']);
      const GetStaticMethodID = new NativeFunction(fnTable.add(113 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer', 'pointer']);
      const GetStringUTFChars = new NativeFunction(fnTable.add(169 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer']);
      const ReleaseStringUTFChars = new NativeFunction(fnTable.add(170 * 8).readPointer(), 'void', ['pointer', 'pointer', 'pointer']);
      const jclass = FindClass(fnTable, Memory.allocUtf8String('com/huachenjie/c/HcjNative'));
      if (!jclass || jclass.isNull()) { s('✗ jclass null'); return; }
      const mid = GetStaticMethodID(fnTable, jclass, Memory.allocUtf8String('signRequest'), Memory.allocUtf8String('(Ljava/lang/String;I)Ljava/lang/String;'));
      s('ArtMethod* = ' + mid);
      s('结构: ' + hex(mid, 0x30));

      // 找 data_ 候选
      let fn = null;
      [0x18, 0x20, 0x28].forEach(function (off) {
        try {
          const p = mid.add(off).readPointer();
          if (p.compare(ptr(0x10000)) < 0) return;
          let desc = '?';
          try {
            const r = Process.findRangeByAddress(p);
            if (r) desc = r.protection + (r.file ? ' ' + r.file.path : ' [anon]');
          } catch (e) {}
          s('  data_+0x' + off.toString(16) + ' = ' + p + '  ' + desc + '  bytes: ' + hex(p, 16));
          if (!fn && desc.indexOf('r-x') >= 0 && desc.indexOf('libart') < 0) fn = p;
        } catch (e) {}
      });
      if (!fn) { s('✗ 未找到可执行 data_ 候选'); send({t:'nomid'}); return; }
      s('★★★ 真实入口 = ' + fn);

      // hook 验证
      let hitCount = 0;
      let argJson = '';
      try {
        Interceptor.attach(fn, {
          onEnter: function (args) {
            hitCount++;
            // (env, clazz, jstring, jint)
            try {
              const js = args[2];
              const c = GetStringUTFChars(fnTable, js, ptr(0));
              argJson = c.readUtf8String();
              ReleaseStringUTFChars(fnTable, js, c);
            } catch (e) { argJson = 'read-err'; }
          }
        });
        s('  hook 已装');
      } catch (e) { s('  hook 失败: ' + e); }

      s('  调 signRequest {"probe2":1} ...');
      try {
        const out = String(H.signRequest('{"probe2":1}', 0));
        s('  out: ' + out.substring(0, 44));
      } catch (e) { s('  err: ' + e); }
      s('  触发次数: ' + hitCount + '  捕获参数: ' + argJson);
      send({ t: 'fn', fn: String(fn), hits: hitCount, arg: argJson });

      // dump 所在映射（找包含 fn 的 range，r-x 部分）
      try {
        const r = Process.findRangeByAddress(fn);
        if (r) {
          const RB = r.base, RS = r.size;
          s('════ dump 映射 ' + RB + ' sz=0x' + RS.toString(16) + ' prot=' + r.protection + ' ════');
          const CHUNK = 240 * 1024;
          const total = Math.min(RS, 1024 * 1024); // 上限 1MB
          send({ t: 'dumpmeta', base: String(RB), size: total, prot: r.protection });
          for (let off = 0; off < total; off += CHUNK) {
            const sz = Math.min(CHUNK, total - off);
            const data = RB.add(off).readByteArray(sz);
            send({ t: 'chunk', off: off, size: sz }, data);
            s('  chunk @+0x' + off.toString(16) + ' ' + sz + 'B 已发');
          }
        }
      } catch (e) { s('  dump err: ' + e); }
    });
  }
});
s('[boot] 抓真实实现就绪');
