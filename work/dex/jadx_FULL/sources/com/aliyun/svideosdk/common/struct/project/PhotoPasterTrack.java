package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class PhotoPasterTrack extends PasterTrack implements TemplateNode {

    @SerializedName("Actions")
    private List<ActionBase> mActions = new ArrayList();
    private transient List<Frame> mFrameArray;

    @SerializedName(AliyunVodKey.KEY_VOD_HEIGHT)
    private float mHeight;

    @SerializedName("Mirror")
    private boolean mMirror;
    private transient String mName;

    @SerializedName("NodeKey")
    protected String mNodeKey;

    @SerializedName("Rotation")
    private float mRotation;

    @SerializedName("Source")
    private Source mSource;
    private transient List<FrameTime> mTimeArray;

    @SerializedName("TimelineIn")
    private float mTimelineIn;

    @SerializedName("TimelineOut")
    private float mTimelineOut;

    @SerializedName("Width")
    private float mWidth;

    @SerializedName("X")
    private float mX;

    @SerializedName("Y")
    private float mY;

    public PhotoPasterTrack() {
        setType(PasterTrack.Type.photo);
    }

    public List<ActionBase> getActions() {
        return this.mActions;
    }

    public List<Frame> getFrameArray() {
        return this.mFrameArray;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public String getNodeKey() {
        return this.mNodeKey;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public Source getSource() {
        return this.mSource;
    }

    public List<FrameTime> getTimeArray() {
        return this.mTimeArray;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
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

    public boolean isMirror() {
        return this.mMirror;
    }

    public void setFrameArray(List<Frame> list) {
        this.mFrameArray = list;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setMirror(boolean z) {
        this.mMirror = z;
    }

    public void setName(String str) {
        this.mName = str;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public void setNodeKey(String str) {
        this.mNodeKey = str;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setTimeArray(List<FrameTime> list) {
        this.mTimeArray = list;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
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

    public String toString() {
        return super.toString() + "PhotoPasterTrack{mSource=" + this.mSource + ", mX=" + this.mX + ", mY=" + this.mY + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mRotation=" + this.mRotation + ", mMirror=" + this.mMirror + ", mTimelineIn=" + this.mTimelineIn + ", mTimelineOut=" + this.mTimelineOut + ", mActions=" + this.mActions + ", mFrameArray=" + this.mFrameArray + ", mTimeArray=" + this.mTimeArray + ", mName='" + this.mName + "'}";
    }
}
