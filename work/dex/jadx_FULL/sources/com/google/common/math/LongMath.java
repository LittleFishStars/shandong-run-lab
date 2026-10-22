package com.google.common.math;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import com.zj.adlib.go6;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class LongMath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32205a = -545925251;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final long f6366a = 4611686018427387904L;

    @VisibleForTesting
    public static final long b = -5402926248376769404L;

    @VisibleForTesting
    public static final long c = 3037000499L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final byte[] f6367a = {19, com.google.common.base.a.u, com.google.common.base.a.u, com.google.common.base.a.u, com.google.common.base.a.u, 17, 17, 17, com.google.common.base.a.r, com.google.common.base.a.r, com.google.common.base.a.r, com.google.common.base.a.q, com.google.common.base.a.q, com.google.common.base.a.q, com.google.common.base.a.q, com.google.common.base.a.p, com.google.common.base.a.p, com.google.common.base.a.p, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GwtIncompatible
    public static final long[] f6369a = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    @GwtIncompatible
    public static final long[] f6372b = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final long[] f6373c = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f6368a = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public static final int[] f6371b = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, go6.g, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long[][] f6370a = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j, long j2, long j3) {
                long j4 = j + j2;
                return j >= j3 - j2 ? j4 - j3 : j4;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int iMin = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.k(j << iMin, j2);
                    i -= iMin;
                } while (i > 0);
                return j;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                long j4 = j >>> 32;
                long j5 = j2 >>> 32;
                long j6 = j & 4294967295L;
                long j7 = j2 & 4294967295L;
                long jTimes2ToThe32Mod = times2ToThe32Mod(j4 * j5, j3) + (j4 * j7);
                if (jTimes2ToThe32Mod < 0) {
                    jTimes2ToThe32Mod = UnsignedLongs.k(jTimes2ToThe32Mod, j3);
                }
                return plusMod(times2ToThe32Mod(jTimes2ToThe32Mod + (j5 * j6), j3), UnsignedLongs.k(j6 * j7, j3), j3);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long jTimes2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long jK = j3 * j4 * 2;
                if (jK < 0) {
                    jK = UnsignedLongs.k(jK, j2);
                }
                return plusMod(times2ToThe32Mod(jTimes2ToThe32Mod + jK, j2), UnsignedLongs.k(j4 * j4, j2), j2);
            }
        };

        private long powMod(long j, long j2, long j3) {
            long jMulMod = 1;
            while (j2 != 0) {
                if ((j2 & 1) != 0) {
                    jMulMod = mulMod(jMulMod, j, j3);
                }
                j = squareMod(j, j3);
                j2 >>= 1;
            }
            return jMulMod;
        }

        public static boolean test(long j, long j2) {
            return (j2 <= LongMath.c ? SMALL : LARGE).testWitness(j, j2);
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2 - 1;
            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> iNumberOfTrailingZeros;
            long j5 = j % j2;
            if (j5 == 0) {
                return true;
            }
            long jPowMod = powMod(j5, j4, j2);
            if (jPowMod == 1) {
                return true;
            }
            int i = 0;
            while (jPowMod != j3) {
                i++;
                if (i == iNumberOfTrailingZeros) {
                    return false;
                }
                jPowMod = squareMod(jPowMod, j2);
            }
            return true;
        }

        public abstract long mulMod(long j, long j2, long j3);

        public abstract long squareMod(long j, long j2);

        /* synthetic */ MillerRabinTester(a aVar) {
            this();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32206a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f32206a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32206a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32206a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32206a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32206a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32206a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32206a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32206a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Beta
    public static long A(long j, long j2) {
        long j3 = j - j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) >= 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long B(long j, RoundingMode roundingMode) {
        f.f("x", j);
        if (i(j)) {
            return e.x((int) j, roundingMode);
        }
        long jSqrt = (long) Math.sqrt(j);
        long j2 = jSqrt * jSqrt;
        switch (a.f32206a[roundingMode.ordinal()]) {
            case 1:
                f.k(j2 == j);
                return jSqrt;
            case 2:
            case 3:
                return j < j2 ? jSqrt - 1 : jSqrt;
            case 4:
            case 5:
                return j > j2 ? jSqrt + 1 : jSqrt;
            case 6:
            case 7:
            case 8:
                long j3 = jSqrt - ((long) (j >= j2 ? 0 : 1));
                return j3 + ((long) n((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    public static long a(int i, int i2) {
        f.e("n", i);
        f.e("k", i2);
        com.google.common.base.i.m(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long jU = 1;
        if (i2 == 0) {
            return 1L;
        }
        if (i2 == 1) {
            return i;
        }
        long[] jArr = f6373c;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = f6368a;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = f6371b;
        if (i2 < iArr2.length && i <= iArr2[i2]) {
            int i3 = i - 1;
            long j = i;
            for (int i4 = 2; i4 <= i2; i4++) {
                j = (j * ((long) i3)) / ((long) i4);
                i3--;
            }
            return j;
        }
        long j2 = i;
        int iQ = q(j2, RoundingMode.CEILING);
        int i5 = i - 1;
        int i6 = iQ;
        int i7 = 2;
        long j3 = j2;
        long j4 = 1;
        while (i7 <= i2) {
            i6 += iQ;
            if (i6 < 63) {
                j3 *= (long) i5;
                j4 *= (long) i7;
            } else {
                jU = u(jU, j3, j4);
                j3 = i5;
                j4 = i7;
                i6 = iQ;
            }
            i7++;
            i5--;
        }
        return u(jU, j3, j4);
    }

    @Beta
    public static long b(long j) {
        f.i("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long c(long j, long j2) {
        long j3 = j + j2;
        f.c(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long d(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        f.c(iNumberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        f.c((j >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        f.c(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long e(long j, int i) {
        f.e("exponent", i);
        long jD = 1;
        if ((j >= -2) && (j <= 2)) {
            int i2 = (int) j;
            if (i2 == -2) {
                f.c(i < 64, "checkedPow", j, i);
                return (i & 1) == 0 ? 1 << i : (-1) << i;
            }
            if (i2 == -1) {
                return (i & 1) == 0 ? 1L : -1L;
            }
            if (i2 == 0) {
                return i == 0 ? 1L : 0L;
            }
            if (i2 == 1) {
                return 1L;
            }
            if (i2 != 2) {
                throw new AssertionError();
            }
            f.c(i < 63, "checkedPow", j, i);
            return 1 << i;
        }
        long j2 = j;
        int i3 = i;
        while (i3 != 0) {
            if (i3 == 1) {
                return d(jD, j2);
            }
            if ((i3 & 1) != 0) {
                jD = d(jD, j2);
            }
            long j3 = jD;
            int i4 = i3 >> 1;
            if (i4 > 0) {
                f.c(-3037000499L <= j2 && j2 <= c, "checkedPow", j2, i4);
                j2 *= j2;
            }
            i3 = i4;
            jD = j3;
        }
        return jD;
    }

    @GwtIncompatible
    public static long f(long j, long j2) {
        long j3 = j - j2;
        f.c(((j ^ j2) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, j2);
        return j3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    @GwtIncompatible
    public static long g(long j, long j2, RoundingMode roundingMode) {
        com.google.common.base.i.E(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 == 0) {
            return j3;
        }
        boolean z = true;
        int i = ((int) ((j ^ j2) >> 63)) | 1;
        switch (a.f32206a[roundingMode.ordinal()]) {
            case 1:
                f.k(j4 == 0);
                z = false;
                if (z) {
                    return j3 + ((long) i);
                }
                return j3;
            case 2:
                z = false;
                if (z) {
                    return j3 + ((long) i);
                }
                return j3;
            case 3:
                if (i >= 0) {
                    z = false;
                }
                if (z) {
                    return j3 + ((long) i);
                }
                return j3;
            case 4:
                if (z) {
                    return j3 + ((long) i);
                }
                return j3;
            case 5:
                if (i <= 0) {
                    z = false;
                }
                if (z) {
                    return j3 + ((long) i);
                }
                return j3;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j4);
                long jAbs2 = jAbs - (Math.abs(j2) - jAbs);
                if (jAbs2 == 0) {
                    z = (((1 & j3) != 0) & (roundingMode == RoundingMode.HALF_EVEN)) | (roundingMode == RoundingMode.HALF_UP);
                } else if (jAbs2 <= 0) {
                    z = false;
                }
                if (z) {
                    return j3 + ((long) i);
                }
                return j3;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long h(int i) {
        f.e("n", i);
        long[] jArr = f6373c;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    public static boolean i(long j) {
        return ((long) ((int) j)) == j;
    }

    @Beta
    public static long j(long j) {
        f.i("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long k(long j, long j2) {
        f.f("a", j);
        f.f("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long jNumberOfTrailingZeros = j >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j3 = j2 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j3) {
            long j4 = jNumberOfTrailingZeros - j3;
            long j5 = (j4 >> 63) & j4;
            long j6 = (j4 - j5) - j5;
            j3 += j5;
            jNumberOfTrailingZeros = j6 >> Long.numberOfTrailingZeros(j6);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static boolean l(long j) {
        return (j > 0) & ((j & (j - 1)) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean m(long j) {
        if (j < 2) {
            f.f("n", j);
            return false;
        }
        if (j < 66) {
            return ((722865708377213483 >> (((int) j) + (-2))) & 1) != 0;
        }
        if (((1 << ((int) (j % 30))) & f32205a) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        }
        if (j < 289) {
            return true;
        }
        for (long[] jArr : f6370a) {
            if (j <= jArr[0]) {
                for (int i = 1; i < jArr.length; i++) {
                    if (!MillerRabinTester.test(jArr[i], j)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    public static int n(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    @GwtIncompatible
    public static int o(long j, RoundingMode roundingMode) {
        int iN;
        f.i("x", j);
        int iP = p(j);
        long j2 = f6369a[iP];
        switch (a.f32206a[roundingMode.ordinal()]) {
            case 1:
                f.k(j == j2);
            case 2:
            case 3:
                return iP;
            case 4:
            case 5:
                iN = n(j2, j);
                return iP + iN;
            case 6:
            case 7:
            case 8:
                iN = n(f6372b[iP], j);
                return iP + iN;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static int p(long j) {
        byte b2 = f6367a[Long.numberOfLeadingZeros(j)];
        return b2 - n(j, f6369a[b2]);
    }

    public static int q(long j, RoundingMode roundingMode) {
        f.i("x", j);
        switch (a.f32206a[roundingMode.ordinal()]) {
            case 1:
                f.k(l(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return (63 - iNumberOfLeadingZeros) + n(b >>> iNumberOfLeadingZeros, j);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long r(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @GwtIncompatible
    public static int s(long j, int i) {
        return (int) t(j, i);
    }

    @GwtIncompatible
    public static long t(long j, long j2) {
        if (j2 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    public static long u(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long jK = k(j, j3);
        return (j / jK) * (j2 / (j3 / jK));
    }

    @GwtIncompatible
    public static long v(long j, int i) {
        f.e("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j2 * j;
                }
                j2 *= (i & 1) == 0 ? 1L : j;
                j *= j;
                i >>= 1;
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            if (i < 64) {
                return (i & 1) == 0 ? 1 << i : -(1 << i);
            }
            return 0L;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        if (i < 64) {
            return 1 << i;
        }
        return 0L;
    }

    @GwtIncompatible
    public static double w(long j, RoundingMode roundingMode) {
        double dNextUp;
        long jCeil;
        double d = j;
        long jFloor = (long) d;
        int iD = jFloor == Long.MAX_VALUE ? -1 : Longs.d(j, jFloor);
        int[] iArr = a.f32206a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                f.k(iD == 0);
                return d;
            case 2:
                if (j >= 0) {
                    return iD >= 0 ? d : d.f(d);
                }
                return iD <= 0 ? d : Math.nextUp(d);
            case 3:
                return iD >= 0 ? d : d.f(d);
            case 4:
                if (j >= 0) {
                    return iD <= 0 ? d : Math.nextUp(d);
                }
                return iD >= 0 ? d : d.f(d);
            case 5:
                return iD <= 0 ? d : Math.nextUp(d);
            case 6:
            case 7:
            case 8:
                if (iD >= 0) {
                    dNextUp = Math.nextUp(d);
                    jCeil = (long) Math.ceil(dNextUp);
                } else {
                    double dF = d.f(d);
                    jFloor = (long) Math.floor(dF);
                    dNextUp = d;
                    d = dF;
                    jCeil = jFloor;
                }
                long j2 = j - jFloor;
                long j3 = jCeil - j;
                if (jCeil == Long.MAX_VALUE) {
                    j3++;
                }
                int iD2 = Longs.d(j2, j3);
                if (iD2 < 0) {
                    return d;
                }
                if (iD2 > 0) {
                    return dNextUp;
                }
                int i = iArr[roundingMode.ordinal()];
                if (i == 6) {
                    return j >= 0 ? d : dNextUp;
                }
                if (i == 7) {
                    return j >= 0 ? dNextUp : d;
                }
                if (i == 8) {
                    return (d.c(d) & 1) == 0 ? d : dNextUp;
                }
                throw new AssertionError("impossible");
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long x(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long y(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        if ((iNumberOfLeadingZeros < 64) || ((j2 == Long.MIN_VALUE) & (j < 0))) {
            return j3;
        }
        long j4 = j * j2;
        return (j == 0 || j4 / j == j2) ? j4 : j3;
    }

    @Beta
    public static long z(long j, int i) {
        f.e("exponent", i);
        long jY = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j2 = ((j >>> 63) & ((long) (i & 1))) + Long.MAX_VALUE;
            while (i != 0) {
                if (i == 1) {
                    return y(jY, j);
                }
                if ((i & 1) != 0) {
                    jY = y(jY, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > c)) {
                        return j2;
                    }
                    j *= j;
                }
            }
            return jY;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            if (i >= 64) {
                return ((long) (i & 1)) + Long.MAX_VALUE;
            }
            return (i & 1) == 0 ? 1 << i : (-1) << i;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        if (i >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i;
    }
}
