/**
 * 在捕获 mprotect→RX 的**同一时刻**，于进程内立即 dump 该区间。
 *
 * 为什么必须进程内：宿主往返（adb shell dd + pull）需要数秒，而壳在此窗口内会
 * 自毁/卸载隐藏 SO，导致 dump 到空或拿不到。
 *
 * 依据（看雪《Frida 企业级加固对抗实战：通过 mmap/mprotect 钓出壳隐藏的真实 SO》）：
 *   壳绕开系统 linker 私自加载真实 SO，但**无法绕过 mmap/mprotect**：
 *   隐藏 SO 完成 mmap 后必紧跟一次 mprotect→RX。在那一刻读内存最可靠。
 *
 * 传输策略：单次 send 不宜超过 64MB（Frida 消息上限），因此超过则分块。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function findExport(name) {
    try {
        if (typeof Module.findGlobalExportByName === 'function') {
            const a = Module.findGlobalExportByName(name);
            if (a) return a;
        }
    } catch (e) {}
    try {
        if (typeof Module.getGlobalExportByName === 'function') {
            const a = Module.getGlobalExportByName(name);
            if (a) return a;
        }
    } catch (e) {}
    return null;
}

const MAX_ONESHOT = 48 * 1024 * 1024;      // 单次 send 上限
const dumped = {};                          // 去重

function grab(addr, len, why) {
    const key = addr.toString() + ':' + len;
    if (dumped[key]) return;
    dumped[key] = true;

    let data = null;
    try { data = addr.readByteArray(len); }
    catch (e) { s('[!] 读取失败 ' + addr + ': ' + e); return; }
    if (!data) { s('[!] ' + addr + ' 读出 null'); return; }

    // 快速特征
    let elf = -1;
    try {
        const u8 = new Uint8Array(data);
        for (let i = 0; i + 4 < u8.length && i < 0x100000; i++) {
            if (u8[i] === 0x7f && u8[i+1] === 0x45 && u8[i+2] === 0x4c && u8[i+3] === 0x46) {
                elf = i; break;
            }
        }
    } catch (e) {}

    s('★★★ 进程内 dump: ' + addr + '  ' + (len/1024).toFixed(1) + 'KB  ' +
      'ELF头=' + (elf >= 0 ? '0x' + elf.toString(16) : '无') + '  (' + why + ')');

    if (len <= MAX_ONESHOT) {
        send({ t: 'so', addr: addr.toString(), len: len, elf: elf, part: 0, total: 1 }, data);
    } else {
        const CH = MAX_ONESHOT;
        const n = Math.ceil(len / CH);
        for (let i = 0; i < n; i++) {
            const off = i * CH;
            const sz = Math.min(CH, len - off);
            let chunk = null;
            try { chunk = addr.add(off).readByteArray(sz); } catch (e) { continue; }
            if (chunk) send({ t: 'so', addr: addr.toString(), len: len, elf: elf,
                              part: i, total: n, off: off }, chunk);
        }
    }
}

// ═══ 主钩子：mprotect→RX ═══
const mprotectAddr = findExport('mprotect');
if (mprotectAddr) {
    Interceptor.attach(mprotectAddr, {
        onEnter: function (args) {
            this.addr = args[0];
            this.len = args[1].toInt32();
            this.prot = args[2].toInt32();
        },
        onLeave: function (retval) {
            // PROT_READ(1)|PROT_EXEC(4) == 5，且大小合理（排除 32MB jit-cache）
            if (this.prot === 5 && this.len >= 32 * 1024 && this.len <= 8 * 1024 * 1024) {
                // 立即 dump（同一调用栈内，最可靠）
                grab(this.addr, this.len, 'mprotect→RX');
            }
        }
    });
    s('[hook] mprotect（捕获 RX 后立即进程内 dump）');
}

// ═══ 辅助：mmap 分配的匿名大块也记下来 ═══
const mmapAddr = findExport('mmap');
if (mmapAddr) {
    Interceptor.attach(mmapAddr, {
        onEnter: function (args) {
            this.len = args[1].toInt32();
            this.fd = args[4].toInt32();
        },
        onLeave: function (retval) {
            if (retval.isNull()) return;
            if (this.fd !== -1 && this.fd !== -0x1) return;      // 只关心匿名
            if (this.len < 128 * 1024 || this.len > 8 * 1024 * 1024) return;
            s('[mmap anon] ' + retval + '  ' + (this.len/1024).toFixed(1) + 'KB');
        }
    });
}

// ═══ 记录哪些 so 被 dlopen（含可疑）═══
['android_dlopen_ext', 'dlopen'].forEach(function (n) {
    const a = findExport(n);
    if (!a) return;
    Interceptor.attach(a, {
        onEnter: function (args) {
            let name = '';
            try { name = args[0].readCString(); } catch (e) {}
            if (name && name.length < 200) s('[' + n + '] ' + name);
        }
    });
});

// ═══ 触发：主动调用 native ═══
const FIRST = 0x27000, DC = 0x11c7d8;
const art = Process.findModuleByName('libart.so');
var fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
    onEnter: function (a) {
        if (fired) return;
        var desc = '';
        try { desc = a[2].readCString(); } catch (e) { return; }
        if (!desc || desc.indexOf('Lcom/huachenjie/') !== 0) return;
        fired = true;
        s('[native] 触发: ' + desc);
        Java.perform(function () {
            try {
                var N = Java.use('com.huachenjie.c.HcjNative');
                s('  signRequest → ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 24) + '...');
            } catch (e) { s('  ' + e); }
        });
    }
});

s('[boot] 就绪（进程内即时 dump）');
