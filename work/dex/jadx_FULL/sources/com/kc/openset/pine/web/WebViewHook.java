package com.kc.openset.pine.web;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.SSActivityLifecycleCallbacks;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.callback.MethodHook;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WebViewHook {
    private static final String TAG = OSETSDKProtected.getString2(2392);

    /* JADX INFO: renamed from: com.kc.openset.pine.web.WebViewHook$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4677);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.web.WebViewHook$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends SSActivityLifecycleCallbacks {
        static {
            OSETSDKProtected.interface11(4678);
        }

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityDestroyed(Activity activity);
    }

    @Keep
    public static class SsKsWebViewClient extends WebViewClient {
        private final WebViewClient webViewClient;

        static {
            OSETSDKProtected.interface11(4679);
        }

        public SsKsWebViewClient(WebViewClient webViewClient) {
            this.webViewClient = webViewClient;
        }

        @Override // android.webkit.WebViewClient
        public native void doUpdateVisitedHistory(WebView webView, String str, boolean z);

        @Override // android.webkit.WebViewClient
        public native void onFormResubmission(WebView webView, Message message, Message message2);

        @Override // android.webkit.WebViewClient
        public native void onLoadResource(WebView webView, String str);

        @Override // android.webkit.WebViewClient
        public native void onPageCommitVisible(WebView webView, String str);

        @Override // android.webkit.WebViewClient
        public native void onPageFinished(WebView webView, String str);

        @Override // android.webkit.WebViewClient
        public native void onPageStarted(WebView webView, String str, Bitmap bitmap);

        @Override // android.webkit.WebViewClient
        public native void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest);

        @Override // android.webkit.WebViewClient
        public native void onReceivedError(WebView webView, int i, String str, String str2);

        @Override // android.webkit.WebViewClient
        public native void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

        @Override // android.webkit.WebViewClient
        public native void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2);

        @Override // android.webkit.WebViewClient
        public native void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

        @Override // android.webkit.WebViewClient
        public native void onReceivedLoginRequest(WebView webView, String str, String str2, String str3);

        @Override // android.webkit.WebViewClient
        public native void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

        @Override // android.webkit.WebViewClient
        public native boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);

        @Override // android.webkit.WebViewClient
        public native void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse);

        @Override // android.webkit.WebViewClient
        public native void onScaleChanged(WebView webView, float f, float f2);

        @Override // android.webkit.WebViewClient
        public native void onTooManyRedirects(WebView webView, Message message, Message message2);

        @Override // android.webkit.WebViewClient
        public native void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent);

        @Override // android.webkit.WebViewClient
        public native WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest);

        @Override // android.webkit.WebViewClient
        public native WebResourceResponse shouldInterceptRequest(WebView webView, String str);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    static {
        OSETSDKProtected.interface11(4680);
    }

    public static native void initWebViewHook();
}
