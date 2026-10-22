package com.zj.adlib;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.b;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nm6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f18462a;
    public int b;
    public int c;

    public nm6() {
        this.f18462a = gj9.f16790a;
    }

    public final void a() {
        int i;
        int i2 = this.f43558a;
        sb0.i(i2 >= 0 && (i2 < (i = this.c) || (i2 == i && this.b == 0)));
    }

    public int b() {
        return ((this.c - this.f43558a) * 8) - this.b;
    }

    public void c() {
        if (this.b == 0) {
            return;
        }
        this.b = 0;
        this.f43558a++;
        a();
    }

    public int d() {
        sb0.i(this.b == 0);
        return this.f43558a;
    }

    public int e() {
        return (this.f43558a * 8) + this.b;
    }

    public void f(int i, int i2) {
        if (i2 < 32) {
            i &= (1 << i2) - 1;
        }
        int iMin = Math.min(8 - this.b, i2);
        int i3 = this.b;
        int i4 = (8 - i3) - iMin;
        int i5 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i3) | ((1 << i4) - 1);
        byte[] bArr = this.f18462a;
        int i6 = this.f43558a;
        byte b = (byte) (i5 & bArr[i6]);
        bArr[i6] = b;
        int i7 = i2 - iMin;
        bArr[i6] = (byte) (b | ((i >>> i7) << i4));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.f18462a[i8] = (byte) (i >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.f18462a;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i & ((1 << i7) - 1)) << i9) | b2);
        s(i2);
        a();
    }

    public boolean g() {
        boolean z = (this.f18462a[this.f43558a] & (128 >> this.b)) != 0;
        r();
        return z;
    }

    public int h(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.b += i;
        int i3 = 0;
        while (true) {
            i2 = this.b;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.b = i4;
            byte[] bArr = this.f18462a;
            int i5 = this.f43558a;
            this.f43558a = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.f18462a;
        int i6 = this.f43558a;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.b = 0;
            this.f43558a = i6 + 1;
        }
        a();
        return i7;
    }

    public void i(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.f18462a;
            int i4 = this.f43558a;
            int i5 = i4 + 1;
            this.f43558a = i5;
            byte b = bArr2[i4];
            int i6 = this.b;
            byte b2 = (byte) (b << i6);
            bArr[i] = b2;
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | b2);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        byte b3 = (byte) (bArr[i3] & (255 >> i7));
        bArr[i3] = b3;
        int i8 = this.b;
        if (i8 + i7 > 8) {
            byte[] bArr3 = this.f18462a;
            int i9 = this.f43558a;
            this.f43558a = i9 + 1;
            bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
            this.b = i8 - 8;
        }
        int i10 = this.b + i7;
        this.b = i10;
        byte[] bArr4 = this.f18462a;
        int i11 = this.f43558a;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.b = 0;
            this.f43558a = i11 + 1;
        }
        a();
    }

    public long j(int i) {
        return i <= 32 ? gj9.E1(h(i)) : gj9.D1(h(i - 32), h(32));
    }

    public void k(byte[] bArr, int i, int i2) {
        sb0.i(this.b == 0);
        System.arraycopy(this.f18462a, this.f43558a, bArr, i, i2);
        this.f43558a += i2;
        a();
    }

    public String l(int i) {
        return m(i, b.c);
    }

    public String m(int i, Charset charset) {
        byte[] bArr = new byte[i];
        k(bArr, 0, i);
        return new String(bArr, charset);
    }

    public void n(om6 om6Var) {
        p(om6Var.d(), om6Var.f());
        q(om6Var.e() * 8);
    }

    public void o(byte[] bArr) {
        p(bArr, bArr.length);
    }

    public void p(byte[] bArr, int i) {
        this.f18462a = bArr;
        this.f43558a = 0;
        this.b = 0;
        this.c = i;
    }

    public void q(int i) {
        int i2 = i / 8;
        this.f43558a = i2;
        this.b = i - (i2 * 8);
        a();
    }

    public void r() {
        int i = this.b + 1;
        this.b = i;
        if (i == 8) {
            this.b = 0;
            this.f43558a++;
        }
        a();
    }

    public void s(int i) {
        int i2 = i / 8;
        int i3 = this.f43558a + i2;
        this.f43558a = i3;
        int i4 = this.b + (i - (i2 * 8));
        this.b = i4;
        if (i4 > 7) {
            this.f43558a = i3 + 1;
            this.b = i4 - 8;
        }
        a();
    }

    public void t(int i) {
        sb0.i(this.b == 0);
        this.f43558a += i;
        a();
    }

    public nm6(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public nm6(byte[] bArr, int i) {
        this.f18462a = bArr;
        this.c = i;
    }
}
