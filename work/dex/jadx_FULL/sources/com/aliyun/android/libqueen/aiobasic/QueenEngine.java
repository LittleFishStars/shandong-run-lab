package com.aliyun.android.libqueen.aiobasic;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.aliyun.android.libqueen.aio.QueenConfig;
import com.aliyun.android.libqueen.aiobasic.helper.ContextManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class QueenEngine {
    private static final String TAG = "QueenEngineAIO";
    private static boolean sLibraryLoaded = a.a();
    private static Throwable sThrowable = a.b;
    private Context mContext;
    private long mEnginePtr;
    private Texture2D mOutTexture = null;

    public QueenEngine(Context context, QueenConfig queenConfig) throws Exception {
        init(context, queenConfig);
    }

    private void checkEngineState() {
        if (!initialized()) {
            throw new IllegalStateException("queen engine is illegal state");
        }
    }

    private void init(Context context, QueenConfig queenConfig) throws Exception {
        if (!isLibraryLoaded()) {
            throw new Exception(sThrowable);
        }
        initInner(context, queenConfig);
        if (!initialized()) {
            throw new Exception("queen engine initialize failure");
        }
    }

    private void initInner(Context context, QueenConfig queenConfig) {
        if (isLibraryLoaded()) {
            this.mContext = context.getApplicationContext();
            ContextManager.setContext(context);
            if (queenConfig.cachePath == null) {
                queenConfig.cachePath = this.mContext.getCacheDir().getPath();
            }
            this.mEnginePtr = nInit(this.mContext, queenConfig);
        }
    }

    private boolean initialized() {
        return this.mEnginePtr != 0;
    }

    private static boolean isLibraryLoaded() {
        return sLibraryLoaded;
    }

    private native int nAutoGenOutTexture(long j, boolean z);

    private native void nEnableBeautyType(long j, int i, boolean z, boolean z2, int i2);

    private native void nGetOutSize(long j, int[] iArr);

    private native int nGetOutTextureId(long j);

    private native long nInit(Context context, QueenConfig queenConfig);

    private native int nProcessBufferData(long j, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native void nRelease(long j);

    private native int nRender(long j);

    private native void nResetAllGLState(long j);

    private native void nSetBeautyParams(long j, int i, float f);

    private native void nSetInputFlip(long j, int i);

    private native void nSetInputTexture(long j, int i, int i2, int i3, boolean z);

    private native void nSetScreenViewport(long j, int i, int i2, int i3, int i4);

    private native void nUpdateInputTextureId(long j, int i);

    private native void nUpdateOesTextureMatrix(long j, float[] fArr);

    private native void nUpdateOutTexture(long j, int i, int i2, int i3, boolean z);

    private native void setLogDebug(long j, boolean z);

    public Texture2D autoGenOutTexture(boolean z) {
        checkEngineState();
        int iNAutoGenOutTexture = nAutoGenOutTexture(this.mEnginePtr, z);
        if (iNAutoGenOutTexture <= 0) {
            return null;
        }
        if (this.mOutTexture == null) {
            this.mOutTexture = new Texture2D(this.mEnginePtr);
        }
        int[] iArr = new int[2];
        nGetOutSize(this.mEnginePtr, iArr);
        if (z) {
            this.mOutTexture.a(iNAutoGenOutTexture, iArr[1], iArr[0], false);
        } else {
            this.mOutTexture.a(iNAutoGenOutTexture, iArr[0], iArr[1], false);
        }
        return this.mOutTexture;
    }

    public void enableBeautyType(int i, boolean z) {
        enableBeautyType(i, z, false);
    }

    public void enableBeautyType(int i, boolean z, int i2) {
        enableBeautyType(i, z, false, i2);
    }

    public void enableBeautyType(int i, boolean z, boolean z2) {
        enableBeautyType(i, z, z2, 0);
    }

    public void enableBeautyType(int i, boolean z, boolean z2, int i2) {
        checkEngineState();
        nEnableBeautyType(this.mEnginePtr, i, z, z2, i2);
    }

    public void enableDebugLog() {
        checkEngineState();
        setLogDebug(this.mEnginePtr, true);
    }

    public int getAutoGenOutTextureId() {
        return nGetOutTextureId(this.mEnginePtr);
    }

    public int processBufferData(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        checkEngineState();
        return nProcessBufferData(this.mEnginePtr, bArr, bArr2, i, i2, i3, i4, i5, i6, i7);
    }

    public synchronized void release() {
        if (initialized()) {
            Texture2D texture2D = this.mOutTexture;
            if (texture2D != null) {
                texture2D.c();
                this.mOutTexture = null;
            }
            nRelease(this.mEnginePtr);
            this.mEnginePtr = 0L;
        }
    }

    public int render() {
        checkEngineState();
        resetAllGLState();
        return nRender(this.mEnginePtr);
    }

    public int renderTexture(float[] fArr) {
        checkEngineState();
        resetAllGLState();
        nUpdateOesTextureMatrix(this.mEnginePtr, fArr);
        return nRender(this.mEnginePtr);
    }

    public void resetAllGLState() {
        checkEngineState();
        nResetAllGLState(this.mEnginePtr);
    }

    public void setBeautyParam(int i, float f) {
        checkEngineState();
        nSetBeautyParams(this.mEnginePtr, i, f);
    }

    public void setInputTexture(int i, int i2, int i3, boolean z) {
        checkEngineState();
        Log.i("QueenEngine#", this.mEnginePtr + " setInputTexture [textureId: " + i + ", width: " + i2 + ", height: " + i3 + ", isOES: " + z + ", thread_id: " + Thread.currentThread().getId() + "]");
        nSetInputTexture(this.mEnginePtr, i, i2, i3, z);
    }

    public void setScreenViewport(int i, int i2, int i3, int i4) {
        checkEngineState();
        nSetScreenViewport(this.mEnginePtr, i, i2, i3, i4);
    }

    public void updateOutTexture(int i, int i2, int i3, boolean z) {
        checkEngineState();
        nUpdateOutTexture(this.mEnginePtr, i, i2, i3, z);
    }
}
