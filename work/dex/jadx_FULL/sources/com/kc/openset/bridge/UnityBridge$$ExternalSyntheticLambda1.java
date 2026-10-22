package com.kc.openset.bridge;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.listener.OSETInterstitialListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class UnityBridge$$ExternalSyntheticLambda1 implements Runnable {
    public final Activity f$0;
    public final OSETInterstitialListener f$1;

    static {
        OSETSDKProtected.interface11(4351);
    }

    public /* synthetic */ UnityBridge$$ExternalSyntheticLambda1(Activity activity, OSETInterstitialListener oSETInterstitialListener) {
        this.f$0 = activity;
        this.f$1 = oSETInterstitialListener;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
