// spoof_sig2.js —— 在 Signature.toByteArray() 处返回原版证书
//
// 依据（本轮 sig_route.js 实测调用链）：
//   MyJni.load(native)
//     → ApplicationPackageManager.getPackageInfo("com.huachenjie.shandong_school", 0x40)
//     → Signature.toByteArray()          ← ★ 唯一必经点，壳自己也会读
//     → 写 .cache/.rpcesredsopoiu.bin
//     → System.exit(0)
//
// 上一版 spoof_sig.js 替换的是 PackageInfo.signatures 字段，未生效；
// 这里直接换 toByteArray() 的返回值（更靠后、更贴近壳的读取动作）。
// 原版证书 DER 779 B，sha256=3571253832dc0f23a48718eafae173ee9d0f04e1d3a06d343e3787a6c41830ad
// 调试证书 DER 761 B，sha256=1417a9cfe8fc662aef6179ac56350201fd4490e3c7e53b4a8a166168e86cfcae

'use strict';

// 原版证书 DER（hex，1558 字符）
var ORIG_HEX = '30820307308201efa00302010202040cfe2b19300d06092a864886f70d01010b05003033310b300906035504061302636e3111300f060355040813087a68656a69616e673111300f0603550407130868616e677a686f753020170d3230303930373031353830385a180f32313230303831343031353830385a3033310b300906035504061302636e3111300f060355040813087a68656a69616e673111300f0603550407130868616e677a686f7530820122300d06092a864886f70d01010105000382010f003082010a028201010086b7057f25ae2c3f34a6f3381b789c73f76cfa689d1329c724dc1de500cb0aab65ecc2b6e04240e2220ab71e06bb5929fdce3de6d8546dfd8a94e38876a0d04cbe8798f424fcd506495d7052937faa0ff8da74944f6b19e5a1b0cfeb63e6e29e5013a06df2514339e9a68abb5299a84c0465c842c70df538444e096d12910dad5e5a99912cca4e1eaf9cf1f52a4b3f13b28909b6918a12e8f00bdd1f07a390b12d2a14f261c79747d781124ecab1f84c21fd179003a19ec16b8e7502cf87f274269ea7476f1c976dc204f518646d0cd6aea504897a3024f2b4d396dd588ae900347637f245e69f0936f04f9217517aa05fe77ddf87b858371f60ed7ca2110cd90203010001a321301f301d0603551d0e041604140af366dcc6a21a27e669e9ba3dd49bdaf52f4964300d06092a864886f70d01010b0500038201010081db50e2924a121fe2e601152113d7871f8ec5dd3b9dc3b065494c3df4ed68605f74d260186d4bafe30616ca7201eb682fa7e7622c2d0f36b0f4a2e9c843a7d40b9eee04fa148c258d90d02369b1739be22c6b33781e0b6cf3e82bcab38d30e2b66e9a3ae2511b31161127299b5912833408a604cdaf113f3115dcb60e6b4a9bdde8ff7c20c9583e7659e54d6474a42fbfb2452d5d87f2a9001049f2b046d428bfb776cb398a7af7c4e270472938703d77348842a8898c704002115a9f468c49e02e5c0086e04cfa806d29ca37508dbf78726a9890a85951972360f32eff7ceda72e181f8501ad019565b488d2e08f66dad649f89092de7ebe05ae3dca265e12';

var ORIG_BYTES = (function () {
    var a = [];
    for (var i = 0; i < ORIG_HEX.length; i += 2) a.push(parseInt(ORIG_HEX.substr(i, 2), 16));
    return a;
})();

var n = 0;
function log(m) { if (n++ > 300) return; send({ t: 'log', msg: String(m) }); }

function sha256(u8) {
    try {
        var MD = Java.use('java.security.MessageDigest').getInstance('SHA-256');
        var jb = Java.array('byte', Array.prototype.slice.call(u8));
        var r = new Uint8Array(MD.digest(jb)), s = '';
        for (var i = 0; i < r.length; i++) s += ('0' + r[i].toString(16)).slice(-2);
        return s;
    } catch (e) { return 'err'; }
}

var DBG_SHA = '1417a9cfe8fc662aef6179ac56350201fd4490e3c7e53b4a8a166168e86cfcae';
var ORIG_SHA = '3571253832dc0f23a48718eafae173ee9d0f04e1d3a06d343e3787a6c41830ad';

log('[*] 原版证书已装载: ' + ORIG_BYTES.length + ' 字节');

Java.perform(function () {
    log('[+] Java.perform 进入');

    // ① Signature.toByteArray() → 换原版
    try {
        var Sig = Java.use('android.content.pm.Signature');
        Sig.toByteArray.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var b = new Uint8Array(r);
                    var h = sha256(b);
                    if (h === DBG_SHA) {
                        log('[SPOOF] toByteArray() ' + b.length + ' B (调试证书) → 换原版 ' +
                            ORIG_BYTES.length + ' B');
                        return Java.array('byte', ORIG_BYTES);
                    }
                    log('     toByteArray() ' + b.length + ' B sha=' + h.substring(0, 16));
                } catch (e) { }
                return r;
            };
        });
        log('[+] Signature.toByteArray 已挂');
    } catch (e) { log('[-] toByteArray 挂载失败 ' + e); }

    // ② 直接改 Signature 内部字段 mSignature（更底层，防止壳绕过 toByteArray）
    try {
        var Sig2 = Java.use('android.content.pm.Signature');
        Sig2.$init.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var f = this.mSignature.value;
                    if (f) {
                        var b = new Uint8Array(f);
                        if (b.length === 761) {
                            log('[FIELD] Signature.<init> 761 B → 改写 mSignature');
                            this.mSignature.value = Java.array('byte', ORIG_BYTES);
                        }
                    }
                } catch (e) { }
                return r;
            };
        });
        log('[+] Signature.<init> 已挂');
    } catch (e) { }

    // ③ getPackageInfo 返回后立刻修正 signatures 数组内容
    try {
        var PM = Java.use('android.app.ApplicationPackageManager');
        PM.getPackageInfo.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var flags = arguments[1];
                    if ((flags & 0x40) !== 0 && r) {
                        var arr = r.signatures.value;
                        if (arr && arr.length) {
                            var b = new Uint8Array(arr[0].toByteArray());
                            log('[PKG] getPackageInfo(0x40) signatures[0] ' + b.length + ' B');
                            if (b.length === 761) {
                                arr[0] = Sig2.$new(Java.array('byte', ORIG_BYTES));
                                log('[PKG] → 已替换为原版 Signature 对象');
                            }
                        }
                    }
                } catch (e) { log('     [PKG] 处理异常 ' + e); }
                return r;
            };
        });
        log('[+] getPackageInfo 已挂');
    } catch (e) { }

    // ④ System.exit 只记录（先不阻断，观察 spoof 是否足以让壳放行）
    try {
        var Sys = Java.use('java.lang.System');
        Sys.exit.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[EXIT] System.exit(' + arguments[0] + ') —— spoof 未能阻止');
                return ov.apply(this, arguments);
            };
        });
        log('[+] System.exit 已挂');
    } catch (e) { }
});

// ⑤ 兜底：如果壳改用 SigningInfo 路径
setTimeout(function () {
    Java.perform(function () {
        try {
            var SI = Java.use('android.content.pm.SigningInfo');
            ['getApkContentsSigners', 'getSigningCertificateHistory'].forEach(function (m) {
                try {
                    SI[m].overloads.forEach(function (ov) {
                        ov.implementation = function () {
                            log('[SI] SigningInfo.' + m + '() 被调用');
                            return ov.apply(this, arguments);
                        };
                    });
                } catch (e) { }
            });
        } catch (e) { }
    });
}, 800);

log('[*] spoof_sig2.js 装载完成');
