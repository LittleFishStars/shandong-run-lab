package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class MediaTrack extends Track {

    @SerializedName("Duration")
    private float mDuration;

    public float getDuration() {
        return this.mDuration;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }
}
