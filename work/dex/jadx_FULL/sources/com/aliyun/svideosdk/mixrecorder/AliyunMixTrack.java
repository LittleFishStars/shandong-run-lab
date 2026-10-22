package com.aliyun.svideosdk.mixrecorder;

import com.aliyun.Visible;
import com.aliyun.common.c.a.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunMixTrack {
    private AliyunMixStream mAliyunMixStream;
    private AliyunMixTrackLayoutParam mMixTrackLayoutParam;
    private int mTrackId;
    private int mMixAudioWeight = 100;
    private boolean outputAudioTrack = false;

    public AliyunMixTrack() {
    }

    @Deprecated
    public AliyunMixTrack(int i) {
        this.mTrackId = i;
    }

    public int addStream(AliyunMixStream aliyunMixStream) {
        if (aliyunMixStream == null) {
            a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        aliyunMixStream.setTrack(this);
        this.mAliyunMixStream = aliyunMixStream;
        return 0;
    }

    public int getMixAudioWeight() {
        return this.mMixAudioWeight;
    }

    public AliyunMixStream getMixStream() {
        return this.mAliyunMixStream;
    }

    public AliyunMixTrackLayoutParam getMixTrackLayoutParam() {
        return this.mMixTrackLayoutParam;
    }

    @Deprecated
    public int getTrackId() {
        return this.mTrackId;
    }

    public boolean isAudioOutputTrack() {
        return this.outputAudioTrack;
    }

    public void setIsOutputAudioTrack(boolean z) {
        this.outputAudioTrack = z;
    }

    public void setMixAudioWeight(int i) {
        this.mMixAudioWeight = i;
    }

    public void setMixTrackLayoutParam(AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam) {
        this.mMixTrackLayoutParam = aliyunMixTrackLayoutParam;
    }

    @Deprecated
    public void setTrackId(int i) {
        this.mTrackId = i;
    }
}
