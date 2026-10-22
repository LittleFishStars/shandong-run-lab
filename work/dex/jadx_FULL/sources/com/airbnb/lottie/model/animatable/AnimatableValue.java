package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.zj.adlib.ps4;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> a();

    List<ps4<K>> b();

    boolean isStatic();
}
