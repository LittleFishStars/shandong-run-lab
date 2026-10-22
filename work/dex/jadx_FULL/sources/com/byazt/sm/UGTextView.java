package com.byazt.sm;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.byazt.rb.sp;
import com.byazt.rb.x;
import com.byazt.sa.uj;
import com.byazt.sz.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 40, 893})
public class UGTextView extends TextView implements sp, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29027a;
    public uj c;
    public float n;
    public float sp;
    public float tt;
    public float uj;
    public x ve;

    public UGTextView(Context context) {
        super(context);
        this.uj = -1.0f;
        this.f29027a = 1.0f;
        this.sp = 0.0f;
        this.ve = new x(this);
    }

    public void c(uj ujVar) {
        this.c = ujVar;
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.tt(canvas);
        }
    }

    public float getBorderRadius() {
        return this.ve.c();
    }

    @Override // com.byazt.rb.sp
    public float getRipple() {
        return this.tt;
    }

    @Override // com.byazt.rb.sp
    public float getRubIn() {
        return this.ve.getRubIn();
    }

    @Override // com.byazt.rb.sp
    public float getShine() {
        return this.ve.getShine();
    }

    @Override // com.byazt.rb.sp
    public float getStretch() {
        return this.ve.getStretch();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(canvas, this);
            this.c.c(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(i, i2, i3, i4);
        }
        if (z && this.uj > 0.0f) {
            c(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.c;
        if (ujVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.ve.c(i);
    }

    public void setBorderRadius(float f) {
        x xVar = this.ve;
        if (xVar != null) {
            xVar.c(f);
        }
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f29027a = f2;
        this.sp = f;
    }

    public void setMinTextSize(float f) {
        this.uj = f;
    }

    public void setRipple(float f) {
        this.tt = f;
        x xVar = this.ve;
        if (xVar != null) {
            xVar.tt(f);
        }
        postInvalidate();
    }

    public void setRubIn(float f) {
        x xVar = this.ve;
        if (xVar != null) {
            xVar.n(f);
        }
    }

    public void setShine(float f) {
        x xVar = this.ve;
        if (xVar != null) {
            xVar.ve(f);
        }
    }

    public void setStretch(float f) {
        x xVar = this.ve;
        if (xVar != null) {
            xVar.uj(f);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.n = getTextSize();
    }

    private void c(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.n == 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        float fMax = this.n;
        int iC = c(text, paint, i, fMax);
        while (iC > i2) {
            float f = this.uj;
            if (fMax <= f) {
                break;
            }
            fMax = Math.max(fMax - 1.0f, f);
            iC = c(text, paint, i, fMax);
        }
        setTextSize(0, fMax);
        setLineSpacing(this.sp, this.f29027a);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.n = getTextSize();
    }

    private int c(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.f29027a, this.sp, true).getHeight();
    }
}
