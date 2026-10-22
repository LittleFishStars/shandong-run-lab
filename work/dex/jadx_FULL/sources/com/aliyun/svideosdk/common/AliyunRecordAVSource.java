package com.aliyun.svideosdk.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunRecordAVSource extends AliyunRecordVideoSource {
    private AliyunRecordAVSource() {
    }

    public static AliyunRecordAVSource createAVWithFile(String str, long j, long j2) {
        AliyunRecordAVSource aliyunRecordAVSource = new AliyunRecordAVSource();
        aliyunRecordAVSource.setNativeHandle(aliyunRecordAVSource.nativeCreateAVWithFile(str, j, j2, false));
        return aliyunRecordAVSource;
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
