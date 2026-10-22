package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.common.net.b;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionRotateBy extends ActionRotateBase {

    @SerializedName(b.t)
    protected float mFromDegree;

    @SerializedName("Rotate")
    protected float mRotateDegree;

    public ActionRotateBy() {
        this.mType = ActionBase.Type.rotate_by;
    }

    public float getRotateDegree() {
        return this.mRotateDegree;
    }

    public void setFromDegree(float f) {
        this.mFromDegree = f;
    }

    public void setRotateDegree(float f) {
        this.mRotateDegree = f;
    }
}
