/**
 * 在解密后的 liby.so 代码段关键函数下断点，抓 signRequest 的 80 字节拼装过程。
 *
 * 依据（report/11 §6.1f）：
 *   · liby.so 基址可用「锚点+磁盘签名」双验证确定
 *   · 解密后的代码在 base+0x1d000 .. base+0x41000（160 KB，248 函数）
 *   · 字符串表在 base+0x14300 附近：
 *       0x14310 "userToken":"   0x14b94 "signKey":"
 *       0x14ba0 "satoken":"     0x14f0e "encKey":"
 *   · PIC 扫描得出引用这些串的候选函数（vaddr，需 +base）：
 *       FUN_00042d54 (4788 B) ← 最多引用
 *       FUN_000457b4 / FUN_00044254 / FUN_000421a0 / FUN_00023118
 *
 * 策略：对这些函数入口全部下 hook，并在 onLeave 记录返回值
 *（返回值可能是 std::string*，按 libc++ SSO 解析）。
 * 同时 hook libc 的 memcpy/strlen 观察数据流。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

// ── 基址定位（锚点 + 磁盘签名双验证）──
const SIG = 'ff8300d1912c40f98d2840f9ab0040f9f35300a9f50b00f93f020debac0840b9';
const SIG_VADDR = 0x5b5f0;
const ANCHORS = [
  ['/proc/self/maps', 0x5f780],
  ['LD_PRELOAD',      0x5f7d8],
  ['dl_iterate_phdr', 0x5f860],
];
function pattern(str) {
  let o = [];
  for (let i = 0; i < str.length; i++) o.push(('0' + str.charCodeAt(i).toString(16)).slice(-2));
  return o.join(' ');
}
function verifyBase(b) {
  try {
    const p = b.add(SIG_VADDR), n = SIG.length / 2;
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h === SIG;
  } catch (e) { return false; }
}
function findBase() {
  for (let i = 0; i < ANCHORS.length; i++) {
    const nm = ANCHORS[i][0], va = ANCHORS[i][1], pat = pattern(nm);
    let rs = [];
    try { rs = Process.enumerateRanges('r--'); } catch (e) { break; }
    for (let j = 0; j < rs.length; j++) {
      const r = rs[j];
      if (r.size < nm.length || r.size > 64*1024*1024) continue;
      let hits = null;
      try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { continue; }
      if (!hits) continue;
      for (let k = 0; k < hits.length; k++) {
        const b = hits[k].address.sub(va);
        if (verifyBase(b)) return b;
      }
    }
  }
  return null;
}

// libc++ std::string 读取（SSO：bit0==0 时 len=*p>>1，数据在 p+1）
function readStdString(p) {
  try {
    const b0 = p.readU8();
    if ((b0 & 1) === 0) {
      const len = b0 >> 1;
      if (len === 0) return '';
      if (len > 22) return null;    // SSO 上限 22
      const bytes = new Uint8Array(p.add(1).readByteArray(len));
      let out = '';
      for (let i = 0; i < len; i++) out += String.fromCharCode(bytes[i]);
      return out;
    } else {
      const len = p.add(8).readU64().toNumber();
      if (len === 0 || len > 4096) return null;
      const ptr = p.add(0x10).readPointer();
      const bytes = new Uint8Array(ptr.readByteArray(Math.min(len, 512)));
      let out = '';
      for (let i = 0; i < bytes.length; i++) out += String.fromCharCode(bytes[i]);
      return out;
    }
  } catch (e) { return null; }
}

function hexOf(addr, len) {
  try {
    const by = new Uint8Array(addr.readByteArray(len));
    let h = '';
    for (let i = 0; i < len; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}

// 候选函数（vaddr）
const CANDS = [
  [0x42d54, 'JSON构造器(4788B)'],
  [0x457b4, 'FUN_457b4(1012B)'],
  [0x44254, 'FUN_44254(752B)'],
  [0x421a0, 'FUN_421a0(544B)'],
  [0x23118, 'std::string操作(1148B)'],
  [0x4187c, 'FUN_4187c(292B)'],
  [0x25154, 'FUN_25154(964B)'],
  [0x29f94, 'FUN_29f94(76B)'],
  [0x29fe0, 'FUN_29fe0(100B)'],
];

const hits = {};
let base = null;
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
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        N.signRequest('{"probe":1}', 0);
        s('native 已加载');
      } catch (e) {}

      base = findBase();
      if (!base) { s('✗ 未定位基址'); return; }
      s('★ 基址 = ' + base);

      s('');
      s('════ 对 ' + CANDS.length + ' 个候选函数下 hook ════');
      let ok = 0;
      CANDS.forEach(function (c) {
        const va = c[0], nm = c[1];
        try {
          Interceptor.attach(base.add(va), {
            onEnter: function (args) {
              const k = '0x' + va.toString(16);
              const rec = hits[k] || (hits[k] = { name: nm, n: 0, io: [] });
              rec.n++;
              // 尝试把前 4 个参数按 std::string* 解析
              let strs = [];
              for (let i = 0; i < 4; i++) {
                const p = args[i];
                if (!p || p.isNull()) continue;
                const v = readStdString(p);
                if (v !== null && v.length > 0 && /^[\x20-\x7e]*$/.test(v))
                  strs.push('arg' + i + '="' + v.substring(0, 80) + '"');
              }
              if (strs.length && rec.io.length < 6)
                rec.io.push({ dir: 'in', args: strs });
              this.rec = rec;
            },
            onLeave: function (rv) {
              if (!this.rec) return;
              // 返回值可能是 std::string*（x0）
              if (!rv.isNull()) {
                const v = readStdString(rv);
                if (v !== null && v.length > 0 && /^[\x20-\x7e]*$/.test(v)) {
                  if (this.rec.io.length < 12)
                    this.rec.io.push({ dir: 'out', val: v.substring(0, 200) });
                }
              }
            }
          });
          ok++;
        } catch (e) {}
      });
      s('  已装 ' + ok + ' 个');

      // ── 调用 signRequest 观察 ──
      s('');
      s('════ 调用 signRequest（多次，捕捉稳定模式）════');
      try {
        const N2 = Java.use('com.huachenjie.c.HcjNative');
        ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
          const out = String(N2.signRequest(inp, 0));
          s('  ' + inp + ' → ' + out.substring(0, 44) + '...');
        });
      } catch (e) { s('  调用失败: ' + e); }

      s('');
      s('════ 触发统计 ════');
      Object.keys(hits).sort(function (x, y) { return hits[y].n - hits[x].n; }).forEach(function (k) {
        const r = hits[k];
        s('  ' + k + '  ' + r.name + '  ×' + r.n);
        r.io.slice(0, 6).forEach(function (e) {
          if (e.dir === 'in') s('       IN  ' + e.args.join('  '));
          else s('       OUT ' + JSON.stringify(e.val));
        });
      });
      send({ t: 'hits', base: base.toString(), hits: hits });
    });
  }
});
s('[boot] 80 字节拼装追踪就绪');
