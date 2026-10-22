/**
 * Hook 自定义 linker 的 dlsym 包装，直接记录它查找的**明文**符号名。
 *
 * 依据（report/10 + 本次反编译）：
 *   FUN_000971f0 是自定义 ELF 加载器，它：
 *     · 读 e_phoff(0x3c)、按 0x20 字节遍历 Phdr、4KB 页对齐
 *     · mmap(0, size, 7 /*RWX* /, 0x21 MAP_ANON|MAP_PRIVATE* /, -1, 0)
 *     · memcpy 段内容
 *     · 调 FUN_0007ed58(local, &DAT_xxx) 取名字 → FUN_000d08b4(name, handle) 做 dlsym
 *
 * 因此 hook FUN_000d08b4 就能拿到**解密后的符号名明文**，
 * 一次解决「字符串加密」+「liby.so 导出了什么」两个问题。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function findExport(n){
  try { if (typeof Module.findGlobalExportByName==='function'){const a=Module.findGlobalExportByName(n); if(a)return a;} } catch(e){}
  try { if (typeof Module.getGlobalExportByName==='function'){const a=Module.getGlobalExportByName(n); if(a)return a;} } catch(e){}
  return null;
}

const SEG_MIN = 800000, SEG_MAX = 1000000;   // 892KB 段
const hooked = {};

// 候选：dlsym 包装 + 名字构造函数
const TARGETS = [
  ['FUN_000d08b4 dlsym包装', 0xd08b4],
  ['FUN_0007ed58 名字构造',   0x7ed58],
  ['FUN_0007ed08 JNI_OnLoad', 0x7ed08],
  ['FUN_000971f0 ELF加载器',  0x971f0],
];

const mp = findExport('mprotect');
if (mp) {
  Interceptor.attach(mp, {
    onEnter: function (a) { this.addr=a[0]; this.len=a[1].toInt32(); this.prot=a[2].toInt32(); },
    onLeave: function () {
      if (this.prot !== 5) return;
      if (this.len < SEG_MIN || this.len > SEG_MAX) return;
      const base = this.addr;
      s('★ 892KB 段 @ ' + base);

      TARGETS.forEach(function (t) {
        const name = t[0], off = t[1];
        if (hooked[off]) return;
        hooked[off] = 1;
        try {
          Interceptor.attach(base.add(off), {
            onEnter: function (args) {
              // 尝试多种签名解释，读出可能的字符串
              let cands = [];
              for (let i = 0; i < 4; i++) {
                let p = args[i];
                if (!p || p.isNull()) continue;
                // 直接当 char*
                try {
                  const cs = p.readCString();
                  if (cs && cs.length >= 2 && cs.length < 200 &&
                      /^[\x20-\x7e]+$/.test(cs)) cands.push('arg' + i + '(str)=' + cs);
                } catch (e) {}
                // 当 std::string*（SSO：[len][buf] 或 [ptr][len][cap]）
                try {
                  const b = new Uint8Array(p.readByteArray(32));
                  // 情况 A：+0 是长度（小端 8 字节），+8 起是内容
                  const lenA = b[0] | (b[1]<<8) | (b[2]<<16) | (b[3]<<24);
                  if (lenA > 0 && lenA < 200) {
                    let t2 = '';
                    for (let j = 0; j < lenA && 8+j < 32; j++) {
                      const c = b[8+j];
                      if (c >= 32 && c < 127) t2 += String.fromCharCode(c);
                    }
                    if (t2.length === lenA) cands.push('arg' + i + '(sso)=' + t2);
                  }
                  // 情况 B：+8 是长度，+16 起内容
                  const lenB = b[8] | (b[9]<<8) | (b[10]<<16) | (b[11]<<24);
                  if (lenB > 0 && lenB < 200) {
                    let t3 = '';
                    for (let j = 0; j < lenB && 16+j < 32; j++) {
                      const c = b[16+j];
                      if (c >= 32 && c < 127) t3 += String.fromCharCode(c);
                    }
                    if (t3.length === lenB) cands.push('arg' + i + '(sso2)=' + t3);
                  }
                } catch (e) {}
              }
              if (cands.length) {
                s('  [' + name + '] ' + cands.join('  |  '));
              } else {
                s('  [' + name + '] (参数无法解析为字符串)');
              }
            },
            onLeave: function (rv) {
              if (off === 0xd08b4) {
                s('       → 返回 ' + rv + (rv.isNull() ? '  (未找到)' : '  ★ 找到导出!'));
                if (!rv.isNull()) {
                  try {
                    const r = Process.findRangeByAddress(rv);
                    if (r) s('          实现段: ' + r.base + ' (' + (r.size/1024).toFixed(0) +
                             'KB ' + r.protection + ')  偏移 0x' + rv.sub(r.base).toString(16));
                  } catch (e) {}
                }
              }
            }
          });
          s('  [hook] ' + name);
        } catch (e) { s('  [hook] ' + name + ' 失败: ' + e); }
      });
    }
  });
}

// 触发
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (fired) return;
    let d = ''; try { d = a[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;
    Java.perform(function () {
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        s('触发 signRequest: ' + String(N.signRequest('{"probe":1}', 0)).substring(0, 30) + '...');
        s('触发 encodeRun: ' + String(N.encodeRun('a','b','c','d',0)).substring(0, 20));
      } catch (e) { s('' + e); }
    });
  }
});
s('[boot] dlsym 包装 hook 就绪');
