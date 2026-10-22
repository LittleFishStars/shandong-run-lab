package com.bumptech.glide.integration.webp;

import androidx.annotation.Keep;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Keep
public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;

    @Keep
    private long mNativePtr;
    private int mWidth;

    static {
        System.loadLibrary("glide-webp");
    }

    @Keep
    public WebpImage(long j, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        if (j == 0) {
            throw new RuntimeException("internal error: native WebpImage is 0");
        }
        this.mWidth = i;
        this.mHeigth = i2;
        this.mFrameCount = i3;
        this.mDurationMs = i4;
        this.mFrameDurations = iArr;
        this.mLoopCount = i5;
        fixFrameDurations(iArr);
        this.mBackgroundColor = i6;
        this.mNativePtr = j;
    }

    public static WebpImage create(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArr.length);
        byteBufferAllocateDirect.put(bArr);
        byteBufferAllocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(byteBufferAllocateDirect);
    }

    private void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 11) {
                iArr[i] = 100;
            }
        }
    }

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i);

    private native int nativeGetSizeInBytes();

    public void dispose() {
        nativeDispose();
    }

    public void finalize() throws Throwable {
        nativeFinalize();
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public WebpFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public WebpFrameInfo getFrameInfo(int i) {
        WebpFrame frame = getFrame(i);
        try {
            return new WebpFrameInfo(i, frame);
        } finally {
            frame.dispose();
        }
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public int getWidth() {
        return this.mWidth;
    }
}
