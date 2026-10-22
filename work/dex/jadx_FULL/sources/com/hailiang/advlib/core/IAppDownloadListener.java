package com.hailiang.advlib.core;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface IAppDownloadListener {
    void onDownloadActive(long j, long j2, String str);

    void onDownloadCompleted(String str);

    void onDownloadFailed();

    void onDownloadPaused(long j, long j2, String str);

    void onIdle();

    void onInstalled(String str);
}
