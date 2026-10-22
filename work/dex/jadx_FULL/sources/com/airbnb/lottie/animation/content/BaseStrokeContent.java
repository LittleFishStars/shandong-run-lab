package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.ds4;
import com.zj.adlib.j45;
import com.zj.adlib.ul9;
import com.zj.adlib.up5;
import com.zj.adlib.vj9;
import com.zj.adlib.vs4;
import com.zj.adlib.yc9;
import com.zj.adlib.zt4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<?, Float> f368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.airbnb.lottie.animation.keyframe.b f369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseLayer f370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f372a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final BaseKeyframeAnimation<?, Integer> f373b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<BaseKeyframeAnimation<?, Float>> f374b;

    @Nullable
    public final BaseKeyframeAnimation<?, Float> c;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> d;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PathMeasure f365a = new PathMeasure();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f364a = new Path();
    public final Path b = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f366a = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<b> f371a = new ArrayList();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final yc9 f23331a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<PathContent> f375a;

        public b(@Nullable yc9 yc9Var) {
            this.f375a = new ArrayList();
            this.f23331a = yc9Var;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.animatable.d dVar, com.airbnb.lottie.model.animatable.b bVar, List<com.airbnb.lottie.model.animatable.b> list, com.airbnb.lottie.model.animatable.b bVar2) {
        zt4 zt4Var = new zt4(1);
        this.f363a = zt4Var;
        this.f23330a = 0.0f;
        this.f367a = lottieDrawable;
        this.f370a = baseLayer;
        zt4Var.setStyle(Paint.Style.STROKE);
        zt4Var.setStrokeCap(cap);
        zt4Var.setStrokeJoin(join);
        zt4Var.setStrokeMiter(f);
        this.f373b = dVar.a();
        this.f368a = bVar.a();
        if (bVar2 == null) {
            this.c = null;
        } else {
            this.c = bVar2.a();
        }
        this.f374b = new ArrayList(list.size());
        this.f372a = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f374b.add(list.get(i).a());
        }
        baseLayer.j(this.f373b);
        baseLayer.j(this.f368a);
        for (int i2 = 0; i2 < this.f374b.size(); i2++) {
            baseLayer.j(this.f374b.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.c;
        if (baseKeyframeAnimation != null) {
            baseLayer.j(baseKeyframeAnimation);
        }
        this.f373b.a(this);
        this.f368a.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f374b.get(i3).a(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.c;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
        if (baseLayer.w() != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = baseLayer.w().a().a();
            this.e = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            baseLayer.j(this.e);
        }
        if (baseLayer.y() != null) {
            this.f369a = new com.airbnb.lottie.animation.keyframe.b(this, baseLayer, baseLayer.y());
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        vs4.a("StrokeContent#getBounds");
        this.f364a.reset();
        for (int i = 0; i < this.f371a.size(); i++) {
            b bVar = this.f371a.get(i);
            for (int i2 = 0; i2 < bVar.f375a.size(); i2++) {
                this.f364a.addPath(((PathContent) bVar.f375a.get(i2)).f(), matrix);
            }
        }
        this.f364a.computeBounds(this.f366a, false);
        float fM = ((com.airbnb.lottie.animation.keyframe.c) this.f368a).m();
        RectF rectF2 = this.f366a;
        float f = fM / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.f366a);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        vs4.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        vs4.a("StrokeContent#draw");
        if (vj9.h(matrix)) {
            vs4.b("StrokeContent#draw");
            return;
        }
        this.f363a.setAlpha(up5.d((int) ((((i / 255.0f) * ((com.airbnb.lottie.animation.keyframe.e) this.f373b).m()) / 100.0f) * 255.0f), 0, 255));
        this.f363a.setStrokeWidth(((com.airbnb.lottie.animation.keyframe.c) this.f368a).m() * vj9.g(matrix));
        if (this.f363a.getStrokeWidth() <= 0.0f) {
            vs4.b("StrokeContent#draw");
            return;
        }
        e(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.d;
        if (baseKeyframeAnimation != null) {
            this.f363a.setColorFilter(baseKeyframeAnimation.f());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.e;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2.f().floatValue();
            if (fFloatValue == 0.0f) {
                this.f363a.setMaskFilter(null);
            } else if (fFloatValue != this.f23330a) {
                this.f363a.setMaskFilter(this.f370a.x(fFloatValue));
            }
            this.f23330a = fFloatValue;
        }
        com.airbnb.lottie.animation.keyframe.b bVar = this.f369a;
        if (bVar != null) {
            bVar.a(this.f363a);
        }
        for (int i2 = 0; i2 < this.f371a.size(); i2++) {
            b bVar2 = this.f371a.get(i2);
            if (bVar2.f23331a != null) {
                j(canvas, bVar2, matrix);
            } else {
                vs4.a("StrokeContent#buildPath");
                this.f364a.reset();
                for (int size = bVar2.f375a.size() - 1; size >= 0; size--) {
                    this.f364a.addPath(((PathContent) bVar2.f375a.get(size)).f(), matrix);
                }
                vs4.b("StrokeContent#buildPath");
                vs4.a("StrokeContent#drawPath");
                canvas.drawPath(this.f364a, this.f363a);
                vs4.b("StrokeContent#drawPath");
            }
        }
        vs4.b("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        yc9 yc9Var = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof yc9) {
                yc9 yc9Var2 = (yc9) content;
                if (yc9Var2.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    yc9Var = yc9Var2;
                }
            }
        }
        if (yc9Var != null) {
            yc9Var.e(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof yc9) {
                yc9 yc9Var3 = (yc9) content2;
                if (yc9Var3.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f371a.add(bVar);
                    }
                    bVar = new b(yc9Var3);
                    yc9Var3.e(this);
                } else if (!(content2 instanceof PathContent)) {
                    if (bVar == null) {
                        bVar = new b(yc9Var);
                    }
                    bVar.f375a.add((PathContent) content2);
                }
            } else if (!(content2 instanceof PathContent)) {
                if (bVar == null) {
                    bVar = new b(yc9Var);
                }
                bVar.f375a.add((PathContent) content2);
            }
        }
        if (bVar != null) {
            this.f371a.add(bVar);
        }
    }

    public final void e(Matrix matrix) {
        vs4.a("StrokeContent#applyDashPattern");
        if (this.f374b.isEmpty()) {
            vs4.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = vj9.g(matrix);
        for (int i = 0; i < this.f374b.size(); i++) {
            this.f372a[i] = this.f374b.get(i).f().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f372a;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f372a;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f372a;
            fArr3[i] = fArr3[i] * fG;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.c;
        this.f363a.setPathEffect(new DashPathEffect(this.f372a, baseKeyframeAnimation == null ? 0.0f : fG * baseKeyframeAnimation.f().floatValue()));
        vs4.b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f367a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        com.airbnb.lottie.animation.keyframe.b bVar;
        com.airbnb.lottie.animation.keyframe.b bVar2;
        com.airbnb.lottie.animation.keyframe.b bVar3;
        com.airbnb.lottie.animation.keyframe.b bVar4;
        com.airbnb.lottie.animation.keyframe.b bVar5;
        if (t == LottieProperty.f356d) {
            this.f373b.k(j45Var);
            return;
        }
        if (t == LottieProperty.h) {
            this.f368a.k(j45Var);
            return;
        }
        if (t == LottieProperty.f343a) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.d;
            if (baseKeyframeAnimation != null) {
                this.f370a.H(baseKeyframeAnimation);
            }
            if (j45Var == null) {
                this.d = null;
                return;
            }
            ul9 ul9Var = new ul9(j45Var);
            this.d = ul9Var;
            ul9Var.a(this);
            this.f370a.j(this.d);
            return;
        }
        if (t == LottieProperty.f353c) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.e;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.k(j45Var);
                return;
            }
            ul9 ul9Var2 = new ul9(j45Var);
            this.e = ul9Var2;
            ul9Var2.a(this);
            this.f370a.j(this.e);
            return;
        }
        if (t == LottieProperty.f358e && (bVar5 = this.f369a) != null) {
            bVar5.b(j45Var);
            return;
        }
        if (t == LottieProperty.v && (bVar4 = this.f369a) != null) {
            bVar4.e(j45Var);
            return;
        }
        if (t == LottieProperty.w && (bVar3 = this.f369a) != null) {
            bVar3.c(j45Var);
            return;
        }
        if (t == LottieProperty.x && (bVar2 = this.f369a) != null) {
            bVar2.d(j45Var);
        } else {
            if (t != LottieProperty.y || (bVar = this.f369a) == null) {
                return;
            }
            bVar.f(j45Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x011c  */
    public final void j(Canvas canvas, b bVar, Matrix matrix) {
        float f;
        vs4.a("StrokeContent#applyTrimPath");
        if (bVar.f23331a == null) {
            vs4.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f364a.reset();
        for (int size = bVar.f375a.size() - 1; size >= 0; size--) {
            this.f364a.addPath(((PathContent) bVar.f375a.get(size)).f(), matrix);
        }
        float fFloatValue = bVar.f23331a.j().f().floatValue() / 100.0f;
        float fFloatValue2 = bVar.f23331a.g().f().floatValue() / 100.0f;
        float fFloatValue3 = bVar.f23331a.i().f().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.f364a, this.f363a);
            vs4.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f365a.setPath(this.f364a, false);
        float length = this.f365a.getLength();
        while (this.f365a.nextContour()) {
            length += this.f365a.getLength();
        }
        float f2 = fFloatValue3 * length;
        float f3 = (fFloatValue * length) + f2;
        float fMin = Math.min((fFloatValue2 * length) + f2, (f3 + length) - 1.0f);
        float f4 = 0.0f;
        for (int size2 = bVar.f375a.size() - 1; size2 >= 0; size2--) {
            this.b.set(((PathContent) bVar.f375a.get(size2)).f());
            this.b.transform(matrix);
            this.f365a.setPath(this.b, false);
            float length2 = this.f365a.getLength();
            if (fMin > length) {
                float f5 = fMin - length;
                if (f5 >= f4 + length2 || f4 >= f5) {
                    f = f4 + length2;
                    if (f < f3 && f4 <= fMin) {
                        if (f > fMin || f3 >= f4) {
                            vj9.a(this.b, f3 < f4 ? 0.0f : (f3 - f4) / length2, fMin > f ? 1.0f : (fMin - f4) / length2, 0.0f);
                            canvas.drawPath(this.b, this.f363a);
                        } else {
                            canvas.drawPath(this.b, this.f363a);
                        }
                    }
                } else {
                    vj9.a(this.b, f3 > length ? (f3 - length) / length2 : 0.0f, Math.min(f5 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.b, this.f363a);
                }
            } else {
                f = f4 + length2;
                if (f < f3) {
                }
            }
            f4 += length2;
        }
        vs4.b("StrokeContent#applyTrimPath");
    }
}
