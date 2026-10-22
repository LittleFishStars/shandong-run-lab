/**
 * v13：按 **JNI 签名**（而非名字）匹配 signRequest。
 *
 * v12 发现：
 *   · RegisterNatives hook 完全有效，捕获 27+ 批次 432+ 方法
 *   · 名字全被加密，但 **签名是明文**（"(Landroid/app/Application;..." 等可读）
 *   · 批次#1 的 11 个 = libnesec.so 的壳 native（report/02 已记录）
 *   · signRequest 不在前 2 批 → 在后续批次
 *
 * 本法：全程收集，按签名匹配这三个目标签名：
 *   signRequest          (Ljava/lang/String;I)Ljava/lang/String;
 *   encodeRun            (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
 *   buildFlutterSecParams (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
 * 命中即报 fnPtr + 归属 + dump 所在段。
 *
 * 同时：对**所有**非系统 fnPtr 装 hook，最后一次调用统一验证（双保险）。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const WANT = [
  '(Ljava/lang/String;I)Ljava/lang/String;',
  '(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;',
  '(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;',
];
const NAMES = ['signRequest', 'encodeRun', 'buildFlutterSecParams'];

function locate(a2) {
  try {
    const r = Process.findRangeByAddress(a2);
    if (r) return r.protection + ' ' + (r.file ? r.file.path.split('/').pop() : '[anon]') +
      '@' + r.base + '+0x' + a2.sub(r.base).toString(16);
  } catch (e) {}
  return '?';
}
function isSys(a2) {
  try {
    const r = Process.findRangeByAddress(a2);
    if (!r) return true;
    const p = r.file ? r.file.path : '';
    if (!p) return false;
    return p.indexOf('/system/') >= 0 || p.indexOf('/apex/') >= 0 ||
           p.indexOf('/vendor/') >= 0 || p.indexOf('libart') >= 0 ||
           p.indexOf('libc') >= 0 || p.indexOf('frida') >= 0;
  } catch (e) { return true; }
}
function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

const found = [];          // 按签名命中的
const nonSys = [];         // 所有非系统 fnPtr（去重）
const seen = {};
let batches = 0, methods = 0;

Java.perform(function () {
  let table = null;
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    const ver = gv(table) >>> 0;
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败 0x' + ver.toString(16)); return; }
    s('[cal] OK 0x' + ver.toString(16));
  } catch (e) { s('[cal] err: ' + e); return; }

  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a2) {
        try {
          const arr = a2[2], count = a2[3].toInt32();
          if (count <= 0 || count > 600) return;
          batches++; methods += count;
          for (let i = 0; i < count; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (!fn || fn.isNull()) continue;

            // ★ 按签名匹配
            const wi = WANT.indexOf(sig);
            if (wi >= 0) {
              const rec = { want: NAMES[wi], sig: sig, fn: fn, loc: locate(fn), bytes: hex(fn, 32) };
              found.push(rec);
              s('════════ ★★★ 签名命中: ' + NAMES[wi] + ' ★★★ ════════');
              s('  批次#' + batches + '.' + i + '   sig=' + sig);
              s('  fnPtr = ' + fn + '   ' + rec.loc);
              s('  bytes = ' + rec.bytes);
              send({ t: 'SIGMATCH', rec: { want: rec.want, fn: String(fn), loc: rec.loc, bytes: rec.bytes } });
            }
            // 收集非系统库指针
            if (!isSys(fn)) {
              const k = fn.toString();
              if (!seen[k]) { seen[k] = 1; nonSys.push({ fn: fn, sig: sig }); }
            }
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RegisterNatives hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a2) {
    if (fired) return;
    let d = ''; try { d = a2[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;
    s('[DC] ' + d);

    Java.perform(function () {
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('[probe] ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) { s('[probe] err: ' + String(e).substring(0, 70)); }
      s('  此刻: 批次=' + batches + ' 方法=' + methods + ' 签名命中=' + found.length + ' 非系统=' + nonSys.length);
      send({ t: 'PROGRESS', batches: batches, methods: methods, found: found.length });
    });
  }
});
s('[boot] v13 就绪（按签名匹配）');
