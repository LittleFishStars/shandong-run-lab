package com.aliyun.svideosdk.common;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunRecordBaseSource extends AliyunObject {
    public native long nativeCreateAVWithFile(String str, long j, long j2, boolean z);

    public native long nativeCreateAudioWithFile(String str, long j, long j2, boolean z);

    public native long nativeCreateAudioWithInfo(int i, int i2);

    public native long nativeCreateVideoWithFile(String str, long j, long j2, boolean z);

    public native long nativeCreateVideoWithInfo(int i, int i2);

    public native void nativeDestroy(long j);

    public native long nativeGetStickerManager(long j);

    public void nativeInitError() {
        Log.w(AliyunRecordBaseSource.class.getSimpleName(), "AliyunRecordBaseSource native handle error");
    }

    public native void nativeSetAECFarSource(long j, long j2);

    public native void nativeSetAnimationFilterInfo(long j, String str, String str2);

    public native void nativeSetBeautyLevel(long j, int i);

    public native void nativeSetCaptureSurface(long j, SurfaceTexture surfaceTexture, int i, int i2, int i3);

    public native void nativeSetDenoiseWeight(long j, float f);

    public native void nativeSetDisplay(long j, Surface surface);

    public native void nativeSetEffect(long j, int i, float f);

    public native void nativeSetFadeIn(long j, int i, long j2);

    public native void nativeSetFadeOut(long j, int i, long j2);

    public native void nativeSetFilterInfo(long j, String str);

    public native void nativeSetIsFixedTempo(long j, boolean z, boolean z2, boolean z3);

    public native void nativeSetLayoutInfo(long j, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4);

    public native void nativeSetMirrorInfo(long j, int i);

    public native void nativeSetNeedOutput(long j, boolean z, boolean z2, boolean z3);

    public native void nativeSetNeedRender(long j, boolean z, boolean z2, boolean z3);

    public native void nativeSetPureColorBorder(long j, float f, int i, float f2);

    public native void nativeSetVolume(long j, float f);

    public void release() {
        nativeDestroy(getNativeHandle());
        releaseNativeHandle();
    }

    public void setFixedTempo(boolean z, boolean z2, boolean z3) {
        nativeSetIsFixedTempo(getNativeHandle(), z, z2, z3);
    }
}
