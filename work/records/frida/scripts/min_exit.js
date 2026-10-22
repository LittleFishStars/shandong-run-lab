// min_exit.js —— 极简：只抓「谁调用了 System.exit」的完整 Java 栈
//
// 依据链：
//   · sig_route2：JNI 表 147/148/149（CallStaticVoidMethod/_V/_A）已成功挂钩，0 命中
//   · 但 System.exit(0) 与 Runtime.exit 都被调用
//   ⇒ 调用者是 **Java 代码**（在壳 DEX 里），不是 native
//   · sig_route3 因同时装了 229 个 JNI 钩子被反 Hook 打死，没来得及打印栈
//
// 本脚本只装 System.exit / Runtime.exit / Runtime.halt 三个 Java 钩子，
// 不装任何 native 钩子，最大限度降低暴露面。
// 打印【完整】栈（不裁剪），直接拿到调用者的类名与方法名。

'use strict';

var n = 0;
function log(m) { if (n++ > 200) return; send({ t: 'log', msg: String(m) }); }

Java.perform(function () {
    log('[+] Java.perform 进入');

    var trace = function () {
        try {
            var T = Java.use('java.lang.Throwable');
            var Log = Java.use('android.util.Log');
            return Log.getStackTraceString(T.$new());
        } catch (e) { return '(取栈失败: ' + e + ')'; }
    };

    ['java.lang.System', 'java.lang.Runtime'].forEach(function (cn) {
        var C = null;
        try { C = Java.use(cn); } catch (e) { log('[-] ' + cn + ' 不可用'); return; }
        ['exit', 'halt'].forEach(function (mn) {
            if (!C[mn]) return;
            try {
                C[mn].overloads.forEach(function (ov) {
                    ov.implementation = function () {
                        var a = Array.prototype.slice.call(arguments).join(', ');
                        log('\n★★★★★★ [' + cn + '.' + mn + '(' + a + ')] 完整 Java 栈：\n' + trace());
                        return ov.apply(this, arguments);
                    };
                });
                log('[+] 已挂 ' + cn + '.' + mn);
            } catch (e) { log('[-] 挂 ' + cn + '.' + mn + ' 失败'); }
        });
    });

    // 兜底：有些壳用 Process.killProcess / System.runFinalizers
    try {
        var P = Java.use('android.os.Process');
        ['killProcess', 'killProcessQuiet'].forEach(function (mn) {
            if (!P[mn]) return;
            P[mn].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    log('\n★★★ [android.os.Process.' + mn + '(' + arguments[0] + ')] 栈：\n' + trace());
                    return ov.apply(this, arguments);
                };
            });
        });
        log('[+] 已挂 Process.killProcess*');
    } catch (e) { }
});

log('[*] min_exit.js 装载完成');
