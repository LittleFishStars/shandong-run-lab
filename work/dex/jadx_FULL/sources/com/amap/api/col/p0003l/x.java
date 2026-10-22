package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class x implements ThreadFactory {
    public static final int N;
    public static final int O;
    public static final int P;
    public final int K;
    public final int L;
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f26062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f1115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Thread.UncaughtExceptionHandler f1116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BlockingQueue<Runnable> f1117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ThreadFactory f1118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicLong f1119a;
    public final String f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f1120a;

        public a(Runnable runnable) {
            this.f1120a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f1120a.run();
            } catch (Throwable unused) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Boolean f1121a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Integer f1122a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1123a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Thread.UncaughtExceptionHandler f1124a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public BlockingQueue<Runnable> f1125a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ThreadFactory f1126a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26064a = x.O;
        public int b = x.P;
        public int c = 30;

        public final b a() {
            this.f26064a = 1;
            return this;
        }

        public final b b(int i) {
            if (this.f26064a <= 0) {
                throw new NullPointerException("corePoolSize  must > 0!");
            }
            this.b = i;
            return this;
        }

        public final b c(String str) {
            if (str == null) {
                throw new NullPointerException("Naming pattern must not be null!");
            }
            this.f1123a = str;
            return this;
        }

        public final b d(BlockingQueue<Runnable> blockingQueue) {
            this.f1125a = blockingQueue;
            return this;
        }

        public final x g() {
            x xVar = new x(this, (byte) 0);
            i();
            return xVar;
        }

        public final void i() {
            this.f1126a = null;
            this.f1124a = null;
            this.f1123a = null;
            this.f1122a = null;
            this.f1121a = null;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        N = iAvailableProcessors;
        O = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        P = (iAvailableProcessors * 2) + 1;
    }

    public /* synthetic */ x(b bVar, byte b2) {
        this(bVar);
    }

    public final int a() {
        return this.K;
    }

    public final int b() {
        return this.L;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f1117a;
    }

    public final int d() {
        return this.M;
    }

    public final ThreadFactory g() {
        return this.f1118a;
    }

    public final String h() {
        return this.f;
    }

    public final Boolean i() {
        return this.f26062a;
    }

    public final Integer j() {
        return this.f1115a;
    }

    public final Thread.UncaughtExceptionHandler k() {
        return this.f1116a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new a(runnable);
        Thread threadNewThread = g().newThread(runnable);
        if (h() != null) {
            threadNewThread.setName(String.format(h() + "-%d", Long.valueOf(this.f1119a.incrementAndGet())));
        }
        if (k() != null) {
            threadNewThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            threadNewThread.setPriority(j().intValue());
        }
        if (i() != null) {
            threadNewThread.setDaemon(i().booleanValue());
        }
        return threadNewThread;
    }

    public x(b bVar) {
        if (bVar.f1126a == null) {
            this.f1118a = Executors.defaultThreadFactory();
        } else {
            this.f1118a = bVar.f1126a;
        }
        int i = bVar.f26064a;
        this.K = i;
        int i2 = P;
        this.L = i2;
        if (i2 < i) {
            throw new NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.M = bVar.c;
        if (bVar.f1125a == null) {
            this.f1117a = new LinkedBlockingQueue(256);
        } else {
            this.f1117a = bVar.f1125a;
        }
        if (TextUtils.isEmpty(bVar.f1123a)) {
            this.f = "amap-threadpool";
        } else {
            this.f = bVar.f1123a;
        }
        this.f1115a = bVar.f1122a;
        this.f26062a = bVar.f1121a;
        this.f1116a = bVar.f1124a;
        this.f1119a = new AtomicLong();
    }
}
