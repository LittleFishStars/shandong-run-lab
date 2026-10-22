package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class MainVideoTrackClip extends VideoTrackClip {

    @SerializedName("ClassType")
    String ClassType = "main";

    @SerializedName("DisplayMode")
    private int mDisplayMode;

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }
}
