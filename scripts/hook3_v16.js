/**
 * v16：双重 hook + .bss 实际内容扫描。
 *
 * v15 结果：
 *   · base 反推成功 = fn - 0x24926c
 *   · 但 4 张表全零 → 惰性初始化 / vtable 运行时被改写
 *   · hook +0x179284 无 IO → signRequest 不走该槽
 *
 * 本法：
 *   ① hook 三个层级：+0x24926c(signRequest) / +0x34b820(核心) / +0x179284(槽0)
 *      任何一个被调用都能抓到 (输入, 输出)
 *   ② 扫描 .bss 全段，报出**非零区域**（找真正被初始化的表）
 *   ③ 抓 signRequest 的 native 输入（json）与输出（签名）
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const JNI_TABLE = null;
let jniTable = null;
Java.perform(function () {
  try {
    const env = Java.vm.getEnv();
    jniTable = env.handle.readPointer();
    const gv = new NativeFunction(jniTable.add(4 * 8).readPointer(), 'int', ['pointer']);
    s('[cal] JNI ' + '0x' + (gv(jniTable) >>> 0).toString(16));
  } catch (e) { s('[cal] err: ' + e); }
});

function hex(p, n) {
  try {
    const by = new Uint8Array(p.readByteArray(n));
    let h = '';
    for (let i = 0; i < n; i++) h += ('0' + by[i].toString(16)).slice(-2);
    return h;
  } catch (e) { return null; }
}
function jstr(js) {
  try {
    if (!jniTable || !js || js.isNull()) return null;
    const GetStringUTFChars = new NativeFunction(jniTable.add(169 * 8).readPointer(), 'pointer', ['pointer', 'pointer', 'pointer']);
    const ReleaseStringUTFChars = new NativeFunction(jniTable.add(170 * 8).readPointer(), 'void', ['pointer', 'pointer', 'pointer']);
    const c = GetStringUTFChars(jniTable, js, ptr(0));
    const v = c.readUtf8String();
    ReleaseStringUTFChars(jniTable, js, c);
    return v;
  } catch (e) { return null; }
}
function rdStdStr(p) {
  try {
    const b0 = p.readU8();
    if ((b0 & 1) === 0) {
      const len = b0 >> 1;
      if (len <= 0 || len > 22) return null;
      return p.add(1).readByteArray(len) ? Array.from(new Uint8Array(p.add(1).readByteArray(len)))
        .map(function (x) { return ('0' + x.toString(16)).slice(-2); }).join('') : null;
    }
    const len = p.add(8).readU64().toNumber();
    if (len <= 0 || len > 8192) return null;
    const ptr2 = p.add(16).readPointer();
    const by = new Uint8Array(ptr2.readByteArray(len));
    return Array.from(by).map(function (x) { return ('0' + x.toString(16)).slice(-2); }).join('');
  } catch (e) { return null; }
}

const SIG = '(Ljava/lang/String;I)Ljava/lang/String;';
let base = null, done = false;
const results = [];

function attachAll(fn) {
  if (done) return;
  done = true;
  // 反推 base
  [0x24926c, 0x2493ac].forEach(function (off) {
    if (base) return;
    const cand = fn.sub(off);
    const h = hex(cand.add(0x11c9a0), 16);
    if (h && h !== '0'.repeat(32)) base = cand;
  });
  if (!base) { s('✗ base 反推失败'); return; }
  s('★★ base = ' + base);
  send({ t: 'base', base: String(base) });

  // ① 三层 hook
  const POINTS = [
    ['signRequest', 0x24926c, 'jni'],
    ['core',        0x34b820, 'stdstr'],
    ['slot0',       0x179284, 'stdstr'],
  ];
  POINTS.forEach(function (p) {
    try {
      Interceptor.attach(base.add(p[1]), {
        onEnter: function (args) {
          if (p[2] === 'jni') {
            this.ih = jstr(args[2]);      // (env, jclass, jstring, jint)
            this.env = args[3].toInt32();
            s('  [' + p[0] + '] ENTER json=' + JSON.stringify((this.ih || '').substring(0, 60)) + ' env=' + this.env);
          } else {
            this.ih = rdStdStr(args[2]);
          }
          this.tag = p[0];
        },
        onLeave: function (rv) {
          let oh = null;
          if (this.tag === 'signRequest') {
            oh = jstr(rv);
            s('  [signRequest] LEAVE → ' + JSON.stringify((oh || '').substring(0, 60)));
          } else {
            oh = rdStdStr(args0Safe(this));
          }
          if (this.ih || oh) results.push({ tag: this.tag, in: this.ih, out: oh, env: this.env });
        }
      });
      s('  ✓ hook ' + p[0] + ' @+0x' + p[1].toString(16));
    } catch (e) { s('  ✗ hook ' + p[0] + ': ' + e); }
  });

  // ② 扫描 .bss 找非零区（.bss 文件偏移 0x47c690 .. 0x4dc237）
  s('');
  s('════ .bss 非零区扫描 ════');
  try {
    let found = 0;
    for (let off = 0x47c000; off < 0x4dc000; off += 0x1000) {
      const h = hex(base.add(off), 64);
      if (h && h !== '0'.repeat(128)) {
        found++;
        if (found <= 12) s('  +0x' + off.toString(16) + '  ' + h.substring(0, 64) + '…');
      }
    }
    s('  非零 4KB 页数: ' + found);
    send({ t: 'bss', nonzero: found });
  } catch (e) { s('  bss 扫描 err: ' + e); }

  // ③ 产生样本
  s('');
  s('════ 样本 ════');
  try {
    const H = Java.use('com.huachenjie.c.HcjNative');
    ['{"probe":1}', '{}'].forEach(function (inp) {
      s('  ' + inp + ' → ' + String(H.signRequest(inp, 0)).substring(0, 48));
    });
  } catch (e) { s('  ' + e); }

  s('  记录 ' + results.length + ' 条');
  send({ t: 'R', list: results, count: results.length });
}
function args0Safe(ctx) { return ctx.outPtr || ptr(0); }

// RN hook
Java.perform(function () {
  if (!jniTable) { s('✗ 无 JNI 表'); return; }
  try {
    Interceptor.attach(jniTable.add(215 * 8).readPointer(), {
      onEnter: function (a2) {
        if (done) return;
        try {
          const arr = a2[2], cnt = a2[3].toInt32();
          if (cnt <= 0 || cnt > 600) return;
          for (let i = 0; i < cnt; i++) {
            const e2 = arr.add(i * 24);
            let sig = '';
            try { sig = e2.add(8).readPointer().readCString() || ''; } catch (err) { continue; }
            if (sig !== SIG) continue;
            let fn = null;
            try { fn = e2.add(16).readPointer(); } catch (err) { continue; }
            if (!fn || fn.isNull()) continue;
            s('★ 捕获 signRequest fn=' + fn);
            attachAll(fn);
            return;
          }
        } catch (e) { s('  RN err: ' + e); }
      }
    });
    s('[A] RN hook OK');
  } catch (e) { s('[A] err: ' + e); }
});

const DC = 0x11c7d8, FIRST = 0x27000;
const art = Process.findModuleByName('libart.so');
let fired = false;
Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a2) {
    if (fired) return;
    let d = ''; try { d = a2[2].readCString(); } catch (e) { return; }
    if (!d || d.indexOf('Lcom/huachenjie/') !== 0) return;
    fired = true;
    Java.perform(function () {
      try {
        const H = Java.use('com.huachenjie.c.HcjNative');
        s('[DC warm] ' + String(H.signRequest('{"warm":1}', 0)).substring(0, 20));
      } catch (e) {}
    });
  }
});
s('[boot] v16 就绪');
