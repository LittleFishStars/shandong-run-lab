package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.common.net.b;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class ActionRotate extends ActionRotateBase {

    @SerializedName("Clockwise")
    protected boolean mClockwise;

    @SerializedName("DurationPerCircle")
    protected float mDurationPerCircle;

    @SerializedName(b.t)
    protected float mFromDegree;

    @SerializedName("Repeat")
    protected boolean mRepeat;

    public ActionRotate() {
        this.mType = ActionBase.Type.rotate_repeat;
    }

    public float getDurationPerCircle() {
        return this.mDurationPerCircle;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public boolean isRepeat() {
        return this.mRepeat;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    @Deprecated
    public void setAnimationConfig(String str) {
        throw new RuntimeException("Not Support");
    }

    public void setClockwise(boolean z) {
        this.mClockwise = z;
    }

    public void setDurationPerCircle(long j) {
        this.mDurationPerCircle = j / 1000000.0f;
    }

    public void setFromDegree(float f) {
        this.mFromDegree = f;
    }

    @Deprecated
    public void setRepeat(boolean z) {
        this.mRepeat = z;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setRepeatCount(int i) {
        setRepeat(i > 0);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setRepeatMode(ActionBase.RepeatMode repeatMode) {
        throw new RuntimeException("Not Support");
    }
}
