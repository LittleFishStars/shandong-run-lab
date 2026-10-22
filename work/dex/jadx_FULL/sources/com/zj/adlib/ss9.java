package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ss9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f19643a;
    public int b;
    public int c;

    public ss9(byte[] bArr) {
        this.f19643a = bArr;
        this.f44766a = bArr.length;
    }

    public final void a() {
        int i;
        int i2 = this.b;
        sb0.i(i2 >= 0 && (i2 < (i = this.f44766a) || (i2 == i && this.c == 0)));
    }

    public int b() {
        return ((this.f44766a - this.b) * 8) - this.c;
    }

    public int c() {
        return (this.b * 8) + this.c;
    }

    public boolean d() {
        boolean z = (((this.f19643a[this.b] & 255) >> this.c) & 1) == 1;
        h(1);
        return z;
    }

    public int e(int i) {
        int i2 = this.b;
        int iMin = Math.min(i, 8 - this.c);
        int i3 = i2 + 1;
        int i4 = ((this.f19643a[i2] & 255) >> this.c) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.f19643a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        h(i);
        return i5;
    }

    public void f() {
        this.b = 0;
        this.c = 0;
    }

    public void g(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.c = i - (i2 * 8);
        a();
    }

    public void h(int i) {
        int i2 = i / 8;
        int i3 = this.b + i2;
        this.b = i3;
        int i4 = this.c + (i - (i2 * 8));
        this.c = i4;
        if (i4 > 7) {
            this.b = i3 + 1;
            this.c = i4 - 8;
        }
        a();
    }
}
