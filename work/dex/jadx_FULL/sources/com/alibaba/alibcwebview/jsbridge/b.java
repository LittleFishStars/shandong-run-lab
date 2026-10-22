package com.alibaba.alibcwebview.jsbridge;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import com.alibaba.alibcwebview.callback.INativeToJsCallback;
import com.alibaba.alibcwebview.container.BCWebView;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.zj.adlib.o61;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b implements AlibcJsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23724a = AlibcJsCallback.class.getSimpleName();
    private static boolean b = true;
    private BCWebView c;
    private String d;
    private String e;
    private String f;
    private boolean g = false;
    private String h = null;

    public b(BCWebView bCWebView, String str, String str2, String str3) {
        this.c = bCWebView;
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public static void a(final WebView webView, String str, String str2, final INativeToJsCallback iNativeToJsCallback) {
        String str3 = String.format("window.AliBCBridge && window.AliBCBridge.bcDispatchEvent('%s', '%%s', %s);", str, null);
        if (AlibcBaseTradeCommon.isDebug() && !TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
                AlibcLogger.e(f23724a, "return param is not a valid json!\n" + str3 + "\n" + str2);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        try {
            final String str4 = String.format(str3, a(str2));
            webView.post(new Runnable() { // from class: com.alibaba.alibcwebview.jsbridge.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(webView, str4, iNativeToJsCallback);
                }
            });
        } catch (Exception e) {
            AlibcLogger.e(f23724a, "callback error. " + e.getMessage());
        }
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback
    public final void fail(String str) {
        AlibcLogger.e(f23724a, "native callBack to js error");
        a(this.c, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onFailure(%s,'%%s');", this.d), str);
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback
    public final void success() {
        c cVar = new c();
        cVar.h = "0";
        cVar.i = "BC_SUCCESS";
        a(cVar);
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback
    public final void fail(Map<String, Object> map) {
        AlibcLogger.e(f23724a, "native callBack to js error");
        a(this.c, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onFailure(%s,'%%s');", this.d), a(map).a());
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback
    public final void success(String str) {
        a(this.c, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onSuccess(%s,'%%s');", this.d), str);
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback
    public final void success(Map<String, Object> map) {
        a(a(map));
    }

    private void a(c cVar) {
        a(this.c, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onSuccess(%s,'%%s');", this.d), cVar.a());
    }

    private static void a(final WebView webView, String str, String str2) {
        if (AlibcBaseTradeCommon.isDebug() && !TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
                AlibcLogger.e(f23724a, "return param is not a valid json!\n" + str + "\n" + str2);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        try {
            final String str3 = String.format(str, a(str2));
            webView.post(new Runnable() { // from class: com.alibaba.alibcwebview.jsbridge.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(webView, str3);
                }
            });
        } catch (Exception e) {
            AlibcLogger.e(f23724a, "callback exception: " + e.getMessage());
        }
    }

    public static void a(WebView webView, String str) {
        a(webView, str, new ValueCallback<String>() { // from class: com.alibaba.alibcwebview.jsbridge.b.3
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
            }
        });
    }

    public static void a(WebView webView, String str, final INativeToJsCallback iNativeToJsCallback) {
        a(webView, str, new ValueCallback<String>() { // from class: com.alibaba.alibcwebview.jsbridge.b.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str2) {
                if ("true".equals(str2)) {
                    iNativeToJsCallback.a(true);
                } else {
                    iNativeToJsCallback.a(false);
                }
            }
        });
    }

    private static void a(WebView webView, String str, ValueCallback<String> valueCallback) {
        while (webView != null) {
            if (str != null && str.length() > 10 && com.alibaba.ariver.remotedebug.b.k.equals(str.substring(0, 11).toLowerCase())) {
                str = str.substring(11);
            }
            if (!b) {
                return;
            }
            try {
                webView.evaluateJavascript(str, valueCallback);
                return;
            } catch (IllegalStateException unused) {
                b = false;
            } catch (NoSuchMethodError unused2) {
                b = false;
            } catch (Throwable th) {
                AlibcLogger.e(f23724a, "evaluateJavascript exception: " + th.getMessage());
                return;
            }
        }
    }

    private static String a(String str) {
        if (str.contains("\u2028")) {
            try {
                str = str.replace("\u2028", "\\u2028");
            } catch (Exception e) {
                AlibcLogger.e(f23724a, "string replace exception: " + e.getMessage());
            }
        }
        if (str.contains("\u2029")) {
            try {
                str = str.replace("\u2029", "\\u2029");
            } catch (Exception e2) {
                AlibcLogger.e(f23724a, "string replace exception: " + e2.getMessage());
            }
        }
        return str.replace(o61.h, "\\\\").replace("'", "\\'");
    }

    private static c a(Map<String, Object> map) {
        c cVar = new c();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("code".equals(key)) {
                    cVar.h = String.valueOf(value);
                } else if ("msg".equals(key)) {
                    cVar.i = String.valueOf(value);
                } else if (!TextUtils.isEmpty(key)) {
                    cVar.g.put(key, value);
                }
            }
        }
        return cVar;
    }
}
