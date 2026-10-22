package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AudioTrackClip extends TrackClip {

    @SerializedName("Effects")
    private List<Effect> mEffects = new ArrayList();

    @SerializedName("In")
    private float mIn;

    @SerializedName("Out")
    private float mOut;

    @SerializedName("Source")
    private Source mSource;

    @SerializedName("Type")
    private Type mType;

    public enum Type {
        Music,
        Dubs
    }

    public List<Effect> getEffects() {
        return this.mEffects;
    }

    public float getIn() {
        return this.mIn;
    }

    public float getOut() {
        return this.mOut;
    }

    public Source getSource() {
        return this.mSource;
    }

    public Type getType() {
        return this.mType;
    }

    public void setIn(float f) {
        this.mIn = f;
    }

    public void setOut(float f) {
        this.mOut = f;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
