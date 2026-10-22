package com.zj.adlib;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class sl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f44710a = 0.42f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f19599a = 3;
    public static final float b = 0.8f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f19601b = 5;
    public static final int c = 25;
    public static final int d = 5;
    public static final int e = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f19600a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f19602b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f19603c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int[] f19604d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static void a(xg7[] xg7VarArr, xg7[] xg7VarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            xg7VarArr[iArr[i]] = xg7VarArr2[i];
        }
    }

    public static mh6 b(jv0 jv0Var, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        tv0 tv0VarB = jv0Var.b();
        List<xg7[]> listC = c(z, tv0VarB);
        for (int i = 0; listC.isEmpty() && i < 3; i++) {
            tv0VarB = tv0VarB.clone();
            if (i != 1) {
                tv0VarB.x();
            } else {
                tv0VarB.y();
            }
            listC = c(z, tv0VarB);
        }
        return new mh6(tv0VarB, listC);
    }

    public static List<xg7[]> c(boolean z, tv0 tv0Var) {
        int iC;
        float fD;
        ArrayList<xg7[]> arrayList = new ArrayList();
        int iMax = 0;
        int i = 0;
        loop0: while (true) {
            int i2 = i;
            while (iMax < tv0Var.o()) {
                xg7[] xg7VarArrF = f(tv0Var, iMax, i);
                if (xg7VarArrF[0] == null && xg7VarArrF[3] == null) {
                    if (i2 == 0) {
                        break;
                    }
                    for (xg7[] xg7VarArr : arrayList) {
                        xg7 xg7Var = xg7VarArr[1];
                        if (xg7Var != null) {
                            iMax = (int) Math.max(iMax, xg7Var.d());
                        }
                        xg7 xg7Var2 = xg7VarArr[3];
                        if (xg7Var2 != null) {
                            iMax = Math.max(iMax, (int) xg7Var2.d());
                        }
                    }
                    iMax += 5;
                    i = 0;
                } else {
                    arrayList.add(xg7VarArrF);
                    if (!z) {
                        break loop0;
                    }
                    xg7 xg7Var3 = xg7VarArrF[2];
                    if (xg7Var3 != null) {
                        iC = (int) xg7Var3.c();
                        fD = xg7VarArrF[2].d();
                    } else {
                        iC = (int) xg7VarArrF[4].c();
                        fD = xg7VarArrF[4].d();
                    }
                    iMax = (int) fD;
                    i = iC;
                    i2 = 1;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    public static int[] d(tv0 tv0Var, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (tv0Var.k(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (tv0Var.k(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (g(iArr2, iArr) < 0.42f) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || g(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    public static xg7[] e(tv0 tv0Var, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        xg7[] xg7VarArr = new xg7[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                z = false;
                break;
            }
            int[] iArrD = d(tv0Var, i4, i7, i2, iArr, iArr2);
            if (iArrD != null) {
                int i8 = i7;
                int[] iArr3 = iArrD;
                int i9 = i8;
                while (true) {
                    if (i9 <= 0) {
                        i6 = i9;
                        break;
                    }
                    int i10 = i9 - 1;
                    int[] iArrD2 = d(tv0Var, i4, i10, i2, iArr, iArr2);
                    if (iArrD2 == null) {
                        i6 = i10 + 1;
                        break;
                    }
                    iArr3 = iArrD2;
                    i9 = i10;
                }
                float f = i6;
                xg7VarArr[0] = new xg7(iArr3[0], f);
                xg7VarArr[1] = new xg7(iArr3[1], f);
                z = true;
                i7 = i6;
                break;
            }
            i7 += 5;
        }
        int i11 = i7 + 1;
        if (z) {
            int[] iArr4 = {(int) xg7VarArr[0].c(), (int) xg7VarArr[1].c()};
            int i12 = i11;
            int i13 = 0;
            while (true) {
                if (i12 >= i) {
                    i5 = i13;
                    break;
                }
                i5 = i13;
                int[] iArrD3 = d(tv0Var, iArr4[0], i12, i2, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i13 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i13 = i5 + 1;
                }
                i12++;
            }
            i11 = i12 - (i5 + 1);
            float f2 = i11;
            xg7VarArr[2] = new xg7(iArr4[0], f2);
            xg7VarArr[3] = new xg7(iArr4[1], f2);
        }
        if (i11 - i7 < 10) {
            Arrays.fill(xg7VarArr, (Object) null);
        }
        return xg7VarArr;
    }

    public static xg7[] f(tv0 tv0Var, int i, int i2) {
        int iO = tv0Var.o();
        int iT = tv0Var.t();
        xg7[] xg7VarArr = new xg7[8];
        a(xg7VarArr, e(tv0Var, iO, iT, i, i2, f19603c), f19600a);
        xg7 xg7Var = xg7VarArr[4];
        if (xg7Var != null) {
            i2 = (int) xg7Var.c();
            i = (int) xg7VarArr[4].d();
        }
        a(xg7VarArr, e(tv0Var, iO, iT, i, i2, f19604d), f19602b);
        return xg7VarArr;
    }

    public static float g(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f = i;
        float f2 = f / i2;
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f5 = iArr2[i4] * f2;
            float f6 = i5;
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
