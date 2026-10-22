// spoof_sig.js —— 冒充原版签名，绕过易盾 NIS 的签名自校验
//
// v2 结论：com.netease.nis.wrapper.MyApplication.attachBaseContext 内，外壳经
//          com.netease.nis.wrapper.MyJni.load() → getPackageInfo(flags=64) 拿到当前
//          APK 签名（实测 761 字节 = 我们的调试证书），与内置原版证书（779 字节）
//          不符 → 立刻 System.exit(0)。阻断 exit 后 attachBaseContext/onCreate 正常走完。
// 本脚本：把 getPackageInfo(GET_SIGNATURES) 的返回替换为原始证书，观察校验是否放行。

'use strict';

var ORIG_HEX = '30820307308201efa00302010202040cfe2b19300d06092a864886f70d01010b05003033310b300906035504061302636e3111300f060355040813087a68656a69616e673111300f0603550407130868616e677a686f753020170d3230303930373031353830385a180f32313230303831343031353830385a3033310b300906035504061302636e3111300f060355040813087a68656a69616e673111300f0603550407130868616e677a686f7530820122300d06092a864886f70d01010105000382010f003082010a028201010086b7057f25ae2c3f34a6f3381b789c73f76cfa689d1329c724dc1de500cb0aab65ecc2b6e04240e2220ab71e06bb5929fdce3de6d8546dfd8a94e38876a0d04cbe8798f424fcd506495d7052937faa0ff8da74944f6b19e5a1b0cfeb63e6e29e5013a06df2514339e9a68abb5299a84c0465c842c70df538444e096d12910dad5e5a99912cca4e1eaf9cf1f52a4b3f13b28909b6918a12e8f00bdd1f07a390b12d2a14f261c79747d781124ecab1f84c21fd179003a19ec16b8e7502cf87f274269ea7476f1c976dc204f518646d0cd6aea504897a3024f2b4d396dd588ae900347637f245e69f0936f04f9217517aa05fe77ddf87b858371f60ed7ca2110cd90203010001a321301f301d0603551d0e041604140af366dcc6a21a27e669e9ba3dd49bdaf52f4964300d06092a864886f70d01010b0500038201010081db50e2924a121fe2e601152113d7871f8ec5dd3b9dc3b065494c3df4ed68605f74d260186d4bafe30616ca7201eb682fa7e7622c2d0f36b0f4a2e9c843a7d40b9eee04fa148c258d90d02369b1739be22c6b33781e0b6cf3e82bcab38d30e2b66e9a3ae2511b31161127299b5912833408a604cdaf113f3115dcb60e6b4a9bdde8ff7c20c9583e7659e54d6474a42fbfb2452d5d87f2a9001049f2b046d428bfb776cb398a7af7c4e270472938703d77348842a8898c704002115a9f468c49e02e5c0086e04cfa806d29ca37508dbf78726a9890a85951972360f32eff7ceda72e181f8501ad019565b488d2e08f66dad649f89092de7ebe05ae3dca265e12';      // 由打包脚本替换为原版证书 DER 的 hex
var exitCount = 0;

function log(m) { send({ t: 'log', msg: String(m) }); }

function hexToBytes(h) {
    var out = new Uint8Array(h.length / 2);
    for (var i = 0; i < out.length; i++) out[i] = parseInt(h.substr(i * 2, 2), 16);
    return out;
}

function bytesToHex(b) {
    return Array.prototype.map.call(new Uint8Array(b), function (x) {
        return ('0' + (x & 0xff).toString(16)).slice(-2);
    }).join('');
}

function sha256Hex(u8) {
    // 纯 JS 实现太大；改用 Java MessageDigest
    try {
        var MD = Java.use('java.security.MessageDigest');
        var md = MD.getInstance('SHA-256');
        var jb = Java.array('byte', Array.prototype.slice.call(u8));
        var d = md.digest(jb);
        return bytesToHex(d);
    } catch (e) { return '<' + e + '>'; }
}

Java.perform(function () {
    log('[+] Java.perform 进入');

    var origBytes = hexToBytes(ORIG_HEX);
    log('[+] 原版证书 ' + origBytes.length + ' 字节，sha256=' +
        sha256Hex(origBytes));

    // ── ① 核心：替换 getPackageInfo 返回的签名 ──
    try {
        var PM = Java.use('android.app.ApplicationPackageManager');
        PM.getPackageInfo.overloads.forEach(function (ov) {
            ov.implementation = function () {
                var r = ov.apply(this, arguments);
                try {
                    var flags = arguments.length > 1 ? arguments[1] : 0;
                    if ((flags & 0x40) && r && r.signatures.value &&
                        r.signatures.value.length > 0) {
                        var real = r.signatures.value[0].toByteArray();
                        log('[SIG] 真实签名 len=' + real.length +
                            ' sha256=' + sha256Hex(real));
                        var Sig = Java.use('android.content.pm.Signature');
                        var forged = Sig.$new(Java.array('byte',
                            Array.prototype.slice.call(origBytes)));
                        var arr = Java.array('android.content.pm.Signature', [forged]);
                        r.signatures.value = arr;
                        log('[SIG] ★ 已替换为原版证书 → 外壳将看到 len=' +
                            origBytes.length);
                    }
                } catch (e) { log('[SIG] 替换失败 ' + e); }
                return r;
            };
        });
        log('[+] 已挂 getPackageInfo（签名替换）');
    } catch (e) { log('[-] getPackageInfo: ' + e); }

    // ── ② 兜底：拦截 exit 但只计数，不阻断（若替换成功就不该触发）──
    ['java.lang.System', 'java.lang.Runtime'].forEach(function (cn) {
        try {
            var C = Java.use(cn);
            C['exit'].overloads.forEach(function (ov) {
                ov.implementation = function () {
                    exitCount++;
                    if (exitCount <= 5) {
                        log('[!!] 仍在调 ' + cn + '.exit —— 替换未生效 (第 ' +
                            exitCount + ' 次)');
                    }
                    return;                  // 仍然阻断，让应用续跑
                };
            });
        } catch (e) { }
    });
    try {
        var R = Java.use('java.lang.Runtime');
        R['halt'].overloads.forEach(function (ov) {
            ov.implementation = function () { log('[!!] Runtime.halt 被调'); return; };
        });
    } catch (e) { }
    try {
        var P = Java.use('android.os.Process');
        P['killProcess'].overloads.forEach(function (ov) {
            ov.implementation = function () { log('[!!] Process.killProcess 被调'); return; };
        });
    } catch (e) { }

    // ── ③ 观察应用是否真的活了 ──
    var alive = 0;
    try {
        var A = Java.use('com.netease.nis.wrapper.MyApplication');
        A.onCreate.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[LIFE] MyApplication.onCreate 进入');
                var r = ov.apply(this, arguments);
                log('[LIFE] MyApplication.onCreate 返回 —— 外壳通过！');
                alive = 1;
                return r;
            };
        });
    } catch (e) { log('[-] MyApplication: ' + e); }

    // 真正的业务 Application
    try {
        var S = Java.use('com.huachenjie.shandong_school.ShandongApplication');
        S.onCreate.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[LIFE] ★★★ ShandongApplication.onCreate 进入 —— 应用真正起来了');
                var r = ov.apply(this, arguments);
                log('[LIFE] ShandongApplication.onCreate 返回');
                return r;
            };
        });
        log('[+] 已挂 ShandongApplication.onCreate');
    } catch (e) { log('[-] ShandongApplication: ' + e); }

    // 首页 Activity
    try {
        var Spl = Java.use('com.huachenjie.shandong_school.splash.SplashActivity');
        Spl.onCreate.overloads.forEach(function (ov) {
            ov.implementation = function () {
                log('[LIFE] ★★★ SplashActivity.onCreate 进入 —— 进到 UI 了！');
                return ov.apply(this, arguments);
            };
        });
        log('[+] 已挂 SplashActivity.onCreate');
    } catch (e) { log('[-] SplashActivity: ' + e); }
});

log('[*] spoof_sig.js 装载完成');
