package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.beizi.fusion.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f27939a;
    private Paint b;
    private Paint c;
    private Paint d;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;
    private float o;
    private int p;
    private int q;
    private float r;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BeiZiCircleProgressViewStyle, 0, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        float fApplyDimension2 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.r = TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.i = typedArrayObtainStyledAttributes.getDimension(R.styleable.BeiZiCircleProgressViewStyle_adScopeRadius, fApplyDimension);
        this.k = typedArrayObtainStyledAttributes.getDimension(R.styleable.BeiZiCircleProgressViewStyle_adScopeStrokeWidth, fApplyDimension2);
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeCircleColor, 0);
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeRingColor, -41216);
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeTextColor, -1);
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeRingBgColor, 1589427388);
        this.j = this.i + (this.k / 2.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.l = getWidth() / 2;
        int height = getHeight() / 2;
        this.m = height;
        canvas.drawCircle(this.l, height, this.i, this.f27939a);
        RectF rectF = new RectF();
        float f = this.l;
        float f2 = this.j;
        float f3 = f - f2;
        rectF.left = f3;
        float f4 = this.m - f2;
        rectF.top = f4;
        float f5 = f2 * 2.0f;
        rectF.right = f3 + f5;
        rectF.bottom = f5 + f4;
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.c);
        if (this.q > 0) {
            RectF rectF2 = new RectF();
            float f6 = this.l;
            float f7 = this.j;
            float f8 = f6 - f7;
            rectF2.left = f8;
            float f9 = this.m - f7;
            rectF2.top = f9;
            float f10 = f7 * 2.0f;
            rectF2.right = f8 + f10;
            rectF2.bottom = f10 + f9;
            canvas.drawArc(rectF2, -90.0f, (this.q / this.p) * 360.0f, false, this.b);
            float fMeasureText = this.d.measureText("跳过", 0, 2);
            this.n = fMeasureText;
            canvas.drawText("跳过", this.l - (fMeasureText / 2.0f), this.m + (this.o / 4.0f), this.d);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (int) (getPaddingLeft() + this.r + getPaddingRight());
        }
        if (mode2 != 1073741824) {
            size2 = (int) (getPaddingTop() + this.r + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    public void setProgress(int i) {
        this.q = i;
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 100;
        a(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f27939a = paint;
        paint.setAntiAlias(true);
        this.f27939a.setColor(this.e);
        Paint paint2 = this.f27939a;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setColor(this.h);
        Paint paint4 = this.c;
        Paint.Style style2 = Paint.Style.STROKE;
        paint4.setStyle(style2);
        this.c.setStrokeWidth(this.k);
        Paint paint5 = new Paint();
        this.b = paint5;
        paint5.setAntiAlias(true);
        this.b.setColor(this.f);
        this.b.setStyle(style2);
        this.b.setStrokeWidth(this.k);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.d = paint6;
        paint6.setAntiAlias(true);
        this.d.setStyle(style);
        this.d.setColor(this.g);
        this.d.setTextSize((this.i * 3.0f) / 5.0f);
        this.d.setShadowLayer(2.0f, 1.0f, 1.0f, Color.parseColor("#000000"));
        Paint.FontMetrics fontMetrics = this.d.getFontMetrics();
        this.o = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }
}
