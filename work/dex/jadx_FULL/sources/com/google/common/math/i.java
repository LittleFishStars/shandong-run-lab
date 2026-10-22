package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f6386a = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f32221a = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double b = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double c = Double.NaN;
    public double d = Double.NaN;

    public static double i(double d, double d2) {
        if (Doubles.n(d)) {
            return d2;
        }
        if (Doubles.n(d2) || d == d2) {
            return d;
        }
        return Double.NaN;
    }

    public void a(double d) {
        long j = this.f6386a;
        if (j == 0) {
            this.f6386a = 1L;
            this.f32221a = d;
            this.c = d;
            this.d = d;
            if (Doubles.n(d)) {
                return;
            }
            this.b = Double.NaN;
            return;
        }
        this.f6386a = j + 1;
        if (Doubles.n(d) && Doubles.n(this.f32221a)) {
            double d2 = this.f32221a;
            double d3 = d - d2;
            double d4 = d2 + (d3 / this.f6386a);
            this.f32221a = d4;
            this.b += d3 * (d - d4);
        } else {
            this.f32221a = i(this.f32221a, d);
            this.b = Double.NaN;
        }
        this.c = Math.min(this.c, d);
        this.d = Math.max(this.d, d);
    }

    public void b(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        m(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
    }

    public void c(i iVar) {
        if (iVar.j() == 0) {
            return;
        }
        m(iVar.j(), iVar.l(), iVar.u(), iVar.n(), iVar.k());
    }

    public void d(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void e(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void f(double... dArr) {
        for (double d : dArr) {
            a(d);
        }
    }

    public void g(int... iArr) {
        for (int i : iArr) {
            a(i);
        }
    }

    public void h(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public long j() {
        return this.f6386a;
    }

    public double k() {
        com.google.common.base.i.g0(this.f6386a != 0);
        return this.d;
    }

    public double l() {
        com.google.common.base.i.g0(this.f6386a != 0);
        return this.f32221a;
    }

    public final void m(long j, double d, double d2, double d3, double d4) {
        long j2 = this.f6386a;
        if (j2 == 0) {
            this.f6386a = j;
            this.f32221a = d;
            this.b = d2;
            this.c = d3;
            this.d = d4;
            return;
        }
        this.f6386a = j2 + j;
        if (Doubles.n(this.f32221a) && Doubles.n(d)) {
            double d5 = this.f32221a;
            double d6 = d - d5;
            double d7 = j;
            double d8 = d5 + ((d6 * d7) / this.f6386a);
            this.f32221a = d8;
            this.b += d2 + (d6 * (d - d8) * d7);
        } else {
            this.f32221a = i(this.f32221a, d);
            this.b = Double.NaN;
        }
        this.c = Math.min(this.c, d3);
        this.d = Math.max(this.d, d4);
    }

    public double n() {
        com.google.common.base.i.g0(this.f6386a != 0);
        return this.c;
    }

    public final double o() {
        return Math.sqrt(p());
    }

    public final double p() {
        com.google.common.base.i.g0(this.f6386a != 0);
        if (Double.isNaN(this.b)) {
            return Double.NaN;
        }
        return this.f6386a == 1 ? AudioStats.AUDIO_AMPLITUDE_NONE : d.b(this.b) / this.f6386a;
    }

    public final double q() {
        return Math.sqrt(r());
    }

    public final double r() {
        com.google.common.base.i.g0(this.f6386a > 1);
        if (Double.isNaN(this.b)) {
            return Double.NaN;
        }
        return d.b(this.b) / (this.f6386a - 1);
    }

    public Stats s() {
        return new Stats(this.f6386a, this.f32221a, this.b, this.c, this.d);
    }

    public final double t() {
        return this.f32221a * this.f6386a;
    }

    public double u() {
        return this.b;
    }
}
