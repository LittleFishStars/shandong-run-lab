/**
 * v25 ★★★ 用捕获到的真实参数调用 init → 解锁 4 张密钥表 → 解密并复现 signRequest。
 *
 * v24 决定性发现：
 *   ► init(+0x24a644) 真实参数：
 *       arg0 = "YD00717730319426"   ← 易盾 PRODUCT_ID（report/07 已记录）
 *       arg1 = 0x7fd3f10e40  (栈指针，可能是输出缓冲或结构体)
 *       arg2 = 0x7fd3f10ff0  (栈指针)
 *       arg3 = 0x0
 *       arg4 = 0x2ba2        (0x2ba2 = 11170)
 *   ◄ 返回后 **守卫 = 1**（初始化成功！）
 *   但 T1 表仍全零 → 表的生成需要 arg1/arg2 指向的有效结构体
 *
 * 本脚本分两条路：
 *   A) 在 init 的 onEnter 里**保存 arg1/arg2 的完整内存快照**，
 *      然后按相同顺序重放：init(...) → 观察表状态
 *   B) 若 arg1/arg2 是栈地址（调用即失效），改为
 *      **在 init 的 onEnter 中直接调用表生成器**（此时栈有效），
 *      或在 onLeave 里立即 dump 表
 *   C) 同时 dump arg1/arg2 指向的内存（找密钥材料）
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

let envPtr = null, table = null;
Java.perform(function () {
  try {
    envPtr = Java.vm.getEnv().handle;
    table = envPtr.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    s('[cal] 0x' + (gv(envPtr) >>> 0).toString(16));
  } catch (e) { s('[cal] err: ' + e); }
});
function jni(i, r, a) { return new NativeFunction(table.add(i * 8).readPointer(), r, a); }
function hex(p, n) {
  try { const by = new Uint8Array(p.readByteArray(n)); let h = '';
        for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2); return h; } catch (e) { return null; }
}
function u8(p) { try { return p.readU8(); } catch (e) { return -1; } }

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
const OFF_SIGN = 0x24926c, OFF_INIT = 0x24a644, OFF_GUARD = 0x4d26c8;
const OFF_T1 = 0x47c9b8, OFF_DK = 0x47c970, OFF_WT0 = 0x47c9b0;
const OFF_T2 = 0x47cdb8, OFF_T3 = 0x47d1b8, OFF_T4 = 0x47d5b8;

let base = null, done = false, initSeen = 0;

function dumpTables(tag) {
  s('  ── 表状态 [' + tag + '] 守卫=' + (u8(base.add(OFF_GUARD)) & 0xff));
  [['delta_key', OFF_DK, 64], ['whiteT0', OFF_WT0, 32], ['T1', OFF_T1, 64],
   ['T2', OFF_T2, 64], ['T3', OFF_T3, 64], ['T4', OFF_T4, 64]].forEach(function (t) {
    const h = hex(base.add(t[1]), t[2]);
    if (!h) { s('    ' + t[0] + ' 读失败'); return; }
    const z = h === '0'.repeat(h.length);
    s('    ' + t[0].padEnd(10) + (z ? '全零' : h + ' ★'));
    if (!z) send({ t: 'table', name: t[0], hex: h });
  });
}

function work(fnPtr) {
  if (done) return; done = true;
  base = fnPtr.sub(OFF_SIGN);
  s('');
  s('════ ① 环境 ════');
  s('  base = ' + base + '  校验 = ' + hex(base.add(OFF_SIGN), 16));

  // ══ ② hook init：抓参数 + 在 onLeave 立即 dump 表 ══
  s('');
  s('════ ② 挂 init hook（核心）════');
  try {
    Interceptor.attach(base.add(OFF_INIT), {
      onEnter: function (a) {
        initSeen++;
        let cstr = null;
        try { cstr = a[0].readCString(); } catch (e) {}
        s('  ► init#' + initSeen + '  arg0=' + a[0] + ' cstr=' + JSON.stringify(cstr));
        s('     arg1=' + a[1] + ' arg2=' + a[2] + ' arg3=' + a[3] + ' arg4=' + a[4]);
        // ★ dump arg1 / arg2 指向的内存（各 256 字节）—— 找密钥材料
        [['arg1', a[1]], ['arg2', a[2]]].forEach(function (x) {
          for (let off = 0; off < 512; off += 128) {
            const h = hex(x[1].add(off), 128);
            if (h) s('     ' + x[0] + '+0x' + off.toString(16) + ': ' + h);
          }
        });
        this.a1 = a[1]; this.a2 = a[2];
      },
      onLeave: function () {
        const g = u8(base.add(OFF_GUARD)) & 0xff;
        s('  ◄ init#' + initSeen + ' 返回  守卫=' + g);
        dumpTables('init 返回后');
        // ★★★ 决定性实验：守卫置位后立即调 signRequest，再看表是否被初始化
        if (g === 1 && initSeen === 1) {
          Java.perform(function () {
            try {
              const H = Java.use('com.huachenjie.c.HcjNative');
              s('  →★ init 后立刻调 signRequest ...');
              const o = String(H.signRequest('{"probe":1}', 0));
              s('  → 输出: ' + o.substring(0, 48));
            } catch (e) { s('  → err: ' + String(e).substring(0, 80)); }
            dumpTables('signRequest 之后');
          });
        }
      }
    });
    s('  ✓ init hook');
  } catch (e) { s('  ✗ ' + e); }

  // ══ ③ hook 表生成器，抓它的参数 ══
  try {
    Interceptor.attach(base.add(0x780dc), {
      onEnter: function (a) {
        s('  ► 表生成器 self=' + a[0] + ' arg1=0x' + a[1].toInt32().toString(16) +
          ' arg2=0x' + a[2].toInt32().toString(16));
        if (a[0] && !a[0].isNull()) s('     self[0..64] = ' + hex(a[0], 64));
        this.self = a[0];
      },
      onLeave: function () {
        s('  ◄ 表生成器返回');
        dumpTables('生成器返回后');
      }
    });
    s('  ✓ 生成器 hook');
  } catch (e) {}

  // ══ ④ hook signRequest ══
  try {
    Interceptor.attach(base.add(OFF_SIGN), {
      onEnter: function (a) {
        s('  ► signRequest 被调用! env=' + a[3].toInt32());
        dumpTables('signRequest 进入时');
      }
    });
    s('  ✓ signRequest hook');
  } catch (e) {}

  // ══ ⑤ 触发全链：Java 层先调 HTProtect（触发 init），再调 signRequest ══
  s('');
  s('════ ③ 触发全链 ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    s('  [1] signRequest (触发 warm) ...');
    s('      → ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 40));

    // ★ 尝试触发 HTProtect.getToken（report/07：PRODUCT_ID=YD00717730319426）
    s('  [2] 尝试 HTProtect ...');
    try {
      const HT = Java.use('com.netease.nis.basesdk.HTProtect');
      s('      HTProtect 类存在');
    } catch (e) { s('      HTProtect 类: ' + String(e).substring(0, 60)); }
    try {
      const cls = Java.use('java.lang.Class');
      ['com.netease.nis.basesdk.HTProtect', 'com.netease.nis.basesdk.HTPUtil',
       'com.netease.nis.nis.HTProtect'].forEach(function (n) {
        try { Java.use(n); s('      ✓ ' + n); } catch (e) {}
      });
    } catch (e) {}

    s('  [3] signRequest 复调 ...');
    s('      → ' + String(H.signRequest('{"probe":1}', 0)).substring(0, 48));
  } catch (e) { s('  触发 err: ' + e); }

  s('');
  s('════ ④ 汇总 ════');
  s('  init 被调用 ' + initSeen + ' 次');
  dumpTables('最终');
  send({ t: 'final', initSeen: initSeen, guard: u8(base.add(OFF_GUARD)) & 0xff });
}

Java.perform(function () {
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
            if (sig !== SIG) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (fn && !fn.isNull()) { work(fn); return; }
          }
        } catch (e) {}
      }
    });
    s('[A] RN hook OK');
  } catch (e) {}
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
s('[boot] v25 就绪');
