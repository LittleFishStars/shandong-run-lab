package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class oj7 extends BitmapDrawable implements TransformAwareDrawable, Rounded {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f43761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Matrix f18648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f18649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f18650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f18651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransformCallback f18652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<Bitmap> f18653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f18655a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final Matrix f18656b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f18657b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Path f18658b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f18659b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18660b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final float[] f18661b;

    @VisibleForTesting
    public final Matrix c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f18662c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f18663c;

    @VisibleForTesting
    public final Matrix d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f18664d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f18665d;

    @VisibleForTesting
    public final Matrix e;

    @VisibleForTesting
    public final Matrix f;

    public oj7(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    public static oj7 h(Resources resources, BitmapDrawable bitmapDrawable) {
        return new oj7(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void a(@Nullable TransformCallback transformCallback) {
        this.f18652a = transformCallback;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int b() {
        return this.K;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float c() {
        return this.f43761a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void d(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f18655a, 0.0f);
            this.f18660b = false;
        } else {
            ax6.e(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f18655a, 0, 8);
            this.f18660b = false;
            for (int i = 0; i < 8; i++) {
                this.f18660b |= fArr[i] > 0.0f;
            }
        }
        this.f18663c = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!i()) {
            super.draw(canvas);
            return;
        }
        o();
        l();
        j();
        int iSave = canvas.save();
        canvas.concat(this.e);
        canvas.drawPath(this.f18650a, this.f18649a);
        float f = this.f43761a;
        if (f > 0.0f) {
            this.f18657b.setStrokeWidth(f);
            this.f18657b.setColor(mr2.c(this.K, this.f18649a.getAlpha()));
            canvas.drawPath(this.f18658b, this.f18657b);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean e() {
        return this.f18654a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float f() {
        return this.b;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void g(int i, float f) {
        if (this.K == i && this.f43761a == f) {
            return;
        }
        this.K = i;
        this.f43761a = f;
        this.f18663c = true;
        invalidateSelf();
    }

    @VisibleForTesting
    public boolean i() {
        return this.f18654a || this.f18660b || this.f43761a > 0.0f;
    }

    public final void j() {
        Bitmap bitmap = getBitmap();
        WeakReference<Bitmap> weakReference = this.f18653a;
        if (weakReference == null || weakReference.get() != bitmap) {
            this.f18653a = new WeakReference<>(bitmap);
            Paint paint = this.f18649a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.f18665d = true;
        }
        if (this.f18665d) {
            this.f18649a.getShader().setLocalMatrix(this.f);
            this.f18665d = false;
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void k(boolean z) {
        this.f18654a = z;
        this.f18663c = true;
        invalidateSelf();
    }

    public final void l() {
        float[] fArr;
        if (this.f18663c) {
            this.f18658b.reset();
            RectF rectF = this.f18651a;
            float f = this.f43761a;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.f18654a) {
                this.f18658b.addCircle(this.f18651a.centerX(), this.f18651a.centerY(), Math.min(this.f18651a.width(), this.f18651a.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i = 0;
                while (true) {
                    fArr = this.f18661b;
                    if (i >= fArr.length) {
                        break;
                    }
                    fArr[i] = (this.f18655a[i] + this.b) - (this.f43761a / 2.0f);
                    i++;
                }
                this.f18658b.addRoundRect(this.f18651a, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.f18651a;
            float f2 = this.f43761a;
            rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
            this.f18650a.reset();
            RectF rectF3 = this.f18651a;
            float f3 = this.b;
            rectF3.inset(f3, f3);
            if (this.f18654a) {
                this.f18650a.addCircle(this.f18651a.centerX(), this.f18651a.centerY(), Math.min(this.f18651a.width(), this.f18651a.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.f18650a.addRoundRect(this.f18651a, this.f18655a, Path.Direction.CW);
            }
            RectF rectF4 = this.f18651a;
            float f4 = this.b;
            rectF4.inset(-f4, -f4);
            this.f18650a.setFillType(Path.FillType.WINDING);
            this.f18663c = false;
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] m() {
        return this.f18655a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void n(float f) {
        if (this.b != f) {
            this.b = f;
            this.f18663c = true;
            invalidateSelf();
        }
    }

    public final void o() {
        TransformCallback transformCallback = this.f18652a;
        if (transformCallback != null) {
            transformCallback.o(this.c);
            this.f18652a.l(this.f18651a);
        } else {
            this.c.reset();
            this.f18651a.set(getBounds());
        }
        this.f18662c.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.f18664d.set(getBounds());
        this.f18648a.setRectToRect(this.f18662c, this.f18664d, Matrix.ScaleToFit.FILL);
        if (!this.c.equals(this.d) || !this.f18648a.equals(this.f18656b)) {
            this.f18665d = true;
            this.c.invert(this.e);
            this.f.set(this.c);
            this.f.preConcat(this.f18648a);
            this.d.set(this.c);
            this.f18656b.set(this.f18648a);
        }
        if (this.f18651a.equals(this.f18659b)) {
            return;
        }
        this.f18663c = true;
        this.f18659b.set(this.f18651a);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f18649a.getAlpha()) {
            this.f18649a.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f18649a.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        ax6.o(f >= 0.0f);
        Arrays.fill(this.f18655a, f);
        this.f18660b = f != 0.0f;
        this.f18663c = true;
        invalidateSelf();
    }

    public oj7(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.f18654a = false;
        this.f18660b = false;
        this.f18655a = new float[8];
        this.f18661b = new float[8];
        this.f18651a = new RectF();
        this.f18659b = new RectF();
        this.f18662c = new RectF();
        this.f18664d = new RectF();
        this.f18648a = new Matrix();
        this.f18656b = new Matrix();
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new Matrix();
        this.f43761a = 0.0f;
        this.K = 0;
        this.b = 0.0f;
        this.f18650a = new Path();
        this.f18658b = new Path();
        this.f18663c = true;
        Paint paint2 = new Paint();
        this.f18649a = paint2;
        Paint paint3 = new Paint(1);
        this.f18657b = paint3;
        this.f18665d = true;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }
}
