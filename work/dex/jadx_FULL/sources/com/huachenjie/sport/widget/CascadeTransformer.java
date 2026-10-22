package com.huachenjie.sport.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/widget/CascadeTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "()V", "transformPage", "", "page", "Landroid/view/View;", "position", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CascadeTransformer implements ViewPager2.PageTransformer {
    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NotNull View page, float position) {
        Intrinsics.checkNotNullParameter(page, "page");
        if (position <= 0.0f) {
            page.setAlpha(1.0f);
            page.setTranslationZ(0.0f);
            page.setTranslationX(0.0f);
        } else {
            if (position > 1.0f) {
                page.setAlpha(0.0f);
                return;
            }
            page.setAlpha(1.0f);
            float f = -position;
            page.setTranslationX((page.getWidth() + page.getPaddingStart() + page.getPaddingEnd()) * f);
            page.setTranslationZ(f);
        }
    }
}
