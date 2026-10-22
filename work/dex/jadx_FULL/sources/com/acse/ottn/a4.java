package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a4 extends d0 {
    public static final float c = 0.85f;
    public float b;

    public a4() {
        this.b = 0.85f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f < -1.0f) {
            view.setScaleX(this.b);
            view.setScaleY(this.b);
            view.setPivotX(width);
            return;
        }
        if (f > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.b);
            view.setScaleY(this.b);
        } else {
            if (f < 0.0f) {
                float f2 = this.b;
                float f3 = ((f + 1.0f) * (1.0f - f2)) + f2;
                view.setScaleX(f3);
                view.setScaleY(f3);
                view.setPivotX(width * (((-f) * 0.5f) + 0.5f));
                return;
            }
            float f4 = 1.0f - f;
            float f5 = this.b;
            float f6 = ((1.0f - f5) * f4) + f5;
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotX(width * f4 * 0.5f);
        }
    }

    public a4(float f) {
        this.b = f;
    }
}
