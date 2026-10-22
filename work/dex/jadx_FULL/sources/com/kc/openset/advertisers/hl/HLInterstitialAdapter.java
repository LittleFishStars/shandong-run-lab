package com.kc.openset.advertisers.hl;

import android.app.Activity;
import android.os.Bundle;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLInterstitialAdapter extends BaseInterstitialBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    private static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String TAG = OSETSDKProtected.getString2(1054);
    private IMultiAdObject mInterstitialAd;

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements AdRequestParam.ADLoadListener {
        final HLInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4267);
        }

        public AnonymousClass1(HLInterstitialAdapter hLInterstitialAdapter) {
            this.this$0 = hLInterstitialAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onADLoaded(IMultiAdObject iMultiAdObject);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLInterstitialAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements AdRequestParam.ADInteractionListener {
        final HLInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4268);
        }

        public AnonymousClass2(HLInterstitialAdapter hLInterstitialAdapter) {
            this.this$0 = hLInterstitialAdapter;
        }

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onADExposed();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdClick();

        @Override // com.hailiang.advlib.core.AdRequestParam.ADInteractionListener
        public native void onAdClose(Bundle bundle);

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdFailed(String str);
    }

    static {
        OSETSDKProtected.interface11(4269);
    }

    public static native /* synthetic */ IMultiAdObject access$002(HLInterstitialAdapter hLInterstitialAdapter, IMultiAdObject iMultiAdObject);

    public static native /* synthetic */ void access$100(HLInterstitialAdapter hLInterstitialAdapter);

    public static native /* synthetic */ void access$200(HLInterstitialAdapter hLInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(HLInterstitialAdapter hLInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(HLInterstitialAdapter hLInterstitialAdapter);

    public static native /* synthetic */ void access$500(HLInterstitialAdapter hLInterstitialAdapter);

    public static native /* synthetic */ void access$600(HLInterstitialAdapter hLInterstitialAdapter);

    public static native /* synthetic */ void access$700(HLInterstitialAdapter hLInterstitialAdapter, String str, String str2);

    private native AdRequestParam.ADInteractionListener getInteractionListener();

    private native AdRequestParam.ADLoadListener getLoadListener();

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
    public native String getS2SInfo();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
