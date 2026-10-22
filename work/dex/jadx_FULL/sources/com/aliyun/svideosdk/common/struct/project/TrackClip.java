package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TrackClip {
    private transient int mClipId;

    @SerializedName("DenoiseWeight")
    private int mDenoiseWeight;

    @SerializedName("MediaId")
    private String mMediaId;

    @SerializedName("MixWeight")
    private int mMixWeight = -1;

    @SerializedName("TimelineIn")
    private float mTimelineIn;

    @SerializedName("TimelineOut")
    private float mTimelineOut;

    public int getClipId() {
        return this.mClipId;
    }

    public int getDenoiseWeight() {
        return this.mDenoiseWeight;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int getMixWeight() {
        return this.mMixWeight;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public void setClipId(int i) {
        this.mClipId = i;
    }

    public void setDenoiseWeight(int i) {
        this.mDenoiseWeight = i;
    }

    public void setMediaId(String str) {
        this.mMediaId = str;
    }

    public void setMixWeight(int i) {
        this.mMixWeight = i;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }
}
