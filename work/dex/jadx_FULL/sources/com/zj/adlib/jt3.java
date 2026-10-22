package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class jt3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final it3 f42668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f17498a;

    public jt3(it3 it3Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f42668a = it3Var;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f17498a = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f17498a = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f17498a = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public jt3 a(jt3 jt3Var) {
        if (!this.f42668a.equals(jt3Var.f42668a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return jt3Var;
        }
        if (jt3Var.g()) {
            return this;
        }
        int[] iArr = this.f17498a;
        int[] iArr2 = jt3Var.f17498a;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = it3.a(iArr2[i - length], iArr[i]);
        }
        return new jt3(this.f42668a, iArr3);
    }

    public jt3[] b(jt3 jt3Var) {
        if (!this.f42668a.equals(jt3Var.f42668a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (jt3Var.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        jt3 jt3VarG = this.f42668a.g();
        int iH = this.f42668a.h(jt3Var.d(jt3Var.f()));
        jt3 jt3VarA = this;
        while (jt3VarA.f() >= jt3Var.f() && !jt3VarA.g()) {
            int iF = jt3VarA.f() - jt3Var.f();
            int iJ = this.f42668a.j(jt3VarA.d(jt3VarA.f()), iH);
            jt3 jt3VarJ = jt3Var.j(iF, iJ);
            jt3VarG = jt3VarG.a(this.f42668a.b(iF, iJ));
            jt3VarA = jt3VarA.a(jt3VarJ);
        }
        return new jt3[]{jt3VarG, jt3VarA};
    }

    public int c(int i) {
        if (i == 0) {
            return d(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.f17498a) {
                iA = it3.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.f17498a;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = it3.a(this.f42668a.j(i, iA2), this.f17498a[i3]);
        }
        return iA2;
    }

    public int d(int i) {
        int[] iArr = this.f17498a;
        return iArr[(iArr.length - 1) - i];
    }

    public int[] e() {
        return this.f17498a;
    }

    public int f() {
        return this.f17498a.length - 1;
    }

    public boolean g() {
        return this.f17498a[0] == 0;
    }

    public jt3 h(int i) {
        if (i == 0) {
            return this.f42668a.g();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f17498a.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f42668a.j(this.f17498a[i2], i);
        }
        return new jt3(this.f42668a, iArr);
    }

    public jt3 i(jt3 jt3Var) {
        if (!this.f42668a.equals(jt3Var.f42668a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || jt3Var.g()) {
            return this.f42668a.g();
        }
        int[] iArr = this.f17498a;
        int length = iArr.length;
        int[] iArr2 = jt3Var.f17498a;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = it3.a(iArr3[i4], this.f42668a.j(i2, iArr2[i3]));
            }
        }
        return new jt3(this.f42668a, iArr3);
    }

    public jt3 j(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f42668a.g();
        }
        int length = this.f17498a.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f42668a.j(this.f17498a[i3], i2);
        }
        return new jt3(this.f42668a, iArr);
    }

    public String toString() {
        if (g()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    if (iF == f()) {
                        sb.append(c49.f40900a);
                    } else {
                        sb.append(" - ");
                    }
                    iD = -iD;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i = this.f42668a.i(iD);
                    if (i == 0) {
                        sb.append('1');
                    } else if (i == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iF);
                    }
                }
            }
        }
        return sb.toString();
    }
}
