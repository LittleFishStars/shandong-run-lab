package com.google.common.util.concurrent;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f32391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f6567a;
    public double b;
    public double c;

    public static final class b extends SmoothRateLimiter {
        public final double d;

        public b(RateLimiter.SleepingStopwatch sleepingStopwatch, double d) {
            super(sleepingStopwatch);
            this.d = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double v() {
            return this.c;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void w(double d, double d2) {
            double d3 = this.b;
            double d4 = this.d * d;
            this.b = d4;
            if (d3 == Double.POSITIVE_INFINITY) {
                ((SmoothRateLimiter) this).f32391a = d4;
                return;
            }
            double d5 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (d3 != AudioStats.AUDIO_AMPLITUDE_NONE) {
                d5 = (((SmoothRateLimiter) this).f32391a * d4) / d3;
            }
            ((SmoothRateLimiter) this).f32391a = d5;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long y(double d, double d2) {
            return 0L;
        }
    }

    public static final class c extends SmoothRateLimiter {
        public final long b;
        public double d;
        public double e;
        public double f;

        public c(RateLimiter.SleepingStopwatch sleepingStopwatch, long j, TimeUnit timeUnit, double d) {
            super(sleepingStopwatch);
            this.b = timeUnit.toMicros(j);
            this.f = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double v() {
            return this.b / super.b;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void w(double d, double d2) {
            double d3 = super.b;
            double d4 = this.f * d2;
            long j = this.b;
            double d5 = (j * 0.5d) / d2;
            this.e = d5;
            double d6 = ((j * 2.0d) / (d2 + d4)) + d5;
            super.b = d6;
            this.d = (d4 - d2) / (d6 - d5);
            if (d3 == Double.POSITIVE_INFINITY) {
                ((SmoothRateLimiter) this).f32391a = AudioStats.AUDIO_AMPLITUDE_NONE;
                return;
            }
            if (d3 != AudioStats.AUDIO_AMPLITUDE_NONE) {
                d6 = (((SmoothRateLimiter) this).f32391a * d6) / d3;
            }
            ((SmoothRateLimiter) this).f32391a = d6;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long y(double d, double d2) {
            long jZ;
            double d3 = d - this.e;
            if (d3 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                double dMin = Math.min(d3, d2);
                jZ = (long) (((z(d3) + z(d3 - dMin)) * dMin) / 2.0d);
                d2 -= dMin;
            } else {
                jZ = 0;
            }
            return jZ + ((long) (this.c * d2));
        }

        public final double z(double d) {
            return this.c + (d * this.d);
        }
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double i() {
        return TimeUnit.SECONDS.toMicros(1L) / this.c;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void j(double d, long j) {
        x(j);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d;
        this.c = micros;
        w(d, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long m(long j) {
        return this.f6567a;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long p(int i, long j) {
        x(j);
        long j2 = this.f6567a;
        double d = i;
        double dMin = Math.min(d, this.f32391a);
        this.f6567a = LongMath.x(this.f6567a, y(this.f32391a, dMin) + ((long) ((d - dMin) * this.c)));
        this.f32391a -= dMin;
        return j2;
    }

    public abstract double v();

    public abstract void w(double d, double d2);

    public void x(long j) {
        long j2 = this.f6567a;
        if (j > j2) {
            this.f32391a = Math.min(this.b, this.f32391a + ((j - j2) / v()));
            this.f6567a = j;
        }
    }

    public abstract long y(double d, double d2);

    public SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.f6567a = 0L;
    }
}
