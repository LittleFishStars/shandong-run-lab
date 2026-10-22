package com.huachenjie.common.webview;

import android.util.Log;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class JsCallback {
    public static final String b = "javascript:%s.callback(%d, %d %s);";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f33965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f8970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<WebView> f8971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8972a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f8973b;

    public static class JsCallbackException extends Exception {
        public JsCallbackException(String msg) {
            super(msg);
        }
    }

    public JsCallback(WebView view, String injectedName, int index) {
        this.f8971a = new WeakReference<>(view);
        this.f8970a = injectedName;
        this.f33965a = index;
    }

    public void a(Object... args) throws JsCallbackException {
        if (this.f8971a.get() == null) {
            throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
        }
        if (!this.f8972a) {
            throw new JsCallbackException("the JsCallback isn't permanent,cannot be called more than once");
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : args) {
            sb.append(",");
            boolean z = obj instanceof String;
            if (z) {
                sb.append("\"");
            }
            sb.append(String.valueOf(obj));
            if (z) {
                sb.append("\"");
            }
        }
        String str = String.format(b, this.f8970a, Integer.valueOf(this.f33965a), Integer.valueOf(this.f8973b), sb.toString());
        Log.d("JsCallBack", str);
        this.f8971a.get().loadUrl(str);
        this.f8972a = this.f8973b > 0;
    }

    public void b(boolean z) {
        this.f8973b = z ? 1 : 0;
    }
}
