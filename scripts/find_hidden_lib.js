/**
 * 定位并 dump 「隐藏的 liby.so」—— 用函数指针反查段。
 *
 * 前几次失败的教训：
 *   · hook art::JNI::RegisterNatives 太晚（注册在 spawn 后瞬间完成）
 *   · liby.so 的 ELF 头被抹、maps 里无路径名 → findModuleByName 找不到
 *
 * 本脚本改用**最直接**的办法：
 *   1. 通过 Java 反射拿到 HcjNative.signRequest 的 Method 对象
 *   2. 用 art 内部结构取出它的 native 入口地址（ArtMethod.entry_point_from_jni_）
 *   3. 用该地址反查属于哪个映射段 → 就是隐藏 liby.so 的段
 *   4. 报告段区间（宿主再用 /proc/pid/mem dump 出来分析）
 *
 * ArtMethod 里 native 方法的入口在 entry_point_from_jni_ 字段（偏移随版本变化，
 * 这里用扫描方式：从 ArtMethod 起始往后 64 字节内找落在可执行段的指针）。
 */
function s(m){ send({t:'log',msg:String(m)}); }

Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});

const FIRST = 0x27000;
const DC = 0x11c7d8;
const art = Process.findModuleByName('libart.so');
var tried = false;

function analyze() {
  if (tried) return;
  tried = true;
  Java.perform(function () {
    var N = null;
    try { N = Java.use('com.huachenjie.c.HcjNative'); }
    catch (e) { s('取 HcjNative 失败: ' + e); return; }

    // 强制加载 native
    try { N.signRequest('{"probe":1}', 0); s('signRequest 调用成功 → native 已加载'); }
    catch (e) { s('signRequest 调用失败: ' + e); return; }

    // 反射拿 Method 对象
    var M = null;
    try {
      var cls = N.class;
      var ms = cls.getDeclaredMethods();
      for (var i = 0; i < ms.length; i++) {
        if (ms[i].getName() === 'signRequest') { M = ms[i]; break; }
      }
    } catch (e) { s('反射失败: ' + e); }

    if (!M) { s('未找到 signRequest 方法'); return; }
    s('找到 signRequest 方法: ' + M);

    // ── 用 Java 层手段拿 art::ArtMethod* ──
    // Frida 的 Java 包装器不直接暴露 ArtMethod，这里换思路：
    // 用 Java.vm.getEnv() 拿 JNIEnv，再通过反射调用底层太复杂。
    // 实用替代：直接扫描所有可执行段，找「调用了 signRequest 返回值特征」的代码不适合。
    //
    // 因此改用最朴素但可靠的办法：把 HcjNative 类里所有 native 方法的
    // 入口地址通过 art 的 ArtMethod 结构读出来。
    // Frida 提供了隐蔽接口：Java.vm.getEnv() + JNI 反射调用，成本高。
    //
    // 我们退一步：既然 signRequest 一定在某个 r-xp 匿名段里，
    // 那就把所有匿名可执行段报到宿主，由宿主 dump 后在离线环境用
    // 特征匹配（例如找它引用的字符串常量地址）来确认哪一段是 liby.so。
    s('');
    s('════ 列出所有可执行段（宿主据此 dump）════');
    var ranges = [];
    try { ranges = Process.enumerateRanges('r-x'); } catch (e) { s('枚举失败: ' + e); return; }
    s('可执行段总数: ' + ranges.length);

    var anon = [];
    for (var k = 0; k < ranges.length; k++) {
      var r = ranges[k];
      // 通过 /proc/self/maps 拿不到名字（会被壳检测），这里只按「非模块区间」判断
      var isModule = false;
      try {
        // 如果该地址能对应到某个已加载模块，说明是正常库
        var mods = Process.enumerateModules();
        for (var mi = 0; mi < mods.length; mi++) {
          var mb = mods[mi].base, me = mb.add(mods[mi].size);
          if (r.base.compare(mb) >= 0 && r.base.compare(me) < 0) { isModule = true; break; }
        }
      } catch (e) {}
      if (!isModule) anon.push(r);
    }

    s('非模块可执行段: ' + anon.length + ' 个');
    anon.forEach(function (r) {
      s('  ' + r.base + '  size=' + (r.size / 1024).toFixed(0) + 'KB  ' + r.protection);
      send({ t: 'seg', base: r.base.toString(), size: r.size, prot: r.protection });
    });
    s('════ 完成 ════');
  });
}

Interceptor.attach(art.base.add(DC - FIRST), {
  onEnter: function (a) {
    if (tried) return;
    var desc = '';
    try { desc = a[2].readCString(); } catch (e) { return; }
    if (!desc || desc.indexOf('Lcom/huachenjie/') !== 0) return;
    s('[native] 触发: ' + desc);
    analyze();
  }
});
s('[boot] 就绪');
