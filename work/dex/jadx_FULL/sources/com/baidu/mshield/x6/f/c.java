package com.baidu.mshield.x6.f;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f26768a;
    public static Handler b;

    public c() {
        super("BackgroundThread", 10);
    }

    public static void a() {
        if (f26768a == null) {
            f26768a = new c();
            f26768a.start();
            b = new Handler(f26768a.getLooper());
        }
    }

    public static Handler b() {
        Handler handler;
        try {
            synchronized (c.class) {
                a();
                handler = b;
            }
            return handler;
        } catch (Throwable th) {
            f.b(th);
            return b;
        }
    }
}
