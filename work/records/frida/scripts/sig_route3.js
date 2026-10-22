// sig_route3.js —— 用 Java 栈定位「谁调用了 System.exit」
//
// 上一步 sig_route2 结论：JNI 表项 147/148/149 已成功挂钩却 0 命中，
// 但 System.exit(0) 与 Runtime.exit 都被调用 ⇒ 调用者是 **Java 代码**，
// 很可能是 shell DEX 里那 30 个乱码类名之一（Ag==/CCLLLLLC/CD/...），
// 不在 MyJni/MyApplication/Utils/Entry 这四个壳类里。
//
// 本次三线取证：
//   A) 在 exit / halt / killProcess / Shutdown.exit 处抓 **完整 Java 栈**
//      —— 直接给出调用者的类名+方法名+行号
//   B) 全 JNI 函数表泛挂（索引 1..232），只打印栈里含 ★native 模块的调用
//      —— 覆盖壳可能使用的任意 JNI 入口
//   C) libc 挂钩自检（打印实际挂上几个），排除静默失败

'use strict';

var n = 0;
function log(m) { if (n++ > 800) return; send({ t: 'log', msg: String(m) }); }

var NATIVE_RE = /libnesec|libNetHTProtect|liby\.so|libsecsdk|libjiagu|liball_in_one|libDexHelper|libshell/i;

function modOf(addr) {
    var m = null;
    try { m = Process.findModuleByAddress(addr); } catch (e) { }
    if (!m) return addr.toString();
    var s = m.name + '+0x' + addr.sub(m.base).toString(16);
    return NATIVE_RE.test(m.name) ? '★' + s : s;
}

function bt(ctx, max) {
    var bt = null;
    try { bt = Thread.backtrace(ctx, Backtracer.ACCURATE); } catch (e) { }
    if (!bt || bt.length < 2) { try { bt = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { } }
    var out = [];
    if (bt) for (var i = 0; i < bt.length && out.length < (max || 8); i++) {
        var m = null;
        try { m = Process.findModuleByAddress(bt[i]); } catch (e) { }
        if (!m) continue;
        out.push(modOf(bt[i]));
    }
    return out;
}

// ═══ C) libc 挂钩自检 ═══
var attached = 0, libcLog = 0;
(function () {
    ['open', 'openat', 'fopen', 'fopen64', 'access', 'faccessat', 'stat', 'stat64', 'lstat', 'lstat64',
        'write', 'rename', 'unlink', 'mkdir', 'readlink'].forEach(function (nm) {
            var a = null;
            try { a = Module.findGlobalExportByName(nm); } catch (e) { }
            if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName(nm); } catch (e) { } }
            if (!a) return;
            try {
                Interceptor.attach(a, {
                    onEnter: function (args) {
                        if (libcLog++ > 40) return;
                        var p = (nm === 'openat' || nm === 'faccessat') ? args[1] : args[0];
                        if (!p || p.isNull()) return;
                        var s = null;
                        try { s = p.readUtf8String(160); } catch (e) { return; }
                        if (!s || s.length < 3) return;
                        if (!/\.cache|\.rpcesred|huachenjie|base\.apk|\.bin|magisk|frida/i.test(s)) return;
                        log('[LIBC ' + nm + '] ' + modOf(this.context.lr || this.context.pc) + '  "' + s.substring(0, 80) + '"');
                    }
                });
                attached++;
            } catch (e) { }
        });
    log('[*] libc 挂钩数 = ' + attached);
})();

// ═══ A) Java 栈：谁调用了 exit ═══
var TARGETS = [
    ['java.lang.System', 'exit', true],
    ['java.lang.Runtime', 'exit', true],
    ['java.lang.Runtime', 'halt', true],
    ['android.os.Process', 'killProcess', true],
    ['java.lang.Shutdown', 'exit', false],
    ['java.lang.Shutdown', 'shutdown', false],
    ['android.os.Process', 'killProcessQuiet', false]
];

Java.perform(function () {
    log('[+] Java.perform 进入');

    TARGETS.forEach(function (t) {
        try {
            var C = Java.use(t[0]);
            if (!C[t[1]]) return;
            C[t[1]].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    var args = Array.prototype.slice.call(arguments).join(', ');
                    var trace = '';
                    try {
                        var Log = Java.use('android.util.Log');
                        var T = Java.use('java.lang.Throwable');
                        trace = Log.getStackTraceString(T.$new());
                    } catch (e) { trace = '(取栈失败 ' + e + ')'; }
                    // 只保留应用/壳相关帧
                    var keep = String(trace).split('\n').filter(function (L) {
                        return /huachenjie|netease|nis|wrapper|reflection|Method\.invoke|NativeCalls|InstrumentationProxy/i.test(L) ||
                            /System\.exit|Runtime\.exit|Shutdown/.test(L);
                    }).slice(0, 14).join('\n        ');
                    log('★★★ [' + t[0] + '.' + t[1] + '(' + args + ')] 被调用\n      Java 栈:\n        ' + keep);
                    // 仍然放行（先看清楚，不阻断）
                    return ov.apply(this, arguments);
                };
            });
            log('[+] 已挂 ' + t[0] + '.' + t[1]);
        } catch (e) { log('[-] 挂 ' + t[0] + '.' + t[1] + ' 失败'); }
    });

    // ═══ B) 全 JNI 表泛挂 ═══
    try {
        var all = Java.use('java.lang.System');
    } catch (e) { }

    try {
        var envPtr = Java.vm.getEnv().handle;
        var table = envPtr.readPointer();
        log('[*] JNIEnv* = ' + envPtr + '  表 = ' + table);
        var hits = 0;
        for (var idx = 1; idx <= 232; idx++) {
            var p = null;
            try { p = table.add(idx * Process.pointerSize).readPointer(); } catch (e) { continue; }
            if (!p || p.isNull()) continue;
            var pm = null;
            try { pm = Process.findModuleByAddress(p); } catch (e) { }
            if (!pm || pm.name.indexOf('libart') < 0) continue;   // 只挂 libart 的 JNI 实现
            (function (i, addr) {
                try {
                    Interceptor.attach(addr, {
                        onEnter: function () {
                            var c = modOf(this.context.lr || this.context.pc);
                            if (c.charAt(0) !== '★') return;
                            log('[JNI#' + i + '] ★★★ 调用者 = ' + c + '\n      栈: ' + bt(this.context, 6).join(' ← '));
                        }
                    });
                    hits++;
                } catch (e) { }
            })(idx, p);
        }
        log('[*] JNI 全表挂钩数 = ' + hits);
    } catch (e) { log('[-] JNI 泛挂失败 ' + e); }
});

log('[*] sig_route3.js 装载完成');
