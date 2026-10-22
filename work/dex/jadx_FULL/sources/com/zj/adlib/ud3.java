package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ud3 extends db0 {

    @VisibleForTesting
    public static final int O = 0;

    @VisibleForTesting
    public static final int P = 1;

    @VisibleForTesting
    public static final int Q = 2;

    @VisibleForTesting
    public int K;

    @VisibleForTesting
    public int L;

    @VisibleForTesting
    public int M;

    @VisibleForTesting
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public long f45119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public int[] f20037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public boolean[] f20038a;

    @VisibleForTesting
    public int[] b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable[] f20039b;

    public ud3(Drawable[] drawableArr) {
        super(drawableArr);
        ax6.p(drawableArr.length >= 1, "At least one layer required!");
        this.f20039b = drawableArr;
        this.f20037a = new int[drawableArr.length];
        this.b = new int[drawableArr.length];
        this.M = 255;
        this.f20038a = new boolean[drawableArr.length];
        this.N = 0;
        w();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[LOOP:0: B:25:0x004e->B:27:0x0053, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064 A[EDGE_INSN: B:31:0x0064->B:28:0x0064 BREAK  A[LOOP:0: B:25:0x004e->B:27:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.zj.adlib.db0, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean zY;
        Drawable[] drawableArr;
        int i = this.K;
        int i2 = 0;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                ax6.o(this.L > 0);
                zY = y((getCurrentTimeMs() - this.f45119a) / this.L);
                this.K = zY ? 2 : 1;
            }
            while (true) {
                drawableArr = this.f20039b;
                if (i2 < drawableArr.length) {
                    break;
                }
                h(canvas, drawableArr[i2], (this.b[i2] * this.M) / 255);
                i2++;
            }
            if (z) {
            }
            invalidateSelf();
        }
        System.arraycopy(this.b, 0, this.f20037a, 0, this.f20039b.length);
        this.f45119a = getCurrentTimeMs();
        zY = y(this.L == 0 ? 1.0f : 0.0f);
        this.K = zY ? 2 : 1;
        z = zY;
        while (true) {
            drawableArr = this.f20039b;
            if (i2 < drawableArr.length) {
                break;
                break;
            } else {
                h(canvas, drawableArr[i2], (this.b[i2] * this.M) / 255);
                i2++;
            }
        }
        if (z) {
            invalidateSelf();
        }
    }

    public void g() {
        this.N++;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.M;
    }

    public long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public final void h(Canvas canvas, Drawable drawable, int i) {
        if (drawable == null || i <= 0) {
            return;
        }
        this.N++;
        drawable.mutate().setAlpha(i);
        this.N--;
        drawable.draw(canvas);
    }

    public void i() {
        this.N--;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N == 0) {
            super.invalidateSelf();
        }
    }

    public void j() {
        this.K = 0;
        Arrays.fill(this.f20038a, true);
        invalidateSelf();
    }

    public void k(int i) {
        this.K = 0;
        this.f20038a[i] = true;
        invalidateSelf();
    }

    public void m() {
        this.K = 0;
        Arrays.fill(this.f20038a, false);
        invalidateSelf();
    }

    public void n(int i) {
        this.K = 0;
        this.f20038a[i] = false;
        invalidateSelf();
    }

    public void p(int i) {
        this.K = 0;
        Arrays.fill(this.f20038a, false);
        this.f20038a[i] = true;
        invalidateSelf();
    }

    public void q(int i) {
        this.K = 0;
        int i2 = i + 1;
        Arrays.fill(this.f20038a, 0, i2, true);
        Arrays.fill(this.f20038a, i2, this.f20039b.length, false);
        invalidateSelf();
    }

    public void r() {
        this.K = 2;
        for (int i = 0; i < this.f20039b.length; i++) {
            this.b[i] = this.f20038a[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    public int s() {
        return this.L;
    }

    @Override // com.zj.adlib.db0, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.M != i) {
            this.M = i;
            invalidateSelf();
        }
    }

    @VisibleForTesting
    public int t() {
        return this.K;
    }

    public boolean u(int i) {
        return this.f20038a[i];
    }

    public void v() {
        w();
        invalidateSelf();
    }

    public final void w() {
        this.K = 2;
        Arrays.fill(this.f20037a, 0);
        this.f20037a[0] = 255;
        Arrays.fill(this.b, 0);
        this.b[0] = 255;
        Arrays.fill(this.f20038a, false);
        this.f20038a[0] = true;
    }

    public void x(int i) {
        this.L = i;
        if (this.K == 1) {
            this.K = 0;
        }
    }

    public final boolean y(float f) {
        boolean z = true;
        for (int i = 0; i < this.f20039b.length; i++) {
            boolean z2 = this.f20038a[i];
            int i2 = z2 ? 1 : -1;
            int[] iArr = this.b;
            int i3 = (int) (this.f20037a[i] + (i2 * 255 * f));
            iArr[i] = i3;
            if (i3 < 0) {
                iArr[i] = 0;
            }
            if (iArr[i] > 255) {
                iArr[i] = 255;
            }
            if (z2 && iArr[i] < 255) {
                z = false;
            }
            if (!z2 && iArr[i] > 0) {
                z = false;
            }
        }
        return z;
    }
}
