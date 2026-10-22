package com.baidu.mshield.x6.f.m;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f26773a = new AtomicInteger(1);
    public final AtomicInteger b;
    public String c;
    public int d;

    public b() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.c + this.b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.d;
        if (i != 5) {
            thread.setPriority(i);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public b(int i) {
        this.b = new AtomicInteger(1);
        this.c = "fin-" + f26773a.getAndIncrement() + "-thread-";
        this.d = i;
    }
}
