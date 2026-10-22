package com.zj.adlib;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class sh6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44692a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final w43 f19581a = new w43();
    public static final int b = 3;
    public static final int c = 512;

    public static tz0 a(pl2 pl2Var) throws NotFoundException {
        int[] iArrJ;
        if (pl2Var == null || (iArrJ = pl2Var.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrJ) {
            i2 += iP - i3;
            if (i3 > 0) {
                break;
            }
        }
        fn1[] fn1VarArrD = pl2Var.d();
        for (int i4 = 0; i2 > 0 && fn1VarArrD[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i5 = iArrJ[length];
            i += iP - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = fn1VarArrD.length - 1; i > 0 && fn1VarArrD[length2] == null; length2--) {
            i--;
        }
        return pl2Var.a().a(i2, i, pl2Var.k());
    }

    public static void b(nl2 nl2Var, cm0[][] cm0VarArr) throws NotFoundException {
        cm0 cm0Var = cm0VarArr[0][1];
        int[] iArrB = cm0Var.b();
        int iJ = (nl2Var.j() * nl2Var.l()) - r(nl2Var.k());
        if (iArrB.length == 0) {
            if (iJ < 1 || iJ > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            cm0Var.c(iJ);
            return;
        }
        if (iArrB[0] == iJ || iJ < 1 || iJ > 928) {
            return;
        }
        cm0Var.c(iJ);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    public static int c(tv0 tv0Var, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z) {
                    if (i6 >= i2) {
                        break;
                    }
                    if (z == tv0Var.k(i6, i4)) {
                        break;
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                } else {
                    if (i6 < i) {
                        break;
                    }
                    if (z == tv0Var.k(i6, i4)) {
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    public static boolean d(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    public static int e(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f19581a.a(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static cm0[][] f(nl2 nl2Var) {
        int iC;
        cm0[][] cm0VarArr = (cm0[][]) Array.newInstance((Class<?>) cm0.class, nl2Var.l(), nl2Var.j() + 2);
        for (cm0[] cm0VarArr2 : cm0VarArr) {
            int i = 0;
            while (true) {
                if (i < cm0VarArr2.length) {
                    cm0VarArr2[i] = new cm0();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (ol2 ol2Var : nl2Var.o()) {
            if (ol2Var != null) {
                for (fn1 fn1Var : ol2Var.d()) {
                    if (fn1Var != null && (iC = fn1Var.c()) >= 0 && iC < cm0VarArr.length) {
                        cm0VarArr[iC][i2].c(fn1Var.e());
                    }
                }
            }
            i2++;
        }
        return cm0VarArr;
    }

    public static q82 g(nl2 nl2Var) throws NotFoundException, ChecksumException, FormatException {
        cm0[][] cm0VarArrF = f(nl2Var);
        b(nl2Var, cm0VarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[nl2Var.l() * nl2Var.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < nl2Var.l(); i++) {
            int i2 = 0;
            while (i2 < nl2Var.j()) {
                int i3 = i2 + 1;
                int[] iArrB = cm0VarArrF[i][i3].b();
                int iJ = (nl2Var.j() * i) + i2;
                if (iArrB.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrB.length == 1) {
                    iArr[iJ] = iArrB[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrB);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return h(nl2Var.k(), iArr, lh6.c(arrayList), lh6.c(arrayList3), iArr2);
    }

    public static q82 h(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException, FormatException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return j(iArr, i, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
                i2 = i3;
            }
        }
    }

    public static q82 i(tv0 tv0Var, xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, xg7 xg7Var4, int i, int i2) throws NotFoundException, ChecksumException, FormatException {
        ol2 pl2Var;
        int i3;
        int i4;
        int i5;
        ol2 ol2Var;
        tz0 tz0Var = new tz0(tv0Var, xg7Var, xg7Var2, xg7Var3, xg7Var4);
        pl2 pl2VarS = null;
        boolean z = true;
        pl2 pl2VarS2 = null;
        boolean z2 = true;
        while (true) {
            tz0 tz0Var2 = tz0Var;
            if (xg7Var != null) {
                pl2VarS = s(tv0Var, tz0Var2, xg7Var, true, i, i2);
            }
            if (xg7Var3 != null) {
                pl2VarS2 = s(tv0Var, tz0Var2, xg7Var3, false, i, i2);
            }
            nl2 nl2VarV = v(pl2VarS, pl2VarS2);
            if (nl2VarV == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            tz0Var = nl2VarV.m();
            if (!z2 || tz0Var == null || (tz0Var.g() >= tz0Var2.g() && tz0Var.e() <= tz0Var2.e())) {
                nl2VarV.p(tz0Var2);
                int iJ = nl2VarV.j() + 1;
                nl2VarV.q(0, pl2VarS);
                nl2VarV.q(iJ, pl2VarS2);
                boolean z3 = pl2VarS != null;
                int iMin = i;
                int iMax = i2;
                int i6 = 1;
                while (i6 <= iJ) {
                    int i7 = z3 ? i6 : iJ - i6;
                    if (nl2VarV.n(i7) == null) {
                        if (i7 == 0 || i7 == iJ) {
                            pl2Var = new pl2(tz0Var2, i7 == 0 ? z : false);
                        } else {
                            pl2Var = new ol2(tz0Var2);
                        }
                        ol2 ol2Var2 = pl2Var;
                        nl2VarV.q(i7, ol2Var2);
                        int i8 = -1;
                        int iG = tz0Var2.g();
                        int i9 = -1;
                        while (iG <= tz0Var2.e()) {
                            int iT = t(nl2VarV, i7, iG, z3);
                            if (iT < 0 || iT > tz0Var2.d()) {
                                if (i9 == i8) {
                                    i4 = iG;
                                    i5 = i8;
                                    ol2Var = ol2Var2;
                                } else {
                                    i3 = i9;
                                }
                                i9 = i9;
                                iG = i4 + 1;
                                ol2Var2 = ol2Var;
                                i8 = i5;
                            } else {
                                i3 = iT;
                            }
                            int i10 = iG;
                            i5 = i8;
                            ol2Var = ol2Var2;
                            fn1 fn1VarK = k(tv0Var, tz0Var2.f(), tz0Var2.d(), z3, i3, i10, iMin, iMax);
                            i4 = i10;
                            if (fn1VarK != null) {
                                ol2Var.f(i4, fn1VarK);
                                iMin = Math.min(iMin, fn1VarK.f());
                                iMax = Math.max(iMax, fn1VarK.f());
                                i9 = i3;
                            } else {
                                i9 = i9;
                            }
                            iG = i4 + 1;
                            ol2Var2 = ol2Var;
                            i8 = i5;
                        }
                    }
                    i6++;
                    z = true;
                }
                return g(nl2VarV);
            }
            z2 = false;
        }
    }

    public static q82 j(int[] iArr, int i, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int iE = e(iArr, iArr2, i2);
        x(iArr, i2);
        q82 q82VarB = DecodedBitStreamParser.b(iArr, String.valueOf(i));
        q82VarB.n(Integer.valueOf(iE));
        q82VarB.m(Integer.valueOf(iArr2.length));
        return q82VarB;
    }

    public static fn1 k(tv0 tv0Var, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iD;
        int iB;
        int iC = c(tv0Var, i, i2, z, i3, i4);
        int[] iArrQ = q(tv0Var, i, i2, z, iC, i4);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = se5.d(iArrQ);
        if (z) {
            i7 = iC + iD2;
        } else {
            for (int i8 = 0; i8 < iArrQ.length / 2; i8++) {
                int i9 = iArrQ[i8];
                iArrQ[i8] = iArrQ[(iArrQ.length - 1) - i8];
                iArrQ[(iArrQ.length - 1) - i8] = i9;
            }
            iC -= iD2;
            i7 = iC;
        }
        if (d(iD2, i5, i6) && (iB = lh6.b((iD = kh6.d(iArrQ)))) != -1) {
            return new fn1(iC, i7, n(iD), iB);
        }
        return null;
    }

    public static yl0 l(pl2 pl2Var, pl2 pl2Var2) {
        yl0 yl0VarI;
        yl0 yl0VarI2;
        if (pl2Var == null || (yl0VarI = pl2Var.i()) == null) {
            if (pl2Var2 == null) {
                return null;
            }
            return pl2Var2.i();
        }
        if (pl2Var2 == null || (yl0VarI2 = pl2Var2.i()) == null || yl0VarI.a() == yl0VarI2.a() || yl0VarI.b() == yl0VarI2.b() || yl0VarI.c() == yl0VarI2.c()) {
            return yl0VarI;
        }
        return null;
    }

    public static int[] m(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    public static int n(int i) {
        return o(m(i));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    public static int[] q(tv0 tv0Var, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
                if (i6 < 8) {
                    break;
                    break;
                }
                if (tv0Var.k(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            } else {
                if (i3 >= i2) {
                    break;
                }
                if (i6 < 8) {
                    break;
                }
                if (tv0Var.k(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    public static int r(int i) {
        return 2 << i;
    }

    public static pl2 s(tv0 tv0Var, tz0 tz0Var, xg7 xg7Var, boolean z, int i, int i2) {
        pl2 pl2Var = new pl2(tz0Var, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iC = (int) xg7Var.c();
            for (int iD = (int) xg7Var.d(); iD <= tz0Var.e() && iD >= tz0Var.g(); iD += i4) {
                fn1 fn1VarK = k(tv0Var, 0, tv0Var.t(), z, iC, iD, i, i2);
                if (fn1VarK != null) {
                    pl2Var.f(iD, fn1VarK);
                    iC = z ? fn1VarK.d() : fn1VarK.b();
                }
            }
            i3++;
        }
        return pl2Var;
    }

    public static int t(nl2 nl2Var, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        fn1 fn1VarB = u(nl2Var, i4) ? nl2Var.n(i4).b(i2) : null;
        if (fn1VarB != null) {
            return z ? fn1VarB.b() : fn1VarB.d();
        }
        fn1 fn1VarC = nl2Var.n(i).c(i2);
        if (fn1VarC != null) {
            return z ? fn1VarC.d() : fn1VarC.b();
        }
        if (u(nl2Var, i4)) {
            fn1VarC = nl2Var.n(i4).c(i2);
        }
        if (fn1VarC != null) {
            return z ? fn1VarC.b() : fn1VarC.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!u(nl2Var, i)) {
                tz0 tz0VarM = nl2Var.m();
                return z ? tz0VarM.f() : tz0VarM.d();
            }
            for (fn1 fn1Var : nl2Var.n(i).d()) {
                if (fn1Var != null) {
                    return (z ? fn1Var.b() : fn1Var.d()) + (i3 * i5 * (fn1Var.b() - fn1Var.d()));
                }
            }
            i5++;
        }
    }

    public static boolean u(nl2 nl2Var, int i) {
        return i >= 0 && i <= nl2Var.j() + 1;
    }

    public static nl2 v(pl2 pl2Var, pl2 pl2Var2) throws NotFoundException {
        yl0 yl0VarL;
        if ((pl2Var == null && pl2Var2 == null) || (yl0VarL = l(pl2Var, pl2Var2)) == null) {
            return null;
        }
        return new nl2(yl0VarL, tz0.j(a(pl2Var), a(pl2Var2)));
    }

    public static String w(cm0[][] cm0VarArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < cm0VarArr.length; i++) {
            try {
                formatter.format("Row %2d: ", Integer.valueOf(i));
                int i2 = 0;
                while (true) {
                    cm0[] cm0VarArr2 = cm0VarArr[i];
                    if (i2 < cm0VarArr2.length) {
                        cm0 cm0Var = cm0VarArr2[i2];
                        if (cm0Var.b().length == 0) {
                            formatter.format("        ", null);
                        } else {
                            formatter.format("%4d(%2d)", Integer.valueOf(cm0Var.b()[0]), cm0Var.a(cm0Var.b()[0]));
                        }
                        i2++;
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    public static void x(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
