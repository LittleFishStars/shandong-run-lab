package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;
import com.google.android.exoplayer2.source.rtsp.d;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class Config {

    @SerializedName("Bitrate")
    private int mBitrate;

    @SerializedName("DisplayMode")
    private int mDisplayMode;

    @SerializedName("FPS")
    private int mFps;

    @SerializedName("Mute")
    private boolean mMute;

    @SerializedName("OutputHeight")
    private int mOutputHeight;

    @SerializedName("OutputWidth")
    private int mOutputWidth;

    @SerializedName("VideoCodec")
    private int mVideoCodec;

    @SerializedName("GOP")
    private int mGop = -1;

    @SerializedName("VideoQuality")
    private int mVideoQuality = -1;

    @SerializedName("CRF")
    private int mCrf = 23;

    @SerializedName(d.x)
    private float mScale = 1.0f;

    @SerializedName("Volume")
    private int mVolume = 50;

    @SerializedName("BackgroundColor")
    private int mBackgroundColor = -16777216;

    @SerializedName("AudioSampleRate")
    private int mAudioSampleRate = AliyunVideoParam.AudioSampleRate.AUDIO_PCM_44_1K.getValue();

    @SerializedName("AudioChannel")
    private int mAudioChannel = 2;

    public int getAudioChannel() {
        return this.mAudioChannel;
    }

    public int getAudioSampleRate() {
        return this.mAudioSampleRate;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getCrf() {
        return this.mCrf;
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoQuality() {
        return this.mVideoQuality;
    }

    public int getVolume() {
        return this.mVolume;
    }

    public boolean isMute() {
        return this.mMute;
    }

    public void setAudioChannel(int i) {
        if (i == 1 || i == 2) {
            this.mAudioChannel = i;
        }
    }

    public void setAudioSampleRate(int i) {
        this.mAudioSampleRate = i;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }

    public void setFps(int i) {
        this.mFps = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setMute(boolean z) {
        this.mMute = z;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public void setVideoCodec(int i) {
        this.mVideoCodec = i;
    }

    public void setVideoQuality(int i) {
        this.mVideoQuality = i;
    }

    public void setVolume(int i) {
        this.mVolume = i;
    }
}
