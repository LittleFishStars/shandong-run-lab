package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AudioFade extends Effect {

    @SerializedName("Duration")
    public float duration;

    @SerializedName("FadeIn")
    public boolean isFadeIn;

    @SerializedName("ShapeType")
    public int shapeType;

    public AudioFade(int i, float f, boolean z) {
        super(Effect.Type.audio_fade);
        this.duration = f;
        this.shapeType = i;
        this.isFadeIn = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.isFadeIn == ((AudioFade) obj).isFadeIn;
    }
}
