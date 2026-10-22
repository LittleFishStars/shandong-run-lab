package com.kc.openset.bridge;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class UnityBridge$$ExternalSyntheticLambda4 implements Runnable {
    public final Activity f$0;
    public final String f$1;
    public final String f$2;

    static {
        OSETSDKProtected.interface11(4354);
    }

    public /* synthetic */ UnityBridge$$ExternalSyntheticLambda4(Activity activity, String str, String str2) {
        this.f$0 = activity;
        this.f$1 = str;
        this.f$2 = str2;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
