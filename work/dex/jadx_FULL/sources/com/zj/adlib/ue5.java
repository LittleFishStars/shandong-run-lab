package com.zj.adlib;

import com.google.common.math.c;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ue5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45128a = 7973;
    public static final int b = 1335;
    public static final int c = 21522;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f20050a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[][] f20051b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[][] f20052c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, c.f6376a}};
    public static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(qv0 qv0Var, ErrorCorrectionLevel errorCorrectionLevel, lm9 lm9Var, int i, r51 r51Var) throws WriterException {
        c(r51Var);
        d(lm9Var, r51Var);
        l(errorCorrectionLevel, i, r51Var);
        s(lm9Var, r51Var);
        f(qv0Var, i, r51Var);
    }

    public static int b(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i2);
        int iN2 = i << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i2 << (n(iN2) - iN);
        }
        return iN2;
    }

    public static void c(r51 r51Var) {
        r51Var.a((byte) -1);
    }

    public static void d(lm9 lm9Var, r51 r51Var) throws WriterException {
        j(r51Var);
        e(r51Var);
        r(lm9Var, r51Var);
        k(r51Var);
    }

    public static void e(r51 r51Var) throws WriterException {
        if (r51Var.b(8, r51Var.d() - 8) == 0) {
            throw new WriterException();
        }
        r51Var.g(8, r51Var.d() - 8, 1);
    }

    public static void f(qv0 qv0Var, int i, r51 r51Var) throws WriterException {
        boolean zM;
        int iE = r51Var.e() - 1;
        int iD = r51Var.d() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < r51Var.d()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = iE - i4;
                    if (o(r51Var.b(i5, iD))) {
                        if (i2 < qv0Var.s()) {
                            zM = qv0Var.m(i2);
                            i2++;
                        } else {
                            zM = false;
                        }
                        if (i != -1 && i85.f(i, i5, iD)) {
                            zM = !zM;
                        }
                        r51Var.h(i5, iD, zM);
                    }
                }
                iD += i3;
            }
            i3 = -i3;
            iD += i3;
            iE -= 2;
        }
        if (i2 == qv0Var.s()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + '/' + qv0Var.s());
    }

    public static void g(int i, int i2, r51 r51Var) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!o(r51Var.b(i4, i2))) {
                throw new WriterException();
            }
            r51Var.g(i4, i2, 0);
        }
    }

    public static void h(int i, int i2, r51 r51Var) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f20051b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                r51Var.g(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void i(int i, int i2, r51 r51Var) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f20050a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                r51Var.g(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void j(r51 r51Var) throws WriterException {
        int length = f20050a[0].length;
        i(0, 0, r51Var);
        i(r51Var.e() - length, 0, r51Var);
        i(0, r51Var.e() - length, r51Var);
        g(0, 7, r51Var);
        g(r51Var.e() - 8, 7, r51Var);
        g(0, r51Var.e() - 8, r51Var);
        m(7, 0, r51Var);
        m((r51Var.d() - 7) - 1, 0, r51Var);
        m(7, r51Var.d() - 7, r51Var);
    }

    public static void k(r51 r51Var) {
        int i = 8;
        while (i < r51Var.e() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (o(r51Var.b(i, 6))) {
                r51Var.g(i, 6, i3);
            }
            if (o(r51Var.b(6, i))) {
                r51Var.g(6, i, i3);
            }
            i = i2;
        }
    }

    public static void l(ErrorCorrectionLevel errorCorrectionLevel, int i, r51 r51Var) throws WriterException {
        int iD;
        qv0 qv0Var = new qv0();
        p(errorCorrectionLevel, i, qv0Var);
        for (int i2 = 0; i2 < qv0Var.s(); i2++) {
            boolean zM = qv0Var.m((qv0Var.s() - 1) - i2);
            int[] iArr = d[i2];
            r51Var.h(iArr[0], iArr[1], zM);
            int iE = 8;
            if (i2 < 8) {
                iD = 8;
                iE = (r51Var.e() - i2) - 1;
            } else {
                iD = (r51Var.d() - 7) + (i2 - 8);
            }
            r51Var.h(iE, iD, zM);
        }
    }

    public static void m(int i, int i2, r51 r51Var) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!o(r51Var.b(i, i4))) {
                throw new WriterException();
            }
            r51Var.g(i, i4, 0);
        }
    }

    public static int n(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean o(int i) {
        return i == -1;
    }

    public static void p(ErrorCorrectionLevel errorCorrectionLevel, int i, qv0 qv0Var) throws WriterException {
        if (!b57.f(i)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i;
        qv0Var.d(bits, 5);
        qv0Var.d(b(bits, b), 10);
        qv0 qv0Var2 = new qv0();
        qv0Var2.d(21522, 15);
        qv0Var.C(qv0Var2);
        if (qv0Var.s() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + qv0Var.s());
    }

    public static void q(lm9 lm9Var, qv0 qv0Var) throws WriterException {
        qv0Var.d(lm9Var.j(), 6);
        qv0Var.d(b(lm9Var.j(), f45128a), 12);
        if (qv0Var.s() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + qv0Var.s());
    }

    public static void r(lm9 lm9Var, r51 r51Var) {
        if (lm9Var.j() < 2) {
            return;
        }
        int[] iArr = f20052c[lm9Var.j() - 1];
        for (int i : iArr) {
            if (i >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && o(r51Var.b(i2, i))) {
                        h(i2 - 2, i - 2, r51Var);
                    }
                }
            }
        }
    }

    public static void s(lm9 lm9Var, r51 r51Var) throws WriterException {
        if (lm9Var.j() < 7) {
            return;
        }
        qv0 qv0Var = new qv0();
        q(lm9Var, qv0Var);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean zM = qv0Var.m(i);
                i--;
                r51Var.h(i2, (r51Var.d() - 11) + i3, zM);
                r51Var.h((r51Var.d() - 11) + i3, i2, zM);
            }
        }
    }
}
