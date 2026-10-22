/**
 * 最终定位：在所有「变为可执行」的匿名段里，找出 signRequest 的实现段。
 *
 * 已知事实：
 *   · liby.so 是 APK 内的真实文件（458,584 字节），但**完全不在 /proc/maps**
 *     → 壳加载后卸载了文件映射，代码落在匿名段
 *   · report/08 钓到的三个段（120KB / 1148KB / 872KB）经反汇编分析，
 *     分别是 易盾防dump组件 / 360加固保运行时 / 易盾native SDK
 *   · "signRequest" 字符串在 rw- 段（ART 堆），说明 Java 层字符串是运行时创建的
 *
 * 本脚本：
 *   ① 记录所有 mprotect→RX 的段（含匿名）
 *   ② 在**每个**这样的段里搜索 liby.so 的特征：
 *      · 导出函数名（284 个，名字加密 → 搜不到）
 *      · 但可以搜 **JNI 方法签名串** "(Ljava/lang/String;I)Ljava/lang/String;"
 *        —— signRequest 的签名，静态存在于任何实现它的 SO 中
 *   ③ 命中即报告段基址 → 宿主 dump 后与 liby.so 磁盘文件做差分比对
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

const captured = {};   // base -> {base,size}

const mp = findExport('mprotect');
if (mp) {
  Interceptor.attach(mp, {
    onEnter: function (a) { this.addr=a[0]; this.len=a[1].toInt32(); this.prot=a[2].toInt32(); },
    onLeave: function () {
      if (this.prot !== 5 && this.prot !== 7) return;
      if (this.len < 4096) return;
      const k = this.addr.toString();
      if (!captured[k]) {
        captured[k] = { base: this.addr, size: this.len };
        s('[RX] ' + this.addr + '  ' + (this.len/1024).toFixed(0) + 'KB');
      }
    }
  });
}

// 在给定段里搜字符串模式
function scanSeg(seg, patterns) {
  const out = [];
  patterns.forEach(function (p) {
    let hits = null;
    try { hits = Memory.scanSync(seg.base, seg.size, p.pat); } catch (e) { return; }
    if (hits && hits.length) out.push({ name: p.name, n: hits.length, at: hits[0].address });
  });
  return out;
}

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
      // 先把 native 全部加载（多调几次）
      try {
        const N = Java.use('com.huachenjie.c.HcjNative');
        N.signRequest('{"probe":1}', 0);
        N.buildFlutterSecParams('a','b','c',0);
        N.encodeRun('a','b','c','d',0);
        s('  已触发 3 个 native 方法');
      } catch (e) { s('  触发失败: ' + e); }

      // 等一会儿让所有段都 mprotect 过
      s('');
      s('════ 在所有已捕获的 RX 段里搜索 JNI 签名 ════');
      const PATTERNS = [
        { name: 'signRequest签名', pat: '(Ljava/lang/String;I)Ljava/lang/String;'.split('').map(function(c){
            return ('0'+c.charCodeAt(0).toString(16)).slice(-2); }).join(' ') },
        { name: 'encodeRun签名',   pat: '(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;'
            .split('').map(function(c){ return ('0'+c.charCodeAt(0).toString(16)).slice(-2); }).join(' ') },
        { name: 'JNI_OnLoad',      pat: '4a 4e 49 5f 4f 6e 4c 6f 61 64' },
        { name: 'liby.so',         pat: '6c 69 62 79 2e 73 6f' },
      ];

      let found = 0;
      Object.keys(captured).forEach(function (k) {
        const seg = captured[k];
        if (seg.size > 32 * 1024 * 1024) return;
        const hits = scanSeg(seg, PATTERNS);
        if (hits.length) {
          found++;
          s('  ★★ 段 ' + seg.base + ' (' + (seg.size/1024).toFixed(0) + 'KB) 命中:');
          hits.forEach(function (h) { s('       ' + h.name + ' ×' + h.n + '  @' + h.at); });
          send({ t: 'hit', base: seg.base.toString(), size: seg.size,
                 hits: hits.map(function (h) { return h.name + '|' + h.n + '|' + h.at.toString(); }) });
        }
      });
      if (!found) s('  未在任何 RX 段找到 JNI 签名（可能段尚未创建）');

      // 汇总所有段
      send({ t: 'segs', segs: Object.keys(captured).map(function (k) {
        return { base: captured[k].base.toString(), size: captured[k].size };
      })});
      s('  共捕获 ' + Object.keys(captured).length + ' 个 RX 段');
    });
  }
});
s('[boot] 最终定位就绪');
