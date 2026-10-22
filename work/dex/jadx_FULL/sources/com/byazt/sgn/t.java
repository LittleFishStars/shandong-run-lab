package com.byazt.sgn;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 66})
public class t extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29013a;
    public int c;
    public RectF da;
    public int i;
    public LinearGradient n;
    public Paint sl;
    public int sp;
    public int tt;
    public float[] uj;
    public int[] ve;
    public int x;

    @com.byazt.zqa.c(c = {0, 1, 211, 125})
    public static class c {
        public LinearGradient n;
        public float[] uj;
        public int[] ve;
        public int c = 2789591;
        public int tt = 2789591;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29014a = 10;
        public int sp = 16;
        public int x = 0;
        public int i = 0;

        public c c(int i) {
            this.c = i;
            return this;
        }

        public c n(int i) {
            this.i = i;
            return this;
        }

        public c tt(int i) {
            this.tt = i;
            return this;
        }

        public c uj(int i) {
            this.x = i;
            return this;
        }

        public c ve(int i) {
            this.f29014a = i;
            return this;
        }

        public c c(int[] iArr) {
            this.ve = iArr;
            return this;
        }

        public t c() {
            return new t(this.c, this.ve, this.uj, this.tt, this.n, this.f29014a, this.sp, this.x, this.i);
        }
    }

    public t(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.c = i;
        this.ve = iArr;
        this.uj = fArr;
        this.tt = i2;
        this.n = linearGradient;
        this.f29013a = i3;
        this.sp = i4;
        this.x = i5;
        this.i = i6;
    }

    private void c() {
        int[] iArr;
        Paint paint = new Paint();
        this.sl = paint;
        paint.setAntiAlias(true);
        this.sl.setShadowLayer(this.sp, this.x, this.i, this.tt);
        if (this.da == null || (iArr = this.ve) == null || iArr.length <= 1) {
            this.sl.setColor(this.c);
            return;
        }
        float[] fArr = this.uj;
        boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint2 = this.sl;
        LinearGradient linearGradient = this.n;
        if (linearGradient == null) {
            RectF rectF = this.da;
            linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.ve, z ? this.uj : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.da == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.sp;
            int i3 = this.x;
            int i4 = bounds.top + i2;
            int i5 = this.i;
            this.da = new RectF((i + i2) - i3, i4 - i5, (bounds.right - i2) - i3, (bounds.bottom - i2) - i5);
        }
        if (this.sl == null) {
            c();
        }
        RectF rectF = this.da;
        int i6 = this.f29013a;
        canvas.drawRoundRect(rectF, i6, i6, this.sl);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.sl;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.sl;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void c(View view, c cVar) {
        if (view == null || cVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(cVar.c());
    }
}
