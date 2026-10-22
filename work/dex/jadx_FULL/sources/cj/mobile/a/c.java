package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import com.ptg.adsdk.lib.interf.PtgCustomController;
import com.ptg.adsdk.lib.interf.PtgInteractionAd;
import com.ptg.adsdk.lib.interf.PtgNativeExpressAd;
import com.ptg.adsdk.lib.interf.PtgRewardVideoAd;
import com.ptg.adsdk.lib.interf.PtgSplashAd;
import com.ptg.adsdk.lib.interf.PtgVideoAdListener;
import com.ptg.adsdk.lib.model.AdError;
import com.ptg.adsdk.lib.provider.PtgAdNative;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c {
    public Handler A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PtgSplashAd f21827a;
    public PtgInteractionAd b;
    public PtgNativeExpressAd c;
    public View d;
    public PtgNativeExpressAd e;
    public View f;
    public PtgRewardVideoAd g;
    public boolean h;
    public cj.mobile.p.h i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public boolean t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public RenderAdInfo z;

    public class a implements PtgVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMediaListener f21828a;

        public a(c cVar, CJMediaListener cJMediaListener) {
        }

        public void onVideoComplete() {
        }

        public void onVideoError(int i, String str) {
        }

        public void onVideoPause() {
        }

        public void onVideoProgressUpdate(long j, long j2) {
        }

        public void onVideoResume() {
        }

        public void onVideoStart() {
        }
    }

    public class b extends PtgCustomController {
        public b(c cVar) {
        }

        public String getMediaAndroidId() {
            return cj.mobile.p.b.T;
        }

        public String getMediaDeviceImei() {
            return cj.mobile.p.b.S;
        }

        public String getMediaDeviceOaId() {
            return cj.mobile.p.b.R;
        }

        public boolean isAllowSDKInstallList() {
            return cj.mobile.p.b.l0;
        }

        public boolean isAllowSDKObtainAndroidId() {
            return !cj.mobile.p.b.j0;
        }

        public boolean isAllowSDKObtainLocation() {
            return !cj.mobile.p.b.j0;
        }

        public boolean isAllowSDKObtainOaId() {
            return cj.mobile.p.b.k0;
        }

        public boolean isAllowSDKObtainWifiState() {
            return !cj.mobile.p.b.j0;
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.c$c, reason: collision with other inner class name */
    public class HandlerC0048c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f21829a;

        public HandlerC0048c(c cVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class d implements PtgAdNative.SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21830a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ c g;

        public class a implements PtgSplashAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f21831a;

            public a(d dVar) {
            }

            public void onAdClicked() {
            }

            public void onAdShow() {
            }

            public void onAdSkip() {
            }

            public void onAdTimeOver() {
            }

            public void onDismiss(int i) {
            }

            public void onRenderError(AdError adError) {
            }

            public void onRenderSuccess() {
            }
        }

        public d(c cVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        public void onError(AdError adError) {
        }

        public void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        }

        public void onTimeout() {
        }
    }

    public class e implements PtgAdNative.InteractionExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21832a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ c g;

        public class a implements PtgInteractionAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21833a;

            public a(e eVar) {
            }

            public void onAdClicked() {
            }

            public void onAdDismiss() {
            }

            public void onAdShow() {
            }

            public void onRenderError(AdError adError) {
            }
        }

        public e(c cVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onError(AdError adError) {
        }

        public void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
        }
    }

    public class f implements PtgAdNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21834a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJNativeExpressListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ c g;

        public class a implements PtgNativeExpressAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PtgNativeExpressAd f21835a;
            public final /* synthetic */ f b;

            public a(f fVar, PtgNativeExpressAd ptgNativeExpressAd) {
            }

            public void onAdClicked() {
            }

            public void onAdDismiss() {
            }

            public void onAdShow() {
            }

            public void onRenderFail(AdError adError) {
            }

            public void onRenderSuccess(View view) {
            }
        }

        public f(c cVar, String str, String str2, cj.mobile.p.h hVar, CJNativeExpressListener cJNativeExpressListener, Context context, String str3) {
        }

        public void onError(AdError adError) {
        }

        public void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        }
    }

    public class g implements PtgAdNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21836a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJBannerListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ c g;

        public class a implements PtgNativeExpressAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PtgNativeExpressAd f21837a;
            public final /* synthetic */ g b;

            public a(g gVar, PtgNativeExpressAd ptgNativeExpressAd) {
            }

            public void onAdClicked() {
            }

            public void onAdDismiss() {
            }

            public void onAdShow() {
            }

            public void onRenderFail(AdError adError) {
            }

            public void onRenderSuccess(View view) {
            }
        }

        public g(c cVar, String str, String str2, cj.mobile.p.h hVar, CJBannerListener cJBannerListener, Context context, String str3) {
        }

        public void onError(AdError adError) {
        }

        public void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        }
    }

    public class h implements PtgAdNative.RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21838a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ c g;

        public class a implements PtgRewardVideoAd.RewardAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f21839a;

            /* JADX INFO: renamed from: cj.mobile.a.c$h$a$a, reason: collision with other inner class name */
            public class RunnableC0049a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f21840a;

                public RunnableC0049a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                }
            }

            public a(h hVar) {
            }

            public void onAdClose() {
            }

            public void onAdShow() {
            }

            public void onAdVideoBarClick() {
            }

            public void onRenderError(AdError adError) {
            }

            public void onRewardVerify(boolean z, Bundle bundle) {
            }

            public void onSkippedVideo() {
            }

            public void onVideoComplete() {
            }

            public void onVideoError(int i, String str) {
            }

            public void onVideoPause() {
            }

            public void onVideoProgressUpdate(long j, long j2) {
            }

            public void onVideoResume() {
            }

            public void onVideoStart() {
            }
        }

        public h(c cVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        public void onError(AdError adError) {
        }

        public void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
        }
    }

    public class i implements PtgAdNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21841a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ c d;

        public i(c cVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onError(AdError adError) {
        }

        public void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        }
    }

    public class j implements PtgNativeExpressAd.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21842a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ CJRenderListener e;
        public final /* synthetic */ c f;

        public j(c cVar, Context context, String str, int i, int i2, CJRenderListener cJRenderListener) {
        }

        public void onAdClicked() {
        }

        public void onAdDismiss() {
        }

        public void onAdShow() {
        }

        public void onRenderFail(AdError adError) {
        }

        public void onRenderSuccess(View view) {
        }
    }

    public View f() {
        return this.d;
    }

    public RenderAdInfo g() {
        return this.z;
    }

    public String h() {
        return this.y;
    }

    public String i() {
        return this.w;
    }

    public String d() {
        return this.x;
    }

    public String e() {
        return this.v;
    }

    public void c() {
    }

    public void b() {
    }

    public c c(boolean z) {
        this.t = z;
        return this;
    }

    public c b(boolean z) {
        this.p = z;
        return this;
    }

    public c c(int i2) {
        this.r = i2;
        return this;
    }

    public c b(int i2) {
        this.s = i2;
        return this;
    }

    public void b(ViewGroup viewGroup) {
    }

    public void a() {
    }

    public void b(Activity activity) {
    }

    public c a(String str, String str2) {
        this.n = str;
        this.o = str2;
        return this;
    }

    public c a(boolean z) {
        this.q = z;
        return this;
    }

    public void a(Context context, String str, String str2) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
    }

    public final void a(PtgNativeExpressAd ptgNativeExpressAd) {
    }

    public View a(Context context, ViewGroup viewGroup, List<View> list, String str, int i2, int i3, CJRenderListener cJRenderListener) {
    }

    public void a(ViewGroup viewGroup, CJMediaListener cJMediaListener) {
    }

    public void a(int i2) {
    }

    public void a(int i2, int i3) {
    }
}
