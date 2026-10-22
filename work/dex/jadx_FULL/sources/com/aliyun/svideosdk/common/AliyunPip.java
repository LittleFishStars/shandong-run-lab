package com.aliyun.svideosdk.common;

import android.graphics.PointF;
import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AudioEffectType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunPip extends AliyunObject {
    private AliyunAugmentation mAliyunAugmentation;
    private AliyunLayoutParams mLayoutParams;

    @Visible
    public static class AliyunAudioEffect {
        public float mEffectParam;
        public AudioEffectType mEffectType;

        public AliyunAudioEffect(int i, float f) {
            this.mEffectType = AudioEffectType.values()[i];
            this.mEffectParam = f;
        }
    }

    @Visible
    public static class AliyunAudioFade {
        public long duration;
        public boolean isFadeIn;
        public int shapeType;

        public AliyunAudioFade(int i, long j, boolean z) {
            this.duration = j;
            this.shapeType = i;
            this.isFadeIn = z;
        }
    }

    public AliyunPip() {
        this.mNativeHandle = nativeCreate();
        AliyunLayoutParams aliyunLayoutParams = new AliyunLayoutParams();
        this.mLayoutParams = aliyunLayoutParams;
        aliyunLayoutParams.setNativeHandle(nativeGetLayoutParams(this.mNativeHandle));
        AliyunAugmentation aliyunAugmentation = new AliyunAugmentation();
        this.mAliyunAugmentation = aliyunAugmentation;
        aliyunAugmentation.setNativeHandle(nativeGetAugmentation(this.mNativeHandle));
    }

    private native long nativeCreate();

    private native void nativeDestroy(long j);

    private native float nativeGetAudioDenoiseWeight(long j);

    private native AliyunAudioEffect nativeGetAudioEffect(long j);

    private native AliyunAudioFade nativeGetAudioFadeIn(long j);

    private native AliyunAudioFade nativeGetAudioFadeOut(long j);

    private native float nativeGetAudioVolume(long j);

    private native long nativeGetAugmentation(long j);

    private native int nativeGetBoarderColor(long j);

    private native float nativeGetBoarderRadius(long j);

    private native float nativeGetBoarderWidth(long j);

    private native long nativeGetDuration(long j);

    private native long nativeGetEndTime(long j);

    private native boolean nativeGetHorizontalFlip(long j);

    private native long nativeGetLayoutParams(long j);

    private native String nativeGetPath(long j);

    private native long nativeGetStartTime(long j);

    private native int nativeGetStreamId(long j);

    private native long nativeGetTimelineEndTime(long j);

    private native long nativeGetTimelineStartTime(long j);

    private native int nativeGetVideoHeight(long j);

    private native int nativeGetVideoWidth(long j);

    private native void nativeSetAudioDenoiseWeight(long j, float f);

    private native void nativeSetAudioEffect(long j, int i, float f);

    private native void nativeSetAudioFadeIn(long j, int i, long j2);

    private native void nativeSetAudioFadeOut(long j, int i, long j2);

    private native void nativeSetAudioVolume(long j, float f);

    private native void nativeSetBoarderColor(long j, int i);

    private native void nativeSetBoarderRadius(long j, float f);

    private native void nativeSetBoarderWidth(long j, float f);

    private native void nativeSetDuration(long j, long j2);

    private native void nativeSetEndTime(long j, long j2);

    private native void nativeSetHorizontalFlip(long j, boolean z);

    private native void nativeSetPath(long j, String str);

    private native void nativeSetStartTime(long j, long j2);

    private native void nativeSetTimelineEndTime(long j, long j2);

    private native void nativeSetTimelineStartTime(long j, long j2);

    private native void nativeSetVideoHeight(long j, int i);

    private native void nativeSetVideoWidth(long j, int i);

    public void addEffect(AliyunAudioEffect aliyunAudioEffect) {
        nativeSetAudioEffect(this.mNativeHandle, aliyunAudioEffect.mEffectType.ordinal(), aliyunAudioEffect.mEffectParam);
    }

    public float getAlpha() {
        return this.mLayoutParams.getAlpha();
    }

    public AliyunAudioEffect getAudioEffect() {
        return nativeGetAudioEffect(this.mNativeHandle);
    }

    public AliyunAudioFade getAudioFadeIn() {
        return nativeGetAudioFadeIn(this.mNativeHandle);
    }

    public AliyunAudioFade getAudioFadeOut() {
        return nativeGetAudioFadeOut(this.mNativeHandle);
    }

    public int getBoarderColor() {
        return nativeGetBoarderColor(this.mNativeHandle);
    }

    public float getBoarderWidth() {
        return nativeGetBoarderWidth(this.mNativeHandle);
    }

    public float getBrightness() {
        return this.mAliyunAugmentation.getBrightness();
    }

    public float getContrast() {
        return this.mAliyunAugmentation.getContrast();
    }

    public float getCornerRadius() {
        return nativeGetBoarderRadius(this.mNativeHandle);
    }

    public int getDenoiseWeight() {
        return (int) (nativeGetAudioDenoiseWeight(this.mNativeHandle) * 100.0f);
    }

    public long getDuration() {
        return nativeGetDuration(this.mNativeHandle);
    }

    public long getEndTime() {
        return getStartTime() + getDuration();
    }

    public String getFilePath() {
        return nativeGetPath(this.mNativeHandle);
    }

    public int getHeight() {
        return nativeGetVideoHeight(this.mNativeHandle);
    }

    public boolean getHorizontalFlip() {
        return nativeGetHorizontalFlip(this.mNativeHandle);
    }

    public int getLayerIndex() {
        return this.mLayoutParams.getLayerIndex();
    }

    public AliyunLayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    public PointF getPosition() {
        return this.mLayoutParams.getPosition();
    }

    public float getRotationRadian() {
        return this.mLayoutParams.getRotationRadian();
    }

    public float getSaturation() {
        return this.mAliyunAugmentation.getSaturation();
    }

    public float getScale() {
        return this.mLayoutParams.getScale();
    }

    public float getSharpness() {
        return this.mAliyunAugmentation.getSharpness();
    }

    public long getStartTime() {
        return nativeGetStartTime(this.mNativeHandle);
    }

    public int getStreamId() {
        return nativeGetStreamId(this.mNativeHandle);
    }

    public long getTimelineEndTime() {
        return nativeGetTimelineEndTime(this.mNativeHandle);
    }

    public long getTimelineStartTime() {
        return nativeGetTimelineStartTime(this.mNativeHandle);
    }

    public float getVignette() {
        return this.mAliyunAugmentation.getVignette();
    }

    public int getVolume() {
        return (int) (nativeGetAudioVolume(this.mNativeHandle) * 100.0f);
    }

    public int getWidth() {
        return nativeGetVideoWidth(this.mNativeHandle);
    }

    public void release() {
        nativeDestroy(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    public void setAlpha(float f) {
        this.mLayoutParams.setAlpha(f);
    }

    public void setAudioFadeIn(AliyunAudioFade aliyunAudioFade) {
        nativeSetAudioFadeIn(this.mNativeHandle, aliyunAudioFade.shapeType, aliyunAudioFade.duration);
    }

    public void setAudioFadeOut(AliyunAudioFade aliyunAudioFade) {
        nativeSetAudioFadeOut(this.mNativeHandle, aliyunAudioFade.shapeType, aliyunAudioFade.duration);
    }

    public void setBoarderColor(int i) {
        nativeSetBoarderColor(this.mNativeHandle, i);
    }

    public void setBoarderWidth(float f) {
        nativeSetBoarderWidth(this.mNativeHandle, f);
    }

    public void setBrightness(float f) {
        this.mAliyunAugmentation.setBrightness(f);
    }

    public void setContrast(float f) {
        this.mAliyunAugmentation.setContrast(f);
    }

    public void setCornerRadius(float f) {
        nativeSetBoarderRadius(this.mNativeHandle, f);
    }

    public void setDenoiseWeight(int i) {
        nativeSetAudioDenoiseWeight(this.mNativeHandle, i / 100.0f);
    }

    public void setDuration(long j) {
        nativeSetDuration(this.mNativeHandle, j);
    }

    public void setEndTime(long j) {
        nativeSetEndTime(this.mNativeHandle, j);
    }

    public void setFilePath(String str) {
        nativeSetPath(this.mNativeHandle, str);
    }

    public void setHeight(int i) {
        nativeSetVideoHeight(this.mNativeHandle, i);
    }

    public void setHorizontalFlip(boolean z) {
        nativeSetHorizontalFlip(this.mNativeHandle, z);
    }

    public void setLayerIndex(int i) {
        this.mLayoutParams.setLayerIndex(i);
    }

    public void setPosition(PointF pointF) {
        this.mLayoutParams.setPosition(pointF);
    }

    public void setRotationRadian(float f) {
        this.mLayoutParams.setRotationRadian(f);
    }

    public void setSaturation(float f) {
        this.mAliyunAugmentation.setSaturation(f);
    }

    public void setScale(float f) {
        this.mLayoutParams.setScale(f);
    }

    public void setSharpness(float f) {
        this.mAliyunAugmentation.setSharpness(f);
    }

    public void setStartTime(long j) {
        nativeSetStartTime(this.mNativeHandle, j);
    }

    public void setTimelineEndTime(long j) {
        nativeSetTimelineEndTime(this.mNativeHandle, j);
    }

    public void setTimelineStartTime(long j) {
        nativeSetTimelineStartTime(this.mNativeHandle, j);
    }

    public void setVignette(float f) {
        this.mAliyunAugmentation.setVignette(f);
    }

    public void setVolume(int i) {
        nativeSetAudioVolume(this.mNativeHandle, i / 100.0f);
    }

    public void setWidth(int i) {
        nativeSetVideoWidth(this.mNativeHandle, i);
    }
}
