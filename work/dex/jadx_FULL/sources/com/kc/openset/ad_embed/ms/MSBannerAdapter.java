package com.kc.openset.ad_embed.ms;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.ad.banner.BannerAdEventLoader;
import com.kc.dw.core.ad.banner.BannerAdLoadListener;
import com.kc.dw.core.ad.banner.IBannerAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSBannerAdapter extends BaseBannerBridge {
    private static final String TAG = OSETSDKProtected.getString2(834);
    private BannerAdEventLoader mBannerAdEventLoader;
    private IBannerAd mIBannerAd;
    private WeakReference<ViewGroup> mWeakReferenceBanner;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements BannerAdLoadListener {
        final MSBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4152);
        }

        public AnonymousClass1(MSBannerAdapter mSBannerAdapter) {
            this.this$0 = mSBannerAdapter;
        }

        /* JADX INFO: renamed from: onAdFail, reason: avoid collision after fix types in other method */
        public native void onAdFail2(IBannerAd iBannerAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onAdFail(IBannerAd iBannerAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native void onLoadFail(AdError adError);

        /* JADX INFO: renamed from: onLoadSuccess, reason: avoid collision after fix types in other method */
        public native void onLoadSuccess2(IBannerAd iBannerAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onLoadSuccess(IBannerAd iBannerAd);

        /* JADX INFO: renamed from: onRenderSuccess, reason: avoid collision after fix types in other method */
        public native void onRenderSuccess2(IBannerAd iBannerAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onRenderSuccess(IBannerAd iBannerAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements InteractionListener {
        final MSBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4153);
        }

        public AnonymousClass2(MSBannerAdapter mSBannerAdapter) {
            this.this$0 = mSBannerAdapter;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClicked();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClosed();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdExposure();
    }

    static {
        OSETSDKProtected.interface11(4154);
    }

    public static native /* synthetic */ void access$000(MSBannerAdapter mSBannerAdapter, int i, String str);

    public static native /* synthetic */ void access$100(MSBannerAdapter mSBannerAdapter, int i, String str);

    public static native /* synthetic */ IBannerAd access$202(MSBannerAdapter mSBannerAdapter, IBannerAd iBannerAd);

    public static native /* synthetic */ void access$300(MSBannerAdapter mSBannerAdapter);

    public static native /* synthetic */ void access$400(MSBannerAdapter mSBannerAdapter, int i, String str);

    public static native /* synthetic */ void access$500(MSBannerAdapter mSBannerAdapter, int i, String str);

    public static native /* synthetic */ WeakReference access$600(MSBannerAdapter mSBannerAdapter);

    public static native /* synthetic */ void access$700(MSBannerAdapter mSBannerAdapter, View view);

    public static native /* synthetic */ void access$800(MSBannerAdapter mSBannerAdapter, View view);

    public static native /* synthetic */ void access$900(MSBannerAdapter mSBannerAdapter, View view);

    private native BannerAdLoadListener getAdLoadListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdUserName();

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
    public native void toShowAd(Activity activity);
}
