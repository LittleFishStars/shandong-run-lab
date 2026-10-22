package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.acse.ottn.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActivityIndicatorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23285a;
    public int b;
    public float c;
    public boolean d;
    public final int e;
    public final int f;
    public final int g;
    public int[] h;
    public Paint i;
    public Handler j;
    public Runnable k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityIndicatorView.a(ActivityIndicatorView.this, 30);
            ActivityIndicatorView.this.invalidate();
            ActivityIndicatorView.this.j.postDelayed(ActivityIndicatorView.this.k, 100L);
        }
    }

    public ActivityIndicatorView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int a(ActivityIndicatorView activityIndicatorView, int i) {
        int i2 = activityIndicatorView.b + i;
        activityIndicatorView.b = i2;
        return i2;
    }

    public void c() {
        this.j.removeCallbacks(this.k);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d) {
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null) {
            c();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float fMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        if (this.c == 0.0f) {
            this.c = a(15, fMin / 2.0f) / 2.0f;
        }
        this.i.setStrokeWidth(this.c);
        int i = 0;
        while (true) {
            int[] iArr = this.h;
            if (i >= iArr.length) {
                return;
            }
            this.i.setColor(iArr[i]);
            float f = width;
            int i2 = i * (-30);
            float f2 = fMin / 2.0f;
            float f3 = height;
            canvas.drawLine(f + a(this.b + i2, f2), f3 + b(this.b + i2, f2), f + a(this.b + i2, fMin - (this.c / 2.0f)), f3 + b(i2 + this.b, fMin - (this.c / 2.0f)), this.i);
            i++;
        }
    }

    public void setColor(int i) {
        this.f23285a = i;
    }

    public void setStartAngle(int i) {
        this.b = i;
    }

    public void setStrokeWidth(float f) {
        this.c = f;
    }

    public ActivityIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float b(int i, float f) {
        return (float) (((double) f) * Math.sin((((double) i) * 3.141592653589793d) / 180.0d));
    }

    public ActivityIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23285a = Color.argb(255, 255, 255, 255);
        this.b = 0;
        this.c = 0.0f;
        this.e = 12;
        this.f = 0;
        this.g = 30;
        this.h = new int[12];
        this.j = new Handler(Looper.getMainLooper());
        this.k = new a();
        a(context, attributeSet, i, 0);
    }

    public final void a(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityIndicatorView, i, i2);
        this.f23285a = typedArrayObtainStyledAttributes.getColor(R.styleable.ActivityIndicatorView_aiv_color, this.f23285a);
        this.b = typedArrayObtainStyledAttributes.getInt(R.styleable.ActivityIndicatorView_aiv_startAngle, this.b);
        this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActivityIndicatorView_aiv_strokeWidth, this.c);
        this.d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActivityIndicatorView_aiv_auto_start, true);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public void b() {
        this.j.post(this.k);
    }

    public final void a() {
        this.i = new Paint(1);
        int iAlpha = Color.alpha(this.f23285a);
        int iRed = Color.red(this.f23285a);
        int iGreen = Color.green(this.f23285a);
        int iBlue = Color.blue(this.f23285a);
        int iAbs = Math.abs(iAlpha + 0) / 12;
        int i = 0;
        while (true) {
            int[] iArr = this.h;
            if (i < iArr.length) {
                iArr[i] = Color.argb(iAlpha - (iAbs * i), iRed, iGreen, iBlue);
                i++;
            } else {
                this.i.setStrokeCap(Paint.Cap.ROUND);
                return;
            }
        }
    }

    public final float a(int i, float f) {
        return (float) (((double) f) * Math.cos((((double) i) * 3.141592653589793d) / 180.0d));
    }
}
