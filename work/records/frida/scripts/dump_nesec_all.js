// dump_nesec_all.js —— 完整 dump libnesec.so 的运行时内存镜像
// 用 Process.getModuleByName 拿到权威 base/size，先校验 ELF 头，再分块回传。
// 说明：本脚本跑在「无壳版」APK 上（没有壳的反 Frida），所以可以放心 spawn。

var CHUNK = 131072; // 128 KB

function dumpModule() {
    var m = null;
    try {
        m = Process.findModuleByName('libnesec.so');
    } catch (e) { }
    if (m === null) {
        try {
            Process.enumerateModules().forEach(function (x) {
                if (x.name.indexOf('nesec') >= 0) { m = x; }
            });
        } catch (e2) { }
    }
    if (m === null) { send({ t: 'log', msg: '未找到 libnesec.so' }); return; }

    send({ t: 'log', msg: '模块 ' + m.name + ' base=' + m.base + ' size=' + m.size + ' path=' + m.path });

    var head = m.base.readByteArray(16);
    var hb = new Uint8Array(head);
    var hex = [];
    for (var i = 0; i < hb.length; i++) {
        hex.push(('0' + hb[i].toString(16)).slice(-2));
    }
    send({ t: 'log', msg: 'ELF 头: ' + hex.join(' ') });

    // ★ 逐页读：壳把某些区间做成洞/guard，整块 readByteArray 会整体失败。
    var PAGE = 4096;
    var holes = [];
    var off = 0;
    while (off < m.size) {
        var n = Math.min(CHUNK, m.size - off);
        var data = [];
        var got = 0;
        for (var p = 0; p < n; p += PAGE) {
            var len = Math.min(PAGE, n - p);
            var one = null;
            try { one = m.base.add(off + p).readByteArray(len); } catch (e3) { one = null; }
            if (one === null) {
                if (len === PAGE) { holes.push(off + p); }
                else { holes.push(-(off + p)); }
                data.push(new Uint8Array(len));   // 不可读就用 0 填掉，保持偏移对齐
            } else {
                data.push(new Uint8Array(one));
                got += len;
            }
        }
        var buf = new Uint8Array(n);
        var pos = 0;
        for (var k = 0; k < data.length; k++) { buf.set(data[k], pos); pos += data[k].length; }
        send({ t: 'newexec', name: 'nesec_full_0x' + off.toString(16), data: buf.buffer }, buf.buffer);
        off += n;
    }
    if (holes.length > 0) {
        var hs = [];
        for (var h = 0; h < holes.length; h++) {
            var v = holes[h];
            hs.push((v < 0 ? '部分:0x' + (-v).toString(16) : '0x' + v.toString(16)));
        }
        send({ t: 'log', msg: '不可读页 ' + holes.length + ' 个: ' + hs.join(',') });
    }
    send({ t: 'log', msg: 'dump 完成，共 ' + m.size + ' 字节' });
}
// ★ 不能用 setTimeout(1500)：无壳版在 MyJni.load 里约 1 秒内就因 ART 崩溃而退出，
//   所以用 setInterval 每 120ms 探一次，库一出现立刻 dump。
var done = false;
var timer = setInterval(function () {
    if (done) { return; }
    var m = null;
    try { m = Process.findModuleByName('libnesec.so'); } catch (e) { }
    if (m === null) { return; }
    done = true;
    clearInterval(timer);
    dumpModule();
}, 120);
