package com.zj.adlib;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class nu3 extends Binarizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43608a = 5;
    public static final int b = 3;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f18510b = new byte[0];
    public static final int c = 32;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f18511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f18512a;

    public nu3(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.f18511a = f18510b;
        this.f18512a = new int[32];
    }

    public static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i3 - 1;
        int i13 = -1;
        int i14 = i12;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i3 - i12) * (i2 - iArr[i12]);
            if (i16 > i13) {
                i14 = i12;
                i13 = i16;
            }
            i12--;
        }
        return i14 << 3;
    }

    @Override // com.google.zxing.Binarizer
    public Binarizer a(LuminanceSource luminanceSource) {
        return new nu3(luminanceSource);
    }

    @Override // com.google.zxing.Binarizer
    public tv0 b() throws NotFoundException {
        LuminanceSource luminanceSourceE = e();
        int iE = luminanceSourceE.e();
        int iB = luminanceSourceE.b();
        tv0 tv0Var = new tv0(iE, iB);
        h(iE);
        int[] iArr = this.f18512a;
        for (int i = 1; i < 5; i++) {
            byte[] bArrD = luminanceSourceE.d((iB * i) / 5, this.f18511a);
            int i2 = (iE * 4) / 5;
            for (int i3 = iE / 5; i3 < i2; i3++) {
                int i4 = (bArrD[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrC = luminanceSourceE.c();
        for (int i5 = 0; i5 < iB; i5++) {
            int i6 = i5 * iE;
            for (int i7 = 0; i7 < iE; i7++) {
                if ((bArrC[i6 + i7] & 255) < iG) {
                    tv0Var.z(i7, i5);
                }
            }
        }
        return tv0Var;
    }

    @Override // com.google.zxing.Binarizer
    public qv0 c(int i, qv0 qv0Var) throws NotFoundException {
        LuminanceSource luminanceSourceE = e();
        int iE = luminanceSourceE.e();
        if (qv0Var == null || qv0Var.s() < iE) {
            qv0Var = new qv0(iE);
        } else {
            qv0Var.h();
        }
        h(iE);
        byte[] bArrD = luminanceSourceE.d(i, this.f18511a);
        int[] iArr = this.f18512a;
        for (int i2 = 0; i2 < iE; i2++) {
            int i3 = (bArrD[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iG = g(iArr);
        if (iE < 3) {
            for (int i4 = 0; i4 < iE; i4++) {
                if ((bArrD[i4] & 255) < iG) {
                    qv0Var.y(i4);
                }
            }
        } else {
            int i5 = 1;
            int i6 = bArrD[0] & 255;
            int i7 = bArrD[1] & 255;
            while (i5 < iE - 1) {
                int i8 = i5 + 1;
                int i9 = bArrD[i8] & 255;
                if ((((i7 * 4) - i6) - i9) / 2 < iG) {
                    qv0Var.y(i5);
                }
                i6 = i7;
                i5 = i8;
                i7 = i9;
            }
        }
        return qv0Var;
    }

    public final void h(int i) {
        if (this.f18511a.length < i) {
            this.f18511a = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f18512a[i2] = 0;
        }
    }
}
