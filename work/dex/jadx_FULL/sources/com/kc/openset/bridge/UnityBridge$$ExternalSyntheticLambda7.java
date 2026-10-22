package com.kc.openset.bridge;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class UnityBridge$$ExternalSyntheticLambda7 implements Runnable {
    public final String f$0;
    public final Activity f$1;
    public final OSETUnityRewardListener f$2;

    static {
        OSETSDKProtected.interface11(4357);
    }

    public /* synthetic */ UnityBridge$$ExternalSyntheticLambda7(String str, Activity activity, OSETUnityRewardListener oSETUnityRewardListener) {
        this.f$0 = str;
        this.f$1 = activity;
        this.f$2 = oSETUnityRewardListener;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
