package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void cancel();

    @NonNull
    R createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(R r, c cVar);

    void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener);
}
