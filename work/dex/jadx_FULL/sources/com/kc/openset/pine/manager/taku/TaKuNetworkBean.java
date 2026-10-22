package com.kc.openset.pine.manager.taku;

import com.anythink.core.api.ATBaseAdInternalAdapter;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class TaKuNetworkBean {
    private ATBiddingResult atBiddingResult;
    private BaseAd baseAd;
    private boolean isLoaded;
    private ATBaseAdInternalAdapter mATBaseAdInternalAdapter;
    private String networkName;
    private String placementId;
    private TaKuHook.OSETATBiddingListener ssATBidListener;
    private MethodType methodType = MethodType.ON_C2S_BIDDING_RESULT_WITH_CACHE;
    private boolean isQd = false;

    @Keep
    public enum MethodType {
        ON_C2S_BIDDING_RESULT_WITH_CACHE,
        ON_C2S_BID_RESULT;

        static {
            OSETSDKProtected.interface11(4624);
        }

        public static native MethodType valueOf(String str);

        public static native MethodType[] values();
    }

    static {
        OSETSDKProtected.interface11(4625);
    }

    public native ATBaseAdInternalAdapter getATBaseAdInternalAdapter();

    public native ATBiddingResult getAtBiddingResult();

    public native BaseAd getBaseAd();

    public native MethodType getMethodType();

    public native String getNetworkName();

    public native String getPlacementId();

    public native TaKuHook.OSETATBiddingListener getSsATBidListener();

    public native boolean isLoaded();

    public native boolean isQd();

    public native void setATBaseAdInternalAdapter(ATBaseAdInternalAdapter aTBaseAdInternalAdapter);

    public native void setAtBiddingResult(ATBiddingResult aTBiddingResult);

    public native void setBaseAd(BaseAd baseAd);

    public native void setLoaded(boolean z);

    public native void setMethodType(MethodType methodType);

    public native void setNetworkName(String str);

    public native void setPlacementId(String str);

    public native void setQd(boolean z);

    public native void setSsATBidListener(TaKuHook.OSETATBiddingListener oSETATBiddingListener);

    public native String toString();
}
