package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJFullListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import cj.mobile.listener.CJVideoFlowListener;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class r {
    public boolean A;
    public boolean B;
    public int C;
    public RenderAdInfo D;
    public Handler E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UnifiedInterstitialAD f22026a;
    public UnifiedInterstitialAD b;
    public RewardVideoAD c;
    public SplashAD d;
    public UnifiedBannerView e;
    public NativeUnifiedAD f;
    public NativeUnifiedADData g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public cj.mobile.p.h l;
    public CJSplashListener m;
    public String n;
    public String o;
    public Context p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public View w;
    public NativeUnifiedADData x;
    public NativeExpressADView y;
    public boolean z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22027a;
        public final /* synthetic */ String b;
        public final /* synthetic */ r c;

        /* JADX INFO: renamed from: cj.mobile.a.r$a$a, reason: collision with other inner class name */
        public class C0067a implements GDTAdSdk.OnStartListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f22028a;

            public C0067a(a aVar, long j) {
            }

            public void onStartFailed(Exception exc) {
            }

            public void onStartSuccess() {
            }
        }

        public a(r rVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f22029a;

        public b(r rVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c implements NativeADMediaListener {
        public c(r rVar) {
        }

        public void onVideoClicked() {
        }

        public void onVideoCompleted() {
        }

        public void onVideoError(AdError adError) {
        }

        public void onVideoInit() {
        }

        public void onVideoLoaded(int i) {
        }

        public void onVideoLoading() {
        }

        public void onVideoPause() {
        }

        public void onVideoReady() {
        }

        public void onVideoResume() {
        }

        public void onVideoStart() {
        }

        public void onVideoStop() {
        }
    }

    public class d implements UnifiedBannerADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22030a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJBannerListener f;
        public final /* synthetic */ r g;

        public d(r rVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJBannerListener cJBannerListener) {
        }

        public void onADClicked() {
        }

        public void onADClosed() {
        }

        public void onADExposure() {
        }

        public void onADLeftApplication() {
        }

        public void onADReceive() {
        }

        public void onNoAD(AdError adError) {
        }
    }

    public class e implements UnifiedInterstitialADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22031a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ r g;

        public e(r rVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onADClicked() {
        }

        public void onADClosed() {
        }

        public void onADExposure() {
        }

        public void onADLeftApplication() {
        }

        public void onADOpened() {
        }

        public void onADReceive() {
        }

        public void onNoAD(AdError adError) {
        }

        public void onRenderFail() {
        }

        public void onRenderSuccess() {
        }

        public void onVideoCached() {
        }
    }

    public class f implements UnifiedInterstitialADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22032a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJFullListener f;
        public final /* synthetic */ r g;

        public f(r rVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJFullListener cJFullListener) {
        }

        public void onADClicked() {
        }

        public void onADClosed() {
        }

        public void onADExposure() {
        }

        public void onADLeftApplication() {
        }

        public void onADOpened() {
        }

        public void onADReceive() {
        }

        public void onNoAD(AdError adError) {
        }

        public void onRenderFail() {
        }

        public void onRenderSuccess() {
        }

        public void onVideoCached() {
        }
    }

    public class g implements UnifiedInterstitialMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJFullListener f22033a;

        public g(r rVar, CJFullListener cJFullListener) {
        }

        public void onVideoComplete() {
        }

        public void onVideoError(AdError adError) {
        }

        public void onVideoInit() {
        }

        public void onVideoLoading() {
        }

        public void onVideoPageClose() {
        }

        public void onVideoPageOpen() {
        }

        public void onVideoPause() {
        }

        public void onVideoReady(long j) {
        }

        public void onVideoStart() {
        }
    }

    public class h implements RewardVideoADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22034a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ r g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f22035a;

            public a(h hVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public h(r rVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        public void onADClick() {
        }

        public void onADClose() {
        }

        public void onADExpose() {
        }

        public void onADLoad() {
        }

        public void onADShow() {
        }

        public void onError(AdError adError) {
        }

        public void onReward(Map<String, Object> map) {
        }

        public void onVideoCached() {
        }

        public void onVideoComplete() {
        }
    }

    public class i extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f22036a;

        public i(r rVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class j implements NativeExpressAD.NativeExpressADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.p.h f22037a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ r g;

        public j(r rVar, cj.mobile.p.h hVar, String str, String str2, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        public void onADClicked(NativeExpressADView nativeExpressADView) {
        }

        public void onADClosed(NativeExpressADView nativeExpressADView) {
        }

        public void onADExposure(NativeExpressADView nativeExpressADView) {
        }

        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        public void onADLoaded(List<NativeExpressADView> list) {
        }

        public void onNoAD(AdError adError) {
        }

        public void onRenderFail(NativeExpressADView nativeExpressADView) {
        }

        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        }
    }

    public class k implements NativeADUnifiedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22038a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ CJVideoFlowListener e;
        public final /* synthetic */ String f;
        public final /* synthetic */ r g;

        public class a implements NativeADMediaListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f22039a;

            public a(k kVar) {
            }

            public void onVideoClicked() {
            }

            public void onVideoCompleted() {
            }

            public void onVideoError(AdError adError) {
            }

            public void onVideoInit() {
            }

            public void onVideoLoaded(int i) {
            }

            public void onVideoLoading() {
            }

            public void onVideoPause() {
            }

            public void onVideoReady() {
            }

            public void onVideoResume() {
            }

            public void onVideoStart() {
            }

            public void onVideoStop() {
            }
        }

        public class b implements NativeADEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f22040a;

            public b(k kVar) {
            }

            public void onADClicked() {
            }

            public void onADError(AdError adError) {
            }

            public void onADExposed() {
            }

            public void onADStatusChanged() {
            }
        }

        public k(r rVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, CJVideoFlowListener cJVideoFlowListener, String str3) {
        }

        public void onADLoaded(List<NativeUnifiedADData> list) {
        }

        public void onNoAD(AdError adError) {
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22041a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJSplashListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ r g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f22042a;

            public a(l lVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public l(r rVar, String str, Context context, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class m implements NativeADUnifiedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22043a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRenderListener f;
        public final /* synthetic */ r g;

        public class a implements NativeADEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f22044a;

            public a(m mVar) {
            }

            public void onADClicked() {
            }

            public void onADError(AdError adError) {
            }

            public void onADExposed() {
            }

            public void onADStatusChanged() {
            }
        }

        public m(r rVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRenderListener cJRenderListener) {
        }

        public void onADLoaded(List<NativeUnifiedADData> list) {
        }

        public void onNoAD(AdError adError) {
        }
    }

    public class n implements NativeADMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMediaListener f22045a;

        public n(r rVar, CJMediaListener cJMediaListener) {
        }

        public void onVideoClicked() {
        }

        public void onVideoCompleted() {
        }

        public void onVideoError(AdError adError) {
        }

        public void onVideoInit() {
        }

        public void onVideoLoaded(int i) {
        }

        public void onVideoLoading() {
        }

        public void onVideoPause() {
        }

        public void onVideoReady() {
        }

        public void onVideoResume() {
        }

        public void onVideoStart() {
        }

        public void onVideoStop() {
        }
    }

    public class o implements SplashADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJSplashListener f22046a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ r g;

        public o(r rVar, CJSplashListener cJSplashListener, String str, String str2, cj.mobile.p.h hVar, Context context, String str3) {
        }

        public void onADClicked() {
        }

        public void onADDismissed() {
        }

        public void onADExposure() {
        }

        public void onADLoaded(long j) {
        }

        public void onADPresent() {
        }

        public void onADTick(long j) {
        }

        public void onNoAD(AdError adError) {
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22047a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJSplashListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ r g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f22048a;

            public a(p pVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public p(r rVar, String str, Context context, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class q implements NativeADUnifiedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22049a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ r g;

        public class a implements NativeADEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f22050a;

            public a(q qVar) {
            }

            public void onADClicked() {
            }

            public void onADError(AdError adError) {
            }

            public void onADExposed() {
            }

            public void onADStatusChanged() {
            }
        }

        public q(r rVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        public void onADLoaded(List<NativeUnifiedADData> list) {
        }

        public void onNoAD(AdError adError) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.r$r, reason: collision with other inner class name */
    public class RunnableC0068r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22051a;
        public final /* synthetic */ View b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ r d;

        public RunnableC0068r(r rVar, Activity activity, View view, TextView textView) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class s implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f22052a;

        public s(r rVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class t implements NativeADMediaListener {
        public t(r rVar) {
        }

        public void onVideoClicked() {
        }

        public void onVideoCompleted() {
        }

        public void onVideoError(AdError adError) {
        }

        public void onVideoInit() {
        }

        public void onVideoLoaded(int i) {
        }

        public void onVideoLoading() {
        }

        public void onVideoPause() {
        }

        public void onVideoReady() {
        }

        public void onVideoResume() {
        }

        public void onVideoStart() {
        }

        public void onVideoStop() {
        }
    }

    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22053a;
        public final /* synthetic */ View b;
        public final /* synthetic */ NativeAdContainer c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ r e;

        public u(r rVar, Activity activity, View view, NativeAdContainer nativeAdContainer, TextView textView) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static /* synthetic */ int d(r rVar) {
    }

    public void g() {
    }

    public r d(boolean z) {
        this.u = z;
        return this;
    }

    public r e(boolean z) {
        this.A = z;
        return this;
    }

    public r f(boolean z) {
        this.j = z;
        return this;
    }

    public r g(boolean z) {
        this.B = z;
        return this;
    }

    public void h() {
    }

    public View i() {
        return this.y;
    }

    public RenderAdInfo j() {
        return this.D;
    }

    public View k() {
        return this.w;
    }

    public r c(int i2) {
        this.t = i2;
        return this;
    }

    public r d(int i2) {
        this.s = i2;
        return this;
    }

    public void e() {
    }

    public void f() {
    }

    public r b(int i2) {
        this.r = i2;
        return this;
    }

    public void c() {
    }

    public void d() {
    }

    public void b() {
    }

    public void c(boolean z) {
    }

    public void d(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public r a(String str, String str2) {
        this.h = str;
        this.i = str2;
        return this;
    }

    public void b(boolean z) {
    }

    public void a() {
    }

    public void b(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str) {
    }

    public void a(boolean z) {
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void c(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public View b(Activity activity, boolean z) {
    }

    public void a(Activity activity, ViewGroup viewGroup) {
    }

    public void c(Activity activity) {
    }

    public View a(Activity activity, boolean z) {
    }

    public void b(Activity activity) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(int i2, boolean z, String str) {
    }

    public void a(int i2) {
    }

    public void a(Context context, String str, String str2, int i2, int i3, int i4, String str3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJVideoFlowListener cJVideoFlowListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
    }

    public final void a(NativeUnifiedADData nativeUnifiedADData) {
    }

    public View a(Context context, ViewGroup viewGroup, List<View> list) {
    }

    public void a(Context context, ViewGroup viewGroup, CJMediaListener cJMediaListener) {
    }
}
