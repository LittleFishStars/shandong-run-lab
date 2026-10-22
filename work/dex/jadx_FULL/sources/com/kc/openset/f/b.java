package com.kc.openset.f;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b {
    static {
        OSETSDKProtected.interface11(4426);
    }

    private static native int a(Context context, String str);

    public static native Rect a(Context context, int i, int i2);

    public static native DisplayMetrics a(Context context);

    public static native DisplayMetrics b(Context context);

    public static native int c(Context context);

    public static native int[] d(Context context);

    public static native int e(Context context);

    public static native boolean f(Context context);
}
