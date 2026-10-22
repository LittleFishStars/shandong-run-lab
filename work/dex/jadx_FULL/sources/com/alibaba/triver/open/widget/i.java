package com.alibaba.triver.open.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Interpolator f25103a = new LinearInterpolator();
    private static final Interpolator b = new DecelerateInterpolator();
    private static final int c = 2000;
    private static final int d = 600;
    private static final int e = 30;
    private final RectF f = new RectF();
    private ObjectAnimator g;
    private ObjectAnimator h;
    private boolean i;
    private Paint j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private Property<i, Float> p;
    private Property<i, Float> q;

    public i(int i, float f) {
        Class<Float> cls = Float.class;
        this.p = new Property<i, Float>(cls, "angle") { // from class: com.alibaba.triver.open.widget.i.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(i iVar) {
                return Float.valueOf(iVar.a());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(i iVar, Float f2) {
                iVar.a(f2.floatValue());
            }
        };
        this.q = new Property<i, Float>(cls, "arc") { // from class: com.alibaba.triver.open.widget.i.2
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(i iVar) {
                return Float.valueOf(iVar.b());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(i iVar, Float f2) {
                iVar.b(f2.floatValue());
            }
        };
        this.n = f;
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(f);
        this.j.setColor(i);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z = !this.i;
        this.i = z;
        if (z) {
            this.k = (this.k + 60.0f) % 360.0f;
        }
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.p, 360.0f);
        this.h = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(f25103a);
        this.h.setDuration(2000L);
        this.h.setRepeatMode(1);
        this.h.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, this.q, 300.0f);
        this.g = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(b);
        this.g.setDuration(600L);
        this.g.setRepeatMode(1);
        this.g.setRepeatCount(-1);
        this.g.addListener(new Animator.AnimatorListener() { // from class: com.alibaba.triver.open.widget.i.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                i.this.c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public void b(float f) {
        this.m = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        float f2 = this.l - this.k;
        float f3 = this.m;
        if (this.i) {
            f = f3 + 30.0f;
        } else {
            f2 += f3;
            f = (360.0f - f3) - 30.0f;
        }
        canvas.drawArc(this.f, f2, f, false, this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.f;
        float f = rect.left;
        float f2 = this.n;
        rectF.left = f + (f2 / 2.0f) + 0.5f;
        rectF.right = (rect.right - (f2 / 2.0f)) - 0.5f;
        rectF.top = rect.top + (f2 / 2.0f) + 0.5f;
        rectF.bottom = (rect.bottom - (f2 / 2.0f)) - 0.5f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.j.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.o = true;
        this.h.start();
        this.g.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.o = false;
            this.h.cancel();
            this.g.cancel();
            invalidateSelf();
        }
    }

    public void a(float f) {
        this.l = f;
        invalidateSelf();
    }

    public float b() {
        return this.m;
    }

    public void c(float f) {
        this.j.setStrokeWidth(f);
        invalidateSelf();
    }

    public float a() {
        return this.l;
    }

    public void a(int i) {
        this.j.setColor(i);
        invalidateSelf();
    }
}
