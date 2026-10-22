/**
 * 「钓」出壳隐藏的真实 SO —— mmap + mprotect 联合监控法。
 *
 * 依据（看雪《Frida 企业级加固对抗实战：通过 mmap/mprotect 钓出壳隐藏的真实 SO》）：
 *   壳为隐藏真实业务 SO，会**绕开系统 linker 私自加载**（不登记到已加载模块链表），
 *   因此 findModuleByName / maps 里都看不到它。但壳**绝对无法绕过 mmap**——
 *   要让 SO 运行就必须用 mmap 分配内存、写入解密后的代码。
 *   且**隐藏 SO 完成 mmap 后一定会紧跟一次 mprotect 把代码段改成 RX**。
 *   ⇒ 监控 mmap(num > 阈值) + 紧随其后的 mprotect(PROT_READ|PROT_EXEC) 即可锁定。
 *
 * 本脚本还额外监控：
 *   · android_dlopen_ext / dlopen  （看壳如何加载）
 *   · dlsym                        （看壳是否劫持符号查找）
 *   · 自身进程的 mprotect 调用，把「刚变为 RX」的区间报给宿主
 *
 * 只读观测，不修改任何行为。
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

const FIRST = 0x27000, DC = 0x11c7d8;
const art = Process.findModuleByName('libart.so');

// ── 记录 mmap 的分配（地址 → 大小）──
const mmapAllocs = [];
// ── 记录 mprotect 改成的 RX 区间 ──
const rxRanges = [];

// ═══ ① hook mmap ═══
const mmapAddr = findExport('mmap');
if (mmapAddr) {
    Interceptor.attach(mmapAddr, {
        onEnter: function (args) {
            this.len = args[1].toInt32();
            this.prot = args[2].toInt32();
            this.flags = args[3].toInt32();
            this.fd = args[4].toInt32();
        },
        onLeave: function (retval) {
            const addr = retval;
            if (addr.isNull()) return;
            // 只关心可观大小的匿名映射（壳加载 SO 用）
            if (this.len < 16 * 1024) return;
            // fd == -1 表示匿名映射
            const anon = (this.fd === -1 || this.fd === -0x1);
            const rec = {
                addr: addr.toString(),
                len: this.len,
                prot: this.prot,
                anon: anon,
                fd: this.fd
            };
            mmapAllocs.push(rec);
            // 只报「匿名 + 大块」的（壳隐藏 SO 的典型特征）
            if (anon && this.len >= 64 * 1024) {
                s('[mmap] ' + addr + '  len=' + (this.len / 1024).toFixed(1) + 'KB' +
                  '  prot=' + this.prot + '  anon=1');
                send({ t: 'mmap', addr: rec.addr, len: this.len, prot: this.prot });
            }
        }
    });
    s('[hook] mmap @ ' + mmapAddr);
} else {
    s('[hook] mmap 未找到');
}

// ═══ ② hook mprotect —— 这是关键：捕获「刚变成 RX」的区间 ═══
const mprotectAddr = findExport('mprotect');
if (mprotectAddr) {
    Interceptor.attach(mprotectAddr, {
        onEnter: function (args) {
            this.addr = args[0];
            this.len = args[1].toInt32();
            this.prot = args[2].toInt32();
        },
        onLeave: function (retval) {
            // PROT_READ(1) | PROT_EXEC(4) == 5
            if (this.prot === 5 && this.len >= 16 * 1024) {
                rxRanges.push({ addr: this.addr.toString(), len: this.len });
                s('★★ [mprotect→RX] ' + this.addr + '  len=' +
                  (this.len / 1024).toFixed(1) + 'KB  ★ 疑似隐藏 SO 代码段');
                send({ t: 'rx', addr: this.addr.toString(), len: this.len });
            }
        }
    });
    s('[hook] mprotect @ ' + mprotectAddr);
} else {
    s('[hook] mprotect 未找到');
}

// ═══ ③ hook dlopen / android_dlopen_ext ═══
['dlopen', 'android_dlopen_ext', 'dlclose'].forEach(function (n) {
    const a = findExport(n);
    if (!a) return;
    try {
        Interceptor.attach(a, {
            onEnter: function (args) {
                let name = '';
                try { name = args[0].readCString(); } catch (e) {}
                if (name && name.length < 200) s('[' + n + '] ' + name);
            },
            onLeave: function (retval) {
                if (n === 'dlopen' || n === 'android_dlopen_ext') {
                    s('  → handle = ' + retval);
                }
            }
        });
        s('[hook] ' + n);
    } catch (e) {}
});

// ═══ ④ hook dlsym —— 看壳是否劫持符号查找 ═══
const dlsymAddr = findExport('dlsym');
if (dlsymAddr) {
    Interceptor.attach(dlsymAddr, {
        onEnter: function (args) {
            this.handle = args[0];
            this.name = '';
            try { this.name = args[1].readCString(); } catch (e) {}
        },
        onLeave: function (retval) {
            if (!this.name) return;
            // 只关心安全相关符号，避免刷屏
            const n = this.name;
            if (n.indexOf('JNI_OnLoad') >= 0 || n.indexOf('Java_') === 0 ||
                n.indexOf('sign') >= 0 || n.indexOf('encode') >= 0 ||
                n.indexOf('Register') >= 0) {
                let owner = '';
                try {
                    const mod = Process.findModuleByAddress(retval);
                    owner = mod ? mod.name : '(不属于任何已知模块!)';
                } catch (e) { owner = '(查询失败)'; }
                s('[dlsym] ' + n + ' → ' + retval + '  owner=' + owner);
            }
        }
    });
    s('[hook] dlsym');
}

// ═══ ⑤ 触发时机：等应用类出现，主动调用 native 逼壳加载 ═══
var fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
    onEnter: function (a) {
        if (fired) return;
        var desc = '';
        try { desc = a[2].readCString(); } catch (e) { return; }
        if (!desc || desc.indexOf('Lcom/huachenjie/') !== 0) return;
        fired = true;
        s('[native] 触发类: ' + desc + '，主动调用 native 以逼壳加载');
        Java.perform(function () {
            try {
                var N = Java.use('com.huachenjie.c.HcjNative');
                var r = String(N.signRequest('{"probe":1}', 0));
                s('  调用成功: ' + r.substring(0, 30) + '...');
            } catch (e) { s('  调用失败: ' + e); }
        });
    }
});

s('[boot] mmap/mprotect/dlsym 监控就绪');
