package com.zj.adlib;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class qv0 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f44304a = 0.75f;
    public static final int[] b = new int[0];
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f19174a;

    public qv0() {
        this.K = 0;
        this.f19174a = b;
    }

    public static int[] v(int i) {
        return new int[(i + 31) / 32];
    }

    public void A(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.K) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = 31;
            int i8 = i6 > i4 ? 0 : i & 31;
            if (i6 >= i5) {
                i7 = 31 & i3;
            }
            int i9 = (2 << i7) - (1 << i8);
            int[] iArr = this.f19174a;
            iArr[i6] = i9 | iArr[i6];
            i6++;
        }
    }

    public void B(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (m(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public void C(qv0 qv0Var) {
        if (this.K != qv0Var.K) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f19174a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ qv0Var.f19174a[i];
            i++;
        }
    }

    public void a(boolean z) {
        k(this.K + 1);
        if (z) {
            int[] iArr = this.f19174a;
            int i = this.K;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.K++;
    }

    public void b(qv0 qv0Var) {
        int i = qv0Var.K;
        k(this.K + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(qv0Var.m(i2));
        }
    }

    public void d(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i3 = this.K;
        k(i3 + i2);
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (((1 << i4) & i) != 0) {
                int[] iArr = this.f19174a;
                int i5 = i3 / 32;
                iArr[i5] = iArr[i5] | (1 << (i3 & 31));
            }
            i3++;
        }
        this.K = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qv0)) {
            return false;
        }
        qv0 qv0Var = (qv0) obj;
        return this.K == qv0Var.K && Arrays.equals(this.f19174a, qv0Var.f19174a);
    }

    public void h() {
        int length = this.f19174a.length;
        for (int i = 0; i < length; i++) {
            this.f19174a[i] = 0;
        }
    }

    public int hashCode() {
        return (this.K * 31) + Arrays.hashCode(this.f19174a);
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public qv0 clone() {
        return new qv0((int[]) this.f19174a.clone(), this.K);
    }

    public final void k(int i) {
        if (i > this.f19174a.length * 32) {
            int[] iArrV = v((int) Math.ceil(i / 0.75f));
            int[] iArr = this.f19174a;
            System.arraycopy(iArr, 0, iArrV, 0, iArr.length);
            this.f19174a = iArrV;
        }
    }

    public void l(int i) {
        int[] iArr = this.f19174a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public boolean m(int i) {
        return ((1 << (i & 31)) & this.f19174a[i / 32]) != 0;
    }

    public int[] o() {
        return this.f19174a;
    }

    public int p(int i) {
        int i2 = this.K;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & this.f19174a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f19174a;
            if (i3 == iArr.length) {
                return this.K;
            }
            i4 = iArr[i3];
        }
        return Math.min((i3 * 32) + Integer.numberOfTrailingZeros(i4), this.K);
    }

    public int r(int i) {
        int i2 = this.K;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & (~this.f19174a[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f19174a;
            if (i3 == iArr.length) {
                return this.K;
            }
            i4 = ~iArr[i3];
        }
        return Math.min((i3 * 32) + Integer.numberOfTrailingZeros(i4), this.K);
    }

    public int s() {
        return this.K;
    }

    public int t() {
        return (this.K + 7) / 8;
    }

    public String toString() {
        int i = this.K;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.K; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(m(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public boolean u(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.K) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i & 31));
            int i8 = this.f19174a[i6] & i7;
            if (!z) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public void x() {
        int[] iArr = new int[this.f19174a.length];
        int i = (this.K - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i - i3] = Integer.reverse(this.f19174a[i3]);
        }
        int i4 = this.K;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.f19174a = iArr;
    }

    public void y(int i) {
        int[] iArr = this.f19174a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void z(int i, int i2) {
        this.f19174a[i / 32] = i2;
    }

    public qv0(int i) {
        this.K = i;
        this.f19174a = v(i);
    }

    public qv0(int[] iArr, int i) {
        this.f19174a = iArr;
        this.K = i;
    }
}
