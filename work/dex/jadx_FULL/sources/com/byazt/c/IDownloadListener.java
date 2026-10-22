package com.byazt.c;

import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface IDownloadListener {
    void onCanceled(DownloadInfo downloadInfo);

    void onFailed(DownloadInfo downloadInfo, BaseException baseException);

    void onFirstStart(DownloadInfo downloadInfo);

    void onFirstSuccess(DownloadInfo downloadInfo);

    void onPause(DownloadInfo downloadInfo);

    void onPrepare(DownloadInfo downloadInfo);

    void onProgress(DownloadInfo downloadInfo);

    void onRetry(DownloadInfo downloadInfo, BaseException baseException);

    void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException);

    void onStart(DownloadInfo downloadInfo);

    void onSuccessed(DownloadInfo downloadInfo);
}
