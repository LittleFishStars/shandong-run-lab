package cj.mobile.content.game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import cj.mobile.CJRewardVideo;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJRewardListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJGameActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f22102a;
    public Activity b;
    public LoadingDialog c;
    public String d;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJGameActivity f22103a;

        public a(CJGameActivity cJGameActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJGameActivity f22104a;

        public b(CJGameActivity cJGameActivity) {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        }
    }

    public class c implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f22105a;
        public final /* synthetic */ CJGameActivity b;

        public c(CJGameActivity cJGameActivity, CJRewardVideo cJRewardVideo) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onReward(String str) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onShow() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoEnd() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoStart() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f22106a;
        public final /* synthetic */ CJGameActivity b;

        public d(CJGameActivity cJGameActivity, JSONObject jSONObject) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJGameActivity f22107a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22108a;

            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22109a;

            public b(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22110a;

            public c(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f22111a;
            public final /* synthetic */ String b;
            public final /* synthetic */ e c;

            public d(e eVar, String str, String str2) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        /* JADX INFO: renamed from: cj.mobile.content.game.CJGameActivity$e$e, reason: collision with other inner class name */
        public class RunnableC0070e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22112a;

            public RunnableC0070e(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22113a;

            public f(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22114a;

            public g(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22115a;

            public h(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public e(CJGameActivity cJGameActivity) {
        }

        @JavascriptInterface
        public void backGame() {
        }

        @JavascriptInterface
        public void backInGame() {
        }

        @JavascriptInterface
        public void cjLoadAnShowRewardVideoAd(String str, String str2) {
        }

        @JavascriptInterface
        public void closeLoading() {
        }

        @JavascriptInterface
        public void getDeviceId() {
        }

        @JavascriptInterface
        public void setLandscape() {
        }

        @JavascriptInterface
        public void setPortrait() {
        }

        @JavascriptInterface
        public void showLoading() {
        }

        public /* synthetic */ e(CJGameActivity cJGameActivity, a aVar) {
            this(cJGameActivity);
        }
    }

    public class f implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJGameActivity f22116a;

        public f(CJGameActivity cJGameActivity) {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }

        public /* synthetic */ f(CJGameActivity cJGameActivity, a aVar) {
            this(cJGameActivity);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
    }

    @SuppressLint({"JavascriptInterface"})
    public void b() {
    }

    public void c() {
    }

    public final void a() {
    }

    public final void a(int i) {
        setRequestedOrientation(i);
    }

    public void a(String str, String str2) {
    }

    public void a(Activity activity, JSONObject jSONObject) {
    }
}
