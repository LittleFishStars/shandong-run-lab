package com.kwad.sdk.export.proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface AdHttpResponseListener {
    boolean onReadProgress(long j, long j2);

    void onResponseEnd();

    void onResponseStart();
}
