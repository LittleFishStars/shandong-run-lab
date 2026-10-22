package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.ads.WMAdSplashad;
import com.kc.bw.common.Ilistener.XAdSplashListener;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMSplashAdapter extends BaseSplashBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    private static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String TAG = OSETSDKProtected.getString2(899);
    private WMAdSplashad mWMAdSplashAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements XAdSplashListener {
        final WMSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED);
        }

        public AnonymousClass1(WMSplashAdapter wMSplashAdapter) {
            this.this$0 = wMSplashAdapter;
        }

        @Override // com.kc.bw.common.Ilistener.XAdSplashListener
        public native void onAdDismissed();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onAdRequest();

        @Override // com.kc.bw.common.Ilistener.XAdSplashListener
        public native void onAdZoomOut();

        @Override // com.kc.bw.common.Ilistener.XAdSplashListener
        public native void onAdZoomOutClick();

        @Override // com.kc.bw.common.Ilistener.XAdSplashListener
        public native void onAdZoomOutDismissed();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onClick();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onExposure();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onNoAd(String str);
    }

    static {
        OSETSDKProtected.interface11(4203);
    }

    public static native /* synthetic */ void access$000(WMSplashAdapter wMSplashAdapter);

    public static native /* synthetic */ void access$100(WMSplashAdapter wMSplashAdapter);

    public static native /* synthetic */ void access$200(WMSplashAdapter wMSplashAdapter);

    public static native /* synthetic */ void access$300(WMSplashAdapter wMSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(WMSplashAdapter wMSplashAdapter);

    private native XAdSplashListener getAdLoaderListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseSplashBridge, com.kc.openset.ad.base.bridge.AdBridge
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
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
