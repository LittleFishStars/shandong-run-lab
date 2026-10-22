package com.kc.openset.ad.base.bridge.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ScreenUtilBridge {
    static {
        OSETSDKProtected.interface11(3791);
    }

    public static native int dip2px(Context context, int i);

    public static native DisplayMetrics getMetrics(Context context);

    public static native DisplayMetrics getMetricsFull(Context context);

    public static native int getNavigationBarHeight(Context context);

    public static native int getScreenHeight(Context context);

    public static native int getScreenHeightByDp(Context context);

    public static native int getScreenWidth(Context context);

    public static native int getScreenWidthByDp(Context context);

    public static native int getStatusBarHeight(Context context);

    public static native int px2dip(Context context, int i);
}
