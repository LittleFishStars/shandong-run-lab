package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class h {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32218a;

        public c a(int i) {
            return new c(this.f32218a, i);
        }

        public d b(Collection<Integer> collection) {
            return new d(this.f32218a, Ints.B(collection));
        }

        public d c(int... iArr) {
            return new d(this.f32218a, (int[]) iArr.clone());
        }

        public b(int i) {
            com.google.common.base.i.e(i > 0, "Quantile scale must be positive");
            this.f32218a = i;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32219a;
        public final int b;

        public double a(Collection<? extends Number> collection) {
            return e(Doubles.z(collection));
        }

        public double b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public double c(int... iArr) {
            return e(h.l(iArr));
        }

        public double d(long... jArr) {
            return e(h.m(jArr));
        }

        public double e(double... dArr) {
            com.google.common.base.i.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (h.j(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.b) * ((long) (dArr.length - 1));
            int iG = (int) LongMath.g(length, this.f32219a, RoundingMode.DOWN);
            int i = (int) (length - (((long) iG) * ((long) this.f32219a)));
            h.u(iG, dArr, 0, dArr.length - 1);
            if (i == 0) {
                return dArr[iG];
            }
            int i2 = iG + 1;
            h.u(i2, dArr, i2, dArr.length - 1);
            return h.k(dArr[iG], dArr[i2], i, this.f32219a);
        }

        public c(int i, int i2) {
            h.h(i2, i);
            this.f32219a = i;
            this.b = i2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32220a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f6385a;

        public Map<Integer, Double> a(Collection<? extends Number> collection) {
            return e(Doubles.z(collection));
        }

        public Map<Integer, Double> b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public Map<Integer, Double> c(int... iArr) {
            return e(h.l(iArr));
        }

        public Map<Integer, Double> d(long... jArr) {
            return e(h.m(jArr));
        }

        public Map<Integer, Double> e(double... dArr) {
            int i = 0;
            com.google.common.base.i.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (h.j(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.f6385a;
                int length = iArr.length;
                while (i < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i]), Double.valueOf(Double.NaN));
                    i++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.f6385a;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr6 = this.f6385a;
                if (i2 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i2]) * ((long) (dArr.length - 1));
                int iG = (int) LongMath.g(length2, this.f32220a, RoundingMode.DOWN);
                int i4 = (int) (length2 - (((long) iG) * ((long) this.f32220a)));
                iArr3[i2] = iG;
                iArr4[i2] = i4;
                iArr5[i3] = iG;
                i3++;
                if (i4 != 0) {
                    iArr5[i3] = iG + 1;
                    i3++;
                }
                i2++;
            }
            Arrays.sort(iArr5, 0, i3);
            h.t(iArr5, 0, i3 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.f6385a;
                if (i >= iArr7.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i5 = iArr3[i];
                int i6 = iArr4[i];
                if (i6 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(dArr[i5]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(h.k(dArr[i5], dArr[i5 + 1], i6, this.f32220a)));
                }
                i++;
            }
        }

        public d(int i, int[] iArr) {
            for (int i2 : iArr) {
                h.h(i2, i);
            }
            com.google.common.base.i.e(iArr.length > 0, "Indexes must be a non empty array");
            this.f32220a = i;
            this.f6385a = iArr;
        }
    }

    public static void h(int i, int i2) {
        if (i < 0 || i > i2) {
            StringBuilder sb = new StringBuilder(70);
            sb.append("Quantile indexes must be between 0 and the scale, which is ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static int i(int[] iArr, int i, int i2, int i3, int i4) {
        if (i == i2) {
            return i;
        }
        int i5 = i3 + i4;
        int i6 = i5 >>> 1;
        while (i2 > i + 1) {
            int i7 = (i + i2) >>> 1;
            int i8 = iArr[i7];
            if (i8 > i6) {
                i2 = i7;
            } else {
                if (i8 >= i6) {
                    return i7;
                }
                i = i7;
            }
        }
        return (i5 - iArr[i]) - iArr[i2] > 0 ? i2 : i;
    }

    public static boolean j(double... dArr) {
        for (double d2 : dArr) {
            if (Double.isNaN(d2)) {
                return true;
            }
        }
        return false;
    }

    public static double k(double d2, double d3, double d4, double d5) {
        if (d2 == Double.NEGATIVE_INFINITY) {
            return d3 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d3 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d2 + (((d3 - d2) * d4) / d5);
    }

    public static double[] l(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = iArr[i];
        }
        return dArr;
    }

    public static double[] m(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = jArr[i];
        }
        return dArr;
    }

    public static c n() {
        return s(2).a(1);
    }

    public static void o(double[] dArr, int i, int i2) {
        int i3 = (i + i2) >>> 1;
        double d2 = dArr[i2];
        double d3 = dArr[i3];
        boolean z = d2 < d3;
        double d4 = dArr[i];
        boolean z2 = d3 < d4;
        boolean z3 = d2 < d4;
        if (z == z2) {
            v(dArr, i3, i);
        } else if (z != z3) {
            v(dArr, i, i2);
        }
    }

    public static int p(double[] dArr, int i, int i2) {
        o(dArr, i, i2);
        double d2 = dArr[i];
        int i3 = i2;
        while (i2 > i) {
            if (dArr[i2] > d2) {
                v(dArr, i3, i2);
                i3--;
            }
            i2--;
        }
        v(dArr, i, i3);
        return i3;
    }

    public static b q() {
        return s(100);
    }

    public static b r() {
        return s(4);
    }

    public static b s(int i) {
        return new b(i);
    }

    public static void t(int[] iArr, int i, int i2, double[] dArr, int i3, int i4) {
        int i5 = i(iArr, i, i2, i3, i4);
        int i6 = iArr[i5];
        u(i6, dArr, i3, i4);
        int i7 = i5 - 1;
        while (i7 >= i && iArr[i7] == i6) {
            i7--;
        }
        if (i7 >= i) {
            t(iArr, i, i7, dArr, i3, i6 - 1);
        }
        int i8 = i5 + 1;
        while (i8 <= i2 && iArr[i8] == i6) {
            i8++;
        }
        if (i8 <= i2) {
            t(iArr, i8, i2, dArr, i6 + 1, i4);
        }
    }

    public static void u(int i, double[] dArr, int i2, int i3) {
        if (i != i2) {
            while (i3 > i2) {
                int iP = p(dArr, i2, i3);
                if (iP >= i) {
                    i3 = iP - 1;
                }
                if (iP <= i) {
                    i2 = iP + 1;
                }
            }
            return;
        }
        int i4 = i2;
        for (int i5 = i2 + 1; i5 <= i3; i5++) {
            if (dArr[i4] > dArr[i5]) {
                i4 = i5;
            }
        }
        if (i4 != i2) {
            v(dArr, i4, i2);
        }
    }

    public static void v(double[] dArr, int i, int i2) {
        double d2 = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d2;
    }
}
