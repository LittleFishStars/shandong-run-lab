package com.kc.openset.plugin;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseDpOpt {
    static {
        OSETSDKProtected.interface11(4681);
    }

    public native String getDpOptSdkVersion();

    public native void openDeeplink(Context context, String str, String str2, DpOptResultListener dpOptResultListener);

    public native void s1(Context context, String str, String str2, int i);

    public native boolean s2(Context context, String str, String str2);
}
