package com.huachenjie.mall.page.goods_detail.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
class ImagePreviewViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f35211a;
    public boolean b;

    public ImagePreviewViewPager(@NonNull Context context) {
        super(context);
        this.b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            this.f35211a = false;
        } else if (actionMasked == 5) {
            this.f35211a = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f35211a || !this.b) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setTouchEnable(boolean z) {
        this.b = z;
    }

    public ImagePreviewViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
    }
}
