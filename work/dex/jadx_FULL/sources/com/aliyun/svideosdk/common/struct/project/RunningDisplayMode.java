package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class RunningDisplayMode extends VideoEffect {

    @SerializedName("Mode")
    private int mDisplayMode;

    public RunningDisplayMode(int i, int i2, long j, long j2, int i3) {
        super(Effect.Type.running_display_mode, i, i2, j, j2);
        this.mDisplayMode = i3;
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }

    public String toString() {
        return "RunningDisplayMode{mId=" + getId() + ", mDisplayMode=" + this.mDisplayMode + ", mStartTimeMills=" + getStartTime() + ", mDurationMills=" + getDuration() + ", mStreamId=" + getStreamId() + '}';
    }
}
