package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.zj.adlib.lm9;
import com.zj.adlib.tv0;
import com.zj.adlib.zk3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lm9 f32531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f6778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zk3 f6779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6780a;

    public a(tv0 tv0Var) throws FormatException {
        int iO = tv0Var.o();
        if (iO < 21 || (iO & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f6778a = tv0Var;
    }

    public final int a(int i, int i2, int i3) {
        return this.f6780a ? this.f6778a.k(i2, i) : this.f6778a.k(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.f6778a.t()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f6778a.o(); i3++) {
                if (this.f6778a.k(i, i3) != this.f6778a.k(i3, i)) {
                    this.f6778a.i(i3, i);
                    this.f6778a.i(i, i3);
                }
            }
            i = i2;
        }
    }

    public byte[] c() throws FormatException {
        zk3 zk3VarD = d();
        lm9 lm9VarE = e();
        DataMask dataMask = DataMask.values()[zk3VarD.c()];
        int iO = this.f6778a.o();
        dataMask.unmaskBitMatrix(this.f6778a, iO);
        tv0 tv0VarA = lm9VarE.a();
        byte[] bArr = new byte[lm9VarE.h()];
        int i = iO - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < iO; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!tv0VarA.k(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.f6778a.k(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == lm9VarE.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public zk3 d() throws FormatException {
        zk3 zk3Var = this.f6779a;
        if (zk3Var != null) {
            return zk3Var;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int iO = this.f6778a.o();
        int i3 = iO - 7;
        for (int i4 = iO - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = iO - 8; i5 < iO; i5++) {
            iA = a(i5, 8, iA);
        }
        zk3 zk3VarA = zk3.a(iA3, iA);
        this.f6779a = zk3VarA;
        if (zk3VarA != null) {
            return zk3VarA;
        }
        throw FormatException.getFormatInstance();
    }

    public lm9 e() throws FormatException {
        lm9 lm9Var = this.f32531a;
        if (lm9Var != null) {
            return lm9Var;
        }
        int iO = this.f6778a.o();
        int i = (iO - 17) / 4;
        if (i <= 6) {
            return lm9.i(i);
        }
        int i2 = iO - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iO - 9; i4 >= i2; i4--) {
                iA2 = a(i4, i3, iA2);
            }
        }
        lm9 lm9VarC = lm9.c(iA2);
        if (lm9VarC != null && lm9VarC.e() == iO) {
            this.f32531a = lm9VarC;
            return lm9VarC;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iO - 9; i6 >= i2; i6--) {
                iA = a(i5, i6, iA);
            }
        }
        lm9 lm9VarC2 = lm9.c(iA);
        if (lm9VarC2 == null || lm9VarC2.e() != iO) {
            throw FormatException.getFormatInstance();
        }
        this.f32531a = lm9VarC2;
        return lm9VarC2;
    }

    public void f() {
        if (this.f6779a == null) {
            return;
        }
        DataMask.values()[this.f6779a.c()].unmaskBitMatrix(this.f6778a, this.f6778a.o());
    }

    public void g(boolean z) {
        this.f32531a = null;
        this.f6779a = null;
        this.f6780a = z;
    }
}
