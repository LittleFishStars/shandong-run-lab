package com.kc.openset.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class SizeLimitView extends FrameLayout {
    private float maxHeight;
    private float maxWidth;

    public SizeLimitView(Context context) {
        this(context, null);
    }

    public SizeLimitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SizeLimitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdSetSizeLimitView);
        this.maxHeight = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdSetSizeLimitView_adSetMaxHeight, 0.0f);
        this.maxWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdSetSizeLimitView_adSetMaxWidth, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = this.maxHeight;
        if (f != 0.0f && size2 > f) {
            size2 = (int) f;
        }
        float f2 = this.maxWidth;
        if (f2 != 0.0f && size > f2) {
            size = (int) f2;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }
}
