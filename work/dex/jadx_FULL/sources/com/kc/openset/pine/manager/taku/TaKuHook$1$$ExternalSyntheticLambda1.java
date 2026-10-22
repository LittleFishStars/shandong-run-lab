package com.kc.openset.pine.manager.taku;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class TaKuHook$1$$ExternalSyntheticLambda1 implements Runnable {
    public final Object f$0;
    public final String[] f$1;
    public final Pine.CallFrame f$2;
    public final TaKuHook.OSETATBiddingListener f$3;

    static {
        OSETSDKProtected.interface11(4617);
    }

    public /* synthetic */ TaKuHook$1$$ExternalSyntheticLambda1(Object obj, String[] strArr, Pine.CallFrame callFrame, TaKuHook.OSETATBiddingListener oSETATBiddingListener) {
        this.f$0 = obj;
        this.f$1 = strArr;
        this.f$2 = callFrame;
        this.f$3 = oSETATBiddingListener;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
