package com.kc.aw.component.widgets;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw._o6;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgLogoView extends LinearLayout {
    public ImageView _a;
    public TextView _b;

    public PtgLogoView(Context context) {
        super(context);
        _a(context);
    }

    public PtgLogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a(context);
    }

    public PtgLogoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a(context);
    }

    public final void _a(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setGravity(17);
        setOrientation(0);
        setPadding((int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics()));
        Context context2 = getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 100.0f, context2.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(-1724697805);
        setBackground(gradientDrawable);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 9.0f, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 9.0f, context.getResources().getDisplayMetrics())));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setContentDescription("ImageLogo");
        _o6._a(imageView);
        this._a = imageView;
        addView(imageView);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics()), 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setText("广告");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        this._b = textView;
        addView(textView);
    }

    public void setAdText(String str) {
        this._b.setText(str);
    }

    public void setAdTextColor(int i) {
        this._b.setTextColor(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) getBackground()).setColor(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    public void setLogoImageResource(int i) {
        this._a.setImageResource(i);
    }
}
