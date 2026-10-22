package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class VideoEffect extends Effect {
    private transient long mDurationMills;
    private transient int mId;

    @SerializedName("In")
    private float mIn;

    @SerializedName("Out")
    private float mOut;
    private transient int mStreamId;

    public VideoEffect(Effect.Type type, int i, int i2, long j, long j2) {
        super(type);
        this.mId = i2;
        this.mStreamId = i;
        float f = j / 1000.0f;
        this.mIn = f;
        this.mDurationMills = j2;
        this.mOut = f + (j2 / 1000.0f);
    }

    public long getDuration() {
        return (long) ((this.mOut - this.mIn) * 1000.0f);
    }

    public int getId() {
        return this.mId;
    }

    public float getIn() {
        return this.mIn;
    }

    public float getOut() {
        return this.mOut;
    }

    public long getStartTime() {
        return (long) (this.mIn * 1000.0f);
    }

    public int getStreamId() {
        return this.mStreamId;
    }

    public void setDuration(long j) {
        this.mDurationMills = j;
        this.mOut = this.mIn + (j / 1000.0f);
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setIn(float f) {
        this.mIn = f;
    }

    public void setOut(float f) {
        this.mOut = f;
    }

    public void setStartTime(long j) {
        float f = j / 1000.0f;
        this.mIn = f;
        this.mOut = f + (this.mDurationMills / 1000.0f);
    }

    public void setStreamId(int i) {
        this.mStreamId = i;
    }
}
