package com.google.zxing.qrcode.detector;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.zj.adlib.ah3;
import com.zj.adlib.ch3;
import com.zj.adlib.tv0;
import com.zj.adlib.xg7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FinderPatternFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32532a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final EstimatedModuleComparator f6781a = new EstimatedModuleComparator();
    public static final int b = 3;
    public static final int c = 97;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ResultPointCallback f6782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f6783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<ah3> f6784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f6786a;

    public static final class EstimatedModuleComparator implements Comparator<ah3>, Serializable {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ah3 ah3Var, ah3 ah3Var2) {
            return Float.compare(ah3Var.i(), ah3Var2.i());
        }
    }

    public FinderPatternFinder(tv0 tv0Var) {
        this(tv0Var, null);
    }

    public static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void doClearCounts(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    public static void doShiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public static boolean foundPatternDiagonal(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public static double j(ah3 ah3Var, ah3 ah3Var2) {
        double dC = ah3Var.c() - ah3Var2.c();
        double d = ah3Var.d() - ah3Var2.d();
        return (dC * dC) + (d * d);
    }

    public final boolean b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] iArrG = g();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.f6783a.k(i2 - i6, i - i6)) {
            iArrG[2] = iArrG[2] + 1;
            i6++;
        }
        if (iArrG[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.f6783a.k(i2 - i6, i - i6)) {
            iArrG[1] = iArrG[1] + 1;
            i6++;
        }
        if (iArrG[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.f6783a.k(i2 - i6, i - i6)) {
            iArrG[0] = iArrG[0] + 1;
            i6++;
        }
        if (iArrG[0] == 0) {
            return false;
        }
        int iO = this.f6783a.o();
        int iT = this.f6783a.t();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= iO || (i5 = i2 + i7) >= iT || !this.f6783a.k(i5, i8)) {
                break;
            }
            iArrG[2] = iArrG[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= iO || (i4 = i2 + i7) >= iT || this.f6783a.k(i4, i9)) {
                break;
            }
            iArrG[3] = iArrG[3] + 1;
            i7++;
        }
        if (iArrG[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= iO || (i3 = i2 + i7) >= iT || !this.f6783a.k(i3, i10)) {
                break;
            }
            iArrG[4] = iArrG[4] + 1;
            i7++;
        }
        if (iArrG[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(iArrG);
    }

    public final float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        tv0 tv0Var = this.f6783a;
        int iT = tv0Var.t();
        int[] iArrG = g();
        int i8 = i;
        while (i8 >= 0 && tv0Var.k(i8, i2)) {
            iArrG[2] = iArrG[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !tv0Var.k(i8, i2)) {
            int i9 = iArrG[1];
            if (i9 > i3) {
                break;
            }
            iArrG[1] = i9 + 1;
            i8--;
        }
        if (i8 < 0 || iArrG[1] > i3) {
            return Float.NaN;
        }
        while (i8 >= 0 && tv0Var.k(i8, i2) && (i7 = iArrG[0]) <= i3) {
            iArrG[0] = i7 + 1;
            i8--;
        }
        if (iArrG[0] > i3) {
            return Float.NaN;
        }
        int i10 = i + 1;
        while (i10 < iT && tv0Var.k(i10, i2)) {
            iArrG[2] = iArrG[2] + 1;
            i10++;
        }
        if (i10 == iT) {
            return Float.NaN;
        }
        while (i10 < iT && !tv0Var.k(i10, i2) && (i6 = iArrG[3]) < i3) {
            iArrG[3] = i6 + 1;
            i10++;
        }
        if (i10 == iT || iArrG[3] >= i3) {
            return Float.NaN;
        }
        while (i10 < iT && tv0Var.k(i10, i2) && (i5 = iArrG[4]) < i3) {
            iArrG[4] = i5 + 1;
            i10++;
        }
        int i11 = iArrG[4];
        if (i11 < i3 && Math.abs(((((iArrG[0] + iArrG[1]) + iArrG[2]) + iArrG[3]) + i11) - i4) * 5 < i4 && foundPatternCross(iArrG)) {
            return a(iArrG, i10);
        }
        return Float.NaN;
    }

    @Deprecated
    public final void clearCounts(int[] iArr) {
        doClearCounts(iArr);
    }

    public final float d(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        tv0 tv0Var = this.f6783a;
        int iO = tv0Var.o();
        int[] iArrG = g();
        int i8 = i;
        while (i8 >= 0 && tv0Var.k(i2, i8)) {
            iArrG[2] = iArrG[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !tv0Var.k(i2, i8)) {
            int i9 = iArrG[1];
            if (i9 > i3) {
                break;
            }
            iArrG[1] = i9 + 1;
            i8--;
        }
        if (i8 < 0 || iArrG[1] > i3) {
            return Float.NaN;
        }
        while (i8 >= 0 && tv0Var.k(i2, i8) && (i7 = iArrG[0]) <= i3) {
            iArrG[0] = i7 + 1;
            i8--;
        }
        if (iArrG[0] > i3) {
            return Float.NaN;
        }
        int i10 = i + 1;
        while (i10 < iO && tv0Var.k(i2, i10)) {
            iArrG[2] = iArrG[2] + 1;
            i10++;
        }
        if (i10 == iO) {
            return Float.NaN;
        }
        while (i10 < iO && !tv0Var.k(i2, i10) && (i6 = iArrG[3]) < i3) {
            iArrG[3] = i6 + 1;
            i10++;
        }
        if (i10 == iO || iArrG[3] >= i3) {
            return Float.NaN;
        }
        while (i10 < iO && tv0Var.k(i2, i10) && (i5 = iArrG[4]) < i3) {
            iArrG[4] = i5 + 1;
            i10++;
        }
        int i11 = iArrG[4];
        if (i11 < i3 && Math.abs(((((iArrG[0] + iArrG[1]) + iArrG[2]) + iArrG[3]) + i11) - i4) * 5 < i4 * 2 && foundPatternCross(iArrG)) {
            return a(iArrG, i10);
        }
        return Float.NaN;
    }

    public final ch3 e(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int iO = this.f6783a.o();
        int iT = this.f6783a.t();
        int i = (iO * 3) / MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zH = false;
        while (i2 < iO && !zH) {
            doClearCounts(iArr);
            int i3 = 0;
            int i4 = 0;
            while (i3 < iT) {
                if (this.f6783a.k(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i3)) {
                    if (this.f6785a) {
                        zH = h();
                    } else {
                        int iF = f();
                        int i5 = iArr[2];
                        if (iF > i5) {
                            i2 += (iF - i5) - 2;
                            i3 = iT - 1;
                        }
                    }
                    doClearCounts(iArr);
                    i = 2;
                    i4 = 0;
                } else {
                    doShiftCounts2(iArr);
                    i4 = 3;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, iT)) {
                i = iArr[0];
                if (this.f6785a) {
                    zH = h();
                }
            }
            i2 += i;
        }
        ah3[] ah3VarArrI = i();
        xg7.e(ah3VarArrI);
        return new ch3(ah3VarArrI);
    }

    public final int f() {
        if (this.f6784a.size() <= 1) {
            return 0;
        }
        ah3 ah3Var = null;
        for (ah3 ah3Var2 : this.f6784a) {
            if (ah3Var2.h() >= 2) {
                if (ah3Var != null) {
                    this.f6785a = true;
                    return ((int) (Math.abs(ah3Var.c() - ah3Var2.c()) - Math.abs(ah3Var.d() - ah3Var2.d()))) / 2;
                }
                ah3Var = ah3Var2;
            }
        }
        return 0;
    }

    public final int[] g() {
        doClearCounts(this.f6786a);
        return this.f6786a;
    }

    public final tv0 getImage() {
        return this.f6783a;
    }

    public final List<ah3> getPossibleCenters() {
        return this.f6784a;
    }

    public final boolean h() {
        int size = this.f6784a.size();
        float fAbs = 0.0f;
        int i = 0;
        float fI = 0.0f;
        for (ah3 ah3Var : this.f6784a) {
            if (ah3Var.h() >= 2) {
                i++;
                fI += ah3Var.i();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = fI / size;
        Iterator<ah3> it = this.f6784a.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().i() - f);
        }
        return fAbs <= fI * 0.05f;
    }

    @Deprecated
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        return handlePossibleCenter(iArr, i, i2);
    }

    public final ah3[] i() throws NotFoundException {
        double d;
        if (this.f6784a.size() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.f6784a.sort(f6781a);
        ah3[] ah3VarArr = new ah3[3];
        int i = 0;
        double d2 = Double.MAX_VALUE;
        while (i < this.f6784a.size() - 2) {
            ah3 ah3Var = this.f6784a.get(i);
            float fI = ah3Var.i();
            i++;
            int i2 = i;
            while (i2 < this.f6784a.size() - 1) {
                ah3 ah3Var2 = this.f6784a.get(i2);
                double dJ = j(ah3Var, ah3Var2);
                i2++;
                for (int i3 = i2; i3 < this.f6784a.size(); i3++) {
                    ah3 ah3Var3 = this.f6784a.get(i3);
                    if (ah3Var3.i() <= 1.4f * fI) {
                        double dJ2 = j(ah3Var2, ah3Var3);
                        double dJ3 = j(ah3Var, ah3Var3);
                        if (dJ >= dJ2) {
                            if (dJ2 >= dJ3) {
                                d = dJ3;
                                dJ3 = dJ2;
                            } else if (dJ < dJ3) {
                                d = dJ2;
                                dJ2 = dJ3;
                                dJ3 = dJ;
                            } else {
                                d = dJ2;
                            }
                            dJ2 = dJ;
                        } else if (dJ2 <= dJ3) {
                            d = dJ;
                            dJ2 = dJ3;
                            dJ3 = dJ2;
                        } else if (dJ < dJ3) {
                            d = dJ;
                        } else {
                            d = dJ3;
                            dJ3 = dJ;
                        }
                        double dAbs = Math.abs(dJ2 - (dJ3 * 2.0d)) + Math.abs(dJ2 - (d * 2.0d));
                        if (dAbs < d2) {
                            ah3VarArr[0] = ah3Var;
                            ah3VarArr[1] = ah3Var2;
                            ah3VarArr[2] = ah3Var3;
                            d2 = dAbs;
                        }
                    }
                }
            }
        }
        if (d2 != Double.MAX_VALUE) {
            return ah3VarArr;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Deprecated
    public final void shiftCounts2(int[] iArr) {
        doShiftCounts2(iArr);
    }

    public FinderPatternFinder(tv0 tv0Var, ResultPointCallback resultPointCallback) {
        this.f6783a = tv0Var;
        this.f6784a = new ArrayList();
        this.f6786a = new int[5];
        this.f6782a = resultPointCallback;
    }

    public final boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i2);
        float fD = d(i, iA, iArr[2], i3);
        if (!Float.isNaN(fD)) {
            int i4 = (int) fD;
            float fC = c(iA, i4, iArr[2], i3);
            if (!Float.isNaN(fC) && b(i4, (int) fC)) {
                float f = i3 / 7.0f;
                for (int i5 = 0; i5 < this.f6784a.size(); i5++) {
                    ah3 ah3Var = this.f6784a.get(i5);
                    if (ah3Var.f(f, fD, fC)) {
                        this.f6784a.set(i5, ah3Var.g(fD, fC, f));
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    ah3 ah3Var2 = new ah3(fC, fD, f);
                    this.f6784a.add(ah3Var2);
                    ResultPointCallback resultPointCallback = this.f6782a;
                    if (resultPointCallback != null) {
                        resultPointCallback.a(ah3Var2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
