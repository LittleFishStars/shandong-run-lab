/**
 * v35 ★★★ 定位 360 加固的 makekey 与密钥派生链。
 *
 * 背景：
 *   · report/10 记录 1148KB 段（so_0x7ca8bda000.bin）的 .dynstr 里有 `makekey`
 *     且伴随 24 个 360 相关字符串（libjiagu.so / com.jiagu.sdk / jiagu_vip /
 *     doSetShellState / QIHOO / 360DC_DeviceId / jiaguVersion）
 *   · 但 `makekey` 在该段的**导入符号表**里 → 提供者是外部库
 *   · 设备上无独立 libjiagu.so，只有 libjiagu_sdk_OSETSDKProtected.so（797KB）
 *   · 发现 360 运行时产物：files/.motion/libxt_a64.so（290KB，NDK r29，未加密）
 *     + .imprint（设备指纹）+ .dmpvedpogjhejs.cfg + 两个 128 字节文件
 *
 * 本脚本（多路并进）：
 *   ① 列出全部已加载模块，筛出 360/jiagu/xt/hodor 相关
 *   ② 在这些模块中搜 `makekey` 导出符号 + 定位它的代码
 *   ③ hook dlopen/dlsym，抓 360 库的动态加载（可能运行时才落地）
 *   ④ 若找到 makekey：hook 它，抓 (输入, 输出) → 反推密钥派生
 *   ⑤ 枚举 files 目录下 360 运行时文件的变化（观察密钥槽刷新）
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
function locate(a) {
  if (!a || a.isNull()) return 'null';
  try {
    const r = Process.findRangeByAddress(a);
    if (r) return r.protection + ' ' + (r.file ? r.file.path.split('/').pop() : '[anon]') +
      '+0x' + a.sub(r.base).toString(16);
  } catch (e) {}
  return '?';
}

// ══════════ ① 模块枚举 ══════════
function listModules() {
  s('');
  s('════ ① 全部模块（筛 360/加固 相关）════');
  const KEY = ['jiagu', 'jiagu_sdk', 'OSET', 'oset', 'xt_a64', 'hodor', 'motion',
               'zxprotect', 'nesec', 'libsecsdk', 'liby', 'libNetHT', 'liball_in_one',
               'weapon', 'zx-core'];
  let n = 0, hits = [];
  try {
    Process.enumerateModules().forEach(function (m) {
      n++;
      const hit = KEY.some(function (k) { return m.name.indexOf(k) >= 0; });
      if (hit) {
        hits.push(m);
        s('  ★ ' + m.name.padEnd(38) + ' base=' + m.base + ' size=0x' + m.size.toString(16) +
          '  ' + m.path);
      }
    });
  } catch (e) { s('  枚举失败: ' + e); }
  s('  模块总数 ' + n + '，命中 ' + hits.length);
  return hits;
}

// ══════════ ② 在候选模块中搜 makekey ══════════
function findMakekey(mods) {
  s('');
  s('════ ② 在候选模块中搜 "makekey" ════');
  const PAT = '6d 61 6b 65 6b 65 79';   // "makekey"
  let totalHits = 0;
  mods.forEach(function (m) {
    let res = null;
    try { res = Memory.scanSync(m.base, m.size, PAT); } catch (e) { return; }
    if (!res || !res.length) return;
    totalHits += res.length;
    s('  ' + m.name + ': 命中 ' + res.length + ' 处');
    res.slice(0, 6).forEach(function (r) {
      const off = r.address.sub(m.base);
      let ctx = '';
      try { ctx = r.address.sub(16).readCString(); } catch (e) {}
      s('    @base+0x' + off.toString(16) + '   上下文=' + JSON.stringify((ctx || '').substring(0, 40)));
    });
  });
  if (!totalHits) s('  （候选模块中无 "makekey" 字符串）');

  // 全内存搜（含匿名段）
  s('');
  s('════ ②b 全内存搜 "makekey"（含匿名段）════');
  let anon = 0;
  try {
    Process.enumerateRanges('r--').forEach(function (r) {
      if (r.size < 128 || r.size > 32 * 1024 * 1024) return;
      let res = null;
      try { res = Memory.scanSync(r.base, r.size, PAT); } catch (e) { return; }
      if (!res || !res.length) return;
      res.forEach(function (x) {
        anon++;
        if (anon <= 15) {
          s('  @' + x.address + '  段=' + r.base + ' sz=0x' + r.size.toString(16) +
            (r.file ? '  ' + r.file.path.split('/').pop() : '  [anon]'));
        }
      });
    });
  } catch (e) {}
  s('  匿名段命中合计: ' + anon);
}

// ══════════ ③ hook dlopen / dlsym ══════════
function hookLoader() {
  s('');
  s('════ ③ hook 动态加载（抓 360 库的加载）════');
  ['dlopen', 'android_dlopen_ext', 'dlsym'].forEach(function (nm) {
    let p = null;
    try { p = Module.getGlobalExportByName(nm); } catch (e) {}
    if (!p) { s('  ✗ 找不到 ' + nm); return; }
    try {
      Interceptor.attach(p, {
        onEnter: function (args) {
          let name = null;
          try {
            if (nm === 'dlsym') name = args[1].readCString();
            else name = args[0].readCString();
          } catch (e) {}
          if (name && /jiagu|hodor|xt_|motion|oset|makekey|\.so$/i.test(name)) {
            s('  [' + nm + '] ' + JSON.stringify(name));
          }
        },
        onLeave: function (rv) {
          if (nm === 'dlsym' && rv && !rv.isNull()) {
            // 只报刚加载的 360 相关符号
          }
        }
      });
      s('  ✓ hook ' + nm + ' @' + p);
    } catch (e) { s('  ✗ ' + nm + ': ' + String(e).substring(0, 60)); }
  });
}

// ══════════ ④ 检查 360 运行时文件目录 ══════════
function checkFiles() {
  s('');
  s('════ ④ 360 运行时文件（.motion / .hodor / 密钥槽）════');
  try {
    const F = Java.use('java.io.File');
    const dirs = [
      '/data/data/com.huachenjie.shandong_school/files',
      '/data/data/com.huachenjie.shandong_school/files/.motion',
      '/data/data/com.huachenjie.shandong_school/files/.hodor',
      '/data/data/com.huachenjie.shandong_school/files/.2',
    ];
    dirs.forEach(function (d) {
      try {
        const f = F.$new(d);
        if (!f.exists()) { s('  ' + d + ' 不存在'); return; }
        const kids = f.listFiles();
        s('  ' + d + '  (' + (kids ? kids.length : 0) + ' 项)');
        if (kids) {
          for (let i = 0; i < Math.min(kids.length, 12); i++) {
            s('    ' + kids[i].getName() + '  ' + kids[i].length() + 'B' +
              (kids[i].isDirectory() ? ' [DIR]' : ''));
          }
        }
      } catch (e) { s('    ' + d + ' err: ' + String(e).substring(0, 50)); }
    });
  } catch (e) { s('  File 操作失败: ' + e); }
}

// ══════════ 主流程 ══════════
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

      const mods = listModules();
      findMakekey(mods);
      hookLoader();
      checkFiles();

      s('');
      s('════ 完成。触发一次 signRequest 看是否带动 360 加载 ════');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        s('  sign: ' + String(H2.signRequest('{"probe":1}', 0)).substring(0, 32));
      } catch (e) {}

      send({ t: 'DONE', mods: mods.map(function (m) {
        return { name: m.name, base: String(m.base), size: m.size, path: m.path };
      }) });
    });
  }
});
s('[boot] v35 就绪');
