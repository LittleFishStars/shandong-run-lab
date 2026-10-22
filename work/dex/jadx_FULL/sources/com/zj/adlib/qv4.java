package com.zj.adlib;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class qv4 {
    public static final int r = -1;
    public static final int s = 12;
    public static final int t = 5003;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f19179a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int h;
    public int l;
    public int m;
    public int n;
    public int q;
    public int g = 12;
    public int i = 4096;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f19180a = new int[5003];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f19182b = new int[5003];
    public int j = 5003;
    public int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19178a = false;
    public int o = 0;
    public int p = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f19183c = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f19181b = new byte[256];

    public qv4(int width, int height, byte[] pixels, int color_depth) {
        this.f44307a = width;
        this.b = height;
        this.f19179a = pixels;
        this.c = Math.max(2, color_depth);
    }

    public final int a(int n_bits) {
        return (1 << n_bits) - 1;
    }

    public void b(byte c, OutputStream outs) throws IOException {
        byte[] bArr = this.f19181b;
        int i = this.q;
        int i2 = i + 1;
        this.q = i2;
        bArr[i] = c;
        if (i2 >= 254) {
            g(outs);
        }
    }

    public void c(OutputStream outs) throws IOException {
        d(this.j);
        int i = this.m;
        this.k = i + 2;
        this.f19178a = true;
        i(i, outs);
    }

    public void d(int hsize) {
        for (int i = 0; i < hsize; i++) {
            this.f19180a[i] = -1;
        }
    }

    public void e(int init_bits, OutputStream outs) throws IOException {
        this.l = init_bits;
        int i = 0;
        this.f19178a = false;
        this.f = init_bits;
        this.h = a(init_bits);
        int i2 = 1 << (init_bits - 1);
        this.m = i2;
        this.n = i2 + 1;
        this.k = i2 + 2;
        this.q = 0;
        int iH = h();
        for (int i3 = this.j; i3 < 65536; i3 *= 2) {
            i++;
        }
        int i4 = 8 - i;
        int i5 = this.j;
        d(i5);
        i(this.m, outs);
        while (true) {
            int iH2 = h();
            if (iH2 == -1) {
                i(iH, outs);
                i(this.n, outs);
                return;
            }
            int i6 = (iH2 << this.g) + iH;
            int i7 = (iH2 << i4) ^ iH;
            int i8 = this.f19180a[i7];
            if (i8 == i6) {
                iH = this.f19182b[i7];
            } else {
                if (i8 >= 0) {
                    int i9 = i5 - i7;
                    if (i7 == 0) {
                        i9 = 1;
                    }
                    while (true) {
                        i7 -= i9;
                        if (i7 < 0) {
                            i7 += i5;
                        }
                        int i10 = this.f19180a[i7];
                        if (i10 == i6) {
                            iH = this.f19182b[i7];
                        } else if (i10 < 0) {
                        }
                    }
                }
                i(iH, outs);
                int i11 = this.k;
                if (i11 < this.i) {
                    int[] iArr = this.f19182b;
                    this.k = i11 + 1;
                    iArr[i7] = i11;
                    this.f19180a[i7] = i6;
                } else {
                    c(outs);
                }
                iH = iH2;
            }
        }
    }

    public void f(OutputStream os) throws IOException {
        os.write(this.c);
        this.d = this.f44307a * this.b;
        this.e = 0;
        e(this.c + 1, os);
        os.write(0);
    }

    public void g(OutputStream outs) throws IOException {
        int i = this.q;
        if (i > 0) {
            outs.write(i);
            outs.write(this.f19181b, 0, this.q);
            this.q = 0;
        }
    }

    public final int h() {
        int i = this.d;
        if (i == 0) {
            return -1;
        }
        this.d = i - 1;
        byte[] bArr = this.f19179a;
        int i2 = this.e;
        this.e = i2 + 1;
        return bArr[i2] & 255;
    }

    public void i(int code, OutputStream outs) throws IOException {
        int i = this.o;
        int[] iArr = this.f19183c;
        int i2 = this.p;
        int i3 = i & iArr[i2];
        this.o = i3;
        if (i2 > 0) {
            this.o = i3 | (code << i2);
        } else {
            this.o = code;
        }
        this.p = i2 + this.f;
        while (this.p >= 8) {
            b((byte) (this.o & 255), outs);
            this.o >>= 8;
            this.p -= 8;
        }
        if (this.k > this.h || this.f19178a) {
            if (this.f19178a) {
                int i4 = this.l;
                this.f = i4;
                this.h = a(i4);
                this.f19178a = false;
            } else {
                int i5 = this.f + 1;
                this.f = i5;
                if (i5 == this.g) {
                    this.h = this.i;
                } else {
                    this.h = a(i5);
                }
            }
        }
        if (code == this.n) {
            while (this.p > 0) {
                b((byte) (this.o & 255), outs);
                this.o >>= 8;
                this.p -= 8;
            }
            g(outs);
        }
    }
}
