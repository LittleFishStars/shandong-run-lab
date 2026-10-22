package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface g<R extends f, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r, int i, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r);

    @WorkerThread
    void onSuccess(@NonNull R r, @NonNull T t);
}
