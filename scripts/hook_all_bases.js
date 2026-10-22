/**
 * ★终极修正：liby 被映射了**两份**（verify_base_bug 实测同一轮内两个 base
 * 都通过 SIG 验证：0x7cb2781000 与 0x7cb2eac000）。
 * 之前 hook 0 命中是因为只 hook 了 findBase 返回的**第一份**（静止副本），
 * 真正执行的是另一份。
 *
 * 本脚本：收集所有通过验证的 base → 每份都做序言扫描 + 全量 hook →
 * 调 signRequest → 记录 (base, offset, 次数)。命中者即真正执行的那份。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

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
function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}
function verifyBase(b) { return hex(b.add(SIG_VADDR), SIG.length/2) === SIG; }

// 收集所有通过验证的 base（去重）
function findAllBases() {
  const seen = {};
  const out = [];
  ANCHORS.forEach(function (anc) {
    const nm = anc[0], va = anc[1], pat = pattern(nm);
    let rs = [];
    try { rs = Process.enumerateRanges('r--'); } catch (e) { return; }
    rs.forEach(function (r) {
      if (r.size < nm.length || r.size > 16*1024*1024) return;
      let hits = null;
      try { hits = Memory.scanSync(r.base, r.size, pat); } catch (e) { return; }
      if (!hits) return;
      hits.forEach(function (h) {
        const b = h.address.sub(va);
        const k = b.toString();
        if (seen[k]) return;
        if (verifyBase(b)) { seen[k] = 1; out.push(b); }
      });
    });
  });
  return out;
}

const PROLOGUES = [
  'fd 7b bf a9', 'fd 7b 01 a9', 'ff 03 01 d1', 'ff 83 00 d1',
  'ff 43 00 d1', 'ff c3 00 d1', 'f6 57 bf a9', 'f6 57 bd a9',
  'f4 4f bf a9', 'fd 03 00 aa',
];

// hits[baseIdx][offset] = count
const hits = {};
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
      try { Java.use('com.huachenjie.c.HcjNative').signRequest('{"warm":1}', 0); } catch (e) {}

      const bases = findAllBases();
      s('★★ 通过验证的 base 数: ' + bases.length);
      bases.forEach(function (b, i) { s('  base[' + i + '] = ' + b); });
      if (!bases.length) { s('✗ 无 base'); return; }

      const SEGS = [
        [0x1000,  0x47000],
        [0x4e000, 0x5d000],
        [0x5e000, 0x61000],
      ];

      bases.forEach(function (base, bi) {
        hits[bi] = {};
        let found = [];
        SEGS.forEach(function (sg) {
          PROLOGUES.forEach(function (pat) {
            try {
              Memory.scanSync(base.add(sg[0]), sg[1] - sg[0], pat).forEach(function (m) {
                const o = m.address.sub(base).toInt32();
                if (o % 4 === 0) found.push(o);
              });
            } catch (e) {}
          });
        });
        found = Array.from(new Set(found)).sort(function (x, y) { return x - y; });
        s('  base[' + bi + '] 序言候选: ' + found.length);

        let ok = 0;
        found.forEach(function (o) {
          try {
            Interceptor.attach(base.add(o), {
              onEnter: function () { hits[bi][o] = (hits[bi][o] || 0) + 1; }
            });
            ok++;
          } catch (e) {}
        });
        s('  base[' + bi + '] 已 hook: ' + ok);
      });

      s('');
      s('════ 调用 signRequest {"probe":1} ════');
      try {
        const out = String(Java.use('com.huachenjie.c.HcjNative').signRequest('{"probe":1}', 0));
        s('  out: ' + out.substring(0, 44));
      } catch (e) { s('  err: ' + e); }

      s('');
      s('════ 触发统计 ════');
      bases.forEach(function (b, bi) {
        const ks = Object.keys(hits[bi]).sort(function (x, y) { return hits[bi][y] - hits[bi][x]; });
        s('── base[' + bi + '] ' + b + '  触发 ' + ks.length + ' 个函数:');
        ks.forEach(function (k) {
          s('    +0x' + Number(k).toString(16) + '  ×' + hits[bi][k]);
        });
      });
      send({ t: 'hits', bases: bases.map(String), hits: hits });
    });
  }
});
s('[boot] 多 base 全量 hook 就绪');
