package com.aliyun.svideosdk.crop;

import android.graphics.Rect;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.MediaType;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class CropParam {
    private Rect cropRect;
    private long endTime;
    private String mInputPath;
    private int mVideoBitrate;
    private int outputHeight;
    private String outputPath;
    private int outputWidth;
    private long startTime;
    private int frameRate = 25;
    private int gop = 5;
    private VideoQuality quality = VideoQuality.HD;
    private VideoDisplayMode mScaleMode = VideoDisplayMode.FILL;
    private MediaType mMediaType = MediaType.ANY_VIDEO_TYPE;
    private int mFillColor = -16777216;
    private boolean isUseGPU = false;
    private VideoCodecs mVideoCodec = VideoCodecs.H264_HARDWARE;
    private int mCrf = 23;

    public int getCrf() {
        return this.mCrf;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.endTime, TimeUnit.MICROSECONDS);
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getGop() {
        return this.gop;
    }

    public String getInputPath() {
        return this.mInputPath;
    }

    public MediaType getMediaType() {
        return this.mMediaType;
    }

    public int getOutputHeight() {
        return this.outputHeight;
    }

    public String getOutputPath() {
        return this.outputPath;
    }

    public int getOutputWidth() {
        return this.outputWidth;
    }

    public VideoQuality getQuality() {
        VideoQuality videoQuality = this.quality;
        return videoQuality == null ? VideoQuality.HD : videoQuality;
    }

    public VideoDisplayMode getScaleMode() {
        VideoDisplayMode videoDisplayMode = this.mScaleMode;
        return videoDisplayMode == null ? VideoDisplayMode.FILL : videoDisplayMode;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MICROSECONDS);
    }

    public VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public String getVideoPath() {
        return this.mInputPath;
    }

    public int getvideobitrate() {
        return this.mVideoBitrate;
    }

    @Deprecated
    public boolean isUseGPU() {
        return this.isUseGPU;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setCropRect(Rect rect) {
        this.cropRect = rect;
    }

    public void setEndTime(long j) {
        setEndTime(j, TimeUnit.MICROSECONDS);
    }

    public void setEndTime(long j, TimeUnit timeUnit) {
        this.endTime = timeUnit.toMicros(j);
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
    }

    public void setFrameRate(int i) {
        this.frameRate = i;
    }

    public void setGop(int i) {
        this.gop = i;
    }

    public void setInputPath(String str) {
        this.mInputPath = str;
    }

    public void setMediaType(MediaType mediaType) {
        this.mMediaType = mediaType;
    }

    public void setOutputHeight(int i) {
        this.outputHeight = i;
    }

    public void setOutputPath(String str) {
        this.outputPath = str;
    }

    public void setOutputWidth(int i) {
        this.outputWidth = i;
    }

    public void setQuality(VideoQuality videoQuality) {
        this.quality = videoQuality;
    }

    public void setScaleMode(VideoDisplayMode videoDisplayMode) {
        this.mScaleMode = videoDisplayMode;
    }

    public void setStartTime(long j) {
        setStartTime(j, TimeUnit.MICROSECONDS);
    }

    public void setStartTime(long j, TimeUnit timeUnit) {
        this.startTime = timeUnit.toMicros(j);
    }

    @Deprecated
    public void setUseGPU(boolean z) {
        this.isUseGPU = z;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setVideoCodec(VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public void setVideoPath(String str) {
        this.mInputPath = str;
    }
}
