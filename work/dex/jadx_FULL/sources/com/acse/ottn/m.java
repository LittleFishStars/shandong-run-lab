package com.acse.ottn;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class m extends Animation {
    public static final boolean q;
    public static final WeakHashMap<View, m> r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f23078a;
    public boolean c;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float l;
    public float m;
    public final Camera b = new Camera();
    public float d = 1.0f;
    public float j = 1.0f;
    public float k = 1.0f;
    public final RectF n = new RectF();
    public final RectF o = new RectF();
    public final Matrix p = new Matrix();

    static {
        q = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        r = new WeakHashMap<>();
    }

    public m(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f23078a = new WeakReference<>(view);
    }

    public static m a(View view) {
        WeakHashMap<View, m> weakHashMap = r;
        m mVar = weakHashMap.get(view);
        if (mVar != null && mVar == view.getAnimation()) {
            return mVar;
        }
        m mVar2 = new m(view);
        weakHashMap.put(view, mVar2);
        return mVar2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        View view = this.f23078a.get();
        if (view != null) {
            transformation.setAlpha(this.d);
            a(transformation.getMatrix(), view);
        }
    }

    public float b() {
        return this.e;
    }

    public float c() {
        return this.f;
    }

    public float d() {
        return this.i;
    }

    public float e() {
        return this.g;
    }

    public float f() {
        return this.h;
    }

    public float g() {
        return this.j;
    }

    public float h() {
        return this.k;
    }

    public int i() {
        View view = this.f23078a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int j() {
        View view = this.f23078a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float k() {
        return this.l;
    }

    public float l() {
        return this.m;
    }

    public float m() {
        View view = this.f23078a.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.l;
    }

    public float n() {
        View view = this.f23078a.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.m;
    }

    public final void o() {
        View view = this.f23078a.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.o;
        a(rectF, view);
        rectF.union(this.n);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void p() {
        View view = this.f23078a.get();
        if (view != null) {
            a(this.n, view);
        }
    }

    public void b(float f) {
        if (this.c && this.e == f) {
            return;
        }
        p();
        this.c = true;
        this.e = f;
        o();
    }

    public void c(float f) {
        if (this.c && this.f == f) {
            return;
        }
        p();
        this.c = true;
        this.f = f;
        o();
    }

    public void d(float f) {
        if (this.i != f) {
            p();
            this.i = f;
            o();
        }
    }

    public void e(float f) {
        if (this.g != f) {
            p();
            this.g = f;
            o();
        }
    }

    public void f(float f) {
        if (this.h != f) {
            p();
            this.h = f;
            o();
        }
    }

    public void g(float f) {
        if (this.j != f) {
            p();
            this.j = f;
            o();
        }
    }

    public void h(float f) {
        if (this.k != f) {
            p();
            this.k = f;
            o();
        }
    }

    public void k(float f) {
        View view = this.f23078a.get();
        if (view != null) {
            i(f - view.getLeft());
        }
    }

    public void l(float f) {
        View view = this.f23078a.get();
        if (view != null) {
            j(f - view.getTop());
        }
    }

    public void i(float f) {
        if (this.l != f) {
            p();
            this.l = f;
            o();
        }
    }

    public void j(float f) {
        if (this.m != f) {
            p();
            this.m = f;
            o();
        }
    }

    public float a() {
        return this.d;
    }

    public void a(float f) {
        if (this.d != f) {
            this.d = f;
            View view = this.f23078a.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void b(int i) {
        View view = this.f23078a.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public void a(int i) {
        View view = this.f23078a.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public final void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.p;
        matrix.reset();
        a(matrix, view);
        this.p.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f = rectF.right;
        float f2 = rectF.left;
        if (f < f2) {
            rectF.right = f2;
            rectF.left = f;
        }
        float f3 = rectF.bottom;
        float f4 = rectF.top;
        if (f3 < f4) {
            rectF.top = f3;
            rectF.bottom = f4;
        }
    }

    public final void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.c;
        float f = z ? this.e : width / 2.0f;
        float f2 = z ? this.f : height / 2.0f;
        float f3 = this.g;
        float f4 = this.h;
        float f5 = this.i;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.b;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.j;
        float f7 = this.k;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.l, this.m);
    }
}
