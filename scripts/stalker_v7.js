/**
 * v7：Stalker 绑定到正确线程（终局法）。
 *
 * 前次 Stalker 失败原因：在 Java.perform 回调里取 getCurrentThreadId()，
 * 那可能不是真正执行 native 的线程；且 transform 回调是异步的。
 *
 * 本版：
 *   ① Stalker.follow 不带 tid → 跟随**当前线程**（默认行为），且在
 *      **调用 signRequest 前后紧邻**地 follow/unfollow，减少噪声
 *   ② transform 里只统计落在目标地址范围的 block 首地址
 *   ③ 用 onCallSummary 兜底（同步回调，记直接调用目标）
 *   ④ 结束后 dump 命中地址临近区域
 *
 * 若 Stalker 完全无输出，则输出「已排除」结论并给出替代建议。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const hits = {};
let exploring = false;

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
      const H = Java.use('com.huachenjie.c.HcjNative');
      try { s('warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20)); } catch (e) {}

      // 记录 liby 与 libnesec 的范围，便于分类
      const mods = [];
      ['liby.so', 'libnesec.so'].forEach(function (n) {
        try {
          const m = Process.findModuleByName(n);
          if (m) { mods.push({ name: n, base: m.base, hi: m.base.add(m.size) }); s('模块 ' + n + ' @' + m.base + ' sz=0x' + m.size.toString(16)); }
        } catch (e) {}
      });
      function classify(addr) {
        for (let i = 0; i < mods.length; i++) {
          if (addr.compare(mods[i].base) >= 0 && addr.compare(mods[i].hi) < 0)
            return mods[i].name + '+0x' + addr.sub(mods[i].base).toString(16);
        }
        return null;
      }

      s('');
      s('════ Stalker.follow（当前线程，紧邻调用）════');
      let ok = false;
      try {
        const tid = Process.getCurrentThreadId();
        s('  tid=' + tid);
        Stalker.follow(tid, {
          events: { call: false, ret: false, exec: false, block: false, compile: true },
          onCallSummary: function (summary) {
            Object.keys(summary).forEach(function (t) {
              const a2 = ptr(t);
              const cl = classify(a2);
              if (cl) hits['CALL ' + cl] = (hits['CALL ' + cl] || 0) + summary[t];
            });
          },
          transform: function (iterator) {
            let ins = iterator.next();
            if (ins === null) return;
            const cl = classify(ins.address);
            if (cl) hits['BLK ' + cl] = (hits['BLK ' + cl] || 0) + 1;
          }
        });
        ok = true;
        exploring = true;
        s('  ✓ Stalker 已启动');
      } catch (e) { s('  Stalker 启动失败: ' + e); }

      s('');
      s('  调 signRequest（Stalker 下）...');
      try {
        const out = String(H.signRequest('{"probe":1}', 0));
        s('  out: ' + out.substring(0, 44));
      } catch (e) { s('  err: ' + e); }

      // ★ 同步停止 + 汇总（不用 setTimeout）
      if (ok) {
        try { Stalker.unfollow(Process.getCurrentThreadId()); } catch (e) {}
        try { Stalker.flush(); } catch (e) {}
        s('  ✓ Stalker 已停止');
      }

      s('');
      s('════ Stalker 命中（liby/libnesec 内）════');
      const ks = Object.keys(hits).sort(function (x, y) { return hits[y] - hits[x]; });
      if (!ks.length) {
        s('  （无——说明执行不经过这两个模块的已映射页）');
      } else {
        ks.slice(0, 60).forEach(function (k) { s('  ' + k + '  ×' + hits[k]); });
      }
      send({ t: 'stalk', hits: hits });

      // 附带：再次确认 liby 双映射是否仍在
      let bases = 0;
      try {
        Process.enumerateRanges('r-x').forEach(function (r) {
          if (r.file && r.file.path.indexOf('liby.so') >= 0) { bases++; s('  liby r-x 映射: ' + r.base + ' ' + (r.size/1024).toFixed(0) + 'KB'); }
        });
      } catch (e) {}
      s('  liby r-x 映射数: ' + bases);
    });
  }
});
s('[boot] v7 Stalker 就绪');
