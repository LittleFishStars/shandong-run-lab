/**
 * v6：全 r-x 段暴力序言 hook（终局定位法）。
 *
 * 已确认事实（累积）：
 *   · JNIEnv 布局 = A：table = env.handle.readPointer()，GetVersion=0x10006 ✓
 *   · FindClass 会触发壳 abort（防篡改）→ 禁用该路径
 *   · 通过磁盘签名验证的 liby 映射（2 份）上全部序言函数 0 触发
 *   · trampoline 存活实验证明不是「被重解密抹掉」
 *   ⇒ 实现代码必然在**另一个** r-x 段里
 *
 * 本法：枚举所有 50KB~2MB 的 r-x 段，每段扫描 AArch64 序言并 hook（总量上限
 * 1800 个），然后调 signRequest，报出命中的 (段, 偏移)，并 dump 该段。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const PROLOGUES = [
  'fd 7b bf a9', 'fd 7b 01 a9', 'ff 03 01 d1', 'ff 83 00 d1',
  'ff 43 00 d1', 'ff c3 00 d1', 'f6 57 bf a9', 'f6 57 bd a9',
  'f4 4f bf a9', 'fd 03 00 aa', 'ff 07 01 d1', 'f8 5f bc a9',
];

const hits = {};          // "base|off" -> count
const segInfo = {};       // base -> {size, prot, path, n}
let totalHooked = 0;
const LIMIT = 1800;

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
      // 先建一个基础调用，确保 native 已注册
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) { s('warm err: ' + e); }

      // ── 枚举候选 r-x 段 ──
      let ranges = [];
      try { ranges = Process.enumerateRanges('r-x'); } catch (e) { s('枚举失败: ' + e); return; }
      const cands = [];
      ranges.forEach(function (r) {
        if (r.size < 50 * 1024 || r.size > 2 * 1024 * 1024) return;
        const p = r.file ? r.file.path : '';
        // 排除系统库与已知大模块
        if (p.indexOf('/system/') >= 0 || p.indexOf('/apex/') >= 0) return;
        if (p.indexOf('libart') >= 0 || p.indexOf('libc') >= 0) return;
        cands.push(r);
      });
      s('候选 r-x 段: ' + cands.length + ' 个（50KB~2MB，非系统库）');
      cands.forEach(function (r, i) {
        const p = r.file ? r.file.path.split('/').pop() : '[anon]';
        s('  [' + i + '] ' + r.base + '  ' + (r.size/1024).toFixed(0) + 'KB  ' + p);
      });

      // ── 逐段扫描 + hook ──
      cands.forEach(function (r, idx) {
        if (totalHooked >= LIMIT) return;
        const key = r.base.toString();
        segInfo[key] = { idx: idx, size: r.size, path: (r.file ? r.file.path : '[anon]'), n: 0 };
        let found = [];
        PROLOGUES.forEach(function (pat) {
          if (totalHooked + found.length >= LIMIT) return;
          try {
            Memory.scanSync(r.base, r.size, pat).forEach(function (m) {
              const o = m.address.sub(r.base).toInt32();
              if (o % 4 === 0) found.push(o);
            });
          } catch (e) {}
        });
        found = Array.from(new Set(found)).sort(function (x, y) { return x - y; });
        const room = Math.min(found.length, LIMIT - totalHooked, 200);
        for (let i = 0; i < room; i++) {
          const o = found[i];
          try {
            Interceptor.attach(r.base.add(o), {
              onEnter: function () {
                const k = key + '|' + o;
                hits[k] = (hits[k] || 0) + 1;
              }
            });
            totalHooked++;
            segInfo[key].n++;
          } catch (e) {}
        }
      });
      s('已 hook 总数: ' + totalHooked);

      // ── 调用 signRequest ──
      s('');
      s('════ 调用 signRequest ════');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        ['{"probe":1}', '{}'].forEach(function (inp) {
          const out = String(H2.signRequest(inp, 0));
          s('  ' + inp + ' → ' + out.substring(0, 40));
        });
      } catch (e) { s('  调用 err: ' + e); }

      // ── 命中统计 ──
      s('');
      s('════ 命中 ════');
      const ks = Object.keys(hits).sort(function (x, y) { return hits[y] - hits[x]; });
      if (!ks.length) s('  （全 0——实现不在这些段）');
      const hitSegs = {};
      ks.forEach(function (k) {
        const parts = k.split('|');
        const by = parts[0], off = parseInt(parts[1]);
        s('  ' + by + ' +0x' + off.toString(16) + '  ×' + hits[k]);
        if (!hitSegs[by]) hitSegs[by] = { size: segInfo[by] ? segInfo[by].size : 0, ofs: [] };
        hitSegs[by].ofs.push(off);
      });
      send({ t: 'hits', hits: hits, segs: segInfo });

      // ── dump 命中段 ──
      Object.keys(hitSegs).forEach(function (by) {
        try {
          const base = ptr(by), size = hitSegs[by].size;
          const total = Math.min(size, 512 * 1024);
          s('dump ' + by + ' size=' + total);
          send({ t: 'dumpmeta', base: by, size: total });
          const CHUNK = 200 * 1024;
          for (let off = 0; off < total; off += CHUNK) {
            const sz = Math.min(CHUNK, total - off);
            send({ t: 'chunk', off: off, size: sz }, base.add(off).readByteArray(sz));
          }
        } catch (e) { s('  dump err: ' + e); }
      });
    });
  }
});
s('[boot] v6 全段暴力 hook 就绪');
