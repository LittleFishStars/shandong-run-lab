package com.kc.openset.sdk.dsp.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f39929a;

    @Keep
    public class a extends ThreadLocal<SimpleDateFormat> {
        static {
            OSETSDKProtected.interface11(4903);
        }

        public native SimpleDateFormat a();

        @Override // java.lang.ThreadLocal
        public native /* bridge */ /* synthetic */ SimpleDateFormat initialValue();
    }

    static {
        OSETSDKProtected.interface11(4904);
        f39929a = new a();
    }

    public static native long a();

    public static native long a(long j, int i);
}
