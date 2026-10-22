package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class Effect {

    @SerializedName("Type")
    private Type mType;

    public enum Type {
        blur_background,
        running_display_mode,
        transition,
        audio_effect,
        audio_fade
    }

    public Effect(Type type) {
        this.mType = type;
    }

    public Type getType() {
        return this.mType;
    }
}
