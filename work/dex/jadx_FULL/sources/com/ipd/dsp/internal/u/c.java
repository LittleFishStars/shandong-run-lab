package com.ipd.dsp.internal.u;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.ipd.dsp.internal.f.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends Drawable implements g.b, Animatable, Animatable2Compat {
    public static final int q = -1;
    public static final int r = 0;
    public static final int s = 119;
    public final a f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public Paint n;
    public Rect o;
    public List<Animatable2Compat.AnimationCallback> p;

    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        public final g f38546a;

        public a(g gVar) {
            this.f38546a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    @Deprecated
    public c(Context context, com.ipd.dsp.internal.e.a aVar, com.ipd.dsp.internal.j.e eVar, m<Bitmap> mVar, int i, int i2, Bitmap bitmap) {
        this(context, aVar, mVar, i, i2, bitmap);
    }

    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.f.f38546a.a(mVar, bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer c() {
        return this.f.f38546a.b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.p;
        if (list != null) {
            list.clear();
        }
    }

    public final Rect d() {
        if (this.o == null) {
            this.o = new Rect();
        }
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.i) {
            return;
        }
        if (this.m) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.m = false;
        }
        canvas.drawBitmap(this.f.f38546a.c(), (Rect) null, d(), i());
    }

    public Bitmap e() {
        return this.f.f38546a.e();
    }

    public int f() {
        return this.f.f38546a.f();
    }

    public int g() {
        return this.f.f38546a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f.f38546a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f.f38546a.l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public m<Bitmap> h() {
        return this.f.f38546a.h();
    }

    public final Paint i() {
        if (this.n == null) {
            this.n = new Paint(2);
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g;
    }

    public int j() {
        return this.f.f38546a.k();
    }

    public boolean k() {
        return this.i;
    }

    public final void l() {
        List<Animatable2Compat.AnimationCallback> list = this.p;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.p.get(i).onAnimationEnd(this);
            }
        }
    }

    public void m() {
        this.i = true;
        this.f.f38546a.a();
    }

    public final void n() {
        this.k = 0;
    }

    public void o() {
        com.ipd.dsp.internal.d0.m.a(!this.g, "You cannot restart a currently running animation.");
        this.f.f38546a.o();
        start();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.m = true;
    }

    public final void p() {
        com.ipd.dsp.internal.d0.m.a(!this.i, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f.f38546a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.g) {
                return;
            }
            this.g = true;
            this.f.f38546a.a(this);
            invalidateSelf();
        }
    }

    public final void q() {
        this.g = false;
        this.f.f38546a.b(this);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        i().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        i().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.ipd.dsp.internal.d0.m.a(!this.i, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.j = z;
        if (!z) {
            q();
        } else if (this.h) {
            p();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.h = true;
        n();
        if (this.j) {
            p();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.h = false;
        q();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.p;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public c(Context context, com.ipd.dsp.internal.e.a aVar, m<Bitmap> mVar, int i, int i2, Bitmap bitmap) {
        this(new a(new g(com.ipd.dsp.internal.components.glide.a.a(context), aVar, i, i2, mVar, bitmap)));
    }

    public void a(boolean z) {
        this.g = z;
    }

    @Override // com.ipd.dsp.internal.u.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.k++;
        }
        int i = this.l;
        if (i == -1 || this.k < i) {
            return;
        }
        l();
        stop();
    }

    public c(a aVar) {
        this.j = true;
        this.l = -1;
        this.f = (a) com.ipd.dsp.internal.d0.m.a(aVar);
    }

    @VisibleForTesting
    public c(g gVar, Paint paint) {
        this(new a(gVar));
        this.n = paint;
    }

    public void a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            int iJ = this.f.f38546a.j();
            this.l = iJ != 0 ? iJ : -1;
        } else {
            this.l = i;
        }
    }
}
