/**
 * 动态定位 signRequest 的 native 实现地址。
 *
 * 思路：liby.so 的 ELF 头被抹、模块名被隐藏，无法按名字找。
 * 但 JNI 方法一定通过 RegisterNatives 注册 —— hook art::JNI::RegisterNatives
 * （libart.so vaddr 0x387860），在注册瞬间抓出 (名字, 签名, 函数指针) 三元组，
 * 即可拿到 signRequest/encodeRun 的真实地址，进而：
 *   · 把该地址所在的映射段 dump 出来做静态分析
 *   · 或在地址上下断点/记录调用参数
 *
 * 注意：只读观测，不修改行为。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const FIRST = 0x27000;
const REG_NATIVE = 0x387860;      // art::JNI::RegisterNatives（本项目实测 vaddr）
const art = Process.findModuleByName('libart.so');

// JNINativeMethod { const char* name; const char* signature; void* fnPtr; } = 24 字节
const NM_SIZE = 24;

Interceptor.attach(art.base.add(REG_NATIVE - FIRST), {
  onEnter: function (args) {
    // x1 = JNIEnv*, x2 = jclass, x3 = JNINativeMethod*, x4 = count
    var methods = args[2];      // 注意：Frida 的 args[] 不包含 this
    var count = 0;
    try { count = args[3].toInt32(); } catch (e) { return; }
    if (count <= 0 || count > 500) return;

    // 先判断这批方法里有没有我们关心的
    var names = [];
    for (var i = 0; i < count; i++) {
      var nm = '';
      try { nm = methods.add(i * NM_SIZE).readPointer().readCString(); } catch (e) { continue; }
      names.push(nm);
    }
    var interesting = names.filter(function (n) {
      return n === 'signRequest' || n === 'encodeRun' || n === 'buildFlutterSecParams';
    });
    if (interesting.length === 0) return;

    s('★★★★★ 命中目标注册 ★★★★★');
    s('  本次注册 ' + count + ' 个方法: ' + names.join(', '));
    s('');
    for (var j = 0; j < count; j++) {
      var base = methods.add(j * NM_SIZE);
      var name = '', sig = '', fn = null;
      try {
        name = base.readPointer().readCString();
        sig = base.add(8).readPointer().readCString();
        fn = base.add(16).readPointer();
      } catch (e) { continue; }
      s('  方法: ' + name);
      s('    签名: ' + sig);
      s('    实现: ' + fn);

      // 找该地址属于哪个映射段
      var r = null;
      try { r = Process.findRangeByAddress(fn); } catch (e) {}
      if (r) {
        s('    所在段: ' + r.base + ' - ' + r.base.add(r.size) +
          '  ' + r.protection + '  (' + (r.size / 1024).toFixed(0) + ' KB)');
        s('    段内偏移: 0x' + fn.sub(r.base).toString(16));
      } else {
        s('    所在段: 未找到（可能是匿名段）');
      }
      s('');
    }
  }
});
s('[boot] RegisterNatives hook 已装（等 liby.so 注册）');
