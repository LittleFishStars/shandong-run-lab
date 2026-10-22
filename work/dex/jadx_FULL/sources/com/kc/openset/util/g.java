package com.kc.openset.util;

import android.os.Bundle;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f39972a;

    static {
        OSETSDKProtected.interface11(5010);
        f39972a = new HashSet();
    }

    private static native Bundle a(Object obj, String str);

    public static native String a(Object obj);

    private static native Field a(Class<?> cls, String str);

    private static native boolean a(Class<?> cls);

    private static native Bundle b(Object obj, String str);
}
