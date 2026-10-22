package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j45<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public BaseKeyframeAnimation<?, ?> f42505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a45<T> f17324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public T f17325a;

    public j45() {
        this.f17324a = new a45<>();
        this.f17325a = null;
    }

    @Nullable
    public T a(a45<T> a45Var) {
        return this.f17325a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.f17324a.h(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f42505a = baseKeyframeAnimation;
    }

    public final void d(@Nullable T t) {
        this.f17325a = t;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.f42505a;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.h();
        }
    }

    public j45(@Nullable T t) {
        this.f17324a = new a45<>();
        this.f17325a = t;
    }
}
