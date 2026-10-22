package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s3 extends d0 {
    public static final float c = 15.0f;
    public float b;

    public s3() {
        this.b = 15.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        if (f < -1.0f) {
            view.setRotation(this.b * (-1.0f));
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else if (f > 1.0f) {
            view.setRotation(this.b);
            view.setPivotX(view.getWidth() * 0);
            view.setPivotY(view.getHeight());
        } else if (f < 0.0f) {
            view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
            view.setPivotY(view.getHeight());
            view.setRotation(this.b * f);
        } else {
            view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
            view.setPivotY(view.getHeight());
            view.setRotation(this.b * f);
        }
    }

    public s3(float f) {
        this.b = f;
    }
}
