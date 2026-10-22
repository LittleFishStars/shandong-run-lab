package com.baidu.xclient.gdid.j;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f26835a;
    public static Handler b;

    public b() {
        super("BackgroundThread", 10);
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            c();
            bVar = f26835a;
        }
        return bVar;
    }

    public static Handler b() {
        Handler handler;
        synchronized (b.class) {
            c();
            handler = b;
        }
        return handler;
    }

    public static void c() {
        if (f26835a == null) {
            b bVar = new b();
            f26835a = bVar;
            bVar.start();
            b = new Handler(f26835a.getLooper());
        }
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            b().post(runnable);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
