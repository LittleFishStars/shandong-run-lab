package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.android.exoplayer2.source.rtsp.d;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class PipVideoTrackClip extends VideoTrackClip {

    @SerializedName("ClassType")
    String ClassType = "pip";

    @SerializedName("Alpha")
    private float alpha;

    @SerializedName("Border")
    private BorderInfo border;

    @SerializedName("X")
    private float centerX;

    @SerializedName("Y")
    private float centerY;

    @SerializedName("OutputRotation")
    private float rotationRadian;

    @SerializedName(d.x)
    private float scale;

    public float getAlpha() {
        return this.alpha;
    }

    public BorderInfo getBorder() {
        if (this.border == null) {
            this.border = new BorderInfo();
        }
        return this.border;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getRotationRadian() {
        return this.rotationRadian;
    }

    public float getScale() {
        return this.scale;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public void setBorder(BorderInfo borderInfo) {
        this.border = borderInfo;
    }

    public void setCenterX(float f) {
        this.centerX = f;
    }

    public void setCenterY(float f) {
        this.centerY = f;
    }

    public void setRotationRadian(float f) {
        this.rotationRadian = f;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public String toString() {
        return "PipVideoTrackClip{centerX=" + this.centerX + ", centerY=" + this.centerY + ", scale=" + this.scale + ", rotationRadian=" + this.rotationRadian + ", border=" + this.border + '}';
    }
}
