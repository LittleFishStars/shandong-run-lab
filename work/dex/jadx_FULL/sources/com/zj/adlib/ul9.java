package com.zj.adlib;

import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ul9<K, A> extends BaseKeyframeAnimation<K, A> {
    public final A b;

    public ul9(j45<A> j45Var) {
        this(j45Var, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public float b() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A f() {
        j45<A> j45Var = ((BaseKeyframeAnimation) this).f452a;
        A a2 = this.b;
        return j45Var.b(0.0f, 0.0f, a2, a2, d(), d(), d());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A g(ps4<K> ps4Var, float f) {
        return f();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void h() {
        if (((BaseKeyframeAnimation) this).f452a != null) {
            super.h();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void j(float f) {
        ((BaseKeyframeAnimation) this).f23343a = f;
    }

    public ul9(j45<A> j45Var, @Nullable A a2) {
        super(Collections.emptyList());
        k(j45Var);
        this.b = a2;
    }
}
