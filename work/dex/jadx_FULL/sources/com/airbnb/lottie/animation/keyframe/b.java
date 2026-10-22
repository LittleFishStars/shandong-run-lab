package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.a45;
import com.zj.adlib.hs2;
import com.zj.adlib.j45;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f23346a = 0.017453292519943295d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation.AnimationListener f459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<Integer, Integer> f460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f461a = true;
    public final BaseKeyframeAnimation<Float, Float> b;
    public final BaseKeyframeAnimation<Float, Float> c;
    public final BaseKeyframeAnimation<Float, Float> d;
    public final BaseKeyframeAnimation<Float, Float> e;

    public class a extends j45<Float> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ j45 f462a;

        public a(j45 j45Var) {
            this.f462a = j45Var;
        }

        @Override // com.zj.adlib.j45
        @Nullable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float a(a45<Float> a45Var) {
            Float f = (Float) this.f462a.a(a45Var);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public b(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, hs2 hs2Var) {
        this.f459a = animationListener;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA = hs2Var.a().a();
        this.f460a = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA2 = hs2Var.d().a();
        this.b = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = hs2Var.b().a();
        this.c = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA4 = hs2Var.c().a();
        this.d = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        baseLayer.j(baseKeyframeAnimationA4);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA5 = hs2Var.e().a();
        this.e = baseKeyframeAnimationA5;
        baseKeyframeAnimationA5.a(this);
        baseLayer.j(baseKeyframeAnimationA5);
    }

    public void a(Paint paint) {
        if (this.f461a) {
            this.f461a = false;
            double dFloatValue = ((double) this.c.f().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.d.f().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.f460a.f().intValue();
            paint.setShadowLayer(this.e.f().floatValue(), fSin, fCos, Color.argb(Math.round(this.b.f().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }

    public void b(@Nullable j45<Integer> j45Var) {
        this.f460a.k(j45Var);
    }

    public void c(@Nullable j45<Float> j45Var) {
        this.c.k(j45Var);
    }

    public void d(@Nullable j45<Float> j45Var) {
        this.d.k(j45Var);
    }

    public void e(@Nullable j45<Float> j45Var) {
        if (j45Var == null) {
            this.b.k(null);
        } else {
            this.b.k(new a(j45Var));
        }
    }

    public void f(@Nullable j45<Float> j45Var) {
        this.e.k(j45Var);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f461a = true;
        this.f459a.h();
    }
}
