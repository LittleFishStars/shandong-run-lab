package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class AlphaAnimation extends Animation {

    @JBindingInclude
    private float mFromAlpha;

    @JBindingInclude
    private float mToAlpha;

    public AlphaAnimation(float f, float f2) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(f, f2);
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "AlphaAnimation";
    }
}
