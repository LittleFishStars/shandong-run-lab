package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtCompatible
public final class UnsignedInts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32245a = 4294967295L;

    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < iMin; i++) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                if (i2 != i3) {
                    return UnsignedInts.b(i2, i3);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int a(long j) {
        i.p((j >> 32) == 0, "out of range: %s", j);
        return (int) j;
    }

    public static int b(int i, int i2) {
        return Ints.e(e(i), e(i2));
    }

    @CanIgnoreReturnValue
    public static int c(String str) {
        a aVarA = a.a(str);
        try {
            return k(aVarA.f6438a, aVarA.f32248a);
        } catch (NumberFormatException e) {
            String strValueOf = String.valueOf(str);
            NumberFormatException numberFormatException = new NumberFormatException(strValueOf.length() != 0 ? "Error parsing value: ".concat(strValueOf) : new String("Error parsing value: "));
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static int d(int i, int i2) {
        return (int) (r(i) / r(i2));
    }

    public static int e(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static String f(String str, int... iArr) {
        i.E(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(s(iArr[0]));
        for (int i = 1; i < iArr.length; i++) {
            sb.append(str);
            sb.append(s(iArr[i]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> g() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int h(int... iArr) {
        i.d(iArr.length > 0);
        int iE = e(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            int iE2 = e(iArr[i]);
            if (iE2 > iE) {
                iE = iE2;
            }
        }
        return e(iE);
    }

    public static int i(int... iArr) {
        i.d(iArr.length > 0);
        int iE = e(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            int iE2 = e(iArr[i]);
            if (iE2 < iE) {
                iE = iE2;
            }
        }
        return e(iE);
    }

    @CanIgnoreReturnValue
    public static int j(String str) {
        return k(str, 10);
    }

    @CanIgnoreReturnValue
    public static int k(String str, int i) {
        i.E(str);
        long j = Long.parseLong(str, i);
        if ((4294967295L & j) == j) {
            return (int) j;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 69);
        sb.append("Input ");
        sb.append(str);
        sb.append(" in base ");
        sb.append(i);
        sb.append(" is not in the range of an unsigned integer");
        throw new NumberFormatException(sb.toString());
    }

    public static int l(int i, int i2) {
        return (int) (r(i) % r(i2));
    }

    public static int m(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 4294967296L) {
            return -1;
        }
        return (int) j;
    }

    public static void n(int[] iArr) {
        i.E(iArr);
        o(iArr, 0, iArr.length);
    }

    public static void o(int[] iArr, int i, int i2) {
        i.E(iArr);
        i.f0(i, i2, iArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            iArr[i3] = e(iArr[i3]);
        }
        Arrays.sort(iArr, i, i2);
        while (i < i2) {
            iArr[i] = e(iArr[i]);
            i++;
        }
    }

    public static void p(int[] iArr) {
        i.E(iArr);
        q(iArr, 0, iArr.length);
    }

    public static void q(int[] iArr, int i, int i2) {
        i.E(iArr);
        i.f0(i, i2, iArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            iArr[i3] = Integer.MAX_VALUE ^ iArr[i3];
        }
        Arrays.sort(iArr, i, i2);
        while (i < i2) {
            iArr[i] = iArr[i] ^ Integer.MAX_VALUE;
            i++;
        }
    }

    public static long r(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String s(int i) {
        return t(i, 10);
    }

    public static String t(int i, int i2) {
        return Long.toString(((long) i) & 4294967295L, i2);
    }
}
