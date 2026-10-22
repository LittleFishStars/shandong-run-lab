package com.aliyun.svideosdk.editor.impl.text;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StaticLayout f25762a;
    private int c;
    private int f;
    private float g;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected CharSequence s;
    protected final TextPaint b = new TextPaint(1);
    private int d = 0;
    private Bitmap e = null;
    protected float h = 0.0f;
    protected float i = 1.0f;
    protected boolean j = true;
    protected int o = 0;
    protected int p = 0;
    protected int q = 0;
    protected int r = 0;
    public Layout.Alignment t = Layout.Alignment.ALIGN_CENTER;
    private int u = 1;
    private boolean v = true;

    private static float a(float f) {
        return Math.max(2.0f, (f - 42.0f) / 15.0f);
    }

    private void a() {
        float fA = a(this.b.getTextSize());
        this.g = fA;
        this.b.setStrokeWidth(fA);
        invalidateSelf();
    }

    public void a(float f, float f2) {
        this.h = f;
        this.i = f2;
        b();
    }

    public void a(int i) {
        this.d = i;
        invalidateSelf();
    }

    public void a(int i, int i2) {
        this.k = i;
        this.l = i2;
        b();
    }

    public void a(Bitmap bitmap) {
        this.e = bitmap;
        b();
    }

    public void a(Paint.Join join) {
        this.b.setStrokeJoin(join);
    }

    public void a(Typeface typeface) {
        this.b.setTypeface(typeface);
        b();
    }

    public void a(Layout.Alignment alignment) {
        if (alignment != null) {
            this.t = alignment;
        }
    }

    public void a(CharSequence charSequence) {
        this.s = charSequence;
        b();
    }

    public void a(boolean z) {
        this.b.setFakeBoldText(z);
    }

    @SuppressLint({"WrongConstant"})
    public StaticLayout b(float f) {
        this.b.setTextSize(f);
        int i = Build.VERSION.SDK_INT;
        CharSequence charSequence = this.s;
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.b, this.m);
        builderObtain.setAlignment(this.t).setBreakStrategy(this.u).setLineSpacing(this.h, this.i).setIncludePad(this.j);
        if (i > 27) {
            builderObtain.setUseLineSpacingFromFallbacks(this.v);
        }
        return builderObtain.build();
    }

    public final void b() {
        this.f25762a = null;
        invalidateSelf();
    }

    public void b(int i) {
        this.c = i;
        invalidateSelf();
    }

    public void b(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    public void b(boolean z) {
        this.j = z;
        b();
    }

    public abstract StaticLayout c();

    public void c(int i) {
        this.o = i;
    }

    public void c(int i, int i2) {
        this.m = i;
        this.n = i2;
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void d(int i) {
        this.r = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float width;
        int height;
        if (this.f25762a == null) {
            StaticLayout staticLayoutC = c();
            this.f25762a = staticLayoutC;
            if (this.r > 0) {
                int lineCount = staticLayoutC.getLineCount();
                int i = this.r;
                if (lineCount > i) {
                    this.s = this.s.subSequence(0, this.f25762a.getLineStart(i));
                    this.f25762a = c();
                }
            }
            a();
        }
        canvas.save();
        Rect bounds = getBounds();
        canvas.drawColor(this.d);
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            int width2 = bitmap.getWidth();
            int height2 = this.e.getHeight();
            Rect rect = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = width2;
            rect.bottom = height2;
            Rect rect2 = new Rect();
            rect2.left = 0;
            rect2.right = this.k;
            rect2.top = 0;
            rect2.bottom = this.l;
            canvas.drawBitmap(this.e, rect, rect2, (Paint) null);
        }
        canvas.translate(bounds.left, bounds.top);
        canvas.scale(bounds.width() / this.k, bounds.height() / this.l);
        if (this.t == Layout.Alignment.ALIGN_CENTER) {
            width = (((this.k - this.p) - this.f25762a.getWidth()) / 2) + this.p;
            height = (((this.l - this.q) - this.f25762a.getHeight()) / 2) + this.q;
        } else {
            width = this.p;
            height = this.q;
        }
        canvas.translate(width, height);
        TextPaint paint = this.f25762a.getPaint();
        int i2 = this.f;
        if (i2 != 0) {
            paint.setColor(i2);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f25762a.draw(canvas);
        }
        int i3 = this.c;
        if (i3 != 0) {
            paint.setColor(i3);
            paint.setStyle(Paint.Style.FILL);
            this.f25762a.draw(canvas);
        }
        canvas.restore();
    }

    public void e(int i) {
        this.f = i;
        invalidateSelf();
    }

    public void f(int i) {
        this.u = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f25762a = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
