package com.acse.ottn;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y0 extends d0 {
    public static final float c = 0.75f;
    public float b;

    public y0() {
        this.b = 0.75f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        if (f < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            return;
        }
        if (f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        view.setVisibility(0);
        view.setAlpha(1.0f - f);
        view.setTranslationX(width * (-f));
        float f2 = this.b;
        float fAbs = f2 + ((1.0f - f2) * (1.0f - Math.abs(f)));
        view.setScaleX(fAbs);
        view.setScaleY(fAbs);
        if (f == 1.0f) {
            view.setVisibility(4);
        }
    }

    public y0(float f) {
        this.b = f;
    }
}
