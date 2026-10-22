package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener;
import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.sdk.components.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d implements IOfflineApkLoader {
    j ayr;

    public d(j jVar) {
        this.ayr = jVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void addLoadStatusListener(final IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener) {
        this.ayr.a(new com.kwad.sdk.components.i() { // from class: com.kwad.components.offline.e.a.d.1
            @Override // com.kwad.sdk.components.i
            public final void onDownloadFailed() {
                iOfflineApkLoadStatusListener.onDownloadFailed();
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadFinished() {
                iOfflineApkLoadStatusListener.onDownloadFinished();
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadStarted() {
                iOfflineApkLoadStatusListener.onDownloadStarted();
            }

            @Override // com.kwad.sdk.components.i
            public final void onIdle() {
                iOfflineApkLoadStatusListener.onIdle();
            }

            @Override // com.kwad.sdk.components.i
            public final void onInstalled() {
                iOfflineApkLoadStatusListener.onInstalled();
            }

            @Override // com.kwad.sdk.components.i
            public final void onPaused(int i, long j, long j2) {
                iOfflineApkLoadStatusListener.onPaused(i, j, j2);
            }

            @Override // com.kwad.sdk.components.i
            public final void onProgressUpdate(int i, long j, long j2) {
                iOfflineApkLoadStatusListener.onProgressUpdate(i, j, j2);
            }
        });
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void cancelDownload() {
        this.ayr.cancelDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void clearFileCache() {
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void installApp() {
        this.ayr.installApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void openApp() {
        this.ayr.openApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void pauseDownload() {
        this.ayr.pauseDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void resumeDownload() {
        this.ayr.resumeDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void setCustomReportParam(String str) {
        this.ayr.setCustomReportParam(str);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void startDownload() {
        this.ayr.startDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void stopDownload() {
        this.ayr.stopDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void uninstallApp() {
    }
}
