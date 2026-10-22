package com.kc.openset.bridge;

import android.app.Activity;
import android.app.Application;
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
import com.kc.openset.config.controller.OSETCustomController;
import com.kc.openset.config.controller.OSETUnityCustomController;
import com.kc.openset.listener.OSETInitListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class UnityBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f39736a;

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETUnityCustomController f39737a;
        final String b;
        final Application c;
        final String d;
        final OSETInitListener e;

        static {
            OSETSDKProtected.interface11(4358);
        }

        public a(OSETUnityCustomController oSETUnityCustomController, String str, Application application, String str2, OSETInitListener oSETInitListener) {
            this.f39737a = oSETUnityCustomController;
            this.b = str;
            this.c = application;
            this.d = str2;
            this.e = oSETInitListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class b extends OSETCustomController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETUnityCustomController f39738a;

        static {
            OSETSDKProtected.interface11(4359);
        }

        public b(OSETUnityCustomController oSETUnityCustomController) {
            this.f39738a = oSETUnityCustomController;
        }

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canReadInstalledPackages();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canReadLocation();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUseMacAddress();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUseNetworkState();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUseOaid();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUsePersonalizedAd();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUsePhoneState();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUseSensor();

        @Override // com.kc.openset.config.controller.OSETCustomController
        public native boolean canUseStoragePermission();
    }

    @Keep
    public class c implements OSETRewardAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39739a;
        final OSETUnityRewardListener b;

        @Keep
        public class a implements OSETRewardListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final OSETRewardAd f39740a;
            final c b;

            static {
                OSETSDKProtected.interface11(4360);
            }

            public a(c cVar, OSETRewardAd oSETRewardAd) {
                this.b = cVar;
                this.f39740a = oSETRewardAd;
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
            OSETSDKProtected.interface11(4361);
        }

        public c(Activity activity, OSETUnityRewardListener oSETUnityRewardListener) {
            this.f39739a = activity;
            this.b = oSETUnityRewardListener;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETRewardAdLoadListener
        public native void onLoadSuccess(OSETRewardAd oSETRewardAd);
    }

    @Keep
    public class d implements OSETSplashAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39741a;
        final FrameLayout b;
        final OSETSplashListener c;
        final ViewGroup d;

        @Keep
        public class a implements OSETSplashListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final d f39742a;

            static {
                OSETSDKProtected.interface11(4362);
            }

            public a(d dVar) {
                this.f39742a = dVar;
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
            OSETSDKProtected.interface11(4363);
        }

        public d(Activity activity, FrameLayout frameLayout, OSETSplashListener oSETSplashListener, ViewGroup viewGroup) {
            this.f39741a = activity;
            this.b = frameLayout;
            this.c = oSETSplashListener;
            this.d = viewGroup;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETSplashAdLoadListener
        public native void onLoadSuccess(OSETSplashAd oSETSplashAd);
    }

    @Keep
    public class e implements OSETInterstitialAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39743a;
        final OSETInterstitialListener b;

        @Keep
        public class a implements OSETInterstitialListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f39744a;

            static {
                OSETSDKProtected.interface11(4364);
            }

            public a(e eVar) {
                this.f39744a = eVar;
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
            OSETSDKProtected.interface11(4365);
        }

        public e(Activity activity, OSETInterstitialListener oSETInterstitialListener) {
            this.f39743a = activity;
            this.b = oSETInterstitialListener;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETInterstitialAdLoadListener
        public native void onLoadSuccess(OSETInterstitialAd oSETInterstitialAd);
    }

    @Keep
    public class f implements OSETInterstitialAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Activity f39745a;
        final OSETInterstitialListener b;

        @Keep
        public class a implements OSETInterstitialListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final f f39746a;

            static {
                OSETSDKProtected.interface11(4366);
            }

            public a(f fVar) {
                this.f39746a = fVar;
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
            OSETSDKProtected.interface11(4367);
        }

        public f(Activity activity, OSETInterstitialListener oSETInterstitialListener) {
            this.f39745a = activity;
            this.b = oSETInterstitialListener;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.OSETInterstitialAdLoadListener
        public native void onLoadSuccess(OSETInterstitialAd oSETInterstitialAd);
    }

    /* JADX INFO: renamed from: $r8$lambda$4RrG0O1SwsEcLgvAp8MT-OY5MoM, reason: not valid java name */
    public static native /* synthetic */ void m1030$r8$lambda$4RrG0O1SwsEcLgvAp8MTOY5MoM(Activity activity, String str, String str2);

    public static native /* synthetic */ void $r8$lambda$61t87GNbCcfUpk3_e0p8tkmq4Iw(Activity activity, String str, OSETSplashListener oSETSplashListener);

    /* JADX INFO: renamed from: $r8$lambda$BbeHrciJQoyvWNjZO70Tkq-5ZXE, reason: not valid java name */
    public static native /* synthetic */ void m1031$r8$lambda$BbeHrciJQoyvWNjZO70Tkq5ZXE(String str);

    public static native /* synthetic */ void $r8$lambda$aiosSpFdsuytocuRuhbpmPDI89g(Activity activity, String str, String str2);

    public static native /* synthetic */ void $r8$lambda$c2vKk1k22PlPtvy3i8NaqH7hAMs(Activity activity, OSETInterstitialListener oSETInterstitialListener);

    public static native /* synthetic */ void $r8$lambda$g2PlANHMnPJNw1OcnzaqP4wtISM(Activity activity, OSETInterstitialListener oSETInterstitialListener);

    public static native /* synthetic */ void $r8$lambda$iYzQqeial4_cAwqv9iOm6C50qsY(String str, Activity activity, OSETUnityRewardListener oSETUnityRewardListener);

    /* JADX INFO: renamed from: $r8$lambda$x-jMuvpF2hkEfi6n8izQDU7dOMs, reason: not valid java name */
    public static native /* synthetic */ void m1032$r8$lambda$xjMuvpF2hkEfi6n8izQDU7dOMs(Activity activity, String str, String str2);

    static {
        OSETSDKProtected.interface11(4368);
        f39736a = new Handler(Looper.getMainLooper());
    }

    public static native /* synthetic */ OSETCustomController a(OSETUnityCustomController oSETUnityCustomController);

    private static native /* synthetic */ void a(Activity activity, OSETInterstitialListener oSETInterstitialListener);

    private static native /* synthetic */ void a(Activity activity, String str, OSETSplashListener oSETSplashListener);

    private static native /* synthetic */ void a(Activity activity, String str, String str2);

    private static native /* synthetic */ void a(String str);

    private static native /* synthetic */ void a(String str, Activity activity, OSETUnityRewardListener oSETUnityRewardListener);

    private static native OSETCustomController b(OSETUnityCustomController oSETUnityCustomController);

    private static native /* synthetic */ void b(Activity activity, OSETInterstitialListener oSETInterstitialListener);

    private static native /* synthetic */ void b(Activity activity, String str, String str2);

    private static native /* synthetic */ void c(Activity activity, String str, String str2);

    public static native void initSdk(Application application, String str, String str2, OSETInitListener oSETInitListener);

    public static native void initSdk(Application application, String str, String str2, OSETInitListener oSETInitListener, OSETUnityCustomController oSETUnityCustomController);

    public static native void preLoadHorizontal(Activity activity, String str, String str2);

    public static native void preLoadInsert(Activity activity, String str, String str2);

    public static native void preLoadReward(Activity activity, String str, String str2);

    public static native void showInsert(Activity activity, OSETInterstitialListener oSETInterstitialListener);

    public static native void showInsertHorizontal(Activity activity, OSETInterstitialListener oSETInterstitialListener);

    public static native void showReward(Activity activity, String str, OSETUnityRewardListener oSETUnityRewardListener);

    public static native void showSplash(Activity activity, String str, OSETSplashListener oSETSplashListener);

    public static native void showToast(String str);
}
