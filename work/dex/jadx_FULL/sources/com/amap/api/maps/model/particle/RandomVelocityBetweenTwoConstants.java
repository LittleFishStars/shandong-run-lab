package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {

    @JBindingExclude
    private Random random = new Random();
    private float x1;
    private float x2;
    private float y1;
    private float y2;
    private float z1;
    private float z2;

    public RandomVelocityBetweenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6) {
        this.x1 = f;
        this.y1 = f2;
        this.z1 = f3;
        this.x2 = f4;
        this.y2 = f5;
        this.z2 = f6;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float fNextFloat = this.random.nextFloat();
        float f = this.x2;
        float f2 = this.x1;
        return (fNextFloat * (f - f2)) + f2;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float fNextFloat = this.random.nextFloat();
        float f = this.y2;
        float f2 = this.y1;
        return (fNextFloat * (f - f2)) + f2;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float fNextFloat = this.random.nextFloat();
        float f = this.z2;
        float f2 = this.z1;
        return (fNextFloat * (f - f2)) + f2;
    }
}
