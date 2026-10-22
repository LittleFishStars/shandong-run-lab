package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends d0 {
    public static final float c = 0.5f;
    public float b;

    public h() {
        this.b = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        view.setScaleX(0.999f);
        if (f < -1.0f) {
            view.setAlpha(this.b);
            return;
        }
        if (f > 1.0f) {
            view.setAlpha(this.b);
        } else if (f < 0.0f) {
            float f2 = this.b;
            view.setAlpha(f2 + ((1.0f - f2) * (f + 1.0f)));
        } else {
            float f3 = this.b;
            view.setAlpha(f3 + ((1.0f - f3) * (1.0f - f)));
        }
    }

    public h(float f) {
        this.b = f;
    }
}
