package com.kc.openset.ad_embed.ms;

import android.app.Activity;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.ad.splash.ISplashAd;
import com.kc.dw.core.ad.splash.SplashAdEventLoader;
import com.kc.dw.core.ad.splash.SplashAdLoadListener;
import com.kc.dw.core.ad.splash.SplashInteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSSplashAdapter extends BaseSplashBridge {
    private static final String TAG = OSETSDKProtected.getString2(862);
    private ISplashAd mISplashAd;
    private SplashAdEventLoader mSplashAdEventLoader;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements SplashAdLoadListener {
        final MSSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4174);
        }

        public AnonymousClass1(MSSplashAdapter mSSplashAdapter) {
            this.this$0 = mSSplashAdapter;
        }

        /* JADX INFO: renamed from: onAdFail, reason: avoid collision after fix types in other method */
        public native void onAdFail2(ISplashAd iSplashAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onAdFail(ISplashAd iSplashAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native void onLoadFail(AdError adError);

        /* JADX INFO: renamed from: onLoadSuccess, reason: avoid collision after fix types in other method */
        public native void onLoadSuccess2(ISplashAd iSplashAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onLoadSuccess(ISplashAd iSplashAd);

        /* JADX INFO: renamed from: onRenderSuccess, reason: avoid collision after fix types in other method */
        public native void onRenderSuccess2(ISplashAd iSplashAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onRenderSuccess(ISplashAd iSplashAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSSplashAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements SplashInteractionListener {
        final MSSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4175);
        }

        public AnonymousClass2(MSSplashAdapter mSSplashAdapter) {
            this.this$0 = mSSplashAdapter;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClicked();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClosed();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdExposure();

        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
        public native void onSkip();

        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
        public native void onTick(long j);

        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
        public native void onTimeOver();
    }

    static {
        OSETSDKProtected.interface11(4176);
    }

    public static native /* synthetic */ void access$000(MSSplashAdapter mSSplashAdapter, int i, String str);

    public static native /* synthetic */ void access$100(MSSplashAdapter mSSplashAdapter, int i, String str);

    public static native /* synthetic */ ISplashAd access$202(MSSplashAdapter mSSplashAdapter, ISplashAd iSplashAd);

    public static native /* synthetic */ void access$300(MSSplashAdapter mSSplashAdapter);

    public static native /* synthetic */ void access$400(MSSplashAdapter mSSplashAdapter, int i, String str);

    public static native /* synthetic */ void access$500(MSSplashAdapter mSSplashAdapter, int i, String str);

    public static native /* synthetic */ void access$600(MSSplashAdapter mSSplashAdapter);

    public static native /* synthetic */ void access$700(MSSplashAdapter mSSplashAdapter);

    public static native /* synthetic */ void access$800(MSSplashAdapter mSSplashAdapter);

    public static native /* synthetic */ void access$900(MSSplashAdapter mSSplashAdapter);

    private native SplashAdLoadListener getAdLoadListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
