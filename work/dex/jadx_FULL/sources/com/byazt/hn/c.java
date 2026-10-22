package com.byazt.hn;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Choreographer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 20})
public final class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28614a;
    public final n c;
    public Choreographer n;
    public final tt.uj[] tt;
    public final Paint ve;
    public final Path uj = new Path();
    public final Choreographer.FrameCallback sp = new Choreographer.FrameCallback() { // from class: com.byazt.hn.c.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (c.this.f28614a) {
                c.this.invalidateSelf();
                if (!c.this.f28614a || c.this.n == null) {
                    return;
                }
                c.this.n.postFrameCallback(this);
            }
        }
    };

    public c(n nVar) {
        this.c = nVar;
        this.tt = nVar.ve();
        Paint paint = new Paint(1);
        this.ve = paint;
        paint.setStyle(Paint.Style.FILL);
        if (nVar.tt().c().f28617a == 1) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a aVarC;
        int i;
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0 || (i = (aVarC = this.c.c()).c) <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        try {
            c(canvas, aVarC, i);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.c(rect.width(), rect.height());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ve.setColorFilter(colorFilter);
    }

    public void c() {
        if (this.f28614a) {
            return;
        }
        this.f28614a = true;
        try {
            Choreographer choreographer = Choreographer.getInstance();
            this.n = choreographer;
            choreographer.postFrameCallback(this.sp);
        } catch (Throwable unused) {
            this.f28614a = false;
        }
    }

    public void tt() {
        this.f28614a = false;
        Choreographer choreographer = this.n;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this.sp);
            this.n = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0090  */
    private void c(Canvas canvas, a aVar, int i) {
        int i2;
        tt.c cVar;
        int i3;
        int i4 = i;
        int[] iArrC = c(aVar, i4);
        float[] fArr = aVar.ve;
        float[] fArr2 = aVar.uj;
        float[] fArr3 = aVar.n;
        float[] fArr4 = aVar.f28613a;
        int[] iArr = aVar.x;
        tt.uj[] ujVarArr = this.tt;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = iArrC[i5];
            int i7 = iArr[i6];
            if (i7 < 0 || i7 >= ujVarArr.length || (cVar = ujVarArr[i7].t) == null) {
                i2 = i5;
            } else {
                float f = fArr3[i6];
                float f2 = cVar.ve * f;
                float f3 = cVar.uj * f;
                if (f2 <= 0.0f || f3 <= 0.0f || (i3 = (int) ((fArr4[i6] * 255.0f) + 0.5f)) <= 0) {
                    i2 = i5;
                } else {
                    i2 = i5;
                    if (i3 > 255) {
                        i3 = 255;
                    }
                    this.ve.setColor(cVar.n);
                    this.ve.setAlpha(i3);
                    float f4 = fArr[i6];
                    float f5 = fArr2[i6];
                    int i8 = cVar.tt;
                    if (i8 == 1) {
                        float f6 = f2 / 2.0f;
                        float f7 = f3 / 2.0f;
                        canvas.drawRect(f4 - f6, f5 - f7, f6 + f4, f7 + f5, this.ve);
                    } else if (i8 != 2) {
                        canvas.drawCircle(f4, f5, Math.min(f2, f3) / 2.0f, this.ve);
                    } else {
                        c(canvas, f4, f5, Math.min(f2, f3) / 2.0f);
                    }
                }
            }
            i5 = i2 + 1;
            i4 = i;
        }
    }

    private int[] c(a aVar, int i) {
        int[] iArr = aVar.i;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        int i3 = aVar.tt;
        if (i3 != 0 && i3 != 1 && i > 1) {
            c(iArr, aVar.sp, i, i3 == 4);
        }
        return iArr;
    }

    private static void c(int[] iArr, float[] fArr, int i, boolean z) {
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = iArr[i2];
            float f = fArr[i3];
            int i4 = i2 - 1;
            if (!z) {
                while (i4 >= 0) {
                    int i5 = iArr[i4];
                    if (fArr[i5] >= f) {
                        break;
                    }
                    iArr[i4 + 1] = i5;
                    i4--;
                }
            } else {
                while (i4 >= 0) {
                    int i6 = iArr[i4];
                    if (fArr[i6] <= f) {
                        break;
                    }
                    iArr[i4 + 1] = i6;
                    i4--;
                }
            }
            iArr[i4 + 1] = i3;
        }
    }

    private void c(Canvas canvas, float f, float f2, float f3) {
        float f4 = 0.5f * f3;
        Path path = this.uj;
        path.rewind();
        float f5 = -1.5707964f;
        for (int i = 0; i < 10; i++) {
            float f6 = i % 2 == 0 ? f3 : f4;
            double d = f5;
            float fCos = (((float) Math.cos(d)) * f6) + f;
            float fSin = (((float) Math.sin(d)) * f6) + f2;
            if (i == 0) {
                path.moveTo(fCos, fSin);
            } else {
                path.lineTo(fCos, fSin);
            }
            f5 += 0.62831855f;
        }
        path.close();
        canvas.drawPath(path, this.ve);
    }
}
