/**
 * 抓取 signRequest 的真实输入 —— 在 native 层拦截，拿到 Java 层看不到的东西。
 *
 * 思路：
 *   ① Java 层 hook HcjNative.signRequest，记录传入的 json 字符串
 *   ② native 层 hook 安全 SDK 的 MD5（地址会随每次加载变化，用特征扫描定位）——
 *      用 mprotect→RX 钓出的那个段地址 + Ghidra 分析得到的函数偏移 0xb6a04
 *   ③ 记录 MD5 的实际输入缓冲区内容（即签名前的明文拼接结果）
 *
 * 这是纯只读观测，不修改任何数据。
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

// ═══ 记录钓到的隐藏 SO 基址（mprotect→RX 时保存）═══
var hiddenSegs = [];

const mprotectAddr = findExport('mprotect');
if (mprotectAddr) {
    Interceptor.attach(mprotectAddr, {
        onEnter: function (args) {
            this.addr = args[0];
            this.len = args[1].toInt32();
            this.prot = args[2].toInt32();
        },
        onLeave: function (retval) {
            // 目标段约 892KB（0xdA000）
            if (this.prot === 5 && this.len >= 800000 && this.len <= 1000000) {
                s('★★ 钓到目标段: ' + this.addr + '  ' + (this.len/1024).toFixed(0) + 'KB');
                hiddenSegs.push({ base: this.addr, size: this.len });

                // ★ 立即在段内安装 MD5 hook（偏移来自 Ghidra 分析：0xb6a04）
                var md5 = this.addr.add(0xb6a04);
                try {
                    Interceptor.attach(md5, {
                        onEnter: function (args) {
                            // MD5 压缩函数签名（Ghidra 推断）：(int state[4], long data)
                            // 实际是 (uint32 state[4]*, uint8 data[64]*)
                            var state = args[0];
                            var data = args[1];
                            var hex = '';
                            try {
                                var bytes = new Uint8Array(data.readByteArray(64));
                                for (var i = 0; i < 64; i++)
                                    hex += ('0' + bytes[i].toString(16)).slice(-2);
                            } catch (e) { hex = '(读取失败)'; }
                            var st = '';
                            try {
                                var b4 = new Uint8Array(state.readByteArray(16));
                                for (var i = 0; i < 4; i++) {
                                    var v = (b4[i*4] | (b4[i*4+1]<<8) | (b4[i*4+2]<<16) | (b4[i*4+3]<<24)) >>> 0;
                                    st += v.toString(16).padStart(8,'0') + ' ';
                                }
                            } catch (e) { st = '(读取失败)'; }
                            send({ t: 'md5', ret: this.returnAddress.toString(),
                                   state: st, data: hex });
                        }
                    });
                    s('  ✓ 已在段+0xb6a04 安装 MD5 hook');
                } catch (e) { s('  ✗ MD5 hook 失败: ' + e); }
            }
        }
    });
}

// ═══ Java 层：记录 signRequest 的输入 ═══
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
                // ★ hook Java 层入口，记录输入
                N.signRequest.implementation = function (json, env) {
                    s('═══ signRequest 调用 ═══');
                    s('  json = ' + json);
                    s('  len  = ' + (json ? json.length : 0));
                    s('  env  = ' + env);
                    var r = this.signRequest(json, env);
                    s('  → ' + r);
                    return r;
                };
                s('[hook] Java 层 signRequest 已挂');
                // 触发一次
                s('  主动调用: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 32) + '...');
            } catch (e) { s('  ' + e); }
        });
    }
});

s('[boot] signRequest 输入捕获就绪');
