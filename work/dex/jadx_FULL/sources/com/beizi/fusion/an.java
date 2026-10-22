package com.beizi.fusion;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class an implements ThreadFactory {
    private static final AtomicInteger e = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f27019a = new AtomicInteger(1);
    private final String b;
    private final int c;
    private final ThreadGroup d;

    public an(int i, String str) {
        this.c = i;
        this.d = a(str);
        this.b = String.format(Locale.ENGLISH, "adScope-%s-%d-thread-", str, Integer.valueOf(e.getAndIncrement()));
    }

    private ThreadGroup a(String str) {
        try {
            return new ThreadGroup(str);
        } catch (SecurityException unused) {
            SecurityManager securityManager = System.getSecurityManager();
            return securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.d, runnable, this.b + this.f27019a.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.c == 1) {
            thread.setPriority(1);
            return thread;
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(3);
            return thread;
        }
        thread.setPriority(5);
        return thread;
    }
}
