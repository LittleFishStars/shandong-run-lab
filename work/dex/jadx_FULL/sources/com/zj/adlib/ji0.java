package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ji0 extends cl3 implements Runnable {
    public static final int L = 360;
    public static final int M = 20;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public float f42591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17403a;
    public boolean b;

    public ji0(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right;
        int i2 = bounds.left;
        int i3 = i - i2;
        int i4 = bounds.bottom;
        int i5 = bounds.top;
        int i6 = i4 - i5;
        float f = this.f42591a;
        if (!this.f17403a) {
            f = 360.0f - f;
        }
        canvas.rotate(f, i2 + (i3 / 2), i5 + (i6 / 2));
        super.draw(canvas);
        canvas.restoreToCount(iSave);
        t();
    }

    public final int r() {
        return (int) ((20.0f / this.K) * 360.0f);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b = false;
        this.f42591a += r();
        invalidateSelf();
    }

    public void s() {
        this.f42591a = 0.0f;
        this.b = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    public final void t() {
        if (this.b) {
            return;
        }
        this.b = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    public void u(boolean z) {
        this.f17403a = z;
    }

    public ji0(Drawable drawable, int i, boolean z) {
        super((Drawable) ax6.i(drawable));
        this.f42591a = 0.0f;
        this.b = false;
        this.K = i;
        this.f17403a = z;
    }
}
