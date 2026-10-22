package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class a {

    /* JADX INFO: renamed from: com.google.common.math.a$a, reason: collision with other inner class name */
    public static class C0752a extends ToDoubleRounder<BigDecimal> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0752a f32208a = new C0752a();

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.subtract(bigDecimal2);
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public double c(BigDecimal bigDecimal) {
            return bigDecimal.doubleValue();
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int d(BigDecimal bigDecimal) {
            return bigDecimal.signum();
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public BigDecimal e(double d, RoundingMode roundingMode) {
            return new BigDecimal(d);
        }
    }

    public static double a(BigDecimal bigDecimal, RoundingMode roundingMode) {
        return C0752a.f32208a.b(bigDecimal, roundingMode);
    }
}
