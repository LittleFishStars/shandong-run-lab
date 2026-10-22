package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class fr5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final er5 f41738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f16602a;

    public fr5(er5 er5Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f41738a = er5Var;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f16602a = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f16602a = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f16602a = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public fr5 a(fr5 fr5Var) {
        if (!this.f41738a.equals(fr5Var.f41738a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f()) {
            return fr5Var;
        }
        if (fr5Var.f()) {
            return this;
        }
        int[] iArr = this.f16602a;
        int[] iArr2 = fr5Var.f16602a;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.f41738a.a(iArr2[i - length], iArr[i]);
        }
        return new fr5(this.f41738a, iArr3);
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.f16602a) {
                iA = this.f41738a.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.f16602a;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            er5 er5Var = this.f41738a;
            iA2 = er5Var.a(er5Var.i(i, iA2), this.f16602a[i3]);
        }
        return iA2;
    }

    public int c(int i) {
        int[] iArr = this.f16602a;
        return iArr[(iArr.length - 1) - i];
    }

    public int[] d() {
        return this.f16602a;
    }

    public int e() {
        return this.f16602a.length - 1;
    }

    public boolean f() {
        return this.f16602a[0] == 0;
    }

    public fr5 g(int i) {
        if (i == 0) {
            return this.f41738a.f();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f16602a.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f41738a.i(this.f16602a[i2], i);
        }
        return new fr5(this.f41738a, iArr);
    }

    public fr5 h(fr5 fr5Var) {
        if (!this.f41738a.equals(fr5Var.f41738a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f() || fr5Var.f()) {
            return this.f41738a.f();
        }
        int[] iArr = this.f16602a;
        int length = iArr.length;
        int[] iArr2 = fr5Var.f16602a;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                er5 er5Var = this.f41738a;
                iArr3[i4] = er5Var.a(iArr3[i4], er5Var.i(i2, iArr2[i3]));
            }
        }
        return new fr5(this.f41738a, iArr3);
    }

    public fr5 i(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f41738a.f();
        }
        int length = this.f16602a.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f41738a.i(this.f16602a[i3], i2);
        }
        return new fr5(this.f41738a, iArr);
    }

    public fr5 j() {
        int length = this.f16602a.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f41738a.j(0, this.f16602a[i]);
        }
        return new fr5(this.f41738a, iArr);
    }

    public fr5 k(fr5 fr5Var) {
        if (this.f41738a.equals(fr5Var.f41738a)) {
            return fr5Var.f() ? this : a(fr5Var.j());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int iE = e(); iE >= 0; iE--) {
            int iC = c(iE);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iE == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iE != 0) {
                    if (iE == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iE);
                    }
                }
            }
        }
        return sb.toString();
    }
}
