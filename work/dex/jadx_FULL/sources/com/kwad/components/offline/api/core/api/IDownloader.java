package com.kwad.components.offline.api.core.api;

import androidx.annotation.WorkerThread;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IDownloader {
    @WorkerThread
    boolean downloadSync(File file, String str);
}
