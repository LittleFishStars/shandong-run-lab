package com.aliyun.svideosdk.common.struct.common;

import com.aliyun.Visible;
import com.google.android.exoplayer2.util.FileTypes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunAudioClip {
    private long mEndTime;
    private String mFilePath;
    private int mId;
    private long mStartTime;

    public AliyunAudioClip(int i, long j, String str) {
        this.mId = i;
        this.mStartTime = j;
        this.mFilePath = str + FileTypes.f5242f;
    }

    public long getDuration() {
        return this.mEndTime - this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public int getId() {
        return this.mId;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public String toString() {
        return "AliyunAudioClip{mId=" + this.mId + ", mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", mPcmFilePath='" + this.mFilePath + "'}";
    }
}
