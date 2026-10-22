package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.q13;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JobScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30012a = "queueTime";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final JobRunnable f1677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f1681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f1680a = new a();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f1683b = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public q13 f1679a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public boolean f1682a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public JobState f1678a = JobState.IDLE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public long f1676a = 0;

    @VisibleForTesting
    @GuardedBy("this")
    public long b = 0;

    public interface JobRunnable {
        void a(q13 q13Var, boolean z);
    }

    @VisibleForTesting
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.d();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.j();
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30015a;

        static {
            int[] iArr = new int[JobState.values().length];
            f30015a = iArr;
            try {
                iArr[JobState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30015a[JobState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30015a[JobState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30015a[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ScheduledExecutorService f30016a;

        public static ScheduledExecutorService a() {
            if (f30016a == null) {
                f30016a = Executors.newSingleThreadScheduledExecutor();
            }
            return f30016a;
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.f1681a = executor;
        this.f1677a = jobRunnable;
        this.f1675a = i;
    }

    public static boolean i(q13 q13Var, boolean z) {
        return z || q13.H(q13Var);
    }

    public void c() {
        q13 q13Var;
        synchronized (this) {
            q13Var = this.f1679a;
            this.f1679a = null;
            this.f1682a = false;
        }
        q13.j(q13Var);
    }

    public final void d() {
        q13 q13Var;
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            q13Var = this.f1679a;
            z = this.f1682a;
            this.f1679a = null;
            this.f1682a = false;
            this.f1678a = JobState.RUNNING;
            this.b = jUptimeMillis;
        }
        try {
            if (i(q13Var, z)) {
                this.f1677a.a(q13Var, z);
            }
        } finally {
            q13.j(q13Var);
            g();
        }
    }

    public final void e(long j) {
        if (j > 0) {
            d.a().schedule(this.f1683b, j, TimeUnit.MILLISECONDS);
        } else {
            this.f1683b.run();
        }
    }

    public synchronized long f() {
        return this.b - this.f1676a;
    }

    public final void g() {
        long jMax;
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.f1678a == JobState.RUNNING_AND_PENDING) {
                jMax = Math.max(this.b + ((long) this.f1675a), jUptimeMillis);
                this.f1676a = jUptimeMillis;
                this.f1678a = JobState.QUEUED;
                z = true;
            } else {
                this.f1678a = JobState.IDLE;
                jMax = 0;
                z = false;
            }
        }
        if (z) {
            e(jMax - jUptimeMillis);
        }
    }

    public boolean h() {
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (!i(this.f1679a, this.f1682a)) {
                return false;
            }
            int i = c.f30015a[this.f1678a.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    this.f1678a = JobState.RUNNING_AND_PENDING;
                }
                jMax = 0;
            } else {
                jMax = Math.max(this.b + ((long) this.f1675a), jUptimeMillis);
                this.f1676a = jUptimeMillis;
                this.f1678a = JobState.QUEUED;
                z = true;
            }
            if (z) {
                e(jMax - jUptimeMillis);
            }
            return true;
        }
    }

    public final void j() {
        this.f1681a.execute(this.f1680a);
    }

    public boolean k(q13 q13Var, boolean z) {
        q13 q13Var2;
        if (!i(q13Var, z)) {
            return false;
        }
        synchronized (this) {
            q13Var2 = this.f1679a;
            this.f1679a = q13.h(q13Var);
            this.f1682a = z;
        }
        q13.j(q13Var2);
        return true;
    }
}
