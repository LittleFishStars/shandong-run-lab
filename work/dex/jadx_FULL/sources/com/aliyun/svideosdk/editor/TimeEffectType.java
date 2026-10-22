package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public enum TimeEffectType {
    TIME_EFFECT_TYPE_NONE,
    TIME_EFFECT_TYPE_RATE,
    TIME_EFFECT_TYPE_REPEAT,
    TIME_EFFECT_TYPE_INVERT;

    public static TimeEffectType getTypeByValue(int i) {
        if (i == 0) {
            return TIME_EFFECT_TYPE_NONE;
        }
        if (i == 1) {
            return TIME_EFFECT_TYPE_RATE;
        }
        if (i == 2) {
            return TIME_EFFECT_TYPE_REPEAT;
        }
        if (i != 3) {
            return null;
        }
        return TIME_EFFECT_TYPE_INVERT;
    }
}
