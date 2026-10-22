package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.common.net.b;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionScale extends ActionFrameBase<Float> {

    @SerializedName(b.t)
    protected float mFromScale;

    @SerializedName("AnchorBaseScale")
    protected float mScaleAnchorBaseScale = 1.0f;

    @SerializedName("ScaleAnchorEnable")
    protected boolean mScaleAnchorEnable;

    @SerializedName("AnchorX")
    protected float mScaleAnchorX;

    @SerializedName("AnchorY")
    protected float mScaleAnchorY;

    @SerializedName("To")
    protected float mToScale;

    public ActionScale() {
        this.mType = ActionBase.Type.scale;
    }

    public float getFromScale() {
        return this.mFromScale;
    }

    public float getToScale() {
        return this.mToScale;
    }

    public void setFromScale(float f) {
        this.mFromScale = f;
    }

    public void setScaleAnchorBaseScale(float f) {
        this.mScaleAnchorBaseScale = f;
    }

    public void setScaleAnchorEnable(boolean z) {
        this.mScaleAnchorEnable = z;
    }

    public void setScaleAnchorX(float f) {
        this.mScaleAnchorX = f;
    }

    public void setScaleAnchorY(float f) {
        this.mScaleAnchorY = f;
    }

    public void setToScale(float f) {
        this.mToScale = f;
    }
}
