/**
 * v26 ★★★ 全内存搜索 signRequest 代码的所有副本 → 全部 hook → 定位真正执行的那份。
 *
 * 逻辑矛盾（v25）：
 *   · init(+0x24a644) 被调用，守卫 0→1 ✓（说明该 SO 的映射与地址计算正确）
 *   · 但 4 张表仍全零，且 base+0x24926c 的 hook **不触发**
 *   · 而 Java 层 signRequest 正常返回 80 字节
 *   ⇒ 执行的是**另一份代码副本**（liby.so 当年也有"映射两份"的先例）
 *
 * 本法：
 *   ① 用 signRequest 开头唯一的 32 字节签名：
 *        ff8301d1 f85f02a9 f65703a9 f44f04a9 fd7b05a9 fd430191 57d03bd5 e81640f9
 *      在**全部可读内存**中搜索 → 得到所有副本地址
 *   ② 对每个副本：读它的「段信息 + +0x140 偏移处是否也是同一函数」
 *   ③ 在**每个副本**的入口装 hook（含 +0x140 处的第二注册项）
 *   ④ 调 Java signRequest → 看哪个副本被触发
 *   ⑤ 命中的副本：dump 其基址 + 表状态
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}

const SIG32 = 'ff8301d1f85f02a9f65703a9f44f04a9fd7b05a9fd43019157d03bd5e81640f9';
const SIG_PAT = SIG32.match(/../g).join(' ');
const OFF_SIGN_A = 0x24926c, OFF_SIGN_B = 0x2493ac, OFF_GUARD = 0x4d26c8;

const copies = [];      // {entry, base, prot, path}
const hits = {};        // entry -> count
let done = false;

function findAll() {
  s('');
  s('════ ① 全内存搜索 signRequest 代码签名 ════');
  s('  签名: ' + SIG32);
  let scanned = 0;
  ['r--', 'rw-', 'r-x'].forEach(function (prot) {
    let ranges = [];
    try { ranges = Process.enumerateRanges(prot); } catch (e) { return; }
    ranges.forEach(function (r) {
      // 限制：跳过超大段（堆/栈）与明显无关段
      if (r.size < 64) return;
      // (removed stray)
      scanned++;
      let res = null;
      try { res = Memory.scanSync(r.base, r.size, SIG_PAT); } catch (e) { return; }
      if (!res || !res.length) return;
      res.forEach(function (m) {
        const entry = m.address;
        const base = entry.sub(OFF_SIGN_A);
        const k = entry.toString();
        if (copies.some(function (c) { return String(c.entry) === k; })) return;
        copies.push({ entry: entry, base: base, prot: r.protection,
                      path: r.file ? r.file.path : '[anon]', segBase: r.base, segSize: r.size });
      });
    });
  });
  s('  扫描 ' + scanned + ' 个段');
  s('  ★ 命中 ' + copies.length + ' 个副本:');
  copies.forEach(function (c, i) {
    s('    [' + i + '] entry=' + c.entry + '  base=' + c.base);
    s('        段=' + c.segBase + ' sz=0x' + c.segSize.toString(16) + ' ' + c.prot +
      '  ' + c.path);
    s('        +0x140 处 = ' + (hex(c.entry.add(0x140), 16) || '不可读'));
    s('        守卫(' + c.base.add(OFF_GUARD) + ') = ' + (function () {
      try { return (c.base.add(OFF_GUARD).readU8() & 0xff).toString(10); } catch (e) { return '?'; }
    })());
    s('        T1(' + c.base.add(0x47c9b8) + ') = ' + (hex(c.base.add(0x47c9b8), 16) || '不可读'));
  });
  send({ t: 'copies', list: copies.map(function (c) {
    return { entry: String(c.entry), base: String(c.base), prot: c.prot,
             seg: String(c.segBase), size: c.segSize, path: c.path };
  }) });
}

function hookAll() {
  s('');
  s('════ ② 给所有副本的入口装 hook ════');
  let n = 0;
  copies.forEach(function (c, ci) {
    [['A', 0], ['B', 0x140]].forEach(function (x) {
      const addr = c.entry.add(x[1]);
      try {
        Interceptor.attach(addr, {
          onEnter: function () {
            const k = 'copy' + ci + x[0] + '@' + addr;
            hits[k] = (hits[k] || 0) + 1;
            s('  ►►► 命中 ' + k + '  (base=' + c.base + ')');
          }
        });
        n++;
      } catch (e) {}
    });
  });
  s('  已 hook ' + n + ' 个入口');
}

function work() {
  if (done) return; done = true;
  findAll();
  if (!copies.length) { s('✗ 无副本'); return; }
  hookAll();

  s('');
  s('════ ③ 调 Java signRequest ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
      s('  ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 44));
    });
  } catch (e) { s('  err: ' + e); }

  s('');
  s('════ ④ 命中统计 ════');
  const ks = Object.keys(hits).sort(function (a, b) { return hits[b] - hits[a]; });
  if (!ks.length) s('  ⚠ 全 0 —— 所有副本都未被执行');
  ks.forEach(function (k) { s('  ' + k + '  ×' + hits[k]); });

  s('');
  s('════ ⑤ 各副本最终状态 ════');
  copies.forEach(function (c, i) {
    s('  [' + i + '] base=' + c.base);
    s('     守卫=' + (function () { try { return c.base.add(OFF_GUARD).readU8() & 0xff; } catch (e) { return '?'; } })() +
      '  T1=' + (hex(c.base.add(0x47c9b8), 16) || '?'));
  });
  send({ t: 'hits', hits: hits, copies: copies.length });
}

// 触发：RN 捕获后 + DefineClass 双保险
const SIG_SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
let table = null;
Java.perform(function () {
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    if (((gv(env.handle) >>> 0) & 0xffff0000) !== 0x10000) table = null;
  } catch (e) { table = null; }
  if (!table) return;
  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a) {
        if (done) return;
        try {
          const arr = a[2], cnt = a[3].toInt32();
          if (cnt <= 0 || cnt > 600) return;
          for (let i = 0; i < cnt; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            if (sig !== SIG_SIG) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (fn && !fn.isNull()) {
              s('[RN] signRequest fn = ' + fn);
              // 记录注册指针，稍后与副本对照
              work();
              return;
            }
          }
        } catch (e) {}
      }
    });
    s('[A] RN hook OK');
  } catch (e) { s('[A] err: ' + e); }
});

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
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('[DC] warm: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) {}
    });
  }
});
s('[boot] v26 就绪');
