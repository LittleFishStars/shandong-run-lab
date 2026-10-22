package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Effect;
import com.aliyun.svideosdk.common.struct.project.VideoEffect;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class BlurBackground extends VideoEffect {

    @SerializedName("BlurRadius")
    private float mBlurRadius;

    public BlurBackground(int i, int i2, long j, long j2, float f) {
        super(Effect.Type.blur_background, i, i2, j, j2);
        this.mBlurRadius = f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BlurBackground) && ((BlurBackground) obj).getId() == getId();
    }

    public float getBlurRadius() {
        return this.mBlurRadius;
    }

    public void setBlurRadius(float f) {
        this.mBlurRadius = f;
    }
}
