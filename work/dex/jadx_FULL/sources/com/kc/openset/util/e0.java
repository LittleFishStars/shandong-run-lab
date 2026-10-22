package com.kc.openset.util;

import android.content.Context;
import android.widget.Toast;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Toast f39970a;

    static {
        OSETSDKProtected.interface11(5005);
    }

    public static native void a(Context context, String str);

    public static native void a(String str);

    public static native void b(Context context, String str);
}
