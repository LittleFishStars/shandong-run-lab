package com.zj.adlib;

import com.google.zxing.LuminanceSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b87 extends LuminanceSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f40697a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public b87(int i, int i2, int[] iArr) {
        super(i, i2);
        this.c = i;
        this.d = i2;
        this.e = 0;
        this.f = 0;
        int i3 = i * i2;
        this.f40697a = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.f40697a[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource a(int i, int i2, int i3, int i4) {
        return new b87(this.f40697a, this.c, this.d, this.e + i, this.f + i2, i3, i4);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] c() {
        int iE = e();
        int iB = b();
        int i = this.c;
        if (iE == i && iB == this.d) {
            return this.f40697a;
        }
        int i2 = iE * iB;
        byte[] bArr = new byte[i2];
        int i3 = (this.f * i) + this.e;
        if (iE == i) {
            System.arraycopy(this.f40697a, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < iB; i4++) {
            System.arraycopy(this.f40697a, i3, bArr, i4 * iE, iE);
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
        System.arraycopy(this.f40697a, ((i + this.f) * this.c) + this.e, bArr, 0, iE);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean g() {
        return true;
    }

    public b87(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 <= i && i6 + i4 <= i2) {
            this.f40697a = bArr;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
