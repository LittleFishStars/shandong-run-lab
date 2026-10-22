package com.kc.openset.activity;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETNativeViewAdAppInfoWebViewActivity extends Activity {

    @Keep
    public class a implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LinearLayout f39599a;
        final OSETNativeViewAdAppInfoWebViewActivity b;

        public static native /* synthetic */ void $r8$lambda$1RySZK1XZu2WKBiJ6y2mE1QULoM(a aVar, LinearLayout linearLayout, String str, String str2);

        static {
            OSETSDKProtected.interface11(3695);
        }

        public a(OSETNativeViewAdAppInfoWebViewActivity oSETNativeViewAdAppInfoWebViewActivity, LinearLayout linearLayout) {
            this.b = oSETNativeViewAdAppInfoWebViewActivity;
            this.f39599a = linearLayout;
        }

        private native /* synthetic */ void a(LinearLayout linearLayout, String str, String str2);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    @Keep
    public class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETNativeViewAdAppInfoWebViewActivity f39600a;

        static {
            OSETSDKProtected.interface11(3696);
        }

        public b(OSETNativeViewAdAppInfoWebViewActivity oSETNativeViewAdAppInfoWebViewActivity) {
            this.f39600a = oSETNativeViewAdAppInfoWebViewActivity;
        }

        @Override // android.webkit.WebViewClient
        public native void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);
    }

    public static native /* synthetic */ void $r8$lambda$4KEazEzICgZFZ7dbkLqkv9CXyyQ(OSETNativeViewAdAppInfoWebViewActivity oSETNativeViewAdAppInfoWebViewActivity, View view);

    static {
        OSETSDKProtected.interface11(3697);
    }

    private native /* synthetic */ void a(View view);

    private native void a(WebView webView);

    private native void a(LinearLayout linearLayout, String str);

    private native void a(LinearLayout linearLayout, String str, String str2);

    public static native /* synthetic */ void a(OSETNativeViewAdAppInfoWebViewActivity oSETNativeViewAdAppInfoWebViewActivity, LinearLayout linearLayout, String str, String str2);

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);
}
