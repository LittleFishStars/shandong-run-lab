package com.aliyun.svideosdk.facearengine;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class FaceAREngine {
    private long mNativeHandle = 0;

    private native Object nativeGetOrganLocation(long j);

    private native long nativeInitialize(byte[] bArr, int i, int i2, int i3);

    private native void nativeRelease(long j);

    private native int nativeRenderImageData(long j, byte[] bArr, int i, int i2, int i3);

    private native int nativeRenderVideoData(long j, byte[] bArr, int i, int i2, int i3);

    private native void nativeSetMaxFaceCount(long j, int i);

    private native int nativeSetRenderMode(long j, int i);

    private native void nativeSetRenderRotationAndSize(long j, int i, int i2, int i3);

    private native void nativeSwitchFaceDetect(long j, boolean z);

    public FaceAROrganLocation getFaceOrganLocation() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return (FaceAROrganLocation) nativeGetOrganLocation(j);
        }
        Log.e("AliYunLog", "FaceAREngine not initialized");
        return null;
    }

    public int init(byte[] bArr, int i, int i2, int i3) {
        if (this.mNativeHandle != 0) {
            Log.e("AliYunLog", "FaceAREngine has been initialized");
            return -4;
        }
        long jNativeInitialize = nativeInitialize(bArr, i, i2, i3);
        this.mNativeHandle = jNativeInitialize;
        if (jNativeInitialize != 0) {
            return 0;
        }
        Log.e("AliYunLog", "FaceAREngine has been initialized");
        return -4;
    }

    public void release() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeRelease(j);
        } else {
            Log.e("AliYunLog", "FaceAREngine not initialized");
        }
    }

    public int renderImageData(byte[] bArr, int i, int i2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeRenderImageData(j, bArr, bArr.length, i, i2);
        }
        Log.e("AliYunLog", "FaceAREngine not initialized");
        return 1073754196;
    }

    public int renderVideoData(byte[] bArr, int i, int i2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeRenderVideoData(j, bArr, bArr.length, i, i2);
        }
        Log.e("AliYunLog", "FaceAREngine not initialized");
        return 1073754196;
    }

    public void setBuffingIntensity(int i) {
    }

    public void setEnLargeEyeIntensity(float f) {
    }

    public void setFaceReddenABGR(int i) {
    }

    public void setFaceReddenIntensity(int i) {
    }

    public void setFaceWhitenIntensity(int i) {
    }

    public void setMaxFaceCount(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetMaxFaceCount(j, i);
        } else {
            Log.e("AliYunLog", "FaceAREngine not initialized");
        }
    }

    public void setPullJawIntensity(float f) {
    }

    public int setRenderMode(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeSetRenderMode(j, i);
        }
        Log.e("AliYunLog", "FaceAREngine not initialized");
        return 1073754196;
    }

    public void setRenderRotationAndSize(int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetRenderRotationAndSize(j, i, i2, i3);
        } else {
            Log.e("AliYunLog", "FaceAREngine not initialized");
        }
    }

    public void setSlimIntensity(float f) {
    }

    public void switchFaceDetect(boolean z) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSwitchFaceDetect(j, z);
        } else {
            Log.e("AliYunLog", "FaceAREngine not initialized");
        }
    }
}
