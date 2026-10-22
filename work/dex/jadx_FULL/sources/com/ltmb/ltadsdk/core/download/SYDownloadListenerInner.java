package com.ltmb.ltadsdk.core.download;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH&¨\u0006\u0014"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadListenerInner;", "", "Lcom/ltmb/ltadsdk/core/download/SYDownloadTask;", "task", "", "onDownloadStart", "onDownloadPaused", "onDownloadCompleted", "", "errorCode", "", "errorMsg", "onDownloadFailed", "", "totalBytes", "downloadedBytes", "onDownloadUpdate", "requestId", "onInstallStart", "onInstalled", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYDownloadListenerInner {
    void onDownloadCompleted(@NotNull SYDownloadTask task);

    void onDownloadFailed(@NotNull SYDownloadTask task, int errorCode, @Nullable String errorMsg);

    void onDownloadPaused(@NotNull SYDownloadTask task);

    void onDownloadStart(@NotNull SYDownloadTask task);

    void onDownloadUpdate(@NotNull SYDownloadTask task, long totalBytes, long downloadedBytes);

    void onInstallStart(@NotNull String requestId);

    void onInstalled(@NotNull String requestId);
}
