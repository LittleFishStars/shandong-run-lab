// shell_probe.js —— 壳到底注册了什么：挂钩 RegisterNatives + dump libnesec 运行时镜像
//
// 目的：回答「去掉壳要重写多少代码」
//   · 经 JNIEnv 函数表 #215 = RegisterNatives(env, clazz, methods, n)
//     捕获壳注册的每一个 native 方法：名字 / 签名 / 函数指针 / 所属模块
//     —— 这就是壳提供给 ShandongApplication 等类的方法清单
//   · 同时 dump libnesec.so 的运行时可读段（磁盘镜像已加密，只能取运行时）

'use strict';

var n = 0;
function log(m) { if (n++ > 700) return; send({ t: 'log', msg: String(m) }); }

var CLS = null;
var NATIVE_RE = /libnesec|libNetHTProtect|liby\.so|libsecsdk|libjiagu|liball_in_one/i;

function modOf(a) {
    try {
        var m = Process.findModuleByAddress(a);
        if (!m) return a.toString();
        var s = m.name + '+0x' + a.sub(m.base).toString(16);
        return NATIVE_RE.test(m.name) ? '★' + s : s;
    } catch (e) { return String(a); }
}

// ═══ dump libnesec 运行时镜像（只做一次）═══
var dumped = false;
function dumpNesec() {
    if (dumped) return;
    var m = null;
    try { m = Process.findModuleByName('libnesec.so'); } catch (e) { }
    if (!m || m.size < 50000) return;
    dumped = true;
    log('[*] libnesec.so base=' + m.base + ' size=' + m.size);
    log('[*] path=' + m.path);
    try {
        Process.enumerateRanges('r--').forEach(function (r) {
            if (r.base.compare(m.base) >= 0 && r.base.compare(m.base.add(m.size)) < 0) {
                try {
                    var d = r.base.readByteArray(r.size);
                    if (d) {
                        send({ t: 'newexec', name: 'nesec_rt_' + r.base.sub(m.base).toString(16) + '_' + r.size.toString(16), data: d }, d);
                        log('    [+] +0x' + r.base.sub(m.base).toString(16) + '  ' + r.size + ' B ' + r.protection);
                    }
                } catch (e) { }
            }
        });
    } catch (e) { log('[-] dump 异常 ' + e); }
}

// ═══ 主逻辑 ═══
Java.perform(function () {
    log('[+] Java.perform 进入');

    try { CLS = Java.use('java.lang.Class'); } catch (e) { }
    var envPtr = null, table = null;
    try {
        envPtr = Java.vm.getEnv().handle;
        table = envPtr.readPointer();
        log('[*] JNIEnv* = ' + envPtr + '  表 = ' + table);
    } catch (e) { log('[-] 取 JNIEnv 失败 ' + e); return; }

    // #215 RegisterNatives
    var p = null;
    try { p = table.add(215 * Process.pointerSize).readPointer(); } catch (e) { }
    if (!p || p.isNull()) { log('[-] 表项 215 为空'); return; }

    var regCount = 0;
    try {
        Interceptor.attach(p, {
            onEnter: function (args) {
                var clazz = args[1], methods = args[2], cnt = args[3].toInt32();
                var clsName = '?';
                try { clsName = Java.cast(clazz, CLS).getName(); } catch (e) { }
                regCount++;
                log('════ RegisterNatives #' + regCount + '  ' + clsName + '  n=' + cnt +
                    '  调用者=' + modOf(this.context.lr || this.context.pc));
                for (var i = 0; i < cnt && i < 96; i++) {
                    try {
                        var nmP = methods.add(i * 24).readPointer();
                        var sgP = methods.add(i * 24 + 8).readPointer();
                        var fp = methods.add(i * 24 + 16).readPointer();
                        var nm = nmP.isNull() ? '?' : nmP.readUtf8String();
                        var sg = sgP.isNull() ? '?' : sgP.readUtf8String();
                        log('   ' + nm + '  ' + (sg || '').substring(0, 60) + '  → ' + fp + '  (' + modOf(fp) + ')');
                    } catch (e) { log('   [读第 ' + i + ' 项失败]'); }
                }
                // ★ 同步 dump（native 回调里 setTimeout 不可靠）
                if (regCount === 1) { try { dumpNesec(); } catch (e) { } }
            }
        });
        log('[+] RegisterNatives 已挂 @ ' + p);
    } catch (e) { log('[-] 挂 215 失败 ' + e); }

    // 顺带把 #167 NewStringUTF 也盯一下，看壳是否在拼类名
    try {
        var p167 = table.add(167 * Process.pointerSize).readPointer();
        var cnt167 = 0;
        Interceptor.attach(p167, {
            onEnter: function (args) {
                if (cnt167++ > 30) return;
                var s = null;
                try { s = args[1].readUtf8String(120); } catch (e) { return; }
                if (!s || s.length < 4) return;
                if (!/huachenjie|shandong|splash|Application|netease|nis|MyJni|Entry/i.test(s)) return;
                log('[NewStringUTF] ' + s + '   ← ' + modOf(this.context.lr || this.context.pc));
            }
        });
        log('[+] NewStringUTF 已挂');
    } catch (e) { }

    // 兜底 dump（壳可能不用 RegisterNatives）
    setTimeout(dumpNesec, 4000);
    setTimeout(dumpNesec, 9000);
});

log('[*] shell_probe.js 装载完成');
