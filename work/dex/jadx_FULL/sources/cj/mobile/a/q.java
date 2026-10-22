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
import com.anythink.banner.api.ATBannerExListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeDislikeListener;
import com.anythink.nativead.api.ATNativeEventExListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.NativeAd;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ATSplashAd f22015a;
    public ATInterstitial b;
    public ATRewardVideoAd c;
    public ATNative d;
    public NativeAd e;
    public ATNativeAdView f;
    public ATBannerView g;
    public cj.mobile.p.h h;
    public String i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public boolean p;
    public int q;
    public Handler r;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22016a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(q qVar, Context context, String str, String str2) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f22017a;

        public b(q qVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class c implements ATSplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22018a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ q g;

        public c(q qVar, String str, String str2, cj.mobile.p.h hVar, CJSplashListener cJSplashListener, Context context, String str3) {
        }

        public void onAdClick(ATAdInfo aTAdInfo) {
        }

        public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
        }

        public void onAdLoadTimeout() {
        }

        public void onAdLoaded(boolean z) {
        }

        public void onAdShow(ATAdInfo aTAdInfo) {
        }

        public void onNoAdError(AdError adError) {
        }
    }

    public class d implements ATInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22019a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJInterstitialListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ q g;

        public d(q qVar, String str, String str2, cj.mobile.p.h hVar, CJInterstitialListener cJInterstitialListener, Context context, String str3) {
        }

        public void onInterstitialAdClicked(ATAdInfo aTAdInfo) {
        }

        public void onInterstitialAdClose(ATAdInfo aTAdInfo) {
        }

        public void onInterstitialAdLoadFail(AdError adError) {
        }

        public void onInterstitialAdLoaded() {
        }

        public void onInterstitialAdShow(ATAdInfo aTAdInfo) {
        }

        public void onInterstitialAdVideoEnd(ATAdInfo aTAdInfo) {
        }

        public void onInterstitialAdVideoError(AdError adError) {
        }

        public void onInterstitialAdVideoStart(ATAdInfo aTAdInfo) {
        }
    }

    public class e implements ATRewardVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22020a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ q g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f22021a;

            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public e(q qVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        public void onReward(ATAdInfo aTAdInfo) {
        }

        public void onRewardedVideoAdClosed(ATAdInfo aTAdInfo) {
        }

        public void onRewardedVideoAdFailed(AdError adError) {
        }

        public void onRewardedVideoAdLoaded() {
        }

        public void onRewardedVideoAdPlayClicked(ATAdInfo aTAdInfo) {
        }

        public void onRewardedVideoAdPlayEnd(ATAdInfo aTAdInfo) {
        }

        public void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo aTAdInfo) {
        }

        public void onRewardedVideoAdPlayStart(ATAdInfo aTAdInfo) {
        }
    }

    public class f implements ATNativeNetworkListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22022a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJNativeExpressListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ q g;

        public class a implements ATNativeEventExListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f22023a;

            public a(f fVar) {
            }

            public void onAdClicked(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
            }

            public void onAdImpressed(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
            }

            public void onAdVideoEnd(ATNativeAdView aTNativeAdView) {
            }

            public void onAdVideoProgress(ATNativeAdView aTNativeAdView, int i) {
            }

            public void onAdVideoStart(ATNativeAdView aTNativeAdView) {
            }

            public void onDeeplinkCallback(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo, boolean z) {
            }
        }

        public class b extends ATNativeDislikeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f22024a;

            public b(f fVar) {
            }

            public void onAdCloseButtonClick(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
            }
        }

        public f(q qVar, String str, String str2, cj.mobile.p.h hVar, CJNativeExpressListener cJNativeExpressListener, Context context, String str3) {
        }

        public void onNativeAdLoadFail(AdError adError) {
        }

        public void onNativeAdLoaded() {
        }
    }

    public class g implements ATBannerExListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22025a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJBannerListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ q g;

        public g(q qVar, String str, String str2, cj.mobile.p.h hVar, CJBannerListener cJBannerListener, Context context, String str3) {
        }

        public void onBannerAutoRefreshFail(AdError adError) {
        }

        public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
        }

        public void onBannerClicked(ATAdInfo aTAdInfo) {
        }

        public void onBannerClose(ATAdInfo aTAdInfo) {
        }

        public void onBannerFailed(AdError adError) {
        }

        public void onBannerLoaded() {
        }

        public void onBannerShow(ATAdInfo aTAdInfo) {
        }

        public void onDeeplinkCallback(boolean z, ATAdInfo aTAdInfo, boolean z2) {
        }

        public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        }
    }

    public void a() {
    }

    public void c() {
    }

    public void e() {
    }

    public q b(int i) {
        this.o = i;
        return this;
    }

    public void d() {
    }

    public View f() {
        return this.f;
    }

    public q b(boolean z) {
        this.n = z;
        return this;
    }

    public void b() {
    }

    public q a(boolean z) {
        this.p = z;
        return this;
    }

    public void b(Activity activity) {
    }

    public q a(int i) {
        this.q = i;
        return this;
    }

    public q a(String str, String str2) {
        this.l = str;
        this.m = str2;
        return this;
    }

    public void a(Context context, String str, String str2) {
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity, ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }
}
