package com.byazt.jx;

import com.zj.adlib.go6;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 15})
public class uj {
    public final float[] c;
    public final int[] tt;

    public uj(float[] fArr, int[] iArr) {
        this.c = fArr;
        this.tt = iArr;
    }

    public float[] c() {
        return this.c;
    }

    public int[] tt() {
        return this.tt;
    }

    public int ve() {
        return this.tt.length;
    }

    public void c(uj ujVar, uj ujVar2, float f) {
        if (ujVar.tt.length == ujVar2.tt.length) {
            for (int i = 0; i < ujVar.tt.length; i++) {
                this.c[i] = com.byazt.kk.i.c(ujVar.c[i], ujVar2.c[i], f);
                this.tt[i] = com.byazt.kk.uj.c(f, ujVar.tt[i], ujVar2.tt[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + ujVar.tt.length + " vs " + ujVar2.tt.length + ")");
    }

    public uj c(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = c(fArr[i]);
        }
        return new uj(fArr, iArr);
    }

    private int c(float f) {
        int iBinarySearch = Arrays.binarySearch(this.c, f);
        if (iBinarySearch >= 0) {
            return this.tt[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.tt[0];
        }
        int[] iArr = this.tt;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.c;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.byazt.kk.uj.c((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
