/**
 * 阻止网易易盾壳自毁，让解壳流程走完。
 *
 * 背景：
 *   该应用被易盾加固。壳在启动约 2 秒后主动 System.exit(0)（native 层触发），
 *   导致磁盘与内存里都拿不到解出的应用 DEX。此脚本在进程早期注入，
 *   拦截所有会终止进程的路径，使壳无法自杀。
 *
 * 拦截点（覆盖 Java 与 native 两条路径）：
 *   1. java.lang.System.exit / Runtime.exit / Runtime.halt
 *   2. native exit / _exit / _Exit / abort / kill(自身, SIGKILL)
 *   3. android.os.Process.killProcess / System.exit 相关包装
 *
 * 附带：把 InMemoryDexClassLoader / DexClassLoader 的构造与 defineClass
 *   记录下来，便于确认壳到底加载了什么。
 */
'use strict';

function log(msg) {
    console.log('[anti-exit] ' + msg);
    send({ type: 'log', message: String(msg) });
}

function blockAndLog(where) {
    log('拦截终止调用: ' + where + '\n' + (new Error().stack || ''));
}

// Frida 17 通过 Python API 加载时不会自动注入 Java bridge，需显式引入
let Java = null;
try { Java = require('frida-java-bridge'); log('已加载 frida-java-bridge'); }
catch (e) { log('frida-java-bridge 加载失败（CLI 模式下 Java 为全局）: ' + e); }

try { Java.perform(function () {
    log('Java VM 就绪，开始挂 Java hook');
    // ---------- Java 层：System.exit / Runtime ----------
    try {
        const System = Java.use('java.lang.System');
        System.exit.implementation = function (code) {
            blockAndLog('java.lang.System.exit(' + code + ')');
            // 不调用原实现：进程继续存活
        };
        log('已 hook System.exit');
    } catch (e) { log('hook System.exit 失败: ' + e); }

    try {
        const Runtime = Java.use('java.lang.Runtime');
        Runtime.exit.implementation = function (code) {
            blockAndLog('Runtime.exit(' + code + ')');
        };
        Runtime.halt.implementation = function (code) {
            blockAndLog('Runtime.halt(' + code + ')');
        };
        log('已 hook Runtime.exit/halt');
    } catch (e) { log('hook Runtime 失败: ' + e); }

    // ---------- Java 层：Process.killProcess ----------
    try {
        const Process = Java.use('android.os.Process');
        Process.killProcess.implementation = function (pid) {
            blockAndLog('Process.killProcess(' + pid + ')');
        };
        log('已 hook Process.killProcess');
    } catch (e) { log('hook Process 失败: ' + e); }

    // ---------- 观察：DEX 加载与类加载器 ----------
    try {
        const InMem = Java.use('dalvik.system.InMemoryDexClassLoader');
        InMem.$init.overload('[Ljava.nio.ByteBuffer;', 'java.lang.ClassLoader')
            .implementation = function (bufs, parent) {
                let total = 0;
                for (let i = 0; i < bufs.length; i++) {
                    try { total += bufs[i].remaining(); } catch (e) {}
                }
                log('InMemoryDexClassLoader 构造: ' + bufs.length + ' 个 buffer, 共 ' + total + ' 字节');
                return this.$init(bufs, parent);
            };
        log('已 hook InMemoryDexClassLoader');
    } catch (e) { log('hook InMemoryDexClassLoader 失败: ' + e); }

    try {
        const DexCl = Java.use('dalvik.system.DexClassLoader');
        DexCl.$init.overload('java.lang.String', 'java.lang.String',
            'java.lang.String', 'java.lang.ClassLoader')
            .implementation = function (dexPath, opt, lib, parent) {
                log('DexClassLoader(dexPath=' + dexPath + ', lib=' + lib + ')');
                return this.$init(dexPath, opt, lib, parent);
            };
        log('已 hook DexClassLoader');
    } catch (e) { log('hook DexClassLoader 失败: ' + e); }

    // ---------- 观察：DexFile 加载 ----------
    try {
        const DexFile = Java.use('dalvik.system.DexFile');
        DexFile.loadDex.overload('java.lang.String', 'java.lang.String', 'int')
            .implementation = function (src, out, flags) {
                log('DexFile.loadDex(' + src + ')');
                return this.loadDex(src, out, flags);
            };
        log('已 hook DexFile.loadDex');
    } catch (e) { log('hook DexFile 失败: ' + e); }
  });
} catch (e) {
  log('Java 尚未就绪（spawn 早期），将在 resume 后重试: ' + e);
  // 进程 resume 后 Java 必然存在，用轮询二次尝试
  let n = 0;
  const iv = setInterval(function () {
    n++;
    try {
      if (typeof Java === 'undefined' || !Java.available) {
        if (n > 2000) { clearInterval(iv); log('Java 等待超时'); }
        return;
      }
      clearInterval(iv);
      log('Java 就绪（第 ' + n + ' 次轮询）');
      Java.perform(function () {
        const Sys = Java.use('java.lang.System');
        Sys.exit.implementation = function (code) {
          blockAndLog('java.lang.System.exit(' + code + ') 已阻止');
        };
        log('已 hook System.exit（延迟）');
        const Rt = Java.use('java.lang.Runtime');
        Rt.exit.implementation = function (code) { blockAndLog('Runtime.exit(' + code + ')'); };
        Rt.halt.implementation = function (code) { blockAndLog('Runtime.halt(' + code + ')'); };
        log('已 hook Runtime（延迟）');
        const Pr = Java.use('android.os.Process');
        Pr.killProcess.implementation = function (pid) { blockAndLog('Process.killProcess(' + pid + ')'); };
        log('已 hook Process.killProcess（延迟）');
      });
    } catch (e2) { /* 继续等 */ }
  }, 5);
}

// ---------- native 层：exit / _exit / abort / raise ----------
// Frida 17 移除了 Module.findExportByName，这里做多版本兼容
function findExport(name) {
    try {
        if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
    } catch (e) {}
    try {
        if (typeof Module.getGlobalExportByName === 'function') return Module.getGlobalExportByName(name);
    } catch (e) {}
    try {
        if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
    } catch (e) {}
    // 兜底：按模块遍历
    try { return Module.getExportByName('libc.so', name); } catch (e) {}
    return null;
}

function hookNative() {
    // 只用 Interceptor.attach + this.ret（跳过原实现）。
    // 不使用 Interceptor.replace：对 void(int) 之外调用约定的符号（如带变参的
    // pthread_exit / 被 PLT 转跳的 _exit）替换后会造成调用约定不匹配而 SIGSEGV
    // —— 本机实测崩溃点正是 /memfd:frida-agent-64.so。
    const NAMES = ['exit', '_exit', '_Exit', 'abort', 'quick_exit', 'exit_group'];
    NAMES.forEach(function (name) {
        const addr = findExport(name);
        if (!addr) { return; }
        try {
            Interceptor.attach(addr, {
                onEnter() {
                    blockAndLog('native ' + name);
                    this.ret = true;      // 直接返回调用者，不执行原函数体
                }
            });
            log('已 attach native ' + name);
        } catch (e) { log('native ' + name + ' attach 失败: ' + e); }
    });

    // syscall 层：arm64 exit=93 / exit_group=94
    const syscallAddr = findExport('syscall');
    if (syscallAddr) {
        try {
            Interceptor.attach(syscallAddr, {
                onEnter(args) {
                    const nr = args[0].toInt32();
                    if (nr === 93 || nr === 94) {
                        blockAndLog('syscall exit/' + nr);
                        args[0] = ptr(0x7FFFFFFF);
                    }
                }
            });
            log('已 attach syscall');
        } catch (e) { log('syscall attach 失败: ' + e); }
    }

    // kill(getpid(), ...) 自杀防护
    const killAddr = findExport('kill');
    if (killAddr) {
        try {
            Interceptor.attach(killAddr, {
                onEnter(args) {
                    const pid = args[0].toInt32();
                    const sig = args[1].toInt32();
                    if ((pid === Process.id || pid === -1) && (sig === 9 || sig === 6 || sig === 15)) {
                        blockAndLog('kill(self, sig=' + sig + ')');
                        args[1] = ptr(0);
                    }
                }
            });
            log('已 attach native kill');
        } catch (e) { log('kill attach 失败: ' + e); }
    }
}

// native hook 不依赖 Java VM，立即挂载
try { hookNative(); } catch (e) { log('native hook 异常: ' + e); }

log('anti-exit 脚本已加载');

// ============ 关键：拦 mprotect，阻止壳撤销解密后 DEX 页的读权限 ============
// 依据 AWAKE 对 NetEase YiDun App Packer 的记载：壳在解密 DEX 后会用
// mprotect(addr, len, PROT_NONE) 把该区域设为不可读，导致内存扫描找不到 DEX。
// 把 prot=0 改写成 PROT_READ(1) 即可保持可读，随后才能 dump 到明文 DEX。
function hookMprotect() {
    ['mprotect'].forEach(function (name) {
        let addr = null;
        try { addr = Module.getExportByName('libc.so', name); } catch (e) {}
        if (!addr) { try { addr = findExport(name); } catch (e) {} }
        if (!addr) { log('mprotect 未找到'); return; }
        Interceptor.attach(addr, {
            onEnter(args) {
                const prot = args[2].toInt32();
                const size = args[1].toInt32();
                const target = args[0];
                if (prot === 0) {                     // PROT_NONE：壳想撤读权限
                    log('拦截 mprotect(PROT_NONE) addr=' + target + ' size=' + size + ' -> 改为 PROT_READ');
                    args[2] = ptr(1);
                } else if (size > 0x10000) {          // 记录大区域权限变更，便于分析
                    log('mprotect addr=' + target + ' size=' + size + ' prot=' + prot);
                }
            }
        });
        log('已 attach mprotect（阻止 PROT_NONE）');
    });
}
try { hookMprotect(); } catch (e) { log('mprotect hook 异常: ' + e); }
