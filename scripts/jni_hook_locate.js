/**
 * 同进程内一次性完成：定位 signRequest 的 JNI 入口 + 所属段 + 该段基址。
 *
 * 前次教训：跨进程抓到的地址会失效（应用重启后 ASLR 变化）。必须在**同一进程内**
 * 完成"找字符串 → 找引用 → 报段基址"。
 *
 * 关键改进：不用 $handle（Frida 17 里反射 Method 对象没有该属性），改从
 * JNI RegisterNatives 的调用点入手 —— 但那太早。改用最直接的办法：
 *   ① 在 native 层 hook `signRequest` 的**实际被调用**（用 Interceptor.attach 到
 *      所有候选段里的函数不可行）→ 改为
 *   ② 读 `JNIEnv*` 的 GetStaticMethodID 返回值：hook libart 的 GetStaticMethodID，
 *      当返回的 methodId 对应的方法名是 signRequest 时记录指针
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

// libart 里 JNI 函数表相关符号（Android 9 常用偏移，逐个尝试）
const JNI_SYMS = [
  ['_ZN3art3JNI17GetStaticMethodIDEP7_JNIEnvP7_jclassPKcS6_', 'GetStaticMethodID'],
  ['_ZN3art3JNI15GetMethodIDEP7_JNIEnvP7_jclassPKcS6_',        'GetMethodID'],
  ['_ZN3art3JNI18RegisterNativesEP7_JNIEnvP7_jclassPK15JNINativeMethodi', 'RegisterNatives'],
];

let hooksDone = 0;
JNI_SYMS.forEach(function (pair) {
  let addr = null;
  try {
    if (typeof Module.findGlobalExportByName === 'function')
      addr = Module.findGlobalExportByName(pair[0]);
  } catch (e) {}
  if (!addr && typeof Module.getGlobalExportByName === 'function') {
    try { addr = Module.getGlobalExportByName(pair[0]); } catch (e) {}
  }
  // libart 的符号可能未导出 → 用 DebugSymbol 从 .dynsym 找
  if (!addr) {
    try {
      const ds = DebugSymbol.fromName(pair[0]);
      if (ds && ds.address && !ds.address.isNull()) addr = ds.address;
    } catch (e) {}
  }
  if (!addr) { s('  [skip] ' + pair[1] + ' 未找到导出'); return; }

  try {
    Interceptor.attach(addr, {
      onEnter: function (args) {
        if (pair[1] === 'GetStaticMethodID' || pair[1] === 'GetMethodID') {
          let name = '';
          try { name = args[2].readCString(); } catch (e) {}
          this.isTarget = (name === 'signRequest' || name === 'encodeRun' ||
                           name === 'buildFlutterSecParams');
          this.name = name;
        } else {
          // RegisterNatives: 扫表
          this.nm = args[2];
          this.cnt = args[3].toInt32();
        }
      },
      onLeave: function (rv) {
        if (this.isTarget) {
          s('★★★ GetMethodID 命中: ' + this.name + ' → methodId = ' + rv);
          dumpArtMethod(rv, this.name);
        }
        if (this.nm && !this.nm.isNull() && this.cnt > 0 && this.cnt < 500) {
          for (let i = 0; i < this.cnt; i++) {
            const e = this.nm.add(i * 24);
            let nm = '';
            try { nm = e.readPointer().readCString(); } catch (e2) { continue; }
            if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams') {
              let sig = '', fn = null;
              try { sig = e.add(8).readPointer().readCString(); } catch (e2) {}
              try { fn = e.add(16).readPointer(); } catch (e2) {}
              s('★★★ RegisterNatives 命中: ' + nm);
              s('     signature = ' + sig);
              s('     fnPtr     = ' + fn);
              reportSeg(fn, nm);
            }
          }
        }
      }
    });
    hooksDone++;
    s('  [hook] ' + pair[1]);
  } catch (e) { s('  [hook] ' + pair[1] + ' 失败: ' + e); }
});

function reportSeg(p, tag) {
  if (!p || p.isNull()) return;
  try {
    const r = Process.findRangeByAddress(p);
    if (r) {
      s('     ' + tag + ' 所属段: ' + r.base + ' - ' + r.base.add(r.size) +
        '  ' + r.protection + '  ' + (r.size/1024).toFixed(0) + 'KB');
      s('     段内偏移 = 0x' + p.sub(r.base).toString(16));
      send({ t: 'impl', tag: tag, addr: p.toString(),
             segBase: r.base.toString(), segSize: r.size,
             segProt: r.protection, offset: p.sub(r.base).toString(16) });
    } else {
      s('     ' + tag + ' 不属于任何已映射段（匿名？）');
    }
  } catch (e) { s('     reportSeg 失败: ' + e); }
}

function dumpArtMethod(mid, name) {
  s('     ── ArtMethod 字段（' + name + '）──');
  const F = [
    ['declaring_class', 0x00, 4], ['access_flags', 0x04, 4],
    ['dex_code_item', 0x08, 4], ['dex_method_idx', 0x0c, 4],
    ['method_index', 0x10, 2], ['hotness', 0x12, 2],
    ['data_(jni_entry)', 0x18, 8], ['quick_compiled', 0x20, 8],
  ];
  F.forEach(function (f) {
    try {
      const v = mid.add(f[1]);
      if (f[2] === 8) {
        const p = v.readPointer();
        s('       ' + f[0].padEnd(18) + ' = ' + p);
        reportSeg(p, f[0]);
      } else {
        s('       ' + f[0].padEnd(18) + ' = 0x' + v.readU32().toString(16));
      }
    } catch (e) { s('       ' + f[0] + ' 读失败'); }
  });
}

// 触发
const DC = 0x11c7d8;
let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;
    s('[native] 触发: ' + d);
    Java.perform(function () {
      try {
        s('当前已安装 hook: ' + hooksDone);
        if (hooksDone === 0) {
          s('! libart JNI 符号未导出，改用「反射 + 段扫描」方案');
          reflectScan();
        }
        const N = Java.use('com.huachenjie.c.HcjNative');
        s('触发调用: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 32) + '...');
      } catch (e) { s('' + e); }
    });
  }
});

// 备用方案：反射取 Method，再从 ART 类对象的 vtable/art_methods 数组找
function reflectScan() {
  try {
    const N = Java.use('com.huachenjie.c.HcjNative');
    const cls = N.class;
    const ms = cls.getDeclaredMethods();
    s('  声明方法数: ' + ms.length);
    ms.forEach(function (m) { s('    ' + m); });
    // Frida 17 里 Method 对象的内部指针可通过 Java.vm.getEnv().getObjectClass 等推导，
    // 但更稳的是：hook libart 的 Invoke 路径。这里先只列出方法。
  } catch (e) { s('  reflectScan 失败: ' + e); }
}

s('[boot] JNI 符号 hook 就绪（已装 ' + hooksDone + ' 个）');
