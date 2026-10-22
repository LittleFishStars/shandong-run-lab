package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public RectParticleShape(float f, float f2, float f3, float f4, boolean z) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.isUseRatio = z;
        this.type = 1;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return null;
    }
}
