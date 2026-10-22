package com.ipd.dsp.internal.t1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k extends AnimationDrawable {
    public final int A;
    public final Bitmap f;
    public final Bitmap g;
    public final Bitmap h;
    public final Bitmap i;
    public final Bitmap j;
    public Bitmap k;
    public final int l;
    public final RectF m;
    public final Paint n;
    public final Paint o;
    public final PorterDuffXfermode p;
    public final int q;
    public final int r;
    public float s;
    public float t;
    public final RectF u;
    public final Paint v;
    public int w;
    public int x;
    public final ValueAnimator y;
    public float z;

    public k(Context context, int i) {
        this(context, i, 1);
    }

    public final /* synthetic */ void a(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.z = fFloatValue;
        a(fFloatValue);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.u != null) {
            canvas.save();
            canvas.translate((getIntrinsicWidth() - this.w) / 2, (getIntrinsicHeight() - this.x) / 2);
            float f = this.z;
            if (f <= 6.0f) {
                this.v.setAlpha((int) ((f * 255.0f) / 6.0f));
                this.o.setAlpha(255);
            } else {
                int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
                this.v.setAlpha(i);
                this.o.setAlpha(i);
            }
            int iSave = canvas.save();
            int iSaveLayer = canvas.saveLayer(this.u, this.v, 31);
            canvas.drawBitmap(this.k, (Rect) null, this.u, this.v);
            this.n.setXfermode(this.p);
            int i2 = this.A;
            if (i2 == 0) {
                canvas.drawBitmap(this.i, (Rect) null, this.m, this.n);
                canvas.drawBitmap(this.j, (Rect) null, this.m, this.n);
            } else if (i2 == 1) {
                canvas.drawBitmap(this.g, (Rect) null, this.m, this.n);
                canvas.drawBitmap(this.h, (Rect) null, this.m, this.n);
            }
            canvas.drawBitmap(this.f, (Rect) null, this.m, this.n);
            canvas.restoreToCount(iSaveLayer);
            canvas.drawBitmap(this.f, (Rect) null, this.m, this.o);
            canvas.restoreToCount(iSave);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.x + this.r + this.l;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.w + this.q;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.y;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public k(Context context, int i, int i2) {
        this.A = i;
        int iA = ((int) s.a(context, 51.0f)) * i2;
        this.q = iA;
        int iA2 = ((int) s.a(context, 61.0f)) * i2;
        this.r = iA2;
        this.f = BitmapFactory.decodeResource(context.getResources(), R.drawable.ipd_ic_slide_hand);
        this.g = BitmapFactory.decodeResource(context.getResources(), R.drawable.ipd_ic_slide_hand_lt);
        this.h = BitmapFactory.decodeResource(context.getResources(), R.drawable.ipd_ic_slide_hand_lb);
        this.i = BitmapFactory.decodeResource(context.getResources(), R.drawable.ipd_ic_slide_hand_rt);
        this.j = BitmapFactory.decodeResource(context.getResources(), R.drawable.ipd_ic_slide_hand_rb);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.ipd_ic_slide_bg);
        if (i == 0) {
            this.k = bitmapDecodeResource;
        } else if (i == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.k = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
        } else if (i == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.k = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix2, true);
        }
        this.l = (int) s.a(context, 10.0f);
        this.v = new Paint(1);
        if (i == 0) {
            this.x = ((int) s.a(context, 168.0f)) * i2;
            int iA3 = (int) s.a(context, 60.0f);
            this.w = iA3;
            this.s = (-iA2) * 0.22f;
            this.t = iA3 * 0.08f;
        } else if (i == 1) {
            this.x = (int) s.a(context, 60.0f);
            this.w = ((int) s.a(context, 168.0f)) * i2;
            this.s = this.x * 0.09f;
            this.t = (-iA) * 0.2f;
        } else if (i == 2) {
            this.x = (int) s.a(context, 60.0f);
            this.w = ((int) s.a(context, 168.0f)) * i2;
            this.s = this.x * 0.09f;
            this.t = (-iA) * 0.5f;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.w, this.x);
        this.u = rectF;
        this.n = new Paint(3);
        Paint paint = new Paint(3);
        this.o = paint;
        paint.setDither(true);
        float f = rectF.right;
        this.m = new RectF(f - iA, 0.0f, f, iA2);
        this.p = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.y = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1100L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.zfb
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f46255a.a(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setRepeatCount(-1);
    }

    public final void a(float f) {
        if (f < 6.0f) {
            float f2 = f / 6.0f;
            int i = this.A;
            if (i == 0) {
                RectF rectF = this.u;
                float f3 = this.x * (1.0f - f2);
                rectF.top = f3;
                this.m.offsetTo(rectF.left + this.t, f3 + this.s);
                return;
            }
            if (i == 1) {
                RectF rectF2 = this.u;
                float f4 = this.w * (1.0f - f2);
                rectF2.left = f4;
                this.m.offsetTo(f4 + this.t, rectF2.top + this.s);
                return;
            }
            if (i != 2) {
                return;
            }
            RectF rectF3 = this.u;
            float f5 = this.w * f2;
            rectF3.right = f5;
            this.m.offsetTo(f5 + this.t, rectF3.top + this.s);
        }
    }
}
