// ns_exit2.js —— 钩 CallStaticVoidMethod 系列（JNI 表 124/125/126）定位 System.exit
// 之前钩错了槽位：34/35/36 是「实例」方法系列，静态 void 方法在 124/125/126。
// 另一个坑：不读 System.exit 的 Java 栈（只有 Native Method 一帧），要 native 栈。

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
    for (var i = 0; i < frames.length && out.length < (max || 8); i++) {
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

function cstr(p) {
    if (p.isNull()) { return '<null>'; }
    try { return p.readCString(); } catch (e) { return '<bad>'; }
}

Java.perform(function () {
    var envPtr = Java.vm.getEnv().handle;
    var table = envPtr.readPointer();
    var names = {};

    function slot(i) { return table.add(i * Process.pointerSize).readPointer(); }

    // ① 记录 GetStaticMethodID 的名字 → 便于识别 methodID
    Interceptor.attach(slot(113), {
        onEnter: function (args) { this.nm = cstr(args[2]); this.sg = cstr(args[3]); },
        onLeave: function (rv) {
            if (this.nm === 'exit' || this.nm === 'halt') {
                names[rv.toString()] = this.nm + ' ' + this.sg;
                send({ t: 'log', msg: '注册 ' + this.nm + this.sg + ' → ' + rv });
            }
        }
    });

    // ② 静态 void 方法调用系列
    [124, 125, 126].forEach(function (idx) {
        Interceptor.attach(slot(idx), {
            onEnter: function (args) {
                var id = args[2];
                var key = id.toString();
                var tag = names[key];
                if (tag === undefined) { return; }
                send({ t: 'log', msg: '★★★ CallStaticVoidMethod[' + idx + '] ' + tag +
                    '  调用者 native 栈：\n    ' + trace(this.context, 10) });
            }
        });
    });

    // ③ 兜底：Java 层
    try {
        Java.use('java.lang.System').exit.overload('int').implementation = function (c) {
            send({ t: 'log', msg: '（Java 层 System.exit(' + c + ')）' + trace(this.context, 6) });
            return this.exit(c);
        };
    } catch (e) { }

    send({ t: 'log', msg: 'ns_exit2 探针已装，table=' + table });
});
