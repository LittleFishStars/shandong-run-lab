/**
 * v22：定位并 hook Java→native 的实际派发点，攻克 Java2C 阻隔。
 *
 * 背景（report/11 §17）：
 *   · L5 已确认：RegisterNatives 登记的 signRequest 指针（+0x24926c / +0x2493ac）
 *     **主动调用会 abort**，且 **Java 调用不触发其 hook**
 *   · L6/L7：应用启用 Java2C（163java2c0），Java 侧调用被编译成 native 直接跳转
 *
 * 本法（路径 A）：
 *   ① 运行时枚举 libart.so 的全部符号，搜 Call*ObjectMethod* / *Invoke*
 *   ② 对这些候选装 hook（只记录「落到 libNetHTProtect 范围内的调用目标」）
 *   ③ 调 HcjNative.signRequest → 观察哪个派发点被触发、目标地址是什么
 *
 * 兜底（路径 B）：
 *   ④ 若找不到符号，改为 hook `art::interpreter` / `ExecuteSwitchImpl` 等已知路径；
 *   ⑤ 再兜底：在 libNetHTProtect 全 r-x 段做「回归式」序言 hook —— 但这次
 *      只 hook **与 +0x24926c 同段**（0x468000）内的所有序言，不再限制 200 个
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

let htBase = null, htHi = null;
let signFn = null;
const SIG_SR = '(Ljava/lang/String;I)Ljava/lang/String;';
const hits = {};
let ready = false;

let pendingSetup = false;
function setup(fnArg) {
  if (fnArg) signFn = fnArg;
  if (!signFn) { pendingSetup = true; s('[setup] 尚无 fnPtr，挂起等待 RN'); return; }
  if (ready) return;
  ready = true;

  // ══ ① 用 fnPtr 反推 libNetHTProtect 基址（v20 已验证）══
  s('');
  s('════ ① 定位 libNetHTProtect.so ════');
  if (signFn) {
    htBase = signFn.sub(0x24926c);
    const r = Process.findRangeByAddress(signFn);
    htHi = r ? r.base.add(r.size) : htBase.add(0x468000);
    // 校验
    const sig = hex(htBase.add(0x24926c), 16);
    s('  由 fnPtr(' + signFn + ') 反推 base = ' + htBase);
    s('  段范围: ' + (r ? r.base : '?') + ' sz=0x' + (r ? r.size.toString(16) : '?'));
    s('  校验 base+0x24926c = ' + sig + (sig === 'ff8301d1f85f02a9f65703a9f44f04a9' ? '  ✓' : '  ⚠'));
  }
  if (!htBase) { s('  ✗ 未拿到 fnPtr'); return; }
  s('  扫描范围: ' + htBase + ' .. ' + htHi);

  // ══ ② 枚举 libart 符号，找派发点 ══
  s('');
  s('════ ② libart 中 Java→native 派发点 ════');
  const art = Process.findModuleByName('libart.so');
  const CAND = [];
  try {
    art.enumerateSymbols().forEach(function (sym) {
      const n = sym.name;
      if (n.indexOf('CallStaticObjectMethod') >= 0 || n.indexOf('CallObjectMethod') >= 0 ||
          n.indexOf('InvokeWithArgArray') >= 0 || n.indexOf('CallStaticVoidMethod') >= 0 ||
          n.indexOf('artQuickToInterpreterBridge') >= 0 || n.indexOf('ArtMethod::Invoke') >= 0 ||
          n.indexOf('PerformCall') >= 0 || n.indexOf('JniMethodStart') >= 0) {
        CAND.push({ name: n, addr: sym.address });
      }
    });
  } catch (e) { s('  枚举失败: ' + e); }
  s('  候选符号 ' + CAND.length + ' 个');
  CAND.slice(0, 20).forEach(function (c) {
    s('    ' + c.addr + '  ' + c.name.substring(0, 90));
  });
  if (!CAND.length) s('  ⚠ libart 符号表为空（stripped）→ 走兜底方案');

  // ══ ③ 给候选装 hook（只记落到 libNetHTProtect 的）══
  let hooked = 0;
  CAND.forEach(function (c) {
    try {
      Interceptor.attach(c.addr, {
        onEnter: function (a) {
          // 扫描前 6 个参数，看是否有指针落在 libNetHTProtect 内
          for (let i = 0; i < 6; i++) {
            const p = a[i];
            if (!p || p.isNull()) continue;
            if (p.compare(htBase) >= 0 && p.compare(htHi) < 0) {
              const k = c.name.substring(0, 40) + ' arg' + i;
              hits[k] = (hits[k] || 0) + 1;
              s('  ► ' + c.name.substring(0, 50) + ' arg' + i + ' = ' + p +
                ' (libNetHTProtect+0x' + p.sub(htBase).toString(16) + ')');
            }
          }
        }
      });
      hooked++;
    } catch (e) {}
  });
  s('  已 hook ' + hooked + '/' + CAND.length);

  // ══ ④ 兜底：libNetHTProtect 全段序言 hook（无数量限制）══
  s('');
  s('════ ④ 兜底：libNetHTProtect 全段序言 hook ════');
  const PROL = ['fd 7b bf a9', 'fd 7b 01 a9', 'ff 03 01 d1', 'ff 83 00 d1',
                'ff 43 00 d1', 'ff c3 00 d1', 'f6 57 bf a9', 'f6 57 bd a9',
                'f4 4f bf a9', 'fd 03 00 aa', 'ff 07 01 d1', 'f8 5f bc a9',
                'ff c3 01 d1', 'ff 03 02 d1', 'ff 83 01 d1', 'ff c3 00 39'];
  let found = [];
  PROL.forEach(function (pat) {
    try {
      Memory.scanSync(htBase, htHi.sub(htBase).toInt32(), pat).forEach(function (m) {
        const o = m.address.sub(htBase).toInt32();
        if (o % 4 === 0) found.push(o);
      });
    } catch (e) {}
  });
  found = Array.from(new Set(found)).sort(function (a, b) { return a - b; });
  s('  序言候选 ' + found.length + ' 个（全段，无上限）');
  let ok = 0;
  const LIM = 3000;
  for (let i = 0; i < found.length && i < LIM; i++) {
    const o = found[i];
    try {
      Interceptor.attach(htBase.add(o), {
        onEnter: function () { const k = 'PROL+0x' + o.toString(16); hits[k] = (hits[k] || 0) + 1; }
      });
      ok++;
    } catch (e) {}
  }
  s('  已 hook ' + ok + '/' + Math.min(found.length, LIM));

  // ══ ⑤ 调用并统计 ══
  s('');
  s('════ ⑤ 调用 signRequest ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    ['{"probe":1}', '{}', '{"a":2}'].forEach(function (inp) {
      s('  ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 44));
    });
  } catch (e) { s('  err: ' + e); }

  s('');
  s('════ ⑥ 命中汇总 ════');
  const ks = Object.keys(hits).sort(function (a, b) { return hits[b] - hits[a]; });
  if (!ks.length) s('  （全 0 —— 仍在别处）');
  ks.slice(0, 40).forEach(function (k) { s('  ' + k + '  ×' + hits[k]); });
  send({ t: 'R', hits: hits, found: found.length, hooked: ok, cand: CAND.length });
}

// ══ RegisterNatives：先拿 fnPtr ══
Java.perform(function () {
  let table = null;
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();
    const gv = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    if (((gv(table) >>> 0) & 0xffff0000) !== 0x10000) return;
  } catch (e) { return; }
  try {
    Interceptor.attach(table.add(215 * 8).readPointer(), {
      onEnter: function (a) {
        if (signFn) return;
        try {
          const arr = a[2], cnt = a[3].toInt32();
          if (cnt <= 0 || cnt > 600) return;
          for (let i = 0; i < cnt; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            if (sig !== SIG_SR) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (fn && !fn.isNull()) {
              signFn = fn;
              s('[RN] 捕获 signRequest fn=' + fn);
              // ★ 同一回调内立即启动分析（时序：RN 晚于 DefineClass）
              try { setup(fn); } catch (e) { s('[RN→setup] err: ' + e); }
              return;
            }
          }
        } catch (e) {}
      }
    });
    s('[A] RN hook 已装');
  } catch (e) { s('[A] err: ' + e); }
});

// ══ 触发：等 HcjNative 出现 ══
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
      } catch (e) { s('[DC] warm err: ' + String(e).substring(0, 60)); }
      setup();     // ★ 同步执行（不用 setTimeout）
    });
  }
});
s('[boot] v22 就绪');
