package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class BubbleCaptionTrack extends SubTitleTrack {

    @SerializedName("TextCenterX")
    private float mTextCenterX;

    @SerializedName("TextCenterY")
    private float mTextCenterY;

    public BubbleCaptionTrack() {
        setType(PasterTrack.Type.bubble_caption);
    }

    public float getTextCenterX() {
        return this.mTextCenterX;
    }

    public float getTextCenterY() {
        return this.mTextCenterY;
    }

    public void setTextCenterX(float f) {
        this.mTextCenterX = f;
    }

    public void setTextCenterY(float f) {
        this.mTextCenterY = f;
    }
}
