package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.jt.core.JuTuiAdSlot;
import cj.mobile.jt.core.JuTuiPrivacyController;
import cj.mobile.jt.core.interstitial.JuTuiInterstitialAd;
import cj.mobile.jt.core.interstitial.JuTuiInterstitialListener;
import cj.mobile.jt.core.modle.AdError;
import cj.mobile.jt.core.modle.IJuTuiBiddingAdData;
import cj.mobile.jt.core.nativead.JuTuiNativeAd;
import cj.mobile.jt.core.nativead.JuTuiNativeAdData;
import cj.mobile.jt.core.nativead.JuTuiNativeAdLoadListener;
import cj.mobile.jt.core.nativead.NativeAdEventListener;
import cj.mobile.jt.core.splash.JuTuiSplashAd;
import cj.mobile.jt.core.splash.JuTuiSplashListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJSplashListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IJuTuiBiddingAdData f21862a;
    public JuTuiSplashAd b;
    public JuTuiInterstitialAd c;
    public JuTuiNativeAd d;
    public JuTuiNativeAdData e;
    public FrameLayout f;
    public cj.mobile.p.h g;
    public String h;
    public String i;
    public String j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public RenderAdInfo o;
    public IJuTuiBiddingAdData.LOSS_REASON p;
    public boolean q;
    public Handler r;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21863a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;

        /* JADX INFO: renamed from: cj.mobile.a.g$a$a, reason: collision with other inner class name */
        public class C0051a extends JuTuiPrivacyController {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21864a;

            public C0051a(a aVar) {
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public String getAndroidId() {
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public String getOaid() {
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanGetAppList() {
                return cj.mobile.p.b.l0;
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanGetMacAddress() {
                return !cj.mobile.p.b.j0;
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanGetOaid() {
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanUseAndroidId() {
                return false;
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanUseLocation() {
                return !cj.mobile.p.b.j0;
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanUsePhoneState() {
                return !cj.mobile.p.b.j0;
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanUseWifiState() {
                return !cj.mobile.p.b.j0;
            }

            @Override // cj.mobile.jt.core.JuTuiPrivacyController
            public boolean isCanUseWriteExternal() {
                return !cj.mobile.p.b.j0;
            }
        }

        public a(g gVar, String str, String str2, Context context) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b implements NativeAdEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21865a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ CJRenderListener e;
        public final /* synthetic */ g f;

        public b(g gVar, Context context, String str, int i, int i2, CJRenderListener cJRenderListener) {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onAdClicked() {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onAdClose() {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onAdExposed() {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onShowError(AdError adError) {
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f21866a;

        public c(g gVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class d implements JuTuiSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21867a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ g g;

        public d(g gVar, String str, String str2, cj.mobile.p.h hVar, CJSplashListener cJSplashListener, Context context, String str3) {
        }

        @Override // cj.mobile.jt.core.splash.JuTuiSplashListener, cj.mobile.jt.core.interfaces.o
        public void onAdClicked() {
        }

        @Override // cj.mobile.jt.core.splash.JuTuiSplashListener, cj.mobile.jt.core.interfaces.o
        public void onAdDismissed() {
        }

        @Override // cj.mobile.jt.core.splash.JuTuiSplashListener
        public void onAdLoaded(IJuTuiBiddingAdData iJuTuiBiddingAdData) {
        }

        @Override // cj.mobile.jt.core.splash.JuTuiSplashListener, cj.mobile.jt.core.interfaces.o
        public void onAdPresent() {
        }

        @Override // cj.mobile.jt.core.splash.JuTuiSplashListener
        public void onNoAd(AdError adError) {
        }

        @Override // cj.mobile.jt.core.splash.JuTuiSplashListener, cj.mobile.jt.core.interfaces.o
        public void onShowError(AdError adError) {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21868a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ JuTuiAdSlot c;
        public final /* synthetic */ JuTuiSplashListener d;
        public final /* synthetic */ g e;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21869a;

            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public e(g gVar, String str, Context context, JuTuiAdSlot juTuiAdSlot, JuTuiSplashListener juTuiSplashListener) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class f implements JuTuiInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21870a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJInterstitialListener d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ g g;

        public f(g gVar, String str, String str2, cj.mobile.p.h hVar, CJInterstitialListener cJInterstitialListener, Context context, String str3) {
        }

        @Override // cj.mobile.jt.core.interstitial.JuTuiInterstitialListener, cj.mobile.jt.core.interfaces.o
        public void onAdClicked() {
        }

        @Override // cj.mobile.jt.core.interstitial.JuTuiInterstitialListener, cj.mobile.jt.core.interfaces.o
        public void onAdDismissed() {
        }

        @Override // cj.mobile.jt.core.interstitial.JuTuiInterstitialListener
        public void onAdLoaded(IJuTuiBiddingAdData iJuTuiBiddingAdData) {
        }

        @Override // cj.mobile.jt.core.interstitial.JuTuiInterstitialListener, cj.mobile.jt.core.interfaces.o
        public void onAdPresent() {
        }

        @Override // cj.mobile.jt.core.interstitial.JuTuiInterstitialListener
        public void onNoAd(AdError adError) {
        }

        @Override // cj.mobile.jt.core.interstitial.JuTuiInterstitialListener, cj.mobile.jt.core.interfaces.o
        public void onShowError(AdError adError) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.g$g, reason: collision with other inner class name */
    public class C0052g implements JuTuiNativeAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21871a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ String h;
        public final /* synthetic */ CJNativeExpressListener i;
        public final /* synthetic */ g j;

        public C0052g(g gVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, int i, int i2, String str4, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdLoadListener
        public void onAdLoadFail(AdError adError) {
        }

        @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdLoadListener
        public void onAdLoadSuccess(List<JuTuiNativeAdData> list) {
        }
    }

    public class h implements NativeAdEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21872a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ g g;

        public h(g gVar, Context context, String str, String str2, String str3, String str4, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onAdClicked() {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onAdClose() {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onAdExposed() {
        }

        @Override // cj.mobile.jt.core.nativead.NativeAdEventListener
        public void onShowError(AdError adError) {
        }
    }

    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpressListener f21873a;
        public final /* synthetic */ g b;

        public i(g gVar, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class j implements JuTuiNativeAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21874a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ g d;

        public j(g gVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdLoadListener
        public void onAdLoadFail(AdError adError) {
        }

        @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdLoadListener
        public void onAdLoadSuccess(List<JuTuiNativeAdData> list) {
        }
    }

    public void c() {
    }

    public View d() {
        return this.f;
    }

    public RenderAdInfo e() {
        return this.o;
    }

    public void b() {
    }

    public g c(int i2) {
        this.k = i2;
        return this;
    }

    public g b(int i2) {
        this.l = i2;
        return this;
    }

    public void a() {
    }

    public g a(boolean z) {
        this.m = z;
        return this;
    }

    public void a(Context context, String str, String str2) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, String str4, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, JuTuiNativeAdData juTuiNativeAdData, String str4, CJNativeExpressListener cJNativeExpressListener) {
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
    }

    public final void a(JuTuiNativeAdData juTuiNativeAdData) {
    }

    public View a(Context context, ViewGroup viewGroup, List<View> list, String str, int i2, int i3, CJRenderListener cJRenderListener) {
    }

    public void a(int i2) {
    }

    public void a(int i2, String str) {
    }
}
