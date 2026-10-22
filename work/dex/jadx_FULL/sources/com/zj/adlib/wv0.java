package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class wv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f20575a;
    public int b;

    public wv0(byte[] bArr) {
        this.f20575a = bArr;
    }

    public int a() {
        return ((this.f20575a.length - this.f45696a) * 8) - this.b;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f45696a;
    }

    public int d(int i) {
        if (i < 1 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.b;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int iMin = Math.min(i, i4);
            int i5 = i4 - iMin;
            byte[] bArr = this.f20575a;
            int i6 = this.f45696a;
            int i7 = (((255 >> (8 - iMin)) << i5) & bArr[i6]) >> i5;
            i -= iMin;
            int i8 = this.b + iMin;
            this.b = i8;
            if (i8 == 8) {
                this.b = 0;
                this.f45696a = i6 + 1;
            }
            i3 = i7;
        }
        if (i <= 0) {
            return i3;
        }
        while (i >= 8) {
            int i9 = i3 << 8;
            byte[] bArr2 = this.f20575a;
            int i10 = this.f45696a;
            i3 = (bArr2[i10] & 255) | i9;
            this.f45696a = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i3;
        }
        int i11 = 8 - i;
        int i12 = (i3 << i) | ((((255 >> i11) << i11) & this.f20575a[this.f45696a]) >> i11);
        this.b += i;
        return i12;
    }
}
