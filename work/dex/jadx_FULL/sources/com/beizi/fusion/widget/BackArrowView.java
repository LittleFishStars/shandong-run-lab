package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BackArrowView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27938a;
    private int b;
    private float c;
    private float d;
    private int e;
    private float f;
    private int g;
    private Paint h;
    private Path i;

    public BackArrowView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        b(context, attributeSet, i);
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(this.e);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setAntiAlias(true);
        this.h.setStrokeWidth(this.f);
        this.h.setStrokeJoin(Paint.Join.ROUND);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BeiZi_BackArrowView, i, 0);
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZi_BackArrowView_beizi_bav_color, Color.argb(255, 0, 0, 0));
        this.f = typedArrayObtainStyledAttributes.getDimension(R.styleable.BeiZi_BackArrowView_beizi_bav_stroke_width, dip2px(context, 2.0f));
        this.g = typedArrayObtainStyledAttributes.getInt(R.styleable.BeiZi_BackArrowView_beizi_bav_arrow_style, 1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((this.f27938a / 2.0f) - this.c, this.b / 2);
        canvas.rotate(45.0f);
        if (this.i == null) {
            this.i = new Path();
        }
        this.i.reset();
        this.i.lineTo(0.0f, this.d);
        this.i.moveTo(0.0f, 0.0f);
        this.i.lineTo(-this.d, 0.0f);
        if (this.g == 1) {
            this.i.moveTo(0.0f, 0.0f);
            Path path = this.i;
            float f = this.d;
            path.lineTo(f, -f);
        }
        this.i.close();
        canvas.drawPath(this.i, this.h);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(a(i), a(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f27938a = i;
        this.b = i2;
        float fMin = Math.min(i, i2) / 2.0f;
        int i5 = this.g;
        if (i5 == 1) {
            this.c = fMin / 3.0f;
        } else if (i5 == 2) {
            this.c = fMin / 4.0f;
        }
        this.d = fMin * 0.63f;
    }

    public void setViewColor(int i) {
        Paint paint = this.h;
        if (paint != null) {
            paint.setColor(i);
            invalidate();
        }
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(150, size);
        }
        return 150;
    }
}
