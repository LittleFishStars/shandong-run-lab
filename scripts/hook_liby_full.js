/**
 * v9：修正 v6 的致命缺陷 —— 每段只 hook 了前 200 个序言！
 *
 * v6 事实：候选 21 段，已 hook 总数 1800，但每段被 `Math.min(..., 200)` 截断。
 * liby.so 的 284KB 段函数数远超 200，真正入口可能在被截断的后半部分。
 *
 * 本版：
 *   ① 只针对 liby.so 的 3 个 r-x 段（由 enumerateRanges 的 file.path 识别）
 *   ② 全量无上限序言 hook（预计 400~800 个，Frida 可承受）
 *   ③ 附带 Stalker 有效性自检：记录**所有** block（不过滤），若连系统库
 *      地址都记不到，说明 Stalker 在本设备失效（壳反调试）
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
  'f7 0b 00 f9', 'fc 6f ba a9', 'ff 03 02 d1', 'ff 83 01 d1',
];

const hits = {};
const segHooked = {};   // base -> count
let total = 0;

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
      // ── ① 先 warm，确保 liby 已加载（它由首次调用触发加载） ──
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('warm1: ' + String(H.signRequest('{"w":1}', 0)).substring(0, 16));
      } catch (e) { s('warm err: ' + e); }

      // ── ② 找 liby.so 的全部 r-x 段 ──
      let libySegs = [];
      try {
        Process.enumerateRanges('r-x').forEach(function (r) {
          const p = r.file ? r.file.path : '';
          if (p.indexOf('liby.so') >= 0) {
            libySegs.push(r);
            s('liby r-x: ' + r.base + '  ' + (r.size/1024).toFixed(0) + 'KB');
          }
        });
      } catch (e) { s('枚举 err: ' + e); }
      if (!libySegs.length) { s('✗ 无 liby r-x 段'); return; }

      // ── ③ 全量序言扫描 + hook（无 200 上限） ──
      s('');
      s('════ 全量序言 hook ════');
      libySegs.forEach(function (r) {
        const key = r.base.toString();
        segHooked[key] = 0;
        let found = [];
        PROLOGUES.forEach(function (pat) {
          try {
            Memory.scanSync(r.base, r.size, pat).forEach(function (m) {
              const o = m.address.sub(r.base).toInt32();
              if (o % 4 === 0) found.push(o);
            });
          } catch (e) {}
        });
        found = Array.from(new Set(found)).sort(function (x, y) { return x - y; });
        s('  ' + key + ' (' + (r.size/1024).toFixed(0) + 'KB) 序言候选 ' + found.length);
        let ok = 0;
        found.forEach(function (o) {
          try {
            Interceptor.attach(r.base.add(o), {
              onEnter: function () {
                const k = key + '|' + o;
                hits[k] = (hits[k] || 0) + 1;
              }
            });
            ok++; total++;
          } catch (e) {}
        });
        segHooked[key] = ok;
        s('    已 hook ' + ok + '/' + found.length);
      });
      s('  合计 hook: ' + total);

      // ── ④ Stalker 自检（记录所有 block，判断是否可用） ──
      let stalkTotal = 0, stalkNonSys = 0;
      const sysPfx = ['/system/', '/apex/', '/vendor/', 'odex', 'vdex', 'oat', 'libart', 'frida', 'ashmem'];
      let stalkOK = false;
      try {
        const tid = Process.getCurrentThreadId();
        Stalker.follow(tid, {
          events: { call: false, ret: false, exec: false, block: false, compile: true },
          transform: function (iterator) {
            let ins = iterator.next();
            if (ins === null) return;
            stalkTotal++;
            let p = '';
            try { const rr = Process.findRangeByAddress(ins.address); p = rr && rr.file ? rr.file.path : ''; } catch (e) {}
            if (!sysPfx.some(function (x) { return p.indexOf(x) >= 0; })) stalkNonSys++;
          }
        });
        stalkOK = true;
      } catch (e) { s('  Stalker 启动失败: ' + e); }

      // ── ⑤ 调用并观察 ──
      s('');
      s('════ 调用 signRequest ════');
      try {
        const H2 = Java.use('com.huachenjie.c.HcjNative');
        ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
          const out = String(H2.signRequest(inp, 0));
          s('  ' + inp + ' → ' + out.substring(0, 40));
        });
      } catch (e) { s('  err: ' + e); }

      if (stalkOK) {
        try { Stalker.unfollow(Process.getCurrentThreadId()); Stalker.flush(); } catch (e) {}
        s('  Stalker 自检: 总 block=' + stalkTotal + '  非系统 block=' + stalkNonSys +
          (stalkTotal === 0 ? '  ⇒ ★Stalker 在本设备失效（反调试）' : '  ⇒ Stalker 可用'));
      }

      // ── ⑥ 命中统计 ──
      s('');
      s('════ 命中 ════');
      const ks = Object.keys(hits).sort(function (x, y) { return hits[y] - hits[x]; });
      if (!ks.length) s('  （全 0）');
      ks.slice(0, 50).forEach(function (k) {
        const parts = k.split('|');
        s('  ' + parts[0] + ' +0x' + Number(parts[1]).toString(16) + '  ×' + hits[k]);
      });
      send({ t: 'hits', hits: hits, hooked: segHooked, total: total,
             stalkTotal: stalkTotal, stalkNonSys: stalkNonSys });

      // ── ⑦ dump 命中点所在段 ──
      const dumpBases = {};
      ks.slice(0, 3).forEach(function (k) { dumpBases[k.split('|')[0]] = 1; });
      Object.keys(dumpBases).forEach(function (by) {
        try {
          const base = ptr(by);
          const r = Process.findRangeByAddress(base.add(0x100));
          const size = r ? Math.min(r.size, 512 * 1024) : 512 * 1024;
          send({ t: 'dumpmeta', base: by, size: size });
          s('dump ' + by + ' size=' + size);
          const CHUNK = 200 * 1024;
          for (let off = 0; off < size; off += CHUNK) {
            const sz = Math.min(CHUNK, size - off);
            send({ t: 'chunk', off: off, size: sz }, base.add(off).readByteArray(sz));
          }
        } catch (e) { s('  dump err: ' + e); }
      });
    });
  }
});
s('[boot] v9 全量 hook + Stalker 自检就绪');
