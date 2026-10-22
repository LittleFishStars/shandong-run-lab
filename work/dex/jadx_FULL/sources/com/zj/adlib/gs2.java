package com.zj.adlib;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class gs2 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float fPow;
        float f2;
        if (f < 0.25f) {
            fPow = ((float) Math.pow(((double) f) - 0.125d, 2.0d)) * (-38.4f);
            f2 = 0.6f;
        } else {
            double d = f;
            if (d < 0.5d || d >= 0.75d) {
                return 0.0f;
            }
            fPow = ((float) Math.pow(d - 0.625d, 2.0d)) * (-19.2f);
            f2 = 0.3f;
        }
        return fPow + f2;
    }
}
