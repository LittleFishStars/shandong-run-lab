package com.zj.adlib;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hl8 {
    public static final int p = 65;
    public static final int q = 400;
    public static final int r = 4000;
    public static final int s = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f42155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final short[] f17018a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f17019b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public short[] f17020b;
    public final float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f17021c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public short[] f17022c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public short[] f17023d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public hl8(int i, int i2, float f, float f2, int i3) {
        this.f17017a = i;
        this.f17019b = i2;
        this.f42155a = f;
        this.b = f2;
        this.c = i / i3;
        this.f17021c = i / 400;
        int i4 = i / 65;
        this.d = i4;
        int i5 = i4 * 2;
        this.e = i5;
        this.f17018a = new short[i5];
        this.f17020b = new short[i5 * i2];
        this.f17022c = new short[i5 * i2];
        this.f17023d = new short[i5 * i2];
    }

    public static void p(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    public final void a(float f, int i) {
        int i2;
        int i3;
        if (this.g == i) {
            return;
        }
        int i4 = this.f17017a;
        int i5 = (int) (i4 / f);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        o(i);
        int i6 = 0;
        while (true) {
            int i7 = this.h;
            if (i6 >= i7 - 1) {
                u(i7 - 1);
                return;
            }
            while (true) {
                i2 = this.i;
                int i8 = (i2 + 1) * i5;
                i3 = this.j;
                if (i8 <= i3 * i4) {
                    break;
                }
                this.f17022c = f(this.f17022c, this.g, 1);
                int i9 = 0;
                while (true) {
                    int i10 = this.f17019b;
                    if (i9 < i10) {
                        this.f17022c[(this.g * i10) + i9] = n(this.f17023d, (i10 * i6) + i9, i4, i5);
                        i9++;
                    }
                }
                this.j++;
                this.g++;
            }
            int i11 = i2 + 1;
            this.i = i11;
            if (i11 == i4) {
                this.i = 0;
                sb0.i(i3 == i5);
                this.j = 0;
            }
            i6++;
        }
    }

    public final void b(float f) {
        int iW;
        int i = this.f;
        if (i < this.e) {
            return;
        }
        int i2 = 0;
        do {
            if (this.k > 0) {
                iW = c(i2);
            } else {
                int iG = g(this.f17020b, i2);
                iW = ((double) f) > 1.0d ? iG + w(this.f17020b, i2, f, iG) : m(this.f17020b, i2, f, iG);
            }
            i2 += iW;
        } while (this.e + i2 <= i);
        v(i2);
    }

    public final int c(int i) {
        int iMin = Math.min(this.e, this.k);
        d(this.f17020b, i, iMin);
        this.k -= iMin;
        return iMin;
    }

    public final void d(short[] sArr, int i, int i2) {
        short[] sArrF = f(this.f17022c, this.g, i2);
        this.f17022c = sArrF;
        int i3 = this.f17019b;
        System.arraycopy(sArr, i * i3, sArrF, this.g * i3, i3 * i2);
        this.g += i2;
    }

    public final void e(short[] sArr, int i, int i2) {
        int i3 = this.e / i2;
        int i4 = this.f17019b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f17018a[i7] = (short) (i8 / i5);
        }
    }

    public final short[] f(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.f17019b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int g(short[] sArr, int i) {
        int iH;
        int i2 = this.f17017a;
        int i3 = i2 > 4000 ? i2 / 4000 : 1;
        if (this.f17019b == 1 && i3 == 1) {
            iH = h(sArr, i, this.f17021c, this.d);
        } else {
            e(sArr, i, i3);
            int iH2 = h(this.f17018a, 0, this.f17021c / i3, this.d / i3);
            if (i3 != 1) {
                int i4 = iH2 * i3;
                int i5 = i3 * 4;
                int i6 = i4 - i5;
                int i7 = i4 + i5;
                int i8 = this.f17021c;
                if (i6 < i8) {
                    i6 = i8;
                }
                int i9 = this.d;
                if (i7 > i9) {
                    i7 = i9;
                }
                if (this.f17019b == 1) {
                    iH = h(sArr, i, i6, i7);
                } else {
                    e(sArr, i, 1);
                    iH = h(this.f17018a, 0, i6, i7);
                }
            } else {
                iH = iH2;
            }
        }
        int i10 = q(this.n, this.o) ? this.l : iH;
        this.m = this.n;
        this.l = iH;
        return i10;
    }

    public final int h(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f17019b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
            }
            if (iAbs * i7 < i6 * i2) {
                i7 = i2;
                i6 = iAbs;
            }
            if (iAbs * i5 > i8 * i2) {
                i5 = i2;
                i8 = iAbs;
            }
            i2++;
        }
        this.n = i6 / i7;
        this.o = i8 / i5;
        return i7;
    }

    public void i() {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f17019b, this.g);
        shortBuffer.put(this.f17022c, 0, this.f17019b * iMin);
        int i = this.g - iMin;
        this.g = i;
        short[] sArr = this.f17022c;
        int i2 = this.f17019b;
        System.arraycopy(sArr, iMin * i2, sArr, 0, i * i2);
    }

    public int k() {
        return this.g * this.f17019b * 2;
    }

    public int l() {
        return this.f * this.f17019b * 2;
    }

    public final int m(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.k = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        short[] sArrF = f(this.f17022c, this.g, i4);
        this.f17022c = sArrF;
        int i5 = this.f17019b;
        System.arraycopy(sArr, i * i5, sArrF, this.g * i5, i5 * i2);
        p(i3, this.f17019b, this.f17022c, this.g + i2, sArr, i + i2, sArr, i);
        this.g += i4;
        return i3;
    }

    public final short n(short[] sArr, int i, int i2, int i3) {
        short s2 = sArr[i];
        short s3 = sArr[i + this.f17019b];
        int i4 = this.j * i2;
        int i5 = this.i;
        int i6 = i5 * i3;
        int i7 = (i5 + 1) * i3;
        int i8 = i7 - i4;
        int i9 = i7 - i6;
        return (short) (((s2 * i8) + ((i9 - i8) * s3)) / i9);
    }

    public final void o(int i) {
        int i2 = this.g - i;
        short[] sArrF = f(this.f17023d, this.h, i2);
        this.f17023d = sArrF;
        short[] sArr = this.f17022c;
        int i3 = this.f17019b;
        System.arraycopy(sArr, i * i3, sArrF, this.h * i3, i3 * i2);
        this.g = i;
        this.h += i2;
    }

    public final boolean q(int i, int i2) {
        return i != 0 && this.l != 0 && i2 <= i * 3 && i * 2 > this.m * 3;
    }

    public final void r() {
        int i = this.g;
        float f = this.f42155a;
        float f2 = this.b;
        float f3 = f / f2;
        float f4 = this.c * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            b(f3);
        } else {
            d(this.f17020b, 0, this.f);
            this.f = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
    }

    public void s() {
        int i;
        int i2 = this.f;
        float f = this.f42155a;
        float f2 = this.b;
        int i3 = this.g + ((int) ((((i2 / (f / f2)) + this.h) / (this.c * f2)) + 0.5f));
        this.f17020b = f(this.f17020b, i2, (this.e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.e;
            int i5 = this.f17019b;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.f17020b[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.f += i * 2;
        r();
        if (this.g > i3) {
            this.g = i3;
        }
        this.f = 0;
        this.k = 0;
        this.h = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.f17019b;
        int i2 = iRemaining / i;
        short[] sArrF = f(this.f17020b, this.f, i2);
        this.f17020b = sArrF;
        shortBuffer.get(sArrF, this.f * this.f17019b, ((i * i2) * 2) / 2);
        this.f += i2;
        r();
    }

    public final void u(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.f17023d;
        int i2 = this.f17019b;
        System.arraycopy(sArr, i * i2, sArr, 0, (this.h - i) * i2);
        this.h -= i;
    }

    public final void v(int i) {
        int i2 = this.f - i;
        short[] sArr = this.f17020b;
        int i3 = this.f17019b;
        System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.f = i2;
    }

    public final int w(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.k = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        short[] sArrF = f(this.f17022c, this.g, i3);
        this.f17022c = sArrF;
        p(i3, this.f17019b, sArrF, this.g, sArr, i, sArr, i + i2);
        this.g += i3;
        return i3;
    }
}
