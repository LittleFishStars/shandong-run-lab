package com.aliyun.svideosdk.common.struct.project;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RollCaptionTrackClip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient int f25682a;

    @SerializedName("Text")
    private String b;

    @SerializedName("Font")
    private Source c;

    @SerializedName("TimelineIn")
    private float d;

    @SerializedName("TimelineOut")
    private float e;

    @SerializedName("TextColor")
    private int f = -1;

    @SerializedName("OutlineColor")
    private int g = 0;

    public Source getFont() {
        return this.c;
    }

    public int getId() {
        return this.f25682a;
    }

    public int getOutlineColor() {
        return this.g;
    }

    public String getText() {
        return this.b;
    }

    public int getTextColor() {
        return this.f;
    }

    public float getTimelineIn() {
        return this.d;
    }

    public float getTimelineOut() {
        return this.e;
    }

    public void setFont(Source source) {
        this.c = source;
    }

    public void setId(int i) {
        this.f25682a = i;
    }

    public void setOutlineColor(int i) {
        this.g = i;
    }

    public void setText(String str) {
        this.b = str;
    }

    public void setTextColor(int i) {
        this.f = i;
    }

    public void setTimelineIn(float f) {
        this.d = f;
    }

    public void setTimelineOut(float f) {
        this.e = f;
    }
}
