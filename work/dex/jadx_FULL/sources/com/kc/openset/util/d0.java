package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.text.SimpleDateFormat;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Map<String, SimpleDateFormat>> f39969a;
    private static final String[] b;
    private static final int[] c;
    private static final String[] d;

    @Keep
    public class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        static {
            OSETSDKProtected.interface11(5002);
        }

        public native Map<String, SimpleDateFormat> a();

        @Override // java.lang.ThreadLocal
        public native /* bridge */ /* synthetic */ Map<String, SimpleDateFormat> initialValue();
    }

    static {
        OSETSDKProtected.interface11(5003);
        f39969a = new a();
        b = new String[]{OSETSDKProtected.getString2(com.igexin.push.a.d), OSETSDKProtected.getString2(3371), OSETSDKProtected.getString2(3372), OSETSDKProtected.getString2(3373), OSETSDKProtected.getString2(3374), OSETSDKProtected.getString2(3375), OSETSDKProtected.getString2(3376), OSETSDKProtected.getString2(3377), OSETSDKProtected.getString2(3378), OSETSDKProtected.getString2(3379), OSETSDKProtected.getString2(3368), OSETSDKProtected.getString2(3369)};
        c = new int[]{20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};
        d = new String[]{OSETSDKProtected.getString2(3382), OSETSDKProtected.getString2(3383), OSETSDKProtected.getString2(3384), OSETSDKProtected.getString2(3385), OSETSDKProtected.getString2(3386), OSETSDKProtected.getString2(3387), OSETSDKProtected.getString2(3388), OSETSDKProtected.getString2(3389), OSETSDKProtected.getString2(3390), OSETSDKProtected.getString2(3391), OSETSDKProtected.getString2(3380), OSETSDKProtected.getString2(3381)};
    }

    private static native long a();

    public static native long a(long j, int i);

    public static native long a(long j, long j2, int i);

    public static native boolean a(long j);

    private static native long b(long j, int i);
}
