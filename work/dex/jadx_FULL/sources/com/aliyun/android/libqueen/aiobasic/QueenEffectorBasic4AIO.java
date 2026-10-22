package com.aliyun.android.libqueen.aiobasic;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.Keep;
import com.aliyun.android.libqueen.aio.IBeautyParamsHolder;
import com.aliyun.android.libqueen.aio.QueenBeautyInterface;
import com.aliyun.android.libqueen.aio.QueenConfig;
import com.aliyun.android.libqueen.aio.QueenImageFormat;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class QueenEffectorBasic4AIO implements QueenBeautyInterface {
    private final float[] IDENTITY_MATRIX = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private IBeautyParamsHolder mIParamsHolder;
    private int mLastInputH;
    private int mLastInputTextureId;
    private int mLastInputW;
    private Texture2D mOutTexture2D;
    private QueenEngine mQueenEngine;

    private int getQueenFormat(@QueenImageFormat int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 4;
            if (i != 4) {
                return 1;
            }
        }
        return i2;
    }

    private int processTexture(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6) {
        IBeautyParamsHolder iBeautyParamsHolder = this.mIParamsHolder;
        if (iBeautyParamsHolder != null) {
            iBeautyParamsHolder.onWriteParamsToBeauty(this.mQueenEngine);
        }
        updateInputTextureIfNeed(i, i2, i3, z);
        if (fArr == null && z) {
            fArr = this.IDENTITY_MATRIX;
        }
        QueenEngine queenEngine = this.mQueenEngine;
        return (fArr != null ? queenEngine.renderTexture(fArr) : queenEngine.render()) == 0 ? this.mOutTexture2D.a() : i;
    }

    private void updateInputTextureIfNeed(int i, int i2, int i3, boolean z) {
        int i4 = z ? i3 : i2;
        if (!z) {
            i2 = i3;
        }
        if (this.mLastInputTextureId == i && this.mLastInputW == i4 && this.mLastInputH == i2) {
            return;
        }
        Texture2D texture2D = this.mOutTexture2D;
        if (texture2D != null) {
            texture2D.c();
            this.mOutTexture2D = null;
        }
        this.mQueenEngine.setInputTexture(i, i4, i2, z);
        Texture2D texture2DAutoGenOutTexture = this.mQueenEngine.autoGenOutTexture(true);
        this.mOutTexture2D = texture2DAutoGenOutTexture;
        this.mQueenEngine.updateOutTexture(texture2DAutoGenOutTexture.a(), i4, i2, true);
        this.mQueenEngine.setScreenViewport(0, 0, i4, i2);
        this.mLastInputTextureId = i;
        this.mLastInputW = i4;
        this.mLastInputH = i2;
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void enableDebugMode() {
        QueenEngine queenEngine = this.mQueenEngine;
        if (queenEngine != null) {
            queenEngine.enableDebugLog();
        }
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void init(Context context) {
        init(context, 0L);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void init(Context context, long j) {
        try {
            QueenConfig queenConfig = new QueenConfig();
            if (j > 0) {
                queenConfig.shareGlContext = j;
                queenConfig.withContext = true;
            }
            this.mQueenEngine = new QueenEngine(context, queenConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void init(Context context, QueenConfig queenConfig) {
        try {
            this.mQueenEngine = new QueenEngine(context, queenConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessBuffer(byte[] bArr, @QueenImageFormat int i, byte[] bArr2, int i2, int i3) {
        return onProcessBuffer(bArr, i, bArr2, i2, i3, 0, 0, 0);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessBuffer(byte[] bArr, @QueenImageFormat int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, IntBuffer.wrap(iArr));
        IBeautyParamsHolder iBeautyParamsHolder = this.mIParamsHolder;
        if (iBeautyParamsHolder != null) {
            iBeautyParamsHolder.onWriteParamsToBeauty(this.mQueenEngine);
        }
        int iProcessBufferData = this.mQueenEngine.processBufferData(bArr, bArr2, getQueenFormat(i), i2, i3, 0, i4, i5, i6);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        return iProcessBufferData;
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessTexture(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, IntBuffer.wrap(iArr));
        int iProcessTexture = processTexture(i, z, fArr, i2, i3, i4, i5, i6);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        return iProcessTexture;
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessTextureAndBuffer(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6, byte[] bArr, @QueenImageFormat int i7) {
        return onProcessTexture(i, z, fArr, i2, i3, i4, i5, i6);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void release() {
        QueenEngine queenEngine = this.mQueenEngine;
        if (queenEngine != null) {
            queenEngine.release();
            this.mQueenEngine = null;
        }
        Texture2D texture2D = this.mOutTexture2D;
        if (texture2D != null) {
            texture2D.c();
            this.mOutTexture2D = null;
        }
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void setBeautyParams(IBeautyParamsHolder iBeautyParamsHolder) {
        this.mIParamsHolder = iBeautyParamsHolder;
    }
}
