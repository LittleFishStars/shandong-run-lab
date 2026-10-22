package com.aliyun.svideosdk.thumbnail;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface FileThumbnailsCallback {
    void onError(int i);

    void onExit();

    void onPicAvailable(ByteBuffer byteBuffer, long j, int i, int i2);

    void onPicError(int i, long j, boolean z);
}
