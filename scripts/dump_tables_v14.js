/**
 * v14：用 RegisterNatives 拿到的 signRequest 指针作为锚点 → 反推基址 → dump 表。
 *
 * 教训：
 *   · liby.so / libNetHTProtect.so 的 r-x 段在 Frida 的 enumerateRanges 里没有
 *     file 字段（壳用的自定义 linker 不登记路径），不能用 path 匹配
 *   · 但 RegisterNatives 给出的 fnPtr 是**精确**的
 *
 * 本法：
 *   ① hook RegisterNatives，按签名 '(Ljava/lang/String;I)Ljava/lang/String;' 匹配
 *      → 得到 signRequest 的 fnPtr（上轮已在 libNetHTProtect+0x24926c 命中）
 *   ② 用已知静态偏移反推 base = fnPtr - 0x24926c
 *   ③ 用 base 定位并 dump 4 张表（.bss：+0x47c9b8 / +0x47cdb8 / +0x47d1b8 / +0x47d5b8）
 *   ④ hook 核心函数 +0x179284，抓 IO 对
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
function rdStdStr(p) {
  try {
    const b0 = p.readU8();
    if ((b0 & 1) === 0) {
      const len = b0 >> 1;
      if (len <= 0 || len > 22) return null;
      return hex(p.add(1), len);
    }
    const len = p.add(8).readU64().toNumber();
    if (len <= 0 || len > 8192) return null;
    return hex(p.add(16).readPointer(), len);
  } catch (e) { return null; }
}

const SIG_SIGNREQ = '(Ljava/lang/String;I)Ljava/lang/String;';
let signFn = null, signFn2 = null;
const ioList = [];

Java.perform(function () {
  // ══ ① RegisterNatives hook 抓 signRequest 指针 ══
  let table = null;
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    const ver = gv(table) >>> 0;
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败'); return; }
    s('[cal] JNIEnv OK 0x' + ver.toString(16));
  } catch (e) { s('[cal] err: ' + e); return; }

  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a2) {
        try {
          const arr = a2[2], cnt = a2[3].toInt32();
          if (cnt <= 0 || cnt > 600) return;
          for (let i = 0; i < cnt; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            if (sig !== SIG_SIGNREQ) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (!fn || fn.isNull()) continue;
            if (!signFn) signFn = fn; else if (!signFn2 && !fn.equals(signFn)) signFn2 = fn;
            const r = Process.findRangeByAddress(fn);
            s('★★ signRequest 指针 = ' + fn + '  ' +
              (r ? ('段=' + r.base + ' sz=0x' + r.size.toString(16)) : '?'));
            send({ t: 'fn', fn: String(fn), seg: r ? String(r.base) : null, segSize: r ? r.size : 0 });
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RegisterNatives hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a2) {
    if (fired) return;
    let d = ''; try { d = a2[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;

    Java.perform(function () {
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) { s('warm err: ' + String(e).substring(0, 70)); }

      if (!signFn) { s('✗ 未捕获 signRequest 指针'); return; }

      // ══ ② 反推基址（静态偏移 0x24926c）══
      const OFFSETS = [0x24926c, 0x2493ac];
      let base = null;
      for (let i = 0; i < OFFSETS.length; i++) {
        const cand = signFn.sub(OFFSETS[i]);
        s('  候选 base (偏移 0x' + OFFSETS[i].toString(16) + ') = ' + cand);
        // 验证：读 .text 起始处应为 ELF 代码（非零）
        const h = hex(cand.add(0x11c9a0), 16);
        s('    .text 头 16 字节: ' + h);
        if (h && h !== '00000000000000000000000000000000') { base = cand; break; }
      }
      if (!base) { s('✗ 基址反推失败'); return; }
      s('★★ libNetHTProtect base = ' + base);

      // ══ ③ dump 运行时表 ══
      s('');
      s('════ 运行时表 dump ════');
      const TABLES = [
        ['delta_key', 0x47c970, 0x40],
        ['whiteT0',   0x47c9b0, 0x10],
        ['T1',        0x47c9b8, 0x400],
        ['T2',        0x47cdb8, 0x400],
        ['T3',        0x47d1b8, 0x400],
        ['T4',        0x47d5b8, 0x400],
      ];
      TABLES.forEach(function (t) {
        const h = hex(base.add(t[1]), t[2]);
        if (h) {
          s('  ' + t[0].padEnd(10) + '  ' + h.substring(0, 64) + '…');
          send({ t: 'table', name: t[0], off: t[1], hex: h });
        } else s('  ' + t[0] + ' 读取失败');
      });

      // ══ ④ hook 核心函数抓 IO ══
      s('');
      s('════ hook 核心 +0x179284 ════');
      try {
        Interceptor.attach(base.add(0x179284), {
          onEnter: function (args) { this.out = args[0]; this.in = args[2]; this.ih = rdStdStr(args[2]); },
          onLeave: function () {
            const oh = rdStdStr(this.out);
            if (this.ih || oh) {
              ioList.push({ in: this.ih, out: oh });
              s('  [IO] in=' + (this.ih || '').substring(0, 56) + '  out=' + (oh || '').substring(0, 56));
            }
          }
        });
        s('  hook OK');
      } catch (e) { s('  hook err: ' + e); }

      s('');
      s('════ 产生样本 ════');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
          s('  ' + inp + ' → ' + String(H2.signRequest(inp, 0)).substring(0, 44));
        });
      } catch (e) { s('  err: ' + e); }

      s('  IO 对数: ' + ioList.length);
      send({ t: 'IO', list: ioList, count: ioList.length });
    });
  }
});
s('[boot] v14 就绪');
