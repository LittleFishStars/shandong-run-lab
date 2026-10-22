package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJSplashListener;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.InterstitialAdListener;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import com.beizi.fusion.SplashAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashAd f21821a;
    public InterstitialAd b;
    public NativeAd c;
    public boolean d;
    public cj.mobile.p.h e;
    public String f;
    public String g;
    public Context h;
    public View i;
    public boolean j;
    public int k;
    public int l;
    public Handler m;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21822a;

        public a(b bVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.b$b, reason: collision with other inner class name */
    public class RunnableC0047b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21823a;
        public final /* synthetic */ Context b;

        public RunnableC0047b(b bVar, String str, Context context) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class c implements AdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21824a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ b g;

        public c(b bVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClicked() {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClosed() {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdFailedToLoad(int i) {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdLoaded() {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdShown() {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdTick(long j) {
        }
    }

    public class d implements InterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21825a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ b g;

        public d(b bVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdClick() {
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdClosed() {
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdFailed(int i) {
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdLoaded() {
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdShown() {
        }
    }

    public class e implements NativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21826a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ b g;

        public e(b bVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClick() {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClosed() {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdFailed(int i) {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdLoaded(View view) {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdShown() {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClosed(View view) {
        }
    }

    public void a() {
    }

    public View b() {
        return this.i;
    }

    public b b(int i) {
        this.k = i;
        return this;
    }

    public b a(boolean z) {
        this.j = z;
        return this;
    }

    public b a(int i) {
        this.l = i;
        return this;
    }

    public void a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }
}
