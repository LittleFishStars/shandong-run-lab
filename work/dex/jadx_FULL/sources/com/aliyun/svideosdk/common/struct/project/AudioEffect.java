package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AudioEffectType;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AudioEffect extends Effect {

    @SerializedName("EffectParam")
    public int mEffectParam;

    @SerializedName("EffectType")
    public AudioEffectType mEffectType;

    public AudioEffect() {
        super(Effect.Type.audio_effect);
    }

    public AudioEffect(int i, int i2) {
        this(AudioEffectType.values()[i], i2);
    }

    public AudioEffect(AudioEffectType audioEffectType, int i) {
        this();
        this.mEffectType = audioEffectType;
        this.mEffectParam = i;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AudioEffect) && ((AudioEffect) obj).mEffectType == this.mEffectType;
    }
}
