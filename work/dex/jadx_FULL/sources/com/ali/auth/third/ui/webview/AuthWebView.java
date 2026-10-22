package com.ali.auth.third.ui.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ali.auth.third.core.util.CommonUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@SuppressLint({"SetJavaScriptEnabled"})
public class AuthWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f23538a;
    private HashMap<String, String> b;
    private String c;

    public AuthWebView(Context context) {
        super(context);
        this.f23538a = new HashMap();
        this.b = new HashMap<>();
        a(context, true);
    }

    public AuthWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23538a = new HashMap();
        this.b = new HashMap<>();
        a(context, true);
    }

    public AuthWebView(Context context, boolean z) {
        super(context);
        this.f23538a = new HashMap();
        this.b = new HashMap<>();
        a(context, z);
    }

    @TargetApi(21)
    private void a(Context context, boolean z) {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        settings.setSavePassword(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setDomStorageEnabled(true);
        String path = context.getApplicationContext().getDir("cache", 0).getPath();
        this.c = path;
        settings.setAppCachePath(path);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAppCacheEnabled(true);
        if (CommonUtils.isNetworkAvailable(context)) {
            settings.setCacheMode(-1);
        } else {
            settings.setCacheMode(1);
        }
        settings.setBuiltInZoomControls(false);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        } catch (Throwable unused2) {
        }
    }

    public final void addBridgeObject(String str, Object obj) {
        this.f23538a.put(str, obj);
    }

    @Override // android.webkit.WebView
    public final void addJavascriptInterface(Object obj, String str) {
    }

    public Object getBridgeObj(String str) {
        return this.f23538a.get(str);
    }

    public HashMap<String, String> getContextParameters() {
        return this.b;
    }
}
