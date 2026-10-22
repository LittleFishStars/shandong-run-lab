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
import cn.jy.ad.sdk.AdSdk;
import cn.jy.ad.sdk.jyapi.JyBanner;
import cn.jy.ad.sdk.jyapi.JyInterstitial;
import cn.jy.ad.sdk.jyapi.JyNativeExpress;
import cn.jy.ad.sdk.jyapi.JyRewardVideo;
import cn.jy.ad.sdk.jyapi.JySplash;
import cn.jy.ad.sdk.jycfg.ctr.CustomController;
import cn.jy.ad.sdk.jyinter.JyAdNative;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JyAdNative f21875a;
    public JySplash b;
    public JyBanner c;
    public JyNativeExpress d;
    public JyInterstitial e;
    public JyRewardVideo f;
    public String g;
    public String h;
    public boolean i;
    public int j;
    public boolean k;
    public int l;
    public cj.mobile.p.h m;
    public int n;
    public String o;
    public String p;
    public Context q;
    public boolean r;
    public boolean s;
    public int t;
    public Handler u;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21876a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: cj.mobile.a.h$a$a, reason: collision with other inner class name */
        public class C0053a extends CustomController {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21877a;

            public C0053a(a aVar) {
            }

            @Override // cn.jy.ad.sdk.jycfg.ctr.CustomController, cn.jy.ad.sdk.jycfg.ctr.JyController
            public String getImei() {
            }

            @Override // cn.jy.ad.sdk.jycfg.ctr.CustomController, cn.jy.ad.sdk.jycfg.ctr.JyController
            public List<String> getInstalledPackages() {
            }

            @Override // cn.jy.ad.sdk.jycfg.ctr.CustomController, cn.jy.ad.sdk.jycfg.ctr.JyController
            public String getOaid() {
            }

            @Override // cn.jy.ad.sdk.jycfg.ctr.CustomController, cn.jy.ad.sdk.jycfg.ctr.JyController
            public boolean isCanReadInstalledPackages() {
                return cj.mobile.p.b.l0;
            }

            @Override // cn.jy.ad.sdk.jycfg.ctr.CustomController, cn.jy.ad.sdk.jycfg.ctr.JyController
            public boolean isCanUseLocation() {
                return !cj.mobile.p.b.j0;
            }

            @Override // cn.jy.ad.sdk.jycfg.ctr.CustomController, cn.jy.ad.sdk.jycfg.ctr.JyController
            public boolean isCanUseOaid() {
                return cj.mobile.p.b.k0;
            }
        }

        public class b implements AdSdk.Callback {
            public b(a aVar) {
            }

            @Override // cn.jy.ad.sdk.AdSdk.Callback
            public void onFail(int i, String str) {
                cj.mobile.p.b.H = 2;
            }

            @Override // cn.jy.ad.sdk.AdSdk.Callback
            public void onSuccess() {
                cj.mobile.p.b.H = 1;
            }
        }

        public a(h hVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f21878a;

        public b(h hVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class c implements JyAdNative.SplashAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21879a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ h g;

        public class a implements JySplash.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f21880a;

            public a(c cVar) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JySplash.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JySplash.AdInteractionListener
            public void onAdClose() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JySplash.AdInteractionListener
            public void onAdExposure() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JySplash.AdInteractionListener
            public void onAdShow() {
            }
        }

        public c(h hVar, String str, String str2, cj.mobile.p.h hVar2, CJSplashListener cJSplashListener, Context context, String str3) {
        }

        @Override // cn.jy.ad.sdk.jyinter.AdViewErrorListener
        public void onError(int i, String str) {
        }

        @Override // cn.jy.ad.sdk.jyinter.JyAdNative.SplashAdLoadListener
        public void onSplashAdLoad(JySplash jySplash) {
        }
    }

    public class d implements JyAdNative.InterstitialAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21881a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJInterstitialListener d;
        public final /* synthetic */ String e;
        public final /* synthetic */ h f;

        public class a implements JyInterstitial.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f21882a;

            public a(d dVar) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyInterstitial.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyInterstitial.AdInteractionListener
            public void onAdClose() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyInterstitial.AdInteractionListener
            public void onAdShow() {
            }
        }

        public d(h hVar, String str, String str2, cj.mobile.p.h hVar2, CJInterstitialListener cJInterstitialListener, String str3) {
        }

        @Override // cn.jy.ad.sdk.jyinter.AdViewErrorListener
        public void onError(int i, String str) {
        }

        @Override // cn.jy.ad.sdk.jyinter.JyAdNative.InterstitialAdLoadListener
        public void onInterstitialAdLoad(JyInterstitial jyInterstitial) {
        }
    }

    public class e implements JyAdNative.RewardVideoAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21883a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ h g;

        public class a implements JyRewardVideo.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21884a;

            /* JADX INFO: renamed from: cj.mobile.a.h$e$a$a, reason: collision with other inner class name */
            public class RunnableC0054a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f21885a;

                public RunnableC0054a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                }
            }

            public a(e eVar) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyRewardVideo.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyRewardVideo.AdInteractionListener
            public void onAdClose() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyRewardVideo.AdInteractionListener
            public void onAdShow() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyRewardVideo.AdInteractionListener
            public void onReward(String str) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyRewardVideo.AdInteractionListener
            public void onVideoComplete() {
            }
        }

        public e(h hVar, String str, String str2, cj.mobile.p.h hVar2, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        @Override // cn.jy.ad.sdk.jyinter.AdViewErrorListener
        public void onError(int i, String str) {
        }

        @Override // cn.jy.ad.sdk.jyinter.JyAdNative.RewardVideoAdLoadListener
        public void onRewardVideoAdLoad(JyRewardVideo jyRewardVideo) {
        }
    }

    public class f implements JyAdNative.BannerAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21886a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJBannerListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ h g;

        public class a implements JyBanner.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f21887a;

            public a(f fVar) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyBanner.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyBanner.AdInteractionListener
            public void onAdClose() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyBanner.AdInteractionListener
            public void onAdShow() {
            }
        }

        public f(h hVar, String str, String str2, cj.mobile.p.h hVar2, CJBannerListener cJBannerListener, Context context, String str3) {
        }

        @Override // cn.jy.ad.sdk.jyinter.JyAdNative.BannerAdLoadListener
        public void onBannerAdLoad(JyBanner jyBanner) {
        }

        @Override // cn.jy.ad.sdk.jyinter.AdViewErrorListener
        public void onError(int i, String str) {
        }
    }

    public class g implements JyAdNative.NativeExpressAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21888a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ h g;

        public class a implements JyNativeExpress.RenderListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f21889a;

            public a(g gVar) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyNativeExpress.RenderListener
            public void onRenderFail(View view, int i, String str) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyNativeExpress.RenderListener
            public void onRenderSuccess(View view, float f, float f2) {
            }
        }

        public class b implements JyNativeExpress.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f21890a;

            public b(g gVar) {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyNativeExpress.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyNativeExpress.AdInteractionListener
            public void onAdClose() {
            }

            @Override // cn.jy.ad.sdk.jyapi.JyNativeExpress.AdInteractionListener
            public void onAdShow() {
            }
        }

        public g(h hVar, String str, String str2, cj.mobile.p.h hVar2, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // cn.jy.ad.sdk.jyinter.AdViewErrorListener
        public void onError(int i, String str) {
        }

        @Override // cn.jy.ad.sdk.jyinter.JyAdNative.NativeExpressAdLoadListener
        public void onNativeExpressAdLoad(List<JyNativeExpress> list) {
        }
    }

    public h c(boolean z) {
        this.s = z;
        return this;
    }

    public h b(int i) {
        this.l = i;
        return this;
    }

    public h c(int i) {
        this.j = i;
        return this;
    }

    public h b(boolean z) {
        this.i = z;
        return this;
    }

    public View b() {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void a() {
    }

    public void b(Activity activity) {
    }

    public h a(boolean z) {
        this.k = z;
        return this;
    }

    public h a(String str, String str2) {
        this.g = str;
        this.h = str2;
        return this;
    }

    public void a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(int i) {
    }

    public void a(int i, String str) {
    }
}
