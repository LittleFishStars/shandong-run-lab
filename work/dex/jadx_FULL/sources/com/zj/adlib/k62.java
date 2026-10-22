package com.zj.adlib;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class k62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f17592a;

    public k62(int i, byte[] bArr) {
        this.f42748a = i;
        this.f17592a = bArr;
    }

    public static k62[] b(byte[] bArr, lm9 lm9Var, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != lm9Var.h()) {
            throw new IllegalArgumentException();
        }
        lm9.b bVarF = lm9Var.f(errorCorrectionLevel);
        lm9.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (lm9.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        k62[] k62VarArr = new k62[iA];
        int i = 0;
        for (lm9.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                k62VarArr[i] = new k62(iB, new byte[bVarF.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = k62VarArr[0].f17592a.length;
        int i3 = iA - 1;
        while (i3 >= 0 && k62VarArr[i3].f17592a.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int iB2 = length - bVarF.b();
        int i5 = 0;
        for (int i6 = 0; i6 < iB2; i6++) {
            int i7 = 0;
            while (i7 < i) {
                k62VarArr[i7].f17592a[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            k62VarArr[i8].f17592a[iB2] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = k62VarArr[0].f17592a.length;
        while (iB2 < length2) {
            int i9 = 0;
            while (i9 < i) {
                k62VarArr[i9].f17592a[i9 < i4 ? iB2 : iB2 + 1] = bArr[i5];
                i9++;
                i5++;
            }
            iB2++;
        }
        return k62VarArr;
    }

    public byte[] a() {
        return this.f17592a;
    }

    public int c() {
        return this.f42748a;
    }
}
