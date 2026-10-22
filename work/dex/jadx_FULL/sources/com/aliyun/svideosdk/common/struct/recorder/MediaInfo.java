package com.aliyun.svideosdk.common.struct.recorder;

import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.b.a;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class MediaInfo {
    protected int mBitrate;
    private int videoHeight;
    private int videoWidth;
    private int fps = 30;
    private VideoCodecs mVideoCodec = VideoCodecs.H264_HARDWARE;
    private int mCrf = a.c;
    private int mEncoderFps = 30;
    protected int mGop = 250;
    protected VideoQuality mVideoQuality = VideoQuality.HD;

    public int getCrf() {
        return this.mCrf;
    }

    public int getEncoderFps() {
        return this.mEncoderFps;
    }

    public int getFps() {
        return this.fps;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getVideoBitrate() {
        return this.mBitrate;
    }

    public VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int setCrf(int i) {
        int i2 = a.f25626a;
        if (i >= i2 && i <= (i2 = a.b)) {
            i2 = i;
        }
        this.mCrf = i2;
        if (i >= a.f25626a && i <= a.b) {
            return 0;
        }
        Log.e("AliYunLog", "Invalid crf = " + i + ", crf must be [" + a.f25626a + ", " + a.b + "]");
        return -20003002;
    }

    public int setEncoderFps(int i) {
        if (i >= 1 && i <= 120) {
            this.mEncoderFps = i;
            return 0;
        }
        Log.e("AliYunLog", "Invalid encoderFps value " + i + ", encoderFps has must be between 0 and 120!");
        return -20003002;
    }

    public int setFps(int i) {
        if (i >= 1 && i <= 120) {
            this.fps = i;
            return 0;
        }
        Log.e("AliYunLog", "Invalid fps value " + i + ", fps has must be between 1 and 120!");
        return -20003002;
    }

    public int setGop(int i) {
        if (i >= 0 && i <= 9000) {
            this.mGop = i;
            return 0;
        }
        Log.e("AliYunLog", "Invalid gop value " + i + ", gop has must be between 0 and 9000!");
        return -20003002;
    }

    public int setVideoBitrate(int i) {
        if (i >= 200 && i <= 20000) {
            this.mBitrate = i;
            return 0;
        }
        Log.e("AliYunLog", "Invalid bitrate value " + i + ", gop has must be between 200 and 20000!");
        return -20003002;
    }

    public void setVideoCodec(VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public int setVideoHeight(int i) {
        if (i > 0) {
            this.videoHeight = i;
            return 0;
        }
        Log.e("AliYunLog", "Invalid videoHeight " + i + ", videoHeight must be grate than 0!");
        return -20003002;
    }

    public void setVideoQuality(VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }

    public int setVideoWidth(int i) {
        if (i > 0) {
            this.videoWidth = i;
            return 0;
        }
        Log.e("AliYunLog", "Invalid videoWidth " + i + ", videoWidth must be grate than 0!");
        return -20003002;
    }
}
