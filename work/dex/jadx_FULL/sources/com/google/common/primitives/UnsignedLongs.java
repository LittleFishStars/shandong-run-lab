package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtCompatible
public final class UnsignedLongs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32246a = -1;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < iMin; i++) {
                long j = jArr[i];
                long j2 = jArr2[i];
                if (j != j2) {
                    return UnsignedLongs.a(j, j2);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final long[] f6437a = new long[37];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f32247a = new int[37];
        public static final int[] b = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = i;
                f6437a[i] = UnsignedLongs.c(-1L, j);
                f32247a[i] = (int) UnsignedLongs.k(-1L, j);
                b[i] = bigInteger.toString(i).length() - 1;
            }
        }

        public static boolean a(long j, int i, int i2) {
            if (j < 0) {
                return true;
            }
            long j2 = f6437a[i2];
            if (j < j2) {
                return false;
            }
            return j > j2 || i > f32247a[i2];
        }
    }

    public static int a(long j, long j2) {
        return Longs.d(d(j), d(j2));
    }

    @CanIgnoreReturnValue
    public static long b(String str) {
        com.google.common.primitives.a aVarA = com.google.common.primitives.a.a(str);
        try {
            return j(aVarA.f6438a, aVarA.f32248a);
        } catch (NumberFormatException e) {
            String strValueOf = String.valueOf(str);
            NumberFormatException numberFormatException = new NumberFormatException(strValueOf.length() != 0 ? "Error parsing value: ".concat(strValueOf) : new String("Error parsing value: "));
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long c(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + ((long) (a(j - (j3 * j2), j2) < 0 ? 0 : 1));
    }

    public static long d(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static String e(String str, long... jArr) {
        i.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(p(jArr[0]));
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(p(jArr[i]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> f() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long g(long... jArr) {
        i.d(jArr.length > 0);
        long jD = d(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            long jD2 = d(jArr[i]);
            if (jD2 > jD) {
                jD = jD2;
            }
        }
        return d(jD);
    }

    public static long h(long... jArr) {
        i.d(jArr.length > 0);
        long jD = d(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            long jD2 = d(jArr[i]);
            if (jD2 < jD) {
                jD = jD2;
            }
        }
        return d(jD);
    }

    @CanIgnoreReturnValue
    public static long i(String str) {
        return j(str, 10);
    }

    @CanIgnoreReturnValue
    public static long j(String str, int i) {
        i.E(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i < 2 || i > 36) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("illegal radix: ");
            sb.append(i);
            throw new NumberFormatException(sb.toString());
        }
        int i2 = a.b[i] - 1;
        long j = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int iDigit = Character.digit(str.charAt(i3), i);
            if (iDigit == -1) {
                throw new NumberFormatException(str);
            }
            if (i3 > i2 && a.a(j, iDigit, i)) {
                throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
            }
            j = (j * ((long) i)) + ((long) iDigit);
        }
        return j;
    }

    public static long k(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (a(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static void l(long[] jArr) {
        i.E(jArr);
        m(jArr, 0, jArr.length);
    }

    public static void m(long[] jArr, int i, int i2) {
        i.E(jArr);
        i.f0(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = d(jArr[i3]);
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = d(jArr[i]);
            i++;
        }
    }

    public static void n(long[] jArr) {
        i.E(jArr);
        o(jArr, 0, jArr.length);
    }

    public static void o(long[] jArr, int i, int i2) {
        i.E(jArr);
        i.f0(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = Long.MAX_VALUE ^ jArr[i3];
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MAX_VALUE;
            i++;
        }
    }

    public static String p(long j) {
        return q(j, 10);
    }

    public static String q(long j, int i) {
        i.k(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= iNumberOfTrailingZeros;
            } while (j != 0);
        } else {
            long jC = (i & 1) == 0 ? (j >>> 1) / ((long) (i >>> 1)) : c(j, i);
            long j2 = i;
            int i4 = 63;
            cArr[63] = Character.forDigit((int) (j - (jC * j2)), i);
            while (jC > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (jC % j2), i);
                jC /= j2;
            }
            i2 = i4;
        }
        return new String(cArr, i2, 64 - i2);
    }
}
