package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.ds4;
import com.zj.adlib.h88;
import com.zj.adlib.j45;
import com.zj.adlib.ul9;
import com.zj.adlib.up5;
import com.zj.adlib.vs4;
import com.zj.adlib.zt4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<Integer, Integer> f395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.airbnb.lottie.animation.keyframe.b f396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseLayer f397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<PathContent> f399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f400a;
    public final BaseKeyframeAnimation<Integer, Integer> b;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> c;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> d;

    public c(LottieDrawable lottieDrawable, BaseLayer baseLayer, h88 h88Var) {
        Path path = new Path();
        this.f393a = path;
        this.f392a = new zt4(1);
        this.f399a = new ArrayList();
        this.f397a = baseLayer;
        this.f398a = h88Var.d();
        this.f400a = h88Var.f();
        this.f394a = lottieDrawable;
        if (baseLayer.w() != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = baseLayer.w().a().a();
            this.d = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            baseLayer.j(this.d);
        }
        if (baseLayer.y() != null) {
            this.f396a = new com.airbnb.lottie.animation.keyframe.b(this, baseLayer, baseLayer.y());
        }
        if (h88Var.b() == null || h88Var.e() == null) {
            this.f395a = null;
            this.b = null;
            return;
        }
        path.setFillType(h88Var.c());
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA2 = h88Var.b().a();
        this.f395a = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA3 = h88Var.e().a();
        this.b = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f393a.reset();
        for (int i = 0; i < this.f399a.size(); i++) {
            this.f393a.addPath(this.f399a.get(i).f(), matrix);
        }
        this.f393a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        if (this.f400a) {
            return;
        }
        vs4.a("FillContent#draw");
        this.f392a.setColor((up5.d((int) ((((i / 255.0f) * this.b.f().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.airbnb.lottie.animation.keyframe.a) this.f395a).m() & 16777215));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.c;
        if (baseKeyframeAnimation != null) {
            this.f392a.setColorFilter(baseKeyframeAnimation.f());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.d;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2.f().floatValue();
            if (fFloatValue == 0.0f) {
                this.f392a.setMaskFilter(null);
            } else if (fFloatValue != this.f23334a) {
                this.f392a.setMaskFilter(this.f397a.x(fFloatValue));
            }
            this.f23334a = fFloatValue;
        }
        com.airbnb.lottie.animation.keyframe.b bVar = this.f396a;
        if (bVar != null) {
            bVar.a(this.f392a);
        }
        this.f393a.reset();
        for (int i2 = 0; i2 < this.f399a.size(); i2++) {
            this.f393a.addPath(this.f399a.get(i2).f(), matrix);
        }
        canvas.drawPath(this.f393a, this.f392a);
        vs4.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.f399a.add((PathContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f398a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f394a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        com.airbnb.lottie.animation.keyframe.b bVar;
        com.airbnb.lottie.animation.keyframe.b bVar2;
        com.airbnb.lottie.animation.keyframe.b bVar3;
        com.airbnb.lottie.animation.keyframe.b bVar4;
        com.airbnb.lottie.animation.keyframe.b bVar5;
        if (t == LottieProperty.f349a) {
            this.f395a.k(j45Var);
            return;
        }
        if (t == LottieProperty.f356d) {
            this.b.k(j45Var);
            return;
        }
        if (t == LottieProperty.f343a) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.c;
            if (baseKeyframeAnimation != null) {
                this.f397a.H(baseKeyframeAnimation);
            }
            if (j45Var == null) {
                this.c = null;
                return;
            }
            ul9 ul9Var = new ul9(j45Var);
            this.c = ul9Var;
            ul9Var.a(this);
            this.f397a.j(this.c);
            return;
        }
        if (t == LottieProperty.f353c) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.d;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.k(j45Var);
                return;
            }
            ul9 ul9Var2 = new ul9(j45Var);
            this.d = ul9Var2;
            ul9Var2.a(this);
            this.f397a.j(this.d);
            return;
        }
        if (t == LottieProperty.f358e && (bVar5 = this.f396a) != null) {
            bVar5.b(j45Var);
            return;
        }
        if (t == LottieProperty.v && (bVar4 = this.f396a) != null) {
            bVar4.e(j45Var);
            return;
        }
        if (t == LottieProperty.w && (bVar3 = this.f396a) != null) {
            bVar3.c(j45Var);
            return;
        }
        if (t == LottieProperty.x && (bVar2 = this.f396a) != null) {
            bVar2.d(j45Var);
        } else {
            if (t != LottieProperty.y || (bVar = this.f396a) == null) {
                return;
            }
            bVar.f(j45Var);
        }
    }
}
