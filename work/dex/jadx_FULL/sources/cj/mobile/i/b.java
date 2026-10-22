package cj.mobile.i;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import cj.mobile.CJRewardVideo;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJRewardListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22264a;
    public WebView b;
    public String c;
    public CJRewardVideo d;
    public LoadingDialog e;
    public boolean f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22265a;
        public final /* synthetic */ b b;

        public a(b bVar, int i) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.i.b$b, reason: collision with other inner class name */
    public class RunnableC0077b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f22266a;

        public RunnableC0077b(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class c implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f22267a;
        public final /* synthetic */ b b;

        public c(b bVar, Object obj) {
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
        public final /* synthetic */ JSONObject f22268a;
        public final /* synthetic */ b b;

        public d(b bVar, JSONObject jSONObject) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public b(Activity activity, WebView webView, String str) {
    }

    @JavascriptInterface
    public void backInGame() {
    }

    @JavascriptInterface
    public void loadRewardAdInGame(int i) {
    }

    public final void a(Object obj) {
    }

    public void a(Activity activity, JSONObject jSONObject) {
    }
}
