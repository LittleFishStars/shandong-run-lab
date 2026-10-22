package com.ipd.dsp.internal.y1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.c2.k;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f38614a;
    public final AtomicInteger b = new AtomicInteger(1);
    public final String c;

    public a(@NonNull String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f38614a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.c = (TextUtils.isEmpty(str) ? "IPDDSP" : str) + "-t-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f38614a, runnable, this.c + this.b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.zj.adlib.ida
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                k.b("NTF", String.format("[%s] onUncaughtException", thread2.getName()), th);
            }
        });
        return thread;
    }
}
