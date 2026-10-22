package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineCompoRequestListener<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    @WorkerThread
    void onError(@NonNull R r, int i, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r);

    @WorkerThread
    void onSuccess(@NonNull R r, @NonNull T t);
}
