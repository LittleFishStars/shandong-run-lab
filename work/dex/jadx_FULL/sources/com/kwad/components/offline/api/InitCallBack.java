package com.kwad.components.offline.api;

import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface InitCallBack {
    @WorkerThread
    void onError(int i);

    @WorkerThread
    void onSuccess(boolean z);
}
