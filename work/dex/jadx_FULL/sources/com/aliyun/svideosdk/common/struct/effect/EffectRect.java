package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.svideosdk.common.c.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EffectRect implements IEffectRect, ICopyable<EffectRect> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f25668a = 0.5f;
    protected float b = 0.5f;
    protected float c = 1.0f;
    protected float d = 1.0f;
    protected float e = 0.0f;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public EffectRect copy() {
        EffectRect effectRect = new EffectRect();
        effectRect.f25668a = this.f25668a;
        effectRect.b = this.b;
        effectRect.c = this.c;
        effectRect.d = this.d;
        effectRect.e = this.e;
        return effectRect;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public void copy(EffectRect effectRect) {
        this.f25668a = effectRect.f25668a;
        this.b = effectRect.b;
        this.c = effectRect.c;
        this.d = effectRect.d;
        this.e = effectRect.e;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getHeightRatio() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getRotation() {
        return this.e;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getWidthRatio() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getXRadio() {
        return this.f25668a;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getYRadio() {
        return this.b;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setHeightRatio(float f) {
        this.d = ((Float) a.a(Float.valueOf(f), Float.valueOf(0.0f), Float.valueOf(1.0f))).floatValue();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setRotation(float f) {
        this.e = f;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setWidthRatio(float f) {
        this.c = ((Float) a.a(Float.valueOf(f), Float.valueOf(0.0f), Float.valueOf(1.0f))).floatValue();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setXRadio(float f) {
        this.f25668a = f;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setYRatio(float f) {
        this.b = f;
    }
}
