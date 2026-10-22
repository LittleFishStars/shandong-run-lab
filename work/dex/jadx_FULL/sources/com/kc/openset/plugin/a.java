package com.kc.openset.plugin;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f39809a = "";
    private static BaseDpOpt b;
    private static boolean c;
    private static BaseDpOpt d;
    private static boolean e;

    static {
        OSETSDKProtected.interface11(4683);
    }

    public static native BaseDpOpt a();

    public static native void a(Context context, String str, DpOptResultListener dpOptResultListener);

    public static native boolean a(Context context, String str, String str2);

    public static native boolean a(Context context, String str, String str2, int i);

    private static native BaseDpOpt b();
}
