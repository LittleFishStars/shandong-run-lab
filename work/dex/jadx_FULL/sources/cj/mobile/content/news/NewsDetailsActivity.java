package cj.mobile.content.news;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cj.mobile.CJInterstitial;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.view.ScrollWebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class NewsDetailsActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22154a;
    public ScrollWebView b;
    public TextView c;
    public String d;
    public String e;
    public String f;
    public CJInterstitial g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public Handler m;

    public class a implements cj.mobile.t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsDetailsActivity f22155a;

        public a(NewsDetailsActivity newsDetailsActivity) {
        }

        @Override // cj.mobile.t.a
        public void a(int i, int i2, int i3, int i4) {
        }
    }

    public class b extends WebViewClient {
        public b(NewsDetailsActivity newsDetailsActivity) {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        }
    }

    public class c implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsDetailsActivity f22156a;

        public c(NewsDetailsActivity newsDetailsActivity) {
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

    public class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsDetailsActivity f22157a;

        public d(NewsDetailsActivity newsDetailsActivity, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public class e implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsDetailsActivity f22158a;

        public e(NewsDetailsActivity newsDetailsActivity) {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }

        public /* synthetic */ e(NewsDetailsActivity newsDetailsActivity, a aVar) {
            this(newsDetailsActivity);
        }
    }

    public void back(View view) {
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    public final void a(WebView webView, String str, String str2) {
    }

    public final void a(WebView webView) {
    }

    public final void a() {
    }
}
