package com.kc.aw.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgOverlayBtmLinerLayout extends LinearLayout {
    public PtgOverlayBtmLinerLayout(Context context) {
        super(context);
        _a();
    }

    public PtgOverlayBtmLinerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a();
    }

    public PtgOverlayBtmLinerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{0, Integer.MIN_VALUE});
            gradientDrawable.setShape(0);
            setBackground(gradientDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
