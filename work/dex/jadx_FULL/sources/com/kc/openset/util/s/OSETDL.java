package com.kc.openset.util.s;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETDL {
    static {
        OSETSDKProtected.interface11(5035);
        System.loadLibrary(OSETSDKProtected.getString2(3450));
    }

    public static native void s1(Context context, String str, String str2, int i);

    public static native boolean s2(Context context, String str);
}
