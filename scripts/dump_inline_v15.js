/**
 * v15：修正时序 —— 在「收到 signRequest 指针之后」才做 dump/IO 采集。
 *
 * v14 教训：
 *   · 指针确实拿到了（0x7ca7d5926c，段 0x7ca7b10000 sz=0x468000）
 *   · 但 DefineClass 触发点早于该注册 → 那一刻 signFn 还是 null
 *   · Frida QuickJS 的 setTimeout 在本环境不可靠 → 用 Interceptor 轮询
 *
 * 本法：在 RegisterNatives 命中 signRequest 的**同一回调内**立即完成
 * 基址反推 + 表 dump + 核心 hook，然后返回。
 * 之后由宿主再触发几次 signRequest 产生 IO 样本。
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

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFFSETS = [0x24926c, 0x2493ac];
let done = false;
let coreHooked = false;
let base = null;
const ioList = [];

function postProcessing(fn, batchInfo) {
  if (done) return;
  done = true;
  s('');
  s('════ 收到 signRequest 指针，立即处理 ════');
  s('  fn = ' + fn);
  const r = Process.findRangeByAddress(fn);
  s('  段 = ' + (r ? r.base + ' sz=0x' + r.size.toString(16) : '?'));

  // ① 反推基址
  for (let i = 0; i < OFFSETS.length; i++) {
    const cand = fn.sub(OFFSETS[i]);
    const h = hex(cand.add(0x11c9a0), 16);      // .text 起始
    s('  候选 base(0x' + OFFSETS[i].toString(16) + ') = ' + cand + '  .text头=' + h);
    if (h && h !== '00000000000000000000000000000000') { base = cand; break; }
  }
  if (!base) { s('  ✗ 基址反推失败'); return; }
  s('  ★★ base = ' + base);
  send({ t: 'base', base: String(base) });

  // ② dump 运行时表（.bss）
  s('');
  s('════ 运行时表 ════');
  [['delta_key', 0x47c970, 0x40], ['whiteT0', 0x47c9b0, 0x10],
   ['T1', 0x47c9b8, 0x400], ['T2', 0x47cdb8, 0x400],
   ['T3', 0x47d1b8, 0x400], ['T4', 0x47d5b8, 0x400]].forEach(function (t) {
    const h = hex(base.add(t[1]), t[2]);
    if (h) {
      s('  ' + t[0].padEnd(10) + ' +0x' + t[1].toString(16) + '  ' + h.substring(0, 64) + '…');
      send({ t: 'table', name: t[0], off: t[1], hex: h });
    } else s('  ' + t[0] + ' 读失败');
  });

  // ③ hook 核心
  s('');
  s('════ hook 核心 +0x179284 ════');
  try {
    Interceptor.attach(base.add(0x179284), {
      onEnter: function (args) { this.out = args[0]; this.ih = rdStdStr(args[2]); },
      onLeave: function () {
        const oh = rdStdStr(this.out);
        if (this.ih || oh) {
          ioList.push({ in: this.ih, out: oh });
          s('  [IO] in=' + (this.ih || '').substring(0, 48) + '  out=' + (oh || '').substring(0, 48));
        }
      }
    });
    coreHooked = true;
    s('  ✓ hook OK');
  } catch (e) { s('  hook err: ' + e); }

  // ④ 立刻调一次产生样本
  s('');
  s('════ 立即产生样本 ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    ['{"probe":1}', '{}'].forEach(function (inp) {
      s('  ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 44));
    });
  } catch (e) { s('  err: ' + e); }
  s('  IO 对数: ' + ioList.length);
  send({ t: 'IO', list: ioList, count: ioList.length, coreHooked: coreHooked });
}

// ══ RegisterNatives hook ══
Java.perform(function () {
  let table = null;
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    const ver = gv(table) >>> 0;
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败'); return; }
    s('[cal] OK');
  } catch (e) { s('[cal] err: ' + e); return; }

  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a2) {
        if (done) return;
        try {
          const arr = a2[2], cnt = a2[3].toInt32();
          if (cnt <= 0 || cnt > 600) return;
          for (let i = 0; i < cnt; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            if (sig !== SIG) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (!fn || fn.isNull()) continue;
            s('★ 命中 signRequest 签名，批次 ' + cnt + ' 个方法，idx=' + i);
            postProcessing(fn, cnt);
            return;
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RN hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

// ══ DefineClass 触发器 ══
const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a2) {
    if (fired) return;
    let d = ''; try { d = a2[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;
    s('[DC] ' + d);
    Java.perform(function () {
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('  warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) { s('  warm err: ' + String(e).substring(0, 60)); }
      if (!done) s('  （此刻 signRequest 尚未注册，等后续批次）');
    });
  }
});
s('[boot] v15 就绪');
