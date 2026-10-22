package com.zj.adlib;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class oh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f18629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f18630a;
    public final int b;

    public oh2(CharSequence charSequence, int i, int i2) {
        this.f18629a = charSequence;
        this.b = i;
        this.f43746a = i2;
        byte[] bArr = new byte[i * i2];
        this.f18630a = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final void a(int i) {
        i(this.f43746a - 1, 0, i, 1);
        i(this.f43746a - 1, 1, i, 2);
        i(this.f43746a - 1, 2, i, 3);
        i(0, this.b - 2, i, 4);
        i(0, this.b - 1, i, 5);
        i(1, this.b - 1, i, 6);
        i(2, this.b - 1, i, 7);
        i(3, this.b - 1, i, 8);
    }

    public final void b(int i) {
        i(this.f43746a - 3, 0, i, 1);
        i(this.f43746a - 2, 0, i, 2);
        i(this.f43746a - 1, 0, i, 3);
        i(0, this.b - 4, i, 4);
        i(0, this.b - 3, i, 5);
        i(0, this.b - 2, i, 6);
        i(0, this.b - 1, i, 7);
        i(1, this.b - 1, i, 8);
    }

    public final void c(int i) {
        i(this.f43746a - 3, 0, i, 1);
        i(this.f43746a - 2, 0, i, 2);
        i(this.f43746a - 1, 0, i, 3);
        i(0, this.b - 2, i, 4);
        i(0, this.b - 1, i, 5);
        i(1, this.b - 1, i, 6);
        i(2, this.b - 1, i, 7);
        i(3, this.b - 1, i, 8);
    }

    public final void d(int i) {
        i(this.f43746a - 1, 0, i, 1);
        i(this.f43746a - 1, this.b - 1, i, 2);
        i(0, this.b - 3, i, 3);
        i(0, this.b - 2, i, 4);
        i(0, this.b - 1, i, 5);
        i(1, this.b - 3, i, 6);
        i(1, this.b - 2, i, 7);
        i(1, this.b - 1, i, 8);
    }

    public final boolean e(int i, int i2) {
        return this.f18630a[(i2 * this.b) + i] == 1;
    }

    public final byte[] f() {
        return this.f18630a;
    }

    public final int g() {
        return this.b;
    }

    public final int h() {
        return this.f43746a;
    }

    public final void i(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f43746a;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.b;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        l(i2, i, (this.f18629a.charAt(i3) & (1 << (8 - i4))) != 0);
    }

    public final boolean j(int i, int i2) {
        return this.f18630a[(i2 * this.b) + i] < 0;
    }

    public final void k() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 4;
        while (true) {
            if (i5 == this.f43746a && i3 == 0) {
                a(i4);
                i4++;
            }
            if (i5 == this.f43746a - 2 && i3 == 0 && this.b % 4 != 0) {
                b(i4);
                i4++;
            }
            if (i5 == this.f43746a - 2 && i3 == 0 && this.b % 8 == 4) {
                c(i4);
                i4++;
            }
            if (i5 == this.f43746a + 4 && i3 == 2 && this.b % 8 == 0) {
                d(i4);
                i4++;
            }
            do {
                if (i5 < this.f43746a && i3 >= 0 && j(i3, i5)) {
                    m(i5, i3, i4);
                    i4++;
                }
                i5 -= 2;
                i3 += 2;
                if (i5 < 0) {
                    break;
                }
            } while (i3 < this.b);
            int i6 = i5 + 1;
            int i7 = i3 + 3;
            do {
                if (i6 >= 0 && i7 < this.b && j(i7, i6)) {
                    m(i6, i7, i4);
                    i4++;
                }
                i6 += 2;
                i7 -= 2;
                i = this.f43746a;
                if (i6 >= i) {
                    break;
                }
            } while (i7 >= 0);
            i5 = i6 + 3;
            i3 = i7 + 1;
            if (i5 >= i && i3 >= (i2 = this.b)) {
                break;
            }
        }
        if (j(i2 - 1, i - 1)) {
            l(this.b - 1, this.f43746a - 1, true);
            l(this.b - 2, this.f43746a - 2, true);
        }
    }

    public final void l(int i, int i2, boolean z) {
        this.f18630a[(i2 * this.b) + i] = z ? (byte) 1 : (byte) 0;
    }

    public final void m(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        i(i4, i5, i3, 1);
        int i6 = i2 - 1;
        i(i4, i6, i3, 2);
        int i7 = i - 1;
        i(i7, i5, i3, 3);
        i(i7, i6, i3, 4);
        i(i7, i2, i3, 5);
        i(i, i5, i3, 6);
        i(i, i6, i3, 7);
        i(i, i2, i3, 8);
    }
}
