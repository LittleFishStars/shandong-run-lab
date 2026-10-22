package com.kc.openset.bridge;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.intestitial.OSETInterstitialAd;
import com.kc.openset.ad.listener.OSETInterstitialAdLoadListener;
import com.kc.openset.ad.listener.OSETInterstitialListener;
import com.kc.openset.ad.listener.OSETRewardAdLoadListener;
import com.kc.openset.ad.listener.OSETRewardListener;
import com.kc.openset.ad.listener.OSETSplashAdLoadListener;
import com.kc.openset.ad.listener.OSETSplashListener;
import com.kc.openset.ad.reward.OSETRewardAd;
import com.kc.openset.ad.splash.OSETSplashAd;
import com.kc.openset.listener.OSETInitListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class CocosBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f39726a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static boolean e;

    @Keep
    public class a implements OSETInitListener {
        static {
            OSETSDKProtected.interface11(4338);
        }

        @Override // com.kc.openset.listener.OSETInitListener
        public native void onError(String str);

        @Override // com.kc.openset.listener.OSETInitListener
        public native void onSuccess();
    }

    @Keep
    public class b implements OSETRewardAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39727a;

        @Keep
        public class a implements OSETRewardListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final OSETRewardAd f39728a;
            final b b;

            static {
                OSETSDKProtected.interface11(4339);
            }

            public a(b bVar, OSETRewardAd oSETRewardAd) {
                this.b = bVar;
                this.f39728a = oSETRewardAd;
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onClick();

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onClose();

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public native void onError(String str, String str2);

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onReward();

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onServiceResponse(int i);

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onShow();

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onVideoEnd();

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public native void onVideoStart();
        }

        static {
            OSETSDKProtected.interface11(4340);
        }

        public b(Activity activity) {
            this.f39727a = activity;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETRewardAdLoadListener
        public native void onLoadSuccess(OSETRewardAd oSETRewardAd);
    }

    @Keep
    public class c implements OSETSplashAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39729a;
        final FrameLayout b;
        final ViewGroup c;

        @Keep
        public class a implements OSETSplashListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final c f39730a;

            static {
                OSETSDKProtected.interface11(4341);
            }

            public a(c cVar) {
                this.f39730a = cVar;
            }

            @Override // com.kc.openset.ad.listener.OSETSplashListener
            public native void onAdDetailViewClosed();

            @Override // com.kc.openset.ad.listener.OSETSplashListener
            public native void onClick();

            @Override // com.kc.openset.ad.listener.OSETSplashListener
            public native void onClose();

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public native void onError(String str, String str2);

            @Override // com.kc.openset.ad.listener.OSETSplashListener
            public native void onShow();
        }

        static {
            OSETSDKProtected.interface11(4342);
        }

        public c(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup) {
            this.f39729a = activity;
            this.b = frameLayout;
            this.c = viewGroup;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETSplashAdLoadListener
        public native void onLoadSuccess(OSETSplashAd oSETSplashAd);
    }

    @Keep
    public class d implements OSETInterstitialAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39731a;

        @Keep
        public class a implements OSETInterstitialListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final d f39732a;

            static {
                OSETSDKProtected.interface11(4343);
            }

            public a(d dVar) {
                this.f39732a = dVar;
            }

            @Override // com.kc.openset.ad.listener.OSETInterstitialListener
            public native void onClick();

            @Override // com.kc.openset.ad.listener.OSETInterstitialListener
            public native void onClose();

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public native void onError(String str, String str2);

            @Override // com.kc.openset.ad.listener.OSETInterstitialListener
            public native void onShow();
        }

        static {
            OSETSDKProtected.interface11(4344);
        }

        public d(Activity activity) {
            this.f39731a = activity;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETInterstitialAdLoadListener
        public native void onLoadSuccess(OSETInterstitialAd oSETInterstitialAd);
    }

    @Keep
    public class e implements OSETInterstitialAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39733a;

        @Keep
        public class a implements OSETInterstitialListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f39734a;

            static {
                OSETSDKProtected.interface11(4345);
            }

            public a(e eVar) {
                this.f39734a = eVar;
            }

            @Override // com.kc.openset.ad.listener.OSETInterstitialListener
            public native void onClick();

            @Override // com.kc.openset.ad.listener.OSETInterstitialListener
            public native void onClose();

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public native void onError(String str, String str2);

            @Override // com.kc.openset.ad.listener.OSETInterstitialListener
            public native void onShow();
        }

        static {
            OSETSDKProtected.interface11(4346);
        }

        public e(Activity activity) {
            this.f39733a = activity;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETInterstitialAdLoadListener
        public native void onLoadSuccess(OSETInterstitialAd oSETInterstitialAd);
    }

    /* JADX INFO: renamed from: $r8$lambda$6ZXuWMJm2T-kM9P8LTeVJ1tIOzw, reason: not valid java name */
    public static native /* synthetic */ void m1027$r8$lambda$6ZXuWMJm2TkM9P8LTeVJ1tIOzw(String str);

    public static native /* synthetic */ void $r8$lambda$Am4IRUJBfXnP0voaB9ogpL1G2Dg(String str, String str2);

    public static native /* synthetic */ void $r8$lambda$CBBcLS9erZrtmyARlTedBK9jM3Q(String str, String str2);

    /* JADX INFO: renamed from: $r8$lambda$FwVJznGv-fgtN_PqfWyabb6z6-o, reason: not valid java name */
    public static native /* synthetic */ void m1028$r8$lambda$FwVJznGvfgtN_PqfWyabb6z6o(String str);

    public static native /* synthetic */ void $r8$lambda$GdTHmZiOeZ1LVkVGzHtj0axWuY0(String str);

    public static native /* synthetic */ void $r8$lambda$NBstRY_daeQ3eTbqy5Whn4SZiNI();

    public static native /* synthetic */ void $r8$lambda$_na4JcOgig_Wm4crV9y_A3IFR6g(String str);

    /* JADX INFO: renamed from: $r8$lambda$frPuApHa-R6n-yl2OWRlcMBi-Do, reason: not valid java name */
    public static native /* synthetic */ void m1029$r8$lambda$frPuApHaR6nyl2OWRlcMBiDo(String str, String str2);

    public static native /* synthetic */ void $r8$lambda$gRcnc5gzorOQNd1neq8ZHjCiEU8(String str, String str2);

    public static native /* synthetic */ void $r8$lambda$jztLdm2sJ4MZKznFLOcs_r5XsK8();

    static {
        OSETSDKProtected.interface11(4347);
        f39726a = new Handler(Looper.getMainLooper());
        e = true;
    }

    private static native void a();

    private static native void a(Runnable runnable);

    public static native /* synthetic */ void a(String str);

    private static native /* synthetic */ void a(String str, String str2);

    private static native void b();

    private static native /* synthetic */ void b(String str);

    private static native /* synthetic */ void b(String str, String str2);

    private static native void c();

    private static native /* synthetic */ void c(String str);

    private static native /* synthetic */ void c(String str, String str2);

    private static native /* synthetic */ void d();

    private static native /* synthetic */ void d(String str);

    private static native /* synthetic */ void d(String str, String str2);

    private static native /* synthetic */ void e();

    private static native /* synthetic */ void e(String str);

    private static native void f(String str);

    public static native void initSdk(String str, String str2);

    public static native void preLoadHorizontalInsert(String str, String str2);

    public static native void preLoadInsert(String str, String str2);

    public static native void preLoadReward(String str, String str2);

    public static native void showHorizontalInsert();

    public static native void showInsert();

    public static native void showReward(String str);

    public static native void showSplash(String str);

    public static native void showToast(String str);
}
