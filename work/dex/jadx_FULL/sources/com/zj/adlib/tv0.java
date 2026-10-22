package com.zj.adlib;

import com.ipd.dsp.internal.i.q;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class tv0 implements Cloneable {
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f45011a;

    public tv0(int i) {
        this(i, i);
    }

    public static tv0 u(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i = -1;
        int length = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i2 > i3) {
                    if (i == -1) {
                        i = i2 - i3;
                    } else if (i2 - i3 != i) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i4++;
                    i3 = i2;
                }
                length++;
            } else {
                if (str.startsWith(str2, length)) {
                    length += str2.length();
                    zArr[i2] = true;
                } else {
                    if (!str.startsWith(str3, length)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(length));
                    }
                    length += str3.length();
                    zArr[i2] = false;
                }
                i2++;
            }
        }
        if (i2 > i3) {
            if (i == -1) {
                i = i2 - i3;
            } else if (i2 - i3 != i) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i4++;
        }
        tv0 tv0Var = new tv0(i, i4);
        for (int i5 = 0; i5 < i2; i5++) {
            if (zArr[i5]) {
                tv0Var.z(i5 % i, i5 / i);
            }
        }
        return tv0Var;
    }

    public static tv0 v(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        tv0 tv0Var = new tv0(length2, length);
        for (int i = 0; i < length; i++) {
            boolean[] zArr2 = zArr[i];
            for (int i2 = 0; i2 < length2; i2++) {
                if (zArr2[i2]) {
                    tv0Var.z(i2, i);
                }
            }
        }
        return tv0Var;
    }

    public void A(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.L || i5 > this.K) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.M * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.f45011a;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public void B(int i, qv0 qv0Var) {
        int[] iArrO = qv0Var.o();
        int[] iArr = this.f45011a;
        int i2 = this.M;
        System.arraycopy(iArrO, 0, iArr, i * i2, i2);
    }

    public String C(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String D(String str, String str2, String str3) {
        return a(str, str2, str3);
    }

    public void E(int i, int i2) {
        int i3 = (i2 * this.M) + (i / 32);
        int[] iArr = this.f45011a;
        iArr[i3] = (~(1 << (i & 31))) & iArr[i3];
    }

    public void F(tv0 tv0Var) {
        if (this.K != tv0Var.K || this.L != tv0Var.L || this.M != tv0Var.M) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        qv0 qv0Var = new qv0(this.K);
        for (int i = 0; i < this.L; i++) {
            int i2 = this.M * i;
            int[] iArrO = tv0Var.p(i, qv0Var).o();
            for (int i3 = 0; i3 < this.M; i3++) {
                int[] iArr = this.f45011a;
                int i4 = i2 + i3;
                iArr[i4] = iArr[i4] ^ iArrO[i3];
            }
        }
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.L * (this.K + 1));
        for (int i = 0; i < this.L; i++) {
            for (int i2 = 0; i2 < this.K; i2++) {
                sb.append(k(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f45011a.length;
        for (int i = 0; i < length; i++) {
            this.f45011a[i] = 0;
        }
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public tv0 clone() {
        return new tv0(this.K, this.L, this.M, (int[]) this.f45011a.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof tv0)) {
            return false;
        }
        tv0 tv0Var = (tv0) obj;
        return this.K == tv0Var.K && this.L == tv0Var.L && this.M == tv0Var.M && Arrays.equals(this.f45011a, tv0Var.f45011a);
    }

    public void h() {
        int length = this.f45011a.length;
        for (int i = 0; i < length; i++) {
            int[] iArr = this.f45011a;
            iArr[i] = ~iArr[i];
        }
    }

    public int hashCode() {
        int i = this.K;
        return (((((((i * 31) + i) * 31) + this.L) * 31) + this.M) * 31) + Arrays.hashCode(this.f45011a);
    }

    public void i(int i, int i2) {
        int i3 = (i2 * this.M) + (i / 32);
        int[] iArr = this.f45011a;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean k(int i, int i2) {
        return ((this.f45011a[(i2 * this.M) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public int[] l() {
        int length = this.f45011a.length - 1;
        while (length >= 0 && this.f45011a[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.M;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.f45011a[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] m() {
        int i = this.K;
        int i2 = this.L;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.L; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.M;
                if (i6 < i7) {
                    int i8 = this.f45011a[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 * 32;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public int o() {
        return this.L;
    }

    public qv0 p(int i, qv0 qv0Var) {
        if (qv0Var == null || qv0Var.s() < this.K) {
            qv0Var = new qv0(this.K);
        } else {
            qv0Var.h();
        }
        int i2 = i * this.M;
        for (int i3 = 0; i3 < this.M; i3++) {
            qv0Var.z(i3 * 32, this.f45011a[i2 + i3]);
        }
        return qv0Var;
    }

    public int r() {
        return this.M;
    }

    public int[] s() {
        int[] iArr;
        int i = 0;
        while (true) {
            iArr = this.f45011a;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i++;
        }
        if (i == iArr.length) {
            return null;
        }
        int i2 = this.M;
        int i3 = i / i2;
        int i4 = (i % i2) * 32;
        int i5 = iArr[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public int t() {
        return this.K;
    }

    public String toString() {
        return C("X ", q.a.i);
    }

    public void x() {
        qv0 qv0Var = new qv0(this.K);
        qv0 qv0Var2 = new qv0(this.K);
        int i = (this.L + 1) / 2;
        for (int i2 = 0; i2 < i; i2++) {
            qv0Var = p(i2, qv0Var);
            int i3 = (this.L - 1) - i2;
            qv0Var2 = p(i3, qv0Var2);
            qv0Var.x();
            qv0Var2.x();
            B(i2, qv0Var2);
            B(i3, qv0Var);
        }
    }

    public void y() {
        int i = this.L;
        int i2 = this.K;
        int i3 = (i + 31) / 32;
        int[] iArr = new int[i3 * i2];
        for (int i4 = 0; i4 < this.L; i4++) {
            for (int i5 = 0; i5 < this.K; i5++) {
                if (((this.f45011a[(this.M * i4) + (i5 / 32)] >>> (i5 & 31)) & 1) != 0) {
                    int i6 = (((i2 - 1) - i5) * i3) + (i4 / 32);
                    iArr[i6] = (1 << (i4 & 31)) | iArr[i6];
                }
            }
        }
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.f45011a = iArr;
    }

    public void z(int i, int i2) {
        int i3 = (i2 * this.M) + (i / 32);
        int[] iArr = this.f45011a;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public tv0(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.K = i;
        this.L = i2;
        int i3 = (i + 31) / 32;
        this.M = i3;
        this.f45011a = new int[i3 * i2];
    }

    public tv0(int i, int i2, int i3, int[] iArr) {
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.f45011a = iArr;
    }
}
