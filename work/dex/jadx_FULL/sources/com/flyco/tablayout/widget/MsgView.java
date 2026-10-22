package com.flyco.tablayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.flyco.tablayout.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class MsgView extends TextView {
    public int K;
    public int L;
    public int M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f30239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GradientDrawable f1848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1849a;
    public boolean b;

    public MsgView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MsgView);
        this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.MsgView_mv_backgroundColor, 0);
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_cornerRadius, 0);
        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_strokeWidth, 0);
        this.N = typedArrayObtainStyledAttributes.getColor(R.styleable.MsgView_mv_strokeColor, 0);
        this.f1849a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isWidthHeightEqual, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(GradientDrawable gradientDrawable, int i, int i2) {
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.L);
        gradientDrawable.setStroke(this.M, i2);
    }

    public int dp2px(float f) {
        return (int) ((f * this.f30239a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getBackgroundColor() {
        return this.K;
    }

    public int getCornerRadius() {
        return this.L;
    }

    public int getStrokeColor() {
        return this.N;
    }

    public int getStrokeWidth() {
        return this.M;
    }

    public boolean isRadiusHalfHeight() {
        return this.f1849a;
    }

    public boolean isWidthHeightEqual() {
        return this.b;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (isRadiusHalfHeight()) {
            setCornerRadius(getHeight() / 2);
        } else {
            setBgSelector();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i, i2);
        } else {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
            super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.K = i;
        setBgSelector();
    }

    public void setBgSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        b(this.f1848a, this.K, this.N);
        stateListDrawable.addState(new int[]{-16842919}, this.f1848a);
        setBackground(stateListDrawable);
    }

    public void setCornerRadius(int i) {
        this.L = dp2px(i);
        setBgSelector();
    }

    public void setIsRadiusHalfHeight(boolean z) {
        this.f1849a = z;
        setBgSelector();
    }

    public void setIsWidthHeightEqual(boolean z) {
        this.b = z;
        setBgSelector();
    }

    public void setStrokeColor(int i) {
        this.N = i;
        setBgSelector();
    }

    public void setStrokeWidth(int i) {
        this.M = dp2px(i);
        setBgSelector();
    }

    public int sp2px(float f) {
        return (int) ((f * this.f30239a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public MsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1848a = new GradientDrawable();
        this.f30239a = context;
        a(context, attributeSet);
    }
}
