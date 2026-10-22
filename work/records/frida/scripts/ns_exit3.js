// ns_exit3.js —— 定位「重签名版」的退出调用链
// 已知：libnesec 用内联 svc #0 实现 exit_group，桩在镜像偏移 0x2fed0（3 个调用点）。
// 本脚本直接钩这个桩（放在所有 libc hook 之外，绕不过去），抓 native 回溯。
var done = false;
var hookInstalled = false;

function log(m) { send({ t: 'log', msg: m }); }

function bt(ctx) {
  try {
    var arr = Thread.backtrace(ctx, Backtracer.FUZZY) || [];
    return arr.map(function (a) {
      var m = Process.findModuleByAddress(a);
      return m ? (m.name + '+0x' + a.sub(m.base).toString(16)) : a.toString();
    }).join('  <=  ');
  } catch (e) { return 'bt 失败: ' + e; }
}

function install() {
  var mod = Process.findModuleByName('libnesec.so');
  if (!mod) return false;
  log('libnesec.so base=' + mod.base + ' size=' + mod.size);

  var targets = {
    '0x2fed0': 'exit_group 桩(94)',
    '0x2ff30': 'kill 桩(129)',
    '0x2ff90': 'reboot 桩(207)',
    '0xcdee0': '内部 exit 包装(mov w0,#1)',
    '0xcdf08': '内部 exit 包装2',
    '0xcdf10': '内部 exit 包装3',
    '0xb1bec': '自杀出口(回桌面+System.exit)',
    '0xb1aec': '检测判据/分发器'
  };
  Object.keys(targets).forEach(function (off) {
    var addr = mod.base.add(ptr(off).toInt32 ? parseInt(off, 16) : parseInt(off, 16));
    try {
      Interceptor.attach(mod.base.add(parseInt(off, 16)), {
        onEnter: function (args) {
          log('★★ 命中 ' + targets[off] + ' @' + off + '  x0=' + this.context.x0);
          log('   回溯: ' + bt(this.context));
        }
      });
      log('  已挂钩 ' + targets[off] + ' @ ' + off);
    } catch (e) { log('  挂钩 ' + off + ' 失败: ' + e); }
  });
  return true;
}

function tick() {
  if (hookInstalled) return;
  if (install()) {
    hookInstalled = true;
    log('=== 全部挂钩就绪 ===');
  }
}

// 先用最短间隔抢时间
var iv = setInterval(tick, 20);
// 15 秒后收工
setTimeout(function () {
  clearInterval(iv);
  if (!hookInstalled) log('!!! 始终没等到 libnesec.so');
  log('=== 观察结束 ===');
}, 15000);
tick();
