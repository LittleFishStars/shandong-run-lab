package com.alibaba.sdk.android.vod.upload;

import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodUploadResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class VODUploadCallback {
    public void onUploadFailed(UploadFileInfo uploadFileInfo, String str, String str2) {
    }

    public void onUploadProgress(UploadFileInfo uploadFileInfo, long j, long j2) {
    }

    public void onUploadRetry(String str, String str2) {
    }

    public void onUploadRetryResume() {
    }

    public void onUploadStarted(UploadFileInfo uploadFileInfo) {
    }

    @Deprecated
    public void onUploadSucceed(UploadFileInfo uploadFileInfo) {
    }

    public void onUploadSucceed(UploadFileInfo uploadFileInfo, VodUploadResult vodUploadResult) {
    }

    public void onUploadTokenExpired() {
    }
}
