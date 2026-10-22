package com.kc.dw.ad.reward;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.BeiZiBiddingConstant;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CircleProcessBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f39150a;
    public Paint b;
    public Paint c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public RectF i;
    public int j;
    public int k;
    public a l;

    @Keep
    public interface a {
        void onSkip();
    }

    public CircleProcessBar(Context context) {
        super(context);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 15.5f;
        this.j = 0;
        this.k = 5000;
        a();
    }

    public CircleProcessBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 15.5f;
        this.j = 0;
        this.k = 5000;
        a();
    }

    public CircleProcessBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 15.5f;
        this.j = 0;
        this.k = 5000;
        a();
    }

    public final void a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = this.d;
        float f2 = displayMetrics.density;
        this.d = f * f2;
        this.e *= f2;
        this.f *= f2;
        this.g *= f2;
        Paint paint = new Paint();
        this.f39150a = paint;
        paint.setTextSize(this.e);
        this.f39150a.setColor(-1);
        this.f39150a.setAntiAlias(true);
        this.f39150a.setShadowLayer(displayMetrics.density * 3.0f, 0.0f, 0.0f, -7829368);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(Color.parseColor("#b7ffffff"));
        this.b.setAntiAlias(true);
        this.b.setStrokeWidth(this.d);
        this.b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(Color.parseColor("#42c1f0"));
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth(this.d);
        this.c.setStyle(Paint.Style.STROKE);
        this.f39150a.measureText(BeiZiBiddingConstant.LossReason.OTHER);
        float f3 = this.g;
        this.h = f3;
        float f4 = this.d / 2.0f;
        float f5 = 0.0f + f4 + 1.0f;
        float f6 = ((f3 * 2.0f) - f4) - 1.0f;
        this.i = new RectF(f5, f5, f6, f6);
    }

    public void a(int i) {
        a aVar;
        synchronized (this) {
            this.j = i;
            invalidate();
            if (this.j >= this.k && (aVar = this.l) != null) {
                aVar.onSkip();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.i, 0.0f, 360.0f, false, this.b);
        canvas.save();
        canvas.rotate(-90.0f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        canvas.drawArc(this.i, 0.0f, ((this.j * 1.0f) / this.k) * 360.0f, false, this.c);
        canvas.restore();
        Paint.FontMetrics fontMetrics = this.f39150a.getFontMetrics();
        int measuredHeight = (int) ((getMeasuredHeight() / 2) - ((fontMetrics.top + fontMetrics.bottom) / 2.0f));
        int iMax = Math.max(0, ((this.k - this.j) + 999) / 1000);
        if (iMax == 0) {
            setVisibility(8);
            a aVar = this.l;
            if (aVar != null) {
                aVar.onSkip();
                return;
            }
            return;
        }
        canvas.drawText("" + iMax, (getMeasuredWidth() / 2) - (this.f39150a.measureText(iMax + "") / 2.0f), measuredHeight, this.f39150a);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = (int) (this.h * 2.0f);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = (int) (this.h * 2.0f);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        int action = motionEvent.getAction();
        if (action != 0) {
            f = action == 1 ? 1.0f : 0.5f;
            return true;
        }
        setAlpha(f);
        return true;
    }

    public void setOnSkipListener(a aVar) {
        this.l = aVar;
    }

    public void setmTotalTime(int i) {
        this.k = i;
    }
}
