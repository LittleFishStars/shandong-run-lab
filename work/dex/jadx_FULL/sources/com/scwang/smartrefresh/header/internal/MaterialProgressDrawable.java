package com.scwang.smartrefresh.header.internal;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    public static final int K = 1332;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f40385a = 0;
    public static final byte b = 1;
    public static final byte c = 40;
    public static final byte d = 56;
    public static final byte e = 5;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final float f15088e = 1080.0f;
    public static final byte f = 10;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final float f15089f = 8.75f;
    public static final byte g = 5;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final float f15090g = 2.5f;
    public static final byte h = 12;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final float f15091h = 12.5f;
    public static final byte i = 6;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final float f15092i = 3.0f;
    public static final float j = 0.75f;
    public static final float k = 0.5f;
    public static final float l = 0.5f;
    public static final float m = 5.0f;
    public static final float n = 0.8f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f15093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f15094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Animation f15095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15098a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f15099b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f15100c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public float f15101d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Interpolator f15085a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Interpolator f15087b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f15086a = {-16777216};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Animation> f15097a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f15096a = new c();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public class a extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f40386a;

        public a(c cVar) {
            this.f40386a = cVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.f15098a) {
                materialProgressDrawable.a(f, this.f40386a);
                return;
            }
            float fC = materialProgressDrawable.c(this.f40386a);
            c cVar = this.f40386a;
            float f2 = cVar.g;
            float f3 = cVar.f;
            float f4 = cVar.h;
            MaterialProgressDrawable.this.m(f, cVar);
            if (f <= 0.5f) {
                this.f40386a.f15104a = f3 + ((0.8f - fC) * MaterialProgressDrawable.f15087b.getInterpolation(f / 0.5f));
            }
            if (f > 0.5f) {
                this.f40386a.b = f2 + ((0.8f - fC) * MaterialProgressDrawable.f15087b.getInterpolation((f - 0.5f) / 0.5f));
            }
            MaterialProgressDrawable.this.g(f4 + (0.25f * f));
            MaterialProgressDrawable materialProgressDrawable2 = MaterialProgressDrawable.this;
            materialProgressDrawable2.h((f * 216.0f) + ((materialProgressDrawable2.f15099b / 5.0f) * 1080.0f));
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f40387a;

        public b(c cVar) {
            this.f40387a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f40387a.j();
            this.f40387a.f();
            c cVar = this.f40387a;
            cVar.f15104a = cVar.b;
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (!materialProgressDrawable.f15098a) {
                materialProgressDrawable.f15099b = (materialProgressDrawable.f15099b + 1.0f) % 5.0f;
                return;
            }
            materialProgressDrawable.f15098a = false;
            animation.setDuration(1332L);
            MaterialProgressDrawable.this.l(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.f15099b = 0.0f;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f40388a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public float f15104a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f15105a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Paint f15106a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Path f15107a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final RectF f15108a = new RectF();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f15110a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f15111a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f15112b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final Paint f15113b;
        public float c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f15114c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final Paint f15115c;
        public float d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public int f15116d;
        public float e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public int f15117e;
        public float f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public int f15118f;
        public float g;
        public float h;
        public float i;

        public c() {
            Paint paint = new Paint();
            this.f15106a = paint;
            Paint paint2 = new Paint();
            this.f15113b = paint2;
            this.f15104a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 5.0f;
            this.e = 2.5f;
            this.f15115c = new Paint(1);
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f15108a;
            rectF.set(rect);
            float f = this.e;
            rectF.inset(f, f);
            float f2 = this.f15104a;
            float f3 = this.c;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.b + f3) * 360.0f) - f4;
            if (f5 != 0.0f) {
                this.f15106a.setColor(this.f15118f);
                canvas.drawArc(rectF, f4, f5, false, this.f15106a);
            }
            b(canvas, f4, f5, rect);
            if (this.f15116d < 255) {
                this.f15115c.setColor(this.f15117e);
                this.f15115c.setAlpha(255 - this.f15116d);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2.0f, this.f15115c);
            }
        }

        public final void b(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f15110a) {
                Path path = this.f15107a;
                if (path == null) {
                    Path path2 = new Path();
                    this.f15107a = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.e) / 2) * this.i;
                float fCos = (float) ((this.f40388a * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) rect.exactCenterX()));
                float fSin = (float) ((this.f40388a * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) rect.exactCenterY()));
                this.f15107a.moveTo(0.0f, 0.0f);
                this.f15107a.lineTo(this.f15112b * this.i, 0.0f);
                Path path3 = this.f15107a;
                float f4 = this.f15112b;
                float f5 = this.i;
                path3.lineTo((f4 * f5) / 2.0f, this.f15114c * f5);
                this.f15107a.offset(fCos - f3, fSin);
                this.f15107a.close();
                this.f15113b.setColor(this.f15118f);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f15107a, this.f15113b);
            }
        }

        public int c() {
            return this.f15111a[d()];
        }

        public final int d() {
            return (this.f15105a + 1) % this.f15111a.length;
        }

        public int e() {
            return this.f15111a[this.f15105a];
        }

        public void f() {
            h(d());
        }

        public void g() {
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            this.f15104a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
        }

        public void h(int i) {
            this.f15105a = i;
            this.f15118f = this.f15111a[i];
        }

        public void i(int i, int i2) {
            float fMin = Math.min(i, i2);
            double d = this.f40388a;
            this.e = (float) ((d <= AudioStats.AUDIO_AMPLITUDE_NONE || fMin < 0.0f) ? Math.ceil(this.d / 2.0f) : ((double) (fMin / 2.0f)) - d);
        }

        public void j() {
            this.f = this.f15104a;
            this.g = this.b;
            this.h = this.c;
        }
    }

    public MaterialProgressDrawable(View view) {
        this.f15094a = view;
        f(f15086a);
        n(1);
        k();
    }

    public void a(float f2, c cVar) {
        m(f2, cVar);
        float fFloor = (float) (Math.floor(cVar.h / 0.8f) + 1.0d);
        float fC = c(cVar);
        float f3 = cVar.f;
        float f4 = cVar.g;
        j(f3 + (((f4 - fC) - f3) * f2), f4);
        float f5 = cVar.h;
        g(f5 + ((fFloor - f5) * f2));
    }

    public final int b(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
    }

    public float c(c cVar) {
        return (float) Math.toRadians(((double) cVar.d) / (cVar.f40388a * 6.283185307179586d));
    }

    public void d(float f2) {
        c cVar = this.f15096a;
        if (cVar.i != f2) {
            cVar.i = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.rotate(this.f15093a, bounds.exactCenterX(), bounds.exactCenterY());
        this.f15096a.a(canvas, bounds);
        canvas.restoreToCount(iSave);
    }

    public void e(@ColorInt int i2) {
        this.f15096a.f15117e = i2;
    }

    public void f(@ColorInt int... iArr) {
        c cVar = this.f15096a;
        cVar.f15111a = iArr;
        cVar.h(0);
    }

    public void g(float f2) {
        this.f15096a.c = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f15096a.f15116d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f15101d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f15100c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(float f2) {
        this.f15093a = f2;
        invalidateSelf();
    }

    public final void i(int i2, int i3, float f2, float f3, float f4, float f5) {
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        this.f15100c = i2 * f6;
        this.f15101d = i3 * f6;
        this.f15096a.h(0);
        float f7 = f3 * f6;
        this.f15096a.f15106a.setStrokeWidth(f7);
        c cVar = this.f15096a;
        cVar.d = f7;
        cVar.f40388a = f2 * f6;
        cVar.f15112b = (int) (f4 * f6);
        cVar.f15114c = (int) (f5 * f6);
        cVar.i((int) this.f15100c, (int) this.f15101d);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        List<Animation> list = this.f15097a;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animation animation = list.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void j(float f2, float f3) {
        c cVar = this.f15096a;
        cVar.f15104a = f2;
        cVar.b = f3;
        invalidateSelf();
    }

    public final void k() {
        c cVar = this.f15096a;
        a aVar = new a(cVar);
        aVar.setRepeatCount(-1);
        aVar.setRepeatMode(1);
        aVar.setInterpolator(f15085a);
        aVar.setAnimationListener(new b(cVar));
        this.f15095a = aVar;
    }

    public void l(boolean z) {
        c cVar = this.f15096a;
        if (cVar.f15110a != z) {
            cVar.f15110a = z;
            invalidateSelf();
        }
    }

    public void m(float f2, c cVar) {
        if (f2 > 0.75f) {
            cVar.f15118f = b((f2 - 0.75f) / 0.25f, cVar.e(), cVar.c());
        }
    }

    public void n(int i2) {
        if (i2 == 0) {
            i(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            i(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f15096a.f15116d = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15096a.f15106a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f15095a.reset();
        this.f15096a.j();
        c cVar = this.f15096a;
        if (cVar.b != cVar.f15104a) {
            this.f15098a = true;
            this.f15095a.setDuration(666L);
            this.f15094a.startAnimation(this.f15095a);
        } else {
            cVar.h(0);
            this.f15096a.g();
            this.f15095a.setDuration(1332L);
            this.f15094a.startAnimation(this.f15095a);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f15094a.clearAnimation();
        this.f15096a.h(0);
        this.f15096a.g();
        l(false);
        h(0.0f);
    }
}
