package com.kc.openset.pine.manager.taku;

import com.anythink.core.api.ATBiddingResult;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class TaKuHook$OSETATBiddingListener$$ExternalSyntheticLambda1 implements Runnable {
    public final TaKuHook.OSETATBiddingListener f$0;
    public final ATBiddingResult f$1;

    static {
        OSETSDKProtected.interface11(4620);
    }

    public /* synthetic */ TaKuHook$OSETATBiddingListener$$ExternalSyntheticLambda1(TaKuHook.OSETATBiddingListener oSETATBiddingListener, ATBiddingResult aTBiddingResult) {
        this.f$0 = oSETATBiddingListener;
        this.f$1 = aTBiddingResult;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
