/**
 * v10：在壳注册 JNI 的瞬间抓 signRequest 的真实函数指针。
 *
 * 累积事实：
 *   · JNIEnv 布局已校准：table = env.handle.readPointer()，GetVersion=0x10006 ✓
 *   · FindClass 会触发壳 abort → 不可用
 *   · liby.so 全部 277 个序言函数 0 命中 → 实现不在 liby.so
 *   · Stalker 被壳禁废（block 总数恒 0）
 *   · 明文 "signRequest" 不在任何 SO 的字符串表里 → 方法名运行时构造
 *   ⇒ 唯一可靠路径：在 RegisterNatives 被调用时读出 (name, sig, fnPtr)
 *
 * 本法：
 *   ① 顶层同步（无 setTimeout）从 vtable[215] 取 RegisterNatives 并 attach
 *   ② 记录所有注册批次的 name，匹配 signRequest/encodeRun/buildFlutter*
 *   ③ 命中即报 fnPtr + 所属映射 + 前后 32 字节
 *   ④ 同时装 System.exit/Runtime.exit 反退出 hook 保障存活
 */
function s(m){ send({t:'log',msg:String(m)}); }

// ① 反退出（先装）
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) { s('[keep] System.exit(' + c + ') 已拦'); }; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.ProcessBuilder').start.implementation = function () {
    s('[keep] ProcessBuilder.start 已拦'); return this.start();
  }; } catch (e) {}
});

function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}
function locate(addr) {
  try {
    const r = Process.findRangeByAddress(addr);
    if (r) return r.protection + ' ' + (r.file ? r.file.path : '[anon]') +
      ' @' + r.base + '+0x' + addr.sub(r.base).toString(16) + ' sz=0x' + r.size.toString(16);
  } catch (e) {}
  return '?';
}

let registered = 0;
const allNames = [];

Java.perform(function () {
  // ② 从 vtable[215] 拿 RegisterNatives
  let table = null;
  try {
    const env = Java.vm.getEnv();
    table = env.handle.readPointer();          // ★ 已校准：A 方案
    const GetVersion = new NativeFunction(table.add(4 * 8).readPointer(), 'int', ['pointer']);
    const ver = GetVersion(table) >>> 0;
    s('[cal] table=' + table + '  GetVersion=0x' + ver.toString(16));
    if (ver < 0x10000 || ver > 0x20000) { s('✗ 校准失败'); return; }
  } catch (e) { s('[cal] err: ' + e); return; }

  try {
    const rn = table.add(215 * 8).readPointer();
    s('[A] RegisterNatives = ' + rn + '  ' + locate(rn));
    Interceptor.attach(rn, {
      onEnter: function (a) {
        try {
          const methods = a[2], count = a[3].toInt32();
          if (count <= 0 || count > 400) return;
          registered++;
          for (let i = 0; i < count; i++) {
            const rec = methods.add(i * 24);
            let nm = '';
            try { nm = rec.readCString() || ''; } catch (e) { continue; }
            if (nm) allNames.push(nm);
            if (nm === 'signRequest' || nm === 'encodeRun' || nm === 'buildFlutterSecParams') {
              let sig = '', fn = null;
              try { sig = rec.add(8).readPointer().readCString(); } catch (e) {}
              try { fn = rec.add(16).readPointer(); } catch (e) {}
              s('════════ ★★★ RegisterNatives 命中 ★★★ ════════');
              s('  批次 #' + registered + '   本批 ' + count + ' 个方法');
              s('  name      = ' + nm);
              s('  signature = ' + sig);
              s('  fnPtr     = ' + fn);
              if (fn && !fn.isNull()) {
                s('  归属      = ' + locate(fn));
                s('  前 32 字节 = ' + hex(fn, 32));
                send({ t: 'rn', name: nm, sig: sig, fn: String(fn) });
              }
            }
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] hook 已装（等壳注册）');
  } catch (e) { s('[A] err: ' + e); }
});

// ③ 3 秒后（用 Interceptor 的 native 回调已足够早；再补一个同步触发）
Java.perform(function () {
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    s('probe: ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 24));
  } catch (e) { s('probe err: ' + e); }
  s('');
  s('════ 已注册方法名汇总（' + allNames.length + ' 个）════');
  const uniq = Array.from(new Set(allNames));
  s('  批次 ' + registered + ' 个，去重后 ' + uniq.length + ' 个名字');
  s('  ' + uniq.join(', '));
  send({ t: 'names', n: uniq.length, names: uniq.slice(0, 300) });
});
s('[boot] v10 就绪');
