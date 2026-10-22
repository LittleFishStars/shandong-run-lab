package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EmergeAnimation extends Animation {
    public EmergeAnimation(LatLng latLng) {
        this.glAnimation = new GLEmergeAnimation(latLng);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "EmergeAnimation";
    }
}
