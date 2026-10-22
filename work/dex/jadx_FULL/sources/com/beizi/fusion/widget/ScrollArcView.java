package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScrollArcView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f27956a;
    private Path b;
    private Paint c;
    private Paint d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;

    public ScrollArcView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 100.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        f();
    }

    private void a() {
        int i = this.h;
        float f = i / 2.0f;
        int i2 = this.i;
        float f2 = i2 / 2.0f;
        float fMin = Math.min(i, i2) / 2.0f;
        this.f27956a.reset();
        this.b.reset();
        Path path = this.b;
        Path.Direction direction = Path.Direction.CW;
        path.addCircle(f, f2, fMin, direction);
        this.f27956a.addCircle(f, f2, fMin, direction);
    }

    private void b() {
        float f = (this.i - ((this.e + 10.0f) / 2.0f)) - this.g;
        this.f27956a.moveTo(0.0f, f);
        Path path = this.f27956a;
        float f2 = this.h;
        path.quadTo(f2 / 2.0f, this.e + f, f2, f);
        this.b.moveTo(0.0f, f);
        Path path2 = this.b;
        float f3 = this.h;
        path2.quadTo(f3 / 2.0f, this.e + f, f3, f);
        this.b.lineTo(this.h, 0.0f);
        this.b.lineTo(0.0f, 0.0f);
        this.b.close();
    }

    private void c() {
        float f = (this.h - ((this.e + 10.0f) / 2.0f)) - this.f;
        this.f27956a.moveTo(f, 0.0f);
        Path path = this.f27956a;
        float f2 = f - this.e;
        float f3 = this.i;
        path.quadTo(f2, f3 / 2.0f, f, f3);
        this.b.moveTo(f, 0.0f);
        Path path2 = this.b;
        float f4 = f - this.e;
        float f5 = this.i;
        path2.quadTo(f4, f5 / 2.0f, f, f5);
        this.b.lineTo(this.h, this.i);
        this.b.lineTo(this.h, 0.0f);
        this.b.close();
    }

    private void d() {
        float f = ((this.e + 10.0f) / 2.0f) + this.f;
        this.f27956a.moveTo(f, 0.0f);
        Path path = this.f27956a;
        float f2 = this.e + f;
        float f3 = this.i;
        path.quadTo(f2, f3 / 2.0f, f, f3);
        this.b.moveTo(f, 0.0f);
        Path path2 = this.b;
        float f4 = this.e + f;
        float f5 = this.i;
        path2.quadTo(f4, f5 / 2.0f, f, f5);
        this.b.lineTo(0.0f, this.i);
        this.b.lineTo(0.0f, 0.0f);
        this.b.close();
    }

    private void e() {
        float f = ((this.e + 10.0f) / 2.0f) + this.g;
        this.f27956a.moveTo(0.0f, f);
        Path path = this.f27956a;
        float f2 = this.h;
        path.quadTo(f2 / 2.0f, f - this.e, f2, f);
        this.b.moveTo(0.0f, f);
        Path path2 = this.b;
        float f3 = this.h;
        path2.quadTo(f3 / 2.0f, f - this.e, f3, f);
        this.b.lineTo(this.h, this.i);
        this.b.lineTo(0.0f, this.i);
        this.b.close();
    }

    private void f() {
        float fApplyDimension = TypedValue.applyDimension(1, this.e, getResources().getDisplayMetrics());
        this.e = fApplyDimension;
        this.i = ((int) fApplyDimension) + 10;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(Color.parseColor("#E5E5E5"));
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(8.0f);
        this.c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setColor(Color.parseColor("#000000"));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setAntiAlias(true);
        this.f27956a = new Path();
        this.b = new Path();
    }

    private void g() {
        this.f27956a.reset();
        this.b.reset();
        int i = this.j;
        if (i == 0) {
            e();
            return;
        }
        if (i == 1) {
            d();
            return;
        }
        if (i == 2) {
            c();
        } else if (i == 3) {
            b();
        } else {
            if (i != 4) {
                return;
            }
            a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.b, this.d);
        canvas.drawPath(this.f27956a, this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        this.i = i2;
        g();
    }

    public void setArcColor(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public void setArcDirection(int i) {
        this.j = i;
        g();
        invalidate();
    }

    public void setArcHeight(int i) {
        this.e = i;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public void setOffset(float f) {
        this.g = TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        g();
        invalidate();
    }

    public void setOffsetX(float f) {
        this.f = f;
        g();
        invalidate();
    }

    public void setOffsetY(float f) {
        this.g = f;
        g();
        invalidate();
    }

    public void setArcHeight(float f) {
        this.e = TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        g();
        invalidate();
    }
}
