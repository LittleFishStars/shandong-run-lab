package com.kc.bw.okhttp.utils;

import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMCommonThreadFactory implements ThreadFactory {
    public static final String TAG = dexg.dexa("XN`DpnnpoUisfbeGbdupsz");
    public final ThreadGroup group;
    public final String namePrefix;
    public final AtomicInteger threadNumber = new AtomicInteger(1);

    @Keep
    public static class WmUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Log.e(dexg.dexa("XN`DpnnpoUisfbeGbdupsz"), dexg.dexa("voiboemfe!fydfqujpo!jo!uisfbe!") + thread.getName() + dexg.dexa(c49.f40900a) + (th != null ? Log.getStackTraceString(th) : null));
        }
    }

    public WMCommonThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = ((str == null || str.isEmpty()) ? dexg.dexa("XN.Uisfbe") : str) + dexg.dexa("$");
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        thread.setUncaughtExceptionHandler(new WmUncaughtExceptionHandler());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
