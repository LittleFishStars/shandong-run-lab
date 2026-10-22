package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class VideoTrackClip extends TrackClip implements TemplateNode {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 0;

    @SerializedName("Duration")
    private float mDuration;

    @SerializedName(AliyunVodKey.KEY_VOD_HEIGHT)
    private int mHeight;

    @SerializedName("In")
    private float mIn;

    @SerializedName("NodeKey")
    protected String mNodeKey;

    @SerializedName("Out")
    private float mOut;

    @SerializedName("Source")
    private Source mSource;

    @SerializedName("Width")
    private int mWidth;

    @SerializedName("Type")
    private int mType = 0;

    @SerializedName("Rotation")
    private int mRotation = -1;

    @SerializedName("BrightnessValue")
    private float mBrightness = 0.5f;

    @SerializedName("ContrastValue")
    private float mContrast = 0.25f;

    @SerializedName("VignetteValue")
    private float mVignette = 0.0f;

    @SerializedName("SaturationValue")
    private float mSaturation = 0.5f;

    @SerializedName("SharpnessValue")
    private float mSharpness = 0.0f;

    @SerializedName("HorizontalFlip")
    private boolean mHorizontalFlip = false;

    @SerializedName("Effects")
    private List<Effect> mEffects = new ArrayList();

    @SerializedName("Actions")
    private List<ActionBase> mActions = new ArrayList();

    public List<ActionBase> getActions() {
        return this.mActions;
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public float getContrast() {
        return this.mContrast;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public List<Effect> getEffects() {
        return this.mEffects;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean getHorizontalFlip() {
        return this.mHorizontalFlip;
    }

    public float getIn() {
        return this.mIn;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public String getNodeKey() {
        return this.mNodeKey;
    }

    public float getOut() {
        return this.mOut;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public float getSaturation() {
        return this.mSaturation;
    }

    public float getSharpness() {
        return this.mSharpness;
    }

    public Source getSource() {
        return this.mSource;
    }

    public TransitionBase getTransition() {
        for (Effect effect : this.mEffects) {
            if (effect instanceof TransitionBase) {
                return (TransitionBase) effect;
            }
        }
        return null;
    }

    public int getType() {
        return this.mType;
    }

    public float getVignette() {
        return this.mVignette;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isFileExists() {
        if (getSource() == null || q.b(getSource().getPath())) {
            return false;
        }
        return new File(getSource().getPath()).exists();
    }

    public boolean isHorizontalFlip() {
        return this.mHorizontalFlip;
    }

    public void setBrightness(float f) {
        this.mBrightness = f;
    }

    public void setContrast(float f) {
        this.mContrast = f;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setHorizontalFlip(boolean z) {
        this.mHorizontalFlip = z;
    }

    public void setIn(float f) {
        this.mIn = f;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public void setNodeKey(String str) {
        this.mNodeKey = str;
    }

    public void setOut(float f) {
        this.mOut = f;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setSaturation(float f) {
        this.mSaturation = f;
    }

    public void setSharpness(float f) {
        this.mSharpness = f;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setTransition(TransitionBase transitionBase) {
        for (Effect effect : this.mEffects) {
            if (effect instanceof TransitionBase) {
                this.mEffects.remove(effect);
                break;
            }
        }
        if (transitionBase != null) {
            this.mEffects.add(transitionBase);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVignette(float f) {
        this.mVignette = f;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }
}
