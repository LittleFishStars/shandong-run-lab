package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.common.base.b;
import com.ipd.dsp.internal.q.u;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class om6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f18674a;
    public int b;

    public om6() {
        this.f18674a = gj9.f16790a;
    }

    @Nullable
    public String A() {
        return l((char) 0);
    }

    public String B(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f43778a;
        int i3 = (i2 + i) - 1;
        String strJ = gj9.J(this.f18674a, i2, (i3 >= this.b || this.f18674a[i3] != 0) ? i : i - 1);
        this.f43778a += i;
        return strJ;
    }

    public short C() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.f43778a = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public String D(int i) {
        return E(i, b.c);
    }

    public String E(int i, Charset charset) {
        String str = new String(this.f18674a, this.f43778a, i, charset);
        this.f43778a += i;
        return str;
    }

    public int F() {
        return (G() << 21) | (G() << 14) | (G() << 7) | G();
    }

    public int G() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        this.f43778a = i + 1;
        return bArr[i] & 255;
    }

    public int H() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.f43778a = i2 + 1 + 2;
        return i3;
    }

    public long I() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16) | ((((long) bArr[i3]) & 255) << 8);
        this.f43778a = i4 + 1;
        return j2 | (((long) bArr[i4]) & 255);
    }

    public int J() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        this.f43778a = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public int K() {
        int iO = o();
        if (iO >= 0) {
            return iO;
        }
        throw new IllegalStateException("Top bit not zero: " + iO);
    }

    public long L() {
        long jZ = z();
        if (jZ >= 0) {
            return jZ;
        }
        throw new IllegalStateException("Top bit not zero: " + jZ);
    }

    public int M() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.f43778a = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    public long N() {
        int i;
        int i2;
        long j = this.f18674a[this.f43778a];
        int i3 = 7;
        while (true) {
            if (i3 >= 0) {
                int i4 = 1 << i3;
                if ((((long) i4) & j) == 0) {
                    if (i3 < 6) {
                        j &= (long) (i4 - 1);
                        i2 = 7 - i3;
                        break;
                    }
                    if (i3 == 7) {
                        i2 = 1;
                        break;
                    }
                } else {
                    i3--;
                }
            }
            i2 = 0;
            break;
        }
        if (i2 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i = 1; i < i2; i++) {
            byte b = this.f18674a[this.f43778a + i];
            if ((b & u.n7) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | ((long) (b & 63));
        }
        this.f43778a += i2;
        return j;
    }

    public void O(int i) {
        Q(b() < i ? new byte[i] : this.f18674a, i);
    }

    public void P(byte[] bArr) {
        Q(bArr, bArr.length);
    }

    public void Q(byte[] bArr, int i) {
        this.f18674a = bArr;
        this.b = i;
        this.f43778a = 0;
    }

    public void R(int i) {
        sb0.a(i >= 0 && i <= this.f18674a.length);
        this.b = i;
    }

    public void S(int i) {
        sb0.a(i >= 0 && i <= this.b);
        this.f43778a = i;
    }

    public void T(int i) {
        S(this.f43778a + i);
    }

    public int a() {
        return this.b - this.f43778a;
    }

    public int b() {
        return this.f18674a.length;
    }

    public void c(int i) {
        if (i > b()) {
            this.f18674a = Arrays.copyOf(this.f18674a, i);
        }
    }

    public byte[] d() {
        return this.f18674a;
    }

    public int e() {
        return this.f43778a;
    }

    public int f() {
        return this.b;
    }

    public char g() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int h() {
        return this.f18674a[this.f43778a] & 255;
    }

    public void i(nm6 nm6Var, int i) {
        k(nm6Var.f18462a, 0, i);
        nm6Var.q(0);
    }

    public void j(ByteBuffer byteBuffer, int i) {
        byteBuffer.put(this.f18674a, this.f43778a, i);
        this.f43778a += i;
    }

    public void k(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f18674a, this.f43778a, bArr, i, i2);
        this.f43778a += i2;
    }

    @Nullable
    public String l(char c) {
        if (a() == 0) {
            return null;
        }
        int i = this.f43778a;
        while (i < this.b && this.f18674a[i] != c) {
            i++;
        }
        byte[] bArr = this.f18674a;
        int i2 = this.f43778a;
        String strJ = gj9.J(bArr, i2, i - i2);
        this.f43778a = i;
        if (i < this.b) {
            this.f43778a = i + 1;
        }
        return strJ;
    }

    public double m() {
        return Double.longBitsToDouble(z());
    }

    public float n() {
        return Float.intBitsToFloat(o());
    }

    public int o() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.f43778a = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public int p() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (((bArr[i] & 255) << 24) >> 8) | ((bArr[i2] & 255) << 8);
        this.f43778a = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    @Nullable
    public String q() {
        if (a() == 0) {
            return null;
        }
        int i = this.f43778a;
        while (i < this.b && !gj9.K0(this.f18674a[i])) {
            i++;
        }
        int i2 = this.f43778a;
        if (i - i2 >= 3) {
            byte[] bArr = this.f18674a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f43778a = i2 + 3;
            }
        }
        byte[] bArr2 = this.f18674a;
        int i3 = this.f43778a;
        String strJ = gj9.J(bArr2, i3, i - i3);
        this.f43778a = i;
        int i4 = this.b;
        if (i == i4) {
            return strJ;
        }
        byte[] bArr3 = this.f18674a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.f43778a = i5;
            if (i5 == i4) {
                return strJ;
            }
        }
        int i6 = this.f43778a;
        if (bArr3[i6] == 10) {
            this.f43778a = i6 + 1;
        }
        return strJ;
    }

    public int r() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.f43778a = i5 + 1;
        return ((bArr[i5] & 255) << 24) | i6;
    }

    public int s() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        this.f43778a = i3 + 1;
        return ((bArr[i3] & 255) << 16) | i4;
    }

    public long t() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 48);
        this.f43778a = i8 + 1;
        return j6 | ((((long) bArr[i8]) & 255) << 56);
    }

    public short u() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.f43778a = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public long v() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        this.f43778a = i4 + 1;
        return j2 | ((((long) bArr[i4]) & 255) << 24);
    }

    public int w() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        this.f43778a = i3 + 1;
        return ((bArr[i3] & 255) << 16) | i4;
    }

    public int x() {
        int iR = r();
        if (iR >= 0) {
            return iR;
        }
        throw new IllegalStateException("Top bit not zero: " + iR);
    }

    public int y() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.f43778a = i2 + 1;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public long z() {
        byte[] bArr = this.f18674a;
        int i = this.f43778a;
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 8);
        this.f43778a = i8 + 1;
        return j6 | (((long) bArr[i8]) & 255);
    }

    public om6(int i) {
        this.f18674a = new byte[i];
        this.b = i;
    }

    public om6(byte[] bArr) {
        this.f18674a = bArr;
        this.b = bArr.length;
    }

    public om6(byte[] bArr, int i) {
        this.f18674a = bArr;
        this.b = i;
    }
}
