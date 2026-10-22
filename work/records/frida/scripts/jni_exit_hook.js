// jni_exit_hook.js —— 经 JNIEnv 函数表定位「native 调用 System.exit」的返回地址
//
// 原理：
//   Java 栈显示 java.lang.System.exit(Native Method)，说明是 libnesec.so 通过 JNI
//   的 CallStaticVoidMethod* 调进 Java 的。JNIEnv 是指向函数表的指针，
//   标准 JNI 表中 CallStaticVoidMethod=147 / CallStaticVoidMethodV=148 / CallStaticVoidMethodA=149。
//   libart.so 并不导出这些 C++ 符号（enumerateExports 0 命中），因此必须走函数表。
//
// 目标：拿到 ★libnesec.so+0x?????? —— 即 native 侧的调用点，随后反汇编并 patch。

'use strict';

var n = 0;
function log(m) { if (n++ > 400) return; send({ t: 'log', msg: String(m) }); }

var WANT = /libnesec|libNetHTProtect|liby\.so|libsecsdk|libjiagu|libDexHelper|libshell|libnesec-wrapper/i;

function stk(ctx, max) {
    var out = [];
    var bt = null;
    try { bt = Thread.backtrace(ctx, Backtracer.ACCURATE); } catch (e) { }
    if (!bt || !bt.length) { try { bt = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { } }
    if (!bt) return out;
    for (var i = 0; i < bt.length && out.length < (max || 10); i++) {
        var m = null;
        try { m = Process.findModuleByAddress(bt[i]); } catch (e) { }
        if (!m) continue;
        var s = m.name + '+0x' + bt[i].sub(m.base).toString(16);
        if (WANT.test(m.name)) s = '★' + s;
        out.push(s);
    }
    return out;
}

// ═══ JNI 函数表 hook ═══
Java.perform(function () {
    var envPtr = null;
    try { envPtr = Java.vm.getEnv().handle; } catch (e) { log('[-] getEnv 失败 ' + e); return; }
    log('[*] JNIEnv* = ' + envPtr);

    var table = null;
    try { table = envPtr.readPointer(); } catch (e) { log('[-] 读函数表失败'); return; }
    log('[*] 函数表 = ' + table);

    // 先 dump 表里几个已知项，校验索引推算是否正确
    var CHECKS = { 4: 'GetVersion', 6: 'FindClass', 113: 'GetStaticMethodID', 167: 'NewStringUTF', 215: 'RegisterNatives' };
    Object.keys(CHECKS).forEach(function (k) {
        try {
            var p = table.add(parseInt(k, 10) * Process.pointerSize).readPointer();
            var sym = null;
            try { sym = DebugSymbol.fromAddress(p); } catch (e) { }
            var mod = null;
            try { mod = Process.findModuleByAddress(p); } catch (e) { }
            log('  [' + k + '] ' + CHECKS[k] + ' → ' + p +
                (mod ? ' (' + mod.name + '+0x' + p.sub(mod.base).toString(16) + ')' : '') +
                (sym && sym.name ? '  sym=' + sym.name : ''));
        } catch (e) { }
    });

    // 挂钩 CallStaticVoidMethod / V / A
    [147, 148, 149].forEach(function (idx) {
        var p = null;
        try { p = table.add(idx * Process.pointerSize).readPointer(); } catch (e) { return; }
        if (!p || p.isNull()) { log('[-] 表项 ' + idx + ' 为空'); return; }
        try {
            Interceptor.attach(p, {
                onEnter: function () {
                    var fl = stk(this.context, 10);
                    if (!fl.length) return;
                    var hot = fl.some(function (s) { return s.charAt(0) === '★'; });
                    log('[JNI#' + idx + ']' + (hot ? ' ★命中' : '') + '\n      ' + fl.join('\n      '));
                }
            });
            log('[+] 已挂函数表项 ' + idx + ' @ ' + p);
        } catch (e) { log('[-] 挂 ' + idx + ' 失败 ' + e); }
    });
});

// ═══ 补充网：libart 导出里搜 StaticVoid，及 libc 退出族 ═══
(function () {
    try {
        var art = Process.findModuleByName('libart.so');
        if (art) {
            var hit = [];
            art.enumerateExports().forEach(function (e) {
                if (/StaticVoid/i.test(e.name)) hit.push(e.name);
            });
            log('[*] libart 含 StaticVoid 的导出 ' + hit.length + ' 个: ' + hit.slice(0, 6).join(', '));
        }
    } catch (e) { }

    ['exit', '_exit', '_Exit', 'abort', 'pthread_exit', 'raise'].forEach(function (nm) {
        var a = null;
        try { a = Module.findGlobalExportByName(nm); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName(nm); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function () { log('[LIBC] ' + nm + ' ← ' + stk(this.context, 8).join(' ← ')); }
            });
        } catch (e) { }
    });
})();

// ═══ 观察 MyJni.load 的进出（Frida 对 native 方法的 Java hook 有效）═══
Java.perform(function () {
    try {
        var M = Java.use('com.netease.nis.wrapper.MyJni');
        M.load.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[myjni.load] 进入');
                var r = ov.apply(this, arguments);
                log('[myjni.load] 返回（未被 exit 打断）');
                return r;
            };
        });
        log('[+] MyJni.load 已挂');
    } catch (e) { log('[-] MyJni.load 挂载失败'); }
});

log('[*] jni_exit_hook.js 装载完成');
