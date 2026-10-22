// detect_env.js —— 抓出易盾 NIS 到底在检测什么环境特征导致 System.exit(0)
//
// ★ 决定性对照实验结论：原始未修改的 APK 也在同一位置 System.exit(0)，
//    ⇒ 退出与签名无关，是环境检测（root / Magisk / LSPosed / Frida / VM）。
// 本脚本 hook 所有文件访问与进程执行入口，过滤出可疑路径。

'use strict';

var MAX = 400;
var n = 0;

function log(m) { send({ t: 'log', msg: String(m) }); }

// 可疑关键词
var SUS = /su$|\/su\b|magisk|kernelsu|apatch|lsposed|xposed|substrate|frida|gdbserver|busybox|shamiko|riru|zygisk|\/data\/adb|\/sbin\/|superuser|Supersu|xbin|daemonsu|phhusson|lineage|cm_|custom|qemu|goldfish|ranchu|genymotion|bluestacks|nox|vbox|\/dev\/socket\/|magiskd|denylist|isolated|treble|debuggable|test-keys/i;

function susp(s) {
    if (typeof s !== 'string') return false;
    try { return SUS.test(s); } catch (e) { return false; }
}

// ────────── libc 文件/进程相关函数 ──────────
var TARGETS = [
    ['open',        ['pointer', 'int'],          0],
    ['openat',      ['int', 'pointer', 'int'],   1],
    ['fopen',       ['pointer', 'pointer'],      0],
    ['access',      ['pointer', 'int'],          0],
    ['faccessat',   ['int', 'pointer', 'int', 'int'], 1],
    ['stat',        ['pointer', 'pointer'],      0],
    ['lstat',       ['pointer', 'pointer'],      0],
    ['stat64',      ['pointer', 'pointer'],      0],
    ['__xstat',     ['int', 'pointer', 'pointer'], 1],
    ['__lxstat',    ['int', 'pointer', 'pointer'], 1],
    ['opendir',     ['pointer'],                 0],
    ['readlink',    ['pointer', 'pointer', 'size_t'], 0],
    ['execve',      ['pointer', 'pointer', 'pointer'], 0],
    ['system',      ['pointer'],                 0],
    ['popen',       ['pointer', 'pointer'],      0],
    ['kill',        ['int', 'int'],              1],
    ['__system_property_get', ['pointer', 'pointer'], 0]
];

function readStr(p) {
    if (!p || p.isNull()) return '';
    try { return p.readCString() || ''; } catch (e) { return ''; }
}

function hookOne(name, argIdx) {
    var p = null;
    [function () { return Module.findGlobalExportByName(name); },
     function () { return Module.findExportByName(null, name); },
     function () { return Process.findModuleByName('libc.so').findExportByName(name); }]
        .forEach(function (f) { try { if (!p) p = f(); } catch (e) { } });
    if (!p) return false;

    try {
        Interceptor.attach(p, {
            onEnter: function (args) {
                var s = readStr(args[argIdx]);
                if (!s || !susp(s)) return;
                if (n++ > MAX) return;
                var caller = this.returnAddress;
                var m = Process.findModuleByAddress(caller);
                log('[ENV] ' + name + '("' + s + '")  ← ' +
                    (m ? m.name + '+' + (caller - m.base) : caller));
            }
        });
        return true;
    } catch (e) { return false; }
}

var hooked = [];
TARGETS.forEach(function (t) { if (hookOne(t[0], t[2])) hooked.push(t[0]); });
log('[+] libc 已挂: ' + hooked.join(', '));

// ────────── Java 层文件检测 ──────────
Java.perform(function () {
    log('[+] Java.perform 进入');

    try {
        var F = Java.use('java.io.File');
        F.exists.implementation = function () {
            var r = F.exists.call(this);
            try {
                var p = this.getAbsolutePath();
                if (r && susp(p)) log('[JENV] File.exists("' + p + '") = true');
            } catch (e) { }
            return r;
        };
        log('[+] 已挂 File.exists');
    } catch (e) { log('[-] File.exists: ' + e); }

    try {
        var F2 = Java.use('java.io.File');
        ['canRead', 'isFile', 'isDirectory'].forEach(function (mn) {
            try {
                F2[mn].implementation = function () {
                    var r = F2[mn].call(this);
                    try {
                        var p = this.getAbsolutePath();
                        if (r && susp(p)) log('[JENV] File.' + mn + '("' + p + '") = true');
                    } catch (e) { }
                    return r;
                };
            } catch (e) { }
        });
        log('[+] 已挂 File.canRead/isFile/isDirectory');
    } catch (e) { }

    // Runtime.exec / ProcessBuilder
    try {
        var RT = Java.use('java.lang.Runtime');
        RT.exec.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var a = Array.prototype.slice.call(arguments).map(String).join(' ');
                log('[JENV] Runtime.exec: ' + a);
                return ov.apply(this, arguments);
            };
        });
        log('[+] 已挂 Runtime.exec');
    } catch (e) { log('[-] Runtime.exec: ' + e); }

    try {
        var PB = Java.use('java.lang.ProcessBuilder');
        PB.start.implementation = function () {
            try {
                log('[JENV] ProcessBuilder: ' + this.command().toString());
            } catch (e) { }
            return PB.start.call(this);
        };
        log('[+] 已挂 ProcessBuilder.start');
    } catch (e) { }

    // 系统属性（易盾常读 ro.build.tags / ro.debuggable）
    try {
        var SP = Java.use('java.lang.System');
        var PROPS = ['ro.build.tags', 'ro.debuggable', 'ro.secure', 'ro.build.type',
                     'ro.product.model', 'ro.hardware', 'ro.kernel.qemu'];
        SP.getProperty.overloads.forEach(function (ov) {
            ov.implementation = function (k) {
                var v = ov.apply(this, arguments);
                if (PROPS.indexOf(String(k)) >= 0) {
                    log('[JENV] System.getProperty("' + k + '") = ' + v);
                }
                return v;
            };
        });
        log('[+] 已挂 System.getProperty');
    } catch (e) { }
});

// ────────── 退出钩子：只记录，便于确认触发时刻 ──────────
Java.perform(function () {
    ['java.lang.System', 'java.lang.Runtime'].forEach(function (cn) {
        try {
            var C = Java.use(cn);
            C['exit'].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    log('[EXIT] ' + cn + '.exit 被调 —— 记录后阻断');
                    return;
                };
            });
        } catch (e) { }
    });
    try {
        Java.use('java.lang.Runtime')['halt'].overloads.forEach(function (ov) {
            ov.implementation = function () { log('[EXIT] Runtime.halt 被调'); return; };
        });
    } catch (e) { }
});

log('[*] detect_env.js 装载完成');
