package com.aliyun.svideosdk.common;

import android.graphics.Bitmap;
import android.util.Log;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunStickerManager extends AliyunObject {
    public AliyunStickerManager(long j) {
        setNativeHandle(j);
    }

    private void nativeInitError() {
        Log.w(AliyunStickerManager.class.getSimpleName(), "AliyunStickerManager native handle error");
    }

    public void addBitmapSticker(int i, Bitmap bitmap, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        } else {
            nativeAddBitmapSticker(getNativeHandle(), i, bitmap, i2, i3, i4, f, f2, f3, f4, f5);
        }
    }

    public void addGifSticker(int i, String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        } else {
            nativeAddGifSticker(getNativeHandle(), i, str, f, f2, f3, f4, f5, z, j, j2, z2);
        }
    }

    public void addSticker(int i, String str, float f, float f2, float f3, float f4, float f5) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        } else {
            nativeAddSticker(getNativeHandle(), i, str, f, f2, f3, f4, f5);
        }
    }

    public void mapScreenToOriginalPreview(float[] fArr) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            nativeMapToVideo(j, fArr);
        }
    }

    public native void nativeAddBitmapSticker(long j, int i, Bitmap bitmap, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5);

    public native void nativeAddGifSticker(long j, int i, String str, float f, float f2, float f3, float f4, float f5, boolean z, long j2, long j3, boolean z2);

    public native void nativeAddSticker(long j, int i, String str, float f, float f2, float f3, float f4, float f5);

    public native void nativeMapToVideo(long j, float[] fArr);

    public native void nativeRemoveSticker(long j, int i);

    public native void nativeSetDisplaySize(long j, long j2, int i, int i2);

    public native void nativeSetFacePoint(long j, int i, float[] fArr, int i2);

    public native void nativeUpdateStickerPosition(long j, int i, float f, float f2, float f3, float f4);

    public void removeSticker(int i) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        } else {
            nativeRemoveSticker(getNativeHandle(), i);
        }
    }

    public void setDisplaySize(long j, int i, int i2) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        } else {
            nativeSetDisplaySize(getNativeHandle(), j, i, i2);
        }
    }

    public void setFacePoint(int i, float[] fArr, int i2) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        } else {
            nativeSetFacePoint(getNativeHandle(), i, fArr, i2);
        }
    }

    public void updateStickerPosition(int i, float f, float f2, float f3, float f4) {
        nativeUpdateStickerPosition(getNativeHandle(), i, f, f2, f3, f4);
    }
}
