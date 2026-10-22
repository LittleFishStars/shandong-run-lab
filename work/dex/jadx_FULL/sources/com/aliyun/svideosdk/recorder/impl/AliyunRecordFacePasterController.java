package com.aliyun.svideosdk.recorder.impl;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.EffectSticker;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public class AliyunRecordFacePasterController extends AliyunRecordPasterController {
    public AliyunRecordFacePasterController(Source source, d dVar) {
        super(source, dVar);
        ((EffectSticker) this.mModel).setWidthRatio(0.0f);
        ((EffectSticker) this.mModel).setHeightRatio(0.0f);
    }

    @Override // com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController, com.aliyun.svideosdk.recorder.impl.a
    public AliyunRecordStickerType getType() {
        return AliyunRecordStickerType.FACE_STICKER;
    }
}
