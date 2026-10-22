package com.kc.openset.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, d> f39968a;
    private SharedPreferences b;

    static {
        OSETSDKProtected.interface11(5004);
        f39968a = new HashMap();
    }

    private d(String str, int i) {
        Context context = ContextUtils.getContext();
        if (context != null) {
            this.b = context.getSharedPreferences(str, i);
        }
    }

    public static native d a(String str, int i);

    public static native d b(String str);

    private static native boolean e(String str);

    public native long a(String str, long j);

    public native String a(String str, String str2);

    public native void a(String str, int i, boolean z);

    public native void a(String str, long j, boolean z);

    public native void a(String str, String str2, boolean z);

    public native void a(String str, boolean z, boolean z2);

    public native boolean a(String str);

    public native boolean a(String str, boolean z);

    public native int b(String str, int i);

    public native void b(String str, String str2);

    public native void b(String str, boolean z);

    public native long c(String str);

    public native String d(String str);
}
