package com.zj.adlib;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.GridSampler;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class tl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResultPointCallback f44945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f19850a;

    public tl2(tv0 tv0Var) {
        this.f19850a = tv0Var;
    }

    public static int b(xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, float f) throws NotFoundException {
        int iC = ((se5.c(xg7.b(xg7Var, xg7Var2) / f) + se5.c(xg7.b(xg7Var, xg7Var3) / f)) / 2) + 7;
        int i = iC & 3;
        if (i == 0) {
            return iC + 1;
        }
        if (i == 2) {
            return iC - 1;
        }
        if (i != 3) {
            return iC;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static yp6 c(xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, xg7 xg7Var4, int i) {
        float fC;
        float fD;
        float f;
        float f2 = i - 3.5f;
        if (xg7Var4 != null) {
            fC = xg7Var4.c();
            fD = xg7Var4.d();
            f = f2 - 3.0f;
        } else {
            fC = (xg7Var2.c() - xg7Var.c()) + xg7Var3.c();
            fD = (xg7Var2.d() - xg7Var.d()) + xg7Var3.d();
            f = f2;
        }
        return yp6.b(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, xg7Var.c(), xg7Var.d(), xg7Var2.c(), xg7Var2.d(), fC, fD, xg7Var3.c(), xg7Var3.d());
    }

    public static tv0 f(tv0 tv0Var, yp6 yp6Var, int i) throws NotFoundException {
        return GridSampler.a().c(tv0Var, i, i, yp6Var);
    }

    public final float a(xg7 xg7Var, xg7 xg7Var2) {
        float fH = h((int) xg7Var.c(), (int) xg7Var.d(), (int) xg7Var2.c(), (int) xg7Var2.d());
        float fH2 = h((int) xg7Var2.c(), (int) xg7Var2.d(), (int) xg7Var.c(), (int) xg7Var.d());
        if (Float.isNaN(fH)) {
            return fH2 / 7.0f;
        }
        return Float.isNaN(fH2) ? fH / 7.0f : (fH + fH2) / 14.0f;
    }

    public final float calculateModuleSize(xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3) {
        return (a(xg7Var, xg7Var2) + a(xg7Var, xg7Var3)) / 2.0f;
    }

    public ul2 d() throws NotFoundException, FormatException {
        return e(null);
    }

    public final ul2 e(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f44945a = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return processFinderPatternInfo(new FinderPatternFinder(this.f19850a, this.f44945a).e(map));
    }

    public final d40 findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f19850a.t() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.f19850a.o() - 1, i2 + i3) - iMax2;
        if (iMin2 >= f3) {
            return new e40(this.f19850a, iMax, iMax2, iMin, iMin2, f, this.f44945a).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008f A[RETURN] */
    public final float g(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 1;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i11 = 2;
        int i12 = (-iAbs) / 2;
        int i13 = i5 < i7 ? 1 : -1;
        int i14 = i6 < i8 ? 1 : -1;
        int i15 = i7 + i13;
        int i16 = i5;
        int i17 = i6;
        int i18 = 0;
        while (i16 != i15) {
            if ((i18 == i10 ? i10 : 0) == this.f19850a.k(z ? i17 : i16, z ? i16 : i17)) {
                if (i18 == 2) {
                    return se5.b(i16, i17, i5, i6);
                }
                i18++;
            }
            i12 += iAbs2;
            if (i12 > 0) {
                if (i17 == i8) {
                    i9 = 2;
                    if (i18 == i9) {
                        return se5.b(i15, i8, i5, i6);
                    }
                    return Float.NaN;
                }
                i17 += i14;
                i12 -= iAbs;
            }
            i16 += i13;
            i15 = i15;
            z = z;
            i10 = 1;
            i11 = 2;
        }
        i15 = i15;
        i9 = i11;
        if (i18 == i9) {
            return se5.b(i15, i8, i5, i6);
        }
        return Float.NaN;
    }

    public final tv0 getImage() {
        return this.f19850a;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.f44945a;
    }

    public final float h(int i, int i2, int i3, int i4) {
        float fT;
        float fO;
        float fG = g(i, i2, i3, i4);
        int iT = i - (i3 - i);
        int iO = 0;
        if (iT < 0) {
            fT = i / (i - iT);
            iT = 0;
        } else if (iT >= this.f19850a.t()) {
            fT = ((this.f19850a.t() - 1) - i) / (iT - i);
            iT = this.f19850a.t() - 1;
        } else {
            fT = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * fT));
        if (i5 < 0) {
            fO = f / (i2 - i5);
        } else if (i5 >= this.f19850a.o()) {
            fO = ((this.f19850a.o() - 1) - i2) / (i5 - i2);
            iO = this.f19850a.o() - 1;
        } else {
            iO = i5;
            fO = 1.0f;
        }
        return (fG + g(i, i2, (int) (i + ((iT - i) * fO)), iO)) - 1.0f;
    }

    public final ul2 processFinderPatternInfo(ch3 ch3Var) throws NotFoundException, FormatException {
        d40 d40VarFindAlignmentInRegion;
        ah3 ah3VarB = ch3Var.b();
        ah3 ah3VarC = ch3Var.c();
        ah3 ah3VarA = ch3Var.a();
        float fCalculateModuleSize = calculateModuleSize(ah3VarB, ah3VarC, ah3VarA);
        if (fCalculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iB = b(ah3VarB, ah3VarC, ah3VarA, fCalculateModuleSize);
        lm9 lm9VarG = lm9.g(iB);
        int iE = lm9VarG.e() - 7;
        if (lm9VarG.d().length <= 0) {
            d40VarFindAlignmentInRegion = null;
            break;
        }
        float fC = (ah3VarC.c() - ah3VarB.c()) + ah3VarA.c();
        float fD = (ah3VarC.d() - ah3VarB.d()) + ah3VarA.d();
        float f = 1.0f - (3.0f / iE);
        int iC = (int) (ah3VarB.c() + ((fC - ah3VarB.c()) * f));
        int iD = (int) (ah3VarB.d() + (f * (fD - ah3VarB.d())));
        int i = 4;
        while (true) {
            if (i > 16) {
                d40VarFindAlignmentInRegion = null;
                break;
            }
            try {
                d40VarFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, iC, iD, i);
                break;
            } catch (NotFoundException unused) {
                i <<= 1;
            }
        }
        return new ul2(f(this.f19850a, c(ah3VarB, ah3VarC, ah3VarA, d40VarFindAlignmentInRegion, iB), iB), d40VarFindAlignmentInRegion == null ? new xg7[]{ah3VarA, ah3VarB, ah3VarC} : new xg7[]{ah3VarA, ah3VarB, ah3VarC, d40VarFindAlignmentInRegion});
    }
}
