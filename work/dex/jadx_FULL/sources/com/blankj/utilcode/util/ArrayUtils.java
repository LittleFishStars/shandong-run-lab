package com.blankj.utilcode.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ArrayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28119a = -1;

    public interface Closure<E> {
        void a(int i, E e);
    }

    public ArrayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @NonNull
    public static <T> T[] A(@Nullable T[] tArr, @Nullable T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass();
        } else {
            cls = t != null ? t.getClass() : Object.class;
        }
        return (T[]) ((Object[]) v1(tArr, t, cls));
    }

    public static int A0(@Nullable double[] dArr, double d, int i, double d2) {
        if (N0(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i < dArr.length) {
            double d5 = dArr[i];
            if (d5 >= d3 && d5 <= d4) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static char[] A1(@Nullable char[] cArr, int i) {
        if (cArr == null) {
            return null;
        }
        return (char[]) y1(cArr, i);
    }

    @Nullable
    public static byte[] A2(@Nullable Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    @Nullable
    public static <T> T[] B(@Nullable T[] tArr, @Nullable T[] tArr2) {
        return (T[]) ((Object[]) u1(tArr, tArr2));
    }

    public static int B0(@Nullable float[] fArr, float f) {
        return C0(fArr, f, 0);
    }

    @Nullable
    public static double[] B1(@Nullable double[] dArr, int i) {
        if (dArr == null) {
            return null;
        }
        return (double[]) y1(dArr, i);
    }

    @Nullable
    public static byte[] B2(@Nullable Byte[] bArr, byte b) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            Byte b2 = bArr[i];
            bArr2[i] = b2 == null ? b : b2.byteValue();
        }
        return bArr2;
    }

    @NonNull
    public static short[] C(@Nullable short[] sArr, int i, short s) {
        return (short[]) s1(sArr, i, Short.valueOf(s), Short.TYPE);
    }

    public static int C0(@Nullable float[] fArr, float f, int i) {
        if (N0(fArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < fArr.length) {
            if (f == fArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static float[] C1(@Nullable float[] fArr, int i) {
        if (fArr == null) {
            return null;
        }
        return (float[]) y1(fArr, i);
    }

    @Nullable
    public static char[] C2(@Nullable Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    @Nullable
    public static short[] D(@Nullable short[] sArr, int i, @Nullable short[] sArr2) {
        Object objT1 = t1(sArr, i, sArr2, Short.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (short[]) objT1;
    }

    public static int D0(@Nullable int[] iArr, int i) {
        return E0(iArr, i, 0);
    }

    @Nullable
    public static int[] D1(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return null;
        }
        return (int[]) y1(iArr, i);
    }

    @Nullable
    public static char[] D2(@Nullable Character[] chArr, char c) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            Character ch = chArr[i];
            cArr[i] = ch == null ? c : ch.charValue();
        }
        return cArr;
    }

    @NonNull
    public static short[] E(@Nullable short[] sArr, short s) {
        return (short[]) v1(sArr, Short.valueOf(s), Short.TYPE);
    }

    public static int E0(@Nullable int[] iArr, int i, int i2) {
        if (iArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < iArr.length) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Nullable
    public static long[] E1(@Nullable long[] jArr, int i) {
        if (jArr == null) {
            return null;
        }
        return (long[]) y1(jArr, i);
    }

    @Nullable
    public static double[] E2(@Nullable Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    @Nullable
    public static short[] F(@Nullable short[] sArr, @Nullable short[] sArr2) {
        return (short[]) u1(sArr, sArr2);
    }

    public static int F0(@Nullable long[] jArr, long j) {
        return G0(jArr, j, 0);
    }

    @Nullable
    public static Object[] F1(@Nullable Object[] objArr, int i) {
        if (objArr == null) {
            return null;
        }
        return (Object[]) y1(objArr, i);
    }

    @Nullable
    public static double[] F2(@Nullable Double[] dArr, double d) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            Double d2 = dArr[i];
            dArr2[i] = d2 == null ? d : d2.doubleValue();
        }
        return dArr2;
    }

    @NonNull
    public static boolean[] G(@Nullable boolean[] zArr, int i, boolean z) {
        return (boolean[]) s1(zArr, i, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static int G0(@Nullable long[] jArr, long j, int i) {
        if (jArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < jArr.length) {
            if (j == jArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static short[] G1(@Nullable short[] sArr, int i) {
        if (sArr == null) {
            return null;
        }
        return (short[]) y1(sArr, i);
    }

    @Nullable
    public static float[] G2(@Nullable Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    @Nullable
    public static boolean[] H(@Nullable boolean[] zArr, int i, @Nullable boolean[] zArr2) {
        Object objT1 = t1(zArr, i, zArr2, Boolean.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (boolean[]) objT1;
    }

    public static int H0(@Nullable Object[] objArr, @Nullable Object obj) {
        return I0(objArr, obj, 0);
    }

    @Nullable
    public static boolean[] H1(@Nullable boolean[] zArr, int i) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) y1(zArr, i);
    }

    @Nullable
    public static float[] H2(@Nullable Float[] fArr, float f) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            Float f2 = fArr[i];
            fArr2[i] = f2 == null ? f : f2.floatValue();
        }
        return fArr2;
    }

    @NonNull
    public static boolean[] I(@Nullable boolean[] zArr, boolean z) {
        return (boolean[]) v1(zArr, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static int I0(@Nullable Object[] objArr, @Nullable Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (obj == null) {
            while (i < objArr.length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Nullable
    public static byte[] I1(@Nullable byte[] bArr, byte b) {
        int iT0 = t0(bArr, b);
        return iT0 == -1 ? Y(bArr) : z1(bArr, iT0);
    }

    @Nullable
    public static int[] I2(@Nullable Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    @Nullable
    public static boolean[] J(@Nullable boolean[] zArr, @Nullable boolean[] zArr2) {
        return (boolean[]) u1(zArr, zArr2);
    }

    public static int J0(@Nullable short[] sArr, short s) {
        return K0(sArr, s, 0);
    }

    @Nullable
    public static char[] J1(@Nullable char[] cArr, char c) {
        int iV0 = v0(cArr, c);
        return iV0 == -1 ? Z(cArr) : A1(cArr, iV0);
    }

    @Nullable
    public static int[] J2(@Nullable Integer[] numArr, int i) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            iArr[i2] = num == null ? i : num.intValue();
        }
        return iArr;
    }

    @NonNull
    public static <T> List<T> K(@Nullable T... tArr) {
        ArrayList arrayList = new ArrayList();
        if (tArr != null && tArr.length != 0) {
            arrayList.addAll(Arrays.asList(tArr));
        }
        return arrayList;
    }

    public static int K0(@Nullable short[] sArr, short s, int i) {
        if (sArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < sArr.length) {
            if (s == sArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static double[] K1(@Nullable double[] dArr, double d) {
        int iX0 = x0(dArr, d);
        return iX0 == -1 ? a0(dArr) : B1(dArr, iX0);
    }

    @Nullable
    public static long[] K2(@Nullable Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    @NonNull
    public static <T> List<T> L(@Nullable T... tArr) {
        LinkedList linkedList = new LinkedList();
        if (tArr != null && tArr.length != 0) {
            linkedList.addAll(Arrays.asList(tArr));
        }
        return linkedList;
    }

    public static int L0(@Nullable boolean[] zArr, boolean z) {
        return M0(zArr, z, 0);
    }

    @Nullable
    public static float[] L1(@Nullable float[] fArr, float f) {
        int iB0 = B0(fArr, f);
        return iB0 == -1 ? b0(fArr) : C1(fArr, iB0);
    }

    @Nullable
    public static long[] L2(@Nullable Long[] lArr, long j) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            Long l = lArr[i];
            jArr[i] = l == null ? j : l.longValue();
        }
        return jArr;
    }

    @NonNull
    public static <T> List<T> M(@Nullable T... tArr) {
        return (tArr == null || tArr.length == 0) ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public static int M0(@Nullable boolean[] zArr, boolean z, int i) {
        if (N0(zArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < zArr.length) {
            if (z == zArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static int[] M1(@Nullable int[] iArr, int i) {
        int iD0 = D0(iArr, i);
        return iD0 == -1 ? c0(iArr) : D1(iArr, iD0);
    }

    @Nullable
    public static short[] M2(@Nullable Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    @NonNull
    public static <T> List<T> N(@Nullable T... tArr) {
        return Collections.unmodifiableList(M(tArr));
    }

    public static boolean N0(@Nullable Object obj) {
        return s0(obj) == 0;
    }

    @Nullable
    public static long[] N1(@Nullable long[] jArr, long j) {
        int iF0 = F0(jArr, j);
        return iF0 == -1 ? d0(jArr) : E1(jArr, iF0);
    }

    @Nullable
    public static short[] N2(@Nullable Short[] shArr, short s) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            Short sh = shArr[i];
            sArr[i] = sh == null ? s : sh.shortValue();
        }
        return sArr;
    }

    public static boolean O(@Nullable byte[] bArr, byte b) {
        return t0(bArr, b) != -1;
    }

    public static boolean O0(@Nullable Object obj, @Nullable Object obj2) {
        return s0(obj) == s0(obj2);
    }

    @Nullable
    public static Object[] O1(@Nullable Object[] objArr, @Nullable Object obj) {
        int iH0 = H0(objArr, obj);
        return iH0 == -1 ? e0(objArr) : F1(objArr, iH0);
    }

    @Nullable
    public static boolean[] O2(@Nullable Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static boolean P(@Nullable char[] cArr, char c) {
        return v0(cArr, c) != -1;
    }

    public static int P0(@Nullable byte[] bArr, byte b) {
        return Q0(bArr, b, Integer.MAX_VALUE);
    }

    @Nullable
    public static short[] P1(@Nullable short[] sArr, short s) {
        int iJ0 = J0(sArr, s);
        return iJ0 == -1 ? f0(sArr) : G1(sArr, iJ0);
    }

    @Nullable
    public static boolean[] P2(@Nullable Boolean[] boolArr, boolean z) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            Boolean bool = boolArr[i];
            zArr[i] = bool == null ? z : bool.booleanValue();
        }
        return zArr;
    }

    public static boolean Q(@Nullable double[] dArr, double d) {
        return x0(dArr, d) != -1;
    }

    public static int Q0(@Nullable byte[] bArr, byte b, int i) {
        if (bArr == null || i < 0) {
            return -1;
        }
        if (i >= bArr.length) {
            i = bArr.length - 1;
        }
        while (i >= 0) {
            if (b == bArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    @Nullable
    public static boolean[] Q1(@Nullable boolean[] zArr, boolean z) {
        int iL0 = L0(zArr, z);
        return iL0 == -1 ? g0(zArr) : H1(zArr, iL0);
    }

    @NonNull
    public static String Q2(@Nullable Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Object[]) {
            return Arrays.deepToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        }
        if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        }
        if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        }
        if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        }
        throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
    }

    public static boolean R(@Nullable double[] dArr, double d, double d2) {
        return A0(dArr, d, 0, d2) != -1;
    }

    public static int R0(@Nullable char[] cArr, char c) {
        return S0(cArr, c, Integer.MAX_VALUE);
    }

    public static void R1(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length - 1;
        for (int i = 0; length > i; i++) {
            byte b = bArr[length];
            bArr[length] = bArr[i];
            bArr[i] = b;
            length--;
        }
    }

    public static boolean S(@Nullable float[] fArr, float f) {
        return B0(fArr, f) != -1;
    }

    public static int S0(@Nullable char[] cArr, char c, int i) {
        if (cArr == null || i < 0) {
            return -1;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        while (i >= 0) {
            if (c == cArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void S1(char[] cArr) {
        if (cArr == null) {
            return;
        }
        int length = cArr.length - 1;
        for (int i = 0; length > i; i++) {
            char c = cArr[length];
            cArr[length] = cArr[i];
            cArr[i] = c;
            length--;
        }
    }

    public static boolean T(@Nullable int[] iArr, int i) {
        return D0(iArr, i) != -1;
    }

    public static int T0(@Nullable double[] dArr, double d) {
        return V0(dArr, d, Integer.MAX_VALUE);
    }

    public static void T1(double[] dArr) {
        if (dArr == null) {
            return;
        }
        int length = dArr.length - 1;
        for (int i = 0; length > i; i++) {
            double d = dArr[length];
            dArr[length] = dArr[i];
            dArr[i] = d;
            length--;
        }
    }

    public static boolean U(@Nullable long[] jArr, long j) {
        return F0(jArr, j) != -1;
    }

    public static int U0(@Nullable double[] dArr, double d, double d2) {
        return W0(dArr, d, Integer.MAX_VALUE, d2);
    }

    public static void U1(float[] fArr) {
        if (fArr == null) {
            return;
        }
        int length = fArr.length - 1;
        for (int i = 0; length > i; i++) {
            float f = fArr[length];
            fArr[length] = fArr[i];
            fArr[i] = f;
            length--;
        }
    }

    public static boolean V(@Nullable Object[] objArr, @Nullable Object obj) {
        return H0(objArr, obj) != -1;
    }

    public static int V0(@Nullable double[] dArr, double d, int i) {
        if (N0(dArr) || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        while (i >= 0) {
            if (d == dArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void V1(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int length = iArr.length - 1;
        for (int i = 0; length > i; i++) {
            int i2 = iArr[length];
            iArr[length] = iArr[i];
            iArr[i] = i2;
            length--;
        }
    }

    public static boolean W(@Nullable short[] sArr, short s) {
        return J0(sArr, s) != -1;
    }

    public static int W0(@Nullable double[] dArr, double d, int i, double d2) {
        if (N0(dArr) || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i >= 0) {
            double d5 = dArr[i];
            if (d5 >= d3 && d5 <= d4) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void W1(long[] jArr) {
        if (jArr == null) {
            return;
        }
        int length = jArr.length - 1;
        for (int i = 0; length > i; i++) {
            long j = jArr[length];
            jArr[length] = jArr[i];
            jArr[i] = j;
            length--;
        }
    }

    public static boolean X(@Nullable boolean[] zArr, boolean z) {
        return L0(zArr, z) != -1;
    }

    public static int X0(@Nullable float[] fArr, float f) {
        return Y0(fArr, f, Integer.MAX_VALUE);
    }

    public static <T> void X1(T[] tArr) {
        if (tArr == null) {
            return;
        }
        int length = tArr.length - 1;
        for (int i = 0; length > i; i++) {
            T t = tArr[length];
            tArr[length] = tArr[i];
            tArr[i] = t;
            length--;
        }
    }

    @Nullable
    public static byte[] Y(@Nullable byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return j2(bArr, 0, bArr.length);
    }

    public static int Y0(@Nullable float[] fArr, float f, int i) {
        if (N0(fArr) || i < 0) {
            return -1;
        }
        if (i >= fArr.length) {
            i = fArr.length - 1;
        }
        while (i >= 0) {
            if (f == fArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void Y1(short[] sArr) {
        if (sArr == null) {
            return;
        }
        int length = sArr.length - 1;
        for (int i = 0; length > i; i++) {
            short s = sArr[length];
            sArr[length] = sArr[i];
            sArr[i] = s;
            length--;
        }
    }

    @Nullable
    public static char[] Z(@Nullable char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return k2(cArr, 0, cArr.length);
    }

    public static int Z0(@Nullable int[] iArr, int i) {
        return a1(iArr, i, Integer.MAX_VALUE);
    }

    public static void Z1(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        int length = zArr.length - 1;
        for (int i = 0; length > i; i++) {
            boolean z = zArr[length];
            zArr[length] = zArr[i];
            zArr[i] = z;
            length--;
        }
    }

    @NonNull
    public static byte[] a(@Nullable byte[] bArr, byte b) {
        return (byte[]) v1(bArr, Byte.valueOf(b), Byte.TYPE);
    }

    @Nullable
    public static double[] a0(@Nullable double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return l2(dArr, 0, dArr.length);
    }

    public static int a1(@Nullable int[] iArr, int i, int i2) {
        if (iArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= iArr.length) {
            i2 = iArr.length - 1;
        }
        while (i2 >= 0) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static void a2(@Nullable Object obj, int i, @Nullable Object obj2) {
        if (obj == null) {
            return;
        }
        Array.set(obj, i, obj2);
    }

    @NonNull
    public static byte[] b(@Nullable byte[] bArr, int i, byte b) {
        return (byte[]) s1(bArr, i, Byte.valueOf(b), Byte.TYPE);
    }

    @Nullable
    public static float[] b0(@Nullable float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return m2(fArr, 0, fArr.length);
    }

    public static int b1(@Nullable long[] jArr, long j) {
        return c1(jArr, j, Integer.MAX_VALUE);
    }

    public static void b2(@Nullable byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return;
        }
        Arrays.sort(bArr);
    }

    @Nullable
    public static byte[] c(@Nullable byte[] bArr, int i, @Nullable byte[] bArr2) {
        Object objT1 = t1(bArr, i, bArr2, Byte.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (byte[]) objT1;
    }

    @Nullable
    public static int[] c0(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return n2(iArr, 0, iArr.length);
    }

    public static int c1(@Nullable long[] jArr, long j, int i) {
        if (jArr == null || i < 0) {
            return -1;
        }
        if (i >= jArr.length) {
            i = jArr.length - 1;
        }
        while (i >= 0) {
            if (j == jArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void c2(@Nullable char[] cArr) {
        if (cArr == null || cArr.length < 2) {
            return;
        }
        Arrays.sort(cArr);
    }

    @Nullable
    public static byte[] d(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        return (byte[]) u1(bArr, bArr2);
    }

    @Nullable
    public static long[] d0(@Nullable long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return o2(jArr, 0, jArr.length);
    }

    public static int d1(@Nullable Object[] objArr, @Nullable Object obj) {
        return e1(objArr, obj, Integer.MAX_VALUE);
    }

    public static void d2(@Nullable double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return;
        }
        Arrays.sort(dArr);
    }

    @NonNull
    public static char[] e(@Nullable char[] cArr, char c) {
        return (char[]) v1(cArr, Character.valueOf(c), Character.TYPE);
    }

    @Nullable
    public static <T> T[] e0(@Nullable T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) p2(tArr, 0, tArr.length);
    }

    public static int e1(@Nullable Object[] objArr, @Nullable Object obj, int i) {
        if (objArr == null || i < 0) {
            return -1;
        }
        if (i >= objArr.length) {
            i = objArr.length - 1;
        }
        if (obj == null) {
            while (i >= 0) {
                if (objArr[i] == null) {
                    return i;
                }
                i--;
            }
        } else {
            while (i >= 0) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static void e2(@Nullable float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            return;
        }
        Arrays.sort(fArr);
    }

    @NonNull
    public static char[] f(@Nullable char[] cArr, int i, char c) {
        return (char[]) s1(cArr, i, Character.valueOf(c), Character.TYPE);
    }

    @Nullable
    public static short[] f0(@Nullable short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return q2(sArr, 0, sArr.length);
    }

    public static int f1(@Nullable short[] sArr, short s) {
        return g1(sArr, s, Integer.MAX_VALUE);
    }

    public static void f2(@Nullable int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        Arrays.sort(iArr);
    }

    public static char[] g(@Nullable char[] cArr, int i, @Nullable char[] cArr2) {
        Object objT1 = t1(cArr, i, cArr2, Character.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (char[]) objT1;
    }

    @Nullable
    public static boolean[] g0(@Nullable boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return r2(zArr, 0, zArr.length);
    }

    public static int g1(@Nullable short[] sArr, short s, int i) {
        if (sArr == null || i < 0) {
            return -1;
        }
        if (i >= sArr.length) {
            i = sArr.length - 1;
        }
        while (i >= 0) {
            if (s == sArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void g2(@Nullable long[] jArr) {
        if (jArr == null || jArr.length < 2) {
            return;
        }
        Arrays.sort(jArr);
    }

    @Nullable
    public static char[] h(@Nullable char[] cArr, @Nullable char[] cArr2) {
        return (char[]) u1(cArr, cArr2);
    }

    public static boolean h0(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static int h1(@Nullable boolean[] zArr, boolean z) {
        return i1(zArr, z, Integer.MAX_VALUE);
    }

    public static <T> void h2(@Nullable T[] tArr, Comparator<? super T> comparator) {
        if (tArr == null || tArr.length < 2) {
            return;
        }
        Arrays.sort(tArr, comparator);
    }

    @NonNull
    public static double[] i(@Nullable double[] dArr, double d) {
        return (double[]) v1(dArr, Double.valueOf(d), Double.TYPE);
    }

    public static boolean i0(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    public static int i1(@Nullable boolean[] zArr, boolean z, int i) {
        if (N0(zArr) || i < 0) {
            return -1;
        }
        if (i >= zArr.length) {
            i = zArr.length - 1;
        }
        while (i >= 0) {
            if (z == zArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static void i2(@Nullable short[] sArr) {
        if (sArr == null || sArr.length < 2) {
            return;
        }
        Arrays.sort(sArr);
    }

    @NonNull
    public static double[] j(@Nullable double[] dArr, int i, double d) {
        return (double[]) s1(dArr, i, Double.valueOf(d), Double.TYPE);
    }

    public static boolean j0(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @NonNull
    public static <T> T[] j1(T... tArr) {
        return tArr;
    }

    @Nullable
    public static byte[] j2(@Nullable byte[] bArr, int i, int i2) {
        return (byte[]) x1(bArr, i, i2);
    }

    @Nullable
    public static double[] k(@Nullable double[] dArr, int i, @Nullable double[] dArr2) {
        Object objT1 = t1(dArr, i, dArr2, Double.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (double[]) objT1;
    }

    public static boolean k0(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @NonNull
    public static boolean[] k1(boolean... zArr) {
        return zArr;
    }

    @Nullable
    public static char[] k2(@Nullable char[] cArr, int i, int i2) {
        return (char[]) x1(cArr, i, i2);
    }

    @Nullable
    public static double[] l(@Nullable double[] dArr, @Nullable double[] dArr2) {
        return (double[]) u1(dArr, dArr2);
    }

    public static boolean l0(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @NonNull
    public static byte[] l1(byte... bArr) {
        return bArr;
    }

    @Nullable
    public static double[] l2(@Nullable double[] dArr, int i, int i2) {
        return (double[]) x1(dArr, i, i2);
    }

    @NonNull
    public static float[] m(@Nullable float[] fArr, float f) {
        return (float[]) v1(fArr, Float.valueOf(f), Float.TYPE);
    }

    public static boolean m0(@Nullable Object[] objArr, @Nullable Object[] objArr2) {
        return Arrays.deepEquals(objArr, objArr2);
    }

    @NonNull
    public static char[] m1(char... cArr) {
        return cArr;
    }

    @Nullable
    public static float[] m2(@Nullable float[] fArr, int i, int i2) {
        return (float[]) x1(fArr, i, i2);
    }

    @NonNull
    public static float[] n(@Nullable float[] fArr, int i, float f) {
        return (float[]) s1(fArr, i, Float.valueOf(f), Float.TYPE);
    }

    public static boolean n0(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @NonNull
    public static double[] n1(double... dArr) {
        return dArr;
    }

    @Nullable
    public static int[] n2(@Nullable int[] iArr, int i, int i2) {
        return (int[]) x1(iArr, i, i2);
    }

    @Nullable
    public static float[] o(@Nullable float[] fArr, int i, @Nullable float[] fArr2) {
        Object objT1 = t1(fArr, i, fArr2, Float.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (float[]) objT1;
    }

    public static boolean o0(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @NonNull
    public static float[] o1(float... fArr) {
        return fArr;
    }

    @Nullable
    public static long[] o2(@Nullable long[] jArr, int i, int i2) {
        return (long[]) x1(jArr, i, i2);
    }

    @Nullable
    public static float[] p(@Nullable float[] fArr, @Nullable float[] fArr2) {
        return (float[]) u1(fArr, fArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void p0(@Nullable Object obj, @Nullable Closure<E> closure) {
        if (obj == null || closure == 0) {
            return;
        }
        int i = 0;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i < length) {
                closure.a(i, objArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length2 = zArr.length;
            while (i < length2) {
                closure.a(i, zArr[i] ? Boolean.TRUE : Boolean.FALSE);
                i++;
            }
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length3 = bArr.length;
            while (i < length3) {
                closure.a(i, Byte.valueOf(bArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length4 = cArr.length;
            while (i < length4) {
                closure.a(i, Character.valueOf(cArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length5 = sArr.length;
            while (i < length5) {
                closure.a(i, Short.valueOf(sArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length6 = iArr.length;
            while (i < length6) {
                closure.a(i, Integer.valueOf(iArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            while (i < length7) {
                closure.a(i, Long.valueOf(jArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length8 = fArr.length;
            while (i < length8) {
                closure.a(i, Float.valueOf(fArr[i]));
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            throw new IllegalArgumentException("Not an array: " + obj.getClass());
        }
        double[] dArr = (double[]) obj;
        int length9 = dArr.length;
        while (i < length9) {
            closure.a(i, Double.valueOf(dArr[i]));
            i++;
        }
    }

    @NonNull
    public static int[] p1(int... iArr) {
        return iArr;
    }

    @Nullable
    public static <T> T[] p2(@Nullable T[] tArr, int i, int i2) {
        return (T[]) ((Object[]) x1(tArr, i, i2));
    }

    @NonNull
    public static int[] q(@Nullable int[] iArr, int i) {
        return (int[]) v1(iArr, Integer.valueOf(i), Integer.TYPE);
    }

    @Nullable
    public static Object q0(@Nullable Object obj, int i) {
        return r0(obj, i, null);
    }

    @NonNull
    public static long[] q1(long... jArr) {
        return jArr;
    }

    @Nullable
    public static short[] q2(@Nullable short[] sArr, int i, int i2) {
        return (short[]) x1(sArr, i, i2);
    }

    @NonNull
    public static int[] r(@Nullable int[] iArr, int i, int i2) {
        return (int[]) s1(iArr, i, Integer.valueOf(i2), Integer.TYPE);
    }

    @Nullable
    public static Object r0(@Nullable Object obj, int i, @Nullable Object obj2) {
        if (obj == null) {
            return obj2;
        }
        try {
            return Array.get(obj, i);
        } catch (Exception unused) {
            return obj2;
        }
    }

    @NonNull
    public static short[] r1(short... sArr) {
        return sArr;
    }

    @Nullable
    public static boolean[] r2(@Nullable boolean[] zArr, int i, int i2) {
        return (boolean[]) x1(zArr, i, i2);
    }

    @Nullable
    public static int[] s(@Nullable int[] iArr, int i, @Nullable int[] iArr2) {
        Object objT1 = t1(iArr, i, iArr2, Integer.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (int[]) objT1;
    }

    public static int s0(@Nullable Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    @NonNull
    public static Object s1(@Nullable Object obj, int i, @Nullable Object obj2, Class cls) {
        if (obj == null) {
            if (i == 0) {
                Object objNewInstance = Array.newInstance((Class<?>) cls, 1);
                Array.set(objNewInstance, 0, obj2);
                return objNewInstance;
            }
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: 0");
        }
        int length = Array.getLength(obj);
        if (i > length || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        Object objNewInstance2 = Array.newInstance((Class<?>) cls, length + 1);
        System.arraycopy(obj, 0, objNewInstance2, 0, i);
        Array.set(objNewInstance2, i, obj2);
        if (i < length) {
            System.arraycopy(obj, i, objNewInstance2, i + 1, length - i);
        }
        return objNewInstance2;
    }

    @Nullable
    public static Boolean[] s2(@Nullable boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return new Boolean[0];
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = zArr[i] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    @Nullable
    public static int[] t(@Nullable int[] iArr, @Nullable int[] iArr2) {
        return (int[]) u1(iArr, iArr2);
    }

    public static int t0(@Nullable byte[] bArr, byte b) {
        return u0(bArr, b, 0);
    }

    @Nullable
    public static Object t1(@Nullable Object obj, int i, @Nullable Object obj2, Class cls) {
        if (obj == null && obj2 == null) {
            return null;
        }
        int iS0 = s0(obj);
        int iS1 = s0(obj2);
        if (iS0 == 0) {
            if (i == 0) {
                return w1(obj2);
            }
            throw new IndexOutOfBoundsException("Index: " + i + ", array1 Length: 0");
        }
        if (iS1 == 0) {
            return w1(obj);
        }
        if (i > iS0 || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", array1 Length: " + iS0);
        }
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iS0 + iS1);
        if (i == iS0) {
            System.arraycopy(obj, 0, objNewInstance, 0, iS0);
            System.arraycopy(obj2, 0, objNewInstance, iS0, iS1);
        } else if (i == 0) {
            System.arraycopy(obj2, 0, objNewInstance, 0, iS1);
            System.arraycopy(obj, 0, objNewInstance, iS1, iS0);
        } else {
            System.arraycopy(obj, 0, objNewInstance, 0, i);
            System.arraycopy(obj2, 0, objNewInstance, i, iS1);
            System.arraycopy(obj, i, objNewInstance, iS1 + i, iS0 - i);
        }
        return objNewInstance;
    }

    @Nullable
    public static Byte[] t2(@Nullable byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new Byte[0];
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new Byte(bArr[i]);
        }
        return bArr2;
    }

    @NonNull
    public static long[] u(@Nullable long[] jArr, int i, long j) {
        return (long[]) s1(jArr, i, Long.valueOf(j), Long.TYPE);
    }

    public static int u0(@Nullable byte[] bArr, byte b, int i) {
        if (bArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < bArr.length) {
            if (b == bArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Object u1(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        if (obj == null) {
            return w1(obj2);
        }
        if (obj2 == null) {
            return w1(obj);
        }
        int iS0 = s0(obj);
        int iS1 = s0(obj2);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iS0 + iS1);
        System.arraycopy(obj, 0, objNewInstance, 0, iS0);
        System.arraycopy(obj2, 0, objNewInstance, iS0, iS1);
        return objNewInstance;
    }

    @Nullable
    public static Character[] u2(@Nullable char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return new Character[0];
        }
        Character[] chArr = new Character[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            chArr[i] = new Character(cArr[i]);
        }
        return chArr;
    }

    @Nullable
    public static long[] v(@Nullable long[] jArr, int i, @Nullable long[] jArr2) {
        Object objT1 = t1(jArr, i, jArr2, Long.TYPE);
        if (objT1 == null) {
            return null;
        }
        return (long[]) objT1;
    }

    public static int v0(@Nullable char[] cArr, char c) {
        return w0(cArr, c, 0);
    }

    @NonNull
    public static Object v1(@Nullable Object obj, @Nullable Object obj2, Class cls) {
        Object objNewInstance;
        int i = 0;
        if (obj != null) {
            int iS0 = s0(obj);
            objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iS0 + 1);
            System.arraycopy(obj, 0, objNewInstance, 0, iS0);
            i = iS0;
        } else {
            objNewInstance = Array.newInstance((Class<?>) cls, 1);
        }
        Array.set(objNewInstance, i, obj2);
        return objNewInstance;
    }

    @Nullable
    public static Double[] v2(@Nullable double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new Double[0];
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = new Double(dArr[i]);
        }
        return dArr2;
    }

    @NonNull
    public static long[] w(@Nullable long[] jArr, long j) {
        return (long[]) v1(jArr, Long.valueOf(j), Long.TYPE);
    }

    public static int w0(@Nullable char[] cArr, char c, int i) {
        if (cArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < cArr.length) {
            if (c == cArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static Object w1(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return x1(obj, 0, s0(obj));
    }

    @Nullable
    public static Float[] w2(@Nullable float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new Float[0];
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = new Float(fArr[i]);
        }
        return fArr2;
    }

    @Nullable
    public static long[] x(@Nullable long[] jArr, @Nullable long[] jArr2) {
        return (long[]) u1(jArr, jArr2);
    }

    public static int x0(@Nullable double[] dArr, double d) {
        return z0(dArr, d, 0);
    }

    @Nullable
    public static Object x1(@Nullable Object obj, int i, int i2) {
        if (obj == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        int iS0 = s0(obj);
        if (i2 > iS0) {
            i2 = iS0;
        }
        int i3 = i2 - i;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i3 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object objNewInstance = Array.newInstance(componentType, i3);
        System.arraycopy(obj, i, objNewInstance, 0, i3);
        return objNewInstance;
    }

    @Nullable
    public static Integer[] x2(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = new Integer(iArr[i]);
        }
        return numArr;
    }

    @NonNull
    public static <T> T[] y(@Nullable T[] tArr, int i, @Nullable T t) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else {
            if (t == null) {
                T[] tArr2 = (T[]) new Object[1];
                tArr2[0] = null;
                return tArr2;
            }
            componentType = t.getClass();
        }
        return (T[]) ((Object[]) s1(tArr, i, t, componentType));
    }

    public static int y0(@Nullable double[] dArr, double d, double d2) {
        return A0(dArr, d, 0, d2);
    }

    @NonNull
    public static Object y1(@NonNull Object obj, int i) {
        int iS0 = s0(obj);
        if (i < 0 || i >= iS0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + iS0);
        }
        int i2 = iS0 - 1;
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i2);
        System.arraycopy(obj, 0, objNewInstance, 0, i);
        if (i < i2) {
            System.arraycopy(obj, i + 1, objNewInstance, i, (iS0 - i) - 1);
        }
        return objNewInstance;
    }

    @Nullable
    public static Long[] y2(@Nullable long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return new Long[0];
        }
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = new Long(jArr[i]);
        }
        return lArr;
    }

    @Nullable
    public static <T> T[] z(@Nullable T[] tArr, int i, @Nullable T[] tArr2) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else {
            if (tArr2 == null) {
                return null;
            }
            componentType = tArr2.getClass().getComponentType();
        }
        return (T[]) ((Object[]) t1(tArr, i, tArr2, componentType));
    }

    public static int z0(@Nullable double[] dArr, double d, int i) {
        if (N0(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < dArr.length) {
            if (d == dArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public static byte[] z1(@Nullable byte[] bArr, int i) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) y1(bArr, i);
    }

    @Nullable
    public static Short[] z2(@Nullable short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return new Short[0];
        }
        Short[] shArr = new Short[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            shArr[i] = new Short(sArr[i]);
        }
        return shArr;
    }
}
