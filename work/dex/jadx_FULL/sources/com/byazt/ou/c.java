package com.byazt.ou;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.e.DownloadShortInfo;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 883, 20})
public class c implements DownloadStatusChangeListener {
    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onIdle() {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
    }
}
