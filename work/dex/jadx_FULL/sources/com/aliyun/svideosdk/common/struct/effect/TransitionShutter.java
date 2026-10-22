package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TransitionShutter extends TransitionBase {

    @SerializedName("LineWidth")
    protected float mLineWidth;

    @SerializedName("Orientation")
    protected int mOrientation;

    public TransitionShutter() {
        ((TransitionBase) this).mType = 0;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public TransitionShutter setLineWidth(float f) {
        this.mLineWidth = f;
        return this;
    }

    public TransitionShutter setOrientation(int i) {
        this.mOrientation = i;
        return this;
    }
}
