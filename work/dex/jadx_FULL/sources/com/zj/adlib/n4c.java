package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n4c extends Drawable implements Drawable.Callback {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f43451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f18353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4c f18354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18355a;
    public Drawable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18356b;
    public boolean c;
    public boolean d;
    public boolean e;

    public n4c(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this(null);
        drawable = drawable == null ? h4c.f16936a : drawable;
        this.f18353a = drawable;
        drawable.setCallback(this);
        i4c i4cVar = this.f18354a;
        i4cVar.b = drawable.getChangingConfigurations() | i4cVar.b;
        drawable2 = drawable2 == null ? h4c.f16936a : drawable2;
        this.b = drawable2;
        drawable2.setCallback(this);
        i4c i4cVar2 = this.f18354a;
        i4cVar2.b = drawable2.getChangingConfigurations() | i4cVar2.b;
    }

    public final Drawable a() {
        return this.b;
    }

    public final void b(int i) {
        this.L = this.M;
        this.O = 0;
        this.N = 250;
        this.K = 1;
        invalidateSelf();
    }

    public final boolean c() {
        if (!this.c) {
            boolean z = false;
            if (this.f18353a.getConstantState() != null && this.b.getConstantState() != null) {
                z = true;
            }
            this.d = z;
            this.c = true;
        }
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        int i2 = this.K;
        int i3 = 0;
        boolean z = true;
        if (i2 == 1) {
            this.f43451a = SystemClock.uptimeMillis();
            this.K = 2;
            z = false;
        } else if (i2 == 2 && this.f43451a >= 0) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f43451a) / this.N;
            z = fUptimeMillis >= 1.0f;
            if (z) {
                this.K = 0;
            }
            this.O = (int) ((this.L * Math.min(fUptimeMillis, 1.0f)) + 0.0f);
        }
        int i4 = this.O;
        boolean z2 = this.f18355a;
        Drawable drawable = this.f18353a;
        Drawable drawable2 = this.b;
        if (!z) {
            if (z2) {
                drawable.setAlpha(this.M - i4);
            }
            drawable.draw(canvas);
            if (z2) {
                drawable.setAlpha(this.M);
            }
            if (i4 > 0) {
                drawable2.setAlpha(i4);
                drawable2.draw(canvas);
                drawable2.setAlpha(this.M);
            }
            invalidateSelf();
            return;
        }
        if (z2) {
            if (i4 == 0) {
            }
            i = this.M;
            if (i4 == i) {
                drawable2.setAlpha(i);
                drawable2.draw(canvas);
            }
        }
        i3 = i4;
        drawable.draw(canvas);
        i4 = i3;
        i = this.M;
        if (i4 == i) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i4c i4cVar = this.f18354a;
        return changingConfigurations | i4cVar.f42283a | i4cVar.b;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public final Drawable.ConstantState getConstantState() {
        if (!c()) {
            return null;
        }
        this.f18354a.f42283a = getChangingConfigurations();
        return this.f18354a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f18353a.getIntrinsicHeight(), this.b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f18353a.getIntrinsicWidth(), this.b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.e) {
            this.P = Drawable.resolveOpacity(this.f18353a.getOpacity(), this.b.getOpacity());
            this.e = true;
        }
        return this.P;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @CanIgnoreReturnValue
    public final Drawable mutate() {
        if (!this.f18356b && super.mutate() == this) {
            if (!c()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f18353a.mutate();
            this.b.mutate();
            this.f18356b = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f18353a.setBounds(rect);
        this.b.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.O == this.M) {
            this.O = i;
        }
        this.M = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f18353a.setColorFilter(colorFilter);
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public n4c(@Nullable i4c i4cVar) {
        this.K = 0;
        this.M = 255;
        this.O = 0;
        this.f18355a = true;
        this.f18354a = new i4c(i4cVar);
    }
}
