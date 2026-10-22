package com.kc.openset.sdk.dsp.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f39926a;
    private SharedPreferences b;
    private final Object c = new Object();

    static {
        OSETSDKProtected.interface11(4898);
    }

    private a(Context context) {
        if (context != null) {
            this.b = context.getApplicationContext().getSharedPreferences(OSETSDKProtected.getString2(3021), 0);
        }
    }

    public static native a a(Context context);

    private native c a(String str);

    private native String a(String str, String str2);

    private native void a(String str, c cVar);

    public native void a(String str, String str2, int i);

    public native boolean a(String str, String str2, int i, int i2, boolean z);
}
