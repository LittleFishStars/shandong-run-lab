package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public abstract class LinearTransformation {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f32201a;
        public final double b;

        public LinearTransformation a(double d, double d2) {
            com.google.common.base.i.d(com.google.common.math.d.d(d) && com.google.common.math.d.d(d2));
            double d3 = this.f32201a;
            if (d != d3) {
                return b((d2 - this.b) / (d - d3));
            }
            com.google.common.base.i.d(d2 != this.b);
            return new e(this.f32201a);
        }

        public LinearTransformation b(double d) {
            com.google.common.base.i.d(!Double.isNaN(d));
            return com.google.common.math.d.d(d) ? new d(d, this.b - (this.f32201a * d)) : new e(this.f32201a);
        }

        public b(double d, double d2) {
            this.f32201a = d;
            this.b = d2;
        }
    }

    public static final class c extends LinearTransformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32202a = new c();

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation c() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean d() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean e() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double g() {
            return Double.NaN;
        }

        @Override // com.google.common.math.LinearTransformation
        public double h(double d) {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }
    }

    public static LinearTransformation a() {
        return c.f32202a;
    }

    public static LinearTransformation b(double d2) {
        com.google.common.base.i.d(com.google.common.math.d.d(d2));
        return new d(AudioStats.AUDIO_AMPLITUDE_NONE, d2);
    }

    public static b f(double d2, double d3) {
        com.google.common.base.i.d(com.google.common.math.d.d(d2) && com.google.common.math.d.d(d3));
        return new b(d2, d3);
    }

    public static LinearTransformation i(double d2) {
        com.google.common.base.i.d(com.google.common.math.d.d(d2));
        return new e(d2);
    }

    public abstract LinearTransformation c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract double g();

    public abstract double h(double d2);

    public static final class e extends LinearTransformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f32204a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        @LazyInit
        public LinearTransformation f6365a;

        public e(double d) {
            this.f32204a = d;
            this.f6365a = null;
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation c() {
            LinearTransformation linearTransformation = this.f6365a;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation linearTransformationJ = j();
            this.f6365a = linearTransformationJ;
            return linearTransformationJ;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean d() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean e() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double g() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.math.LinearTransformation
        public double h(double d) {
            throw new IllegalStateException();
        }

        public final LinearTransformation j() {
            return new d(AudioStats.AUDIO_AMPLITUDE_NONE, this.f32204a, this);
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f32204a));
        }

        public e(double d, LinearTransformation linearTransformation) {
            this.f32204a = d;
            this.f6365a = linearTransformation;
        }
    }

    public static final class d extends LinearTransformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f32203a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        @LazyInit
        public LinearTransformation f6364a;
        public final double b;

        public d(double d, double d2) {
            this.f32203a = d;
            this.b = d2;
            this.f6364a = null;
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation c() {
            LinearTransformation linearTransformation = this.f6364a;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation linearTransformationJ = j();
            this.f6364a = linearTransformationJ;
            return linearTransformationJ;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean d() {
            return this.f32203a == AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean e() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double g() {
            return this.f32203a;
        }

        @Override // com.google.common.math.LinearTransformation
        public double h(double d) {
            return (d * this.f32203a) + this.b;
        }

        public final LinearTransformation j() {
            double d = this.f32203a;
            return d != AudioStats.AUDIO_AMPLITUDE_NONE ? new d(1.0d / d, (this.b * (-1.0d)) / d, this) : new e(this.b, this);
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f32203a), Double.valueOf(this.b));
        }

        public d(double d, double d2, LinearTransformation linearTransformation) {
            this.f32203a = d;
            this.b = d2;
            this.f6364a = linearTransformation;
        }
    }
}
