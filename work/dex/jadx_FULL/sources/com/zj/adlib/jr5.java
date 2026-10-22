package com.zj.adlib;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Deprecated
public final class jr5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42651a = 32;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f17465a;

    public jr5(tv0 tv0Var) {
        this.f17465a = tv0Var;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    /* JADX WARN: Code duplicated, block: B:40:0x0056  */
    /* JADX WARN: Code duplicated, block: B:67:0x002b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0031 A[EDGE_INSN: B:68:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:72:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:72:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0031 A[EDGE_INSN: B:71:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:72:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x001c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x001c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0067 A[EDGE_INSN: B:85:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:90:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0067 A[EDGE_INSN: B:87:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:90:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0067 A[EDGE_INSN: B:89:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:90:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0053 A[SYNTHETIC] */
    public final int[] a(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        tv0 tv0Var;
        int i6;
        tv0 tv0Var2;
        int i7 = (i3 + i4) / 2;
        int i8 = i7;
        while (i8 >= i3) {
            tv0 tv0Var3 = this.f17465a;
            if (!z) {
                if (!tv0Var3.k(i, i8)) {
                    i6 = i8;
                    while (true) {
                        i6--;
                        if (i6 >= i3) {
                            break;
                            break;
                        }
                        tv0Var2 = this.f17465a;
                        if (z) {
                            if (tv0Var2.k(i6, i)) {
                                break;
                                break;
                            }
                        } else if (tv0Var2.k(i, i6)) {
                            break;
                            break;
                        }
                    }
                    int i9 = i8 - i6;
                    if (i6 < i3) {
                        break;
                    }
                    break;
                    break;
                }
                i8--;
            } else if (tv0Var3.k(i8, i)) {
                i8--;
            } else {
                i6 = i8;
                while (true) {
                    i6--;
                    if (i6 >= i3) {
                        break;
                    }
                    tv0Var2 = this.f17465a;
                    if (z) {
                        if (tv0Var2.k(i6, i)) {
                            break;
                        }
                    } else if (tv0Var2.k(i, i6)) {
                        break;
                    }
                }
                int i10 = i8 - i6;
                if (i6 < i3 || i10 > i2) {
                    break;
                }
                i8 = i6;
            }
        }
        int i11 = i8 + 1;
        while (i7 < i4) {
            tv0 tv0Var4 = this.f17465a;
            if (!z) {
                if (!tv0Var4.k(i, i7)) {
                    i5 = i7;
                    while (true) {
                        i5++;
                        if (i5 < i4) {
                            break;
                            break;
                        }
                        tv0Var = this.f17465a;
                        if (z) {
                            if (tv0Var.k(i5, i)) {
                                break;
                                break;
                            }
                        } else if (tv0Var.k(i, i5)) {
                            break;
                            break;
                        }
                    }
                    int i12 = i5 - i7;
                    if (i5 >= i4) {
                        break;
                    }
                    break;
                    break;
                }
                i7++;
            } else if (tv0Var4.k(i7, i)) {
                i7++;
            } else {
                i5 = i7;
                while (true) {
                    i5++;
                    if (i5 < i4) {
                        break;
                    }
                    tv0Var = this.f17465a;
                    if (z) {
                        if (tv0Var.k(i5, i)) {
                            break;
                        }
                    } else if (tv0Var.k(i, i5)) {
                        break;
                    }
                }
                int i13 = i5 - i7;
                if (i5 >= i4 || i13 > i2) {
                    break;
                }
                i7 = i5;
            }
        }
        int i14 = i7 - 1;
        if (i14 > i11) {
            return new int[]{i11, i14};
        }
        return null;
    }

    public xg7[] b() throws NotFoundException {
        int iO = this.f17465a.o();
        int iT = this.f17465a.t();
        int i = iO / 2;
        int i2 = iT / 2;
        int iMax = Math.max(1, iO / 256);
        int iMax2 = Math.max(1, iT / 256);
        int i3 = -iMax;
        int i4 = i2 / 2;
        int iD = ((int) c(i2, 0, 0, iT, i, i3, 0, iO, i4).d()) - 1;
        int i5 = i / 2;
        xg7 xg7VarC = c(i2, -iMax2, 0, iT, i, 0, iD, iO, i5);
        int iC = ((int) xg7VarC.c()) - 1;
        xg7 xg7VarC2 = c(i2, iMax2, iC, iT, i, 0, iD, iO, i5);
        int iC2 = ((int) xg7VarC2.c()) + 1;
        xg7 xg7VarC3 = c(i2, 0, iC, iC2, i, iMax, iD, iO, i4);
        return new xg7[]{c(i2, 0, iC, iC2, i, i3, iD, ((int) xg7VarC3.d()) + 1, i2 / 4), xg7VarC, xg7VarC2, xg7VarC3};
    }

    public final xg7 c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int[] iArr = null;
        int i10 = i;
        int i11 = i5;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            int[] iArrA = i2 == 0 ? a(i11, i9, i3, i4, true) : a(i10, i9, i7, i8, false);
            if (iArrA == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i2 == 0) {
                    int i12 = i11 - i6;
                    int i13 = iArr[0];
                    if (i13 >= i) {
                        return new xg7(iArr[1], i12);
                    }
                    if (iArr[1] > i) {
                        return new xg7(iArr[i6 <= 0 ? (char) 1 : (char) 0], i12);
                    }
                    return new xg7(i13, i12);
                }
                int i14 = i10 - i2;
                int i15 = iArr[0];
                if (i15 >= i5) {
                    return new xg7(i14, iArr[1]);
                }
                if (iArr[1] > i5) {
                    return new xg7(i14, iArr[i2 >= 0 ? (char) 1 : (char) 0]);
                }
                return new xg7(i14, i15);
            }
            i11 += i6;
            i10 += i2;
            iArr = iArrA;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
