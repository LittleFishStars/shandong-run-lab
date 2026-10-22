package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class TranslateAnimation extends Animation {

    @JBindingInclude
    private double x;

    @JBindingInclude
    private double y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.x = latLng.latitude;
        this.y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "TranslateAnimation";
    }
}
