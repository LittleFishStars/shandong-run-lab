package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class MVFilter extends EffectTrack {

    @SerializedName("MixWeight")
    private int mMixWeight = 50;

    @SerializedName("Mute")
    private boolean mMute = false;

    @SerializedName("Source")
    private Source mSource;

    public MVFilter() {
        setType(EffectTrack.Type.mv);
    }

    public int getMixWeight() {
        return this.mMixWeight;
    }

    public Source getSource() {
        return this.mSource;
    }

    public boolean isMute() {
        return this.mMute;
    }

    public void setMixWeight(int i) {
        this.mMixWeight = i;
    }

    public void setMute(boolean z) {
        this.mMute = z;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }
}
