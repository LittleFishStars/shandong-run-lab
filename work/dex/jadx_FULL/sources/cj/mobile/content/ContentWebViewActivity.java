package cj.mobile.content;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import cj.mobile.CJInterstitial;
import cj.mobile.listener.CJInterstitialListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ContentWebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f22098a;
    public Activity b;
    public String c;
    public String d;
    public CJInterstitial e;

    public class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentWebViewActivity f22099a;

        public a(ContentWebViewActivity contentWebViewActivity) {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        }
    }

    public class b implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentWebViewActivity f22100a;

        public b(ContentWebViewActivity contentWebViewActivity) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onShow() {
        }
    }

    public class c implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentWebViewActivity f22101a;

        public c(ContentWebViewActivity contentWebViewActivity) {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }

        public /* synthetic */ c(ContentWebViewActivity contentWebViewActivity, a aVar) {
            this(contentWebViewActivity);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    public void a(String str) {
    }

    @SuppressLint({"JavascriptInterface"})
    public final void a(WebView webView) {
    }

    public final void a() {
    }
}
