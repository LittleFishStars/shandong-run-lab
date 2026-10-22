package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IObiwanOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getLogDirPath();

    String getLogObiwanData();

    long getLogObiwanStorageQuota();

    boolean isLogObiwanEnableNow();

    boolean isLogObiwanRecordAll();
}
