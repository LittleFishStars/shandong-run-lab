// ns_fields.js —— 定位 `obj == null` 到底缺哪个对象
// 思路：native 一定是先 GetStaticFieldID/GetFieldID 找字段，再读出来拿到 null。
// 所以挂钩 JNI 表的 FindClass / GetMethodID / GetFieldID / GetStaticMethodID /
// GetStaticFieldID / GetObjectField / GetStaticObjectField，凡调用方在 libnesec.so 的
// 就把「名字 + 签名 + 返回值」打出来。返回 0 的那个字段就是元凶。

var IDX = {
    6: 'FindClass',
    33: 'GetMethodID',
    94: 'GetFieldID',
    95: 'GetObjectField',
    96: 'GetObjectField-96',
    113: 'GetStaticMethodID',
    144: 'GetStaticFieldID',
    145: 'GetStaticObjectField'
};

function cstr(p) {
    if (p.isNull()) { return '<null>'; }
    try { return p.readCString(); } catch (e) { return '<bad>'; }
}

function modOf(addr) {
    try {
        var m = Process.findModuleByAddress(addr);
        return m === null ? null : { name: m.name, base: m.base };
    } catch (e) { return null; }
}

// 取第一个落在 libnesec.so 里的调用帧
function nesecFrame(ctx) {
    var frames = null;
    try { frames = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { return null; }
    if (frames === null) { return null; }
    for (var i = 0; i < frames.length; i++) {
        var mm = modOf(frames[i]);
        if (mm === null) { continue; }
        if (mm.name.indexOf('libnesec') >= 0) {
            return { off: frames[i].sub(mm.base), depth: i };
        }
    }
    return null;
}

var installed = 0;
function install() {
    var envPtr = Java.vm.getEnv().handle;
    var table = envPtr.readPointer();
    Object.keys(IDX).forEach(function (k) {
        var idx = parseInt(k, 10);
        var name = IDX[k];
        var fn = table.add(idx * Process.pointerSize).readPointer();
        if (fn.isNull()) { return; }
        var isFieldGet = (idx === 95 || idx === 96 || idx === 145);
        var isIdLookup = (idx === 33 || idx === 94 || idx === 113 || idx === 144);
        var isClass = (idx === 6);
        Interceptor.attach(fn, {
            onEnter: function (args) {
                this.hit = false;
                var f = nesecFrame(this.context);
                if (f === null) { return; }
                this.hit = true;
                this.off = f.off;
                this.arg2 = args[2];
                this.arg3 = args[3];
            },
            onLeave: function (retval) {
                if (!this.hit) { return; }
                var tag = 'N+0x' + this.off.toString(16);
                if (isClass) {
                    send({ t: 'log', msg: tag + '  FindClass("' + cstr(this.arg2) + '")' });
                } else if (isIdLookup) {
                    send({ t: 'log', msg: tag + '  ' + name + '("' + cstr(this.arg2) +
                        '", "' + cstr(this.arg3) + '") = ' + retval });
                } else if (isFieldGet) {
                    var bad = retval.isNull() ? '  ★★★ 返回 NULL' : '';
                    send({ t: 'log', msg: tag + '  ' + name + '(obj=' + this.arg2 +
                        ') = ' + retval + bad });
                }
            }
        });
        installed++;
    });
    send({ t: 'log', msg: '字段/方法探针已装 ' + installed + ' 个，table=' + table });
}

Java.perform(function () {
    send({ t: 'log', msg: 'Java.perform 就绪' });
    install();
});
