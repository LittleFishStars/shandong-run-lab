/**
 * 排查基址验证 bug：上轮 base=0x7cb2845000，但 diff_maps 的新增段在
 * 0x7cb2784000~0x7cb27e8000。两轮 run 的 ASLR 值不同——需要确认
 * findBase 到底验证了什么。本轮：dump 所有候选 base 及其验证详情，
 * 同时对比 /proc/self/maps 中 liby 相关的真实映射。
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

      s('════ ① 锚点扫描：每个锚点串的所有出现位置 ════');
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
            const sigOK = hex(b.add(SIG_VADDR), SIG.length/2) === SIG;
            s('  "' + nm + '" @' + h.address + ' → cand-base ' + b + '  sig=' + (sigOK ? '✓' : '✗'));
          });
        });
      });

      s('');
      s('════ ② /proc/self/maps 中的匿名 exec 段（0x7cb2xxxxxx 附近）════');
      try {
        const maps = File.readAllText('/proc/self/maps').split('\n');
        maps.forEach(function (line) {
          if (line.indexOf('x') === 18 && line.indexOf('/data') < 0 && line.indexOf('system') < 0 && line.indexOf('vendor') < 0 && line.indexOf(' framew') < 0) {
            // 匿名 exec 段
            if (line.indexOf('7cb') >= 0 || line.indexOf('7c') >= 0) s('  ' + line.trim());
          }
        });
      } catch (e) { s('  maps 读失败: ' + e); }

      s('');
      s('════ ③ liby 段权限验证（按 report/11 应为 #1@0 R-E / #2@0x4e000 R-E / #3@0x64af8 RW）════');
      // 尝试两个候选 base
      const cands = ['0x7cb2783000', '0x7cb2845000'];
      cands.forEach(function (cb) {
        const b = ptr(cb);
        const t1 = hex(b.add(0x1000), 8), t2 = hex(b.add(0x4e000), 8), t3 = hex(b.add(0x23000), 8);
        s('  cand ' + cb + ': +0x1000=' + t1 + ' +0x4e000=' + t2 + ' +0x23000=' + t3);
      });
    });
  }
});
s('[boot] 基址排查就绪');
