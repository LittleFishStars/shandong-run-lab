package com.alibaba.sdk.android.vod.upload;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface VODSVideoUploadCallback {
    void onSTSTokenExpried();

    void onUploadFailed(String str, String str2);

    void onUploadProgress(long j, long j2);

    void onUploadRetry(String str, String str2);

    void onUploadRetryResume();

    void onUploadSucceed(String str, String str2);
}
