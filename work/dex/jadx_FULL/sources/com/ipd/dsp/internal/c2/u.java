package com.ipd.dsp.internal.c2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38233a = "IPDWebView";

    public class a extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f38234a;

        public a(Activity activity) {
            this.f38234a = activity;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            k.a("IPDWebView", "console[" + consoleMessage.messageLevel() + u15.f19942b + consoleMessage.message() + "(" + consoleMessage.sourceId() + c49.f40900a + consoleMessage.lineNumber() + ")]");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            k.b("IPDWebView", "onJsAlert [" + str2 + "]");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (str == null || str.equals("")) {
                return;
            }
            try {
                this.f38234a.setTitle(str);
            } catch (Throwable th) {
                r.a(th);
            }
        }
    }

    public class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f38235a;

        public b(Activity activity) {
            this.f38235a = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            k.b("IPDWebView", "onReceivedError.url=" + str2 + "&code=" + i + "&desc=" + str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Map<String, String> requestHeaders;
            String str;
            Map<String, String> responseHeaders;
            String strA = null;
            int statusCode = -21;
            try {
                str = webResourceRequest.getMethod() + u15.f19942b + webResourceRequest.getUrl().toString();
                try {
                    requestHeaders = webResourceRequest.getRequestHeaders();
                    try {
                        statusCode = webResourceResponse.getStatusCode();
                        responseHeaders = webResourceResponse.getResponseHeaders();
                        try {
                            strA = t.a(webResourceResponse.getData());
                        } catch (Throwable th) {
                            th = th;
                            r.a(th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        responseHeaders = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    requestHeaders = null;
                    responseHeaders = null;
                }
            } catch (Throwable th4) {
                th = th4;
                requestHeaders = null;
                str = null;
                responseHeaders = null;
            }
            k.b("IPDWebView", "onReceivedHttpError.url=" + str + "&reqHeader=" + requestHeaders + "&resCode=" + statusCode + "&resHeader=" + responseHeaders + "&content=" + strA);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            int errorCode;
            String string;
            String string2 = webResourceRequest.getUrl().toString();
            try {
                errorCode = webResourceError.getErrorCode();
                try {
                    string = webResourceError.getDescription().toString();
                } catch (Throwable th) {
                    th = th;
                    r.a(th);
                    string = null;
                }
            } catch (Throwable th2) {
                th = th2;
                errorCode = -21;
            }
            k.b("IPDWebView", "onReceivedError.url=" + string2 + "&code=" + errorCode + "&desc=" + string);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return t.b(this.f38235a, str);
        }
    }

    public class c implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f38236a;

        public c(Activity activity) {
            this.f38236a = activity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            k.d("IPDWebView", "onDownloadStart...url=[" + str + "]&ua=[" + str2 + "]&cd=[" + str3 + "]&mime=[" + str4 + "]&length=[" + j + "]");
            t.a(this.f38236a, str);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static String a(WebView webView, Activity activity) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT < 33) {
            try {
                WebSettings.class.getMethod("setAppCacheMaxSize", Long.TYPE).invoke(settings, 8388608);
                WebSettings.class.getMethod("setAppCacheEnabled", Boolean.TYPE).invoke(settings, Boolean.TRUE);
                WebSettings.class.getMethod("setAppCachePath", String.class).invoke(settings, activity.getCacheDir().getAbsolutePath());
            } catch (Throwable unused) {
            }
        }
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(true);
        settings.setTextZoom(100);
        settings.setCacheMode(2);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setBlockNetworkImage(false);
        settings.setUseWideViewPort(true);
        settings.setMixedContentMode(0);
        webView.setWebChromeClient(new a(activity));
        webView.setWebViewClient(new b(activity));
        webView.setDownloadListener(new c(activity));
        return settings.getUserAgentString();
    }

    public static void a(WebView webView) {
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView.getSettings().setJavaScriptEnabled(false);
            try {
                webView.stopLoading();
                webView.removeAllViewsInLayout();
                webView.setWebViewClient(null);
                webView.setWebChromeClient(null);
                webView.removeAllViews();
                webView.destroy();
            } catch (Throwable unused) {
            }
            try {
                ((ViewGroup) webView.getParent()).removeView(webView);
            } catch (Throwable unused2) {
            }
        }
    }
}
