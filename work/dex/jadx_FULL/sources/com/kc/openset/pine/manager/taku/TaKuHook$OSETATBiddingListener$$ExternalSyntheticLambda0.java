package com.kc.openset.pine.manager.taku;

import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class TaKuHook$OSETATBiddingListener$$ExternalSyntheticLambda0 implements Runnable {
    public final TaKuHook.OSETATBiddingListener f$0;
    public final ATBiddingResult f$1;
    public final BaseAd f$2;

    static {
        OSETSDKProtected.interface11(4619);
    }

    public /* synthetic */ TaKuHook$OSETATBiddingListener$$ExternalSyntheticLambda0(TaKuHook.OSETATBiddingListener oSETATBiddingListener, ATBiddingResult aTBiddingResult, BaseAd baseAd) {
        this.f$0 = oSETATBiddingListener;
        this.f$1 = aTBiddingResult;
        this.f$2 = baseAd;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
