package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.common.net.b;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionRotateTo extends ActionRotateBase {

    @SerializedName(b.t)
    protected float mFromDegree;

    @SerializedName("To")
    protected float mRotateToDegree;

    public ActionRotateTo() {
        this.mType = ActionBase.Type.rotate_to;
    }

    public float getFromDegree() {
        return this.mFromDegree;
    }

    public float getRotateToDegree() {
        return this.mRotateToDegree;
    }

    public void setFromDegree(float f) {
        this.mFromDegree = f;
    }

    public void setRotateToDegree(float f) {
        this.mRotateToDegree = f;
    }
}
