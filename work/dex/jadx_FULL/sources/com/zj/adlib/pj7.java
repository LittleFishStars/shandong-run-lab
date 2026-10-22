package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.Rounded;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class pj7 extends Drawable implements Rounded {
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f43995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Paint f18860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Path f18861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f18862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f18864a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final Path f18865b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final float[] f18866b;

    public pj7(int i) {
        this.f18864a = new float[8];
        this.f18866b = new float[8];
        this.f18860a = new Paint(1);
        this.f18863a = false;
        this.f43995a = 0.0f;
        this.b = 0.0f;
        this.K = 0;
        this.f18861a = new Path();
        this.f18865b = new Path();
        this.L = 0;
        this.f18862a = new RectF();
        this.M = 255;
        i(i);
    }

    public static pj7 a(ColorDrawable colorDrawable) {
        return new pj7(colorDrawable.getColor());
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int b() {
        return this.K;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float c() {
        return this.f43995a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void d(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f18864a, 0.0f);
        } else {
            ax6.e(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f18864a, 0, 8);
        }
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f18860a.setColor(mr2.c(this.L, this.M));
        this.f18860a.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f18861a, this.f18860a);
        if (this.f43995a != 0.0f) {
            this.f18860a.setColor(mr2.c(this.K, this.M));
            this.f18860a.setStyle(Paint.Style.STROKE);
            this.f18860a.setStrokeWidth(this.f43995a);
            canvas.drawPath(this.f18865b, this.f18860a);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean e() {
        return this.f18863a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float f() {
        return this.b;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void g(int i, float f) {
        if (this.K != i) {
            this.K = i;
            invalidateSelf();
        }
        if (this.f43995a != f) {
            this.f43995a = f;
            j();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.M;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return mr2.b(mr2.c(this.L, this.M));
    }

    public int h() {
        return this.L;
    }

    public void i(int i) {
        if (this.L != i) {
            this.L = i;
            invalidateSelf();
        }
    }

    public final void j() {
        float[] fArr;
        this.f18861a.reset();
        this.f18865b.reset();
        this.f18862a.set(getBounds());
        RectF rectF = this.f18862a;
        float f = this.f43995a;
        rectF.inset(f / 2.0f, f / 2.0f);
        if (this.f18863a) {
            this.f18865b.addCircle(this.f18862a.centerX(), this.f18862a.centerY(), Math.min(this.f18862a.width(), this.f18862a.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.f18866b;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.f18864a[i] + this.b) - (this.f43995a / 2.0f);
                i++;
            }
            this.f18865b.addRoundRect(this.f18862a, fArr, Path.Direction.CW);
        }
        RectF rectF2 = this.f18862a;
        float f2 = this.f43995a;
        rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
        RectF rectF3 = this.f18862a;
        float f3 = this.b;
        rectF3.inset(f3, f3);
        if (this.f18863a) {
            this.f18861a.addCircle(this.f18862a.centerX(), this.f18862a.centerY(), Math.min(this.f18862a.width(), this.f18862a.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.f18861a.addRoundRect(this.f18862a, this.f18864a, Path.Direction.CW);
        }
        RectF rectF4 = this.f18862a;
        float f4 = this.b;
        rectF4.inset(-f4, -f4);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void k(boolean z) {
        this.f18863a = z;
        j();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] m() {
        return this.f18864a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void n(float f) {
        if (this.b != f) {
            this.b = f;
            j();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        j();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.M) {
            this.M = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        ax6.e(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.f18864a, f);
        j();
        invalidateSelf();
    }

    public pj7(float[] fArr, int i) {
        this(i);
        d(fArr);
    }

    public pj7(float f, int i) {
        this(i);
        setRadius(f);
    }
}
