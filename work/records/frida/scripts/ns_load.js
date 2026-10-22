// 测试：无壳版里手工调用 MyJni.load 会发生什么
'use strict';
var PKG = 'com.huachenjie.shandong_school';
Java.perform(function () {
  var App = Java.use('android.app.Application');
  App.attach.implementation = function (ctx) {
    send({ t: 'log', msg: '▶ Application.attach 进入 ' + this.getClass().getName() });
    var r = this.attach(ctx);
    send({ t: 'log', msg: '◀ Application.attach 返回，mBase=' + (this.getBaseContext() === null ? 'NULL' : 'OK') });
    try {
      var M = Java.use('com.netease.nis.wrapper.MyJni');
      send({ t: 'log', msg: '… 调用 MyJni.load(app,' + PKG + ')' });
      var ok = M.load(this, PKG);
      send({ t: 'log', msg: '★ MyJni.load 返回 ' + ok });
    } catch (e) {
      send({ t: 'log', msg: '★ MyJni.load 抛异常: ' + e });
    }
    return r;
  };
  var SE = Java.use('java.lang.System');
  SE.exit.implementation = function (c) {
    send({ t: 'log', msg: '!!! System.exit(' + c + ')' });
    return this.exit(c);
  };
  send({ t: 'log', msg: '[✓] 已装钩子' });
});
