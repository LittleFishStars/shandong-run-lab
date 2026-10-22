package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public String f6607a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public Boolean f32442a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Integer f6606a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Thread.UncaughtExceptionHandler f6608a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public ThreadFactory f6609a = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Boolean f32443a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Integer f6610a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f6611a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ThreadFactory f6612a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicLong f6613a;
        public final /* synthetic */ String f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f6612a = threadFactory;
            this.f = str;
            this.f6613a = atomicLong;
            this.f32443a = bool;
            this.f6610a = num;
            this.f6611a = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f6612a.newThread(runnable);
            String str = this.f;
            if (str != null) {
                AtomicLong atomicLong = this.f6613a;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(q.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f32443a;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f6610a;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6611a;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(q qVar) {
        String str = qVar.f6607a;
        Boolean bool = qVar.f32442a;
        Integer num = qVar.f6606a;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = qVar.f6608a;
        ThreadFactory threadFactoryDefaultThreadFactory = qVar.f6609a;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    @CheckReturnValue
    public ThreadFactory b() {
        return c(this);
    }

    public q e(boolean z) {
        this.f32442a = Boolean.valueOf(z);
        return this;
    }

    public q f(String str) {
        d(str, 0);
        this.f6607a = str;
        return this;
    }

    public q g(int i) {
        com.google.common.base.i.m(i >= 1, "Thread priority (%s) must be >= %s", i, 1);
        com.google.common.base.i.m(i <= 10, "Thread priority (%s) must be <= %s", i, 10);
        this.f6606a = Integer.valueOf(i);
        return this;
    }

    public q h(ThreadFactory threadFactory) {
        this.f6609a = (ThreadFactory) com.google.common.base.i.E(threadFactory);
        return this;
    }

    public q i(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f6608a = (Thread.UncaughtExceptionHandler) com.google.common.base.i.E(uncaughtExceptionHandler);
        return this;
    }
}
