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
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import com.hxad.sdk.ad.interstitial.HXInterstitialAd;
import com.hxad.sdk.ad.interstitial.inner.HXInterstitialListener;
import com.hxad.sdk.ad.nativead.HXNativeAd;
import com.hxad.sdk.ad.nativead.inner.HXNativeAdData;
import com.hxad.sdk.ad.nativead.inner.HXNativeAdInteractionListener;
import com.hxad.sdk.ad.nativead.inner.HXNativeAdListener;
import com.hxad.sdk.ad.rewardvideo.HXRewardVideoAd;
import com.hxad.sdk.ad.rewardvideo.inner.HXRewardVideoListener;
import com.hxad.sdk.ad.splash.HXSplashAd;
import com.hxad.sdk.ad.splash.inner.HXSplashListener;
import com.hxad.sdk.config.HXPrivacyConfig;
import com.hxad.sdk.model.HXErrorInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HXSplashAd f21848a;
    public HXInterstitialAd b;
    public HXNativeAd c;
    public View d;
    public HXRewardVideoAd e;
    public boolean f;
    public cj.mobile.p.h g;
    public String h;
    public String i;
    public int j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public Handler r;

    public class a extends HXPrivacyConfig {
        public a(e eVar) {
        }

        public boolean canUseAppList() {
            return cj.mobile.p.b.l0;
        }

        public boolean canUseLocation() {
            return !cj.mobile.p.b.j0;
        }

        public boolean canUseMacAddress() {
            return !cj.mobile.p.b.j0;
        }

        public boolean canUseSensor() {
            return cj.mobile.p.b.d0;
        }

        public boolean canUseWifiState() {
            return !cj.mobile.p.b.j0;
        }

        public int getPersonalizedState() {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f21849a;

        public b(e eVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class c extends HXSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJSplashListener f21850a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ e g;

        public c(e eVar, CJSplashListener cJSplashListener, String str, String str2, cj.mobile.p.h hVar, Context context, String str3) {
        }

        public void onAdClicked() {
        }

        public void onAdClosed() {
        }

        public void onAdExposeFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdExposed() {
        }

        public void onAdLoadFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdLoadSucceed() {
        }

        public void onAdSkipped() {
        }
    }

    public class d extends HXInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21851a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ e g;

        public d(e eVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onAdClicked() {
        }

        public void onAdClosed() {
        }

        public void onAdExposeFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdExposed() {
        }

        public void onAdLoadFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdLoadSucceed() {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.e$e, reason: collision with other inner class name */
    public class C0050e implements HXNativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.p.h f21852a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ e g;

        /* JADX INFO: renamed from: cj.mobile.a.e$e$a */
        public class a extends HXNativeAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0050e f21853a;

            public a(C0050e c0050e) {
            }

            public void onAdClicked() {
            }

            public void onAdClosed() {
            }

            public void onAdExposed() {
            }

            public void onAdExposedFailed() {
            }

            public void onRenderFail(HXErrorInfo hXErrorInfo) {
            }

            public void onRenderSuccess(View view, float f, float f2) {
            }
        }

        public C0050e(e eVar, cj.mobile.p.h hVar, String str, Context context, String str2, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        public void onAdLoadFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdLoadSucceed(List<HXNativeAdData> list) {
        }
    }

    public class f extends HXRewardVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21854a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ CJRewardListener d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ e g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f21855a;

            public a(f fVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public f(e eVar, String str, String str2, Context context, CJRewardListener cJRewardListener, String str3, cj.mobile.p.h hVar) {
        }

        public void onAdClicked() {
        }

        public void onAdClosed() {
        }

        public void onAdExposeFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdExposed() {
        }

        public void onAdLoadFailed(HXErrorInfo hXErrorInfo) {
        }

        public void onAdLoadSucceed() {
        }

        public void onReward(boolean z, int i, Map<String, Object> map) {
        }

        public void onVideoComplete() {
        }

        public void onVideoError() {
        }
    }

    public void c() {
    }

    public void d() {
    }

    public View e() {
        return this.d;
    }

    public void b() {
    }

    public e c(int i) {
        this.o = i;
        return this;
    }

    public void a(Context context, String str) {
    }

    public e b(boolean z) {
        this.m = z;
        return this;
    }

    public e b(int i) {
        this.p = i;
        return this;
    }

    public void a() {
    }

    public e a(String str, String str2) {
        this.k = str;
        this.l = str2;
        return this;
    }

    public e a(boolean z) {
        this.n = z;
        return this;
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
    }
}
