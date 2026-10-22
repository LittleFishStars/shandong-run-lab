package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final int f6374a = 256;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final BigInteger f6375a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f32209a = Math.log(10.0d);
    public static final double b = Math.log(2.0d);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32210a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f32210a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32210a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32210a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32210a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32210a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32210a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32210a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32210a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.common.math.b$b, reason: collision with other inner class name */
    @GwtIncompatible
    public static class C0753b extends ToDoubleRounder<BigInteger> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0753b f32211a = new C0753b();

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger.subtract(bigInteger2);
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public double c(BigInteger bigInteger) {
            return d.a(bigInteger);
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int d(BigInteger bigInteger) {
            return bigInteger.signum();
        }

        @Override // com.google.common.math.ToDoubleRounder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public BigInteger e(double d, RoundingMode roundingMode) {
            return c.o(d, roundingMode);
        }
    }

    public static BigInteger a(int i, int i2) {
        f.e("n", i);
        f.e("k", i2);
        int i3 = 1;
        com.google.common.base.i.m(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = LongMath.f6368a;
        if (i2 < iArr.length && i <= iArr[i2]) {
            return BigInteger.valueOf(LongMath.a(i, i2));
        }
        BigInteger bigIntegerDivide = BigInteger.ONE;
        long j = i;
        int iQ = LongMath.q(j, RoundingMode.CEILING);
        long j2 = 1;
        while (true) {
            int i4 = iQ;
            while (i3 < i2) {
                int i5 = i - i3;
                i3++;
                i4 += iQ;
                if (i4 >= 63) {
                    bigIntegerDivide = bigIntegerDivide.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
                    j = i5;
                    j2 = i3;
                } else {
                    j *= (long) i5;
                    j2 *= (long) i3;
                }
            }
            return bigIntegerDivide.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
        }
    }

    @Beta
    public static BigInteger b(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger c(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger d(int i) {
        f.e("n", i);
        long[] jArr = LongMath.f6373c;
        if (i < jArr.length) {
            return BigInteger.valueOf(jArr[i]);
        }
        ArrayList arrayList = new ArrayList(e.g(e.p(i, RoundingMode.CEILING) * i, 64, RoundingMode.CEILING));
        int length = jArr.length;
        long j = jArr[length - 1];
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j2 = j >> iNumberOfTrailingZeros;
        int iQ = LongMath.q(j2, RoundingMode.FLOOR) + 1;
        long j3 = length;
        int iQ2 = LongMath.q(j3, RoundingMode.FLOOR) + 1;
        int i2 = 1 << (iQ2 - 1);
        while (j3 <= i) {
            if ((j3 & ((long) i2)) != 0) {
                i2 <<= 1;
                iQ2++;
            }
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> iNumberOfTrailingZeros2;
            iNumberOfTrailingZeros += iNumberOfTrailingZeros2;
            if ((iQ2 - iNumberOfTrailingZeros2) + iQ >= 64) {
                arrayList.add(BigInteger.valueOf(j2));
                j2 = 1;
            }
            j2 *= j4;
            iQ = LongMath.q(j2, RoundingMode.FLOOR) + 1;
            j3++;
        }
        if (j2 > 1) {
            arrayList.add(BigInteger.valueOf(j2));
        }
        return h(arrayList).shiftLeft(iNumberOfTrailingZeros);
    }

    @GwtIncompatible
    public static boolean e(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    @Beta
    public static BigInteger f(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean g(BigInteger bigInteger) {
        com.google.common.base.i.E(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    public static BigInteger h(List<BigInteger> list) {
        return i(list, 0, list.size());
    }

    public static BigInteger i(List<BigInteger> list, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return BigInteger.ONE;
        }
        if (i3 == 1) {
            return list.get(i);
        }
        if (i3 == 2) {
            return list.get(i).multiply(list.get(i + 1));
        }
        if (i3 == 3) {
            return list.get(i).multiply(list.get(i + 1)).multiply(list.get(i + 2));
        }
        int i4 = (i2 + i) >>> 1;
        return i(list, i, i4).multiply(i(list, i4, i2));
    }

    @GwtIncompatible
    public static int j(BigInteger bigInteger, RoundingMode roundingMode) {
        int iCompareTo;
        f.j("x", bigInteger);
        if (e(bigInteger)) {
            return LongMath.o(bigInteger.longValue(), roundingMode);
        }
        int iK = (int) ((((double) k(bigInteger, RoundingMode.FLOOR)) * b) / f32209a);
        BigInteger bigIntegerPow = BigInteger.TEN.pow(iK);
        int iCompareTo2 = bigIntegerPow.compareTo(bigInteger);
        if (iCompareTo2 > 0) {
            do {
                iK--;
                bigIntegerPow = bigIntegerPow.divide(BigInteger.TEN);
                iCompareTo = bigIntegerPow.compareTo(bigInteger);
            } while (iCompareTo > 0);
        } else {
            BigInteger bigIntegerMultiply = BigInteger.TEN.multiply(bigIntegerPow);
            int i = iCompareTo2;
            int iCompareTo3 = bigIntegerMultiply.compareTo(bigInteger);
            while (iCompareTo3 <= 0) {
                iK++;
                BigInteger bigIntegerMultiply2 = BigInteger.TEN.multiply(bigIntegerMultiply);
                int iCompareTo4 = bigIntegerMultiply2.compareTo(bigInteger);
                BigInteger bigInteger2 = bigIntegerMultiply;
                bigIntegerMultiply = bigIntegerMultiply2;
                bigIntegerPow = bigInteger2;
                i = iCompareTo3;
                iCompareTo3 = iCompareTo4;
            }
            iCompareTo = i;
        }
        switch (a.f32210a[roundingMode.ordinal()]) {
            case 1:
                f.k(iCompareTo == 0);
            case 2:
            case 3:
                return iK;
            case 4:
            case 5:
                return bigIntegerPow.equals(bigInteger) ? iK : iK + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(bigIntegerPow.pow(2).multiply(BigInteger.TEN)) <= 0 ? iK : iK + 1;
            default:
                throw new AssertionError();
        }
    }

    public static int k(BigInteger bigInteger, RoundingMode roundingMode) {
        f.j("x", (BigInteger) com.google.common.base.i.E(bigInteger));
        int iBitLength = bigInteger.bitLength() - 1;
        switch (a.f32210a[roundingMode.ordinal()]) {
            case 1:
                f.k(g(bigInteger));
            case 2:
            case 3:
                return iBitLength;
            case 4:
            case 5:
                return g(bigInteger) ? iBitLength : iBitLength + 1;
            case 6:
            case 7:
            case 8:
                if (iBitLength < 256) {
                    return bigInteger.compareTo(f6375a.shiftRight(256 - iBitLength)) <= 0 ? iBitLength : iBitLength + 1;
                }
                return bigInteger.pow(2).bitLength() + (-1) < (iBitLength * 2) + 1 ? iBitLength : iBitLength + 1;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static double l(BigInteger bigInteger, RoundingMode roundingMode) {
        return C0753b.f32211a.b(bigInteger, roundingMode);
    }

    @GwtIncompatible
    public static BigInteger m(BigInteger bigInteger, RoundingMode roundingMode) {
        f.g("x", bigInteger);
        if (e(bigInteger)) {
            return BigInteger.valueOf(LongMath.B(bigInteger.longValue(), roundingMode));
        }
        BigInteger bigIntegerO = o(bigInteger);
        switch (a.f32210a[roundingMode.ordinal()]) {
            case 1:
                f.k(bigIntegerO.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return bigIntegerO;
            case 4:
            case 5:
                int iIntValue = bigIntegerO.intValue();
                return iIntValue * iIntValue == bigInteger.intValue() && bigIntegerO.pow(2).equals(bigInteger) ? bigIntegerO : bigIntegerO.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return bigIntegerO.pow(2).add(bigIntegerO).compareTo(bigInteger) >= 0 ? bigIntegerO : bigIntegerO.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger n(BigInteger bigInteger) {
        return c.o(Math.sqrt(d.a(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @GwtIncompatible
    public static BigInteger o(BigInteger bigInteger) {
        BigInteger bigIntegerShiftLeft;
        int iK = k(bigInteger, RoundingMode.FLOOR);
        if (iK < 1023) {
            bigIntegerShiftLeft = n(bigInteger);
        } else {
            int i = (iK - 52) & (-2);
            bigIntegerShiftLeft = n(bigInteger.shiftRight(i)).shiftLeft(i >> 1);
        }
        BigInteger bigIntegerShiftRight = bigIntegerShiftLeft.add(bigInteger.divide(bigIntegerShiftLeft)).shiftRight(1);
        if (bigIntegerShiftLeft.equals(bigIntegerShiftRight)) {
            return bigIntegerShiftLeft;
        }
        while (true) {
            BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight.add(bigInteger.divide(bigIntegerShiftRight)).shiftRight(1);
            if (bigIntegerShiftRight2.compareTo(bigIntegerShiftRight) >= 0) {
                return bigIntegerShiftRight;
            }
            bigIntegerShiftRight = bigIntegerShiftRight2;
        }
    }
}
