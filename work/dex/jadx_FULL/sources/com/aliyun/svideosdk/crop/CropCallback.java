package com.aliyun.svideosdk.crop;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface CropCallback {
    void onCancelComplete();

    void onComplete(long j);

    void onError(int i);

    void onProgress(int i);
}
