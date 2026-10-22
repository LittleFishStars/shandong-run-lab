package com.zj.adlib;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class vv9 {
    public static final int g = 10;
    public static final int h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f20340a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public vv9(tv0 tv0Var) throws NotFoundException {
        this(tv0Var, 10, tv0Var.t() / 2, tv0Var.o() / 2);
    }

    public final xg7[] a(xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, xg7 xg7Var4) {
        float fC = xg7Var.c();
        float fD = xg7Var.d();
        float fC2 = xg7Var2.c();
        float fD2 = xg7Var2.d();
        float fC3 = xg7Var3.c();
        float fD3 = xg7Var3.d();
        float fC4 = xg7Var4.c();
        float fD4 = xg7Var4.d();
        return fC < ((float) this.b) / 2.0f ? new xg7[]{new xg7(fC4 - 1.0f, fD4 + 1.0f), new xg7(fC2 + 1.0f, fD2 + 1.0f), new xg7(fC3 - 1.0f, fD3 - 1.0f), new xg7(fC + 1.0f, fD - 1.0f)} : new xg7[]{new xg7(fC4 + 1.0f, fD4 + 1.0f), new xg7(fC2 + 1.0f, fD2 - 1.0f), new xg7(fC3 - 1.0f, fD3 + 1.0f), new xg7(fC - 1.0f, fD - 1.0f)};
    }

    public final boolean b(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f20340a.k(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f20340a.k(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public xg7[] c() throws NotFoundException {
        int i = this.c;
        int i2 = this.d;
        int i3 = this.f;
        int i4 = this.e;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        while (z6) {
            boolean z7 = false;
            boolean zB = true;
            while (true) {
                if ((!zB && z2) || i2 >= this.b) {
                    break;
                }
                zB = b(i3, i4, i2, false);
                if (zB) {
                    i2++;
                    z2 = true;
                    z7 = true;
                } else if (!z2) {
                    i2++;
                }
            }
            if (i2 < this.b) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z3) || i4 >= this.f45471a) {
                        break;
                    }
                    zB2 = b(i, i2, i4, true);
                    if (zB2) {
                        i4++;
                        z3 = true;
                        z7 = true;
                    } else if (!z3) {
                        i4++;
                    }
                }
                if (i4 < this.f45471a) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z4) || i < 0) {
                            break;
                        }
                        zB3 = b(i3, i4, i, false);
                        if (zB3) {
                            i--;
                            z4 = true;
                            z7 = true;
                        } else if (!z4) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z6 = z7;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z5) || i3 < 0) {
                                break;
                            }
                            zB4 = b(i, i2, i3, true);
                            if (zB4) {
                                i3--;
                                z6 = true;
                                z5 = true;
                            } else if (!z5) {
                                i3--;
                            }
                        }
                        if (i3 < 0) {
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        xg7 xg7VarD = null;
        xg7 xg7VarD2 = null;
        for (int i6 = 1; xg7VarD2 == null && i6 < i5; i6++) {
            xg7VarD2 = d(i, i4 - i6, i + i6, i4);
        }
        if (xg7VarD2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        xg7 xg7VarD3 = null;
        for (int i7 = 1; xg7VarD3 == null && i7 < i5; i7++) {
            xg7VarD3 = d(i, i3 + i7, i + i7, i3);
        }
        if (xg7VarD3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        xg7 xg7VarD4 = null;
        for (int i8 = 1; xg7VarD4 == null && i8 < i5; i8++) {
            xg7VarD4 = d(i2, i3 + i8, i2 - i8, i3);
        }
        if (xg7VarD4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i9 = 1; xg7VarD == null && i9 < i5; i9++) {
            xg7VarD = d(i2, i4 - i9, i2 - i9, i4);
        }
        if (xg7VarD != null) {
            return a(xg7VarD, xg7VarD2, xg7VarD4, xg7VarD3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final xg7 d(float f, float f2, float f3, float f4) {
        int iC = se5.c(se5.a(f, f2, f3, f4));
        float f5 = iC;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iC; i++) {
            float f8 = i;
            int iC2 = se5.c((f8 * f6) + f);
            int iC3 = se5.c((f8 * f7) + f2);
            if (this.f20340a.k(iC2, iC3)) {
                return new xg7(iC2, iC3);
            }
        }
        return null;
    }

    public vv9(tv0 tv0Var, int i, int i2, int i3) throws NotFoundException {
        this.f20340a = tv0Var;
        int iO = tv0Var.o();
        this.f45471a = iO;
        int iT = tv0Var.t();
        this.b = iT;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.c = i5;
        int i6 = i2 + i4;
        this.d = i6;
        int i7 = i3 - i4;
        this.f = i7;
        int i8 = i3 + i4;
        this.e = i8;
        if (i7 < 0 || i5 < 0 || i8 >= iO || i6 >= iT) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
