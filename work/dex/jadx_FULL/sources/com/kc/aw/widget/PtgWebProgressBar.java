package com.kc.aw.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.view.GravityCompat;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgWebProgressBar extends ProgressBar {
    public PtgWebProgressBar(Context context) {
        super(context);
        _a();
    }

    public PtgWebProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a();
    }

    public PtgWebProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(0.0f);
            gradientDrawable.setShape(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(-14774017);
            gradientDrawable2.setCornerRadius(0.0f);
            gradientDrawable2.setShape(0);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, GravityCompat.START, 1)});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.progress);
            setProgressDrawable(layerDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
