/**
 * 直接验证 + 精确 hook：不依赖内存扫描，用已知的固定地址。
 *
 * 关键洞察（本轮多次验证）：
 *   · liby.so 基址定位可靠（锚点+签名）
 *   · 但 160KB 代码区的函数**全部未触发**
 *   ⇒ signRequest 的实现**根本不在这个 liby.so 里**！
 *
 * 那它在哪？回顾 report/10 的发现：
 *   FUN_0009fb70 → MD5×13 → FUN_00083560 → FUN_000a3460  （在 892KB 易盾段里）
 *   而 `HcjNative` 静态块执行 `System.loadLibrary("y")`
 *
 * 可能性：liby.so 只是「加载器/解密器」，真正的 signRequest 在它解密出的
 * **另一个段**里（运行时 mmap 的匿名段）。
 *
 * 本脚本：在 signRequest 调用前后，对比整个进程的内存映射差异，
 * 找出「新增的可执行段」——那就是真正的实现所在。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function snapRanges() {
  const out = {};
  try {
    Process.enumerateRanges('---').forEach(function (r) {
      out[r.base.toString()] = { size: r.size, prot: r.protection };
    });
  } catch (e) {
    // '---' 可能不支持，逐个权限枚举
    ['r--', 'rw-', 'r-x', 'rwx', '--x', '-w-'].forEach(function (p) {
      try {
        Process.enumerateRanges(p).forEach(function (r) {
          out[r.base.toString()] = { size: r.size, prot: r.protection };
        });
      } catch (e2) {}
    });
  }
  return out;
}

let fired = false;
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      s('════ 对比 signRequest 调用前后的内存映射 ════');

      // ① 调用前快照
      const before = snapRanges();
      s('  调用前映射数: ' + Object.keys(before).length);

      // ② 调用（首次会触发 native 加载）
      let out1 = null;
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        out1 = String(N.signRequest('{"probe":1}', 0));
        s('  首次调用: ' + out1.substring(0, 32) + '...');
      } catch (e) { s('  调用失败: ' + e); }

      // ③ 调用后快照
      const after = snapRanges();
      s('  调用后映射数: ' + Object.keys(after).length);

      // ④ 找出新增/变化的
      s('');
      s('════ 新增或变化的内存段 ════');
      const added = [];
      Object.keys(after).forEach(function (k) {
        if (!before[k]) {
          added.push(k);
          s('  ★ 新增  ' + k + '  ' + (after[k].size/1024).toFixed(0) + 'KB  ' + after[k].prot);
        } else if (before[k].prot !== after[k].prot || before[k].size !== after[k].size) {
          s('  变化  ' + k + '  ' + before[k].prot + ' → ' + after[k].prot +
            '  ' + (before[k].size/1024).toFixed(0) + '→' + (after[k].size/1024).toFixed(0) + 'KB');
        }
      });
      if (!added.length) s('  （无新增段）');

      // ⑤ 特别关注：调用前后「权限变为可执行」的段
      s('');
      s('════ 从不可执行变为可执行的段 ════');
      let nx = 0;
      Object.keys(before).forEach(function (k) {
        const b = before[k], a2 = after[k];
        if (!a2) return;
        const bx = b.prot.indexOf('x') >= 0, ax = a2.prot.indexOf('x') >= 0;
        if (!bx && ax) {
          nx++;
          s('  ★★ ' + k + '  ' + b.prot + ' → ' + a2.prot + '  ' + (a2.size/1024).toFixed(0) + 'KB');
          send({ t: 'newexec', base: k, size: a2.size, prot: a2.prot });
        }
      });
      if (!nx) s('  （无）');

      // ⑥ 列出所有 >64KB 的可执行段（含匿名）
      s('');
      s('════ 所有 >64KB 的可执行段 ════');
      Object.keys(after).forEach(function (k) {
        const r = after[k];
        if (r.prot.indexOf('x') >= 0 && r.size > 64*1024) {
          s('    ' + k + '  ' + (r.size/1024).toFixed(0) + 'KB  ' + r.prot);
        }
      });

      s('');
      s('实测: ' + String(Java.use('com.huachenjie.c.HcjNative').signRequest('{"probe":2}', 0)).substring(0, 32) + '...');
    });
  }
});
s('[boot] 内存映射差异分析就绪');
