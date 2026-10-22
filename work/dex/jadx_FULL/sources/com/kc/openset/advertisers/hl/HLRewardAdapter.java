package com.kc.openset.advertisers.hl;

import android.app.Activity;
import android.os.Bundle;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLRewardAdapter extends BaseRewardBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    private static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String TAG = OSETSDKProtected.getString2(1061);
    private IMultiAdObject mRewardVideoAd;

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements AdRequestParam.ADLoadListener {
        final HLRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4278);
        }

        public AnonymousClass1(HLRewardAdapter hLRewardAdapter) {
            this.this$0 = hLRewardAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onADLoaded(IMultiAdObject iMultiAdObject);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLRewardAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements AdRequestParam.ADRewardVideoListener {
        final HLRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4279);
        }

        public AnonymousClass2(HLRewardAdapter hLRewardAdapter) {
            this.this$0 = hLRewardAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onAdClick(Bundle bundle);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onAdClose(Bundle bundle);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onAdShow(Bundle bundle);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onReward(Bundle bundle);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onSkippedVideo(Bundle bundle);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onVideoComplete(Bundle bundle);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public native void onVideoError(Bundle bundle);
    }

    static {
        OSETSDKProtected.interface11(4280);
    }

    public static native /* synthetic */ IMultiAdObject access$002(HLRewardAdapter hLRewardAdapter, IMultiAdObject iMultiAdObject);

    public static native /* synthetic */ void access$100(HLRewardAdapter hLRewardAdapter);

    public static native /* synthetic */ void access$1000(HLRewardAdapter hLRewardAdapter);

    public static native /* synthetic */ void access$200(HLRewardAdapter hLRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(HLRewardAdapter hLRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(HLRewardAdapter hLRewardAdapter);

    public static native /* synthetic */ void access$500(HLRewardAdapter hLRewardAdapter);

    public static native /* synthetic */ void access$600(HLRewardAdapter hLRewardAdapter);

    public static native /* synthetic */ void access$700(HLRewardAdapter hLRewardAdapter);

    public static native /* synthetic */ void access$800(HLRewardAdapter hLRewardAdapter, String str);

    public static native /* synthetic */ void access$900(HLRewardAdapter hLRewardAdapter);

    private native AdRequestParam.ADLoadListener getLoadListener();

    private native AdRequestParam.ADRewardVideoListener getRewardVideoListener();

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
