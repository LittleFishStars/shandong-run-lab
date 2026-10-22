package com.byazt.biq;

import android.content.Context;
import com.byazt.aas.pf;
import com.byazt.dna.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 13})
public final class tt {
    public static float[] c(Context context, float f, int i) {
        float fMin;
        float fMax;
        float[] fArr = new float[2];
        float fUj = pf.uj(context, pf.x(context));
        float fUj2 = pf.uj(context, pf.i(context));
        if (i == 2) {
            fMin = Math.max(fUj, fUj2);
            fMax = Math.min(fUj, fUj2);
        } else {
            fMin = Math.min(fUj, fUj2);
            fMax = Math.max(fUj, fUj2);
        }
        int iUj = pf.uj(context, pf.da(context));
        if (pf.tt() || f != 100.0f) {
            if (i != 2) {
                fMax -= iUj;
            } else {
                if ("SM-A207F".equals(((u) com.byazt.ut.uj.getService("device_info_new")).getDeviceModel())) {
                    iUj *= 2;
                }
                fMin -= iUj;
            }
        }
        fArr[0] = fMin;
        fArr[1] = fMax;
        return fArr;
    }

    public static int[] c(Context context, float f, float f2, int i) {
        int iMax;
        float[] fArrC = c(context, f, i);
        float f3 = fArrC[0];
        float f4 = fArrC[1];
        int[] iArr = new int[4];
        int iMin = (int) (Math.min(f3, f4) * f2);
        if (i != 2) {
            float f5 = iMin;
            iMax = (int) Math.max((f4 - (((f3 - f5) - f5) / f)) / 2.0f, 0.0f);
        } else {
            float f6 = iMin;
            iMin = (int) Math.max((f3 - (((f4 - f6) - f6) * f)) / 2.0f, 0.0f);
            iMax = iMin;
        }
        iArr[0] = iMin;
        iArr[1] = iMax;
        iArr[2] = iMin;
        iArr[3] = iMax;
        return iArr;
    }
}
