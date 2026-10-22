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
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import cj.mobile.wm.appsdkdex.WMAdSdk;
import cj.mobile.wm.appsdkdex.WMCustomPrivateController;
import cj.mobile.wm.appsdkdex.ads.WMAdInterstitial;
import cj.mobile.wm.appsdkdex.ads.WMAdNativeExpress;
import cj.mobile.wm.appsdkdex.ads.WMAdNativePot;
import cj.mobile.wm.appsdkdex.ads.WMAdRewardVideo;
import cj.mobile.wm.appsdkdex.ads.WMAdSplashad;
import cj.mobile.wm.common.Ilistener.XAdInterstitialListener;
import cj.mobile.wm.common.Ilistener.XAdNativeExpressListener;
import cj.mobile.wm.common.Ilistener.XAdNativePotListener;
import cj.mobile.wm.common.Ilistener.XAdRewardVideoListener;
import cj.mobile.wm.common.Ilistener.XAdSplashListener;
import cj.mobile.wm.common.bean.WMAdSlot;
import cj.mobile.wm.common.nativepot.AdBaseInfo;
import cj.mobile.wm.common.nativepot.NativeWMResponse;
import cj.mobile.wm.common.nativepot.WMVideoListener;
import cj.mobile.wm.common.nativepot.WMVideoOption;
import cj.mobile.wm.common.utils.DeviceIdentifierHelper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class s {
    public WMAdSplashad b;
    public WMAdInterstitial c;
    public WMAdRewardVideo d;
    public WMAdNativeExpress e;
    public WMAdNativePot f;
    public View g;
    public NativeWMResponse h;
    public boolean i;
    public cj.mobile.p.h j;
    public String k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public int u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22054a = "wm";
    public boolean t = true;
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public int z = 0;
    public RenderAdInfo A = new RenderAdInfo();
    public Handler B = new f(Looper.getMainLooper());

    public class a implements XAdNativePotListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22055a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRenderListener f;
        public final /* synthetic */ s g;

        public a(s sVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRenderListener cJRenderListener) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadFail(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadSuccess() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdRequest() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onClick() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onExposure() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdNativePotListener
        public void onNativePresent(NativeWMResponse nativeWMResponse) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
        }
    }

    public class b implements WMVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMediaListener f22056a;

        public b(s sVar, CJMediaListener cJMediaListener) {
        }

        @Override // cj.mobile.wm.common.nativepot.WMVideoListener
        public void onComplete() {
        }

        @Override // cj.mobile.wm.common.nativepot.WMVideoListener
        public void onError(String str) {
        }

        @Override // cj.mobile.wm.common.nativepot.WMVideoListener
        public void onStart() {
        }

        @Override // cj.mobile.wm.common.nativepot.WMVideoListener
        public void onStop() {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f22057a;

        public c(s sVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class d extends WMCustomPrivateController {
        public d(s sVar) {
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public String getDevOaid() {
            return cj.mobile.p.b.R;
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public boolean isCanUseAppList() {
            return cj.mobile.p.b.l0;
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public boolean isCanUseBootId() {
            return !cj.mobile.p.b.j0;
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public boolean isCanUseLocation() {
            return !cj.mobile.p.b.j0;
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public boolean isCanUseOaid() {
            return cj.mobile.p.b.k0;
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public boolean isCanUsePhoneState() {
            return !cj.mobile.p.b.j0;
        }

        @Override // cj.mobile.wm.appsdkdex.WMCustomPrivateController
        public boolean isCanUseWifiState() {
            return !cj.mobile.p.b.j0;
        }
    }

    public class e implements WMAdSdk.IInitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f22058a;

        public e(s sVar, long j) {
            this.f22058a = j;
        }

        @Override // cj.mobile.wm.appsdkdex.WMAdSdk.IInitCallback
        public void onFail(String str) {
            cj.mobile.p.b.J = 2;
            cj.mobile.p.g.b("init-wm", "error-" + str + "-version-" + new cj.mobile.b.q().a() + u15.f19942b + (System.currentTimeMillis() - this.f22058a));
        }

        @Override // cj.mobile.wm.appsdkdex.WMAdSdk.IInitCallback
        public void onSuccess() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            cj.mobile.p.b.J = 1;
            cj.mobile.p.g.b("init-wm", "success-version-" + new cj.mobile.b.q().a() + u15.f19942b + (jCurrentTimeMillis - this.f22058a));
        }
    }

    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 111) {
                return;
            }
            String str = (String) message.obj;
            if (s.this.i) {
                return;
            }
            s.this.s = true;
            s.this.i = true;
            cj.mobile.p.g.b(s.this.k, s.this.f22054a + c49.f40900a + str + "----timeOut");
            cj.mobile.p.f.a(s.this.f22054a, str, s.this.l, "timeOut");
            if (s.this.j != null) {
                s.this.j.onError(s.this.f22054a, str);
            }
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22060a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ CJSplashListener g;
        public final /* synthetic */ cj.mobile.p.h h;
        public final /* synthetic */ s i;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f22061a;

            public a(g gVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public g(s sVar, String str, Context context, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class h implements XAdSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJSplashListener f22062a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s g;

        public h(s sVar, CJSplashListener cJSplashListener, String str, String str2, cj.mobile.p.h hVar, Context context, String str3) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdSplashListener
        public void onAdDismissed() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadFail(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadSuccess() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdRequest() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdSplashListener
        public void onAdZoomOut() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdSplashListener
        public void onAdZoomOutClick() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdSplashListener
        public void onAdZoomOutDismissed() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onClick() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onExposure() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdSplashListener
        public void onExposureFailed(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
        }
    }

    public class i implements XAdInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitialListener f22063a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s g;

        public i(s sVar, CJInterstitialListener cJInterstitialListener, String str, String str2, cj.mobile.p.h hVar, Context context, String str3) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdInterstitialListener
        public void onAdClose() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadFail(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadSuccess() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdRequest() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onClick() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onExposure() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdInterstitialListener
        public void onExposureFailed(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
        }
    }

    public class j implements XAdRewardVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22064a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJRewardListener d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ s g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f22065a;

            public a(j jVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public j(s sVar, String str, String str2, cj.mobile.p.h hVar, CJRewardListener cJRewardListener, String str3, Context context) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdRewardVideoListener
        public void onAdClose() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadFail(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadSuccess() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdRewardVideoListener
        public void onAdLoad() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdRequest() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onClick() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onExposure() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdRewardVideoListener
        public void onExposureFailed(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdRewardVideoListener
        public void onRewarded(boolean z, Bundle bundle) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdRewardVideoListener
        public void onVideoComplete() {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdRewardVideoListener
        public void onVideoError(String str) {
        }
    }

    public class k implements XAdNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpressListener f22066a;
        public final /* synthetic */ cj.mobile.p.h b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s g;

        public k(s sVar, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar, String str, String str2, Context context, String str3) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdNativeExpressListener
        public void onADIsVideo(boolean z) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdNativeExpressListener
        public void onAdClose() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadFail(String str) {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdDownloadSuccess() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onAdRequest() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onClick() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onExposure() {
        }

        @Override // cj.mobile.wm.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdNativeExpressListener
        public void onRenderFailed(String str) {
        }

        @Override // cj.mobile.wm.common.Ilistener.XAdNativeExpressListener
        public void onRenderSuccess(View view, int i, int i2) {
        }
    }

    public void e() {
        WMAdRewardVideo wMAdRewardVideo = this.d;
        if (wMAdRewardVideo != null) {
            wMAdRewardVideo.destroy();
        }
    }

    public void f() {
        this.B.postDelayed(new c(this), 1000L);
    }

    public String g() {
        return this.x;
    }

    public String h() {
        return this.y;
    }

    public View i() {
        return this.g;
    }

    public RenderAdInfo j() {
        return this.A;
    }

    public String k() {
        return this.v;
    }

    public String l() {
        return this.w;
    }

    public void c() {
        WMAdNativeExpress wMAdNativeExpress = this.e;
        if (wMAdNativeExpress != null) {
            wMAdNativeExpress.destroy();
        }
    }

    public void d() {
        WMAdNativePot wMAdNativePot = this.f;
        if (wMAdNativePot != null) {
            wMAdNativePot.destroy();
        }
    }

    public void b() {
        WMAdInterstitial wMAdInterstitial = this.c;
        if (wMAdInterstitial != null) {
            wMAdInterstitial.destroy();
        }
    }

    public s c(boolean z) {
        this.t = z;
        return this;
    }

    public s b(boolean z) {
        this.o = z;
        return this;
    }

    public s c(int i2) {
        this.p = i2;
        return this;
    }

    public s b(int i2) {
        this.q = i2;
        return this;
    }

    public s a(int i2) {
        this.z = i2;
        return this;
    }

    public void b(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        String str4 = this.k + "-load";
        if (this.r) {
            str4 = str4 + "-bidding";
        }
        cj.mobile.p.g.b(str4, this.f22054a + c49.f40900a + str2);
        if (cj.mobile.p.b.J == 2) {
            if (this.i) {
                return;
            }
            this.i = true;
            cj.mobile.p.f.a(this.f22054a, str2, str3, "初始化失败");
            cj.mobile.p.g.b(this.k, this.f22054a + c49.f40900a + str2 + "-初始化失败");
            if (hVar != null) {
                hVar.onError(this.f22054a, str2);
                return;
            }
            return;
        }
        if (context == null) {
            if (this.i) {
                return;
            }
            this.i = true;
            cj.mobile.p.f.a(this.f22054a, str2, str3, "context=null");
            cj.mobile.p.g.b(this.k, this.f22054a + c49.f40900a + str2 + "-context=null");
            if (hVar != null) {
                hVar.onError(this.f22054a, str2);
                return;
            }
            return;
        }
        WMAdSlot wMAdSlotBuilder = new WMAdSlot.Builder().setSlotId(str2).setAdSize(cj.mobile.p.k.b(context, i2), cj.mobile.p.k.b(context, i3)).setCountDownDuration(this.z).builder();
        WMAdSplashad wMAdSplashad = new WMAdSplashad();
        this.b = wMAdSplashad;
        wMAdSplashad.load(wMAdSlotBuilder, new h(this, cJSplashListener, str2, str3, hVar, context, str));
    }

    public s a(String str, String str2) {
        this.m = str;
        this.n = str2;
        return this;
    }

    public s a(boolean z) {
        this.r = z;
        return this;
    }

    public void a(Context context, String str, String str2) {
        new WMAdSdk.Builder().setToken(str2).setkey(str).enablePersonalized(!cj.mobile.p.b.m0).enableSensor(cj.mobile.p.b.d0).setPrivateController(new d(this)).build(context).init(new e(this, System.currentTimeMillis()));
    }

    public String a(Context context) {
        String oaid;
        try {
            oaid = DeviceIdentifierHelper.getOaid(context);
            try {
                cj.mobile.p.g.a("wm-getoaid", "get-" + oaid);
            } catch (Exception e2) {
                e = e2;
                cj.mobile.p.g.a("wm-getoaid", e.getMessage());
            }
        } catch (Exception e3) {
            e = e3;
            oaid = "";
        }
        return oaid;
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        cj.mobile.p.f.a(this.f22054a, str2, str3);
        this.j = hVar;
        this.l = str3;
        this.u = cj.mobile.p.a.f22636a;
        this.k = MediationConstant.RIT_TYPE_SPLASH;
        this.i = false;
        cj.mobile.p.b.f22637a.execute(new g(this, str2, context, str, str3, i2, i3, cJSplashListener, hVar));
    }

    public void b(Activity activity) {
        WMAdRewardVideo wMAdRewardVideo = this.d;
        if (wMAdRewardVideo != null) {
            wMAdRewardVideo.show(activity);
        }
    }

    public void a(ViewGroup viewGroup) {
        WMAdSplashad wMAdSplashad = this.b;
        if (wMAdSplashad != null) {
            wMAdSplashad.show(viewGroup);
        }
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
        this.j = hVar;
        this.l = str3;
        this.u = cj.mobile.p.a.c;
        this.k = MediationConstant.RIT_TYPE_INTERSTITIAL;
        cj.mobile.p.f.a(this.f22054a, str2, str3);
        String str4 = this.k + "-load";
        if (this.r) {
            str4 = str4 + "-bidding";
        }
        cj.mobile.p.g.b(str4, this.f22054a + c49.f40900a + str2);
        if (context == null) {
            cj.mobile.p.f.a(this.f22054a, str2, str3, "context=null");
            cj.mobile.p.g.b(this.k, this.f22054a + c49.f40900a + str2 + "-context=null");
            if (hVar != null) {
                hVar.onError(this.f22054a, str2);
                return;
            }
            return;
        }
        this.i = false;
        Message message = new Message();
        message.obj = str2;
        this.B.sendMessageDelayed(message, 3000L);
        WMAdInterstitial wMAdInterstitial = new WMAdInterstitial(new WMAdSlot.Builder().setSlotId(str2).setMuted(!this.t).builder(), new i(this, cJInterstitialListener, str2, str3, hVar, context, str));
        this.c = wMAdInterstitial;
        wMAdInterstitial.load();
    }

    public void a(Activity activity) {
        WMAdInterstitial wMAdInterstitial = this.c;
        if (wMAdInterstitial != null) {
            wMAdInterstitial.show(activity);
        }
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
        cj.mobile.p.f.a(this.f22054a, str2, str3);
        this.j = hVar;
        this.l = str3;
        this.u = cj.mobile.p.a.e;
        this.k = "reward";
        String str4 = "reward-load";
        if (this.r) {
            str4 = "reward-load-bidding";
        }
        cj.mobile.p.g.b(str4, this.f22054a + c49.f40900a + str2);
        if (context == null) {
            cj.mobile.p.f.a(this.f22054a, str2, str3, "context=null");
            cj.mobile.p.g.b(this.k, this.f22054a + c49.f40900a + str2 + "-context=null");
            if (hVar != null) {
                hVar.onError(this.f22054a, str2);
                return;
            }
            return;
        }
        this.i = false;
        Message message = new Message();
        message.obj = str2;
        this.B.sendMessageDelayed(message, 3000L);
        WMAdRewardVideo wMAdRewardVideo = new WMAdRewardVideo(new WMAdSlot.Builder().setSlotId(str2).setMuted(!this.t).setOrientation(2).builder(), new j(this, str2, str3, hVar, cJRewardListener, str, context));
        this.d = wMAdRewardVideo;
        wMAdRewardVideo.load();
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
        cj.mobile.p.f.a(this.f22054a, str2, str3);
        this.j = hVar;
        this.l = str3;
        this.u = cj.mobile.p.a.f;
        this.k = "nativeExpress";
        String str4 = this.k + "-load";
        if (this.r) {
            str4 = str4 + "-bidding";
        }
        cj.mobile.p.g.b(str4, this.f22054a + c49.f40900a + str2);
        if (context == null) {
            cj.mobile.p.f.a(this.f22054a, str2, str3, "context=null");
            cj.mobile.p.g.b(this.k, this.f22054a + c49.f40900a + str2 + "-context=null");
            if (hVar != null) {
                hVar.onError(this.f22054a, str2);
                return;
            }
            return;
        }
        this.i = false;
        Message message = new Message();
        message.obj = str2;
        this.B.sendMessageDelayed(message, 3000L);
        this.e = new WMAdNativeExpress(new WMAdSlot.Builder().setSlotId(str2).setMuted(!this.t).setAdSize(cj.mobile.p.k.b(context, i2), cj.mobile.p.k.b(context, i3)).builder(), new k(this, cJNativeExpressListener, hVar, str2, str3, context, str));
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
        cj.mobile.p.f.a(this.f22054a, str2, str3);
        this.j = hVar;
        this.l = str3;
        this.u = cj.mobile.p.a.f;
        this.k = "RenderNative";
        String str4 = this.k + "-load";
        if (this.r) {
            str4 = str4 + "-bidding";
        }
        cj.mobile.p.g.b(str4, this.f22054a + c49.f40900a + str2);
        if (context == null) {
            cj.mobile.p.f.a(this.f22054a, str2, str3, "context=null");
            cj.mobile.p.g.b(this.k, this.f22054a + c49.f40900a + str2 + "-context=null");
            if (hVar != null) {
                hVar.onError(this.f22054a, str2);
                return;
            }
            return;
        }
        this.i = false;
        Message message = new Message();
        message.obj = str2;
        this.B.sendMessageDelayed(message, 3000L);
        WMAdNativePot wMAdNativePot = new WMAdNativePot(new WMAdSlot.Builder().setSlotId(str2).setMuted(!this.t).builder(), new a(this, str2, str3, hVar, context, str, cJRenderListener));
        this.f = wMAdNativePot;
        wMAdNativePot.loadAd();
    }

    public final void a(AdBaseInfo adBaseInfo) {
        this.A.setTitle(adBaseInfo.getTitle());
        this.A.setDesc(adBaseInfo.getDesc());
        this.A.setImgListUrls(adBaseInfo.getImageUrls());
        this.A.setImgUrl(adBaseInfo.getImageUrl());
        this.A.setAdIconUrl(adBaseInfo.getAdLogoUrl());
        this.A.setImgWidth(adBaseInfo.getPictureWidth());
        this.A.setImgHeight(adBaseInfo.getPictureHeight());
        if (adBaseInfo.getMaterialType() == AdBaseInfo.MaterialType.NORMAL) {
            if (adBaseInfo.getImageUrls() != null && adBaseInfo.getImageUrls().size() > 1) {
                this.A.setAdType(2);
            } else {
                this.A.setAdType(1);
            }
        } else if (adBaseInfo.getMaterialType() == AdBaseInfo.MaterialType.VIDEO) {
            this.A.setAdType(3);
        }
        if (adBaseInfo.getInteractionType() == AdBaseInfo.InteractionType.DOWNLOAD) {
            this.A.setButtonText("下载");
        } else {
            this.A.setButtonText("去查看");
        }
        if (adBaseInfo.getDownloadAppInfo() != null) {
            this.A.setAppName(adBaseInfo.getDownloadAppInfo().getAppName());
            this.A.setAppAuthorName(adBaseInfo.getDownloadAppInfo().getAppDeveloper());
            this.A.setAppVersionName(adBaseInfo.getDownloadAppInfo().getAppVersion());
            this.A.setAppIconUrl(adBaseInfo.getDownloadAppInfo().getAppIconUrl());
        }
    }

    public View a(Context context, View view, List<View> list, String str, int i2, int i3, CJRenderListener cJRenderListener) {
        ViewGroup viewGroupBuildContainer = this.h.buildContainer();
        this.h.bindToAdContainer(viewGroupBuildContainer, view);
        this.h.registerClickableViews(list);
        this.h.notifyAdViewShow();
        return viewGroupBuildContainer;
    }

    public void a(Context context, ViewGroup viewGroup, CJMediaListener cJMediaListener) {
        WMVideoOption wMVideoOption = new WMVideoOption();
        wMVideoOption.setAutoPlay(true);
        wMVideoOption.setSilence(true ^ this.t);
        viewGroup.addView(this.h.buildVideoView(wMVideoOption, new b(this, cJMediaListener)).getVideoView());
    }

    public void a() {
        WMAdNativePot wMAdNativePot;
        if (this.r) {
            int i2 = this.u;
            if (i2 == cj.mobile.p.a.e) {
                WMAdRewardVideo wMAdRewardVideo = this.d;
                if (wMAdRewardVideo != null) {
                    wMAdRewardVideo.sendWinNotificationWithInfo(null);
                    return;
                }
                return;
            }
            if (i2 == cj.mobile.p.a.f22636a) {
                WMAdSplashad wMAdSplashad = this.b;
                if (wMAdSplashad != null) {
                    wMAdSplashad.sendWinNotificationWithInfo(null);
                    return;
                }
                return;
            }
            if (i2 == cj.mobile.p.a.c) {
                WMAdInterstitial wMAdInterstitial = this.c;
                if (wMAdInterstitial != null) {
                    wMAdInterstitial.sendWinNotificationWithInfo(null);
                    return;
                }
                return;
            }
            if (i2 == cj.mobile.p.a.f) {
                WMAdNativeExpress wMAdNativeExpress = this.e;
                if (wMAdNativeExpress != null) {
                    wMAdNativeExpress.sendWinNotificationWithInfo(null);
                    return;
                }
                return;
            }
            if (i2 != cj.mobile.p.a.h || (wMAdNativePot = this.f) == null) {
                return;
            }
            wMAdNativePot.sendWinNotificationWithInfo(null);
        }
    }
}
