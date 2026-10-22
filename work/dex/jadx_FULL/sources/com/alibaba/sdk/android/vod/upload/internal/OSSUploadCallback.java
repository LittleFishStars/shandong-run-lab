package com.alibaba.sdk.android.vod.upload.internal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface OSSUploadCallback {
    void onUploadFailed(String str, String str2);

    void onUploadProgress(long j, long j2);

    void onUploadSucceed();

    void onUploadTokenExpired();
}
