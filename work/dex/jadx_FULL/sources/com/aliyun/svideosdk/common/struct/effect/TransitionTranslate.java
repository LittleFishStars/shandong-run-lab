package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TransitionTranslate extends TransitionBase {

    @SerializedName("Direction")
    protected int mDirection;

    public TransitionTranslate() {
        ((TransitionBase) this).mType = 1;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public TransitionTranslate setDirection(int i) {
        this.mDirection = i;
        return this;
    }
}
