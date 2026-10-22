package com.byazt.xd;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 520, 13})
public class tt extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f29175a;
    public final Drawable c;
    public float cu;
    public LinearGradient d;
    public final boolean da;
    public LinearGradient eo;
    public float gr;
    public final Matrix gt;
    public LinearGradient gu;
    public PorterDuffXfermode h;
    public final int i;
    public final RectF m;
    public Paint md;
    public final Path my;
    public final int[] n;
    public boolean nb = true;
    public final Path nu;
    public LinearGradient or;
    public Paint p;
    public Bitmap qp;
    public LinearGradient qy;
    public final RectF rh;
    public final Paint rl;
    public final float sl;
    public final boolean sp;
    public final float t;
    public final float tt;
    public final int u;
    public final boolean uj;
    public final float[] ve;
    public final int x;
    public final int[] yp;
    public boolean yv;
    public final float[] z;
    public LinearGradient zb;
    public ValueAnimator zm;

    public tt(Drawable drawable, int[] iArr, float[] fArr, float f, float[] fArr2, boolean z, int i, int i2, boolean z2, float f2, float f3, int i3, int[] iArr2, float[] fArr3) {
        this.c = drawable;
        this.tt = f;
        this.ve = fArr2;
        this.uj = (iArr == null || fArr == null) ? false : true;
        this.n = iArr;
        this.f29175a = fArr;
        this.sp = z;
        this.x = i <= 0 ? SecExceptionCode.SEC_ERROR_LBSRISK : i;
        this.i = i2;
        this.da = z2;
        this.sl = f2;
        this.t = Math.max(0.0f, Math.min(1.0f, f3));
        this.u = Math.max(2, Math.min(i3, 50));
        this.yp = iArr2;
        this.z = fArr3;
        this.m = new RectF();
        this.nu = new Path();
        this.rh = new RectF();
        this.my = new Path();
        this.gt = new Matrix();
        Paint paint = new Paint(1);
        this.rl = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        if (z2) {
            Paint paint2 = new Paint(1);
            this.p = paint2;
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint(1);
            this.md = paint3;
            paint3.setStyle(Paint.Style.FILL);
            this.h = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        }
    }

    private void n() {
        tt();
        this.yv = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.gr);
        this.zm = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.x);
        this.zm.setInterpolator(new LinearInterpolator());
        int i = this.i;
        if (i == -1) {
            this.zm.setRepeatCount(-1);
        } else {
            this.zm.setRepeatCount(Math.max(0, i - 1));
        }
        this.zm.setRepeatMode(1);
        this.zm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.xd.tt.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                tt.this.gt.setTranslate(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                if (tt.this.qy != null) {
                    tt.this.qy.setLocalMatrix(tt.this.gt);
                }
                if (tt.this.gu != null) {
                    tt.this.gu.setLocalMatrix(tt.this.gt);
                }
                tt.this.invalidateSelf();
            }
        });
        this.zm.start();
    }

    private void uj() {
        RectF rectF = this.rh;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        this.cu = Math.min(this.sl, Math.min(rectF.width(), this.rh.height()) / 2.0f);
        int i = this.u;
        int[] iArr = new int[i];
        float[] fArr = new float[i];
        int i2 = 0;
        while (true) {
            int i3 = this.u;
            if (i2 >= i3) {
                this.d = new LinearGradient(0.0f, f2, 0.0f, f2 + this.cu, iArr, fArr, Shader.TileMode.CLAMP);
                this.eo = new LinearGradient(0.0f, f4, 0.0f, f4 - this.cu, iArr, fArr, Shader.TileMode.CLAMP);
                this.zb = new LinearGradient(f, 0.0f, this.cu + f, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                this.or = new LinearGradient(f3, 0.0f, f3 - this.cu, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                this.p.setShader(this.gu);
                return;
            }
            float f5 = i2 / (i3 - 1);
            fArr[i2] = f5;
            if (i2 == i3 - 1) {
                iArr[i2] = 16777215;
            } else {
                double d = f5;
                iArr[i2] = (((int) (Math.exp(((-4.0d) * d) * d) * 255.0d)) << 24) | 16777215;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.c.draw(canvas);
        if (this.da && this.gu != null) {
            c(canvas);
        }
        if (!this.uj || this.qy == null) {
            return;
        }
        canvas.drawPath(this.nu, this.rl);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.setBounds(rect);
        float f = this.tt / 2.0f;
        this.m.set(rect.left + f, rect.top + f, rect.right - f, rect.bottom - f);
        this.nu.reset();
        float[] fArr = this.ve;
        if (fArr != null) {
            this.nu.addRoundRect(this.m, fArr, Path.Direction.CW);
        } else {
            this.nu.addRect(this.m, Path.Direction.CW);
        }
        this.rh.set(rect.left, rect.top, rect.right, rect.bottom);
        this.my.reset();
        float[] fArr2 = this.ve;
        if (fArr2 != null) {
            this.my.addRoundRect(this.rh, fArr2, Path.Direction.CW);
        } else {
            this.my.addRect(this.rh, Path.Direction.CW);
        }
        this.gr = this.m.width();
        if (this.uj) {
            this.qy = new LinearGradient(0.0f, 0.0f, this.gr, 0.0f, this.n, this.f29175a, Shader.TileMode.REPEAT);
            this.gt.reset();
            this.rl.setShader(this.qy);
        }
        if (this.da) {
            this.gu = new LinearGradient(0.0f, 0.0f, this.gr, 0.0f, this.yp, this.z, Shader.TileMode.REPEAT);
            uj();
            this.nb = true;
        }
        if (this.yv) {
            n();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c.setAlpha(i);
        this.rl.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    private void c(Canvas canvas) {
        Bitmap bitmap;
        RectF rectF = this.rh;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        float f5 = this.cu;
        int i = (int) (f3 - f);
        int i2 = (int) (f4 - f2);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.sp) {
            canvas.save();
            canvas.clipPath(this.my);
            canvas.saveLayer(f, f2, f3, f4, null);
            c(canvas, f, f2, f3, f4, f5);
            this.p.setAlpha((int) (this.t * 255.0f));
            this.p.setXfermode(this.h);
            canvas.drawRect(f, f2, f3, f4, this.p);
            this.p.setXfermode(null);
            canvas.restore();
            canvas.restore();
            return;
        }
        if (this.nb || (bitmap = this.qp) == null || bitmap.getWidth() < i || this.qp.getHeight() < i2) {
            Bitmap bitmap2 = this.qp;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.qp = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(this.qp);
            canvas2.translate(-f, -f2);
            canvas2.save();
            canvas2.clipPath(this.my);
            canvas2.saveLayer(f, f2, f3, f4, null);
            c(canvas2, f, f2, f3, f4, f5);
            this.p.setAlpha((int) (this.t * 255.0f));
            this.p.setXfermode(this.h);
            canvas2.drawRect(f, f2, f3, f4, this.p);
            this.p.setXfermode(null);
            canvas2.restore();
            canvas2.restore();
            this.nb = false;
        }
        canvas.drawBitmap(this.qp, f, f2, (Paint) null);
    }

    public void tt() {
        this.yv = false;
        ValueAnimator valueAnimator = this.zm;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.zm = null;
        }
    }

    public boolean ve() {
        return this.sp;
    }

    private void c(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        this.md.setShader(this.d);
        canvas.drawRect(f, f2, f3, f2 + f5, this.md);
        this.md.setShader(this.eo);
        canvas.drawRect(f, f4 - f5, f3, f4, this.md);
        this.md.setShader(this.zb);
        canvas.drawRect(f, f2, f + f5, f4, this.md);
        this.md.setShader(this.or);
        canvas.drawRect(f3 - f5, f2, f3, f4, this.md);
    }

    public void c() {
        if (this.sp) {
            this.yv = true;
            if (this.gr > 0.0f) {
                if (this.qy == null && this.gu == null) {
                    return;
                }
                n();
            }
        }
    }
}
