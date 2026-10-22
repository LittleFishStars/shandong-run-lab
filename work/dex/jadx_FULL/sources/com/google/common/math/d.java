package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32214a = 52;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f6378a = 4503599627370495L;
    public static final int b = 1023;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f6379b = 9218868437227405312L;
    public static final long c = Long.MIN_VALUE;
    public static final long d = 4503599627370496L;

    @VisibleForTesting
    public static final long e = 4607182418800017408L;

    public static double a(BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        boolean z = true;
        int iBitLength = bigIntegerAbs.bitLength() - 1;
        if (iBitLength < 63) {
            return bigInteger.longValue();
        }
        if (iBitLength > 1023) {
            return ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        }
        int i = (iBitLength - 52) - 1;
        long jLongValue = bigIntegerAbs.shiftRight(i).longValue();
        long j = (jLongValue >> 1) & f6378a;
        if ((jLongValue & 1) == 0 || ((j & 1) == 0 && bigIntegerAbs.getLowestSetBit() >= i)) {
            z = false;
        }
        if (z) {
            j++;
        }
        return Double.longBitsToDouble(((((long) (iBitLength + 1023)) << 52) + j) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
    }

    public static double b(double d2) {
        com.google.common.base.i.d(!Double.isNaN(d2));
        return Math.max(d2, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static long c(double d2) {
        com.google.common.base.i.e(d(d2), "not a normal value");
        int exponent = Math.getExponent(d2);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2) & f6378a;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | d;
    }

    public static boolean d(double d2) {
        return Math.getExponent(d2) <= 1023;
    }

    public static boolean e(double d2) {
        return Math.getExponent(d2) >= -1022;
    }

    public static double f(double d2) {
        return -Math.nextUp(-d2);
    }

    public static double g(double d2) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d2) & f6378a) | e);
    }
}
