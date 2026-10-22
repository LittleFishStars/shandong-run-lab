package com.aliyun.svideosdk.recorder.impl;

import com.aliyun.svideosdk.common.struct.effect.ICopyable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a<MODEL extends ICopyable<MODEL>> extends com.aliyun.svideosdk.common.framework.a.a<MODEL> {
    public MODEL getModel() {
        return this.mModel;
    }

    public abstract AliyunRecordStickerType getType();
}
