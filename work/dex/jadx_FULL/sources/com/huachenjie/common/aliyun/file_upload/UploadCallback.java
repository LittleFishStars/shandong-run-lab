package com.huachenjie.common.aliyun.file_upload;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface UploadCallback {
    void onFailed(int code, String message);

    default void onProgress(long currentSize, long totalSize) {
    }

    void onSuccess(String fileUrl);
}
