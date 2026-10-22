package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f32212a = -2.147483648E9d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final int f6376a = 170;
    public static final double b = 2.147483647E9d;
    public static final double c = -9.223372036854776E18d;
    public static final double d = 9.223372036854776E18d;
    public static final double e = Math.log(2.0d);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final double[] f6377a = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32213a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f32213a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32213a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32213a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32213a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32213a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32213a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32213a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32213a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public static double a(double d2) {
        com.google.common.base.i.d(d.d(d2));
        return d2;
    }

    public static double b(int i) {
        f.e("n", i);
        if (i > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d2 = 1.0d;
        for (int i2 = (i & (-16)) + 1; i2 <= i; i2++) {
            d2 *= (double) i2;
        }
        return d2 * f6377a[i >> 4];
    }

    public static int c(double d2, double d3, double d4) {
        if (d(d2, d3, d4)) {
            return 0;
        }
        if (d2 < d3) {
            return -1;
        }
        if (d2 > d3) {
            return 1;
        }
        return Booleans.d(Double.isNaN(d2), Double.isNaN(d3));
    }

    public static boolean d(double d2, double d3, double d4) {
        f.d("tolerance", d4);
        return Math.copySign(d2 - d3, 1.0d) <= d4 || d2 == d3 || (Double.isNaN(d2) && Double.isNaN(d3));
    }

    @GwtIncompatible
    public static boolean e(double d2) {
        return d.d(d2) && (d2 == AudioStats.AUDIO_AMPLITUDE_NONE || 52 - Long.numberOfTrailingZeros(d.c(d2)) <= Math.getExponent(d2));
    }

    @GwtIncompatible
    public static boolean f(double d2) {
        if (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || !d.d(d2)) {
            return false;
        }
        long jC = d.c(d2);
        return (jC & (jC - 1)) == 0;
    }

    public static double g(double d2) {
        return Math.log(d2) / e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x006b  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @GwtIncompatible
    public static int h(double d2, RoundingMode roundingMode) {
        boolean zF;
        boolean z = false;
        com.google.common.base.i.e(d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d.d(d2), "x must be positive and finite");
        int exponent = Math.getExponent(d2);
        if (!d.e(d2)) {
            return h(d2 * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (a.f32213a[roundingMode.ordinal()]) {
            case 1:
                f.k(f(d2));
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 2:
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 3:
                z = !f(d2);
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 4:
                z = exponent < 0;
                zF = f(d2);
                z &= !zF;
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 5:
                z = exponent >= 0;
                zF = f(d2);
                z &= !zF;
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 6:
            case 7:
            case 8:
                double dG = d.g(d2);
                if (dG * dG > 2.0d) {
                    z = true;
                }
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    @Deprecated
    public static double i(Iterable<? extends Number> iterable) {
        return j(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double j(Iterator<? extends Number> it) {
        com.google.common.base.i.e(it.hasNext(), "Cannot take mean of 0 values");
        double dA = a(it.next().doubleValue());
        long j = 1;
        while (it.hasNext()) {
            j++;
            dA += (a(it.next().doubleValue()) - dA) / j;
        }
        return dA;
    }

    @GwtIncompatible
    @Deprecated
    public static double k(double... dArr) {
        com.google.common.base.i.e(dArr.length > 0, "Cannot take mean of 0 values");
        double dA = a(dArr[0]);
        long j = 1;
        for (int i = 1; i < dArr.length; i++) {
            a(dArr[i]);
            j++;
            dA += (dArr[i] - dA) / j;
        }
        return dA;
    }

    @Deprecated
    public static double l(int... iArr) {
        com.google.common.base.i.e(iArr.length > 0, "Cannot take mean of 0 values");
        long j = 0;
        for (int i : iArr) {
            j += (long) i;
        }
        return j / ((double) iArr.length);
    }

    @Deprecated
    public static double m(long... jArr) {
        com.google.common.base.i.e(jArr.length > 0, "Cannot take mean of 0 values");
        double d2 = jArr[0];
        long j = 1;
        for (int i = 1; i < jArr.length; i++) {
            j++;
            d2 += (jArr[i] - d2) / j;
        }
        return d2;
    }

    @GwtIncompatible
    public static double n(double d2, RoundingMode roundingMode) {
        if (!d.d(d2)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f32213a[roundingMode.ordinal()]) {
            case 1:
                f.k(e(d2));
                return d2;
            case 2:
                return (d2 >= AudioStats.AUDIO_AMPLITUDE_NONE || e(d2)) ? d2 : ((long) d2) - 1;
            case 3:
                return (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || e(d2)) ? d2 : ((long) d2) + 1;
            case 4:
                return d2;
            case 5:
                if (e(d2)) {
                    return d2;
                }
                return ((long) d2) + ((long) (d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : -1));
            case 6:
                return Math.rint(d2);
            case 7:
                double dRint = Math.rint(d2);
                return Math.abs(d2 - dRint) == 0.5d ? d2 + Math.copySign(0.5d, d2) : dRint;
            case 8:
                double dRint2 = Math.rint(d2);
                return Math.abs(d2 - dRint2) == 0.5d ? d2 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger o(double d2, RoundingMode roundingMode) {
        double dN = n(d2, roundingMode);
        if (((-9.223372036854776E18d) - dN < 1.0d) && (dN < 9.223372036854776E18d)) {
            return BigInteger.valueOf((long) dN);
        }
        BigInteger bigIntegerShiftLeft = BigInteger.valueOf(d.c(dN)).shiftLeft(Math.getExponent(dN) - 52);
        return dN < AudioStats.AUDIO_AMPLITUDE_NONE ? bigIntegerShiftLeft.negate() : bigIntegerShiftLeft;
    }

    @GwtIncompatible
    public static int p(double d2, RoundingMode roundingMode) {
        double dN = n(d2, roundingMode);
        f.a((dN > -2.147483649E9d) & (dN < 2.147483648E9d), d2, roundingMode);
        return (int) dN;
    }

    @GwtIncompatible
    public static long q(double d2, RoundingMode roundingMode) {
        double dN = n(d2, roundingMode);
        f.a(((-9.223372036854776E18d) - dN < 1.0d) & (dN < 9.223372036854776E18d), d2, roundingMode);
        return (long) dN;
    }
}
