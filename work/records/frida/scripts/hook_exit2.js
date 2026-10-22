// hook_exit2.js —— 全量阻断易盾 NIS 的签名校验退出，抓 native 调用栈
//
// v1 结论：com.netease.nis.wrapper.MyJni.load() 调 getPackageInfo(flags=64=GET_SIGNATURES)
//          取得当前 APK 签名，校验失败后经 JNI 调 System.exit(0)。
//          native hook（exit/_exit/abort/kill）全部未触发 ⇒ 走的是 JNI CallStaticVoidMethod。
// v2 目标：① 永久阻断所有退出路径，看应用能否续跑
//          ② 在 Java exit hook 内取当前线程 native 栈，定位真凶模块
//          ③ 观察阻断后 MyApplication 是否继续 attachBaseContext / onCreate

'use strict';

var exitCount = 0;
var MAX_LOG = 12;          // 栈只打前 12 次，避免刷屏

function log(m) { send({ t: 'log', msg: String(m) }); }

function jsStack() {
    try {
        var Log = Java.use('android.util.Log');
        var Th = Java.use('java.lang.Throwable');
        return Log.getStackTraceString(Th.$new()).split('\n').slice(0, 8).join('\n');
    } catch (e) { return '  <' + e + '>'; }
}

// Java hook 内取 native 栈：Thread.backtrace 会给出当前执行线程的 native 调用链
function natStack() {
    try {
        var bt = Thread.backtrace(null, Backtracer.FUZZY);
        return bt.slice(0, 10).map(function (a) {
            var s = DebugSymbol.fromAddress(a);
            var nm = s.name || '?';
            var mod = s.moduleName || '?';
            return '      ' + mod + '!' + nm + ' + ' + (a - (s.moduleBase || a));
        }).join('\n');
    } catch (e) { return '      <' + e + '>'; }
}

// 把地址所在模块报出来（用于判断是否 libnesec / libjiagu / libsecsdk）
function modsOf(addrs) {
    var out = [];
    addrs.forEach(function (a) {
        try {
            var m = Process.findModuleByAddress(a);
            if (m && out.indexOf(m.name) < 0) out.push(m.name + '@' + m.base);
        } catch (e) { }
    });
    return out.join(', ');
}

Java.perform(function () {
    log('[+] Java.perform 进入');

    function block(cls, m, label) {
        try {
            var C = Java.use(cls);
            C[m].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    exitCount++;
                    if (exitCount <= MAX_LOG) {
                        log('[!!] 阻断 ' + label + ' 参数=' + JSON.stringify(
                            Array.prototype.slice.call(arguments)) +
                            '  (第 ' + exitCount + ' 次)\n  Java 栈:\n' + jsStack() +
                            '\n  native 栈:\n' + natStack());
                    } else if (exitCount === MAX_LOG + 1) {
                        log('[..] 已达日志上限，后续静默阻断');
                    }
                    return;                 // 永不调用原实现
                };
            });
            log('[+] 已拦截 ' + label);
        } catch (e) { log('[-] ' + label + ': ' + e); }
    }

    block('java.lang.System', 'exit', 'System.exit');
    block('java.lang.Runtime', 'exit', 'Runtime.exit');
    block('java.lang.Runtime', 'halt', 'Runtime.halt');
    block('android.os.Process', 'killProcess', 'Process.killProcess');

    // ── 关键：易盾外壳取签名的入口，把返回的签名打印出来 ──
    try {
        var PM = Java.use('android.app.ApplicationPackageManager');
        PM.getPackageInfo.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var flags = arguments.length > 1 ? arguments[1] : 0;
                    if ((flags & 0x40) && r) {
                        var sigs = r.signatures.value;
                        var hx = '';
                        if (sigs && sigs.length > 0) {
                            var b = sigs[0].toByteArray();
                            hx = Array.prototype.map.call(new Uint8Array(b), function (x) {
                                return ('0' + (x & 0xff).toString(16)).slice(-2);
                            }).join('');
                        }
                        log('[SIG] 外壳取到签名 len=' + (hx.length / 2) +
                            '\n  sha256 需另算，DER 前 64 字节: ' + hx.substring(0, 128));
                    }
                } catch (e) { log('[SIG] 解析失败 ' + e); }
                return r;
            };
        });
    } catch (e) { log('[-] getPackageInfo: ' + e); }

    // ── 观察 MyApplication 生命周期是否继续 ──
    ['com.netease.nis.wrapper.MyApplication'].forEach(function (cn) {
        try {
            var A = Java.use(cn);
            ['attachBaseContext', 'onCreate'].forEach(function (mn) {
                try {
                    A[mn].overloads.forEach(function (ov) {
                        ov.implementation = function () {
                            log('[LIFE] ' + cn + '.' + mn + ' 进入');
                            var r = ov.apply(this, arguments);
                            log('[LIFE] ' + cn + '.' + mn + ' 返回');
                            return r;
                        };
                    });
                    log('[+] 已挂 ' + cn + '.' + mn);
                } catch (e) { }
            });
        } catch (e) { log('[-] ' + cn + ': ' + e); }
    });
});

// native 兜底
['exit', '_exit', 'abort', '_exit_group'].forEach(function (n) {
    var p = null;
    [function () { return Module.findGlobalExportByName(n); },
     function () { return Module.findExportByName(null, n); }].forEach(function (f) {
        try { if (!p) p = f(); } catch (e) { }
    });
    if (!p) return;
    try {
        Interceptor.attach(p, {
            onEnter: function () {
                log('[!!] native ' + n + '(' + this.context.x0 + ') @ ' +
                    Process.findModuleByAddress(this.returnAddress).name);
            }
        });
        log('[+] hooked native ' + n);
    } catch (e) { }
});

log('[*] hook_exit2.js 装载完成');
