package com.huachenjie.mall.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.flyco.tablayout.SlidingTabLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallHomeTabLayout extends SlidingTabLayout {
    public MallHomeTabLayout(Context context) {
        super(context);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable indicatorDrawable = getIndicatorDrawable();
        if (indicatorDrawable == null || !(indicatorDrawable instanceof GradientDrawable)) {
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) indicatorDrawable;
        int[] iArr = {Color.parseColor("#80DF97FF"), Color.parseColor("#808485FF")};
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        gradientDrawable.setCornerRadius(0.0f);
        gradientDrawable.draw(canvas);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void updateTabSelection(int i) {
        int i2 = 0;
        while (i2 < this.mTabCount) {
            boolean z = i2 == i;
            TextView tabTitleView = getTabTitleView(i2);
            if (tabTitleView != null) {
                tabTitleView.setTextColor(z ? getTextSelectColor() : getTextUnselectColor());
                tabTitleView.setTextSize(z ? 18.0f : 14.0f);
                tabTitleView.getPaint().setFakeBoldText(z);
            }
            i2++;
        }
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void updateTabStyles() {
        TextView tabTitleView;
        super.updateTabStyles();
        int i = this.mCurrentTab;
        if (i >= this.mTabCount || (tabTitleView = getTabTitleView(i)) == null) {
            return;
        }
        tabTitleView.setTextSize(18.0f);
    }

    public MallHomeTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MallHomeTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
