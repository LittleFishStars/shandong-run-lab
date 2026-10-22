package com.autonavi.base.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IAnimation {
    void setAnimation(GLAnimation gLAnimation);

    void setAnimationListener(Animation.AnimationListener animationListener);

    boolean startAnimation();
}
