/**
 * 网易易盾壳脱壳：绕环境检测 + 在 DexFile::OpenCommon 处直接截获明文 DEX。
 *
 * 依据（xiaosan-re《汽车 App 加固分析：网易易盾壳的自定义 linker、SMC 与脱壳实战》）：
 *   1. 壳的架构含「反调试（IDA 端口 / 脱壳工具 / 进程状态 / root·模拟器）」，
 *      检测到即闪退 —— 所以必须先把环境伪装干净，进程才能活到加载 DEX。
 *   2. 壳在解密 DEX 后调用 art 的
 *        art::DexFileLoader::OpenCommon(const uint8_t* base, size_t size, ...)
 *      该处 base/size 就是完整明文 DEX —— 原文称「非常舒服的脱壳点」。
 *      在设备 libart.so 中已确认该符号存在：
 *        _ZN3art13DexFileLoader10OpenCommonEPKhmS2_mRK...
 *        _ZN3art16ArtDexFileLoader10OpenCommonEPKhmS2_mRK...
 *   3. 不要用 Process.enumerateRanges / findRangeByAddress —— 壳会检测
 *      /proc/self/maps 被遍历而退出（本项目已实测）。
 *
 * 作者备注：仅用于授权范围内的安全研究。
 */
'use strict';

function log(msg) {
    send({ t: 'log', msg: String(msg) });
}


/* ============================================================
 * 第 0 步：阻止壳自毁（提前挂在最前面）
 * 本项目实测：对 libc 的 exit/_exit/abort/quick_exit 用
 * Interceptor.attach + this.ret = true（跳过原实现），
 * 可把进程存活从约 2 秒延长到 20 秒以上。
 * 注意：不要用 Interceptor.replace —— 调用约定不匹配会导致 SIGSEGV
 *      （崩溃点在 /memfd:frida-agent-64.so，本项目已踩过）。
 * ============================================================ */
function hookAntiExit() {
    // 注意：不要拦 pthread_exit —— 它是 noreturn 函数，用 this.ret 让它返回
    // 属于未定义行为，实测会把进程搞死（本项目踩过）。只拦真正的进程级退出。
    const names = ['exit', '_exit', '_Exit', 'abort', 'quick_exit'];
    names.forEach(function (n) {
        const a = findExport(null, n);
        if (!a) return;
        try {
            Interceptor.attach(a, {
                onEnter() {
                    send({ t: 'log', msg: '[anti-exit] 拦截 ' + n + '（跳过原实现）' });
                    this.ret = true;
                }
            });
        } catch (e) { }
    });
    // kill(getpid(), SIGKILL/ABRT/TERM) 自杀防护
    const k = findExport(null, 'kill');
    if (k) {
        try {
            Interceptor.attach(k, {
                onEnter(args) {
                    const pid = args[0].toInt32();
                    const sig = args[1].toInt32();
                    let self = -1;
                    try { self = Process.id; } catch (e) { }
                    if ((pid === self || pid === -1) && (sig === 9 || sig === 6 || sig === 15)) {
                        send({ t: 'log', msg: '[anti-exit] 拦截 kill(self,' + sig + ')' });
                        args[1] = ptr(0);
                    }
                }
            });
        } catch (e) { }
    }
    // 直接走 syscall 的自毁（arm64: exit=93, exit_group=94）
    const sc = findExport(null, 'syscall');
    if (sc) {
        try {
            Interceptor.attach(sc, {
                onEnter(args) {
                    const nr = args[0].toInt32();
                    if (nr === 93 || nr === 94) {
                        send({ t: 'log', msg: '[anti-exit] 拦截 syscall exit_group' });
                        args[0] = ptr(0x7FFFFFFF);
                    }
                }
            });
        } catch (e) { }
    }
    send({ t: 'log', msg: '[anti-exit] 自毁拦截已安装' });
}
try { hookAntiExit(); } catch (e) { log('anti-exit 安装异常: ' + e); }

/* ============================================================
 * 第 1 步：隐藏 root / Magisk / 加固检测相关文件痕迹
 * 做法：在 libc 的 open/openat/access/stat 等系统调用入口处拦截，
 *      把命中黑名单的路径改成不存在（ENOENT），让壳「看不到」。
 * ============================================================ */

// 壳/风控会探测的路径特征。刻意分成两类：
//   * 子串匹配：特征足够独特，不会误伤正常路径
//   * 基名匹配：像 su / busybox 这类短词，只能整段比较
//     （早期版本把 'su' 当子串会命中 result / assets 等大量正常路径）
const BAD_SUBSTR = [
    'magisk', 'superuser', 'supersu', 'busybox', 'xposed', 'lsposed',
    'frida', 'substrate', 'zygisk', 'shamiko', 'magiskhide',
    'resetprop', '/data/adb', 'unpacker.config', 'dexname', '/fart',
    'libfupk3', 'libblackdex', 'libhoudini', 'blackdex', 'dumpdex',
    'xposedbridge', 'daemonsu', 'magiskd'
];
const BAD_BASENAME = ['su', 'magisk', 'busybox', 'supersu', 'daemonsu',
                      'magiskhide', 'resetprop', 'ksud'];

function isBad(path) {
    if (!path) return false;
    const p = path.toLowerCase();
    for (let i = 0; i < BAD_SUBSTR.length; i++) {
        if (p.indexOf(BAD_SUBSTR[i]) !== -1) return true;
    }
    // 基名精确匹配（去掉结尾可能的空格）
    const slash = p.lastIndexOf('/');
    const base = (slash >= 0 ? p.substring(slash + 1) : p).trim();
    for (let j = 0; j < BAD_BASENAME.length; j++) {
        if (base === BAD_BASENAME[j]) return true;
    }
    return false;
}

// Frida 17 移除了 Module.findExportByName（本项目实测），必须用下列 API：
//   Module.findGlobalExportByName(name) / Module.getGlobalExportByName(name)
//   Module.getExportByName(moduleName, name)
function findExport(mod, name) {
    // 先试全局查找 —— libart 的 ArtDexFileLoader::OpenCommon 是
    // GLOBAL PROTECTED 导出，全局可查（本项目已用 readelf 确认）。
    try { if (typeof Module.findGlobalExportByName === 'function') { const a = Module.findGlobalExportByName(name); if (a) return a; } } catch (e) { }
    try { if (typeof Module.getGlobalExportByName === 'function') { const a = Module.getGlobalExportByName(name); if (a) return a; } } catch (e) { }
    if (mod) {
        try { if (typeof Module.getExportByName === 'function') { const a = Module.getExportByName(mod, name); if (a) return a; } } catch (e) { }
        try { if (typeof Module.findExportByName === 'function') { const a = Module.findExportByName(mod, name); if (a) return a; } } catch (e) { }
    }
    return null;
}

// 兜底：直接从 libart.so 基址 + 符号偏移取地址。
// 偏移来自本机 libart.so 的 readelf 实测（ArtDexFileLoader::OpenCommon = 0x185650），
// 用于全局符号查找失效的场景（例如符号被裁剪或 Frida 版本差异）。
// 本机 libart.so 首个 LOAD 段的 p_vaddr = 0x27000（readelf -l 实测）。
// readelf 给出的符号地址是 vaddr，而 Frida 的 Module.base 指向首个映射
// （即 load_bias + 0x27000），所以：运行时地址 = base + vaddr - 0x27000。
// 不修正会整体偏移 0x27000，hook 装到一个无关地址上（本项目踩过）。
const LIBART_FIRST_LOAD_VADDR = 0x27000;

function addrByOffset(vaddr) {
    try {
        const m = Process.findModuleByName('libart.so') || Process.getModuleByName('libart.so');
        if (m) {
            const addr = m.base.add(vaddr - LIBART_FIRST_LOAD_VADDR);
            send({ t: 'log', msg: 'libart base=' + m.base + ' vaddr=0x' + vaddr.toString(16) +
                  ' -> ' + addr });
            return addr;
        }
    } catch (e) { send({ t: 'log', msg: '取 libart 基址失败: ' + e }); }
    return null;
}

function hookPathApis() {
    // 需要在 onEnter 改写参数或 onLeave 改返回值，逐个处理
    const specs = [
        // name,        pathArgIndex, kind
        ['open', 0, 'path'],
        ['openat', 1, 'path'],
        ['access', 0, 'path'],
        ['faccessat', 1, 'path'],
        ['stat', 0, 'path'],
        ['lstat', 0, 'path'],
        ['__statx', 1, 'path'],
        ['readlink', 0, 'path'],
        ['readlinkat', 1, 'path'],
        ['opendir', 0, 'path'],
        ['realpath', 0, 'path'],
        ['fopen', 0, 'path'],
        ['__open_2', 0, 'path'],
    ];
    let hooked = 0;
    specs.forEach(function (s) {
        const name = s[0], idx = s[1];
        const addr = findExport(null, name) || findExport('libc.so', name);
        if (!addr) { return; }
        try {
            Interceptor.attach(addr, {
                onEnter(args) {
                    let p = null;
                    try { p = args[idx].readCString(); } catch (e) { return; }
                    this.blocked = false;
                    if (isBad(p)) {
                        this.blocked = true;
                        // 把路径换成一个绝不存在的字符串，模拟「文件不存在」
                        args[idx] = Memory.allocUtf8String('/nonexistent/.hidden');
                    }
                }
            });
            hooked++;
        } catch (e) { }
    });
    log('已挂载路径隐藏 hook 数量: ' + hooked);
}

hookPathApis();


/* ============================================================
 * 第 1.5 步：修复壳对 Zygote 的 native 注册失败（关键）
 *
 * 现象（本机 logcat 实测）：
 *   E shandong_schoo: Failed to register native method
 *     com.android.internal.os.Zygote.nativeSpecializeAppProcess(...)V
 *     in /system/framework/framework.jar!classes3.dex
 * 壳的 anti-debug 需要劫持 Zygote 的该方法，但本机 Android 9 上该 native 方法
 * 不存在（Android 10+ 才有），注册失败 -> 壳的 hook 链断裂 -> System.exit(0)。
 *
 * 做法：hook art::JNI::RegisterNatives（LOCAL 符号，地址由本机 libart.so
 * 的 .symtab 实测 = 0x387860），把返回值强制为 JNI_OK(0)，
 * 让壳以为注册成功，从而继续走完解密流程。
 * ============================================================ */
function hookRegisterNatives() {
    const addr = addrByOffset(0x387860);   // art::JNI::RegisterNatives（vaddr）
    if (!addr) { log('RegisterNatives 地址不可得'); return; }
    try {
        Interceptor.attach(addr, {
            onEnter(args) {
                // args[2] = const JNINativeMethod* ，args[3] = int count
                // JNINativeMethod { const char* name; const char* signature; void* fnPtr; }  (24B on arm64)
                let cnt = 0;
                try { cnt = args[3].toInt32(); } catch (e) { }
                if (cnt <= 0 || cnt > 200) return;
                let names = [];
                for (let i = 0; i < cnt; i++) {
                    try {
                        const nm = args[2].add(i * 24).readPointer().readCString();
                        if (nm) names.push(nm);
                    } catch (e) { }
                }
                if (names.length) {
                    send({ t: 'log', msg: '[RegisterNatives] count=' + cnt + ' methods=' + names.join(',') });
                }
                this.forceOk = true;
            },
            onLeave(retval) {
                if (!this.forceOk) return;
                try {
                    const v = retval.toInt32();
                    if (v !== 0) {
                        send({ t: 'log', msg: '[RegisterNatives] 原始返回 ' + v + ' -> 强制 JNI_OK(0)' });
                        retval.replace(0);
                    }
                } catch (e) { }
            }
        });
        send({ t: 'log', msg: '已 hook art::JNI::RegisterNatives @ base+0x387860' });
    } catch (e) { log('hook RegisterNatives 失败: ' + e); }
}
try { hookRegisterNatives(); } catch (e) { }

/* ============================================================
 * 第 3 步：核心 —— hook art::DexFileLoader::OpenCommon 截获明文 DEX
 * 签名（Android 9 arm64 libart.so）：
 *   OpenCommon(const uint8_t* base, size_t size, const uint8_t* data_base, size_t data_size,
 *              const std::string& location, uint32_t location_checksum,
 *              const OatDexFile* oat_dex_file, bool verify, bool verify_checksum,
 *              std::string* error_msg, std::unique_ptr<DexFileContainer> container,
 *              VerifyResult* verify_result)
 * 因此 args[0]=base, args[1]=size, args[4]=&location(std::string)
 * ============================================================ */

// 注意：不要用 Module.findGlobalExportByName 解析 OpenCommon ——
// 该符号在本机 libart.so 里是 UND（未定义），全局查找会命中**其它模块**的
// 同名符号，得到完全错误的地址（实测偏移 0x811f4a40，差出 2GB）。
// 正确做法：用 .symtab 的 vaddr + 首个 LOAD 段修正（见 addrByOffset）。
const OPENCOMMON_VADDR = 0x185650;      // art::ArtDexFileLoader::OpenCommon

const seen = new Set();
let dumpCount = 0;

function tryReadCString(ptr) {
    try { return ptr.readCString(); } catch (e) { return null; }
}

function captureDex(base, size, where) {
    if (!base || size <= 0) return;
    if (size < 4096 || size > 256 * 1024 * 1024) return;
    // 校验 DEX magic "dex\n03x"
    let magic = '';
    try { magic = base.readCString(4); } catch (e) { return; }
    if (magic !== 'dex\n') { return; }

    const key = base.toString() + ':' + size;
    if (seen.has(key)) return;
    seen.add(key);

    // 读 header 关键字段，判断是否完整
    let fileSize = 0, strSize = 0, classDefs = 0;
    try {
        fileSize = base.add(0x20).readU32();
        strSize = base.add(0x38).readU32();
        classDefs = base.add(0x60).readU32();
    } catch (e) { }

    let data = null;
    try {
        data = base.readByteArray(Math.min(size, fileSize > 0 ? fileSize : size));
    } catch (e) {
        try { data = base.readByteArray(size); } catch (e2) { return; }
    }
    if (!data) return;

    dumpCount++;
    const isShellContainer = (size > 100 * 1024 * 1024 && classDefs < 100);
    log('捕获 DEX #' + dumpCount + ' @ ' + base + ' size=' + size +
        ' fileSize=' + fileSize + ' strings=' + strSize + ' classes=' + classDefs +
        (isShellContainer ? ' [壳容器，跳过传输]' : '') + ' (' + where + ')');
    if (isShellContainer) {
        // 壳自己的 141MB 容器：APK 里已有，无需回传（也超过 Frida 128MB 消息上限）
        send({ t: 'log', msg: 'DEX #' + dumpCount + ' 判定为壳容器（' + classDefs + ' 类），跳过' });
        return;
    }
    if (data.byteLength > 64 * 1024 * 1024) {
        send({ t: 'log', msg: 'DEX #' + dumpCount + ' 过大(' + data.byteLength + ')，跳过传输' });
        return;
    }
    send({ t: 'dex', idx: dumpCount, size: size, fileSize: fileSize,
           strSize: strSize, classDefs: classDefs, addr: base.toString() }, data);
}

function hookOpenCommon() {
    const addr = addrByOffset(OPENCOMMON_VADDR);
    if (!addr) { log('OpenCommon 地址不可得'); return 0; }
    try {
        Interceptor.attach(addr, {
            onEnter(args) {
                const base = args[0];
                const size = args[1].toInt32();
                let loc = null;
                try { loc = args[4].readPointer().readCString(); } catch (e) { }
                captureDex(base, size, 'OpenCommon loc=' + (loc || '?'));
            }
        });
        log('已 hook OpenCommon @ base+(0x185650-0x27000)');
        return 1;
    } catch (e) { log('hook OpenCommon 失败: ' + e); return 0; }
}

const n = hookOpenCommon();
if (n === 0) {
    log('未能 hook OpenCommon —— 可能需要改用 DexFileLoader 的其它导出或内联 hook');
}

// 兜底：也挂 header 里常见的 dex 打开路径（不同 Android 版本符号不同）
function hookExtra() {
    const ALT = [
        '_ZN3art13DexFileLoader8OpenFileEPKcS2_S2_bbPSt6vectorINSt3__110unique_ptrINS_7DexFileENS4_14default_deleteIS6_EEEENS4_9allocatorIS9_EEEEPNS0_12VerifyResultE',
        '_ZN3art13DexFileLoader12OpenFromFileEPKcS2_S2_bbPS2_',
    ];
    ALT.forEach(function (sym) {
        let a = null;
        try { a = Module.getExportByName('libart.so', sym); } catch (e) { }
        if (!a) return;
        try {
            Interceptor.attach(a, { onEnter(args) { log('命中备用入口: ' + sym.substring(0, 40)); } });
        } catch (e) { }
    });
}
try { hookExtra(); } catch (e) { }

log('脱壳脚本初始化完成（已 hook 路径隐藏 + Java 绕过 + OpenCommon）');

/* ============================================================
 * 第 2 步：Java 层 root 检测绕过（File.exists / Runtime.exec / System.getProperty）
 * 注意：Frida 17 经 Python API 加载时 Java 不是全局，需要 require。
 * ============================================================ */
// 注意：不要写 require('frida-java-bridge')。经 esbuild 打包后，
// require 会被解析成 CommonJS 模块命名空间对象（没有 perform/use），
// 导致 "TypeError: not a function"。入口脚本已把 bridge 注入为全局 Java，
// 这里直接用全局即可（本项目实测）。
let JAVA = (typeof Java !== 'undefined' && Java && Java.perform) ? Java : null;

if (JAVA) {
  try {
    JAVA.perform(function () {
        try {
            const File = JAVA.use('java.io.File');
            File.exists.implementation = function () {
                let path = '';
                try { path = this.getAbsolutePath(); } catch (e) { }
                if (isBad(path)) { return false; }
                return this.exists();
            };
            log('已 hook java.io.File.exists');
        } catch (e) { log('hook File.exists 失败: ' + e); }

        try {
            const File = JAVA.use('java.io.File');
            ['canRead', 'canExecute', 'isFile', 'isDirectory', 'length'].forEach(function (m) {
                try {
                    if (File[m] && File[m].implementation !== undefined) {
                        File[m].implementation = function () {
                            let path = '';
                            try { path = this.getAbsolutePath(); } catch (e) { }
                            if (isBad(path)) {
                                if (m === 'length') return 0;
                                if (m === 'canRead' || m === 'canExecute') return false;
                                return false;
                            }
                            return this[m].apply(this, arguments);
                        };
                    }
                } catch (e) { }
            });
            log('已 hook File 其余探测方法');
        } catch (e) { }

        try {
            const Runtime = JAVA.use('java.lang.Runtime');
            Runtime.exec.overload('java.lang.String').implementation = function (cmd) {
                if (isBad(cmd)) { log('拦截 Runtime.exec: ' + cmd); throw JAVA.use('java.io.IOException').$new('Permission denied'); }
                return this.exec(cmd);
            };
            Runtime.exec.overload('[Ljava.lang.String;').implementation = function (cmds) {
                try {
                    if (cmds && isBad(cmds.join(' '))) {
                        log('拦截 Runtime.exec[]: ' + cmds.join(' '));
                        throw JAVA.use('java.io.IOException').$new('Permission denied');
                    }
                } catch (e) { }
                return this.exec(cmds);
            };
            log('已 hook Runtime.exec');
        } catch (e) { log('hook Runtime.exec 失败: ' + e); }

        try {
            const Sys = JAVA.use('java.lang.System');
            const origGet = Sys.getProperty.overload('java.lang.String');
            origGet.implementation = function (key) {
                const v = origGet.call(this, key);
                if (key === 'ro.debuggable') return '0';
                if (key === 'ro.secure') return '1';
                return v;
            };
            log('已 hook System.getProperty');
        } catch (e) { }

        // 记录壳加载的 ClassLoader / DEX，便于确认脱壳时机
        try {
            const BaseDexCl = JAVA.use('dalvik.system.BaseDexClassLoader');
            BaseDexCl.$init.overload('java.lang.String', 'java.io.File', 'java.lang.String', 'java.lang.ClassLoader')
                .implementation = function (a, b, c, d) {
                    log('BaseDexClassLoader: ' + a);
                    return this.$init(a, b, c, d);
                };
        } catch (e) { }
    });
  } catch (e) {
    log('Java hook 段异常（不影响 native 脱壳）: ' + e);
  }
} else {
    log('Java bridge 不可用，仅做 native 层处理');
}
