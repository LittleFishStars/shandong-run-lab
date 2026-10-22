package com.zj.adlib;

import android.webkit.WebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ti4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44931a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19827a = "JavaScriptInterface";
    public static final int b = 1;

    public static void a(WebView webView) {
        webView.getWebChromeClient().onCloseWindow(webView);
    }
}
