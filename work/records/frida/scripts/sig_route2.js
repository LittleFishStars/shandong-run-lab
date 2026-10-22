// sig_route2.js —— 钉死 System.exit(0) 的 native 调用点
//
// 已知：Java 层 Signature.toByteArray() 已被成功冒充为原版 779 字节证书，
//       壳仍然 System.exit(0)。⇒ 判定不在 PackageManager 这条路上。
//
// 两条取证线同时布：
//   A) JNIEnv 函数表 147/148/149（CallStaticVoidMethod/_V/_A）
//      —— 壳调 System.exit 必过这里，返回地址 = ★libnesec.so+偏移
//   B) libc 的 open/openat/fopen/write/rename —— 过滤 .cache / files / apk 路径，
//      记录调用者的模块+偏移（壳写校验缓存前的判定点就在附近）
// 另挂 System.exit 记录（不阻断，保持栈完整）。

'use strict';

var n = 0;
function log(m) { if (n++ > 600) return; send({ t: 'log', msg: String(m) }); }

var NATIVE_RE = /libnesec|libNetHTProtect|liby\.so|libsecsdk|libjiagu|liball_in_one|libDexHelper|libshell/i;
var PATH_RE = new RegExp('\\.cache|\\.rpcesredsopoiu|/files/|\\.apk|META-INF|\\.bin|huachenjie', 'i');

function caller(ctx, skipSelf) {
    var ra = null;
    try { ra = ctx.lr || ctx.pc; } catch (e) { }
    if (!ra) return '?';
    var m = null;
    try { m = Process.findModuleByAddress(ra); } catch (e) { }
    if (!m) return ra.toString();
    var s = m.name + '+0x' + ra.sub(m.base).toString(16);
    if (NATIVE_RE.test(m.name)) s = '★' + s;
    return s;
}

function bt(ctx, max) {
    var bt = null;
    try { bt = Thread.backtrace(ctx, Backtracer.ACCURATE); } catch (e) { }
    if (!bt || bt.length < 2) { try { bt = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { } }
    var out = [];
    if (bt) {
        for (var i = 0; i < bt.length && out.length < (max || 8); i++) {
            var m = null;
            try { m = Process.findModuleByAddress(bt[i]); } catch (e) { }
            if (!m) continue;
            var s = m.name + '+0x' + bt[i].sub(m.base).toString(16);
            if (NATIVE_RE.test(m.name)) s = '★' + s;
            out.push(s);
        }
    }
    return out;
}

// ═══ 线 B：libc 文件操作 ═══
(function () {
    var spec = {
        open: { p: 0, s: 1 }, openat: { p: 1, s: 2 },
        fopen: { p: 0, s: 1 }, rename: { p: 0, s: 1, s2: 1 },
        unlink: { p: 0, s: 1 }, write: { p: 0, s: -1 }
    };
    Object.keys(spec).forEach(function (nm) {
        var a = null;
        try { a = Module.findGlobalExportByName(nm); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName(nm); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function (args) {
                    var cfg = spec[nm];
                    var path = null;
                    try {
                        if (nm === 'write') {
                            var p = args[1];
                            if (!p || p.isNull()) return;
                            var buf = p.readByteArray(48);
                            var b = new Uint8Array(buf), t = '';
                            for (var i = 0; i < b.length; i++) t += (b[i] >= 32 && b[i] < 127) ? String.fromCharCode(b[i]) : '.';
                            if (PATH_RE.test(t)) log('[WRITE] ' + caller(this.context) + '  " ' + t.substring(0, 40) + '');
                            return;
                        }
                        path = args[cfg.p];
                        if (!path || path.isNull()) return;
                        var s = path.readUtf8String(200);
                        if (!s || !PATH_RE.test(s)) return;
                        log('[' + nm.toUpperCase() + '] ' + caller(this.context) + '  "' + s.substring(0, 90) + '"');
                    } catch (e) { }
                }
            });
        } catch (e) { }
    });
})();

// ═══ 线 A：JNIEnv 函数表 ═══
Java.perform(function () {
    log('[+] Java.perform 进入');

    var table = null;
    try {
        var envPtr = Java.vm.getEnv().handle;
        log('[*] JNIEnv* = ' + envPtr);
        table = envPtr.readPointer();
        log('[*] 函数表 = ' + table);
    } catch (e) { log('[-] 取 JNIEnv 失败 ' + e); }

    if (table) {
        // 校验索引推算（GetVersion 应为 0x10006 一族）
        [4, 6, 113, 147, 148, 149, 167, 215, 228].forEach(function (idx) {
            try {
                var p = table.add(idx * Process.pointerSize).readPointer();
                var m = Process.findModuleByAddress(p);
                log('  [tbl ' + idx + '] → ' + p + (m ? ' (' + m.name + '+0x' + p.sub(m.base).toString(16) + ')' : ''));
            } catch (e) { }
        });

        [147, 148, 149].forEach(function (idx) {
            var p = null;
            try { p = table.add(idx * Process.pointerSize).readPointer(); } catch (e) { return; }
            if (!p || p.isNull()) return;
            try {
                Interceptor.attach(p, {
                    onEnter: function () {
                        var c = caller(this.context);
                        var fl = bt(this.context, 8);
                        var hot = (c.charAt(0) === '★') || fl.some(function (s) { return s.charAt(0) === '★'; });
                        log('[JNI#' + idx + ']' + (hot ? ' ★★★命中' : '') + ' caller=' + c +
                            (fl.length ? '\n      栈: ' + fl.join('\n          ') : ''));
                    }
                });
                log('[+] 已挂 JNI 表项 ' + idx + ' @ ' + p);
            } catch (e) { log('[-] 挂 ' + idx + ' 失败 ' + e); }
        });
    }
});

// ═══ System.exit：记录 + 栈（不阻断） ═══
Java.perform(function () {
    try {
        Java.use('java.lang.System').exit.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[EXIT] System.exit(' + arguments[0] + ')');
                return ov.apply(this, arguments);
            };
        });
        log('[+] System.exit 已挂');
    } catch (e) { log('[-] exit 挂载失败 ' + e); }
});

// ═══ 观察可能的替代退出路径 ═══
Java.perform(function () {
    ['java.lang.Runtime', 'android.os.Process'].forEach(function (cn) {
        try {
            var C = Java.use(cn);
            if (C.exit) C.exit.overloads.forEach(function (ov) {
                ov.implementation = function () { log('[ALT] ' + cn + '.exit'); return ov.apply(this, arguments); };
            });
            if (C.halt) C.halt.overloads.forEach(function (ov) {
                ov.implementation = function () { log('[ALT] ' + cn + '.halt'); return ov.apply(this, arguments); };
            });
            if (C.killProcess) C.killProcess.overloads.forEach(function (ov) {
                ov.implementation = function () { log('[ALT] ' + cn + '.killProcess' + arguments[0]); return ov.apply(this, arguments); };
            });
        } catch (e) { }
    });
});

log('[*] sig_route2.js 装载完成');
