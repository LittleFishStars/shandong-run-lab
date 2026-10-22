package com.kc.openset.a;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f39593a;
    private Thread.UncaughtExceptionHandler b;
    private final List<String> c = new ArrayList();
    private final AtomicBoolean d = new AtomicBoolean(false);
    private int e = 0;
    private final AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.kc.openset.a.a$a, reason: collision with other inner class name */
    @Keep
    public class C1102a implements ThreadUtils.UICallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39594a;

        static {
            OSETSDKProtected.interface11(3683);
        }

        public C1102a(a aVar) {
            this.f39594a = aVar;
        }

        @Override // com.kc.openset.util.ThreadUtils.UICallBack
        public native void onUIThread();
    }

    static {
        OSETSDKProtected.interface11(3684);
    }

    private a() {
    }

    public static native a a();

    private native void c();

    public native void b();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public native void uncaughtException(Thread thread, Throwable th);
}
