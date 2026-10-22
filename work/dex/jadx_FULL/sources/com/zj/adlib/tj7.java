package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class tj7 extends hx4 implements TransformAwareDrawable, Rounded {
    public int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f44935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Matrix f19830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f19831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f19832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Shader f19833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransformCallback f19834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<Bitmap> f19835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f19837a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final Matrix f19838b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f19839b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Path f19840b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f19841b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19842b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final float[] f19843b;

    @VisibleForTesting
    public final Matrix c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f19844c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f19845c;

    @VisibleForTesting
    public final Matrix d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @VisibleForTesting
    public final RectF f19846d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f19847d;

    @VisibleForTesting
    public final Matrix e;

    @VisibleForTesting
    public final Matrix f;

    public tj7(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void a(@Nullable TransformCallback transformCallback) {
        this.f19834a = transformCallback;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int b() {
        return this.O;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float c() {
        return this.f44935a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void d(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f19837a, 0.0f);
            this.f19842b = false;
        } else {
            ax6.e(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f19837a, 0, 8);
            this.f19842b = false;
            for (int i = 0; i < 8; i++) {
                this.f19842b |= fArr[i] > 0.0f;
            }
        }
        this.f19845c = true;
        invalidateSelf();
    }

    @Override // com.zj.adlib.hx4, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap bitmapI = i();
        Paint paintJ = j();
        if (bitmapI == null) {
            return;
        }
        if (!r()) {
            paintJ.setShader(null);
            canvas.drawBitmap(bitmapI, (Rect) null, bounds, paintJ);
            return;
        }
        s(bitmapI);
        u(bitmapI, bounds);
        t();
        int iSave = canvas.save();
        canvas.concat(this.e);
        canvas.drawPath(this.f19831a, j());
        float f = this.f44935a;
        if (f > 0.0f) {
            this.f19839b.setStrokeWidth(f);
            this.f19839b.setColor(mr2.c(this.O, j().getAlpha()));
            canvas.drawPath(this.f19840b, this.f19839b);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean e() {
        return this.f19836a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float f() {
        return this.b;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void g(int i, float f) {
        if (this.O == i && this.f44935a == f) {
            return;
        }
        this.O = i;
        this.f44935a = f;
        this.f19845c = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void k(boolean z) {
        this.f19836a = z;
        this.f19845c = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] m() {
        return this.f19837a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void n(float f) {
        if (this.b != f) {
            this.b = f;
            this.f19845c = true;
            invalidateSelf();
        }
    }

    @VisibleForTesting
    public Path q() {
        return this.f19831a;
    }

    @VisibleForTesting
    public boolean r() {
        return this.f19836a || this.f19842b || this.f44935a > 0.0f;
    }

    public final void s(Bitmap bitmap) {
        Paint paintJ = j();
        WeakReference<Bitmap> weakReference = this.f19835a;
        if (weakReference == null || weakReference.get() != bitmap) {
            this.f19835a = new WeakReference<>(bitmap);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f19833a = new BitmapShader(bitmap, tileMode, tileMode);
            this.f19847d = true;
        }
        if (this.f19847d) {
            this.f19833a.setLocalMatrix(this.f);
            this.f19847d = false;
        }
        Shader shader = paintJ.getShader();
        Shader shader2 = this.f19833a;
        if (shader != shader2) {
            paintJ.setShader(shader2);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        ax6.o(f >= 0.0f);
        Arrays.fill(this.f19837a, f);
        this.f19842b = f != 0.0f;
        this.f19845c = true;
        invalidateSelf();
    }

    public final void t() {
        float[] fArr;
        if (this.f19845c) {
            this.f19840b.reset();
            RectF rectF = this.f19832a;
            float f = this.f44935a;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.f19836a) {
                this.f19840b.addCircle(this.f19832a.centerX(), this.f19832a.centerY(), Math.min(this.f19832a.width(), this.f19832a.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i = 0;
                while (true) {
                    fArr = this.f19843b;
                    if (i >= fArr.length) {
                        break;
                    }
                    fArr[i] = (this.f19837a[i] + this.b) - (this.f44935a / 2.0f);
                    i++;
                }
                this.f19840b.addRoundRect(this.f19832a, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.f19832a;
            float f2 = this.f44935a;
            rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
            this.f19831a.reset();
            RectF rectF3 = this.f19832a;
            float f3 = this.b;
            rectF3.inset(f3, f3);
            if (this.f19836a) {
                this.f19831a.addCircle(this.f19832a.centerX(), this.f19832a.centerY(), Math.min(this.f19832a.width(), this.f19832a.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.f19831a.addRoundRect(this.f19832a, this.f19837a, Path.Direction.CW);
            }
            RectF rectF4 = this.f19832a;
            float f4 = this.b;
            rectF4.inset(-f4, -f4);
            this.f19831a.setFillType(Path.FillType.WINDING);
            this.f19845c = false;
        }
    }

    public final void u(Bitmap bitmap, Rect rect) {
        TransformCallback transformCallback = this.f19834a;
        if (transformCallback != null) {
            transformCallback.o(this.c);
            this.f19834a.l(this.f19832a);
        } else {
            this.c.reset();
            this.f19832a.set(rect);
        }
        this.f19844c.set(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        this.f19846d.set(rect);
        this.f19830a.setRectToRect(this.f19844c, this.f19846d, Matrix.ScaleToFit.FILL);
        if (!this.c.equals(this.d) || !this.f19830a.equals(this.f19838b)) {
            this.f19847d = true;
            this.c.invert(this.e);
            this.f.set(this.c);
            this.f.preConcat(this.f19830a);
            this.d.set(this.c);
            this.f19838b.set(this.f19830a);
        }
        if (this.f19832a.equals(this.f19841b)) {
            return;
        }
        this.f19845c = true;
        this.f19841b.set(this.f19832a);
    }

    public tj7(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap, paint);
        this.f19836a = false;
        this.f19842b = false;
        this.f19837a = new float[8];
        this.f19843b = new float[8];
        this.f19832a = new RectF();
        this.f19841b = new RectF();
        this.f19844c = new RectF();
        this.f19846d = new RectF();
        this.f19830a = new Matrix();
        this.f19838b = new Matrix();
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new Matrix();
        this.f44935a = 0.0f;
        this.O = 0;
        this.b = 0.0f;
        this.f19831a = new Path();
        this.f19840b = new Path();
        this.f19845c = true;
        Paint paint2 = new Paint(1);
        this.f19839b = paint2;
        this.f19847d = true;
        j().setFlags(1);
        paint2.setStyle(Paint.Style.STROKE);
    }
}
