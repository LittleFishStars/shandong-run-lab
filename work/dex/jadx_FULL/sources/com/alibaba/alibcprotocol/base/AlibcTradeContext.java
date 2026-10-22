package com.alibaba.alibcprotocol.base;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.param.AlibcShowParams;
import com.alibaba.alibcprotocol.param.AlibcTaokeParams;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTradeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebViewClient f23605a;
    private WebChromeClient b;
    public AlibcBizParams bizParams;
    public Context context;
    public ConcurrentHashMap<String, String> convertedUrls;
    public Map<String, Object> extParams;
    public WeakReference<Activity> mActivity;
    public WeakReference<Activity> mRawActivity;
    public WeakReference<WebView> mWebView;
    public AlibcShowParams showParams;
    public AlibcTaokeParams taokeParams;
    public Map<String, String> trackParams;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AlibcTradeContext f23606a = new AlibcTradeContext();
    }

    public static AlibcTradeContext getInstance() {
        return a.f23606a;
    }

    public WebChromeClient getWebChromeClient() {
        return this.b;
    }

    public WebViewClient getWebViewClient() {
        return this.f23605a;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.b = webChromeClient;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f23605a = webViewClient;
    }

    public boolean valid() {
        WeakReference<Activity> weakReference;
        WeakReference<WebView> weakReference2 = this.mWebView;
        return (weakReference2 == null || weakReference2.get() == null || (weakReference = this.mActivity) == null || weakReference.get() == null) ? false : true;
    }

    private AlibcTradeContext() {
    }
}
