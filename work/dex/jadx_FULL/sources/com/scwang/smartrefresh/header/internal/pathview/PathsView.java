package com.scwang.smartrefresh.header.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.zj.adlib.fn6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class PathsView extends View {
    protected fn6 mPathsDrawable;

    public PathsView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mPathsDrawable.draw(canvas);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            parserPaths(getTag().toString());
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mPathsDrawable.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        fn6 fn6Var = this.mPathsDrawable;
        super.setMeasuredDimension(View.resolveSize(fn6Var.getBounds().width() + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(fn6Var.getBounds().height() + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void parserColors(int... iArr) {
        this.mPathsDrawable.e(iArr);
    }

    public boolean parserPaths(String... strArr) {
        return this.mPathsDrawable.f(strArr);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPathsDrawable = new fn6();
    }
}
