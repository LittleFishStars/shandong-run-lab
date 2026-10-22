package com.ipd.dsp.internal.c2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import com.ipd.dsp.internal.c2.v;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38237a = "IPDX5WebView";

    public class a extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f38238a;

        public a(Activity activity) {
            this.f38238a = activity;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            k.a(v.f38237a, "console[" + consoleMessage.messageLevel() + u15.f19942b + consoleMessage.message() + "(" + consoleMessage.sourceId() + c49.f40900a + consoleMessage.lineNumber() + ")]");
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            geolocationPermissionsCallback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            k.b(v.f38237a, "onJsAlert [" + str2 + "]");
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            try {
                this.f38238a.setTitle(str);
            } catch (Throwable th) {
                r.a(th);
            }
        }
    }

    public class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f38239a;

        public b(Activity activity) {
            this.f38239a = activity;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            k.b(v.f38237a, "onReceivedError.url = " + str2 + "&code=" + i + "&desc=" + str);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Map requestHeaders;
            String str;
            Map responseHeaders;
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
            k.b(v.f38237a, "onReceivedHttpError.url=" + str + "&reqHeader=" + requestHeaders + "&resCode=" + statusCode + "&resHeader=" + responseHeaders + "&content=" + strA);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

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
            k.b(v.f38237a, "onReceivedError.url=" + string2 + "&code=" + errorCode + "&desc=" + string);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return t.b(this.f38239a, str);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static String a(WebView webView, final Activity activity) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(activity.getCacheDir().getAbsolutePath());
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
        webView.setDownloadListener(new DownloadListener() { // from class: com.zj.adlib.dvb
            public final void a(String str, String str2, String str3, String str4, long j) {
                v.a(activity, str, str2, str3, str4, j);
            }
        });
        return settings.getUserAgentString();
    }

    public static /* synthetic */ void a(Activity activity, String str, String str2, String str3, String str4, long j) {
        k.d(f38237a, "onDownloadStart...url=[" + str + "]&ua=[" + str2 + "]&cd=[" + str3 + "]&mime=[" + str4 + "]&length=[" + j + "]");
        t.a(activity, str);
    }

    public static void a(WebView webView) {
        if (webView != null) {
            webView.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
            webView.getSettings().setJavaScriptEnabled(false);
            try {
                webView.stopLoading();
                webView.removeAllViewsInLayout();
                webView.setWebViewClient((WebViewClient) null);
                webView.setWebChromeClient((WebChromeClient) null);
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
