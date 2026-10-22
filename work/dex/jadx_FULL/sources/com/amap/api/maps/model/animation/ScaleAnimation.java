package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class ScaleAnimation extends Animation {

    @JBindingInclude
    private float mFromX;

    @JBindingInclude
    private float mFromY;

    @JBindingInclude
    private float mPivotX;

    @JBindingInclude
    private float mPivotY;

    @JBindingInclude
    private float mToX;

    @JBindingInclude
    private float mToY;

    public ScaleAnimation(float f, float f2, float f3, float f4) {
        this.glAnimation = new GLScaleAnimation(f, f2, f3, f4);
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "ScaleAnimation";
    }
}
