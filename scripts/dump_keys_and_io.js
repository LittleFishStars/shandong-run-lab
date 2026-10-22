/**
 * ★终局：动态 dump libNetHTProtect.so 的运行时密钥表 + hook 签名核心函数。
 *
 * 已确认（静态分析）：
 *   · signRequest 实现 = libNetHTProtect.so + 0x24926c → 调 FUN_0034b820
 *   · FUN_0034b820 → 单例 vtable 槽0 = FUN_00179284（+0x179284）
 *   · FUN_00179284 = 8 字节分组 + PKCS#7 填充 + 16 轮查表变换（TEA 家族）
 *   · 4 张 256 项 uint32 表位于 .bss：DAT_0057c9b8 / T2 +0x47cdb8 / T3 +0x47d1b8 / T4 +0x47d5b8
 *     → 磁盘全零，**运行时生成**
 *
 * 本脚本：
 *   ① 定位 libNetHTProtect.so 运行时基址
 *   ② dump .bss 中的 4 张表 + 加白常量（+0x47c9b0 ~ +0x47d9b8）
 *   ③ hook FUN_00179284，抓 (输入, 输出) 对 → 用于离线验证还原结果
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

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
      // ① 触发 native 加载
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24));
      } catch (e) { s('warm err: ' + String(e).substring(0, 80)); }

      // ② 定位 libNetHTProtect.so
      let base = null, size = 0;
      try {
        Process.enumerateRanges('r-x').forEach(function (r) {
          const p = r.file ? r.file.path : '';
          if (p.indexOf('libNetHTProtect.so') >= 0 && !base) { base = r.base; size = r.size; }
        });
      } catch (e) {}
      if (!base) { s('✗ 未找到 libNetHTProtect.so'); return; }
      s('★ libNetHTProtect.so r-x @' + base + '  size=0x' + size.toString(16));
      send({ t: 'base', base: String(base), size: size });

      // ③ dump 运行时表（.bss，磁盘为 0）
      s('');
      s('════ 运行时密钥表 dump ════');
      const TABLES = [
        ['delta_key', 0x47c970, 0x40],
        ['T0_white',  0x47c9b0, 0x10],
        ['T1',        0x47c9b8, 0x400],
        ['T2',        0x47cdb8, 0x400],
        ['T3',        0x47d1b8, 0x400],
        ['T4',        0x47d5b8, 0x400],
        ['tail',      0x47d9b8, 0x40],
      ];
      TABLES.forEach(function (t) {
        const nm = t[0], off = t[1], n = t[2];
        const h = hex(base.add(off), n);
        if (h) {
          s('  ' + nm.padEnd(12) + ' +0x' + off.toString(16) + '  ' + h.substring(0, 72) + (h.length > 72 ? '…' : ''));
          send({ t: 'table', name: nm, off: off, hex: h });
        } else {
          s('  ' + nm + ' 读取失败');
        }
      });

      // ④ hook FUN_00179284（签名核心），抓输入输出
      s('');
      s('════ hook FUN_00179284（签名核心）════');
      const CORE = 0x179284;
      const ioList = [];
      try {
        Interceptor.attach(base.add(CORE), {
          onEnter: function (args) {
            // (out, self, std::string* input)
            this.out = args[0];
            this.input = args[2];
            let v = null;
            try {
              const b0 = this.input.readU8();
              if ((b0 & 1) === 0) {
                const len = b0 >> 1;
                if (len > 0 && len <= 22) v = hex(this.input.add(1), len);
              } else {
                const len2 = this.input.add(8).readU64().toNumber();
                if (len2 > 0 && len2 <= 4096) {
                  const ptr = this.input.add(0x10).readPointer();
                  v = hex(ptr, len2);
                }
              }
            } catch (e) {}
            this.inHex = v;
          },
          onLeave: function (rv) {
            let outHex = null;
            try {
              const b0 = this.out.readU8();
              if ((b0 & 1) === 0) {
                const len = b0 >> 1;
                if (len > 0 && len <= 22) outHex = hex(this.out.add(1), len);
              } else {
                const len2 = this.out.add(8).readU64().toNumber();
                if (len2 > 0 && len2 <= 4096) {
                  const ptr = this.out.add(0x10).readPointer();
                  outHex = hex(ptr, len2);
                }
              }
            } catch (e) {}
            if (this.inHex || outHex) {
              const rec = { in: this.inHex, out: outHex };
              ioList.push(rec);
              s('  [IO] in=' + (this.inHex || '').substring(0, 64) +
                '  out=' + (outHex || '')?.substring(0, 64));
            }
          }
        });
        s('  hook 已装 @' + base.add(CORE));
      } catch (e) { s('  hook 失败: ' + e); }

      // ⑤ 调用 signRequest 产生 IO 样本
      s('');
      s('════ 产生 IO 样本 ════');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
          const out = String(H2.signRequest(inp, 0));
          s('  ' + inp + ' → ' + out.substring(0, 44));
        });
      } catch (e) { s('  err: ' + e); }

      s('');
      s('  共捕获 ' + ioList.length + ' 组 IO 对');
      send({ t: 'IO', list: ioList, count: ioList.length });
    });
  }
});
s('[boot] 终局 dump 就绪');
