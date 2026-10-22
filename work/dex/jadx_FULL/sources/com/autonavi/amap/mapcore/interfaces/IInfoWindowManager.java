package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(Animation animation);

    void setInfoWindowBackColor(int i);

    void setInfoWindowBackEnable(boolean z);

    void setInfoWindowBackScale(float f, float f2);

    void setInfoWindowDisappearAnimation(Animation animation);

    void setInfoWindowMovingAnimation(Animation animation);

    void startAnimation();
}
