package com.byazt.vrg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 2324, 2325})
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29141a;
    public final float c;
    public final PorterDuffXfermode da;
    public float gt;
    public Paint i;
    public long m;
    public float my;
    public final float n;
    public int nu;
    public float rh;
    public float rl;
    public float sl;
    public int sp;
    public boolean t;
    public final float tt;
    public boolean u;
    public final float uj;
    public final float ve;
    public int x;
    public int yp;
    public boolean z;

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    private float c(float f) {
        return ((double) f) < 0.5d ? 2.0f * f * f : ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }

    private void n() {
        this.m = -1L;
        if (this.nu <= 0) {
            setProgressBarInfo(pf.ve(getContext(), 60.0f));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.nu > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.i == null) {
            this.i = uj();
        }
        this.u = true;
    }

    private Paint uj() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    public boolean c() {
        return this.z;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ve();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((c() || !this.t) && this.u) {
            boolean z = false;
            if (this.t) {
                long jNanoTime = System.nanoTime() / 1000000;
                if (this.m < 0) {
                    this.m = jNanoTime;
                }
                float f = (jNanoTime - this.m) / 400.0f;
                this.sl = f;
                int i = (int) f;
                z = ((this.yp + i) & 1) == 1;
                this.sl = f - i;
            }
            try {
                float fC = c(this.sl);
                int i2 = this.nu;
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.i, 31);
                float f2 = (this.rl * fC) + this.gt;
                float f3 = ((double) fC) < 0.5d ? fC * 2.0f : 2.0f - (fC * 2.0f);
                float f4 = this.my;
                float f5 = (0.25f * f3 * f4) + f4;
                this.i.setColor(z ? this.x : this.sp);
                canvas.drawCircle(f2, this.rh, f5, this.i);
                float f6 = this.nu - f2;
                float f7 = this.my;
                float f8 = f7 - ((f3 * 0.375f) * f7);
                this.i.setColor(z ? this.sp : this.x);
                this.i.setXfermode(this.da);
                canvas.drawCircle(f6, this.rh, f8, this.i);
                this.i.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            } catch (Throwable unused) {
            }
            postInvalidateDelayed(17L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.nu <= iMin || iMin <= 0) {
            return;
        }
        setProgressBarInfo(iMin);
    }

    public void setCycleBias(int i) {
        this.yp = i;
    }

    public void setProgress(float f) {
        if (!this.u) {
            n();
        }
        this.sl = f;
        this.z = false;
        this.t = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.nu = i;
            this.rh = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.my = f;
            float f2 = (i * 0.16f) + f;
            this.gt = f2;
            this.rl = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            tt();
        } else {
            ve();
        }
    }

    public void tt() {
        n();
        this.z = true;
        this.t = true;
        postInvalidate();
    }

    public void ve() {
        this.z = false;
        this.u = false;
        this.sl = 0.0f;
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0.25f;
        this.tt = 0.375f;
        this.ve = 0.16f;
        this.uj = 0.32f;
        this.n = 400.0f;
        this.f29141a = 17L;
        this.sp = -119723;
        this.x = -14289682;
        this.da = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.t = false;
        this.u = false;
        this.yp = 0;
        this.z = false;
        this.m = -1L;
        this.nu = -1;
    }
}
