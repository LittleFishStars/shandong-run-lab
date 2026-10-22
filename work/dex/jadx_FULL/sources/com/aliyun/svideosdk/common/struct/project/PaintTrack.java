package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.CanvasInfo;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class PaintTrack extends GlobalTrack {

    @SerializedName("CanvasInfo")
    private CanvasInfo canvasInfo;

    @SerializedName("Source")
    private Source mSource;

    @SerializedName("TimelineIn")
    private float mTimelineIn;

    @SerializedName("TimelineOut")
    private float mTimelineOut;

    public PaintTrack() {
        setType(GlobalTrack.Type.paint);
    }

    public CanvasInfo getCanvasInfo() {
        return this.canvasInfo;
    }

    public Source getSource() {
        return this.mSource;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public void setCanvasInfo(CanvasInfo canvasInfo) {
        this.canvasInfo = canvasInfo;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }
}
