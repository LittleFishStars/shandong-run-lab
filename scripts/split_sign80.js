/**
 * 拆解 signRequest 的 80 字节输出 —— 在调用链各返回点 dump 中间值。
 *
 * 调用链（report/10 用触发追踪法确定）：
 *   FUN_0009fb70 (环境位图) → MD5 ×13 → FUN_00083560 (读 nedig.properties) → FUN_000a3460
 *
 * 策略：
 *   ① 在 signRequest 的 Java 层入口 hook，记录输入与输出
 *   ② 在 FUN_0009fb70 / FUN_00083560 / FUN_000a3460 的 onLeave 记录返回值
 *      （返回值往往是缓冲区指针 → 尝试按 80/64/48/32 字节读取）
 *   ③ 在 MD5 压缩函数上继续记录 state 演化，定位最后一轮的最终摘要
 *   ④ 对比：MD5 最终 state（16 字节）是否出现在 80 字节输出的某段
 *
 * 只读观测。
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

function hexdump(ptr, len) {
  let out = '';
  try {
    const b = new Uint8Array(ptr.readByteArray(len));
    for (let i = 0; i < b.length; i++) out += ('0' + b[i].toString(16)).slice(-2);
  } catch (e) { return '(读失败)'; }
  return out;
}

// 把 Java String 转成可比对的形式（Graal/ART 内部是 UTF-16 或压缩）
function jstr(u8) {
  try {
    // 尝试 latin1 / utf16le 两种解释
    let a = '', b = '';
    for (let i = 0; i < u8.length; i += 2) {
      if (i + 1 < u8.length) b += String.fromCharCode(u8[i] | (u8[i+1] << 8));
    }
    for (let i = 0; i < u8.length; i++) {
      const c = u8[i];
      if (c >= 32 && c < 127) a += String.fromCharCode(c);
    }
    return { ascii: a, utf16: b };
  } catch (e) { return { ascii: '', utf16: '' }; }
}

const TARGET_SEG_MIN = 800000, TARGET_SEG_MAX = 1000000;
const CHAIN = [
  ['FUN_0009fb70 环境位图', 0x9fb70],
  ['FUN_00083560 nedig配置', 0x83560],
  ['FUN_000a3460 ART注入',   0xa3460],
];
const MD5C = 0xb6a04;
const hooked = {};
let md5Count = 0;

// 收集所有 MD5 state，用于找最终摘要
const md5States = [];

const mp = findExport('mprotect');
if (mp) {
  Interceptor.attach(mp, {
    onEnter: function (a) { this.addr = a[0]; this.len = a[1].toInt32(); this.prot = a[2].toInt32(); },
    onLeave: function () {
      if (this.prot !== 5) return;
      if (this.len < TARGET_SEG_MIN || this.len > TARGET_SEG_MAX) return;
      const base = this.addr;
      s('★ 目标段 @ ' + base + ' (' + (this.len / 1024).toFixed(0) + 'KB)');

      // ── MD5 压缩函数 ──
      if (!hooked.md5) {
        hooked.md5 = 1;
        try {
          Interceptor.attach(base.add(MD5C), {
            onEnter: function (args) {
              md5Count++;
              this.st = args[0];
              this.dt = args[1];
            },
            onLeave: function () {
              // 记录每轮后的 state（小端 4×uint32）
              try {
                const b = new Uint8Array(this.st.readByteArray(16));
                let hx = '';
                for (let i = 0; i < 16; i++) hx += ('0' + b[i].toString(16)).slice(-2);
                md5States.push({ n: md5Count, state: hx });
              } catch (e) {}
              if (md5Count % 13 === 0 || md5Count <= 3) {
                send({ t: 'md5state', n: md5Count,
                       state: md5States.length ? md5States[md5States.length-1].state : '' });
              }
            }
          });
          s('   [hook] MD5 压缩函数');
        } catch (e) { s('   [hook] MD5 失败: ' + e); }
      }

      // ── 调用链三个函数的返回点 ──
      CHAIN.forEach(function (c) {
        const name = c[0], off = c[1];
        if (hooked[off]) return;
        hooked[off] = 1;
        try {
          Interceptor.attach(base.add(off), {
            onEnter: function () { s('   → 进入 ' + name); },
            onLeave: function (rv) {
              // 返回值可能是字符串指针或缓冲区
              let ascii = '', u16 = '';
              try {
                const raw = new Uint8Array(rv.readByteArray(96));
                const j = jstr(raw);
                ascii = j.ascii; u16 = j.utf16;
              } catch (e) {}
              send({ t: 'ret', name: name, ret: rv.toString(),
                     ascii: ascii, utf16: u16 });
            }
          });
          s('   [hook] ' + name);
        } catch (e) { s('   [hook] ' + name + ' 失败: ' + e); }
      });
    }
  });
}

// ── Java 层入口 ──
const FIRST = 0x27000, DC = 0x11c7d8;
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
        const cases = ['{"probe":1}', '{}', '{"a":2}'];
        cases.forEach(function (inp) {
          const t0 = md5Count;
          const r = String(N.signRequest(inp, 0));
          send({ t: 'sign', inp: inp, out: r, md5: md5Count - t0 });
        });
        // 汇总 MD5 state
        send({ t: 'md5sum', total: md5Count, states: md5States.map(function (x) { return x.state; }) });
      } catch (e) { s('调用失败: ' + e); }
    });
  }
});
s('[boot] 80 字节拆解就绪');
