package com.kc.cw.ad.internal.c;

import android.webkit.CookieManager;
import android.webkit.WebView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class t {
    public static String a() {
        return null;
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setMixedContentMode(0);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setAllowContentAccess(false);
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(webView, true);
            } else {
                f.b(f.f38946a, "Failed to set Webview to accept 3rd party cookie");
            }
            webView.getSettings().setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setCacheMode(-1);
            WebView.setWebContentsDebuggingEnabled(false);
        } catch (Exception e) {
            f.e(f.e, "Unable update webview settings - Exception: " + e.getMessage());
        }
    }

    public static void b(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void c(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }
}
