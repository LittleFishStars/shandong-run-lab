package com.byazt.cc;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 72})
public class da implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        int i = (iIntValue >> 24) & 255;
        int i2 = (iIntValue >> 16) & 255;
        int i3 = (iIntValue >> 8) & 255;
        int i4 = iIntValue & 255;
        int iIntValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i + ((int) ((((iIntValue2 >> 24) & 255) - i) * f))) << 24) | ((i2 + ((int) ((((iIntValue2 >> 16) & 255) - i2) * f))) << 16) | ((i3 + ((int) ((((iIntValue2 >> 8) & 255) - i3) * f))) << 8) | (i4 + ((int) (f * ((iIntValue2 & 255) - i4)))));
    }
}
