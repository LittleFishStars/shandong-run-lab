package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import cj.mobile.zy.ad.BannerAd;
import cj.mobile.zy.ad.BannerAdListener;
import cj.mobile.zy.ad.InterstitialAd;
import cj.mobile.zy.ad.InterstitialAdListener;
import cj.mobile.zy.ad.LYAdSdkController;
import cj.mobile.zy.ad.NativeAd;
import cj.mobile.zy.ad.NativeAdListener;
import cj.mobile.zy.ad.NativeAdResponse;
import cj.mobile.zy.ad.RewardItem;
import cj.mobile.zy.ad.RewardVideoAd;
import cj.mobile.zy.ad.RewardVideoAdListener;
import cj.mobile.zy.ad.SplashAd;
import cj.mobile.zy.ad.SplashAdListener;
import cj.mobile.zy.ad.internal.nativead.NativeAdEventListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashAd f21914a;
    public InterstitialAd b;
    public RewardVideoAd c;
    public NativeAd d;
    public BannerAd e;
    public View f;
    public View g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public String p;
    public Context q;
    public boolean r;
    public boolean s;
    public int t;
    public cj.mobile.p.h u;
    public String v;
    public Handler w;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21915a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: cj.mobile.a.j$a$a, reason: collision with other inner class name */
        public class C0058a extends LYAdSdkController {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21916a;

            public C0058a(a aVar) {
            }

            public String getOaid() {
            }

            public boolean isCanUsePhoneState() {
                return !cj.mobile.p.b.j0;
            }
        }

        public a(j jVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f21917a;

        public b(j jVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class c implements SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21918a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ j g;

        public c(j jVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        public void onAdCacheLoaded(boolean z) {
        }

        public void onAdClicked() {
        }

        public void onAdClosed() {
        }

        public void onAdFailedToLoad(int i) {
        }

        public void onAdLoaded() {
        }

        public void onAdShown() {
        }

        public void onAdTick(long j) {
        }
    }

    public class d implements InterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21919a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ j g;

        public d(j jVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onAdCacheLoaded(boolean z) {
        }

        public void onAdClicked() {
        }

        public void onAdClosed() {
        }

        public void onAdFailedToLoad(int i) {
        }

        public void onAdLoaded() {
        }

        public void onAdShown() {
        }
    }

    public class e implements RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21920a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ CJRewardListener d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ j g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21921a;

            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public e(j jVar, String str, String str2, Context context, CJRewardListener cJRewardListener, String str3, cj.mobile.p.h hVar) {
        }

        public void onRewardVideoAdClicked() {
        }

        public void onRewardVideoAdClosed() {
        }

        public void onRewardVideoAdComplete() {
        }

        public void onRewardVideoAdFailedToLoad(int i) {
        }

        public void onRewardVideoAdLoaded() {
        }

        public void onRewardVideoAdShown() {
        }

        public void onRewardVideoCached(boolean z) {
        }

        public void onRewarded(RewardItem rewardItem) {
        }
    }

    public class f implements NativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21922a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ j g;

        public class a implements NativeAdEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f21923a;

            public a(f fVar) {
            }

            public void onADExposed() {
            }

            public void onAdClick() {
            }

            public void onAdClose() {
            }

            public void onAdRenderFailed(int i) {
            }
        }

        public f(j jVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        public void onAdFailed(int i) {
        }

        public void onAdLoaded(NativeAdResponse nativeAdResponse) {
        }
    }

    public class g implements BannerAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21924a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJBannerListener f;
        public final /* synthetic */ j g;

        public class a implements NativeAdEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f21925a;

            public a(g gVar) {
            }

            public void onADExposed() {
            }

            public void onAdClick() {
            }

            public void onAdClose() {
            }

            public void onAdRenderFailed(int i) {
            }
        }

        public g(j jVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJBannerListener cJBannerListener) {
        }

        public void onAdFailed(int i) {
        }

        public void onAdLoaded(NativeAdResponse nativeAdResponse) {
        }
    }

    public j c(int i) {
        this.m = i;
        return this;
    }

    public j d(int i) {
        this.n = i;
        return this;
    }

    public void e() {
    }

    public View f() {
        return this.f;
    }

    public String g() {
        return this.v;
    }

    public void c() {
    }

    public void d() {
    }

    public j b(int i) {
        this.t = i;
        return this;
    }

    public j b(boolean z) {
        this.l = z;
        return this;
    }

    public j a(boolean z) {
        this.r = z;
        return this;
    }

    public void b() {
    }

    public j a(String str, String str2) {
        this.i = str;
        this.j = str2;
        return this;
    }

    public void b(ViewGroup viewGroup) {
    }

    public void a() {
    }

    public void a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void b(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
    }
}
