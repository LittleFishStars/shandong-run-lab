package com.kc.aw.component.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgGrayBtn extends TextView {
    public PtgGrayBtn(Context context) {
        super(context);
        _a();
    }

    public PtgGrayBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a();
    }

    public PtgGrayBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        setGravity(17);
        Context context = getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 45.0f, context.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(Color.parseColor("#323232"));
        gradientDrawable.setStroke(0, Color.parseColor("#323232"));
        setBackground(gradientDrawable);
    }
}
