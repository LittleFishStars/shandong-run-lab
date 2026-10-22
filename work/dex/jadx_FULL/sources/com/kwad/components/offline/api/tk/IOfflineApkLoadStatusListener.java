package com.kwad.components.offline.api.tk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineApkLoadStatusListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i, long j, long j2);

    void onProgressUpdate(int i, long j, long j2);
}
