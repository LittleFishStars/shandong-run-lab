package com.acse.ottn;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k2 extends d0 {
    public static final float c = 0.85f;
    public float b;

    public k2() {
        this.b = 0.85f;
    }

    public final ViewPager2 a(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        ViewPager2 viewPager2A = a(view);
        float paddingLeft = viewPager2A.getPaddingLeft();
        float measuredWidth = f - (paddingLeft / ((viewPager2A.getMeasuredWidth() - paddingLeft) - viewPager2A.getPaddingRight()));
        float width = view.getWidth();
        float f2 = this.b;
        float f3 = 1.0f - f2;
        float f4 = (width * f3) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(f4);
            view.setScaleX(this.b);
            view.setScaleY(this.b);
            return;
        }
        double d = measuredWidth;
        if (d > 1.0d) {
            view.setScaleX(f2);
            view.setScaleY(this.b);
            view.setTranslationX(-f4);
            return;
        }
        float fAbs = f3 * Math.abs(1.0f - Math.abs(measuredWidth));
        float f5 = (-f4) * measuredWidth;
        if (d <= -0.5d) {
            view.setTranslationX(f5 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
        } else if (measuredWidth > 0.0f && d >= 0.5d) {
            view.setTranslationX(f5 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
        } else {
            view.setTranslationX(f5);
        }
        view.setScaleX(this.b + fAbs);
        view.setScaleY(fAbs + this.b);
    }

    public k2(float f) {
        this.b = f;
    }
}
