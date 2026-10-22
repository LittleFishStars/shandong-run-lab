package com.ali.auth.third.ui.support;

import android.webkit.WebView;
import com.ali.auth.third.core.trace.SDKLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WebViewActivitySupport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23536a = "WebViewActivitySupport";
    public String lastReloadUrl;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final WebViewActivitySupport f23537a = new WebViewActivitySupport();
    }

    private WebViewActivitySupport() {
        this.lastReloadUrl = "";
    }

    public static WebViewActivitySupport getInstance() {
        return b.f23537a;
    }

    public void safeReload(WebView webView) {
        String url = webView.getUrl();
        SDKLogger.d(f23536a, "reload url: " + url);
        if (url == null) {
            webView.loadUrl(this.lastReloadUrl);
        } else {
            webView.reload();
        }
    }
}
