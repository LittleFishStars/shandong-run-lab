package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.ads.WMAdInterstitial;
import com.kc.bw.common.Ilistener.XAdInterstitialListener;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMInterstitialAdapter extends BaseInterstitialBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    private static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String TAG = OSETSDKProtected.getString2(888);
    private WMAdInterstitial mWMAdInterstitial;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements XAdInterstitialListener {
        final WMInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4187);
        }

        public AnonymousClass1(WMInterstitialAdapter wMInterstitialAdapter) {
            this.this$0 = wMInterstitialAdapter;
        }

        @Override // com.kc.bw.common.Ilistener.XAdInterstitialListener
        public native void onAdClose();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onAdRequest();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onClick();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onExposure();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onNoAd(String str);
    }

    static {
        OSETSDKProtected.interface11(4188);
    }

    public static native /* synthetic */ void access$000(WMInterstitialAdapter wMInterstitialAdapter);

    public static native /* synthetic */ void access$100(WMInterstitialAdapter wMInterstitialAdapter);

    public static native /* synthetic */ void access$200(WMInterstitialAdapter wMInterstitialAdapter);

    public static native /* synthetic */ void access$300(WMInterstitialAdapter wMInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(WMInterstitialAdapter wMInterstitialAdapter);

    private native XAdInterstitialListener getAdLoaderListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseInterstitialBridge, com.kc.openset.ad.base.bridge.AdBridge
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
