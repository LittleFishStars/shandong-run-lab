package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@WorkerThread
public interface DownloadIndex {
    DownloadCursor b(int... iArr) throws IOException;

    @Nullable
    Download c(String str) throws IOException;
}
