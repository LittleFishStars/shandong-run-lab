/**
 * v36 ★★★★ 抓 libjiagu.so 的内存镜像 + dump libsecsdk.so 解密后的代码。
 *
 * v35 决定性发现：
 *   [dlopen] "libjiagu.so"                    ← 360 加固核心（makekey 提供者）
 *   [dlsym]  "doSetShellState"
 *   [android_dlopen_ext] ".../libjiagu_sdk_OSETSDKProtected.so"
 *   [android_dlopen_ext] "/data/user/0/.../files/.motion/libxt_a64.so"
 *   [android_dlopen_ext] ".../libsecsdk.so"    ← 易盾 NIS
 *
 * 静态发现：
 *   · libjiagu_sdk_OSETSDKProtected.so 只有 "libjiagu.so" 一个相关字符串
 *   · libxt_a64.so 无任何 360 特征串（577 个可打印串全不是）
 *   · libsecsdk.so 熵 6.609、无 Java_* 导出
 *   ⇒ 字符串在运行时被抹除/解密 → 必须抓内存镜像
 *
 * 本脚本：
 *   ① hook dlopen/dlsym，等 "libjiagu.so" 出现即记录返回值（handle）
 *   ② libjiagu.so 是内存生成物 → 从其 handle 或 maps 找落点，dump 全部段
 *   ③ 同时 dump libsecsdk.so 的解密代码区
 *   ④ 在 libjiagu.so 内存镜像中搜 makekey/doSetShellState 字符串
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}
function loc(a) {
  try {
    const r = Process.findRangeByAddress(a);
    if (r) return r.protection + ' ' + (r.file ? r.file.path : '[anon]') +
      ' @' + r.base + '+0x' + a.sub(r.base).toString(16) + ' sz=0x' + r.size.toString(16);
  } catch (e) {}
  return '?';
}

const WATCH = ['libjiagu', 'xt_a64', 'libsecsdk', 'libNetHTProtect', 'liball_in_one', 'libnesec'];
let dumpedJiagu = false, dumpedSecsdk = false;

// ══════════ dump 一个模块的全部段 ══════════
function dumpModule(modName, tag, maxTotal) {
  s('');
  s('════ dump ' + modName + '（' + tag + '）════');
  let segs = [];
  try {
    Process.enumerateRanges('r--').forEach(function (r) {
      if (r.file && r.file.path.indexOf(modName) >= 0) segs.push(r);
    });
  } catch (e) {}
  if (!segs.length) {
    s('  按路径找不到，改用 base 范围');
    try {
      const m = Process.findModuleByName(modName);
      if (m) segs.push({ base: m.base, size: m.size, protection: 'r--', file: { path: m.path } });
    } catch (e) {}
  }
  s('  段数: ' + segs.length);
  let total = 0;
  segs.forEach(function (r, i) {
    s('  [' + i + '] ' + r.base + ' sz=0x' + r.size.toString(16) + ' ' + r.protection +
      '  ' + (r.file ? r.file.path.split('/').pop() : '[anon]'));
  });
  const LIMIT = maxTotal || (8 * 1024 * 1024);
  segs.forEach(function (r) {
    if (total >= LIMIT) return;
    const want = Math.min(r.size, LIMIT - total);
    s('  dump ' + r.base + ' ' + want + ' 字节');
    send({ t: 'dumpmeta', name: modName, base: String(r.base), size: want });
    const CHUNK = 240 * 1024;
    for (let off = 0; off < want; off += CHUNK) {
      const sz = Math.min(CHUNK, want - off);
      try {
        send({ t: 'chunk', off: off, size: sz }, r.base.add(off).readByteArray(sz));
        total += sz;
      } catch (e) {}
    }
  });
  s('  合计 dump ' + total + ' 字节');
  return total;
}

// ══════════ 在内存中搜字符串 ══════════
function searchStr(keyword) {
  let o = [];
  const pat = keyword.split('').map(function (c) {
    return ('0' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(' ');
  try {
    ['r--', 'rw-', 'r-x'].forEach(function (prot) {
      Process.enumerateRanges(prot).forEach(function (r) {
        if (r.size < 8 || r.size > 16 * 1024 * 1024) return;
        let res = null;
        try { res = Memory.scanSync(r.base, r.size, pat); } catch (e) { return; }
        if (!res || !res.length) return;
        res.forEach(function (x) {
          if (o.length < 12) o.push({ addr: x.address, range: r });
        });
      });
    });
  } catch (e) {}
  return o;
}

// ══════════ hook loader ══════════
Java.perform(function () {
  ['dlopen', 'android_dlopen_ext', 'dlsym'].forEach(function (nm) {
    let p = null;
    try { p = Module.getGlobalExportByName(nm); } catch (e) {}
    if (!p) return;
    try {
      Interceptor.attach(p, {
        onEnter: function (a) {
          this.nm = nm;
          let name = null;
          try { name = (nm === 'dlsym' ? a[1] : a[0]).readCString(); } catch (e) {}
          this.libname = name || '';
          if (name && WATCH.some(function (w) { return name.indexOf(w) >= 0; })) {
            s('  [' + nm + '] ' + JSON.stringify(name));
          }
        },
        onLeave: function (rv) {
          if (this.nm === 'dlsym') {
            // 记录 doSetShellState 等符号解析结果
            if (this.libname && /doSetShellState|makekey|QHClassLoader/.test(this.libname)) {
              s('  [dlsym 结果] ' + this.libname + ' → ' + rv);
            }
          }
        }
      });
      s('[钩] ' + nm);
    } catch (e) {}
  });
});

// ══════════ 主体 ══════════
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
        s('[DC] warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 16));
      } catch (e) {}

      s('');
      s('════ ① 内存搜关键字符串 ════');
      ['makekey', 'doSetShellState', 'jiaguVersion', '360DC_DeviceId', 'QIHOO', 'libjiagu'].forEach(function (k) {
        const hits = searchStr(k);
        s('  "' + k + '" → ' + hits.length + ' 处' + (hits.length ? ':' : ''));
        hits.slice(0, 4).forEach(function (h) {
          s('      ' + h.addr + '  ' + loc(h.addr));
        });
      });

      s('');
      s('════ ② 已加载模块快照 ════');
      try {
        Process.enumerateModules().forEach(function (m) {
          if (/jiagu|xt_a64|secsdk|NetHT|all_in_one|nesec|oset/i.test(m.name)) {
            s('  ' + m.name.padEnd(36) + ' ' + m.base + ' sz=0x' + m.size.toString(16) +
              '  ' + m.path);
          }
        });
      } catch (e) {}

      s('');
      s('════ ③ 触发 signRequest（带动壳加载）════');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        s('  sign: ' + String(H2.signRequest('{"probe":1}', 0)).substring(0, 32));
      } catch (e) {}

      // 再查一次（加载后）
      s('');
      s('════ ④ 加载后再搜 ════');
      ['makekey', 'doSetShellState', 'libjiagu'].forEach(function (k) {
        const hits = searchStr(k);
        s('  "' + k + '" → ' + hits.length + ' 处');
        hits.slice(0, 5).forEach(function (h) {
          s('      ' + h.addr + '  ' + loc(h.addr));
        });
      });

      s('');
      s('════ ⑤ 模块状态（第二次）════');
      try {
        Process.enumerateModules().forEach(function (m) {
          if (/jiagu|xt_a64|secsdk|NetHT|all_in_one|nesec|oset/i.test(m.name)) {
            s('  ' + m.name.padEnd(36) + ' ' + m.base + ' sz=0x' + m.size.toString(16) +
              '  ' + m.path);
          }
        });
      } catch (e) {}

      send({ t: 'DONE' });
    });
  }
});
s('[boot] v36 就绪');
