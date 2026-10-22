package com.beizi.fusion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f27854a = new AtomicBoolean();
    private static volatile v3 b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;

    private v3() {
        if (f27854a.get()) {
            return;
        }
        d();
    }

    public static v3 b() {
        if (b == null) {
            synchronized (v3.class) {
                if (b == null) {
                    b = new v3();
                }
            }
        }
        return b;
    }

    public static void d() {
        AtomicBoolean atomicBoolean = f27854a;
        if (atomicBoolean.get()) {
            return;
        }
        c = m4.a();
        d = m4.b();
        e = m4.d();
        f = m4.c();
        atomicBoolean.set(true);
    }

    public ExecutorService a() {
        if (c == null) {
            c = m4.a();
        }
        return c;
    }

    public ExecutorService c() {
        if (d == null) {
            d = m4.b();
        }
        return d;
    }

    public ExecutorService e() {
        if (f == null) {
            f = m4.c();
        }
        return f;
    }

    public ExecutorService f() {
        if (e == null) {
            e = m4.d();
        }
        return e;
    }
}
