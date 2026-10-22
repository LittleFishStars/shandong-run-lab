package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31193a = 2037673328;
    public static final int b = 1836279920;
    public static final int c = 1918990112;
    public static final int d = 1684433976;
    public static final int e = 1835365224;
    public static final int f = 1886547818;
    public static final int g = 10000;
    public static final int h = 32000;
    public static final int i = 128000;

    @Nullable
    public static Projection a(byte[] bArr, int i2) {
        ArrayList<Projection.a> arrayListF;
        om6 om6Var = new om6(bArr);
        try {
            arrayListF = c(om6Var) ? f(om6Var) : e(om6Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new Projection(arrayListF.get(0), i2);
        }
        if (size != 2) {
            return null;
        }
        return new Projection(arrayListF.get(0), arrayListF.get(1), i2);
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >> 1);
    }

    public static boolean c(om6 om6Var) {
        om6Var.T(4);
        int iO = om6Var.o();
        om6Var.S(0);
        return iO == 1886547818;
    }

    @Nullable
    public static Projection.a d(om6 om6Var) {
        int iO = om6Var.o();
        if (iO > 10000) {
            return null;
        }
        float[] fArr = new float[iO];
        for (int i2 = 0; i2 < iO; i2++) {
            fArr[i2] = om6Var.n();
        }
        int iO2 = om6Var.o();
        if (iO2 > 32000) {
            return null;
        }
        double d2 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iO) * 2.0d) / dLog);
        nm6 nm6Var = new nm6(om6Var.d());
        int i3 = 8;
        nm6Var.q(om6Var.e() * 8);
        float[] fArr2 = new float[iO2 * 5];
        int i4 = 5;
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < iO2) {
            int i7 = 0;
            while (i7 < i4) {
                int iB = iArr[i7] + b(nm6Var.h(iCeil));
                if (iB >= iO || iB < 0) {
                    return null;
                }
                fArr2[i6] = fArr[iB];
                iArr[i7] = iB;
                i7++;
                i6++;
                i4 = 5;
            }
            i5++;
            i4 = 5;
        }
        nm6Var.q((nm6Var.e() + 7) & (-8));
        int i8 = 32;
        int iH = nm6Var.h(32);
        Projection.b[] bVarArr = new Projection.b[iH];
        int i9 = 0;
        while (i9 < iH) {
            int iH2 = nm6Var.h(i3);
            int iH3 = nm6Var.h(i3);
            int iH4 = nm6Var.h(i8);
            if (iH4 > 128000) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(((double) iO2) * d2) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int iB2 = 0;
            for (int i10 = 0; i10 < iH4; i10++) {
                iB2 += b(nm6Var.h(iCeil2));
                if (iB2 < 0 || iB2 >= iO2) {
                    return null;
                }
                int i11 = i10 * 3;
                int i12 = iB2 * 5;
                fArr3[i11] = fArr2[i12];
                fArr3[i11 + 1] = fArr2[i12 + 1];
                fArr3[i11 + 2] = fArr2[i12 + 2];
                int i13 = i10 * 2;
                fArr4[i13] = fArr2[i12 + 3];
                fArr4[i13 + 1] = fArr2[i12 + 4];
            }
            bVarArr[i9] = new Projection.b(iH2, fArr3, fArr4, iH3);
            i9++;
            i8 = 32;
            d2 = 2.0d;
            i3 = 8;
        }
        return new Projection.a(bVarArr);
    }

    @Nullable
    public static ArrayList<Projection.a> e(om6 om6Var) {
        if (om6Var.G() != 0) {
            return null;
        }
        om6Var.T(7);
        int iO = om6Var.o();
        if (iO == 1684433976) {
            om6 om6Var2 = new om6();
            Inflater inflater = new Inflater(true);
            try {
                if (!gj9.G0(om6Var, om6Var2, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                om6Var = om6Var2;
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        } else if (iO != 1918990112) {
            return null;
        }
        return g(om6Var);
    }

    @Nullable
    public static ArrayList<Projection.a> f(om6 om6Var) {
        int iO;
        om6Var.T(8);
        int iE = om6Var.e();
        int iF = om6Var.f();
        while (iE < iF && (iO = om6Var.o() + iE) > iE && iO <= iF) {
            int iO2 = om6Var.o();
            if (iO2 == 2037673328 || iO2 == 1836279920) {
                om6Var.R(iO);
                return e(om6Var);
            }
            om6Var.S(iO);
            iE = iO;
        }
        return null;
    }

    @Nullable
    public static ArrayList<Projection.a> g(om6 om6Var) {
        ArrayList<Projection.a> arrayList = new ArrayList<>();
        int iE = om6Var.e();
        int iF = om6Var.f();
        while (iE < iF) {
            int iO = om6Var.o() + iE;
            if (iO <= iE || iO > iF) {
                return null;
            }
            if (om6Var.o() == 1835365224) {
                Projection.a aVarD = d(om6Var);
                if (aVarD == null) {
                    return null;
                }
                arrayList.add(aVarD);
            }
            om6Var.S(iO);
            iE = iO;
        }
        return arrayList;
    }
}
