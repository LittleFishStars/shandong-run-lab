package com.alibaba.triver.embed.video.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.embed.video.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RangeBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24887a = "RangeBar";
    private static final int b = 3;
    private static final float c = 24.0f;
    private static final float d = 2.0f;
    private static final int e = -3355444;
    private static final float f = 4.0f;
    private static final int g;
    private static final int h;
    private static final int i = -13388315;
    private static final float j = -1.0f;
    private static final int k = -1;
    private static final int l = -1;
    private f A;
    private f B;
    private b C;
    private c D;
    private int E;
    private a F;
    private int G;
    private int H;
    private Paint I;
    private Paint J;
    private int m;
    private float n;
    private float o;
    private int p;
    private float q;
    private int r;
    private int s;
    private int t;
    private float u;
    private int v;
    private int w;
    private boolean x;
    private int y;
    private int z;

    public interface a {
        void a(RangeBar rangeBar, int i, int i2);
    }

    static {
        int i2 = R.mipmap.handle_left;
        g = i2;
        h = i2;
    }

    public RangeBar(Context context) {
        super(context);
        this.m = 3;
        this.n = 24.0f;
        this.o = 2.0f;
        this.p = e;
        this.q = 4.0f;
        this.r = i;
        this.s = g;
        this.t = h;
        this.u = -1.0f;
        this.v = -1;
        this.w = -1;
        this.x = true;
        this.y = 500;
        this.z = 100;
        this.G = 0;
        this.H = 0 + 8;
    }

    private boolean a(int i2) {
        return i2 > 1;
    }

    private boolean a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        if (this.A.w() + (this.A.u() * 2.0f) <= x || x <= this.A.w() - this.A.u()) {
            return this.B.w() - this.B.u() < x && this.B.w() + (this.B.u() * 2.0f) > x;
        }
        return true;
    }

    private void b() {
        this.C = new b(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.m, this.n, this.o, this.p);
        invalidate();
    }

    private void c() {
        this.D = new c(getContext(), getYPos(), this.q, this.r);
        invalidate();
    }

    private void d() {
        Context context = getContext();
        getYPos();
        this.A = new f(context, getMeasuredHeight() * 2, this.v, this.w, this.u, this.s, this.t);
        this.B = new f(context, getMeasuredHeight() * 2, this.v, this.w, this.u, this.s, this.t);
        float marginLeft = getMarginLeft();
        float barLength = getBarLength();
        this.A.a(((this.G / (this.m - 1)) * barLength) + marginLeft);
        this.B.a(marginLeft + ((this.H / (this.m - 1)) * barLength));
        invalidate();
    }

    private void e() {
        if (this.A.x()) {
            b(this.A);
        } else if (this.B.x()) {
            b(this.B);
        }
    }

    private float getBarLength() {
        return getWidth() - (getMarginLeft() * 2.0f);
    }

    private float getMarginLeft() {
        f fVar = this.A;
        if (fVar != null) {
            return fVar.u();
        }
        return 0.0f;
    }

    private float getYPos() {
        return getHeight() / 2.0f;
    }

    public int getLeftIndex() {
        return this.G;
    }

    public int getRightIndex() {
        return this.H;
    }

    public int getmTickCount() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.I);
        canvas.drawRect(0.0f, 0.0f, this.A.w() - this.A.u(), getMeasuredHeight(), this.J);
        canvas.drawRect(this.B.w() + this.B.u(), 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.J);
        this.A.a(canvas);
        this.B.a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            size = this.y;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.z, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.z;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.m = bundle.getInt("TICK_COUNT");
        this.n = bundle.getFloat("TICK_HEIGHT_DP");
        this.o = bundle.getFloat("BAR_WEIGHT");
        this.p = bundle.getInt("BAR_COLOR");
        this.q = bundle.getFloat("CONNECTING_LINE_WEIGHT");
        this.r = bundle.getInt("CONNECTING_LINE_COLOR");
        this.s = bundle.getInt("THUMB_IMAGE_NORMAL");
        this.t = bundle.getInt("THUMB_IMAGE_PRESSED");
        this.u = bundle.getFloat("THUMB_RADIUS_DP");
        this.v = bundle.getInt("THUMB_COLOR_NORMAL");
        this.w = bundle.getInt("THUMB_COLOR_PRESSED");
        this.G = bundle.getInt("LEFT_INDEX");
        this.H = bundle.getInt("RIGHT_INDEX");
        this.x = bundle.getBoolean("FIRST_SET_TICK_COUNT");
        a(this.G, this.H);
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("TICK_COUNT", this.m);
        bundle.putFloat("TICK_HEIGHT_DP", this.n);
        bundle.putFloat("BAR_WEIGHT", this.o);
        bundle.putInt("BAR_COLOR", this.p);
        bundle.putFloat("CONNECTING_LINE_WEIGHT", this.q);
        bundle.putInt("CONNECTING_LINE_COLOR", this.r);
        bundle.putInt("THUMB_IMAGE_NORMAL", this.s);
        bundle.putInt("THUMB_IMAGE_PRESSED", this.t);
        bundle.putFloat("THUMB_RADIUS_DP", this.u);
        bundle.putInt("THUMB_COLOR_NORMAL", this.v);
        bundle.putInt("THUMB_COLOR_PRESSED", this.w);
        bundle.putInt("LEFT_INDEX", this.G);
        bundle.putInt("RIGHT_INDEX", this.H);
        bundle.putBoolean("FIRST_SET_TICK_COUNT", this.x);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Context context = getContext();
        float f2 = i3 / 2.0f;
        this.A = new f(context, f2, this.v, this.w, this.u, this.s, this.t);
        this.B = new f(context, f2, this.v, this.w, this.u, this.s, this.t);
        float fU = this.A.u();
        float f3 = i2 - (2.0f * fU);
        this.C = new b(context, fU, f2, f3, this.m, this.n, this.o, this.p);
        this.A.a(((this.G / (this.m - 1)) * f3) + fU);
        this.B.a(fU + (((this.G + this.E) / (this.m - 1)) * f3));
        int iB = this.C.b(this.A);
        int iB2 = this.C.b(this.B);
        if (iB != this.G || iB2 != this.H) {
            this.G = iB;
            this.H = iB2;
            a aVar = this.F;
            if (aVar != null) {
                aVar.a(this, iB, iB2);
            }
        }
        this.D = new c(context, f2, this.q, this.r);
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!a(motionEvent)) {
                return false;
            }
            a(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                a(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        e();
        return true;
    }

    public void setBarColor(int i2) {
        this.p = i2;
        b();
    }

    public void setBarWeight(float f2) {
        this.o = f2;
        b();
    }

    public void setConnectingLineColor(int i2) {
        this.r = i2;
        c();
    }

    public void setConnectingLineWeight(float f2) {
        this.q = f2;
        c();
    }

    public void setMaxDuration(int i2) {
        System.out.println("---------------------->>>>>>>>> setMaxDuration: " + i2);
        this.E = i2;
    }

    public void setOnRangeBarChangeListener(a aVar) {
        this.F = aVar;
    }

    public void setThumbColorNormal(int i2) {
        this.v = i2;
        d();
    }

    public void setThumbColorPressed(int i2) {
        this.w = i2;
        d();
    }

    public void setThumbImageNormal(int i2) {
        this.s = i2;
        d();
    }

    public void setThumbImagePressed(int i2) {
        this.t = i2;
        d();
    }

    public void setThumbRadius(float f2) {
        this.u = f2;
        d();
    }

    public void setTickCount(int i2) {
        if (!a(i2)) {
            RVLogger.e(f24887a, "tickCount less than 2; invalid tickCount.");
            throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
        }
        this.m = i2;
        if (this.x) {
            this.G = 0;
            int i3 = i2 - 1;
            this.H = i3;
            a aVar = this.F;
            if (aVar != null) {
                aVar.a(this, 0, i3);
            }
        }
        if (b(this.G, this.H)) {
            this.G = 0;
            int i4 = this.m - 1;
            this.H = i4;
            a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.a(this, 0, i4);
            }
        }
        b();
        d();
    }

    public void setTickHeight(float f2) {
        this.n = f2;
        b();
    }

    public void setmTickCount(int i2) {
        this.m = i2;
    }

    public void a(int i2, int i3) {
        if (!b(i2, i3)) {
            if (this.x) {
                this.x = false;
            }
            this.G = i2;
            this.H = i3;
            d();
            a aVar = this.F;
            if (aVar != null) {
                aVar.a(this, this.G, this.H);
            }
            invalidate();
            requestLayout();
            return;
        }
        RVLogger.e(f24887a, "A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
        throw new IllegalArgumentException("A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
    }

    private boolean b(int i2, int i3) {
        int i4;
        return i2 < 0 || i2 >= (i4 = this.m) || i3 < 0 || i3 >= i4;
    }

    private void b(f fVar) {
        fVar.a(this.C.a(fVar));
        fVar.z();
        invalidate();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RangeBar, 0, 0);
        try {
            Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(R.styleable.RangeBar_tickCount, 3));
            if (a(numValueOf.intValue())) {
                int iIntValue = numValueOf.intValue();
                this.m = iIntValue;
                this.G = 0;
                int i2 = iIntValue - 1;
                this.H = i2;
                a aVar = this.F;
                if (aVar != null) {
                    aVar.a(this, 0, i2);
                }
            } else {
                RVLogger.e(f24887a, "tickCount less than 2; invalid tickCount. XML input ignored.");
            }
            this.n = typedArrayObtainStyledAttributes.getDimension(R.styleable.RangeBar_tickHeight, 24.0f);
            this.o = typedArrayObtainStyledAttributes.getDimension(R.styleable.RangeBar_barWeight, 2.0f);
            this.p = typedArrayObtainStyledAttributes.getColor(R.styleable.RangeBar_editBarColor, e);
            this.q = typedArrayObtainStyledAttributes.getDimension(R.styleable.RangeBar_connectingLineWeight, 4.0f);
            this.r = typedArrayObtainStyledAttributes.getColor(R.styleable.RangeBar_connectingLineColor, i);
            this.u = typedArrayObtainStyledAttributes.getDimension(R.styleable.RangeBar_thumbRadius, -1.0f);
            this.s = typedArrayObtainStyledAttributes.getResourceId(R.styleable.RangeBar_thumbImageNormal, g);
            this.t = typedArrayObtainStyledAttributes.getResourceId(R.styleable.RangeBar_thumbImagePressed, h);
            this.v = typedArrayObtainStyledAttributes.getColor(R.styleable.RangeBar_thumbColorNormal, -1);
            this.w = typedArrayObtainStyledAttributes.getColor(R.styleable.RangeBar_thumbColorPressed, -1);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.I = paint;
            paint.setAntiAlias(true);
            this.I.setStrokeJoin(Paint.Join.MITER);
            this.I.setStrokeWidth(20.0f);
            this.I.setARGB(255, 255, 255, 255);
            this.I.setStrokeCap(Paint.Cap.SQUARE);
            this.I.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.J = paint2;
            paint2.setARGB(100, 0, 0, 0);
            this.J.setStrokeCap(Paint.Cap.SQUARE);
            this.J.setStyle(Paint.Style.FILL_AND_STROKE);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public RangeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 3;
        this.n = 24.0f;
        this.o = 2.0f;
        this.p = e;
        this.q = 4.0f;
        this.r = i;
        this.s = g;
        this.t = h;
        this.u = -1.0f;
        this.v = -1;
        this.w = -1;
        this.x = true;
        this.y = 500;
        this.z = 100;
        this.G = 0;
        this.H = 0 + 8;
        a(context, attributeSet);
    }

    public RangeBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 3;
        this.n = 24.0f;
        this.o = 2.0f;
        this.p = e;
        this.q = 4.0f;
        this.r = i;
        this.s = g;
        this.t = h;
        this.u = -1.0f;
        this.v = -1;
        this.w = -1;
        this.x = true;
        this.y = 500;
        this.z = 100;
        this.G = 0;
        this.H = 0 + 8;
        a(context, attributeSet);
    }

    private void a(float f2, float f3) {
        if (!this.A.x() && this.A.a(f2, f3)) {
            a(this.A);
        } else {
            if (this.A.x() || !this.B.a(f2, f3)) {
                return;
            }
            a(this.B);
        }
    }

    private void a(float f2) {
        if (this.A.x()) {
            a(this.A, f2, true);
        } else if (this.B.x()) {
            a(this.B, f2, false);
        }
        if (this.A.w() > this.B.w()) {
            f fVar = this.A;
            this.A = this.B;
            this.B = fVar;
        }
        int iB = this.C.b(this.A);
        int iB2 = this.C.b(this.B);
        if (this.A.x()) {
            if (iB2 - iB > this.E) {
                this.A.a(this.B.w() - (this.E * this.C.f24901a));
                invalidate();
                return;
            }
        } else if (this.B.x()) {
            int i2 = iB2 - iB;
            int i3 = this.E;
            if (i2 > i3) {
                this.B.a((iB + i3) * this.C.f24901a);
                invalidate();
                return;
            }
        }
        if (iB == this.G && iB2 == this.H) {
            return;
        }
        this.G = iB;
        this.H = iB2;
        a aVar = this.F;
        if (aVar != null) {
            aVar.a(this, iB, iB2);
        }
    }

    private void a(f fVar) {
        if (this.x) {
            this.x = false;
        }
        fVar.y();
        invalidate();
    }

    private void a(f fVar, float f2, boolean z) {
        if (z) {
            if (f2 < this.C.a() || f2 > this.C.b() || fVar.w() + (getMeasuredWidth() / this.m) >= this.B.w()) {
                return;
            }
            fVar.a(f2);
            invalidate();
            return;
        }
        if (f2 < this.C.a() || f2 > this.C.b() || fVar.w() - (getMeasuredWidth() / this.m) <= this.A.w()) {
            return;
        }
        fVar.a(f2);
        invalidate();
    }

    public void a() {
        System.out.println("---------------------->>>>>>>>> 调用了updateRightThumb");
        this.B.a((this.G + 8) * (getBarLength() / (getmTickCount() - 1)));
        invalidate();
    }
}
