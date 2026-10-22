package com.google.android.inner_exoplayer2.offline;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@WorkerThread
public interface DownloadIndex {
    @Nullable
    Download getDownload(String str);

    DownloadCursor getDownloads(int... iArr);
}
