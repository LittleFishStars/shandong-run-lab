package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class gw3 extends BaseStrokeContent {
    public static final int b = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LongSparseArray<LinearGradient> f16892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GradientType f16893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ul9 f16894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16896a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final RectF f16897b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final LongSparseArray<RadialGradient> f16898b;
    public final BaseKeyframeAnimation<cw3, cw3> f;
    public final BaseKeyframeAnimation<PointF, PointF> g;
    public final BaseKeyframeAnimation<PointF, PointF> h;

    public gw3(LottieDrawable lottieDrawable, BaseLayer baseLayer, a aVar) {
        super(lottieDrawable, baseLayer, aVar.b().toPaintCap(), aVar.g().toPaintJoin(), aVar.i(), aVar.k(), aVar.m(), aVar.h(), aVar.c());
        this.f16892a = new LongSparseArray<>();
        this.f16898b = new LongSparseArray<>();
        this.f16897b = new RectF();
        this.f16895a = aVar.j();
        this.f16893a = aVar.f();
        this.f16896a = aVar.n();
        this.f42001a = (int) (lottieDrawable.N().d() / 32.0f);
        BaseKeyframeAnimation<cw3, cw3> baseKeyframeAnimationA = aVar.e().a();
        this.f = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = aVar.l().a();
        this.g = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA3 = aVar.d().a();
        this.h = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        if (this.f16896a) {
            return;
        }
        a(this.f16897b, matrix, false);
        Shader shaderM = this.f16893a == GradientType.LINEAR ? m() : n();
        shaderM.setLocalMatrix(matrix);
        ((BaseStrokeContent) this).f363a.setShader(shaderM);
        super.b(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f16895a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        super.i(t, j45Var);
        if (t == LottieProperty.f350a) {
            ul9 ul9Var = this.f16894a;
            if (ul9Var != null) {
                ((BaseStrokeContent) this).f370a.H(ul9Var);
            }
            if (j45Var == null) {
                this.f16894a = null;
                return;
            }
            ul9 ul9Var2 = new ul9(j45Var);
            this.f16894a = ul9Var2;
            ul9Var2.a(this);
            ((BaseStrokeContent) this).f370a.j(this.f16894a);
        }
    }

    public final int[] k(int[] iArr) {
        ul9 ul9Var = this.f16894a;
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

    public final int l() {
        int iRound = Math.round(this.g.d() * this.f42001a);
        int iRound2 = Math.round(this.h.d() * this.f42001a);
        int iRound3 = Math.round(this.f.d() * this.f42001a);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    public final LinearGradient m() {
        long jL = l();
        LinearGradient linearGradient = this.f16892a.get(jL);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFF = this.g.f();
        PointF pointFF2 = this.h.f();
        cw3 cw3VarF = this.f.f();
        LinearGradient linearGradient2 = new LinearGradient(pointFF.x, pointFF.y, pointFF2.x, pointFF2.y, k(cw3VarF.a()), cw3VarF.b(), Shader.TileMode.CLAMP);
        this.f16892a.put(jL, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient n() {
        long jL = l();
        RadialGradient radialGradient = this.f16898b.get(jL);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFF = this.g.f();
        PointF pointFF2 = this.h.f();
        cw3 cw3VarF = this.f.f();
        int[] iArrK = k(cw3VarF.a());
        float[] fArrB = cw3VarF.b();
        float f = pointFF.x;
        float f2 = pointFF.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointFF2.x - f, pointFF2.y - f2), iArrK, fArrB, Shader.TileMode.CLAMP);
        this.f16898b.put(jL, radialGradient2);
        return radialGradient2;
    }
}
