// 探针：谁注册了 ShandongApplication 等类的 native 方法
'use strict';

var CLS = null;
var logged = 0;

function modOf(addr) {
  try {
    var m = Process.findModuleByAddress(addr);
    if (m) return m.name + '+0x' + addr.sub(m.base).toString(16);
    return ptr(addr).toString();
  } catch (e) { return '?'; }
}

function callerOf(ctx) {
  try {
    var bt = Thread.backtrace(ctx, Backtracer.FUZZY);
    for (var i = 0; i < bt.length; i++) {
      var s = modOf(bt[i]);
      if (s.indexOf('libart') < 0 && s.indexOf('libc') < 0) return s;
    }
    return bt.length ? modOf(bt[0]) : '?';
  } catch (e) { return '?'; }
}

function install() {
  var libart = null;
  var names = ['libart.so', 'libartbase.so'];
  for (var i = 0; i < names.length; i++) {
    var m = Process.findModuleByName(names[i]);
    if (m) { libart = m; break; }
  }
  if (!libart) { send({ t: 'log', msg: '[x] 找不到 libart' }); return; }

  var envPtr = Java.vm.getEnv().handle;
  var table = envPtr.readPointer();
  send({ t: 'log', msg: '[i] JNIEnv=' + envPtr + '  table=' + table });
  var rn = table.add(215 * Process.pointerSize).readPointer();
  send({ t: 'log', msg: '[i] RegisterNatives=' + rn + ' (' + modOf(rn) + ')' });

  Interceptor.attach(rn, {
    onEnter: function (args) {
      if (logged > 400) return;
      try {
        var clazz = args[1], n = args[3].toInt32(), methods = args[2];
        if (n <= 0 || n > 60) return;
        var clsName = '?';
        try { clsName = Java.cast(clazz, CLS).getName(); } catch (e) {}
        if (clsName.indexOf('huachenjie') < 0 && clsName.indexOf('netease') < 0
            && clsName.indexOf('zj.') < 0 && clsName.indexOf('kuaishou') < 0) return;
        logged++;
        send({ t: 'log', msg: '════ RegisterNatives #' + logged + '  ' + clsName + '  n=' + n + '   caller=' + callerOf(this.context) });
        for (var i = 0; i < n && i < 40; i++) {
          var m = methods.add(i * Process.pointerSize * 3);
          var nm = m.readPointer().readCString();
          var sg = m.add(Process.pointerSize).readPointer().readCString();
          var fp = m.add(Process.pointerSize * 2).readPointer();
          send({ t: 'log', msg: '    ' + nm + ' ' + sg + ' → ' + modOf(fp) });
        }
      } catch (e) {
        send({ t: 'log', msg: '[!] hook err ' + e });
      }
    }
  });
  send({ t: 'log', msg: '[✓] RegisterNatives 钩子已装' });
}

try {
  CLS = Java.use('java.lang.Class');
  install();
} catch (e) {
  send({ t: 'log', msg: '[x] ' + e });
}
