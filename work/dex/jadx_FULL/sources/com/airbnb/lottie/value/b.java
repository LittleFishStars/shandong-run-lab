package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.zj.adlib.a45;
import com.zj.adlib.up5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends LottieInterpolatedValue<Integer> {
    public b(Integer num, Integer num2) {
        super(num, num2);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.zj.adlib.j45
    public /* bridge */ /* synthetic */ Object a(a45 a45Var) {
        return super.a(a45Var);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Integer e(Integer num, Integer num2, float f) {
        return Integer.valueOf(up5.l(num.intValue(), num2.intValue(), f));
    }

    public b(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }
}
