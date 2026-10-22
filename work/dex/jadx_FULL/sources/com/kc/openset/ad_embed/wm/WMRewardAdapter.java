package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.ads.WMAdRewardVideo;
import com.kc.bw.common.Ilistener.XAdRewardVideoListener;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMRewardAdapter extends BaseRewardBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    private static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String TAG = OSETSDKProtected.getString2(897);
    private WMAdRewardVideo mWMAdRewardVideo;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements XAdRewardVideoListener {
        final WMRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(TTAdConstant.INIT_FAILED_LOAD_PLUGIN_FAILED);
        }

        public AnonymousClass1(WMRewardAdapter wMRewardAdapter) {
            this.this$0 = wMRewardAdapter;
        }

        @Override // com.kc.bw.common.Ilistener.XAdRewardVideoListener
        public native void onAdClose();

        @Override // com.kc.bw.common.Ilistener.XAdRewardVideoListener
        public native void onAdLoad();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onAdRequest();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onClick();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onExposure();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onNoAd(String str);

        @Override // com.kc.bw.common.Ilistener.XAdRewardVideoListener
        public native void onRewarded(boolean z, Bundle bundle);

        @Override // com.kc.bw.common.Ilistener.XAdRewardVideoListener
        public native void onVideoComplete();

        @Override // com.kc.bw.common.Ilistener.XAdRewardVideoListener
        public native void onVideoError(String str);
    }

    static {
        OSETSDKProtected.interface11(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED);
    }

    public static native /* synthetic */ void access$000(WMRewardAdapter wMRewardAdapter);

    public static native /* synthetic */ void access$100(WMRewardAdapter wMRewardAdapter);

    public static native /* synthetic */ void access$200(WMRewardAdapter wMRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(WMRewardAdapter wMRewardAdapter);

    public static native /* synthetic */ void access$400(WMRewardAdapter wMRewardAdapter);

    public static native /* synthetic */ void access$500(WMRewardAdapter wMRewardAdapter);

    public static native /* synthetic */ void access$600(WMRewardAdapter wMRewardAdapter);

    private native XAdRewardVideoListener getAdLoaderListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseRewardBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
