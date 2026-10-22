package com.byazt.wy;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.sa.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1540, 2193})
public class UGProgressBar extends FrameLayout {
    public uj c;
    public int n;
    public View tt;
    public TextView uj;
    public View ve;

    public UGProgressBar(Context context) {
        super(context);
        c(context);
    }

    private void c(Context context) {
        this.tt = new View(context);
        this.ve = new View(context);
        addView(this.tt);
        addView(this.ve);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tt.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.tt.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ve.getLayoutParams();
        layoutParams2.width = this.n;
        layoutParams2.gravity = 5;
        this.ve.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.uj = textView;
        textView.setTextColor(-1);
        this.uj.setTextSize(16.0f);
        this.uj.setGravity(17);
        addView(this.uj);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(i, i2);
        }
        super.onMeasure(i, i2);
        this.n = c(0, i);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n = i;
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tt.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.tt.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ve.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.ve.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.uj.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setProgressBgColor(int i) {
        this.ve.setBackgroundColor(i);
    }

    public void setProgressColor(int i) {
        this.tt.setBackgroundColor(i);
    }

    public void setText(String str) {
        this.uj.setText(str);
    }

    public void setTextColor(int i) {
        this.uj.setTextColor(i);
    }

    private int c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    public void c(uj ujVar) {
        this.c = ujVar;
    }
}
