package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.a;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class bt8 extends BaseStrokeContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15632a;
    public final BaseLayer b;
    public final BaseKeyframeAnimation<Integer, Integer> f;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> g;

    public bt8(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.b = baseLayer;
        this.f40835a = shapeStroke.h();
        this.f15632a = shapeStroke.k();
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA = shapeStroke.c().a();
        this.f = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        if (this.f15632a) {
            return;
        }
        ((BaseStrokeContent) this).f363a.setColor(((a) this.f).m());
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.g;
        if (baseKeyframeAnimation != null) {
            ((BaseStrokeContent) this).f363a.setColorFilter(baseKeyframeAnimation.f());
        }
        super.b(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f40835a;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        super.i(t, j45Var);
        if (t == LottieProperty.f352b) {
            this.f.k(j45Var);
            return;
        }
        if (t == LottieProperty.f343a) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.g;
            if (baseKeyframeAnimation != null) {
                this.b.H(baseKeyframeAnimation);
            }
            if (j45Var == null) {
                this.g = null;
                return;
            }
            ul9 ul9Var = new ul9(j45Var);
            this.g = ul9Var;
            ul9Var.a(this);
            this.b.j(this.f);
        }
    }
}
