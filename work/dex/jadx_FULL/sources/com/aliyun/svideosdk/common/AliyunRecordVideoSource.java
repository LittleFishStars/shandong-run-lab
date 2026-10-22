package com.aliyun.svideosdk.common;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunRecordVideoSource extends AliyunRecordBaseSource {
    private LayoutInfo mLayoutInfo;
    private AliyunStickerManager mStickerManager;

    @Visible
    public static class LayoutInfo {
        public float centerX;
        public float centerY;
        public int gravity;
        public float height;
        public int outputHeight;
        public int outputWidth;
        public float width;
        public int zPosition;

        public LayoutInfo(float f, float f2, float f3, float f4, int i, int i2, int i3, int i4) {
            this.width = f;
            this.height = f2;
            this.centerX = f3;
            this.centerY = f4;
            this.zPosition = i;
            this.gravity = i2;
            this.outputWidth = i3;
            this.outputHeight = i4;
        }

        public String toString() {
            return "LayoutInfo{width=" + this.width + ", height=" + this.height + ", centerX=" + this.centerX + ", centerY=" + this.centerY + ", zPosition=" + this.zPosition + ", gravity=" + this.gravity + ", outputWidth=" + this.outputWidth + ", outputHeight=" + this.outputHeight + '}';
        }
    }

    public static AliyunRecordVideoSource createVideoWithFile(String str, long j, long j2, boolean z) {
        AliyunRecordVideoSource aliyunRecordVideoSource = new AliyunRecordVideoSource();
        aliyunRecordVideoSource.setNativeHandle(aliyunRecordVideoSource.nativeCreateVideoWithFile(str, j, j2, z));
        return aliyunRecordVideoSource;
    }

    public static AliyunRecordVideoSource createVideoWithInfo(int i, int i2) {
        AliyunRecordVideoSource aliyunRecordVideoSource = new AliyunRecordVideoSource();
        aliyunRecordVideoSource.setNativeHandle(aliyunRecordVideoSource.nativeCreateVideoWithInfo(i, i2));
        return aliyunRecordVideoSource;
    }

    public LayoutInfo getLayoutInfo() {
        return this.mLayoutInfo;
    }

    public AliyunStickerManager getStickerManager() {
        if (this.mStickerManager == null) {
            long jNativeGetStickerManager = nativeGetStickerManager(getNativeHandle());
            if (jNativeGetStickerManager != 0) {
                this.mStickerManager = new AliyunStickerManager(jNativeGetStickerManager);
            }
        }
        return this.mStickerManager;
    }

    @Override // com.aliyun.svideosdk.common.AliyunRecordBaseSource
    public void release() {
        super.release();
        AliyunStickerManager aliyunStickerManager = this.mStickerManager;
        if (aliyunStickerManager != null) {
            aliyunStickerManager.releaseNativeHandle();
            this.mStickerManager = null;
        }
    }

    public void setAnimationFilterInfo(String str, String str2) {
        nativeSetAnimationFilterInfo(getNativeHandle(), str, str2);
    }

    public void setBeautyLevel(int i) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        }
        nativeSetBeautyLevel(this.mNativeHandle, i);
    }

    public void setCaptureSurface(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            nativeSetCaptureSurface(j, surfaceTexture, i, i2, i3);
        }
    }

    public void setDisplay(Surface surface) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        }
        nativeSetDisplay(this.mNativeHandle, surface);
    }

    public void setFilterInfo(String str) {
        nativeSetFilterInfo(getNativeHandle(), str);
    }

    public void setLayoutInfo(LayoutInfo layoutInfo) {
        this.mLayoutInfo = layoutInfo;
        nativeSetLayoutInfo(getNativeHandle(), layoutInfo.width, layoutInfo.height, layoutInfo.centerX, layoutInfo.centerY, layoutInfo.zPosition, layoutInfo.gravity, layoutInfo.outputWidth, layoutInfo.outputHeight);
    }

    public void setMirrorInfo(int i) {
        nativeSetMirrorInfo(getNativeHandle(), i);
    }

    public void setPureColorBorder(float f, int i, float f2) {
        if (this.mNativeHandle == 0) {
            nativeInitError();
        }
        nativeSetPureColorBorder(this.mNativeHandle, f, i, f2);
    }

    public void setVideoNeedOutput(boolean z) {
        nativeSetNeedOutput(getNativeHandle(), z, false, true);
    }

    public void setVideoNeedRender(boolean z) {
        nativeSetNeedRender(getNativeHandle(), z, false, true);
    }
}
