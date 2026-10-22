package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pm6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f18890a;
    public int b;
    public int c;

    public pm6(byte[] bArr, int i, int i2) {
        i(bArr, i, i2);
    }

    public final void a() {
        int i;
        int i2 = this.b;
        sb0.i(i2 >= 0 && (i2 < (i = this.f44014a) || (i2 == i && this.c == 0)));
    }

    public boolean b(int i) {
        int i2 = this.b;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.c + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f44014a) {
                break;
            }
            if (j(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f44014a;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean c() {
        int i = this.b;
        int i2 = this.c;
        int i3 = 0;
        while (this.b < this.f44014a && !d()) {
            i3++;
        }
        boolean z = this.b == this.f44014a;
        this.b = i;
        this.c = i2;
        return !z && b((i3 * 2) + 1);
    }

    public boolean d() {
        boolean z = (this.f18890a[this.b] & (128 >> this.c)) != 0;
        k();
        return z;
    }

    public int e(int i) {
        int i2;
        this.c += i;
        int i3 = 0;
        while (true) {
            i2 = this.c;
            int i4 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.c = i5;
            byte[] bArr = this.f18890a;
            int i6 = this.b;
            i3 |= (bArr[i6] & 255) << i5;
            if (!j(i6 + 1)) {
                i4 = 1;
            }
            this.b = i6 + i4;
        }
        byte[] bArr2 = this.f18890a;
        int i7 = this.b;
        int i8 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.c = 0;
            this.b = i7 + (j(i7 + 1) ? 2 : 1);
        }
        a();
        return i8;
    }

    public final int f() {
        int i = 0;
        while (!d()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? e(i) : 0);
    }

    public int g() {
        int iF = f();
        return (iF % 2 == 0 ? -1 : 1) * ((iF + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i, int i2) {
        this.f18890a = bArr;
        this.b = i;
        this.f44014a = i2;
        this.c = 0;
        a();
    }

    public final boolean j(int i) {
        if (2 <= i && i < this.f44014a) {
            byte[] bArr = this.f18890a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        int i = this.c + 1;
        this.c = i;
        if (i == 8) {
            this.c = 0;
            int i2 = this.b;
            this.b = i2 + (j(i2 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i) {
        int i2 = this.b;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.b = i4;
        int i5 = this.c + (i - (i3 * 8));
        this.c = i5;
        if (i5 > 7) {
            this.b = i4 + 1;
            this.c = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.b) {
                a();
                return;
            } else if (j(i2)) {
                this.b++;
                i2 += 2;
            }
        }
    }
}
