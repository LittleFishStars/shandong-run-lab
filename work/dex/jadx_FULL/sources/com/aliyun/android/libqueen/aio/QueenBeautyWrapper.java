package com.aliyun.android.libqueen.aio;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QueenBeautyWrapper implements QueenBeautyInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private QueenBeautyInterface f25559a;

    public QueenBeautyWrapper() {
        this.f25559a = null;
        this.f25559a = a(b("com.aliyun.android.libqueen.QueenEffectorPro4AIO") ? "com.aliyun.android.libqueen.QueenEffectorPro4AIO" : "com.aliyun.android.libqueen.aiobasic.QueenEffectorBasic4AIO");
    }

    private QueenBeautyInterface a(String str) {
        try {
            return (QueenBeautyInterface) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean b(String str) {
        try {
            Class.forName(str, false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void enableDebugMode() {
        this.f25559a.enableDebugMode();
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void init(Context context) {
        init(context, 0L);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void init(Context context, long j) {
        this.f25559a.init(context, j);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void init(Context context, QueenConfig queenConfig) {
        this.f25559a.init(context, queenConfig);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessBuffer(byte[] bArr, @QueenImageFormat int i, byte[] bArr2, int i2, int i3) {
        return this.f25559a.onProcessBuffer(bArr, i, bArr2, i2, i3);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessBuffer(byte[] bArr, @QueenImageFormat int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6) {
        return this.f25559a.onProcessBuffer(bArr, i, bArr2, i2, i3, i4, i5, i6);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessTexture(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6) {
        return this.f25559a.onProcessTexture(i, z, fArr, i2, i3, i4, i5, i6);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public int onProcessTextureAndBuffer(int i, boolean z, float[] fArr, int i2, int i3, int i4, int i5, int i6, byte[] bArr, @QueenImageFormat int i7) {
        return this.f25559a.onProcessTextureAndBuffer(i, z, fArr, i2, i3, i4, i5, i6, bArr, i7);
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void release() {
        this.f25559a.release();
    }

    @Override // com.aliyun.android.libqueen.aio.QueenBeautyInterface
    public void setBeautyParams(IBeautyParamsHolder iBeautyParamsHolder) {
        this.f25559a.setBeautyParams(iBeautyParamsHolder);
    }
}
