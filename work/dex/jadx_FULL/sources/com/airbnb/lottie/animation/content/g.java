package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.as1;
import com.zj.adlib.ds4;
import com.zj.adlib.j45;
import com.zj.adlib.rj7;
import com.zj.adlib.up5;
import com.zj.adlib.xc7;
import com.zj.adlib.yc9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<?, PointF> f432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f435a;
    public final BaseKeyframeAnimation<?, PointF> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f436b;
    public final BaseKeyframeAnimation<?, Float> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f23340a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f430a = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final as1 f433a = new as1();

    @Nullable
    public BaseKeyframeAnimation<Float, Float> d = null;

    public g(LottieDrawable lottieDrawable, BaseLayer baseLayer, xc7 xc7Var) {
        this.f434a = xc7Var.c();
        this.f435a = xc7Var.f();
        this.f431a = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA = xc7Var.d().a();
        this.f432a = baseKeyframeAnimationA;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = xc7Var.e().a();
        this.b = baseKeyframeAnimationA2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = xc7Var.b().a();
        this.c = baseKeyframeAnimationA3;
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseLayer.j(baseKeyframeAnimationA3);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        baseKeyframeAnimationA3.a(this);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof yc9) {
                yc9 yc9Var = (yc9) content;
                if (yc9Var.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f433a.a(yc9Var);
                    yc9Var.e(this);
                } else if (content instanceof rj7) {
                    this.d = ((rj7) content).i();
                }
            } else if (content instanceof rj7) {
                this.d = ((rj7) content).i();
            }
        }
    }

    public final void e() {
        this.f436b = false;
        this.f431a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.f436b) {
            return this.f23340a;
        }
        this.f23340a.reset();
        if (this.f435a) {
            this.f436b = true;
            return this.f23340a;
        }
        PointF pointFF = this.b.f();
        float f = pointFF.x / 2.0f;
        float f2 = pointFF.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.c;
        float fM = baseKeyframeAnimation2 == null ? 0.0f : ((com.airbnb.lottie.animation.keyframe.c) baseKeyframeAnimation2).m();
        if (fM == 0.0f && (baseKeyframeAnimation = this.d) != null) {
            fM = Math.min(baseKeyframeAnimation.f().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fM > fMin) {
            fM = fMin;
        }
        PointF pointFF2 = this.f432a.f();
        this.f23340a.moveTo(pointFF2.x + f, (pointFF2.y - f2) + fM);
        this.f23340a.lineTo(pointFF2.x + f, (pointFF2.y + f2) - fM);
        if (fM > 0.0f) {
            RectF rectF = this.f430a;
            float f3 = pointFF2.x;
            float f4 = fM * 2.0f;
            float f5 = pointFF2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.f23340a.arcTo(this.f430a, 0.0f, 90.0f, false);
        }
        this.f23340a.lineTo((pointFF2.x - f) + fM, pointFF2.y + f2);
        if (fM > 0.0f) {
            RectF rectF2 = this.f430a;
            float f6 = pointFF2.x;
            float f7 = pointFF2.y;
            float f8 = fM * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.f23340a.arcTo(this.f430a, 90.0f, 90.0f, false);
        }
        this.f23340a.lineTo(pointFF2.x - f, (pointFF2.y - f2) + fM);
        if (fM > 0.0f) {
            RectF rectF3 = this.f430a;
            float f9 = pointFF2.x;
            float f10 = pointFF2.y;
            float f11 = fM * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.f23340a.arcTo(this.f430a, 180.0f, 90.0f, false);
        }
        this.f23340a.lineTo((pointFF2.x + f) - fM, pointFF2.y - f2);
        if (fM > 0.0f) {
            RectF rectF4 = this.f430a;
            float f12 = pointFF2.x;
            float f13 = fM * 2.0f;
            float f14 = pointFF2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.f23340a.arcTo(this.f430a, 270.0f, 90.0f, false);
        }
        this.f23340a.close();
        this.f433a.b(this.f23340a);
        this.f436b = true;
        return this.f23340a;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f434a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        e();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        if (t == LottieProperty.d) {
            this.b.k(j45Var);
        } else if (t == LottieProperty.e) {
            this.f432a.k(j45Var);
        } else if (t == LottieProperty.f355d) {
            this.c.k(j45Var);
        }
    }
}
