package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TailWaterMark extends WaterMark {

    @SerializedName("Duration")
    private float mDuration = 3.0f;

    public TailWaterMark() {
        setType(GlobalTrack.Type.tail_watermark);
    }

    public long getDuration() {
        return (long) (this.mDuration * 1000000.0f);
    }

    public void setDuration(long j) {
        this.mDuration = j / 1000000.0f;
    }
}
