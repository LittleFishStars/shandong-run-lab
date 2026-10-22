package com.aliyun.svideosdk.common;

import android.graphics.Bitmap;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunIThumbnailFetcher {

    @Visible
    public enum CropMode {
        Mediate(1),
        TOP(2),
        LEFT(4),
        RIGHT(8),
        BOTTOM(16);

        int value;

        CropMode(int i) {
            this.value = i;
        }
    }

    @Visible
    public interface OnThumbnailCompletion {
        void onError(int i);

        void onThumbnailReady(Bitmap bitmap, long j, int i);
    }

    int addImageSource(String str, long j, long j2);

    int addVideoSource(String str);

    int addVideoSource(String str, long j, long j2, long j3);

    int fromConfigJson(String str);

    long getTotalDuration();

    void release();

    int requestThumbnailImage(int i, OnThumbnailCompletion onThumbnailCompletion);

    int requestThumbnailImage(long[] jArr, OnThumbnailCompletion onThumbnailCompletion);

    int setFastMode(boolean z);

    int setParameters(int i, int i2, CropMode cropMode, VideoDisplayMode videoDisplayMode, int i3);
}
