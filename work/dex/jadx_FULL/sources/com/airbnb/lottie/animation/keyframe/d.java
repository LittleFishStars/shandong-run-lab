package com.airbnb.lottie.animation.keyframe;

import com.zj.adlib.cw3;
import com.zj.adlib.ps4;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends KeyframeAnimation<cw3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cw3 f23348a;

    public d(List<ps4<cw3>> list) {
        super(list);
        cw3 cw3Var = list.get(0).f18928a;
        int iC = cw3Var != null ? cw3Var.c() : 0;
        this.f23348a = new cw3(new float[iC], new int[iC]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public cw3 g(ps4<cw3> ps4Var, float f) {
        this.f23348a.d(ps4Var.f18928a, ps4Var.f18932b, f);
        return this.f23348a;
    }
}
