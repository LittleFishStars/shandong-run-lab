package com.aliyun.svideosdk.recorder.impl;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.EffectSticker;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public class AliyunRecordPasterController extends a<EffectSticker> {
    protected d mRecordStickerExecutor;

    public AliyunRecordPasterController(Source source, d dVar) {
        this.mModel = new EffectSticker(source);
        this.mRecordStickerExecutor = dVar;
    }

    public float getHeightRatio() {
        return ((EffectSticker) this.mModel).getHeightRatio();
    }

    public float getRotation() {
        return ((EffectSticker) this.mModel).getRotation();
    }

    public Source getSource() {
        return ((EffectSticker) this.mModel).getSource();
    }

    @Override // com.aliyun.svideosdk.recorder.impl.a
    public AliyunRecordStickerType getType() {
        return AliyunRecordStickerType.STICKER;
    }

    public float getWidthRatio() {
        return ((EffectSticker) this.mModel).getWidthRatio();
    }

    public float getXRadio() {
        return ((EffectSticker) this.mModel).getXRadio();
    }

    public float getYRadio() {
        return ((EffectSticker) this.mModel).getYRadio();
    }

    public boolean isFlipH() {
        return ((EffectSticker) this.mModel).isFlipH();
    }

    @Override // com.aliyun.svideosdk.common.framework.a.a
    public void onUpdate(EffectSticker effectSticker) {
        if (this.mRecordStickerExecutor != null) {
            if (((EffectSticker) this.mModel).getViewId() == 0) {
                this.mRecordStickerExecutor.a(this);
            } else {
                this.mRecordStickerExecutor.c(this);
            }
        }
    }

    public void setFlipH(boolean z) {
        ((EffectSticker) this.mModel).setFlipH(z);
    }

    public void setHeightRatio(float f) {
        ((EffectSticker) this.mModel).setHeightRatio(f);
    }

    public void setRotation(float f) {
        ((EffectSticker) this.mModel).setRotation(f);
    }

    public void setSource(Source source) {
        ((EffectSticker) this.mModel).setSource(source);
    }

    public void setWidthRatio(float f) {
        ((EffectSticker) this.mModel).setWidthRatio(f);
    }

    public void setXRadio(float f) {
        ((EffectSticker) this.mModel).setXRadio(f);
    }

    public void setYRatio(float f) {
        ((EffectSticker) this.mModel).setYRatio(f);
    }
}
