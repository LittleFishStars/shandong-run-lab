package com.byazt.bg;

import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1535, 46})
public class n {
    public final String c;
    public final float[] tt;
    public final int[] ve;

    public n(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.c = str;
        this.tt = new float[jSONArray.length()];
        this.ve = new int[jSONArray2.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.tt[i] = (float) jSONArray.optDouble(i);
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            this.ve[i2] = jSONArray2.optInt(i2);
        }
    }

    public int c(float f) {
        int[] iArr;
        int i;
        float[] fArr = this.tt;
        int i2 = -1;
        if (fArr == null || fArr.length == 0 || (iArr = this.ve) == null || iArr.length == 0) {
            return -1;
        }
        int length = fArr.length;
        int i3 = 0;
        while (i3 < length) {
            float[] fArr2 = this.tt;
            float f2 = fArr2[i3];
            if (f > f2 && (i = i3 + 1) < length && f <= fArr2[i]) {
                int[] iArr2 = this.ve;
                return i3 < iArr2.length ? iArr2[i3] : i2;
            }
            if (i3 == length - 1 && f > f2) {
                i2 = this.ve[i3];
            }
            i3++;
        }
        return i2;
    }
}
