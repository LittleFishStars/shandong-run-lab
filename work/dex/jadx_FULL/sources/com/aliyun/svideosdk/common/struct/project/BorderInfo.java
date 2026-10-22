package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class BorderInfo {

    @SerializedName("Color")
    private int color;

    @SerializedName("CornerRadius")
    private float cornerRadius;

    @SerializedName("Width")
    private float width;

    public int getColor() {
        return this.color;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getWidth() {
        return this.width;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public String toString() {
        return "BorderInfo{color=" + this.color + ", width=" + this.width + ", cornerRadius=" + this.cornerRadius + '}';
    }
}
