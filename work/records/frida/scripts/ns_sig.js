// ns_sig.js —— 定位 libnesec 里「读签名 → 比对」的那个函数
//
// 思路：壳是通过 JNI 调 Java 层的（早已证实：PackageManager.getPackageInfo(0x40)
//       → Signature.toByteArray()）。这次不替换返回值，而是**只在调用 toByteArray 时
//       抓 native 回溯**，直接得到发起调用的 libnesec 偏移。
// 目标产物：libnesec 里那个「读签名并判定」的函数入口，之后反汇编它找比对分支。

var CLS = null;
var IDS = {};     // methodID(字符串) -> 方法名
var LOG = [];
var MAXLOG = 60;

function flush() {
    if (LOG.length === 0) { return; }
    send({ t: 'log', msg: LOG.join('\n') });
    LOG = [];
}

function push(s) {
    if (LOG.length < MAXLOG) { LOG.push(s); }
}

function modOf(a) {
    try { return Process.findModuleByAddress(a); } catch (e) { return null; }
}

// FUZZY 回溯，只留 libnesec 的帧
function natTrace(ctx, max) {
    var out = [];
    var fr = null;
    try { fr = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { return out; }
    if (fr === null) { return out; }
    for (var i = 0; i < fr.length && out.length < (max || 6); i++) {
        var m = modOf(fr[i]);
        if (m === null) { continue; }
        if (m.name.indexOf('libnesec') >= 0) {
            out.push('N+0x' + fr[i].sub(m.base).toString(16));
        }
    }
    return out;
}

Java.perform(function () {
    CLS = Java.use('java.lang.Class');
    var P = Process.pointerSize;
    var table = Java.vm.getEnv().handle.readPointer();

    function slot(i) {
        return table.add(i * P).readPointer();
    }

    // ── ① 记录 GetMethodID / GetStaticMethodID 的 名字 ↔ methodID 映射 ──
    var WANT = {
        'toByteArray': 1, 'getSignature': 1, 'getPackageInfo': 1,
        'toCharsString': 1, 'hashCode': 1, 'getSignatures': 1,
        'getApkContentsSigners': 1, 'getSigningCertificateHistory': 1
    };

    [33, 113].forEach(function (idx) {
        try {
            Interceptor.attach(slot(idx), {
                onEnter: function (a) {
                    this.nm = null;
                    try { this.nm = a[2].readCString(); } catch (e) { }
                },
                onLeave: function (ret) {
                    if (this.nm !== null && WANT[this.nm] === 1) {
                        IDS[ret.toString()] = this.nm;
                        push('[id] ' + this.nm + ' = ' + ret);
                    }
                }
            });
        } catch (e) { push('[!] hook ' + idx + ' 失败: ' + e); }
    });

    // ── ② 调用这些方法时抓 native 回溯 ──
    [34, 35, 36].forEach(function (idx) {
        var NM = ['CallObjectMethod', 'CallObjectMethodV', 'CallObjectMethodA'][idx - 34];
        try {
            Interceptor.attach(slot(idx), {
                onEnter: function (a) {
                    var id = a[2].toString();
                    var nm = IDS[id];
                    if (nm === undefined) { return; }
                    var t = natTrace(this.context, 8);
                    push('★★★ ' + NM + '  ' + nm + '()  调用方链=' + t.join(' <- '));
                }
            });
        } catch (e) { push('[!] hook ' + idx + ' 失败: ' + e); }
    });

    push('[i] JNIEnv=' + Java.vm.getEnv().handle + ' table=' + table);
    flush();
});

// 进程随时可能自杀，定时 flush
var iv = setInterval(function () {
    flush();
}, 400);

Process.setExceptionHandler(function (d) {
    clearInterval(iv);
    flush();
    return false;
});
