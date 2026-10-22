package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.zj.adlib.a45;
import com.zj.adlib.j45;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
abstract class LottieInterpolatedValue<T> extends j45<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f23406a;
    public final T b;
    public final T c;

    public LottieInterpolatedValue(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    @Override // com.zj.adlib.j45
    public T a(a45<T> a45Var) {
        return e(this.b, this.c, this.f23406a.getInterpolation(a45Var.e()));
    }

    public abstract T e(T t, T t2, float f);

    public LottieInterpolatedValue(T t, T t2, Interpolator interpolator) {
        this.b = t;
        this.c = t2;
        this.f23406a = interpolator;
    }
}
