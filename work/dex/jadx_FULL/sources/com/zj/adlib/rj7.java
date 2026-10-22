package com.zj.adlib;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class rj7 implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f44468a = 0.5519f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f19339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<Float, Float> f19340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public g88 f19341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19342a;

    public rj7(LottieDrawable lottieDrawable, BaseLayer baseLayer, qj7 qj7Var) {
        this.f19339a = lottieDrawable;
        this.f19342a = qj7Var.c();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = qj7Var.b().a();
        this.f19340a = baseKeyframeAnimationA;
        baseLayer.j(baseKeyframeAnimationA);
        baseKeyframeAnimationA.a(this);
    }

    public static int e(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    public static int g(int i, int i2) {
        return i - (e(i, i2) * i2);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public g88 d(g88 g88Var) {
        List<py1> listA = g88Var.a();
        if (listA.size() <= 2) {
            return g88Var;
        }
        float fFloatValue = this.f19340a.f().floatValue();
        if (fFloatValue == 0.0f) {
            return g88Var;
        }
        g88 g88VarJ = j(g88Var);
        g88VarJ.f(g88Var.b().x, g88Var.b().y);
        List<py1> listA2 = g88VarJ.a();
        boolean zD = g88Var.d();
        int i = 0;
        int i2 = 0;
        while (i < listA.size()) {
            py1 py1Var = listA.get(i);
            py1 py1Var2 = listA.get(g(i - 1, listA.size()));
            py1 py1Var3 = listA.get(g(i - 2, listA.size()));
            PointF pointFC = (i != 0 || zD) ? py1Var2.c() : g88Var.b();
            PointF pointFB = (i != 0 || zD) ? py1Var2.b() : pointFC;
            PointF pointFA = py1Var.a();
            PointF pointFC2 = py1Var3.c();
            PointF pointFC3 = py1Var.c();
            boolean z = !g88Var.d() && i == 0 && i == listA.size() + (-1);
            if (pointFB.equals(pointFC) && pointFA.equals(pointFC) && !z) {
                float f = pointFC.x;
                float f2 = f - pointFC2.x;
                float f3 = pointFC.y;
                float f4 = f3 - pointFC2.y;
                float f5 = pointFC3.x - f;
                float f6 = pointFC3.y - f3;
                float fHypot = (float) Math.hypot(f2, f4);
                float fHypot2 = (float) Math.hypot(f5, f6);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f7 = pointFC.x;
                float f8 = ((pointFC2.x - f7) * fMin) + f7;
                float f9 = pointFC.y;
                float f10 = ((pointFC2.y - f9) * fMin) + f9;
                float f11 = ((pointFC3.x - f7) * fMin2) + f7;
                float f12 = ((pointFC3.y - f9) * fMin2) + f9;
                float f13 = f8 - ((f8 - f7) * 0.5519f);
                float f14 = f10 - ((f10 - f9) * 0.5519f);
                float f15 = f11 - ((f11 - f7) * 0.5519f);
                float f16 = f12 - ((f12 - f9) * 0.5519f);
                py1 py1Var4 = listA2.get(g(i2 - 1, listA2.size()));
                py1 py1Var5 = listA2.get(i2);
                py1Var4.e(f8, f10);
                py1Var4.g(f8, f10);
                if (i == 0) {
                    g88VarJ.f(f8, f10);
                }
                py1Var5.d(f13, f14);
                i2++;
                py1 py1Var6 = listA2.get(i2);
                py1Var5.e(f15, f16);
                py1Var5.g(f11, f12);
                py1Var6.d(f11, f12);
            } else {
                py1 py1Var7 = listA2.get(g(i2 - 1, listA2.size()));
                py1 py1Var8 = listA2.get(i2);
                py1Var7.e(py1Var2.c().x, py1Var2.c().y);
                py1Var7.g(py1Var2.c().x, py1Var2.c().y);
                py1Var8.d(py1Var.c().x, py1Var.c().y);
            }
            i2++;
            i++;
            listA = listA;
        }
        return g88VarJ;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f19342a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f19339a.invalidateSelf();
    }

    public BaseKeyframeAnimation<Float, Float> i() {
        return this.f19340a;
    }

    @NonNull
    public final g88 j(g88 g88Var) {
        List<py1> listA = g88Var.a();
        boolean zD = g88Var.d();
        int size = listA.size() - 1;
        int i = 0;
        while (size >= 0) {
            py1 py1Var = listA.get(size);
            py1 py1Var2 = listA.get(g(size - 1, listA.size()));
            PointF pointFC = (size != 0 || zD) ? py1Var2.c() : g88Var.b();
            i = (((size != 0 || zD) ? py1Var2.b() : pointFC).equals(pointFC) && py1Var.a().equals(pointFC) && !(!g88Var.d() && size == 0 && size == listA.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        g88 g88Var2 = this.f19341a;
        if (g88Var2 == null || g88Var2.a().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new py1());
            }
            this.f19341a = new g88(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f19341a.e(zD);
        return this.f19341a;
    }
}
