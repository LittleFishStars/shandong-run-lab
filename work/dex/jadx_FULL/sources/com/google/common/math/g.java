package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final i f6384a = new i();
    public final i b = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f32217a = AudioStats.AUDIO_AMPLITUDE_NONE;

    public static double d(double d) {
        return Doubles.f(d, -1.0d, 1.0d);
    }

    public void a(double d, double d2) {
        this.f6384a.a(d);
        if (!Doubles.n(d) || !Doubles.n(d2)) {
            this.f32217a = Double.NaN;
        } else if (this.f6384a.j() > 1) {
            this.f32217a += (d - this.f6384a.l()) * (d2 - this.b.l());
        }
        this.b.a(d2);
    }

    public void b(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.f6384a.b(pairedStats.xStats());
        if (this.b.j() == 0) {
            this.f32217a = pairedStats.sumOfProductsOfDeltas();
        } else {
            this.f32217a += pairedStats.sumOfProductsOfDeltas() + ((pairedStats.xStats().mean() - this.f6384a.l()) * (pairedStats.yStats().mean() - this.b.l()) * pairedStats.count());
        }
        this.b.b(pairedStats.yStats());
    }

    public long c() {
        return this.f6384a.j();
    }

    public final double e(double d) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return d;
        }
        return Double.MIN_VALUE;
    }

    public final LinearTransformation f() {
        com.google.common.base.i.g0(c() > 1);
        if (Double.isNaN(this.f32217a)) {
            return LinearTransformation.a();
        }
        double dU = this.f6384a.u();
        if (dU > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return this.b.u() > AudioStats.AUDIO_AMPLITUDE_NONE ? LinearTransformation.f(this.f6384a.l(), this.b.l()).b(this.f32217a / dU) : LinearTransformation.b(this.b.l());
        }
        com.google.common.base.i.g0(this.b.u() > AudioStats.AUDIO_AMPLITUDE_NONE);
        return LinearTransformation.i(this.f6384a.l());
    }

    public final double g() {
        com.google.common.base.i.g0(c() > 1);
        if (Double.isNaN(this.f32217a)) {
            return Double.NaN;
        }
        double dU = this.f6384a.u();
        double dU2 = this.b.u();
        com.google.common.base.i.g0(dU > AudioStats.AUDIO_AMPLITUDE_NONE);
        com.google.common.base.i.g0(dU2 > AudioStats.AUDIO_AMPLITUDE_NONE);
        return d(this.f32217a / Math.sqrt(e(dU * dU2)));
    }

    public double h() {
        com.google.common.base.i.g0(c() != 0);
        return this.f32217a / c();
    }

    public final double i() {
        com.google.common.base.i.g0(c() > 1);
        return this.f32217a / (c() - 1);
    }

    public PairedStats j() {
        return new PairedStats(this.f6384a.s(), this.b.s(), this.f32217a);
    }

    public Stats k() {
        return this.f6384a.s();
    }

    public Stats l() {
        return this.b.s();
    }
}
