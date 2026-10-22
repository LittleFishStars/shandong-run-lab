package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.f;
import com.airbnb.lottie.animation.keyframe.g;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h60 implements AnimatableValue<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ps4<PointF>> f42057a;

    public h60(List<ps4<PointF>> list) {
        this.f42057a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        return this.f42057a.get(0).h() ? new g(this.f42057a) : new f(this.f42057a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<ps4<PointF>> b() {
        return this.f42057a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.f42057a.size() == 1 && this.f42057a.get(0).h();
    }
}
