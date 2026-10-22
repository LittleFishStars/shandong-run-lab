package com.zj.adlib;

import com.google.zxing.LuminanceSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class es6 extends LuminanceSource {
    public static final int g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f41519a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public es6(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f41519a = bArr;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        if (z) {
            n(i5, i6);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource a(int i, int i2, int i3, int i4) {
        return new es6(this.f41519a, this.c, this.d, this.e + i, this.f + i2, i3, i4, false);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] c() {
        int iE = e();
        int iB = b();
        int i = this.c;
        if (iE == i && iB == this.d) {
            return this.f41519a;
        }
        int i2 = iE * iB;
        byte[] bArr = new byte[i2];
        int i3 = (this.f * i) + this.e;
        if (iE == i) {
            System.arraycopy(this.f41519a, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < iB; i4++) {
            System.arraycopy(this.f41519a, i3, bArr, i4 * iE, iE);
            i3 += this.c;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] d(int i, byte[] bArr) {
        if (i < 0 || i >= b()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int iE = e();
        if (bArr == null || bArr.length < iE) {
            bArr = new byte[iE];
        }
        System.arraycopy(this.f41519a, ((i + this.f) * this.c) + this.e, bArr, 0, iE);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean g() {
        return true;
    }

    public int k() {
        return b() / 2;
    }

    public int l() {
        return e() / 2;
    }

    public int[] m() {
        int iE = e() / 2;
        int iB = b() / 2;
        int[] iArr = new int[iE * iB];
        byte[] bArr = this.f41519a;
        int i = (this.f * this.c) + this.e;
        for (int i2 = 0; i2 < iB; i2++) {
            int i3 = i2 * iE;
            for (int i4 = 0; i4 < iE; i4++) {
                iArr[i3 + i4] = ((bArr[(i4 * 2) + i] & 255) * 65793) | (-16777216);
            }
            i += this.c * 2;
        }
        return iArr;
    }

    public final void n(int i, int i2) {
        byte[] bArr = this.f41519a;
        int i3 = (this.f * this.c) + this.e;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.c;
        }
    }
}
