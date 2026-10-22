package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectTrack extends Track {

    @SerializedName("TimelineIn")
    protected float mTimelineIn;

    @SerializedName("TimelineOut")
    protected float mTimelineOut;

    @SerializedName("Type")
    private Type mType;

    public enum Type {
        time_effect,
        filter,
        animation_filter,
        mv,
        lut_filter
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public Type getType() {
        return this.mType;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
