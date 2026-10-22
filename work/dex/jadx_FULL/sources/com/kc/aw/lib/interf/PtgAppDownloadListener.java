package com.kc.aw.lib.interf;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgAppDownloadListener {
    void onDownloadActive(long j, long j2, String str);

    void onDownloadCancel();

    void onDownloadFailed(String str);

    void onDownloadFinished(String str);

    void onDownloadPaused(long j, long j2, String str);

    void onIdle();

    void onInstalled(String str);
}
