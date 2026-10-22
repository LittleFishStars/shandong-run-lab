/**
 * v17 终局（合并修正）：
 *   ① 修正 base 反推 —— .bss 超出 r-x 段，需枚举 rw 段定位表
 *   ② 同时 hook 两条链：
 *      A) libNetHTProtect.so: signRequest(+0x24926c) / core(+0x34b820) / slot0(+0x179284)
 *      B) libnesec/892KB 段: FUN_0009fb70 / MD5(FUN_000b6a04) / FUN_00083560 / FUN_000a3460
 *        （report/10 用触发追踪法发现的链）
 *   ③ dump libNetHTProtect 的全部 rw 段内容（找表实际位置）
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

let jniTable = null;
Java.perform(function () {
  try {
    const env = Java.vm.getEnv();
    jniTable = env.handle.readPointer();
    const gv = new NativeFunction(jniTable.add(4 * 8).readPointer(), 'int', ['pointer']);
    s('[cal] ' + '0x' + (gv(jniTable) >>> 0).toString(16));
  } catch (e) { s('[cal] err: ' + e); }
});

function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}
function jstr(js) {
  try {
    if (!jniTable || !js || js.isNull()) return null;
    const G = new NativeFunction(jniTable.add(169 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer']);
    const R = new NativeFunction(jniTable.add(170 * 8).readPointer(), 'void', ['pointer', 'pointer', 'pointer']);
    const c = G(jniTable, js, ptr(0));
    const v = c.readUtf8String();
    R(jniTable, js, c);
    return v;
  } catch (e) { return null; }
}

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
let done = false;
const io = [];

function work(fn) {
  if (done) return; done = true;
  s('★ signRequest fn = ' + fn);

  // ══ ① 用 fn 精确反推 base，并枚举其附近所有段 ══
  let base = null;
  [0x24926c, 0x2493ac].forEach(function (off) {
    if (base) return;
    const c = fn.sub(off);
    const h = hex(c.add(0x11c9a0), 16);
    if (h && h !== '0'.repeat(32)) base = c;
  });
  if (!base) { s('✗ base 失败'); return; }
  s('★★ base = ' + base);
  send({ t: 'base', base: String(base) });

  // 枚举 base 起 6MB 内的所有段
  s('');
  s('════ base 附近所有段（找 .bss / rw）════');
  const near = [];
  try {
    ['r--', 'rw-', 'r-x', 'rwx'].forEach(function (p2) {
      Process.enumerateRanges(p2).forEach(function (r) {
        const d = r.base.sub(base);
        const off = d.toInt32();
        if (off >= -0x1000 && off < 0x600000) {
          near.push({ base: r.base, size: r.size, prot: r.protection, off: off });
        }
      });
    });
  } catch (e) {}
  near.sort(function (a, b) { return a.off - b.off; });
  near.forEach(function (r) {
    s('  +0x' + r.off.toString(16) + '  ' + r.base + '  sz=0x' + r.size.toString(16) +
      '  ' + r.prot) ;
  });

  // 在「距 base offset 最大的 rw- 段」里找表（表偏移 0x47c9b8）
  s('');
  s('════ 定位密钥表（期望偏移 0x47c9b8 / 0x47cdb8 / 0x47d1b8 / 0x47d5b8）════');
  const wantOffs = [0x47c970, 0x47c9b0, 0x47c9b8, 0x47cdb8, 0x47d1b8, 0x47d5b8];
  const rwSegs = near.filter(function (r) { return r.prot.indexOf('w') >= 0; });
  s('  rw- 段数: ' + rwSegs.length);
  let tableBase = null;
  // 表可能在 base+0x47c9b8（若整体映射）或独立段
  const tryAddrs = [];
  tryAddrs.push(base.add(0x47c9b8));
  rwSegs.forEach(function (r) {
    // 段起点与 base 的差如果是 0x47c000 量级
    tryAddrs.push(r.base);
    tryAddrs.push(r.base.add(0x1000));
  });
  wantOffs.forEach(function (off) {
    const a2 = base.add(off);
    const h = hex(a2, 32);
    s('  base+0x' + off.toString(16) + ' = ' + a2 + '  ' + (h || '不可读'));
  });
  rwSegs.forEach(function (r, i) {
    if (i >= 4) return;
    const h = hex(r.base, 64);
    s('  rw段[' + i + '] ' + r.base + '  ' + (h || '不可读'));
    if (!tableBase && h && h !== '0'.repeat(128)) tableBase = r.base;
  });

  // ══ ② 双链 hook ══
  s('');
  s('════ 安装双层 hook ════');
  const CHAINS = [
    ['A:signRequest', base.add(0x24926c), 'jni'],
    ['A:core',        base.add(0x24b820), 'stdstr'],
    ['A:slot0',       base.add(0x079284), 'stdstr'],
  ];
  // B 链：892KB 易盾段（含 FUN_0009fb70/MD5/FUN_00083560/FUN_000a3460）
  // 用「唯一的 MD5 字节序列」定位该段
  try {
    const md5sig = 'ff8300d1912c40f98d2840f9ab0040f9';   // FUN_000b6a04 序言（report/09）
    Process.enumerateRanges('r-x').forEach(function (r) {
      if (r.size < 800000 || r.size > 1000000) return;   // 892KB 段
      let hits = null;
      try { hits = Memory.scanSync(r.base, r.size, md5sig.match(/../g).join(' ')); } catch (e) { return; }
      if (hits && hits.length) {
        s('  找到 892KB 段 @' + r.base + ' sz=0x' + r.size.toString(16) + ' (md5sig ×' + hits.length + ')');
        CHAINS.push(['B:md5', hitAddrToBase(r.base, hits[0].address), 'none']);
        // 同段的其它锚点：+0x9fb70 / +0x83560 / +0xa3460（report/10 结论）
        ['9fb70', '83560', 'a3460'].forEach(function (off) {
          CHAINS.push(['B:' + off, r.base.add(parseInt(off, 16)), 'none']);
        });
      }
    });
  } catch (e) { s('  B 链定位 err: ' + e); }
  function hitAddrToBase(segBase, addr) { return addr; }   // 直接用命中地址

  CHAINS.forEach(function (c) {
    try {
      Interceptor.attach(c[1], {
        onEnter: function (args) {
          const tag = c[0];
          if (c[2] === 'jni') {
            const j = jstr(args[2]);
            s('  ► ' + tag + ' ENTER json=' + JSON.stringify((j || '').substring(0, 56)) + ' env=' + args[3].toInt32());
            io.push({ tag: tag, in: j, env: args[3].toInt32() });
          } else {
            s('  ► ' + tag + ' 被调用');
            io.push({ tag: tag, hit: 1 });
          }
        },
        onLeave: function (rv) {
          if (c[2] === 'jni') {
            const o = jstr(rv);
            s('  ◄ ' + c[0] + ' LEAVE → ' + JSON.stringify((o || '').substring(0, 56)));
            io.push({ tag: c[0], out: o });
          }
        }
      });
      s('  ✓ hook ' + c[0] + ' @' + c[1] + ' (+0x' + c[1].sub(base).toString(16) + ')');
    } catch (e) { s('  ✗ ' + c[0] + ': ' + e); }
  });

  // ══ ③ 样本 ══
  s('');
  s('════ 样本 ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    ['{"probe":1}', '{}'].forEach(function (inp) {
      s('  ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 48));
    });
  } catch (e) { s('  ' + e); }
  s('  记录 ' + io.length + ' 条');
  send({ t: 'R', io: io, near: near.map(function (r) { return { off: r.off, prot: r.prot, size: r.size }; }) });
}

Java.perform(function () {
  if (!jniTable) return;
  try {
    Interceptor.attach(jniTable.add(215 * 8).readPointer(), {
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
            if (fn && !fn.isNull()) { work(fn); return; }
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RN hook OK');
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
        s('[DC] ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) {}
    });
  }
});
s('[boot] v17 就绪');
