package com.kwad.components.offline.api.core.downloader;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ResourceDownloader {
    int download(List<String> list, String str, String str2, DownloadListener downloadListener, boolean z, boolean z2);

    void startImmediately(int i);
}
