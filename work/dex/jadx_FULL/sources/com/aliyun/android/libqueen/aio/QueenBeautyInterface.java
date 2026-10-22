package com.aliyun.android.libqueen.aio;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public interface QueenBeautyInterface {
    void enableDebugMode();

    void init(Context context);

    void init(Context context, long j);

    void init(Context context, QueenConfig queenConfig);

    int onProcessBuffer(byte[] bArr, @QueenImageFormat int i, byte[] bArr2, int i2, int i3);

    int onProcessBuffer(byte[] bArr, @QueenImageFormat int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6);

    int onProcessTexture(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6);

    int onProcessTextureAndBuffer(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6, byte[] bArr, @QueenImageFormat int i7);

    void release();

    void setBeautyParams(IBeautyParamsHolder iBeautyParamsHolder);
}
