package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i extends BaseKeyframeAnimation<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f23352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<Float, Float> f466a;
    public final PointF b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final BaseKeyframeAnimation<Float, Float> f467b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public j45<Float> f468b;

    @Nullable
    public j45<Float> c;

    public i(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f23352a = new PointF();
        this.b = new PointF();
        this.f466a = baseKeyframeAnimation;
        this.f467b = baseKeyframeAnimation2;
        j(d());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void j(float f) {
        this.f466a.j(f);
        this.f467b.j(f);
        this.f23352a.set(this.f466a.f().floatValue(), this.f467b.f().floatValue());
        for (int i = 0; i < ((BaseKeyframeAnimation) this).f454a.size(); i++) {
            ((BaseKeyframeAnimation) this).f454a.get(i).h();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public PointF f() {
        return g(null, 0.0f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF g(ps4<PointF> ps4Var, float f) {
        Float fB;
        ps4<Float> currentKeyframe;
        ps4<Float> currentKeyframe2;
        Float fB2 = null;
        if (this.f468b == null || (currentKeyframe2 = this.f466a.getCurrentKeyframe()) == null) {
            fB = null;
        } else {
            float interpolatedCurrentKeyframeProgress = this.f466a.getInterpolatedCurrentKeyframeProgress();
            Float f2 = currentKeyframe2.f18927a;
            j45<Float> j45Var = this.f468b;
            float f3 = currentKeyframe2.f44051a;
            fB = j45Var.b(f3, f2 == null ? f3 : f2.floatValue(), currentKeyframe2.f18928a, currentKeyframe2.f18932b, f, f, interpolatedCurrentKeyframeProgress);
        }
        if (this.c != null && (currentKeyframe = this.f467b.getCurrentKeyframe()) != null) {
            float interpolatedCurrentKeyframeProgress2 = this.f467b.getInterpolatedCurrentKeyframeProgress();
            Float f4 = currentKeyframe.f18927a;
            j45<Float> j45Var2 = this.c;
            float f5 = currentKeyframe.f44051a;
            fB2 = j45Var2.b(f5, f4 == null ? f5 : f4.floatValue(), currentKeyframe.f18928a, currentKeyframe.f18932b, f, f, interpolatedCurrentKeyframeProgress2);
        }
        if (fB == null) {
            this.b.set(this.f23352a.x, 0.0f);
        } else {
            this.b.set(fB.floatValue(), 0.0f);
        }
        if (fB2 == null) {
            PointF pointF = this.b;
            pointF.set(pointF.x, this.f23352a.y);
        } else {
            PointF pointF2 = this.b;
            pointF2.set(pointF2.x, fB2.floatValue());
        }
        return this.b;
    }

    public void o(@Nullable j45<Float> j45Var) {
        j45<Float> j45Var2 = this.f468b;
        if (j45Var2 != null) {
            j45Var2.c(null);
        }
        this.f468b = j45Var;
        if (j45Var != null) {
            j45Var.c(this);
        }
    }

    public void p(@Nullable j45<Float> j45Var) {
        j45<Float> j45Var2 = this.c;
        if (j45Var2 != null) {
            j45Var2.c(null);
        }
        this.c = j45Var;
        if (j45Var != null) {
            j45Var.c(this);
        }
    }
}
