// 无壳版诊断：attachBaseContext 到底走到哪一步
'use strict';
Java.perform(function () {
  var CW = Java.use('android.content.ContextWrapper');
  CW.attachBaseContext.implementation = function (ctx) {
    send({ t: 'log', msg: '▶ attachBaseContext  ' + this.getClass().getName()
      + '  base=' + (ctx === null ? 'NULL' : ctx.getClass().getName()) });
    var r = this.attachBaseContext(ctx);
    send({ t: 'log', msg: '◀ 返回 ' + this.getClass().getName()
      + '  mBase=' + (this.getBaseContext() === null ? 'NULL' : 'OK') });
    return r;
  };

  try {
    var SA = Java.use('com.huachenjie.shandong_school.ShandongApplication');
    var m = SA.attachBaseContext.overload('android.content.Context');
    send({ t: 'log', msg: '[i] ShandongApplication.attachBaseContext 存在: ' + m });
  } catch (e) { send({ t: 'log', msg: '[x] SA: ' + e }); }

  var SE = Java.use('java.lang.System');
  SE.exit.implementation = function (c) {
    send({ t: 'log', msg: '!!! System.exit(' + c + ')' });
    var st = Java.use('android.util.Log').getStackTraceString(
      Java.use('java.lang.Throwable').$new());
    send({ t: 'log', msg: st });
    return this.exit(c);
  };
  send({ t: 'log', msg: '[✓] 诊断钩子已装' });
});
