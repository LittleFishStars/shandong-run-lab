package com.aliyun.svideosdk.recorder;

import android.graphics.Bitmap;
import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.AliyunRecordBaseSource;
import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.AliyunStickerManager;
import com.aliyun.svideosdk.nativeload.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public class NativeRecorder extends a {
    private static final int DEFAULT_LAYOUT_ID = com.aliyun.svideosdk.c.a.DEFAULT_LAYER.a();
    private static final String TAG = NativeRecorder.class.getSimpleName();
    private long mNativeHandle;
    private AliyunStickerManager mStickerManager;

    @Visible
    public interface CallBack {
        void onDuration(long j);

        void onEncoderInfoBack(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9);

        void onError(int i);

        void onExit(int i, long j, long j2);
    }

    @Visible
    public interface ScreenshotCallback {
        void onScreenshot(int i, int i2, byte[] bArr, int i3);
    }

    @Visible
    public interface TextureCallback {
        int onDestroyTexture();

        int onPostTexture(int i, int i2, int i3);

        int onPreTexture(int i, int i2, int i3);
    }

    public NativeRecorder(long j) {
        this(j, false);
    }

    public NativeRecorder(long j, boolean z) {
        long jPrepare = prepare(j, z);
        this.mNativeHandle = jPrepare;
        if (jPrepare == 0) {
            nativeInitError();
        }
    }

    public static native void cancel(long j);

    public static native int clearBackground(long j);

    public static native int createTexture(long j);

    public static native int nativeAddAudioBuffer(long j, long j2, byte[] bArr, int i);

    public static native int nativeAddSource(long j, long j2);

    public static native int nativeAddVideoBuffer(long j, long j2, int i);

    public static native int nativeAddVideoBufferBitmap(long j, long j2, Bitmap bitmap);

    public static native void nativeDestroyGlobalStickerManager(long j);

    public static native long nativeGetGlobalStickerManager();

    private void nativeInitError() {
        Log.w(TAG, "NativeRecorder native handle error");
    }

    public static native int nativeRemoveSource(long j, long j2);

    public static native int nativeUpdateGlobalStickers(long j, long j2);

    public static native int nativeUpdateSource(long j, long j2);

    public static native long prepare(long j, boolean z);

    public static native void release(long j);

    public static native int seek(long j, long j2);

    public static native int setBackground(long j, long j2, Bitmap bitmap, int i);

    public static native void setCallback(long j, Object obj);

    public static native void setParam(long j, int i, int i2);

    public static native void setScreenshotCallback(long j, Object obj);

    public static native void setTextureCallback(long j, long j2, Object obj);

    public static native void setVideoSize(long j, int i, int i2);

    public static native int setVideoTempo(long j, float f);

    public static native int start(long j, String str, long j2);

    public static native int startPreview(long j);

    public static native int stitchPart(long j, String[] strArr, int i, String str);

    public static native int stop(long j);

    public static native void takePhoto(long j, long j2);

    public int addAudioBuffer(AliyunRecordBaseSource aliyunRecordBaseSource, byte[] bArr, int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeAddAudioBuffer(j, aliyunRecordBaseSource.getNativeHandle(), bArr, i);
        }
        nativeInitError();
        return -1;
    }

    public int addSource(AliyunRecordBaseSource aliyunRecordBaseSource) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeAddSource(j, aliyunRecordBaseSource.getNativeHandle());
        }
        nativeInitError();
        return -1;
    }

    public void addVideoBuffer(AliyunRecordVideoSource aliyunRecordVideoSource, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            nativeAddVideoBuffer(j, aliyunRecordVideoSource.getNativeHandle(), i);
        }
    }

    public void addVideoBufferBitmap(AliyunRecordVideoSource aliyunRecordVideoSource, Bitmap bitmap) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            nativeAddVideoBufferBitmap(j, aliyunRecordVideoSource.getNativeHandle(), bitmap);
        }
    }

    public void cancel() {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            cancel(j);
        }
    }

    public int clearBackground() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return clearBackground(j);
        }
        nativeInitError();
        return -1;
    }

    public int createTexture() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return createTexture(j);
        }
        nativeInitError();
        return -1;
    }

    public AliyunStickerManager getGlobalStickerManager() {
        if (this.mStickerManager == null) {
            this.mStickerManager = new AliyunStickerManager(nativeGetGlobalStickerManager());
        }
        return this.mStickerManager;
    }

    public void release() {
        if (this.mNativeHandle == 0) {
            nativeInitError();
            return;
        }
        releaseGlobalStickerManager();
        release(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    public void releaseGlobalStickerManager() {
        AliyunStickerManager aliyunStickerManager = this.mStickerManager;
        if (aliyunStickerManager != null) {
            nativeDestroyGlobalStickerManager(aliyunStickerManager.getNativeHandle());
            this.mStickerManager.setNativeHandle(0L);
            this.mStickerManager = null;
        }
    }

    public int removeSource(AliyunRecordBaseSource aliyunRecordBaseSource) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeRemoveSource(j, aliyunRecordBaseSource.getNativeHandle());
        }
        nativeInitError();
        return -1;
    }

    public int seek(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            return seek(j2, j);
        }
        nativeInitError();
        return -1;
    }

    public int setBackground(long j, Bitmap bitmap, int i) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            return setBackground(j2, j, bitmap, i);
        }
        nativeInitError();
        return -1;
    }

    public void setCallback(Object obj) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setCallback(j, obj);
        }
    }

    public void setParam(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setParam(j, i, i2);
        }
    }

    public void setScreenshotCallback(ScreenshotCallback screenshotCallback) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setScreenshotCallback(j, screenshotCallback);
        }
    }

    public void setTextureCallback(AliyunRecordVideoSource aliyunRecordVideoSource, TextureCallback textureCallback) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setTextureCallback(j, aliyunRecordVideoSource.getNativeHandle(), textureCallback);
        }
    }

    public void setVideoSize(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setVideoSize(j, i, i2);
        }
    }

    public int setVideoTempo(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return setVideoTempo(j, f);
        }
        nativeInitError();
        return -1;
    }

    public int start(String str) {
        return start(str, -1L);
    }

    public int start(String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            return start(j2, str, j);
        }
        nativeInitError();
        return -1;
    }

    public int startPreview() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return startPreview(j);
        }
        nativeInitError();
        return -1;
    }

    public int stitchPart(String[] strArr, int i, String str) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return stitchPart(j, strArr, i, str);
        }
        nativeInitError();
        return -1;
    }

    public int stop() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return stop(j);
        }
        nativeInitError();
        return -1;
    }

    public void takePhoto(AliyunRecordVideoSource aliyunRecordVideoSource) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            takePhoto(j, aliyunRecordVideoSource.getNativeHandle());
        }
    }

    public void updateGlobalStickers() {
        AliyunStickerManager aliyunStickerManager = this.mStickerManager;
        if (aliyunStickerManager != null) {
            nativeUpdateGlobalStickers(this.mNativeHandle, aliyunStickerManager.getNativeHandle());
        }
    }

    public int updateSource(AliyunRecordBaseSource aliyunRecordBaseSource) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeUpdateSource(j, aliyunRecordBaseSource.getNativeHandle());
        }
        nativeInitError();
        return -1;
    }
}
