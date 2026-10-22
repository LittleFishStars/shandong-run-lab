package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.zj.adlib.a45;
import com.zj.adlib.up5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends LottieInterpolatedValue<Float> {
    public a(Float f, Float f2) {
        super(f, f2);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.zj.adlib.j45
    public /* bridge */ /* synthetic */ Object a(a45 a45Var) {
        return super.a(a45Var);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float e(Float f, Float f2, float f3) {
        return Float.valueOf(up5.k(f.floatValue(), f2.floatValue(), f3));
    }

    public a(Float f, Float f2, Interpolator interpolator) {
        super(f, f2, interpolator);
    }
}
