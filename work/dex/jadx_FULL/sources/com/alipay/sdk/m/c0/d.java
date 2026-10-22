package com.alipay.sdk.m.c0;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alipay.sdk.m.y.j;
import com.alipay.sdk.m.y.q;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends com.alipay.sdk.m.c0.c implements com.alipay.sdk.m.c0.e.f, com.alipay.sdk.m.c0.e.g, com.alipay.sdk.m.c0.e.h {
    public static final String A = "exit";
    public static final String B = "action";
    public static final String C = "pushWindow";
    public static final String D = "h5JsFuncCallback";
    public static final String E = "sdkInfo";
    public static final String F = "canUseTaoLogin";
    public static final String G = "taoLogin";
    public static final String H = "h5LifeCycle";
    public static final String I = "netWorkReachableType";
    public static final String m = "sdk_result_code:";
    public static final String n = "alipayjsbridge://";
    public static final String o = "onBack";
    public static final String p = "setTitle";
    public static final String q = "onRefresh";
    public static final String r = "showBackButton";
    public static final String s = "onExit";
    public static final String t = "onLoadJs";
    public static final String u = "callNativeFunc";
    public static final String v = "back";
    public static final String w = "title";
    public static final String x = "refresh";
    public static final String y = "backButton";
    public static final String z = "refreshButton";
    public boolean e;
    public String f;
    public boolean g;
    public final com.alipay.sdk.m.w.a h;
    public boolean i;
    public String j;
    public com.alipay.sdk.m.c0.e k;
    public com.alipay.sdk.m.c0.f l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f25405a.finish();
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.c0.e f25407a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.alipay.sdk.m.c0.e eVar) {
            super(null);
            this.f25407a = eVar;
        }

        @Override // com.alipay.sdk.m.c0.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f25407a.b();
            d.this.g = false;
        }
    }

    public class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.c0.e f25408a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.alipay.sdk.m.c0.e eVar, String str) {
            super(null);
            this.f25408a = eVar;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.c0.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.f25408a);
            d.this.k.a(this.b);
            d.this.g = false;
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.c0.d$d, reason: collision with other inner class name */
    public class RunnableC0192d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f25409a;
        public final /* synthetic */ SslErrorHandler b;

        /* JADX INFO: renamed from: com.alipay.sdk.m.c0.d$d$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC0192d.this.b.cancel();
                com.alipay.sdk.m.m.a.b(d.this.h, "net", com.alipay.sdk.m.m.b.A, "2");
                com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a());
                RunnableC0192d.this.f25409a.finish();
            }
        }

        public RunnableC0192d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.f25409a = activity;
            this.b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.sdk.m.c0.b.a(this.f25409a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(), null, null);
        }
    }

    public static abstract class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static class g implements com.alipay.sdk.m.l.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f25412a;
        public final String b;

        public g(f fVar, String str) {
            this.f25412a = fVar;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.l.d.a
        public void a(boolean z, JSONObject jSONObject, String str) {
            try {
                this.f25412a.a(new JSONObject().put("success", z).put("random", this.b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, com.alipay.sdk.m.w.a aVar, String str) {
        super(activity, str);
        this.e = false;
        this.f = "GET";
        this.g = false;
        this.k = null;
        this.l = new com.alipay.sdk.m.c0.f();
        this.h = aVar;
        f();
    }

    @Override // com.alipay.sdk.m.c0.c
    public synchronized void c() {
        this.k.b();
        this.l.a();
    }

    public final synchronized boolean d() {
        if (this.l.b()) {
            this.f25405a.finish();
        } else {
            this.g = true;
            com.alipay.sdk.m.c0.e eVar = this.k;
            this.k = this.l.c();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new b(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.k);
        }
        return true;
    }

    public final synchronized void e() {
        Activity activity = this.f25405a;
        com.alipay.sdk.m.c0.e eVar = this.k;
        if (activity != null && eVar != null) {
            if (this.e) {
                activity.finish();
            } else {
                eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    public final synchronized boolean f() {
        try {
            com.alipay.sdk.m.c0.e eVar = new com.alipay.sdk.m.c0.e(this.f25405a, this.h, new com.alipay.sdk.m.c0.e.C0194e(!a(), !a()));
            this.k = eVar;
            eVar.setChromeProxy(this);
            this.k.setWebClientProxy(this);
            this.k.setWebEventProxy(this);
            addView(this.k);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    public final void g() {
        com.alipay.sdk.m.c0.e eVar = this.k;
        if (eVar != null) {
            WebView webView = eVar.getWebView();
            if (TextUtils.isEmpty(this.j)) {
                webView.loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
                return;
            }
            String strA = com.alipay.sdk.m.y.f.a(this.j);
            if (TextUtils.isEmpty(strA)) {
                com.alipay.sdk.m.m.a.b(this.h, com.alipay.sdk.m.m.b.l, "injectJsApi", "escapeCashierBizDataError");
            } else {
                webView.evaluateJavascript("(function() {window.alipayjsbridgeCashierMainData=" + ("'" + strA.substring(1, strA.length() - 1) + "'") + ";})();", null);
            }
            webView.loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    public boolean h() {
        return this.i;
    }

    public final synchronized void i() {
        WebView webView = this.k.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            com.alipay.sdk.m.c0.f fVar = this.l;
            if (fVar == null || fVar.b()) {
                a(false);
            } else {
                d();
            }
        }
    }

    public final void j() {
        com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "webViewLoadStart");
        if (!com.alipay.sdk.m.o.b.i().i(null)) {
            com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "webLoad|onlineUrl");
            return;
        }
        if (!com.alipay.sdk.m.r.b.e().c()) {
            com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "webLoad|localUrl");
            return;
        }
        com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "webLoad|local|" + com.alipay.sdk.m.r.b.e().f());
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.g ? true : super.onInterceptTouchEvent(motionEvent);
    }

    public synchronized void setCashierBizData(String str) {
        this.j = str;
    }

    @Override // com.alipay.sdk.m.c0.c
    public synchronized boolean b() {
        Activity activity = this.f25405a;
        if (activity == null) {
            return true;
        }
        if (!a()) {
            if (!this.g) {
                e();
            }
            return true;
        }
        com.alipay.sdk.m.c0.e eVar = this.k;
        if (eVar != null && eVar.getWebView() != null) {
            if (!eVar.getWebView().canGoBack()) {
                com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a());
                activity.finish();
            } else if (h()) {
                com.alipay.sdk.m.l.c cVarA = com.alipay.sdk.m.l.c.a(com.alipay.sdk.m.l.c.NETWORK_ERROR.c());
                com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a(cVarA.c(), cVarA.b(), ""));
                activity.finish();
            } else if (this.e) {
                com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a());
                activity.finish();
            }
            return true;
        }
        activity.finish();
        return true;
    }

    public synchronized void a(String str, String str2, boolean z2) {
        this.f = str2;
        this.k.getTitle().setText(str);
        this.e = z2;
    }

    @Override // com.alipay.sdk.m.c0.e.g
    public synchronized boolean c(com.alipay.sdk.m.c0.e eVar, String str) {
        com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "h5ld", SystemClock.elapsedRealtime() + "|" + q.i(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            g();
        }
        return false;
    }

    public final synchronized void a(boolean z2) {
        com.alipay.sdk.m.l.b.a(z2);
        this.f25405a.finish();
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<com.alipay.sdk.m.c0.e> f25411a;
        public final String b;
        public final String c;
        public final JSONObject d;
        public boolean e = false;

        public f(com.alipay.sdk.m.c0.e eVar, String str, String str2, JSONObject jSONObject) {
            this.f25411a = new WeakReference<>(eVar);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
        }

        public void a(JSONObject jSONObject) {
            com.alipay.sdk.m.c0.e eVar;
            if (this.e || (eVar = (com.alipay.sdk.m.c0.e) q.a(this.f25411a)) == null) {
                return;
            }
            this.e = true;
            eVar.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.c), a(jSONObject.toString())));
        }

        public static String a(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }
    }

    @Override // com.alipay.sdk.m.c0.c
    public synchronized void a(String str) {
        com.alipay.sdk.m.y.g.d(com.alipay.sdk.m.n.a.B, "WebContainerImpl loadUrl:" + str);
        j();
        if ("POST".equals(this.f)) {
            this.k.a(str, (byte[]) null);
        } else {
            this.k.a(str);
        }
        com.alipay.sdk.m.c0.c.a(this.k.getWebView());
    }

    @Override // com.alipay.sdk.m.c0.e.g
    public synchronized boolean d(com.alipay.sdk.m.c0.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.f25405a;
        if (activity == null) {
            return true;
        }
        if (q.a(this.h, str, activity)) {
            return true;
        }
        if (str.startsWith(n)) {
            b(str.substring(17));
        } else if (TextUtils.equals(str, com.alipay.sdk.m.n.a.r)) {
            a(false);
        } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, th);
            }
        } else {
            this.k.a(str);
        }
        return true;
    }

    @Override // com.alipay.sdk.m.c0.e.f
    public synchronized boolean a(com.alipay.sdk.m.c0.e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(m)) {
            this.f25405a.runOnUiThread(new a());
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.alipay.sdk.m.c0.e.f
    public synchronized void a(com.alipay.sdk.m.c0.e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.k.getTitle().setText(str);
        }
    }

    public final synchronized boolean b(String str, String str2) {
        com.alipay.sdk.m.c0.e eVar = this.k;
        try {
            com.alipay.sdk.m.c0.e eVar2 = new com.alipay.sdk.m.c0.e(this.f25405a, this.h, new com.alipay.sdk.m.c0.e.C0194e(!a(), !a()));
            this.k = eVar2;
            eVar2.setChromeProxy(this);
            this.k.setWebClientProxy(this);
            this.k.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.k.getTitle().setText(str2);
            }
            this.g = true;
            this.l.a(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new c(eVar, str));
            this.k.setAnimation(translateAnimation);
            addView(this.k);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    @Override // com.alipay.sdk.m.c0.e.g
    public WebResourceResponse a(WebView webView, String str) {
        if (!com.alipay.sdk.m.r.b.e().c()) {
            return null;
        }
        WebResourceResponse webResourceResponseA = com.alipay.sdk.m.y.e.a(com.alipay.sdk.m.r.b.e().b(str));
        if (webResourceResponseA == null) {
            return webResourceResponseA;
        }
        com.alipay.sdk.m.y.g.b(com.alipay.sdk.m.n.a.B, "shouldInterceptRequest return not null, url=" + str);
        return webResourceResponseA;
    }

    @Override // com.alipay.sdk.m.c0.e.g
    public synchronized boolean a(com.alipay.sdk.m.c0.e eVar, int i, String str, String str2) {
        this.i = true;
        com.alipay.sdk.m.m.a.b(this.h, "net", com.alipay.sdk.m.m.b.y, "onReceivedError:" + i + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.m.c0.e.g
    public synchronized boolean a(com.alipay.sdk.m.c0.e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f25405a;
        if (activity == null) {
            return true;
        }
        com.alipay.sdk.m.m.a.b(this.h, "net", com.alipay.sdk.m.m.b.z, "2-" + sslError);
        activity.runOnUiThread(new RunnableC0192d(activity, sslErrorHandler));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00a3  */
    public final synchronized void a(String str, String str2, String str3) {
        com.alipay.sdk.m.c0.e eVar = this.k;
        if (eVar == null) {
            return;
        }
        JSONObject jSONObjectH = q.h(str3);
        f fVar = new f(eVar, str, str2, jSONObjectH);
        Context context = eVar.getContext();
        try {
            switch (fVar.b) {
                case "title":
                    if (jSONObjectH.has("title")) {
                        eVar.getTitle().setText(jSONObjectH.optString("title", ""));
                        break;
                    }
                    break;
                case "refresh":
                    eVar.getWebView().reload();
                    break;
                case "back":
                    i();
                    break;
                case "exit":
                    com.alipay.sdk.m.l.b.a(jSONObjectH.optString("result", null));
                    a(jSONObjectH.optBoolean("success", false));
                    break;
                case "backButton":
                    eVar.getBackButton().setVisibility(jSONObjectH.optBoolean("show", true) ? 0 : 4);
                    break;
                case "refreshButton":
                    eVar.getRefreshButton().setVisibility(jSONObjectH.optBoolean("show", true) ? 0 : 4);
                    break;
                case "pushWindow":
                    b(jSONObjectH.optString("url"), jSONObjectH.optString("title", ""));
                    break;
                case "sdkInfo":
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdk_version", "15.8.42");
                    jSONObject.put("app_name", this.h.c());
                    jSONObject.put(AlibcCommonConstant.APP_VERSION, this.h.d());
                    fVar.a(jSONObject);
                    break;
                case "canUseTaoLogin":
                    String url = eVar.getUrl();
                    if (!q.a(this.h, url)) {
                        com.alipay.sdk.m.m.a.b(this.h, com.alipay.sdk.m.m.b.l, "jsUrlErr", url);
                        break;
                    } else {
                        JSONObject jSONObject2 = new JSONObject();
                        boolean zA = com.alipay.sdk.m.l.d.a(this.h, context);
                        jSONObject2.put("enabled", zA);
                        com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.t0, String.valueOf(zA));
                        fVar.a(jSONObject2);
                        break;
                    }
                    break;
                case "taoLogin":
                    String url2 = eVar.getUrl();
                    if (!q.a(this.h, url2)) {
                        com.alipay.sdk.m.m.a.b(this.h, com.alipay.sdk.m.m.b.l, "jsUrlErr", url2);
                        break;
                    } else {
                        String strOptString = jSONObjectH.optString("random");
                        JSONObject jSONObjectOptJSONObject = jSONObjectH.optJSONObject("options");
                        if (!TextUtils.isEmpty("random") && jSONObjectOptJSONObject != null) {
                            String strOptString2 = jSONObjectOptJSONObject.optString("url");
                            String strOptString3 = jSONObjectOptJSONObject.optString("action");
                            if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && (context instanceof Activity)) {
                                com.alipay.sdk.m.l.d.a(this.h, (Activity) context, 1010, strOptString2, strOptString3, new g(fVar, strOptString));
                            }
                        }
                        break;
                    }
                    break;
                case "h5LifeCycle":
                    String strOptString4 = jSONObjectH.optString("type");
                    com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "h5LifeCycle|" + strOptString4);
                    break;
                case "netWorkReachableType":
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result", !com.alipay.sdk.m.o.b.i().g(null) ? "-2" : j.a(getContext()));
                    fVar.a(jSONObject3);
                    break;
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "jInfoErr", th, str);
        }
    }

    @Override // com.alipay.sdk.m.c0.e.g
    public synchronized boolean b(com.alipay.sdk.m.c0.e eVar, String str) {
        com.alipay.sdk.m.m.a.a(this.h, com.alipay.sdk.m.m.b.l, "h5ldd", SystemClock.elapsedRealtime() + "|" + q.i(str));
        g();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    public final synchronized void b(String str) {
        com.alipay.sdk.m.y.g.d(com.alipay.sdk.m.n.a.B, "processJsBridge urlContent:" + str);
        Map<String, String> mapB = q.b(this.h, str);
        if (str.startsWith(u)) {
            a(mapB.get("func"), mapB.get("cbId"), mapB.get("data"));
        } else if (str.startsWith(o)) {
            i();
        } else if (str.startsWith(p) && mapB.containsKey("title")) {
            this.k.getTitle().setText(mapB.get("title"));
        } else if (str.startsWith(q)) {
            this.k.getWebView().reload();
        } else if (str.startsWith(r) && mapB.containsKey("bshow")) {
            this.k.getBackButton().setVisibility(TextUtils.equals("true", mapB.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(s)) {
            com.alipay.sdk.m.l.b.a(mapB.get("result"));
            a(TextUtils.equals("true", mapB.get("bsucc")));
        } else if (str.startsWith(t)) {
            this.k.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    @Override // com.alipay.sdk.m.c0.e.h
    public synchronized void b(com.alipay.sdk.m.c0.e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }

    @Override // com.alipay.sdk.m.c0.e.h
    public synchronized void a(com.alipay.sdk.m.c0.e eVar) {
        e();
    }
}
