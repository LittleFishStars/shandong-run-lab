package com.alibaba.ariver.resource.api;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PackageDownloadCallback {
    void onCancel(String str);

    void onFailed(String str, int i, String str2);

    void onFinish(@Nullable String str);

    void onPrepare(String str);

    void onProgress(String str, int i);
}
