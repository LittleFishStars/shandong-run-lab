package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.k;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.ds4;
import com.zj.adlib.j45;
import com.zj.adlib.up5;
import com.zj.adlib.we7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f23341a = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f437a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<Float, Float> f440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k f441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseLayer f442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f444a;
    public final BaseKeyframeAnimation<Float, Float> b;

    public h(LottieDrawable lottieDrawable, BaseLayer baseLayer, we7 we7Var) {
        this.f438a = lottieDrawable;
        this.f442a = baseLayer;
        this.f443a = we7Var.c();
        this.f444a = we7Var.f();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = we7Var.b().a();
        this.f440a = baseKeyframeAnimationA;
        baseLayer.j(baseKeyframeAnimationA);
        baseKeyframeAnimationA.a(this);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA2 = we7Var.d().a();
        this.b = baseKeyframeAnimationA2;
        baseLayer.j(baseKeyframeAnimationA2);
        baseKeyframeAnimationA2.a(this);
        k kVarB = we7Var.e().b();
        this.f441a = kVarB;
        kVarB.a(baseLayer);
        kVarB.b(this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f439a.a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.f440a.f().floatValue();
        float fFloatValue2 = this.b.f().floatValue();
        float fFloatValue3 = this.f441a.i().f().floatValue() / 100.0f;
        float fFloatValue4 = this.f441a.e().f().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f23341a.set(matrix);
            float f = i2;
            this.f23341a.preConcat(this.f441a.g(f + fFloatValue2));
            this.f439a.b(canvas, this.f23341a, (int) (i * up5.k(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        this.f439a.c(list, list2);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void e(ListIterator<Content> listIterator) {
        if (this.f439a != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f439a = new a(this.f438a, this.f442a, "Repeater", this.f444a, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        Path pathF = this.f439a.f();
        this.f437a.reset();
        float fFloatValue = this.f440a.f().floatValue();
        float fFloatValue2 = this.b.f().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.f23341a.set(this.f441a.g(i + fFloatValue2));
            this.f437a.addPath(pathF, this.f23341a);
        }
        return this.f437a;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f443a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f438a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        if (this.f441a.c(t, j45Var)) {
            return;
        }
        if (t == LottieProperty.j) {
            this.f440a.k(j45Var);
        } else if (t == LottieProperty.k) {
            this.b.k(j45Var);
        }
    }
}
