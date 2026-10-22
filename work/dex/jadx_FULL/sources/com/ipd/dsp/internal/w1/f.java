package com.ipd.dsp.internal.w1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.w1.f;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
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
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38602a = "ZJX5WebView";

    public class a extends WebChromeClient {
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            k.a(f.f38602a, "console[" + consoleMessage.messageLevel() + u15.f19942b + consoleMessage.message() + "(" + consoleMessage.sourceId() + c49.f40900a + consoleMessage.lineNumber() + ")]");
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            geolocationPermissionsCallback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            k.b(f.f38602a, "onJsAlert [" + str2 + "]");
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    public class b extends WebViewClient {
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            k.b(f.f38602a, "onReceivedError.url = " + str2 + "&code=" + i + "&desc=" + str);
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
                            strA = d.a(webResourceResponse.getData());
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
            k.b(f.f38602a, "onReceivedHttpError.url=" + str + "&reqHeader=" + requestHeaders + "&resCode=" + statusCode + "&resHeader=" + responseHeaders + "&content=" + strA);
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
            k.b(f.f38602a, "onReceivedError.url=" + string2 + "&code=" + errorCode + "&desc=" + string);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return d.b(str);
        }
    }

    public static String a(Context context, WebView webView) {
        IX5WebViewExtension x5WebViewExtension = webView.getX5WebViewExtension();
        if (x5WebViewExtension != null) {
            x5WebViewExtension.setVerticalScrollBarEnabled(false);
            x5WebViewExtension.setHorizontalScrollBarEnabled(false);
        } else {
            webView.getView().setVerticalScrollBarEnabled(false);
            webView.getView().setHorizontalScrollBarEnabled(false);
        }
        WebSettings webSettingsB = b(context, webView);
        webView.setWebChromeClient(new a());
        webView.setWebViewClient(new b());
        webView.setDownloadListener(new DownloadListener() { // from class: com.zj.adlib.n2b
            public final void a(String str, String str2, String str3, String str4, long j) {
                f.a(str, str2, str3, str4, j);
            }
        });
        return webSettingsB.getUserAgentString();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static WebSettings b(Context context, WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setTextZoom(100);
        settings.setCacheMode(2);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(0);
        return settings;
    }

    public static /* synthetic */ void a(String str, String str2, String str3, String str4, long j) {
        k.d(f38602a, "onDownloadStart...url=[" + str + "]&ua=[" + str2 + "]&cd=[" + str3 + "]&mime=[" + str4 + "]&length=[" + j + "]");
        d.a(str);
    }

    public static void a(WebView webView) {
        if (webView != null) {
            webView.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
            webView.getSettings().setJavaScriptEnabled(false);
            try {
                webView.setWebViewClient((WebViewClient) null);
                webView.setWebChromeClient((WebChromeClient) null);
                webView.removeAllViews();
                webView.setVisibility(8);
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
