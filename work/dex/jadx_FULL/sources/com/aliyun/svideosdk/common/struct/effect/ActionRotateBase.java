package com.aliyun.svideosdk.common.struct.effect;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionRotateBase extends ActionFrameBase<Float> {

    @SerializedName("CenterCoordinateSys")
    protected int mCenterCoordinateSys;

    @SerializedName("CenterX")
    protected float mCenterX;

    @SerializedName("CenterY")
    protected float mCenterY;

    public void setCenterCoordinateSys(int i) {
        this.mCenterCoordinateSys = i;
    }

    public void setCenterX(float f) {
        this.mCenterX = f;
    }

    public void setCenterY(float f) {
        this.mCenterY = f;
    }
}
