package com.fl.saas.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AspectRatioRelativeLayout extends RelativeLayout {
    private float mAspectRatio;

    public AspectRatioRelativeLayout(Context context) {
        this(context, null, 0);
    }

    public AspectRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAspectRatio = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YDAspectRatioRelativeLayout, i, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.YDAspectRatioRelativeLayout_yd_aspectRatio, 0.0f);
        this.mAspectRatio = f;
        if (f == 0.0f) {
            throw new IllegalArgumentException("You must specify an aspect ratio when using the AspectRatioView.");
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        float f = this.mAspectRatio;
        if (f == 0.0f) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824));
        }
    }
}
