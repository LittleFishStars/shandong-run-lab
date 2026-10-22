package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.cw3;
import com.zj.adlib.ds4;
import com.zj.adlib.dw3;
import com.zj.adlib.j45;
import com.zj.adlib.ul9;
import com.zj.adlib.up5;
import com.zj.adlib.vs4;
import com.zj.adlib.zt4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public static final int b = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<cw3, cw3> f407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.airbnb.lottie.animation.keyframe.b f408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GradientType f409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseLayer f410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ul9 f411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final String f412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<PathContent> f413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f414a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final BaseKeyframeAnimation<Integer, Integer> f416b;
    public final BaseKeyframeAnimation<PointF, PointF> c;
    public final BaseKeyframeAnimation<PointF, PointF> d;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> e;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LongSparseArray<LinearGradient> f405a = new LongSparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final LongSparseArray<RadialGradient> f415b = new LongSparseArray<>();

    public d(LottieDrawable lottieDrawable, BaseLayer baseLayer, dw3 dw3Var) {
        Path path = new Path();
        this.f403a = path;
        this.f402a = new zt4(1);
        this.f404a = new RectF();
        this.f413a = new ArrayList();
        this.f23335a = 0.0f;
        this.f410a = baseLayer;
        this.f412a = dw3Var.f();
        this.f414a = dw3Var.i();
        this.f406a = lottieDrawable;
        this.f409a = dw3Var.e();
        path.setFillType(dw3Var.c());
        this.f401a = (int) (lottieDrawable.N().d() / 32.0f);
        BaseKeyframeAnimation<cw3, cw3> baseKeyframeAnimationA = dw3Var.d().a();
        this.f407a = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA2 = dw3Var.g().a();
        this.f416b = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA3 = dw3Var.h().a();
        this.c = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA4 = dw3Var.b().a();
        this.d = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        baseLayer.j(baseKeyframeAnimationA4);
        if (baseLayer.w() != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA5 = baseLayer.w().a().a();
            this.f = baseKeyframeAnimationA5;
            baseKeyframeAnimationA5.a(this);
            baseLayer.j(this.f);
        }
        if (baseLayer.y() != null) {
            this.f408a = new com.airbnb.lottie.animation.keyframe.b(this, baseLayer, baseLayer.y());
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f403a.reset();
        for (int i = 0; i < this.f413a.size(); i++) {
            this.f403a.addPath(this.f413a.get(i).f(), matrix);
        }
        this.f403a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        if (this.f414a) {
            return;
        }
        vs4.a("GradientFillContent#draw");
        this.f403a.reset();
        for (int i2 = 0; i2 < this.f413a.size(); i2++) {
            this.f403a.addPath(this.f413a.get(i2).f(), matrix);
        }
        this.f403a.computeBounds(this.f404a, false);
        Shader shaderK = this.f409a == GradientType.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.f402a.setShader(shaderK);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.e;
        if (baseKeyframeAnimation != null) {
            this.f402a.setColorFilter(baseKeyframeAnimation.f());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2.f().floatValue();
            if (fFloatValue == 0.0f) {
                this.f402a.setMaskFilter(null);
            } else if (fFloatValue != this.f23335a) {
                this.f402a.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f23335a = fFloatValue;
        }
        com.airbnb.lottie.animation.keyframe.b bVar = this.f408a;
        if (bVar != null) {
            bVar.a(this.f402a);
        }
        this.f402a.setAlpha(up5.d((int) ((((i / 255.0f) * this.f416b.f().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f403a, this.f402a);
        vs4.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.f413a.add((PathContent) content);
            }
        }
    }

    public final int[] e(int[] iArr) {
        ul9 ul9Var = this.f411a;
        if (ul9Var != null) {
            Integer[] numArr = (Integer[]) ul9Var.f();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f412a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f406a.invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        com.airbnb.lottie.animation.keyframe.b bVar;
        com.airbnb.lottie.animation.keyframe.b bVar2;
        com.airbnb.lottie.animation.keyframe.b bVar3;
        com.airbnb.lottie.animation.keyframe.b bVar4;
        com.airbnb.lottie.animation.keyframe.b bVar5;
        if (t == LottieProperty.f356d) {
            this.f416b.k(j45Var);
            return;
        }
        if (t == LottieProperty.f343a) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.e;
            if (baseKeyframeAnimation != null) {
                this.f410a.H(baseKeyframeAnimation);
            }
            if (j45Var == null) {
                this.e = null;
                return;
            }
            ul9 ul9Var = new ul9(j45Var);
            this.e = ul9Var;
            ul9Var.a(this);
            this.f410a.j(this.e);
            return;
        }
        if (t == LottieProperty.f350a) {
            ul9 ul9Var2 = this.f411a;
            if (ul9Var2 != null) {
                this.f410a.H(ul9Var2);
            }
            if (j45Var == null) {
                this.f411a = null;
                return;
            }
            this.f405a.clear();
            this.f415b.clear();
            ul9 ul9Var3 = new ul9(j45Var);
            this.f411a = ul9Var3;
            ul9Var3.a(this);
            this.f410a.j(this.f411a);
            return;
        }
        if (t == LottieProperty.f353c) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.k(j45Var);
                return;
            }
            ul9 ul9Var4 = new ul9(j45Var);
            this.f = ul9Var4;
            ul9Var4.a(this);
            this.f410a.j(this.f);
            return;
        }
        if (t == LottieProperty.f358e && (bVar5 = this.f408a) != null) {
            bVar5.b(j45Var);
            return;
        }
        if (t == LottieProperty.v && (bVar4 = this.f408a) != null) {
            bVar4.e(j45Var);
            return;
        }
        if (t == LottieProperty.w && (bVar3 = this.f408a) != null) {
            bVar3.c(j45Var);
            return;
        }
        if (t == LottieProperty.x && (bVar2 = this.f408a) != null) {
            bVar2.d(j45Var);
        } else {
            if (t != LottieProperty.y || (bVar = this.f408a) == null) {
                return;
            }
            bVar.f(j45Var);
        }
    }

    public final int j() {
        int iRound = Math.round(this.c.d() * this.f401a);
        int iRound2 = Math.round(this.d.d() * this.f401a);
        int iRound3 = Math.round(this.f407a.d() * this.f401a);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient k() {
        long j = j();
        LinearGradient linearGradient = this.f405a.get(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFF = this.c.f();
        PointF pointFF2 = this.d.f();
        cw3 cw3VarF = this.f407a.f();
        LinearGradient linearGradient2 = new LinearGradient(pointFF.x, pointFF.y, pointFF2.x, pointFF2.y, e(cw3VarF.a()), cw3VarF.b(), Shader.TileMode.CLAMP);
        this.f405a.put(j, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient l() {
        long j = j();
        RadialGradient radialGradient = this.f415b.get(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFF = this.c.f();
        PointF pointFF2 = this.d.f();
        cw3 cw3VarF = this.f407a.f();
        int[] iArrE = e(cw3VarF.a());
        float[] fArrB = cw3VarF.b();
        float f = pointFF.x;
        float f2 = pointFF.y;
        float fHypot = (float) Math.hypot(pointFF2.x - f, pointFF2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrE, fArrB, Shader.TileMode.CLAMP);
        this.f415b.put(j, radialGradient2);
        return radialGradient2;
    }
}
