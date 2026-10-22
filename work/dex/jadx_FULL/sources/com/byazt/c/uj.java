package com.byazt.c;

import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 20, 15})
public abstract class uj extends AbsDownloadListener implements my {
    private void c(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.byazt.n.c cVarN = com.byazt.n.tt.c().n(downloadInfo.getId());
        if (cVarN == null) {
            cVarN = c();
        }
        cVarN.tt(downloadInfo.getTotalBytes());
        if (i == -3) {
            cVarN.c(downloadInfo.getTotalBytes());
        } else {
            cVarN.c(downloadInfo.getCurBytes());
        }
        cVarN.c(i, baseException, z);
    }

    private void tt(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.byazt.n.c cVarN = com.byazt.n.tt.c().n(downloadInfo.getId());
        if (cVarN != null) {
            cVarN.c(downloadInfo);
        } else {
            com.byazt.n.tt.c().c(c());
        }
    }

    private void ve(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.byazt.n.c cVarN = com.byazt.n.tt.c().n(downloadInfo.getId());
            if (cVarN == null) {
                cVarN = c();
            }
            cVarN.c(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    public abstract com.byazt.n.c c();

    @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        c(-1, downloadInfo, baseException, false);
    }

    @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        c(-2, downloadInfo, null, false);
    }

    @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        tt(downloadInfo);
        c(1, downloadInfo, null, true);
    }

    @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        ve(downloadInfo);
    }

    @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        c(2, downloadInfo, null, false);
    }

    @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        c(-3, downloadInfo, null, false);
    }

    @Override // com.byazt.c.my
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        c(11, downloadInfo, null, true);
    }
}
