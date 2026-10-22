// ns_obj.js —— 定位无壳版里 `obj == null` 到底是对谁调方法
// 方法：读 JNIEnv 函数表，挂钩 34/35/36（CallObjectMethod / V / A），
// 只打印调用方落在 libnesec.so 的，并给出 libnesec 内的偏移。
// 附加：把 receiver 指针、methodID、以及调用前后是否有 null 一起打出来。

var CLS = null;
var V = null;

function modOf(addr) {
    try {
        var m = Process.findModuleByAddress(addr);
        if (m === null) { return null; }
        return { name: m.name, off: addr.sub(m.base), path: m.path };
    } catch (e) { return null; }
}

function callerOf(ctx) {
    var frames = null;
    try { frames = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { frames = null; }
    if (frames === null) { return '?'; }
    for (var i = 0; i < frames.length; i++) {
        var mm = modOf(frames[i]);
        if (mm === null) { continue; }
        if (mm.name.indexOf('libc') >= 0 || mm.name.indexOf('libart') >= 0 ||
            mm.name.indexOf('libbase') >= 0 || mm.name.indexOf('frida') >= 0) {
            continue;
        }
        return mm.name + '+0x' + mm.off.toString(16);
    }
    return '?';
}

function install() {
    var env = Java.vm.getEnv();
    var envPtr = env.handle;
    var table = envPtr.readPointer();
    var n = 0;
    [34, 35, 36].forEach(function (idx) {
        var fn = table.add(idx * Process.pointerSize).readPointer();
        if (fn.isNull()) { return; }
        Interceptor.attach(fn, {
            onEnter: function (args) {
                var obj = args[1];
                var owner = callerOf(this.context);
                if (owner.indexOf('libnesec') < 0) { return; }
                send({ t: 'log', msg: '[' + idx + '] ' + owner +
                    '  obj=' + obj + '  methodID=' + args[2] });
                n++;
            }
        });
    });
    send({ t: 'log', msg: 'CallObjectMethod 钩子已装，table=' + table });
}

Java.perform(function () {
    send({ t: 'log', msg: 'Java.perform 就绪' });
    install();
});
