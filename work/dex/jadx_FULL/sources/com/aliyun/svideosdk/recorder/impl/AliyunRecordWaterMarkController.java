package com.aliyun.svideosdk.recorder.impl;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public class AliyunRecordWaterMarkController extends a<EffectImage> {
    protected d mRecordStickerExecutor;

    public AliyunRecordWaterMarkController(Source source, d dVar) {
        this.mModel = new EffectImage(source);
        this.mRecordStickerExecutor = dVar;
    }

    public float getHeightRatio() {
        return ((EffectImage) this.mModel).getHeightRatio();
    }

    public float getRotation() {
        return ((EffectImage) this.mModel).getRotation();
    }

    public Source getSource() {
        return ((EffectImage) this.mModel).getSource();
    }

    @Override // com.aliyun.svideosdk.recorder.impl.a
    public AliyunRecordStickerType getType() {
        return AliyunRecordStickerType.WATERMARK;
    }

    public float getWidthRatio() {
        return ((EffectImage) this.mModel).getWidthRatio();
    }

    public float getXRadio() {
        return ((EffectImage) this.mModel).getXRadio();
    }

    public float getYRadio() {
        return ((EffectImage) this.mModel).getYRadio();
    }

    @Override // com.aliyun.svideosdk.common.framework.a.a
    public void onUpdate(EffectImage effectImage) {
        if (this.mRecordStickerExecutor != null) {
            if (((EffectImage) this.mModel).getViewId() == 0) {
                this.mRecordStickerExecutor.a(this);
            } else {
                this.mRecordStickerExecutor.c(this);
            }
        }
    }

    public void setHeightRatio(float f) {
        ((EffectImage) this.mModel).setHeightRatio(f);
    }

    public void setRotation(float f) {
        ((EffectImage) this.mModel).setRotation(f);
    }

    public void setSource(Source source) {
        ((EffectImage) this.mModel).setSource(source);
    }

    public void setWidthRatio(float f) {
        ((EffectImage) this.mModel).setWidthRatio(f);
    }

    public void setXRadio(float f) {
        ((EffectImage) this.mModel).setXRadio(f);
    }

    public void setYRatio(float f) {
        ((EffectImage) this.mModel).setYRatio(f);
    }
}
