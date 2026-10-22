// ns_trace_shell.js —— 用真壳 DEX 后跟踪壳自身的启动进度
// 目的：真壳版进程约 200ms 静默死亡（无 abort、无 System.exit），
// 先确认它到底走到哪一步：attachBaseContext → load → run → onCreate。

function modOf(addr) {
    try {
        var m = Process.findModuleByAddress(addr);
        return m === null ? null : { name: m.name, base: m.base };
    } catch (e) { return null; }
}

var SKIP = ['libc.so', 'libart.so', 'libbase.so', 'libc++.so', 'libandroid_runtime.so',
            'libopenjdk.so', 'frida', 'libnativehelper'];

function trace(ctx, max) {
    var frames = null;
    try { frames = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { return 'bt 失败'; }
    if (frames === null) { return 'bt null'; }
    var out = [];
    for (var i = 0; i < frames.length && out.length < (max || 6); i++) {
        var mm = modOf(frames[i]);
        if (mm === null) { continue; }
        var skip = false;
        for (var j = 0; j < SKIP.length; j++) {
            if (mm.name.indexOf(SKIP[j]) >= 0) { skip = true; break; }
        }
        if (skip) { continue; }
        out.push(mm.name.replace('libnesec.so', 'N') + '+0x' + frames[i].sub(mm.base).toString(16));
    }
    return out.length ? out.join(' < ') : '（全系统帧）';
}

var LOG = 'com.netease.nis.wrapper.MyApplication';
var JNI = 'com.netease.nis.wrapper.MyJni';
var APP = 'com.huachenjie.shandong_school.ShandongApplication';

var hooked = {};

function hookClass(name, methods) {
    if (hooked[name]) { return true; }
    var clz = null;
    try { clz = Java.use(name); } catch (e) { return false; }
    hooked[name] = true;
    send({ t: 'log', msg: '── ' + name + ' 已加载 ──' });
    methods.forEach(function (m) {
        try {
            var ms = clz[m];
            if (ms === undefined || ms === null) { return; }
            var n = ms.overloads.length;
            for (var i = 0; i < n; i++) {
                (function (ov, idx) {
                    ov.implementation = function () {
                        var a = [];
                        for (var k = 0; k < arguments.length; k++) { a.push('' + arguments[k]); }
                        send({ t: 'log', msg: name.split('.').pop() + '.' + m +
                            '(' + a.join(', ') + ')  进入  |  ' + trace(this.context, 4) });
                        var r = ov.apply(this, arguments);
                        send({ t: 'log', msg: name.split('.').pop() + '.' + m + ' 返回 ' + r });
                        return r;
                    };
                })(ms.overloads[i], i);
            }
        } catch (e) { }
    });
    return true;
}

function killProbes() {
    // 静默死亡最可能是 kill(pid, SIGKILL) 或 Process.killProcess
    try {
        var P = Java.use('android.os.Process');
        ['killProcess', 'sendSignal', 'killProcessQuiet'].forEach(function (n) {
            try {
                var ms = P[n];
                for (var i = 0; i < ms.overloads.length; i++) {
                    (function (ov) {
                        ov.implementation = function () {
                            var a = [];
                            for (var k = 0; k < arguments.length; k++) { a.push('' + arguments[k]); }
                            send({ t: 'log', msg: '★★★ Process.' + n + '(' + a.join(', ') +
                                ')  |  ' + trace(this.context, 8) });
                            return ov.apply(this, arguments);
                        };
                    })(ms.overloads[i]);
                }
            } catch (e) { }
        });
        send({ t: 'log', msg: 'Process 探针已装' });
    } catch (e) { send({ t: 'log', msg: 'Process 探针失败: ' + e }); }

    ['kill', 'tgkill', 'killpg', 'raise', 'pthread_kill', 'abort', 'exit', '_exit', 'syscall'].forEach(function (n) {
        var p = null;
        try { p = Module.getGlobalExportByName(n); } catch (e) { p = null; }
        if (p === null) { return; }
        Interceptor.attach(p, {
            onEnter: function (args) {
                if (n === 'syscall') {
                    var nr = args[0].toInt32();
                    // 94=exit_group 129=kill 131=tgkill 130=tkill
                    if (nr !== 94 && nr !== 129 && nr !== 131 && nr !== 130) { return; }
                }
                send({ t: 'log', msg: '★★★ libc ' + n + '(' + args[0] + ', ' + args[1] + ', ' +
                    args[2] + ')  |  ' + trace(this.context, 8) });
            }
        });
    });
    send({ t: 'log', msg: 'libc 自杀探针已装' });
}

Java.perform(function () {
    send({ t: 'log', msg: 'ns_trace_shell 就绪' });
    killProbes();

    // 反复尝试挂钩，直到类被加载或进程死亡
    var times = 0;
    var iv = setInterval(function () {
        times++;
        var a = hookClass(LOG, ['attachBaseContext', 'onCreate', 'a', 'getVersion']);
        var b = hookClass(JNI, ['load', 'run', 'cp', 'ip', 'ra', 'rp']);
        var c = hookClass(APP, ['attachBaseContext', 'onCreate']);
        if (times > 400 || (a && b && c)) {
            if (a && b && c) { send({ t: 'log', msg: '三类都已挂钩，停止轮询' }); }
            clearInterval(iv);
        }
    }, 20);
});
