package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.a;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ft3 implements SettableDraweeHierarchy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f16612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f16613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RoundingParams f16614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cl3 f16615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final gj7 f16616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ud3 f16617a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public ft3(gt3 gt3Var) {
        int i = 0;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f16613a = colorDrawable;
        this.f16612a = gt3Var.getResources();
        this.f16614a = gt3Var.s();
        this.f16615a = new cl3(colorDrawable);
        int size = gt3Var.f() != null ? gt3Var.f().size() : 0;
        int size2 = (gt3Var.k() != null ? gt3Var.k().size() : 0) + (gt3Var.n() != null ? 1 : 0);
        int i2 = size + 0;
        int i3 = i2 + 1;
        this.f41752a = i2;
        int i4 = i3 + 1;
        this.c = i3;
        int i5 = i4 + 1;
        this.b = i4;
        int i6 = i5 + 1;
        this.d = i5;
        int i7 = i6 + 1;
        this.e = i6;
        Drawable[] drawableArr = new Drawable[i7 + size2];
        if (size > 0) {
            Iterator<Drawable> it = gt3Var.f().iterator();
            int i8 = 0;
            while (it.hasNext()) {
                drawableArr[i8 + 0] = h(it.next(), null);
                i8++;
            }
        }
        drawableArr[this.f41752a] = h(gt3Var.l(), gt3Var.m());
        drawableArr[this.c] = g(this.f16615a, gt3Var.e(), gt3Var.c(), gt3Var.d(), gt3Var.b());
        drawableArr[this.b] = h(gt3Var.o(), gt3Var.p());
        drawableArr[this.d] = h(gt3Var.q(), gt3Var.r());
        drawableArr[this.e] = h(gt3Var.i(), gt3Var.j());
        if (size2 > 0) {
            if (gt3Var.k() != null) {
                Iterator<Drawable> it2 = gt3Var.k().iterator();
                while (it2.hasNext()) {
                    drawableArr[i + i7] = h(it2.next(), null);
                    i++;
                }
            }
            if (gt3Var.n() != null) {
                drawableArr[i7 + i] = h(gt3Var.n(), null);
            }
        }
        ud3 ud3Var = new ud3(drawableArr);
        this.f16617a = ud3Var;
        ud3Var.x(gt3Var.h());
        gj7 gj7Var = new gj7(a.f(ud3Var, this.f16614a));
        this.f16616a = gj7Var;
        gj7Var.mutate();
        s();
    }

    public void A(int i) {
        B(this.f16612a.getDrawable(i));
    }

    public void B(@Nullable Drawable drawable) {
        w(this.f41752a, drawable);
    }

    public void C(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        w(this.f41752a, drawable);
        p(this.f41752a).w(scaleType);
    }

    public void D(PointF pointF) {
        ax6.i(pointF);
        p(this.f41752a).v(pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(float f) {
        Drawable drawableI = n(this.b).i();
        if (drawableI == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (drawableI instanceof Animatable) {
                ((Animatable) drawableI).stop();
            }
            k(this.b);
        } else {
            if (drawableI instanceof Animatable) {
                ((Animatable) drawableI).start();
            }
            i(this.b);
        }
        drawableI.setLevel(Math.round(f * 10000.0f));
    }

    public void F(@Nullable Drawable drawable) {
        w(this.b, drawable);
    }

    public void G(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        w(this.b, drawable);
        p(this.b).w(scaleType);
    }

    public void H(@Nullable Drawable drawable) {
        w(this.d, drawable);
    }

    public void I(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        w(this.d, drawable);
        p(this.d).w(scaleType);
    }

    public void J(RoundingParams roundingParams) {
        this.f16614a = roundingParams;
        a.k(this.f16616a, roundingParams);
        for (int i = 0; i < this.f16617a.e(); i++) {
            a.j(n(i), this.f16614a, this.f16612a);
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable a() {
        return this.f16616a;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void b(Throwable th) {
        this.f16617a.g();
        j();
        if (this.f16617a.c(this.e) != null) {
            i(this.e);
        } else {
            i(this.f41752a);
        }
        this.f16617a.i();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void c(Drawable drawable, float f, boolean z) {
        Drawable drawableD = a.d(drawable, this.f16614a, this.f16612a);
        drawableD.mutate();
        this.f16615a.h(drawableD);
        this.f16617a.g();
        j();
        i(this.c);
        E(f);
        if (z) {
            this.f16617a.r();
        }
        this.f16617a.i();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void d(float f, boolean z) {
        this.f16617a.g();
        E(f);
        if (z) {
            this.f16617a.r();
        }
        this.f16617a.i();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void e(Throwable th) {
        this.f16617a.g();
        j();
        if (this.f16617a.c(this.d) != null) {
            i(this.d);
        } else {
            i(this.f41752a);
        }
        this.f16617a.i();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void f(@Nullable Drawable drawable) {
        this.f16616a.r(drawable);
    }

    @Nullable
    public final Drawable g(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return a.e(a.h(drawable, scaleType, pointF), matrix);
    }

    @Nullable
    public final Drawable h(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        return a.g(a.d(drawable, this.f16614a, this.f16612a), scaleType);
    }

    public final void i(int i) {
        if (i >= 0) {
            this.f16617a.k(i);
        }
    }

    public final void j() {
        k(this.f41752a);
        k(this.c);
        k(this.b);
        k(this.d);
        k(this.e);
    }

    public final void k(int i) {
        if (i >= 0) {
            this.f16617a.n(i);
        }
    }

    public void l(RectF rectF) {
        this.f16615a.p(rectF);
    }

    @Nullable
    public ScalingUtils.ScaleType m() {
        if (q(this.c)) {
            return p(this.c).u();
        }
        return null;
    }

    public final DrawableParent n(int i) {
        DrawableParent drawableParentD = this.f16617a.d(i);
        if (drawableParentD.i() instanceof te5) {
            drawableParentD = (te5) drawableParentD.i();
        }
        return drawableParentD.i() instanceof com.facebook.drawee.drawable.a ? (com.facebook.drawee.drawable.a) drawableParentD.i() : drawableParentD;
    }

    public RoundingParams o() {
        return this.f16614a;
    }

    public final com.facebook.drawee.drawable.a p(int i) {
        DrawableParent drawableParentN = n(i);
        return drawableParentN instanceof com.facebook.drawee.drawable.a ? (com.facebook.drawee.drawable.a) drawableParentN : a.l(drawableParentN, ScalingUtils.ScaleType.f29972a);
    }

    public final boolean q(int i) {
        return n(i) instanceof com.facebook.drawee.drawable.a;
    }

    public final void r() {
        this.f16615a.h(this.f16613a);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        r();
        s();
    }

    public final void s() {
        ud3 ud3Var = this.f16617a;
        if (ud3Var != null) {
            ud3Var.g();
            this.f16617a.j();
            j();
            i(this.f41752a);
            this.f16617a.r();
            this.f16617a.i();
        }
    }

    public void t(ColorFilter colorFilter) {
        this.f16615a.setColorFilter(colorFilter);
    }

    public void u(PointF pointF) {
        ax6.i(pointF);
        p(this.c).v(pointF);
    }

    public void v(ScalingUtils.ScaleType scaleType) {
        ax6.i(scaleType);
        p(this.c).w(scaleType);
    }

    public final void w(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.f16617a.f(i, null);
        } else {
            n(i).h(a.d(drawable, this.f16614a, this.f16612a));
        }
    }

    public void x(int i) {
        this.f16617a.x(i);
    }

    public void y(@Nullable Drawable drawable) {
        w(this.e, drawable);
    }

    public void z(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        w(this.e, drawable);
        p(this.e).w(scaleType);
    }
}
