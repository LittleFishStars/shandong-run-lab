package com.kc.openset.util;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f39976a;
    public static HashMap<String, Integer> b;

    static {
        OSETSDKProtected.interface11(5019);
        f39976a = new HashMap<>();
        b = new HashMap<>();
    }

    public static native int a(Context context, long j);
}
