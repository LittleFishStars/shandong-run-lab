// hook_exit.js —— 阻断重签名 APK 的主动退出，抓出签名校验调用栈
//
// 现象：原版 APK 用调试密钥重签名后，应用初始化走到 SplashActivity 渲染，
//       随后 native 线程调用 System.exit(0) 主动退出（非崩溃）。
// 目的：① 拦截退出让应用续命，观察后续行为
//       ② 抓 Java/native 双栈，定位签名校验的调用者
//       ③ 顺带 hook 签名查询 API，判断校验在 Java 层还是 native 层

'use strict';

var EXIT_BUDGET = 20;     // 最多拦截 20 次退出，防止死循环
var exitCount = 0;

function log(m) { send({ t: 'log', msg: String(m) }); }

function javaStack() {
    try {
        var Log = Java.use('android.util.Log');
        var Th = Java.use('java.lang.Throwable');
        return Log.getStackTraceString(Th.$new());
    } catch (e) { return '  <' + e + '>'; }
}

function nativeStack(ctx) {
    try {
        return Thread.backtrace(ctx, Backtracer.ACCURATE)
            .slice(0, 14)
            .map(function (a) { return '    ' + DebugSymbol.fromAddress(a); })
            .join('\n');
    } catch (e) { return '    <' + e + '>'; }
}

function findExp(name) {
    var tries = [
        function () { return Module.findGlobalExportByName(name); },
        function () { return Module.findExportByName(null, name); },
        function () { return Process.getModuleByName('libc.so').findExportByName(name); },
        function () { return Process.findModuleByName('libc.so').getExportByName(name); }
    ];
    for (var i = 0; i < tries.length; i++) {
        try { var r = tries[i](); if (r) return r; } catch (e) { }
    }
    return null;
}

// ─────────── Java 层 ───────────
Java.perform(function () {
    log('[+] Java.perform 进入');

    function hookExit(cls, m, label) {
        try {
            var C = Java.use(cls);
            C[m].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    if (exitCount < EXIT_BUDGET) {
                        exitCount++;
                        log('[!!] ' + label + ' 参数=' + JSON.stringify(
                            Array.prototype.slice.call(arguments)) +
                            '  (第 ' + exitCount + ' 次，已阻断)\n' + javaStack());
                        return;                      // 不调用原实现 → 阻止退出
                    }
                    log('[..] ' + label + ' 超出预算，放行');
                    return ov.apply(this, arguments);
                };
            });
            log('[+] hooked ' + label);
        } catch (e) { log('[-] ' + label + ': ' + e); }
    }

    hookExit('java.lang.System', 'exit', 'System.exit');
    hookExit('java.lang.Runtime', 'exit', 'Runtime.exit');
    hookExit('java.lang.Runtime', 'halt', 'Runtime.halt');
    hookExit('android.os.Process', 'killProcess', 'Process.killProcess');

    // ── 签名查询 API：判断 Java 层有没有做签名校验 ──
    try {
        var PM = Java.use('android.app.ApplicationPackageManager');
        PM.getPackageInfo.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var flags = arguments.length > 1 ? arguments[1] : 0;
                    if (flags & 0x40) {          // GET_SIGNATURES
                        log('[SIG] getPackageInfo(flags=' + flags + ') 请求签名\n' + javaStack());
                    }
                } catch (e) { }
                return r;
            };
        });
        log('[+] hooked ApplicationPackageManager.getPackageInfo');
    } catch (e) { log('[-] getPackageInfo: ' + e); }

    try {
        var Sig = Java.use('android.content.pm.Signature');
        Sig.$init.overload('[B').implementation = function (b) {
            var hex = b ? Array.prototype.map.call(
                new Uint8Array(Java.array('byte', b)),
                function (x) { return ('0' + (x & 0xff).toString(16)).slice(-2); }
            ).join('') : '';
            log('[SIG] new Signature(len=' + (b ? b.length : 0) + ')\n  ' +
                hex.substring(0, 160) + '\n' + javaStack());
            return this.$init(b);
        };
        log('[+] hooked Signature.<init>');
    } catch (e) { log('[-] Signature: ' + e); }
});

// ─────────── native 层 ───────────
['exit', '_exit', 'abort', 'kill', 'pthread_kill'].forEach(function (n) {
    var p = findExp(n);
    if (!p) { log('[-] native ' + n + ' 未找到'); return; }
    try {
        Interceptor.attach(p, {
            onEnter: function (args) {
                log('[!!] native ' + n + '(' + args[0] + ')\n' +
                    nativeStack(this.context));
            }
        });
        log('[+] hooked native ' + n + ' @ ' + p);
    } catch (e) { log('[-] native ' + n + ': ' + e); }
});

log('[*] hook_exit.js 装载完成');
