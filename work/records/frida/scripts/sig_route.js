// sig_route.js —— 定位「重签名 → System.exit(0)」的判定点
//
// 已确立的事实（2026-10-15 对照实验）：
//   * 原始未修改 APK + Magisk DenyList → 正常运行（PrivacyActivity）
//   * 重签名原版 APK / 重打包 APK + 同样 DenyList → System.exit(0)
//   退出点：com.netease.nis.wrapper.MyJni.load ← MyApplication.attachBaseContext
//
// 本脚本同时铺网：
//   A. Java 层所有「取签名」入口（含 API 28+ 的 signingInfo 路径）
//   B. 所有签名对象的内容读取（toByteArray / toCharsString / hashCode）
//   C. native 层对 APK 文件的读取（open/openat/fopen/stat）
//   D. MyJni / MyApplication 的调用链
//   E. System.exit 的 Java 栈
//   F. libnesec.so 导出符号枚举

'use strict';

var MAX = 600;
var n = 0;
function log(m) {
    if (n++ > MAX) return;
    send({ t: 'log', msg: String(m) });
}
function hex(u8, lim) {
    var s = '', L = Math.min(u8.length, lim || 32);
    for (var i = 0; i < L; i++) s += ('0' + u8[i].toString(16)).slice(-2);
    return s;
}
function sha256(u8) {
    try {
        var MD = Java.use('java.security.MessageDigest').getInstance('SHA-256');
        var jb = Java.array('byte', Array.prototype.slice.call(u8));
        return hex(new Uint8Array(MD.digest(jb)), 32);
    } catch (e) { return 'err'; }
}

// ═══════════ A. Java 层取签名入口 ═══════════
Java.perform(function () {
    log('[+] Java.perform 进入');

    // A1. ApplicationPackageManager.getPackageInfo / getPackageArchiveInfo
    ['getPackageInfo', 'getPackageArchiveInfo'].forEach(function (fn) {
        try {
            var PM = Java.use('android.app.ApplicationPackageManager');
            PM[fn].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    var a = Array.prototype.slice.call(arguments);
                    var ret = ov.apply(this, arguments);
                    try {
                        var flags = (typeof a[1] === 'number') ? a[1] : a[2];
                        log('[PM] ApplicationPackageManager.' + fn +
                            '("' + a[0] + '", flags=0x' + (flags >>> 0).toString(16) + ')');
                        if (ret) {
                            try {
                                var sigs = ret.signatures.value;
                                if (sigs) {
                                    for (var i = 0; i < sigs.length; i++) {
                                        var b = new Uint8Array(sigs[i].toByteArray());
                                        log('     → signatures[' + i + '] len=' + b.length +
                                            ' sha256=' + sha256(b));
                                    }
                                }
                            } catch (e2) { }
                            try {
                                var si = ret.signingInfo.value;
                                if (si) {
                                    log('     → signingInfo 存在，hasMultipleSigners=' +
                                        si.hasMultipleSigners());
                                    // ★ API 28+ 主路径
                                    ['getApkContentsSigners', 'getSigningCertificateHistory']
                                        .forEach(function (m) {
                                            try {
                                                var arr = si[m]();
                                                if (arr) for (var j = 0; j < arr.length; j++) {
                                                    var bb = new Uint8Array(arr[j].toByteArray());
                                                    log('     → signingInfo.' + m +
                                                        '[' + j + '] len=' + bb.length +
                                                        ' sha256=' + sha256(bb));
                                                }
                                            } catch (e3) { }
                                        });
                                } else {
                                    log('     → signingInfo = null');
                                }
                            } catch (e4) { }
                        }
                    } catch (e5) { }
                    return ret;
                };
            });
            log('[+] 已挂 ApplicationPackageManager.' + fn);
        } catch (e) { }
    });

    // A2. PackageManager 静态签名校验
    try {
        var PMgr = Java.use('android.app.ApplicationPackageManager');
        PMgr.checkSignatures.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                log('[PM] checkSignatures(' + Array.prototype.slice.call(arguments).join(', ') +
                    ') = ' + r);
                return r;
            };
        });
        log('[+] 已挂 checkSignatures');
    } catch (e) { }

    // A3. Signature 对象本身
    try {
        var Sig = Java.use('android.content.pm.Signature');
        Sig.toByteArray.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var b = new Uint8Array(r);
                    log('[SIG] Signature.toByteArray() len=' + b.length + ' sha256=' + sha256(b));
                } catch (e) { }
                return r;
            };
        });
        Sig.toCharsString.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                log('[SIG] Signature.toCharsString() = ' + String(r).substring(0, 80));
                return r;
            };
        });
        log('[+] 已挂 Signature');
    } catch (e) { }

    // A4. PackageInfo 的 signatures 字段直接读取没有 hook 点，改用 SigningInfo 类
    try {
        var SI = Java.use('android.content.pm.SigningInfo');
        ['getApkContentsSigners', 'getSigningCertificateHistory'].forEach(function (m) {
            try {
                SI[m].overloads.forEach(function (ov) {
                    ov.implementation = function () {
                        var r = ov.apply(this, arguments);
                        log('[SI] SigningInfo.' + m + '() 被调用');
                        return r;
                    };
                });
            } catch (e) { }
        });
        log('[+] 已挂 SigningInfo');
    } catch (e) { }

    // A5. 壳类
    ['com.netease.nis.wrapper.MyJni', 'com.netease.nis.wrapper.MyApplication',
        'com.netease.nis.wrapper.Utils', 'com.netease.nis.wrapper.Entry'].forEach(function (cn) {
            try {
                var C = Java.use(cn);
                C.class.getDeclaredMethods().forEach(function (m) {
                    var mn = m.getName();
                    if (mn.indexOf('$') === 0 || mn === '<init>' || mn === '<clinit>') return;
                    try {
                        C[mn].overloads.forEach(function (ov) {
                            ov.implementation = function () {
                                var a = Array.prototype.slice.call(arguments, 0, 3).join(', ');
                                log('[SHELL] ' + cn + '.' + mn + '(' + a + ')');
                                return ov.apply(this, arguments);
                            };
                        });
                    } catch (e) { }
                });
                log('[+] 已挂 ' + cn);
            } catch (e) {
                log('[-] ' + cn + ' 不可用（壳未解密）');
            }
        });

    // A6. System.exit —— 打印 Java 栈
    try {
        var Sys = Java.use('java.lang.System');
        Sys.exit.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var code = arguments[0];
                var st = '';
                try {
                    var Th = Java.use('java.lang.Throwable').$new();
                    st = Th.getStackTrace().toString().split(',').slice(0, 12).join('\n      ');
                } catch (e) { }
                log('[EXIT] System.exit(' + code + ')\n      ' + st);
                return ov.apply(this, arguments);
            };
        });
        log('[+] 已挂 System.exit');
    } catch (e) { }
});

// ═══════════ C. native 层文件访问 ═══════════
(function () {
    function resolve(name) {
        var fns = [
            function () { return Module.findGlobalExportByName(name); },
            function () { return Module.findExportByName(null, name); },
            function () { return Process.getModuleByName('libc.so').findExportByName(name); }
        ];
        for (var i = 0; i < fns.length; i++) {
            try { var p = fns[i](); if (p && !p.isNull()) return p; } catch (e) { }
        }
        return null;
    }

    var FILES = [
        ['open', 'pointer'],
        ['openat', 'int'],
        ['fopen', 'pointer'],
        ['stat', 'pointer'],
        ['lstat', 'pointer'],
        ['readlink', 'pointer'],
        ['read', 'int']
    ];

    var RE = /apk|data\/app|huachenjie|\.dex|signature|META-INF/i;

    FILES.forEach(function (f) {
        var name = f[0], argi = f[1] === 'pointer' ? 0 : f[1];
        var addr = resolve(name);
        if (!addr) return;
        try {
            Interceptor.attach(addr, {
                onEnter: function (args) {
                    try {
                        var p = (argi === 0) ? args[0] : args[argi];
                        var s = p.readCString();
                        if (s && RE.test(s)) log('[NAT] ' + name + '("' + s + '")');
                    } catch (e) { }
                }
            });
        } catch (e) { }
    });
    log('[*] native 文件钩子已装');
})();

// ═══════════ F. libnesec.so 导出符号 ═══════════
setTimeout(function () {
    ['libnesec.so', 'libNetHTProtect.so', 'liby.so'].forEach(function (mn) {
        try {
            var m = Process.findModuleByName(mn);
            if (!m) { log('[-] ' + mn + ' 未加载'); return; }
            log('[MOD] ' + mn + ' base=' + m.base + ' size=' + m.size);
            var ex = m.enumerateExports();
            log('    导出 ' + ex.length + ' 项: ' +
                ex.slice(0, 40).map(function (e) { return e.name; }).join(', '));
        } catch (e) { }
    });
}, 1500);

log('[*] sig_route.js 装载完成');
