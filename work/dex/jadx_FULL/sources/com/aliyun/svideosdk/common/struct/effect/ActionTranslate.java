package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionTranslate extends ActionFrameBase<Frame.FramePoint> {

    @SerializedName("FromX")
    protected float mFromPointX;

    @SerializedName("FromY")
    protected float mFromPointY;

    @SerializedName("ToX")
    protected float mToPointX;

    @SerializedName("ToY")
    protected float mToPointY;

    @SerializedName("TranslateType")
    protected int mTranslateType = TranslateType.TranslateTo.ordinal();

    public enum TranslateType {
        TranslateTo,
        TranslateBy
    }

    public ActionTranslate() {
        this.mType = ActionBase.Type.translate;
    }

    public float getFromPointX() {
        return this.mFromPointX;
    }

    public float getFromPointY() {
        return this.mFromPointY;
    }

    public float getToPointX() {
        return this.mToPointX;
    }

    public float getToPointY() {
        return this.mToPointY;
    }

    public void setFromPointX(float f) {
        this.mFromPointX = f;
    }

    public void setFromPointY(float f) {
        this.mFromPointY = f;
    }

    public void setToPointX(float f) {
        this.mToPointX = f;
    }

    public void setToPointY(float f) {
        this.mToPointY = f;
    }

    public void setTranslateType(TranslateType translateType) {
        this.mTranslateType = translateType.ordinal();
    }
}
