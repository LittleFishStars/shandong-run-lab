// ns_trace.js —— 抓「谁在调用 libnesec 的自毁桩」
// 背景：把 exit_group(94)/kill(129)/reboot(207) 三个内联 svc 桩改成 ret 后，
//       进程不再静默退出，而是继续跑进清理路径撞上 Invalid free。
//       ⇒ 说明还有「别的检测」在调自毁桩，我们只堵了杀招、没改条件。
// 本脚本：等 libnesec 加载后，对三个桩的**函数入口**下 Interceptor，
//         打印调用方（FUZZY 回溯里落在 libnesec 的帧偏移）+ 同时也监听自杀出口 0xb1bec。

var N = null;
var LOG = [];

function hex(n) { return '0x' + n.toString(16); }

function modOf(addr) {
    try { return Process.findModuleByAddress(addr); } catch (e) { return null; }
}

// 回溯出「调用方在 libnesec 的偏移」列表
function nesecTrace(ctx) {
    var out = [];
    var frames = null;
    try { frames = Thread.backtrace(ctx, Backtracer.FUZZY); } catch (e) { return out; }
    if (frames === null) { return out; }
    for (var i = 0; i < frames.length && out.length < 6; i++) {
        var m = modOf(frames[i]);
        if (m === null) { continue; }
        if (m.name.indexOf('libnesec') >= 0) {
            out.push('N+' + hex(frames[i].sub(m.base)));
        }
    }
    return out;
}

var STUBS = {
    0x2fed0: 'exit_group(94)',
    0x2ff30: 'kill(129)',
    0x2ff90: 'reboot(207)'
};

function arm() {
    if (N === null) { return; }
    var done = false;
    for (var off in STUBS) {
        (function (o, name) {
            try {
                Interceptor.attach(N.base.add(parseInt(o, 10)), {
                    onEnter: function () {
                        LOG.push('★★★ ' + name + ' 被调用  调用方=' + nesecTrace(this.context).join(' <- '));
                    },
                    onLeave: function () { }
                });
                done = true;
            } catch (e) {
                LOG.push('[!] 挂钩 ' + name + ' 失败: ' + e);
            }
        })(off, STUBS[off]);
    }
    // 自杀出口（已改 ret）也盯一下，确认还有谁在调
    try {
        Interceptor.attach(N.base.add(0xb1bec), {
            onEnter: function () {
                LOG.push('### 自杀出口 0xb1bec 被调用  调用方=' + nesecTrace(this.context).join(' <- '));
            }
        });
    } catch (e) { LOG.push('[!] 挂钩 0xb1bec 失败: ' + e); }

    // 检测判据（已改成 return 0）——确认调用次数，判断是否所有检测都走它
    try {
        Interceptor.attach(N.base.add(0xb1aec), {
            onEnter: function () {
                LOG.push('· 检测判据 0xb1aec 被调用  调用方=' + nesecTrace(this.context).join(' <- '));
            }
        });
    } catch (e) { LOG.push('[!] 挂钩 0xb1aec 失败: ' + e); }

    if (done) { LOG.push('[i] libnesec 挂钩完成 base=' + N.base); }
}

var iv = setInterval(function () {
    if (N !== null) { return; }
    var m = null;
    try { m = Process.findModuleByName('libnesec.so'); } catch (e) { m = null; }
    if (m === null) { return; }
    N = m;
    arm();
    clearInterval(iv);
    // 3 秒后 flush 一次日志（进程可能很快就死）
    setTimeout(function () { flush(); }, 3000);
}, 120);

function flush() {
    if (LOG.length === 0) { return; }
    send({ t: 'log', msg: LOG.join('\n') });
    LOG = [];
}

// 进程退出前兜底
Process.setExceptionHandler(function (d) {
    flush();
    return false;
});
