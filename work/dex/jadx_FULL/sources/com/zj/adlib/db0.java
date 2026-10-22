package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class db0 extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TransformCallback f15957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable[] f15960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrawableParent[] f15961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fr2 f15958a = new fr2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f41145a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15959a = false;
    public boolean b = false;
    public boolean c = false;

    public class a implements DrawableParent {
        public final /* synthetic */ int K;

        public a(int i) {
            this.K = i;
        }

        @Override // com.facebook.drawee.drawable.DrawableParent
        public Drawable h(Drawable drawable) {
            return db0.this.f(this.K, drawable);
        }

        @Override // com.facebook.drawee.drawable.DrawableParent
        public Drawable i() {
            return db0.this.c(this.K);
        }
    }

    public db0(Drawable[] drawableArr) {
        int i = 0;
        ax6.i(drawableArr);
        this.f15960a = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.f15960a;
            if (i >= drawableArr2.length) {
                this.f15961a = new DrawableParent[drawableArr2.length];
                return;
            } else {
                mr2.d(drawableArr2[i], this, this);
                i++;
            }
        }
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void a(TransformCallback transformCallback) {
        this.f15957a = transformCallback;
    }

    public final DrawableParent b(int i) {
        return new a(i);
    }

    @Nullable
    public Drawable c(int i) {
        ax6.d(i >= 0);
        ax6.d(i < this.f15960a.length);
        return this.f15960a[i];
    }

    public DrawableParent d(int i) {
        ax6.d(i >= 0);
        ax6.d(i < this.f15961a.length);
        DrawableParent[] drawableParentArr = this.f15961a;
        if (drawableParentArr[i] == null) {
            drawableParentArr[i] = b(i);
        }
        return this.f15961a[i];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i++;
        }
    }

    public int e() {
        return this.f15960a.length;
    }

    @Nullable
    public Drawable f(int i, @Nullable Drawable drawable) {
        ax6.d(i >= 0);
        ax6.d(i < this.f15960a.length);
        Drawable drawable2 = this.f15960a[i];
        if (drawable != drawable2) {
            if (drawable != null && this.c) {
                drawable.mutate();
            }
            mr2.d(this.f15960a[i], null, null);
            mr2.d(drawable, null, null);
            mr2.e(drawable, this.f15958a);
            mr2.a(drawable, this);
            mr2.d(drawable, this, this);
            this.b = false;
            this.f15960a[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = 0;
        int iMax = -1;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iMax = Math.max(iMax, drawable.getIntrinsicHeight());
            }
            i++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = 0;
        int iMax = -1;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iMax = Math.max(iMax, drawable.getIntrinsicWidth());
            }
            i++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f15960a.length == 0) {
            return -2;
        }
        int i = 1;
        int iResolveOpacity = -1;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return iResolveOpacity;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iResolveOpacity = Drawable.resolveOpacity(iResolveOpacity, drawable.getOpacity());
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.f41145a;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.b) {
            this.f15959a = false;
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.f15960a;
                boolean z = true;
                if (i >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i];
                boolean z2 = this.f15959a;
                if (drawable == null || !drawable.isStateful()) {
                    z = false;
                }
                this.f15959a = z2 | z;
                i++;
            }
            this.b = true;
        }
        return this.f15959a;
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void l(RectF rectF) {
        TransformCallback transformCallback = this.f15957a;
        if (transformCallback != null) {
            transformCallback.l(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                this.c = true;
                return this;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.mutate();
            }
            i++;
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void o(Matrix matrix) {
        TransformCallback transformCallback = this.f15957a;
        if (transformCallback != null) {
            transformCallback.o(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i2 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int i = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f15958a.b(i);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15958a.c(colorFilter);
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f15958a.d(z);
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f15958a.e(z);
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f15960a;
            if (i >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
