package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InfoWindowAnimationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IInfoWindowManager f26108a;

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f26108a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f26108a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f26108a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i) {
        this.f26108a.setInfoWindowBackColor(i);
    }

    public void setInfoWindowBackEnable(boolean z) {
        this.f26108a.setInfoWindowBackEnable(z);
    }

    public void setInfoWindowBackScale(float f, float f2) {
        this.f26108a.setInfoWindowBackScale(f, f2);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f26108a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f26108a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f26108a.startAnimation();
    }
}
