package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public enum EffectType {
    EFFECT_TYPE_TIME(0),
    EFFECT_TYPE_MIX(1),
    EFFECT_TYPE_MV(2),
    EFFECT_TYPE_PITCH(3),
    EFFECT_TYPE_MV_AUDIO(4);

    private int effectType;

    EffectType(int i) {
        this.effectType = i;
    }

    public int getEffectType() {
        return this.effectType;
    }
}
