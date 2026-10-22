package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJFullListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashAd f21805a;
    public RewardVideoAd b;
    public FullScreenVideoAd c;
    public ExpressInterstitialAd d;
    public NativeResponse e;
    public int f;
    public boolean g;
    public int h;
    public String i;
    public String j;
    public boolean k;
    public cj.mobile.p.h l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;
    public Context r;
    public boolean s;
    public String t;
    public ExpressResponse u;
    public View v;
    public ViewGroup w;
    public String x;
    public RenderAdInfo y;
    public Handler z;

    /* JADX INFO: renamed from: cj.mobile.a.a$a, reason: collision with other inner class name */
    public class C0045a implements ExpressResponse.ExpressInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21806a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJNativeExpressListener d;
        public final /* synthetic */ ExpressResponse e;
        public final /* synthetic */ a f;

        public C0045a(a aVar, Context context, String str, String str2, CJNativeExpressListener cJNativeExpressListener, ExpressResponse expressResponse) {
        }

        public void onAdClick() {
        }

        public void onAdExposed() {
        }

        public void onAdRenderFail(View view, String str, int i) {
        }

        public void onAdRenderSuccess(View view, float f, float f2) {
        }

        public void onAdUnionClick() {
        }
    }

    public class b implements ExpressResponse.ExpressDislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpressListener f21807a;
        public final /* synthetic */ ExpressResponse b;

        public b(a aVar, CJNativeExpressListener cJNativeExpressListener, ExpressResponse expressResponse) {
        }

        public void onDislikeItemClick(String str) {
        }

        public void onDislikeWindowClose() {
        }

        public void onDislikeWindowShow() {
        }
    }

    public class c implements BaiduNativeManager.ExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21808a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJBannerListener f;
        public final /* synthetic */ a g;

        public c(a aVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJBannerListener cJBannerListener) {
        }

        public void onLpClosed() {
        }

        public void onNativeFail(int i, String str, ExpressResponse expressResponse) {
        }

        public void onNativeLoad(List<ExpressResponse> list) {
        }

        public void onNoAd(int i, String str, ExpressResponse expressResponse) {
        }

        public void onVideoDownloadFailed() {
        }

        public void onVideoDownloadSuccess() {
        }
    }

    public class d implements ExpressResponse.ExpressInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21809a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJBannerListener d;
        public final /* synthetic */ a e;

        public d(a aVar, Context context, String str, String str2, CJBannerListener cJBannerListener) {
        }

        public void onAdClick() {
        }

        public void onAdExposed() {
        }

        public void onAdRenderFail(View view, String str, int i) {
        }

        public void onAdRenderSuccess(View view, float f, float f2) {
        }

        public void onAdUnionClick() {
        }
    }

    public class e implements ExpressResponse.ExpressDislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJBannerListener f21810a;
        public final /* synthetic */ a b;

        public e(a aVar, CJBannerListener cJBannerListener) {
        }

        public void onDislikeItemClick(String str) {
        }

        public void onDislikeWindowClose() {
        }

        public void onDislikeWindowShow() {
        }
    }

    public class f implements BaiduNativeManager.FeedAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21811a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ a d;

        public f(a aVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onLpClosed() {
        }

        public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
        }

        public void onNativeLoad(List<NativeResponse> list) {
        }

        public void onNoAd(int i, String str, NativeResponse nativeResponse) {
        }

        public void onVideoDownloadFailed() {
        }

        public void onVideoDownloadSuccess() {
        }
    }

    public class g implements NativeResponse.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21812a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ CJRenderListener e;
        public final /* synthetic */ a f;

        public g(a aVar, Context context, String str, int i, int i2, CJRenderListener cJRenderListener) {
        }

        public void adActReward(int i) {
        }

        public void adActRewardSuccess() {
        }

        public void onADExposed() {
        }

        public void onADExposureFailed(int i) {
        }

        public void onADStatusChanged() {
        }

        public void onAdClick() {
        }

        public void onAdUnionClick() {
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21813a;
        public final /* synthetic */ String b;
        public final /* synthetic */ a c;

        public h(a aVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class i implements SplashInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21814a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ a g;

        public i(a aVar, String str, String str2, cj.mobile.p.h hVar, CJSplashListener cJSplashListener, Context context, String str3) {
        }

        public void onADLoaded() {
        }

        public void onAdCacheFailed() {
        }

        public void onAdCacheSuccess() {
        }

        public void onAdClick() {
        }

        public void onAdDismissed() {
        }

        public void onAdExposed() {
        }

        public void onAdFailed(String str) {
        }

        public void onAdPresent() {
        }

        public void onAdSkip() {
        }

        public void onLpClosed() {
        }
    }

    public class j implements RewardVideoAd.RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21815a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJRewardListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ a g;

        /* JADX INFO: renamed from: cj.mobile.a.a$j$a, reason: collision with other inner class name */
        public class RunnableC0046a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f21816a;

            public RunnableC0046a(j jVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public j(a aVar, Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
        }

        public void onAdClick() {
        }

        public void onAdClose(float f) {
        }

        public void onAdFailed(String str) {
        }

        public void onAdLoaded() {
        }

        public void onAdShow() {
        }

        public void onAdSkip(float f) {
        }

        public void onRewardVerify(boolean z, Map<String, Object> map) {
        }

        public void onVideoDownloadFailed() {
        }

        public void onVideoDownloadSuccess() {
        }

        public void playCompletion() {
        }
    }

    public class k implements BiddingListener {
        public k(a aVar) {
        }

        public void onBiddingResult(boolean z, String str, HashMap<String, Object> map) {
        }
    }

    public class l implements BiddingListener {
        public l(a aVar) {
        }

        public void onBiddingResult(boolean z, String str, HashMap<String, Object> map) {
        }
    }

    public class m extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f21817a;

        public m(a aVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class n implements ExpressInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21818a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ a g;

        public n(a aVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onADExposed() {
        }

        public void onADExposureFailed() {
        }

        public void onADLoaded() {
        }

        public void onAdCacheFailed() {
        }

        public void onAdCacheSuccess() {
        }

        public void onAdClick() {
        }

        public void onAdClose() {
        }

        public void onAdFailed(int i, String str) {
        }

        public void onLpClosed() {
        }

        public void onNoAd(int i, String str) {
        }
    }

    public class o implements FullScreenVideoAd.FullScreenVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21819a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJFullListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ a g;

        public o(a aVar, Context context, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
        }

        public void onAdClick() {
        }

        public void onAdClose(float f) {
        }

        public void onAdFailed(String str) {
        }

        public void onAdLoaded() {
        }

        public void onAdShow() {
        }

        public void onAdSkip(float f) {
        }

        public void onVideoDownloadFailed() {
        }

        public void onVideoDownloadSuccess() {
        }

        public void playCompletion() {
        }
    }

    public class p implements BaiduNativeManager.ExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21820a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ a g;

        public p(a aVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        public void onLpClosed() {
        }

        public void onNativeFail(int i, String str, ExpressResponse expressResponse) {
        }

        public void onNativeLoad(List<ExpressResponse> list) {
        }

        public void onNoAd(int i, String str, ExpressResponse expressResponse) {
        }

        public void onVideoDownloadFailed() {
        }

        public void onVideoDownloadSuccess() {
        }
    }

    public a f(boolean z) {
        return this;
    }

    public void update(Context context, String str) {
    }

    public a c(int i2) {
        this.h = i2;
        return this;
    }

    public a d(boolean z) {
        this.g = z;
        return this;
    }

    public a e(boolean z) {
        this.k = z;
        return this;
    }

    public View f() {
        return this.v;
    }

    public RenderAdInfo g() {
        return this.y;
    }

    public void h() {
    }

    public void b(boolean z) {
        MobadsPermissionSettings.setLimitPersonalAds(z);
    }

    public void c() {
    }

    public a d(int i2) {
        this.f = i2;
        return this;
    }

    public void e() {
    }

    public void b() {
    }

    public void d() {
    }

    public void c(boolean z) {
    }

    public void b(Context context, String str) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void b(Activity activity) {
    }

    public a a(String str) {
        this.x = str;
        return this;
    }

    public a a(String str, String str2) {
        this.i = str;
        this.j = str2;
        return this;
    }

    public void b(int i2) {
    }

    public void a() {
    }

    public void a(boolean z) {
        MobadsPermissionSettings.setPermissionAppList(z);
    }

    public final BDAdConfig a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(int i2) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, CJNativeExpressListener cJNativeExpressListener, ExpressResponse expressResponse) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, CJBannerListener cJBannerListener, ExpressResponse expressResponse) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
    }

    public View a(Context context, View view, List<View> list, String str, int i2, int i3, CJRenderListener cJRenderListener) {
    }

    public final void a(NativeResponse nativeResponse) {
    }
}
