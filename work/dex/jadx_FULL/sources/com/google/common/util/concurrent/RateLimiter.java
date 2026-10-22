package com.google.common.util.concurrent;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class RateLimiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SleepingStopwatch f32380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile Object f6548a;

    public static abstract class SleepingStopwatch {

        public class a extends SleepingStopwatch {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.google.common.base.k f32381a = com.google.common.base.k.c();

            @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
            public long readMicros() {
                return this.f32381a.g(TimeUnit.MICROSECONDS);
            }

            @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
            public void sleepMicrosUninterruptibly(long j) {
                if (j > 0) {
                    s.k(j, TimeUnit.MICROSECONDS);
                }
            }
        }

        public static SleepingStopwatch a() {
            return new a();
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long j);
    }

    public RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.f32380a = (SleepingStopwatch) com.google.common.base.i.E(sleepingStopwatch);
    }

    public static void d(int i) {
        com.google.common.base.i.k(i > 0, "Requested permits (%s) must be positive", i);
    }

    public static RateLimiter e(double d) {
        return h(d, SleepingStopwatch.a());
    }

    public static RateLimiter f(double d, long j, TimeUnit timeUnit) {
        com.google.common.base.i.p(j >= 0, "warmupPeriod must not be negative: %s", j);
        return g(d, j, timeUnit, 3.0d, SleepingStopwatch.a());
    }

    @VisibleForTesting
    public static RateLimiter g(double d, long j, TimeUnit timeUnit, double d2, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.c cVar = new SmoothRateLimiter.c(sleepingStopwatch, j, timeUnit, d2);
        cVar.q(d);
        return cVar;
    }

    @VisibleForTesting
    public static RateLimiter h(double d, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.b bVar = new SmoothRateLimiter.b(sleepingStopwatch, 1.0d);
        bVar.q(d);
        return bVar;
    }

    @CanIgnoreReturnValue
    public double a() {
        return b(1);
    }

    @CanIgnoreReturnValue
    public double b(int i) {
        long jN = n(i);
        this.f32380a.sleepMicrosUninterruptibly(jN);
        return (jN * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public final boolean c(long j, long j2) {
        return m(j) - j2 <= j;
    }

    public abstract double i();

    public abstract void j(double d, long j);

    public final double k() {
        double dI;
        synchronized (l()) {
            dI = i();
        }
        return dI;
    }

    public final Object l() {
        Object obj = this.f6548a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f6548a;
                if (obj == null) {
                    obj = new Object();
                    this.f6548a = obj;
                }
            }
        }
        return obj;
    }

    public abstract long m(long j);

    public final long n(int i) {
        long jO;
        d(i);
        synchronized (l()) {
            jO = o(i, this.f32380a.readMicros());
        }
        return jO;
    }

    public final long o(int i, long j) {
        return Math.max(p(i, j) - j, 0L);
    }

    public abstract long p(int i, long j);

    public final void q(double d) {
        com.google.common.base.i.e(d > AudioStats.AUDIO_AMPLITUDE_NONE && !Double.isNaN(d), "rate must be positive");
        synchronized (l()) {
            j(d, this.f32380a.readMicros());
        }
    }

    public boolean r() {
        return t(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean s(int i) {
        return t(i, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean t(int i, long j, TimeUnit timeUnit) {
        long jMax = Math.max(timeUnit.toMicros(j), 0L);
        d(i);
        synchronized (l()) {
            long micros = this.f32380a.readMicros();
            if (!c(micros, jMax)) {
                return false;
            }
            this.f32380a.sleepMicrosUninterruptibly(o(i, micros));
            return true;
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(k()));
    }

    public boolean u(long j, TimeUnit timeUnit) {
        return t(1, j, timeUnit);
    }
}
