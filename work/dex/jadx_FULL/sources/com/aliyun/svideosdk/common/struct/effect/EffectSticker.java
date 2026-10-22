package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectSticker extends EffectBase implements IEffectRect, ICopyable<EffectSticker> {
    protected EffectRect mRect = new EffectRect();
    protected boolean mFlipH = false;

    public EffectSticker(Source source) {
        setSource(source);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public EffectSticker copy() {
        EffectSticker effectSticker = new EffectSticker(this.mSource);
        effectSticker.setViewId(this.viewId);
        effectSticker.setResId(this.resId);
        effectSticker.mRect.copy(this.mRect);
        effectSticker.mFlipH = this.mFlipH;
        return effectSticker;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public void copy(EffectSticker effectSticker) {
        super.copy((EffectBase) effectSticker);
        this.mRect.copy(effectSticker.mRect);
        this.mFlipH = effectSticker.mFlipH;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getHeightRatio() {
        return this.mRect.getHeightRatio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getRotation() {
        return this.mRect.getRotation();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getWidthRatio() {
        return this.mRect.getWidthRatio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getXRadio() {
        return this.mRect.getXRadio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getYRadio() {
        return this.mRect.getYRadio();
    }

    public boolean isFlipH() {
        return this.mFlipH;
    }

    public void setFlipH(boolean z) {
        this.mFlipH = z;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setHeightRatio(float f) {
        this.mRect.setHeightRatio(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setRotation(float f) {
        this.mRect.setRotation(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setWidthRatio(float f) {
        this.mRect.setWidthRatio(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setXRadio(float f) {
        this.mRect.setXRadio(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setYRatio(float f) {
        this.mRect.setYRatio(f);
    }
}
