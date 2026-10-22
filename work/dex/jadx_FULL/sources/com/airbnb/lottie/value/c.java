package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.zj.adlib.a45;
import com.zj.adlib.up5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends LottieInterpolatedValue<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f23407a;

    public c(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f23407a = new PointF();
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.zj.adlib.j45
    public /* bridge */ /* synthetic */ Object a(a45 a45Var) {
        return super.a(a45Var);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public PointF e(PointF pointF, PointF pointF2, float f) {
        this.f23407a.set(up5.k(pointF.x, pointF2.x, f), up5.k(pointF.y, pointF2.y, f));
        return this.f23407a;
    }

    public c(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f23407a = new PointF();
    }
}
