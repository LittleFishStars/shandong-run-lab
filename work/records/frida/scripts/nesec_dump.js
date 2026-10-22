// nesec_dump.js —— ① dump libnesec.so 解密后的完整运行时代码 ② 逐钩 MyJni 的 11 个 native 定位退出点
//
// 背景（shell_probe.js 实测）：
//   libnesec.so (易盾 NIS) 在 RegisterNatives(MyJni, 11) 里注册：
//     load   +0xa5adc      run  +0xa61ac     d +0xa6a7c      e +0xa6b10
//     cp     +0xa6b4c      ip   +0xa6b90     ra +0xa6e94     getEnvInfo +0x9f2bc
//     cl     +0xa7184      rp   +0xa721c     ed +0xa7870
//   磁盘镜像在这些偏移处是密文（熵 7.08）→ 只能取运行时。
//
// 本脚本：
//   A) 分块 dump libnesec 全部 r-x 段（128 KB/块）到设备无关的本地文件
//   B) 逐个 Interceptor.attach 这 11 个指针，维护「当前在哪个 native 里」的栈
//   C) System.exit 被调时打印最内层 native 名 → 一次定位到判定函数

'use strict';

var n = 0;
function log(m) { if (n++ > 400) return; send({ t: 'log', msg: String(m) }); }

var CHUNK = 128 * 1024;

// ═══ A) 分块 dump ═══
function dumpRange(base, mod, off, size, tag) {
    var done = 0;
    while (done < size) {
        var sz = Math.min(CHUNK, size - done);
        try {
            var d = base.add(done).readByteArray(sz);
            if (d) send({ t: 'newexec', name: tag + '_0x' + off.toString(16) + '_0x' + done.toString(16) + '.bin', data: d }, d);
        } catch (e) {
            log('[-] dump ' + tag + '+0x' + (off + done).toString(16) + ' 失败 ' + e);
        }
        done += sz;
    }
}

var dumped = false;
function dumpAll() {
    if (dumped) return;
    var m = null;
    try { m = Process.findModuleByName('libnesec.so'); } catch (e) { }
    if (!m) { log('[-] 找不到 libnesec.so'); return; }
    dumped = true;
    log('[*] libnesec.so base=' + m.base + ' size=' + m.size);

    Process.enumerateRanges('r--').forEach(function (r) {
        if (r.base.compare(m.base) < 0 || r.base.compare(m.base.add(m.size)) >= 0) return;
        var off = r.base.sub(m.base);
        var tag = 'nesec' + (r.protection.indexOf('x') >= 0 ? '_x' : '_r');
        log('[*] dump ' + tag + ' +0x' + off.toString(16) + '  ' + r.size + ' B  ' + r.protection);
        dumpRange(r.base, m, off, r.size, tag);
    });
    log('[*] dump 完毕');
}

// ═══ B/C) native 栈 + exit 定位 ═══
var liveStack = [];
var NAMES = {};

Java.perform(function () {
    log('[+] Java.perform 进入');

    var CLS = null;
    try { CLS = Java.use('java.lang.Class'); } catch (e) { }

    // System.exit：打印当前 native 栈
    try {
        Java.use('java.lang.System').exit.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('★★★ System.exit(' + arguments[0] + ') 时正在执行的 native 栈：\n      ' +
                    (liveStack.length ? liveStack.join('\n      ') : '(空 —— 退出不来自已钩的 native)'));
                return ov.apply(this, arguments);
            };
        });
        log('[+] System.exit 已挂');
    } catch (e) { }

    var regCount = 0;
    var envPtr = Java.vm.getEnv().handle;
    var table = envPtr.readPointer();
    var p215 = table.add(215 * Process.pointerSize).readPointer();

    Interceptor.attach(p215, {
        onEnter: function (args) {
            var clazz = args[1], methods = args[2], cnt = args[3].toInt32();
            regCount++;
            var clsName = '?';
            try { clsName = Java.cast(clazz, CLS).getName(); } catch (e) { }
            if (clsName.indexOf('MyJni') < 0) return;   // 只关心 MyJni

            log('════ MyJni 注册 ' + cnt + ' 个 native，逐个挂钩：');
            for (var i = 0; i < cnt; i++) {
                try {
                    var nm = methods.add(i * 24).readPointer().readUtf8String();
                    var fp = methods.add(i * 24 + 16).readPointer();
                    NAMES[fp.toString()] = nm;
                    (function (name, addr) {
                        try {
                            Interceptor.attach(addr, {
                                onEnter: function () { liveStack.push(name + ' (+0x' + addr.sub(Process.findModuleByName('libnesec.so').base).toString(16) + ')'); },
                                onLeave: function () { liveStack.pop(); }
                            });
                            log('   [✓] ' + name + ' @ ' + addr + ' 已钩');
                        } catch (e) { log('   [✗] ' + name + ' 挂钩失败 ' + e); }
                    })(nm, fp);
                } catch (e) { log('   [读第 ' + i + ' 项失败]'); }
            }
            // ★ 同步 dump（native 回调里 setTimeout 不可靠）
            try { dumpAll(); } catch (e) { log('[-] dump 异常 ' + e); }
        }
    });
    log('[+] RegisterNatives 已挂 @ ' + p215);
});

log('[*] nesec_dump.js 装载完成');
