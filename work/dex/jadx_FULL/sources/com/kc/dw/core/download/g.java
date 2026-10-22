package com.kc.dw.core.download;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {
    public static final TimeUnit b = TimeUnit.HOURS;
    public static final BlockingQueue<Runnable> c = new LinkedBlockingQueue(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f39250a;

    public ThreadPoolExecutor a() {
        if (this.f39250a == null) {
            synchronized (g.class) {
                try {
                    if (this.f39250a == null) {
                        this.f39250a = new ThreadPoolExecutor(3, 5, 1L, b, c, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f39250a;
    }
}
