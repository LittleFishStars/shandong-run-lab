package com.aliyun.svideosdk.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunRecordAudioSource extends AliyunRecordBaseSource {
    private AliyunRecordAudioSource() {
    }

    public static AliyunRecordAudioSource createAudioWithFile(String str, long j, long j2) {
        AliyunRecordAudioSource aliyunRecordAudioSource = new AliyunRecordAudioSource();
        aliyunRecordAudioSource.setNativeHandle(aliyunRecordAudioSource.nativeCreateAudioWithFile(str, j, j2, false));
        return aliyunRecordAudioSource;
    }

    public static AliyunRecordAudioSource createAudioWithFile(String str, boolean z) {
        AliyunRecordAudioSource aliyunRecordAudioSource = new AliyunRecordAudioSource();
        aliyunRecordAudioSource.setNativeHandle(aliyunRecordAudioSource.nativeCreateAudioWithFile(str, 0L, 0L, z));
        return aliyunRecordAudioSource;
    }

    public static AliyunRecordAudioSource createAudioWithInfo(int i, int i2) {
        AliyunRecordAudioSource aliyunRecordAudioSource = new AliyunRecordAudioSource();
        aliyunRecordAudioSource.setNativeHandle(aliyunRecordAudioSource.nativeCreateAudioWithInfo(i, i2));
        return aliyunRecordAudioSource;
    }

    public void setAECFarSource(AliyunRecordBaseSource aliyunRecordBaseSource) {
        nativeSetAECFarSource(getNativeHandle(), aliyunRecordBaseSource != null ? aliyunRecordBaseSource.getNativeHandle() : -1L);
    }

    public void setAudioNeedOutput(boolean z) {
        nativeSetNeedOutput(getNativeHandle(), z, true, false);
    }

    public void setAudioNeedRender(boolean z) {
        nativeSetNeedRender(getNativeHandle(), z, true, false);
    }

    public void setDenoiseWeight(float f) {
        nativeSetDenoiseWeight(getNativeHandle(), f);
    }

    public void setEffect(int i, float f) {
        nativeSetEffect(getNativeHandle(), i, f);
    }

    public void setFadeIn(AliyunPip.AliyunAudioFade aliyunAudioFade) {
        nativeSetFadeIn(getNativeHandle(), aliyunAudioFade.shapeType, aliyunAudioFade.duration);
    }

    public void setFadeOut(AliyunPip.AliyunAudioFade aliyunAudioFade) {
        nativeSetFadeOut(getNativeHandle(), aliyunAudioFade.shapeType, aliyunAudioFade.duration);
    }

    public void setVolume(float f) {
        nativeSetVolume(getNativeHandle(), f);
    }
}
