package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32207a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f32207a = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32207a[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32207a[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32207a[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32207a[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32207a[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32207a[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32207a[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public abstract X a(X x, X x2);

    public final double b(X x, RoundingMode roundingMode) {
        Number numberE;
        double dNextUp;
        com.google.common.base.i.F(x, "x");
        com.google.common.base.i.F(roundingMode, "mode");
        double dC = c(x);
        if (Double.isInfinite(dC)) {
            switch (a.f32207a[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return ((double) d(x)) * Double.MAX_VALUE;
                case 5:
                    return dC == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return dC == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    return dC;
                case 8:
                    String strValueOf = String.valueOf(x);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 44);
                    sb.append(strValueOf);
                    sb.append(" cannot be represented precisely as a double");
                    throw new ArithmeticException(sb.toString());
            }
        }
        Number numberE2 = e(dC, RoundingMode.UNNECESSARY);
        int iCompareTo = ((Comparable) x).compareTo(numberE2);
        int[] iArr = a.f32207a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (d(x) >= 0) {
                    return iCompareTo >= 0 ? dC : d.f(dC);
                }
                return iCompareTo <= 0 ? dC : Math.nextUp(dC);
            case 2:
            case 3:
            case 4:
                if (iCompareTo >= 0) {
                    dNextUp = Math.nextUp(dC);
                    if (dNextUp == Double.POSITIVE_INFINITY) {
                        return dC;
                    }
                    numberE = e(dNextUp, RoundingMode.CEILING);
                } else {
                    double dF = d.f(dC);
                    if (dF == Double.NEGATIVE_INFINITY) {
                        return dC;
                    }
                    Number numberE3 = e(dF, RoundingMode.FLOOR);
                    numberE = numberE2;
                    numberE2 = numberE3;
                    dNextUp = dC;
                    dC = dF;
                }
                int iCompareTo2 = ((Comparable) a(x, numberE2)).compareTo(a(numberE, x));
                if (iCompareTo2 < 0) {
                    return dC;
                }
                if (iCompareTo2 > 0) {
                    return dNextUp;
                }
                int i = iArr[roundingMode.ordinal()];
                if (i == 2) {
                    return (Double.doubleToRawLongBits(dC) & 1) == 0 ? dC : dNextUp;
                }
                if (i == 3) {
                    return d(x) >= 0 ? dC : dNextUp;
                }
                if (i == 4) {
                    return d(x) >= 0 ? dNextUp : dC;
                }
                throw new AssertionError("impossible");
            case 5:
                return iCompareTo >= 0 ? dC : d.f(dC);
            case 6:
                return iCompareTo <= 0 ? dC : Math.nextUp(dC);
            case 7:
                if (d(x) >= 0) {
                    return iCompareTo <= 0 ? dC : Math.nextUp(dC);
                }
                return iCompareTo >= 0 ? dC : d.f(dC);
            case 8:
                f.k(iCompareTo == 0);
                return dC;
            default:
                throw new AssertionError("impossible");
        }
    }

    public abstract double c(X x);

    public abstract int d(X x);

    public abstract X e(double d, RoundingMode roundingMode);
}
