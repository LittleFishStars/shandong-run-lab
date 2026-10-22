package cj.mobile.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJSplashListener;
import cj.mobile.p.h;
import cj.mobile.zf.ad.bean.ZFCJAdInfo;
import cj.mobile.zf.ad.bean.ZFCJInterstitialAdInfo;
import cj.mobile.zf.ad.bean.ZFCJNativeAdInfo;
import cj.mobile.zf.ad.impl.ZFCJInterstitialAd;
import cj.mobile.zf.ad.impl.ZFCJNativeAd;
import cj.mobile.zf.ad.impl.ZFCJSplashAd;
import cj.mobile.zf.ad.listener.DeviceParamsController;
import cj.mobile.zf.ad.listener.ZFCJInterstitialAdListener;
import cj.mobile.zf.ad.listener.ZFCJNativeAdListener;
import cj.mobile.zf.ad.listener.ZFCJSplashAdListener;
import cj.mobile.zf.exception.ZFCJAdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ZFSDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ZFCJSplashAd f22069a;
    public ZFCJInterstitialAd b;
    public ZFCJInterstitialAdInfo c;
    public ZFCJNativeAd d;
    public FrameLayout e;
    public FrameLayout f;
    public String g;
    public boolean h;
    public h i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public int n;
    public int o;
    public Handler p;

    /* JADX INFO: renamed from: cj.mobile.ad.ZFSDK$3, reason: invalid class name */
    public class AnonymousClass3 extends ZFCJSplashAdListener {
        public final /* synthetic */ ZFSDK this$0;
        public final /* synthetic */ String val$cjPosId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ CJSplashListener val$listener;
        public final /* synthetic */ h val$loadListener;
        public final /* synthetic */ String val$posId;
        public final /* synthetic */ String val$requestId;

        public AnonymousClass3(ZFSDK zfsdk, CJSplashListener cJSplashListener, String str, String str2, h hVar, Context context, String str3) {
        }

        public void onAdClick(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdClose(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdExpose(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdFailed(ZFCJAdError zFCJAdError) {
        }

        public void onAdReceive(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdSkip(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdTick(long j) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.ad.ZFSDK$4, reason: invalid class name */
    public class AnonymousClass4 implements ZFCJInterstitialAdListener {
        public final /* synthetic */ ZFSDK this$0;
        public final /* synthetic */ String val$cjPosId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ CJInterstitialListener val$listener;
        public final /* synthetic */ h val$loadListener;
        public final /* synthetic */ String val$posId;
        public final /* synthetic */ String val$requestId;

        public AnonymousClass4(ZFSDK zfsdk, String str, String str2, h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public /* bridge */ /* synthetic */ void onAdClick(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdClick(ZFCJInterstitialAdInfo zFCJInterstitialAdInfo, String str) {
        }

        public /* bridge */ /* synthetic */ void onAdClose(ZFCJAdInfo zFCJAdInfo) {
        }

        public /* bridge */ /* synthetic */ void onAdExpose(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdFailed(ZFCJAdError zFCJAdError) {
        }

        public /* bridge */ /* synthetic */ void onAdReady(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdReady(ZFCJInterstitialAdInfo zFCJInterstitialAdInfo) {
        }

        public /* bridge */ /* synthetic */ void onAdReceive(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdClick(ZFCJInterstitialAdInfo zFCJInterstitialAdInfo) {
        }

        public void onAdClose(ZFCJInterstitialAdInfo zFCJInterstitialAdInfo) {
        }

        public void onAdExpose(ZFCJInterstitialAdInfo zFCJInterstitialAdInfo) {
        }

        public void onAdReceive(ZFCJInterstitialAdInfo zFCJInterstitialAdInfo) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.ad.ZFSDK$5, reason: invalid class name */
    public class AnonymousClass5 extends ZFCJNativeAdListener {
        public final /* synthetic */ ZFSDK this$0;
        public final /* synthetic */ String val$cjPosId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ CJNativeExpressListener val$listener;
        public final /* synthetic */ h val$loadListener;
        public final /* synthetic */ String val$posId;
        public final /* synthetic */ String val$requestId;

        public AnonymousClass5(ZFSDK zfsdk, String str, String str2, h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        public /* bridge */ /* synthetic */ void onAdClick(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdClick(ZFCJNativeAdInfo zFCJNativeAdInfo, String str) {
        }

        public /* bridge */ /* synthetic */ void onAdClose(ZFCJAdInfo zFCJAdInfo) {
        }

        public /* bridge */ /* synthetic */ void onAdExpose(ZFCJAdInfo zFCJAdInfo) {
        }

        public void onAdFailed(ZFCJAdError zFCJAdError) {
        }

        public void onAdReceive(List<ZFCJNativeAdInfo> list) {
        }

        public void onRenderFailed(ZFCJNativeAdInfo zFCJNativeAdInfo, ZFCJAdError zFCJAdError) {
        }

        public void onAdClick(ZFCJNativeAdInfo zFCJNativeAdInfo) {
        }

        public void onAdClose(ZFCJNativeAdInfo zFCJNativeAdInfo) {
        }

        public void onAdExpose(ZFCJNativeAdInfo zFCJNativeAdInfo) {
        }
    }

    public class a extends DeviceParamsController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22070a;

        public a(ZFSDK zfsdk, Context context) {
        }

        public String getAndroidId() {
        }

        public boolean isCanUsePhoneState() {
            return false;
        }

        public boolean isCanUseWifiState() {
            return !cj.mobile.p.b.j0;
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZFSDK f22071a;

        public b(ZFSDK zfsdk, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public void b() {
    }

    public View c() {
        return this.f;
    }

    public ZFSDK b(int i) {
        this.n = i;
        return this;
    }

    public void a() {
    }

    public ZFSDK a(boolean z) {
        this.m = z;
        return this;
    }

    public ZFSDK a(int i) {
        this.o = i;
        return this;
    }

    public void a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, h hVar) {
    }
}
