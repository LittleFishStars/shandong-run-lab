package com.byazt.be;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.byazt.sa.uj;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 798, 1691})
public class DislikeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f28316a;
    public uj c;
    public int i;
    public Paint n;
    public float sp;
    public int tt;
    public RectF uj;
    public int ve;
    public Paint x;

    public DislikeView(Context context) {
        super(context);
        c();
    }

    private void c() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.x = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f28316a = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    @Override // android.view.View
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

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.uj;
        float f = this.sp;
        canvas.drawRoundRect(rectF, f, f, this.f28316a);
        RectF rectF2 = this.uj;
        float f2 = this.sp;
        canvas.drawRoundRect(rectF2, f2, f2, this.n);
        int i = this.tt;
        int i2 = this.ve;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.x);
        int i3 = this.tt;
        int i4 = this.ve;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.x);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.c;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.tt = i;
        this.ve = i2;
        int i5 = this.i;
        this.uj = new RectF(i5, i5, this.tt - i5, this.ve - i5);
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

    public void setBgColor(int i) {
        this.f28316a.setStyle(Paint.Style.FILL);
        this.f28316a.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.x.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.x.setStrokeWidth(i);
    }

    public void setRadius(float f) {
        this.sp = f;
    }

    public void setStrokeColor(int i) {
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.n.setStrokeWidth(i);
        this.i = i;
    }

    public void c(ve veVar) {
        this.c = veVar;
    }
}
