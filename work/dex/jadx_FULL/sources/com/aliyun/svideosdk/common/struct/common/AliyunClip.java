package com.aliyun.svideosdk.common.struct.common;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public abstract class AliyunClip {
    protected int mClipHeight;
    protected int mClipWidth;
    private String mSource;
    private TransitionBase mTransition;
    private int mId = 0;
    private int mRotation = -1;
    private AliyunDisplayMode mDisplayMode = AliyunDisplayMode.DEFAULT;
    private MediaType mediaType = MediaType.ANY_VIDEO_TYPE;

    public int getClipHeight() {
        return this.mClipHeight;
    }

    public int getClipWidth() {
        return this.mClipWidth;
    }

    public AliyunDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getId() {
        return this.mId;
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }

    public String getSource() {
        return this.mSource;
    }

    public TransitionBase getTransition() {
        return this.mTransition;
    }

    public void setDisplayMode(AliyunDisplayMode aliyunDisplayMode) {
        this.mDisplayMode = aliyunDisplayMode;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setTransition(TransitionBase transitionBase) {
        this.mTransition = transitionBase;
    }
}
