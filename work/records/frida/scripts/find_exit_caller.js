// find_exit_caller.js —— 在 native 层定位「调用 System.exit 的那条指令」
//
// 背景：
//   MyJni.load(MyApplication, pkg) 是 native 方法（libnesec.so）
//   它内部依次：stat/open base.apk → getPackageInfo(0x40) → Signature.toByteArray()
//              → 写 .cache/.rpcesredsopoiu.bin → JNI CallStaticVoidMethod(System.exit, 0)
//   Java 层 hook System.exit 时 Thread.backtrace(FUZZY) 取不到 native 帧，这里改 ACCURATE，
//   并从多个角度同时抓栈，找出 libnesec.so 内的返回地址。
//
// 输出目标：libnesec.so+0x?????? —— 下一步直接反汇编该处并 patch 分支。

'use strict';

var n = 0;
function log(m) { if (n++ > 500) return; send({ t: 'log', msg: String(m) }); }

var WANT = /libnesec|libNetHTProtect|liby\.so|libsecsdk|libjiagu|libnesec-wrapper|libDexHelper|libshell/i;

function frameList(ctx, max) {
    var out = [];
    var bt = null;
    try { bt = Thread.backtrace(ctx, Backtracer.ACCURATE); } catch (e) { }
    if (!bt || bt.length === 0) {
        try { bt = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { }
    }
    if (!bt) return out;
    for (var i = 0; i < bt.length && out.length < (max || 8); i++) {
        var m = null;
        try { m = Process.findModuleByAddress(bt[i]); } catch (e) { }
        if (!m) continue;
        var off = bt[i].sub(m.base);
        var s = m.name + '+0x' + off.toString(16);
        if (WANT.test(m.name)) s = '★' + s;
        out.push(s);
    }
    return out;
}

// ═══ 1. libart 内所有 JNI 静态调用入口（按 mangled 名精确找）═══
(function () {
    var art = null;
    try { art = Process.findModuleByName('libart.so'); } catch (e) { }
    if (!art) { log('[-] libart.so 未加载'); return; }
    log('[*] libart.so base=' + art.base + ' size=' + art.size);

    var NAMES = [
        'CallStaticVoidMethod',
        'CallStaticVoidMethodV',
        'CallStaticVoidMethodA',
        'CallStaticObjectMethod',
        'CallStaticObjectMethodV',
        'CallStaticIntMethod',
        'CallStaticBooleanMethod'
    ];
    // libart 导出的是 C++ mangled 名：_ZN3art3JNI22CallStaticVoidMethodEP7_JNIEnvP7_jclassP10_jmethodIDz
    var ex = art.enumerateExports();
    var hits = 0;
    ex.forEach(function (e) {
        for (var i = 0; i < NAMES.length; i++) {
            if (e.name.indexOf(NAMES[i]) >= 0) {
                try {
                    Interceptor.attach(e.address, {
                        onEnter: function () {
                            var fl = frameList(this.context, 8);
                            if (!fl.length) return;
                            var hasNative = fl.some(function (s) { return s.charAt(0) === '★'; });
                            if (hasNative) log('[JNI] ' + e.name + '\n      ' + fl.join('\n      '));
                        }
                    });
                    hits++;
                } catch (err) { }
                break;
            }
        }
    });
    log('[*] libart JNI 调用点已挂: ' + hits);
})();

// ═══ 2. libc 的 exit 家族（兜底，之前判定不走这里）═══
(function () {
    ['exit', '_exit', 'abort'].forEach(function (nm) {
        var a = null;
        try { a = Module.findGlobalExportByName(nm); } catch (e) { }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function () {
                    var fl = frameList(this.context, 8);
                    log('[LIBC] ' + nm + ' ← ' + fl.join(' ← '));
                }
            });
        } catch (e) { }
    });
})();

// ═══ 3. libnesec.so 加载时打印基址，并挂 JNI_OnLoad 返回后的时机 ═══
var nesecBase = null;
function waitNesec() {
    try {
        var m = Process.findModuleByName('libnesec.so');
        if (m && (!nesecBase || !nesecBase.equals(m.base))) {
            nesecBase = m.base;
            log('[MOD] libnesec.so base=' + m.base + ' size=' + m.size);
        }
    } catch (e) { }
}

// ═══ 4. Java 层：System.exit 处用 ACCURATE 取 native 栈 ═══
Java.perform(function () {
    waitNesec();
    try {
        var Sys = Java.use('java.lang.System');
        Sys.exit.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[EXIT-JAVA] System.exit(' + arguments[0] + ')');
                var fl = frameList(null, 12);
                log('      ' + fl.join('\n      '));
                return ov.apply(this, arguments);
            };
        });
        log('[+] System.exit 已挂');
    } catch (e) { log('[-] System.exit 挂载失败 ' + e); }

    // getPackageInfo 是 native 调进 Java 的最近点，这里也抓一次栈
    try {
        var PM = Java.use('android.app.ApplicationPackageManager');
        PM.getPackageInfo.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var flags = 0;
                try { flags = arguments[1]; } catch (e) { }
                if ((flags & 0x40) !== 0) {
                    log('[PKGINFO] flags=0x' + (flags >>> 0).toString(16));
                    var fl = frameList(null, 14);
                    log('      ' + fl.join('\n      '));
                }
                return ov.apply(this, arguments);
            };
        });
        log('[+] getPackageInfo 已挂');
    } catch (e) { }
});

log('[*] find_exit_caller.js 装载完成');
