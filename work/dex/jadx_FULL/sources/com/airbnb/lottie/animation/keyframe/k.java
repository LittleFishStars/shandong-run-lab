package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.cv7;
import com.zj.adlib.j45;
import com.zj.adlib.m60;
import com.zj.adlib.ps4;
import com.zj.adlib.ul9;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f23354a = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<PointF, PointF> f471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f473a;
    public final Matrix b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<?, PointF> f474b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public c f475b;
    public final Matrix c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<cv7, cv7> f476c;
    public final Matrix d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f477d;

    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> e;

    @Nullable
    public BaseKeyframeAnimation<?, Float> f;

    @Nullable
    public BaseKeyframeAnimation<?, Float> g;

    public k(m60 m60Var) {
        this.f471a = m60Var.c() == null ? null : m60Var.c().a();
        this.f474b = m60Var.f() == null ? null : m60Var.f().a();
        this.f476c = m60Var.h() == null ? null : m60Var.h().a();
        this.f477d = m60Var.g() == null ? null : m60Var.g().a();
        c cVar = m60Var.i() == null ? null : (c) m60Var.i().a();
        this.f472a = cVar;
        if (cVar != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.f473a = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.f473a = null;
        }
        this.f475b = m60Var.j() == null ? null : (c) m60Var.j().a();
        if (m60Var.e() != null) {
            this.e = m60Var.e().a();
        }
        if (m60Var.k() != null) {
            this.f = m60Var.k().a();
        } else {
            this.f = null;
        }
        if (m60Var.d() != null) {
            this.g = m60Var.d().a();
        } else {
            this.g = null;
        }
    }

    public void a(BaseLayer baseLayer) {
        baseLayer.j(this.e);
        baseLayer.j(this.f);
        baseLayer.j(this.g);
        baseLayer.j(this.f471a);
        baseLayer.j(this.f474b);
        baseLayer.j(this.f476c);
        baseLayer.j(this.f477d);
        baseLayer.j(this.f472a);
        baseLayer.j(this.f475b);
    }

    public void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.e;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.g;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f471a;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f474b;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation<cv7, cv7> baseKeyframeAnimation6 = this.f476c;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f477d;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        c cVar = this.f472a;
        if (cVar != null) {
            cVar.a(animationListener);
        }
        c cVar2 = this.f475b;
        if (cVar2 != null) {
            cVar2.a(animationListener);
        }
    }

    public <T> boolean c(T t, @Nullable j45<T> j45Var) {
        if (t == LottieProperty.f344a) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.f471a;
            if (baseKeyframeAnimation == null) {
                this.f471a = new ul9(j45Var, new PointF());
                return true;
            }
            baseKeyframeAnimation.k(j45Var);
            return true;
        }
        if (t == LottieProperty.b) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.f474b;
            if (baseKeyframeAnimation2 == null) {
                this.f474b = new ul9(j45Var, new PointF());
                return true;
            }
            baseKeyframeAnimation2.k(j45Var);
            return true;
        }
        if (t == LottieProperty.f348a) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.f474b;
            if (baseKeyframeAnimation3 instanceof i) {
                ((i) baseKeyframeAnimation3).o(j45Var);
                return true;
            }
        }
        if (t == LottieProperty.f351b) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.f474b;
            if (baseKeyframeAnimation4 instanceof i) {
                ((i) baseKeyframeAnimation4).p(j45Var);
                return true;
            }
        }
        if (t == LottieProperty.f346a) {
            BaseKeyframeAnimation<cv7, cv7> baseKeyframeAnimation5 = this.f476c;
            if (baseKeyframeAnimation5 == null) {
                this.f476c = new ul9(j45Var, new cv7());
                return true;
            }
            baseKeyframeAnimation5.k(j45Var);
            return true;
        }
        if (t == LottieProperty.f357e) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f477d;
            if (baseKeyframeAnimation6 == null) {
                this.f477d = new ul9(j45Var, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.k(j45Var);
            return true;
        }
        if (t == LottieProperty.f354c) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.e;
            if (baseKeyframeAnimation7 == null) {
                this.e = new ul9(j45Var, 100);
                return true;
            }
            baseKeyframeAnimation7.k(j45Var);
            return true;
        }
        if (t == LottieProperty.r) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation8 = this.f;
            if (baseKeyframeAnimation8 == null) {
                this.f = new ul9(j45Var, Float.valueOf(100.0f));
                return true;
            }
            baseKeyframeAnimation8.k(j45Var);
            return true;
        }
        if (t == LottieProperty.s) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation9 = this.g;
            if (baseKeyframeAnimation9 == null) {
                this.g = new ul9(j45Var, Float.valueOf(100.0f));
                return true;
            }
            baseKeyframeAnimation9.k(j45Var);
            return true;
        }
        if (t == LottieProperty.f) {
            if (this.f472a == null) {
                this.f472a = new c(Collections.singletonList(new ps4(Float.valueOf(0.0f))));
            }
            this.f472a.k(j45Var);
            return true;
        }
        if (t != LottieProperty.g) {
            return false;
        }
        if (this.f475b == null) {
            this.f475b = new c(Collections.singletonList(new ps4(Float.valueOf(0.0f))));
        }
        this.f475b.k(j45Var);
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.f473a[i] = 0.0f;
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> e() {
        return this.g;
    }

    public Matrix f() {
        PointF pointFF;
        this.f23354a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f474b;
        if (baseKeyframeAnimation != null && (pointFF = baseKeyframeAnimation.f()) != null) {
            float f = pointFF.x;
            if (f != 0.0f || pointFF.y != 0.0f) {
                this.f23354a.preTranslate(f, pointFF.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f477d;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2 instanceof ul9 ? baseKeyframeAnimation2.f().floatValue() : ((c) baseKeyframeAnimation2).m();
            if (fFloatValue != 0.0f) {
                this.f23354a.preRotate(fFloatValue);
            }
        }
        c cVar = this.f472a;
        if (cVar != null) {
            c cVar2 = this.f475b;
            float fCos = cVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar2.m()) + 90.0f));
            c cVar3 = this.f475b;
            float fSin = cVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar3.m()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(cVar.m()));
            d();
            float[] fArr = this.f473a;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.f473a;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.f473a;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.f23354a.preConcat(this.d);
        }
        BaseKeyframeAnimation<cv7, cv7> baseKeyframeAnimation3 = this.f476c;
        if (baseKeyframeAnimation3 != null) {
            cv7 cv7VarF = baseKeyframeAnimation3.f();
            if (cv7VarF.b() != 1.0f || cv7VarF.c() != 1.0f) {
                this.f23354a.preScale(cv7VarF.b(), cv7VarF.c());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f471a;
        if (baseKeyframeAnimation4 != null) {
            PointF pointFF2 = baseKeyframeAnimation4.f();
            float f3 = pointFF2.x;
            if (f3 != 0.0f || pointFF2.y != 0.0f) {
                this.f23354a.preTranslate(-f3, -pointFF2.y);
            }
        }
        return this.f23354a;
    }

    public Matrix g(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f474b;
        PointF pointFF = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.f();
        BaseKeyframeAnimation<cv7, cv7> baseKeyframeAnimation2 = this.f476c;
        cv7 cv7VarF = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.f();
        this.f23354a.reset();
        if (pointFF != null) {
            this.f23354a.preTranslate(pointFF.x * f, pointFF.y * f);
        }
        if (cv7VarF != null) {
            double d = f;
            this.f23354a.preScale((float) Math.pow(cv7VarF.b(), d), (float) Math.pow(cv7VarF.c(), d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f477d;
        if (baseKeyframeAnimation3 != null) {
            float fFloatValue = baseKeyframeAnimation3.f().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f471a;
            PointF pointFF2 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.f() : null;
            this.f23354a.preRotate(fFloatValue * f, pointFF2 == null ? 0.0f : pointFF2.x, pointFF2 != null ? pointFF2.y : 0.0f);
        }
        return this.f23354a;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> h() {
        return this.e;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> i() {
        return this.f;
    }

    public void j(float f) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.e;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.j(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.j(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.g;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.j(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f471a;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.j(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f474b;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.j(f);
        }
        BaseKeyframeAnimation<cv7, cv7> baseKeyframeAnimation6 = this.f476c;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.j(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f477d;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.j(f);
        }
        c cVar = this.f472a;
        if (cVar != null) {
            cVar.j(f);
        }
        c cVar2 = this.f475b;
        if (cVar2 != null) {
            cVar2.j(f);
        }
    }
}
