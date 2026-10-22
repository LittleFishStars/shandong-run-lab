/**
 * 常驻脱壳脚本：保活 + 拦 mprotect + 报告 DexFile 地址。
 *
 * 关键经验（本项目实测）：
 *  1. 壳在应用 DEX 载入后调用 Java 层 System.exit(0) 自毁；拦 libc 的
 *     exit/_exit 全部无效（ART 走 System.exit → Runtime.exitInternal，
 *     壳还用内联 SVC 绕过 libc）。必须在此拦 Java 层。
 *  2. 壳用「自定义 linker」直接构造 ART 的 DexFile，所有标准 DEX 加载函数
 *     都不触发；唯一可见入口是 art::ClassLinker::DefineClass。
 *     运行时地址 = libart base + (0x11c7d8 − 首个LOAD段vaddr 0x27000)。
 *     参数：x2=类描述符, x5=const DexFile&, x6=const ClassDef&。
 *  3. ★ 类描述符过滤**必须同时匹配 `Lcom/huachenjie` 与 `Lhuachenjie`**
 *     —— 后者是应用自研 SDK 的根包（huachenjie.sdk.http / map / push / logcat）。
 *     早期只匹配前者，导致 huachenjie/sdk/http 整个模块（含请求签名
 *     SignInterceptor、加解密 EncryptInterceptor）被漏掉。
 *  4. mprotect(PROT_NONE) 会被壳用来撤销解密区的读权限，改成 RW 保持可读。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) { s('[anti-exit] System.exit(' + c + ') 已阻止'); }; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) { s('[anti-exit] Runtime.exit(' + c + ') 已阻止'); }; } catch (e) {}
  try { Java.use('java.lang.Runtime').halt.implementation = function (c) { s('[anti-exit] Runtime.halt(' + c + ') 已阻止'); }; } catch (e) {}
  s('[anti-exit] 已装');
});
(function () {
  function fe(n){ try { if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(n); } catch (e) {} try { return Module.getGlobalExportByName(n); } catch (e) {} return null; }
  const mp = fe('mprotect');
  let blk = 0;
  if (mp) {
    Interceptor.attach(mp, { onEnter: function (a) {
      try { if (a[2].toInt32() === 0) { blk++; a[2] = ptr(3); } } catch (e) {}   // PROT_NONE -> RW
    }});
    s('[mprotect] 已挂（PROT_NONE -> PROT_READ|PROT_WRITE）');
  }
})();
const FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
const sent = new Set();
let cnt = 0;
Interceptor.attach(art.base.add(0x11c7d8 - FIRST), {
  onEnter: function (a) {
    let desc = '';
    try { desc = a[2].readCString(); } catch (e) { return; }
    // ★ 两个前缀都要匹配：com.huachenjie（主应用）与 huachenjie.sdk（自研 SDK）
    if (!desc || (desc.indexOf('Lcom/huachenjie') !== 0 && desc.indexOf('Lhuachenjie') !== 0)) return;
    cnt++;
    const dexPtr = a[5];
    const key = dexPtr.toString();
    if (sent.has(key)) return;
    sent.add(key);
    s('应用类#' + cnt + ' ' + desc + '  DexFile&=' + dexPtr);
    send({ t: 'dexfile', addr: key, desc: desc });
  }
});
s('已 hook DefineClass（vaddr 0x11c7d8，匹配 Lcom/huachenjie + Lhuachenjie）');
