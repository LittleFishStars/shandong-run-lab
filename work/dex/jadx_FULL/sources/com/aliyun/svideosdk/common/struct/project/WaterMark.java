package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class WaterMark extends GlobalTrack {

    @SerializedName("Actions")
    private ArrayList<ActionBase> mActions = new ArrayList<>();

    @SerializedName(AliyunVodKey.KEY_VOD_HEIGHT)
    private float mHeight;

    @SerializedName("Source")
    private Source mSource;

    @SerializedName("Width")
    private float mWidth;

    @SerializedName("X")
    private float mX;

    @SerializedName("Y")
    private float mY;

    public WaterMark() {
        setType(GlobalTrack.Type.watermark);
    }

    public ArrayList<ActionBase> getActions() {
        return this.mActions;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public Source getSource() {
        return this.mSource;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public void setX(float f) {
        this.mX = f;
    }

    public void setY(float f) {
        this.mY = f;
    }
}
