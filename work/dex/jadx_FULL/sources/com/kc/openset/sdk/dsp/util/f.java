package com.kc.openset.sdk.dsp.util;

import android.os.Handler;
import android.os.Looper;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f39930a;
    private static final Handler b;
    private static final Runnable c;

    @Keep
    public class a implements Runnable {
        static {
            OSETSDKProtected.interface11(4905);
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        OSETSDKProtected.interface11(4906);
        f39930a = new AtomicBoolean(false);
        b = new Handler(Looper.getMainLooper());
        c = new a();
    }

    public static native /* synthetic */ AtomicBoolean a();

    private static native void b();

    public static native boolean c();
}
