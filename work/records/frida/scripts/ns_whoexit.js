// ns_whoexit.js —— 抓出到底是谁调的 System.exit（要 native 栈，不是 Java 栈）
// 之前只看到 Java 栈 `at java.lang.System.exit(Native Method)`，说明调用者是 native。
// 这次在 Java hook 里取 native backtrace，把 libnesec 里的调用点定位出来。

function modOf(addr) {
    try {
        var m = Process.findModuleByAddress(addr);
        return m === null ? null : { name: m.name, base: m.base };
    } catch (e) { return null; }
}

var SKIP = ['libc.so', 'libart.so', 'libbase.so', 'libc++.so', 'libandroid_runtime.so',
            'libopenjdk.so', 'frida', 'libnativehelper'];

function trace(ctx) {
    var frames = null;
    try { frames = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { return 'backtrace 失败'; }
    if (frames === null) { return 'backtrace null'; }
    var out = [];
    for (var i = 0; i < frames.length && out.length < 12; i++) {
        var mm = modOf(frames[i]);
        if (mm === null) { continue; }
        var skip = false;
        for (var j = 0; j < SKIP.length; j++) {
            if (mm.name.indexOf(SKIP[j]) >= 0) { skip = true; break; }
        }
        if (skip) { continue; }
        out.push(mm.name + '+0x' + frames[i].sub(mm.base).toString(16));
    }
    return out.length ? out.join(' < ') : '（全是系统帧）';
}

var done = false;

Java.perform(function () {
    send({ t: 'log', msg: 'ns_whoexit 就绪' });

    try {
        var Sys = Java.use('java.lang.System');
        Sys.exit.overload('int').implementation = function (code) {
            if (!done) {
                done = true;
                send({ t: 'log', msg: '★★ System.exit(' + code + ') 调用者 native 栈：\n    ' + trace(this.context) });
            }
            return this.exit(code);
        };
        send({ t: 'log', msg: 'System.exit 已挂钩' });
    } catch (e) { send({ t: 'log', msg: 'System.exit 挂钩失败: ' + e }); }

    try {
        var R = Java.use('java.lang.Runtime');
        R.exit.overload('int').implementation = function (code) {
            if (!done) {
                done = true;
                send({ t: 'log', msg: '★★ Runtime.exit(' + code + ') 调用者 native 栈：\n    ' + trace(this.context) });
            }
            return this.exit(code);
        };
        send({ t: 'log', msg: 'Runtime.exit 已挂钩' });
    } catch (e) { send({ t: 'log', msg: 'Runtime.exit 挂钩失败: ' + e }); }

    // libc 的 exit 家族（native 直接自杀也可能走这里）
    ['exit', '_exit', '_Exit', 'abort', 'pthread_exit'].forEach(function (n) {
        var p = null;
        try { p = Module.getGlobalExportByName(n); } catch (e) { p = null; }
        if (p === null) { return; }
        Interceptor.attach(p, {
            onEnter: function (args) {
                send({ t: 'log', msg: '★★ libc ' + n + '(' + args[0] + ') 调用者 native 栈：\n    ' + trace(this.context) });
            }
        });
        send({ t: 'log', msg: 'libc ' + n + ' 已挂钩' });
    });
});
