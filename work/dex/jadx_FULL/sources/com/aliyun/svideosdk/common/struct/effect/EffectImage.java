package com.aliyun.svideosdk.common.struct.effect;

import android.graphics.Bitmap;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectImage extends EffectBase implements IEffectRect, ICopyable<EffectImage> {
    private Bitmap bitmap;
    private EffectRect mRect = new EffectRect();

    public EffectImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public EffectImage(Source source) {
        setSource(source);
    }

    public EffectImage(String str) {
        setPath(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public EffectImage copy() {
        EffectImage effectImage = new EffectImage(this.mSource);
        effectImage.setViewId(this.viewId);
        effectImage.setResId(this.resId);
        effectImage.mRect.copy(this.mRect);
        effectImage.bitmap = this.bitmap;
        return effectImage;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public void copy(EffectImage effectImage) {
        super.copy((EffectBase) effectImage);
        this.mRect.copy(effectImage.mRect);
        this.bitmap = effectImage.bitmap;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
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
