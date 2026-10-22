package com.acse.ottn;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f5 extends d0 {
    public static final float d = 0.85f;
    public static final float e = 0.5f;
    public float b;
    public float c;

    public f5() {
        this.b = 0.85f;
        this.c = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float fMax = Math.max(this.b, 1.0f - Math.abs(f));
        float f2 = 1.0f - fMax;
        float f3 = (height * f2) / 2.0f;
        float f4 = (width * f2) / 2.0f;
        if (f < 0.0f) {
            view.setTranslationX(f4 - (f3 / 2.0f));
        } else {
            view.setTranslationX((-f4) + (f3 / 2.0f));
        }
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        float f5 = this.c;
        float f6 = this.b;
        view.setAlpha(f5 + (((fMax - f6) / (1.0f - f6)) * (1.0f - f5)));
    }

    public f5(float f, float f2) {
        this.b = f;
        this.c = f2;
    }
}
