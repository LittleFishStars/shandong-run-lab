// sig_read.js —— 轻量取证：定位 libnesec 读取 APK 签名块的位置 + dump 运行时镜像
//
// 背景：
//   · 重签名 APK 启动即 System.exit(0)，原始 APK 正常 ⇒ native 侧存在签名校验。
//   · Java 层 Signature.toByteArray() 冒充原版证书**无效** ⇒ 不依赖 PackageManager。
//   · libnesec.so 磁盘镜像里没有 "META-INF"/"RUNNING.RSA"/"signature" 字符串
//     ⇒ 极可能读的是 APK Signing Block（v2/v3），该结构无需字符串。
//
// 本脚本只装 ~10 个 libc 钩子（避免被反 Hook 发现），做两件事：
//   A) 记录 open/read/pread/lseek 中涉及 .apk 的调用，输出 ★调用者模块+偏移
//      并记录读取的**文件偏移**——若集中出现在文件尾部（Signing Block 在末尾），
//      即可确认是 v2/v3 校验。
//   B) 把 libnesec.so 的运行时可读段整段 dump 出来（磁盘是加密的，须 dump 运行时）。

'use strict';

var n = 0;
function log(m) { if (n++ > 500) return; send({ t: 'log', msg: String(m) }); }

var NATIVE_RE = /libnesec|libNetHTProtect|liby\.so|libsecsdk|libjiagu|liball_in_one|libDexHelper|libshell/i;

function modOf(addr) {
    var m = null;
    try { m = Process.findModuleByAddress(addr); } catch (e) { }
    if (!m) return addr.toString();
    var s = m.name + '+0x' + addr.sub(m.base).toString(16);
    return NATIVE_RE.test(m.name) ? '★' + s : s;
}
function ret(ctx) { return modOf(ctx.lr || ctx.pc); }

// fd → 路径映射（跟踪壳打开了哪个 apk）
var fdMap = {};

var APK_RE = /\.apk$/i;

(function () {
    var attached = 0;

    ['open', 'open64', 'fopen', 'fopen64'].forEach(function (nm) {
        var a = null;
        try { a = Module.findGlobalExportByName(nm); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName(nm); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function (args) {
                    var p = args[0];
                    if (!p || p.isNull()) return;
                    var s = null;
                    try { s = p.readUtf8String(200); } catch (e) { return; }
                    if (!s || !APK_RE.test(s)) return;
                    this.isApk = true;
                    this.path = s;
                    log('[OPEN ' + nm + '] ' + ret(this.context) + '  "' + s + '"');
                },
                onLeave: function (rv) {
                    if (!this.isApk) return;
                    try {
                        var fd = rv.toInt32();
                        if (fd >= 0) { fdMap[fd] = this.path; log('    → fd=' + fd); }
                    } catch (e) { }
                }
            });
            attached++;
        } catch (e) { }
    });

    // openat(path 在 args[1])
    (function () {
        var a = null;
        try { a = Module.findGlobalExportByName('openat'); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName('openat'); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function (args) {
                    var p = args[1];
                    if (!p || p.isNull()) return;
                    var s = null;
                    try { s = p.readUtf8String(200); } catch (e) { return; }
                    if (!s || !APK_RE.test(s)) return;
                    this.isApk = true; this.path = s;
                    log('[OPENAT] ' + ret(this.context) + '  "' + s + '"');
                },
                onLeave: function (rv) {
                    if (!this.isApk) return;
                    try { var fd = rv.toInt32(); if (fd >= 0) { fdMap[fd] = this.path; log('    → fd=' + fd); } } catch (e) { }
                }
            });
            attached++;
        } catch (e) { }
    })();

    // read(fd, buf, n) —— 只关心 apk fd，记录调用者 + 要求字节数
    (function () {
        var a = null;
        try { a = Module.findGlobalExportByName('read'); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName('read'); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function (args) {
                    var fd = args[0].toInt32();
                    if (!fdMap[fd]) return;
                    this.isApk = true;
                    log('[READ] ' + ret(this.context) + ' fd=' + fd + ' n=' + args[2].toInt32());
                },
                onLeave: function (rv) {
                    if (!this.isApk) return;
                    try { log('     → 实际 ' + rv.toInt32() + ' 字节'); } catch (e) { }
                }
            });
            attached++;
        } catch (e) { }
    })();

    // pread(fd, buf, n, off) —— 记录 offset，判定是否尾部 Signing Block
    (function () {
        var a = null;
        try { a = Module.findGlobalExportByName('pread'); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName('pread'); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function (args) {
                    var fd = args[0].toInt32();
                    if (!fdMap[fd]) return;
                    this.isApk = true;
                    this.off = args[3].toInt32();
                    log('[PREAD] ' + ret(this.context) + ' fd=' + fd + ' n=' + args[2].toInt32() + ' off=' + this.off);
                },
                onLeave: function (rv) {
                    if (!this.isApk) return;
                    try { log('     → 实际 ' + rv.toInt32() + ' 字节'); } catch (e) { }
                }
            });
            attached++;
        } catch (e) { }
    })();

    // lseek —— 观察定位到尾部
    (function () {
        var a = null;
        try { a = Module.findGlobalExportByName('lseek'); } catch (e) { }
        if (!a) { try { a = Process.getModuleByName('libc.so').findExportByName('lseek'); } catch (e) { } }
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter: function (args) {
                    var fd = args[0].toInt32();
                    if (!fdMap[fd]) return;
                    this.isApk = true;
                    log('[LSEEK] ' + ret(this.context) + ' fd=' + fd + ' off=' + args[1].toString() + ' whence=' + args[2].toInt32());
                }
            });
            attached++;
        } catch (e) { }
    })();

    log('[*] libc 轻量挂钩数 = ' + attached);
})();

// ═══ B) dump libnesec.so 运行时可读段 ═══
function dumpModule(name, tag) {
    try {
        var mod = Process.findModuleByName(name);
        if (!mod) { log('[-] 未找到模块 ' + name); return; }
        log('[*] ' + name + ' base=' + mod.base + ' size=' + mod.size + ' path=' + mod.path);
        var ranges = Process.enumerateRanges('r--').filter(function (r) {
            return r.base.compare(mod.base) >= 0 && r.base.compare(mod.base.add(mod.size)) < 0;
        });
        log('[*] ' + name + ' 可读段 ' + ranges.length + ' 个');
        ranges.forEach(function (r, i) {
            var off = r.base.sub(mod.base);
            try {
                var data = r.base.readByteArray(r.size);
                if (!data) { log('    [-][' + i + '] 读到空'); return; }
                send({ t: 'newexec', name: tag + '_' + off.toString(16) + '_' + r.size.toString(16), data: data },
                    data);
                log('    [+] ' + name + '+0x' + off.toString(16) + '  ' + r.size + ' B  (' + r.protection + ')');
            } catch (e) { log('    [-] 读 ' + off + ' 失败 ' + e); }
        });
    } catch (e) { log('[-] dump ' + name + ' 异常 ' + e); }
}

// 等壳把 libnesec 映射好再 dump（壳是自定义 loader，会自解密）
var dumped = false;
function tryDump() {
    if (dumped) return;
    try {
        var m = Process.findModuleByName('libnesec.so');
        if (m && m.size > 100000) { dumped = true; dumpModule('libnesec.so', 'nesec'); return; }
    } catch (e) { }
}

setTimeout(tryDump, 3000);
setTimeout(function () { dumpModule('libNetHTProtect.so', 'htprotect'); }, 5000);
setTimeout(tryDump, 8000);

log('[*] sig_read.js 装载完成');
