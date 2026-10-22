/**
 * 定位 signRequest 的 native 实现所在段与调用路径。
 *
 * 方法：signRequest 一定在某个隐藏段里。逐个「钓」出隐藏段后，
 * 在段内 hook 若干候选函数入口（体积最大的那些 + 已知关键函数），
 * 然后调用 signRequest，看哪些被触发 → 即为调用路径。
 */
function s(m){ send({t:'log',msg:String(m)}); }
Java.perform(function () {
  try { Java.use('java.lang.System').exit.implementation = function (c) {}; } catch (e) {}
  try { Java.use('java.lang.Runtime').exit.implementation = function (c) {}; } catch (e) {}
});
function findExport(n){
  try { if (typeof Module.findGlobalExportByName==='function'){const a=Module.findGlobalExportByName(n); if(a)return a;} } catch(e){}
  try { if (typeof Module.getGlobalExportByName==='function'){const a=Module.getGlobalExportByName(n); if(a)return a;} } catch(e){}
  return null;
}

// 892KB 段的候选函数偏移（来自 Ghidra 分析）
const CANDS = [
  ['主入口 FUN_0009be9c', 0x9be9c],
  ['FUN_000a3460', 0xa3460],
  ['FUN_000568a0', 0x568a0],
  ['FUN_00083560', 0x83560],
  ['FUN_0006c78c', 0x6c78c],
  ['FUN_0009fb70', 0x9fb70],
  ['MD5压缩 FUN_000b6a04', 0xb6a04],
  ['MD5封装 FUN_000b6950', 0xb6950],
  ['CityHash FUN_000c1fd8', 0xc1fd8],
  ['PKCS7 FUN_0007c9f8', 0x7c9f8],
];
const hooked = {};
const mprotectAddr = findExport('mprotect');
if (mprotectAddr) {
  Interceptor.attach(mprotectAddr, {
    onEnter: function (a) { this.addr=a[0]; this.len=a[1].toInt32(); this.prot=a[2].toInt32(); },
    onLeave: function (rv) {
      // 892KB 段
      if (this.prot === 5 && this.len >= 800000 && this.len <= 1000000) {
        s('★ 目标段 @ ' + this.addr + ' (' + (this.len/1024).toFixed(0) + 'KB)');
        CANDS.forEach(function (c) {
          var name = c[0], off = c[1];
          var tgt = this.addr.add(off);
          if (hooked[off]) return;
          hooked[off] = true;
          try {
            Interceptor.attach(tgt, {
              onEnter: function () { s('   → 触发 ' + name + ' @段+0x' + off.toString(16)); },
              onLeave: function (rv) {
                if (off === 0x9be9c || off === 0xb6a04 || off === 0xc1fd8) {
                  s('   ← 返回 ' + name + ' = ' + rv);
                }
              }
            });
            s('   [hook] ' + name);
          } catch (e) { s('   [hook] ' + name + ' 失败: ' + e); }
        }, this);
      }
    }
  });
}
const FIRST=0x27000, DC=0x11c7d8;
const art = Process.findModuleByName('libart.so');
var fired=false;
Interceptor.attach(art.base.add(DC-FIRST), {
  onEnter: function (a) {
    if (fired) return;
    var d=''; try{d=a[2].readCString();}catch(e){return;}
    if(!d||d.indexOf('Lcom/huachenjie/')!==0) return;
    fired=true;
    Java.perform(function(){
      try {
        var N=Java.use('com.huachenjie.c.HcjNative');
        s('═══ 调用 signRequest 观察触发链 ═══');
        var r=String(N.signRequest('{"probe":1}',0));
        s('   结果: '+r.substring(0,40)+'...');
      } catch(e){ s('   '+e); }
    });
  }
});
s('[boot] signRequest 实现定位就绪');
