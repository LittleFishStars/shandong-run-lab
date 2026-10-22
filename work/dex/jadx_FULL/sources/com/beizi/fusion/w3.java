package com.beizi.fusion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f27896a = new AtomicBoolean();
    private static volatile w3 b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;
    private static volatile ScheduledThreadPoolExecutor g;

    private w3() {
        if (f27896a.get()) {
            return;
        }
        f();
    }

    public static w3 c() {
        if (b == null) {
            synchronized (w3.class) {
                if (b == null) {
                    b = new w3();
                }
            }
        }
        return b;
    }

    public static void f() {
        AtomicBoolean atomicBoolean = f27896a;
        if (atomicBoolean.get()) {
            return;
        }
        c = n4.b();
        e = n4.c();
        f = n4.d();
        atomicBoolean.set(true);
    }

    public ExecutorService a() {
        if (d == null) {
            d = n4.a();
        }
        return d;
    }

    public ExecutorService b() {
        if (c == null) {
            c = n4.b();
        }
        return c;
    }

    public ScheduledThreadPoolExecutor d() {
        if (g == null) {
            g = n4.e();
        }
        return g;
    }

    public ExecutorService e() {
        if (e == null) {
            e = n4.c();
        }
        return e;
    }

    public ExecutorService g() {
        if (f == null) {
            f = n4.d();
        }
        return f;
    }
}
