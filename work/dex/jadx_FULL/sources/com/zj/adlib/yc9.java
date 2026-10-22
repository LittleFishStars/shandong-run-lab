package com.zj.adlib;

import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class yc9 implements Content, BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f45999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ShapeTrimPath.Type f20834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<BaseKeyframeAnimation.AnimationListener> f20836a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20837a;
    public final BaseKeyframeAnimation<?, Float> b;
    public final BaseKeyframeAnimation<?, Float> c;

    public yc9(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f20835a = shapeTrimPath.c();
        this.f20837a = shapeTrimPath.f();
        this.f20834a = shapeTrimPath.getType();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = shapeTrimPath.e().a();
        this.f45999a = baseKeyframeAnimationA;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA2 = shapeTrimPath.b().a();
        this.b = baseKeyframeAnimationA2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = shapeTrimPath.d().a();
        this.c = baseKeyframeAnimationA3;
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseLayer.j(baseKeyframeAnimationA3);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        baseKeyframeAnimationA3.a(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
    }

    public void e(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f20836a.add(animationListener);
    }

    public BaseKeyframeAnimation<?, Float> g() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f20835a;
    }

    public ShapeTrimPath.Type getType() {
        return this.f20834a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        for (int i = 0; i < this.f20836a.size(); i++) {
            this.f20836a.get(i).h();
        }
    }

    public BaseKeyframeAnimation<?, Float> i() {
        return this.c;
    }

    public BaseKeyframeAnimation<?, Float> j() {
        return this.f45999a;
    }

    public boolean k() {
        return this.f20837a;
    }
}
