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
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJFullListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import cj.mobile.listener.CJVideoFlowListener;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTRewardVideoAd f21979a;
    public TTFullScreenVideoAd b;
    public CSJSplashAd c;
    public TTFullScreenVideoAd d;
    public TTNativeExpressAd e;
    public View f;
    public TTNativeExpressAd g;
    public String h;
    public String i;
    public boolean j;
    public String k;
    public TTNativeExpressAd l;
    public View m;
    public String n;
    public boolean o;
    public cj.mobile.p.h p;
    public String q;
    public String r;
    public Context s;
    public View t;
    public boolean u;
    public Handler v;
    public int w;
    public int x;

    public class a implements TTAdDislike.DislikeInteractionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21980a;
        public final /* synthetic */ CJBannerListener b;
        public final /* synthetic */ TTNativeExpressAd c;
        public final /* synthetic */ p d;

        /* JADX INFO: renamed from: cj.mobile.a.p$a$a, reason: collision with other inner class name */
        public class RunnableC0065a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21981a;

            public RunnableC0065a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public a(p pVar, Activity activity, CJBannerListener cJBannerListener, TTNativeExpressAd tTNativeExpressAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str, boolean z) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21982a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJInterstitialListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ p g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f21983a;

            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public b(p pVar, String str, Context context, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class c implements TTAdNative.FullScreenVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.p.h f21984a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ p g;

        public c(p pVar, cj.mobile.p.h hVar, String str, String str2, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }
    }

    public class d implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21985a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJInterstitialListener d;
        public final /* synthetic */ p e;

        public d(p pVar, Context context, String str, String str2, CJInterstitialListener cJInterstitialListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21986a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJFullListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ p g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21987a;

            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public e(p pVar, String str, Activity activity, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class f implements TTAdNative.FullScreenVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21988a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJFullListener f;
        public final /* synthetic */ p g;

        public f(p pVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJFullListener cJFullListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }
    }

    public class g implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21989a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJFullListener d;
        public final /* synthetic */ p e;

        public g(p pVar, Activity activity, String str, String str2, CJFullListener cJFullListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21990a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJRewardListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ p g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f21991a;

            public a(h hVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public h(p pVar, String str, Context context, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class i implements TTAdNative.RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21992a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ p g;

        public i(p pVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        }
    }

    public class j implements TTRewardVideoAd.RewardAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21993a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJRewardListener d;
        public final /* synthetic */ p e;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f21994a;

            public a(j jVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public j(p pVar, Context context, String str, String str2, CJRewardListener cJRewardListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardArrived(boolean z, int i, Bundle bundle) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
        }
    }

    public class k extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f21995a;

        public k(p pVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21996a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ CJNativeExpressListener h;
        public final /* synthetic */ cj.mobile.p.h i;
        public final /* synthetic */ p j;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f21997a;

            public a(l lVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public l(p pVar, String str, Context context, String str2, String str3, int i, int i2, int i3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class m implements TTAdNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21998a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ p g;

        public m(p pVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        }
    }

    public class n implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21999a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJNativeExpressListener d;
        public final /* synthetic */ TTNativeExpressAd e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ p g;

        public n(p pVar, Context context, String str, String str2, CJNativeExpressListener cJNativeExpressListener, TTNativeExpressAd tTNativeExpressAd, cj.mobile.p.h hVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
        }
    }

    public class o implements TTAdDislike.DislikeInteractionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpressListener f22000a;
        public final /* synthetic */ TTNativeExpressAd b;

        public o(p pVar, CJNativeExpressListener cJNativeExpressListener, TTNativeExpressAd tTNativeExpressAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str, boolean z) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.p$p, reason: collision with other inner class name */
    public class RunnableC0066p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22001a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ CJVideoFlowListener g;
        public final /* synthetic */ cj.mobile.p.h h;
        public final /* synthetic */ p i;

        /* JADX INFO: renamed from: cj.mobile.a.p$p$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RunnableC0066p f22002a;

            public a(RunnableC0066p runnableC0066p) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public RunnableC0066p(p pVar, String str, Activity activity, String str2, String str3, int i, int i2, CJVideoFlowListener cJVideoFlowListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class q implements TTAdNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22003a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJVideoFlowListener d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ p g;

        public class a implements TTNativeExpressAd.ExpressVideoAdListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f22004a;

            public a(q qVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdComplete() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdPaused() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoError(int i, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        }

        public class b implements TTNativeExpressAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f22005a;

            public b(q qVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
            public void onAdDismiss() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
            }
        }

        public q(p pVar, String str, String str2, cj.mobile.p.h hVar, CJVideoFlowListener cJVideoFlowListener, Activity activity, String str3) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        }
    }

    public class r implements TTAdSdk.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f22006a;
        public final /* synthetic */ p b;

        public r(p pVar, long j) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
        }
    }

    public class s extends TTCustomController {
        public s(p pVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            return cj.mobile.p.b.l0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            return !cj.mobile.p.b.j0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return !cj.mobile.p.b.j0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return !cj.mobile.p.b.j0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return !cj.mobile.p.b.j0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public Map<String, Object> userPrivacyConfig() {
        }
    }

    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22007a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ CJSplashListener g;
        public final /* synthetic */ cj.mobile.p.h h;
        public final /* synthetic */ p i;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t f22008a;

            public a(t tVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public t(p pVar, String str, Context context, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class u implements TTAdNative.CSJSplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22009a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ p g;

        public u(p pVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError cSJAdError) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
        }
    }

    public class v implements CSJSplashAd.SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22010a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ p e;

        public v(p pVar, Context context, String str, String str2, CJSplashListener cJSplashListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        }
    }

    public class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22011a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ CJBannerListener g;
        public final /* synthetic */ cj.mobile.p.h h;
        public final /* synthetic */ p i;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f22012a;

            public a(w wVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public w(p pVar, String str, Activity activity, String str2, String str3, int i, int i2, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class x implements TTAdNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22013a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJBannerListener f;
        public final /* synthetic */ p g;

        public x(p pVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJBannerListener cJBannerListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        }
    }

    public class y implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22014a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJBannerListener d;
        public final /* synthetic */ TTNativeExpressAd e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ p g;

        public y(p pVar, Activity activity, String str, String str2, CJBannerListener cJBannerListener, TTNativeExpressAd tTNativeExpressAd, cj.mobile.p.h hVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public View h() {
        return this.t;
    }

    public View i() {
        return this.m;
    }

    public void c() {
    }

    public p b(int i2) {
        this.w = i2;
        return this;
    }

    public p b(boolean z) {
        this.j = z;
        return this;
    }

    public void c(Activity activity) {
    }

    public void b() {
    }

    public void b(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public p a(boolean z) {
        this.u = z;
        return this;
    }

    public p a(int i2) {
        this.x = i2;
        return this;
    }

    public p a(String str, String str2) {
        this.h = str;
        this.i = str2;
        return this;
    }

    public void a(Context context, String str) {
    }

    public final TTAdConfig a(String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, CSJSplashAd cSJSplashAd, String str, String str2, CJSplashListener cJSplashListener) {
    }

    public void a(Activity activity, String str, String str2, String str3, int i2, int i3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public final void a(Activity activity, TTNativeExpressAd tTNativeExpressAd, String str, String str2, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public final void a(Activity activity, TTNativeExpressAd tTNativeExpressAd, CJBannerListener cJBannerListener) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void b(Activity activity, String str, String str2, String str3, int i2, int i3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a() {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, TTFullScreenVideoAd tTFullScreenVideoAd, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
    }

    public final void a(Activity activity, String str, String str2, TTFullScreenVideoAd tTFullScreenVideoAd, CJFullListener cJFullListener) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, TTRewardVideoAd tTRewardVideoAd, CJRewardListener cJRewardListener) {
    }

    public void a(Context context, String str, String str2, int i2, int i3, int i4, String str3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, TTNativeExpressAd tTNativeExpressAd, cj.mobile.p.h hVar, CJNativeExpressListener cJNativeExpressListener) {
    }

    public final void a(Context context, String str, String str2, TTNativeExpressAd tTNativeExpressAd, CJNativeExpressListener cJNativeExpressListener) {
    }

    public void a(Activity activity, String str, String str2, String str3, int i2, int i3, CJVideoFlowListener cJVideoFlowListener, cj.mobile.p.h hVar) {
    }

    public void b(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void b(Activity activity) {
    }

    public void b(Activity activity, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
    }

    public void b(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void b(Context context, String str, String str2, int i2, int i3, int i4, String str3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void b(Activity activity, String str, String str2, String str3, int i2, int i3, CJVideoFlowListener cJVideoFlowListener, cj.mobile.p.h hVar) {
    }
}
