package com.kc.openset.activity;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.apiad.tools.DeeplinkCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETWebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f39601a;
    private boolean b;

    @Keep
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETWebViewActivity f39602a;

        static {
            OSETSDKProtected.interface11(3698);
        }

        public a(OSETWebViewActivity oSETWebViewActivity) {
            this.f39602a = oSETWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    @Keep
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f39603a;
        final OSETWebViewActivity b;

        static {
            OSETSDKProtected.interface11(3699);
        }

        public b(OSETWebViewActivity oSETWebViewActivity, String str) {
            this.b = oSETWebViewActivity;
            this.f39603a = str;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    @Keep
    public class c extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETWebViewActivity f39604a;

        @Keep
        public class a implements DeeplinkCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final c f39605a;

            static {
                OSETSDKProtected.interface11(3700);
            }

            public a(c cVar) {
                this.f39605a = cVar;
            }

            @Override // com.kc.openset.sdk.apiad.tools.DeeplinkCallback
            public native void onDeeplinkResult(boolean z, String str);

            @Override // com.kc.openset.sdk.apiad.tools.DeeplinkCallback
            public native void onViewFinish(long j);
        }

        static {
            OSETSDKProtected.interface11(3701);
        }

        private c(OSETWebViewActivity oSETWebViewActivity) {
            this.f39604a = oSETWebViewActivity;
        }

        public /* synthetic */ c(OSETWebViewActivity oSETWebViewActivity, a aVar) {
            this(oSETWebViewActivity);
        }

        private native boolean a(String str, boolean z);

        @Override // android.webkit.WebViewClient
        public native void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

        @Override // android.webkit.WebViewClient
        public native WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    @Keep
    public static class d implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<OSETWebViewActivity> f39606a;

        static {
            OSETSDKProtected.interface11(3702);
        }

        public d(OSETWebViewActivity oSETWebViewActivity) {
            this.f39606a = new WeakReference<>(oSETWebViewActivity);
        }

        @Override // android.webkit.DownloadListener
        public native void onDownloadStart(String str, String str2, String str3, String str4, long j);
    }

    static {
        OSETSDKProtected.interface11(3703);
    }

    public static native void a(Context context, String str);

    public static native void a(Context context, String str, String str2);

    private native void a(WebView webView);

    public static native /* synthetic */ void a(OSETWebViewActivity oSETWebViewActivity, String str);

    private native void a(String str);

    public static native /* synthetic */ boolean a(OSETWebViewActivity oSETWebViewActivity);

    public static native /* synthetic */ boolean a(OSETWebViewActivity oSETWebViewActivity, boolean z);

    @Override // android.app.Activity
    public native void onBackPressed();

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onDestroy();

    @Override // android.app.Activity
    public native void onPause();

    @Override // android.app.Activity
    public native void onResume();
}
