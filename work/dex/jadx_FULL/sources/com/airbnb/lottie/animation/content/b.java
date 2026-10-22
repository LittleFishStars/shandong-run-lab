package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.as1;
import com.zj.adlib.ds4;
import com.zj.adlib.hl1;
import com.zj.adlib.j45;
import com.zj.adlib.up5;
import com.zj.adlib.yc9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f23333a = 0.55228f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<?, PointF> f387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hl1 f389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f391a;
    public final BaseKeyframeAnimation<?, PointF> b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f385a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final as1 f388a = new as1();

    public b(LottieDrawable lottieDrawable, BaseLayer baseLayer, hl1 hl1Var) {
        this.f390a = hl1Var.b();
        this.f386a = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA = hl1Var.d().a();
        this.f387a = baseKeyframeAnimationA;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = hl1Var.c().a();
        this.b = baseKeyframeAnimationA2;
        this.f389a = hl1Var;
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof yc9) {
                yc9 yc9Var = (yc9) content;
                if (yc9Var.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f388a.a(yc9Var);
                    yc9Var.e(this);
                }
            }
        }
    }

    public final void e() {
        this.f391a = false;
        this.f386a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        if (this.f391a) {
            return this.f385a;
        }
        this.f385a.reset();
        if (this.f389a.e()) {
            this.f391a = true;
            return this.f385a;
        }
        PointF pointFF = this.f387a.f();
        float f = pointFF.x / 2.0f;
        float f2 = pointFF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f385a.reset();
        if (this.f389a.f()) {
            float f5 = -f2;
            this.f385a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f385a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f385a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f385a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.f385a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f385a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f385a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.f385a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.f385a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f385a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFF2 = this.b.f();
        this.f385a.offset(pointFF2.x, pointFF2.y);
        this.f385a.close();
        this.f388a.b(this.f385a);
        this.f391a = true;
        return this.f385a;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f390a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        e();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        if (t == LottieProperty.c) {
            this.f387a.k(j45Var);
        } else if (t == LottieProperty.e) {
            this.b.k(j45Var);
        }
    }
}
