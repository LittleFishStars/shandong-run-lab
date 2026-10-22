package com.byazt.jwd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.bzd.x;
import com.byazt.nr.m;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 769, 13})
public class tt {
    public WeakReference<Context> c;
    public boolean tt = true;
    public boolean ve = true;
    public boolean uj = true;
    public boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28701a = true;
    public boolean sp = true;
    public boolean x = true;

    private tt(Context context) {
        this.c = new WeakReference<>(context);
    }

    public static tt c(Context context) {
        return new tt(context);
    }

    public tt tt(boolean z) {
        this.ve = z;
        return this;
    }

    private void tt(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            m.ve(th.toString());
        }
    }

    public tt c(boolean z) {
        this.x = z;
        return this;
    }

    public void c(final com.byazt.nl.uj ujVar) {
        x.c(new Runnable() { // from class: com.byazt.jwd.tt.1
            @Override // java.lang.Runnable
            public void run() {
                tt.this.c(ujVar.getWebView());
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void c(WebView webView) {
        if (webView == null || this.c.get() == null) {
            return;
        }
        tt(webView);
        WebSettings settings = webView.getSettings();
        c(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            m.c(e);
        }
        try {
            if (this.ve) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.uj);
        settings.setDomStorageEnabled(this.n);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.sp);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.x = false;
        }
        try {
            boolean z = this.x;
            if (!z) {
                webView.setLayerType(0, null);
            } else if (z) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            m.c(th2);
        }
    }

    private void c(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            m.ve(th.toString());
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head?.appendChild(script);})();";
    }
}
