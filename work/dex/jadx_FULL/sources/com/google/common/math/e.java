package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;
import com.zj.adlib.vj9;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final int f32215a = 1073741824;

    @VisibleForTesting
    public static final int b = -1257966797;

    @VisibleForTesting
    public static final int c = 46340;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final byte[] f6380a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final int[] f6381a = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, vj9.f20229a};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public static final int[] f6382b = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f6383c = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    @VisibleForTesting
    public static int[] d = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32216a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f32216a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32216a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32216a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32216a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32216a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32216a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32216a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32216a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i, int i2) {
        f.e("n", i);
        f.e("k", i2);
        int i3 = 0;
        com.google.common.base.i.m(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = d;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Integer.MAX_VALUE;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return i;
        }
        long j = 1;
        while (i3 < i2) {
            long j2 = j * ((long) (i - i3));
            i3++;
            j = j2 / ((long) i3);
        }
        return (int) j;
    }

    @Beta
    public static int b(int i) {
        f.h("x", i);
        if (i <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i - 1));
        }
        StringBuilder sb = new StringBuilder(58);
        sb.append("ceilingPowerOfTwo(");
        sb.append(i);
        sb.append(") not representable as an int");
        throw new ArithmeticException(sb.toString());
    }

    public static int c(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        f.b(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int d(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        int i3 = (int) j;
        f.b(j == ((long) i3), "checkedMultiply", i, i2);
        return i3;
    }

    public static int e(int i, int i2) {
        f.e("exponent", i2);
        if (i == -2) {
            f.b(i2 < 32, "checkedPow", i, i2);
            return (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        }
        if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        }
        if (i == 0) {
            return i2 == 0 ? 1 : 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            f.b(i2 < 31, "checkedPow", i, i2);
            return 1 << i2;
        }
        int iD = 1;
        while (i2 != 0) {
            if (i2 == 1) {
                return d(iD, i);
            }
            if ((i2 & 1) != 0) {
                iD = d(iD, i);
            }
            i2 >>= 1;
            if (i2 > 0) {
                f.b((-46340 <= i) & (i <= 46340), "checkedPow", i, i2);
                i *= i;
            }
        }
        return iD;
    }

    public static int f(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        int i3 = (int) j;
        f.b(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0057  */
    /* JADX WARN: Code duplicated, block: B:38:0x005a  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static int g(int i, int i2, RoundingMode roundingMode) {
        com.google.common.base.i.E(roundingMode);
        if (i2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i3 = i / i2;
        int i4 = i - (i2 * i3);
        if (i4 == 0) {
            return i3;
        }
        boolean z = true;
        int i5 = ((i ^ i2) >> 31) | 1;
        switch (a.f32216a[roundingMode.ordinal()]) {
            case 1:
                f.k(i4 == 0);
                z = false;
                if (z) {
                    return i3 + i5;
                }
                return i3;
            case 2:
                z = false;
                if (z) {
                    return i3 + i5;
                }
                return i3;
            case 3:
                if (i5 >= 0) {
                    z = false;
                }
                if (z) {
                    return i3 + i5;
                }
                return i3;
            case 4:
                if (z) {
                    return i3 + i5;
                }
                return i3;
            case 5:
                if (i5 <= 0) {
                    z = false;
                }
                if (z) {
                    return i3 + i5;
                }
                return i3;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i4);
                int iAbs2 = iAbs - (Math.abs(i2) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i3 & 1) != 0))) {
                            z = false;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    z = false;
                }
                if (z) {
                    return i3 + i5;
                }
                return i3;
            default:
                throw new AssertionError();
        }
    }

    public static int h(int i) {
        f.e("n", i);
        int[] iArr = f6383c;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int i(int i) {
        f.h("x", i);
        return Integer.highestOneBit(i);
    }

    public static int j(int i, int i2) {
        f.e("a", i);
        f.e("b", i2);
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        int iNumberOfTrailingZeros2 = i >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(i2);
        int i3 = i2 >> iNumberOfTrailingZeros3;
        while (iNumberOfTrailingZeros2 != i3) {
            int i4 = iNumberOfTrailingZeros2 - i3;
            int i5 = (i4 >> 31) & i4;
            int i6 = (i4 - i5) - i5;
            i3 += i5;
            iNumberOfTrailingZeros2 = i6 >> Integer.numberOfTrailingZeros(i6);
        }
        return iNumberOfTrailingZeros2 << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros3);
    }

    public static boolean k(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean l(int i) {
        return LongMath.m(i);
    }

    @VisibleForTesting
    public static int m(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    @GwtIncompatible
    public static int n(int i, RoundingMode roundingMode) {
        int iM;
        f.h("x", i);
        int iO = o(i);
        int i2 = f6381a[iO];
        switch (a.f32216a[roundingMode.ordinal()]) {
            case 1:
                f.k(i == i2);
            case 2:
            case 3:
                return iO;
            case 4:
            case 5:
                iM = m(i2, i);
                return iO + iM;
            case 6:
            case 7:
            case 8:
                iM = m(f6382b[iO], i);
                return iO + iM;
            default:
                throw new AssertionError();
        }
    }

    public static int o(int i) {
        byte b2 = f6380a[Integer.numberOfLeadingZeros(i)];
        return b2 - m(i, f6381a[b2]);
    }

    public static int p(int i, RoundingMode roundingMode) {
        f.h("x", i);
        switch (a.f32216a[roundingMode.ordinal()]) {
            case 1:
                f.k(k(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - iNumberOfLeadingZeros) + m(b >>> iNumberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int q(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    public static int r(int i, int i2) {
        if (i2 > 0) {
            int i3 = i % i2;
            return i3 >= 0 ? i3 : i3 + i2;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Modulus ");
        sb.append(i2);
        sb.append(" must be > 0");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static int s(int i, int i2) {
        f.e("exponent", i2);
        if (i == -2) {
            if (i2 < 32) {
                return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
            }
            return 0;
        }
        if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        }
        if (i == 0) {
            return i2 == 0 ? 1 : 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            if (i2 < 32) {
                return 1 << i2;
            }
            return 0;
        }
        int i3 = 1;
        while (i2 != 0) {
            if (i2 == 1) {
                return i * i3;
            }
            i3 *= (i2 & 1) == 0 ? 1 : i;
            i *= i;
            i2 >>= 1;
        }
        return i3;
    }

    @Beta
    public static int t(int i, int i2) {
        return Ints.x(((long) i) + ((long) i2));
    }

    @Beta
    public static int u(int i, int i2) {
        return Ints.x(((long) i) * ((long) i2));
    }

    @Beta
    public static int v(int i, int i2) {
        f.e("exponent", i2);
        if (i == -2) {
            if (i2 >= 32) {
                return (i2 & 1) + Integer.MAX_VALUE;
            }
            return (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        }
        if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        }
        if (i == 0) {
            return i2 == 0 ? 1 : 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            if (i2 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i2;
        }
        int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
        int iU = 1;
        while (i2 != 0) {
            if (i2 == 1) {
                return u(iU, i);
            }
            if ((i2 & 1) != 0) {
                iU = u(iU, i);
            }
            i2 >>= 1;
            if (i2 > 0) {
                if ((-46340 > i) || (i > 46340)) {
                    return i3;
                }
                i *= i;
            }
        }
        return iU;
    }

    @Beta
    public static int w(int i, int i2) {
        return Ints.x(((long) i) - ((long) i2));
    }

    @GwtIncompatible
    public static int x(int i, RoundingMode roundingMode) {
        int iM;
        f.e("x", i);
        int iY = y(i);
        switch (a.f32216a[roundingMode.ordinal()]) {
            case 1:
                f.k(iY * iY == i);
            case 2:
            case 3:
                return iY;
            case 4:
            case 5:
                iM = m(iY * iY, i);
                return iY + iM;
            case 6:
            case 7:
            case 8:
                iM = m((iY * iY) + iY, i);
                return iY + iM;
            default:
                throw new AssertionError();
        }
    }

    public static int y(int i) {
        return (int) Math.sqrt(i);
    }
}
