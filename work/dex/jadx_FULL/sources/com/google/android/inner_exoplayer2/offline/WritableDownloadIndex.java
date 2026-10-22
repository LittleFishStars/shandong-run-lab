package com.google.android.inner_exoplayer2.offline;

import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@WorkerThread
public interface WritableDownloadIndex extends DownloadIndex {
    void putDownload(Download download);

    void removeDownload(String str);

    void setDownloadingStatesToQueued();

    void setStatesToRemoving();

    void setStopReason(int i);

    void setStopReason(String str, int i);
}
