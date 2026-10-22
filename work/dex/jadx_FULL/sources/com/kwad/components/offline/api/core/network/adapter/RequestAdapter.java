package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.sdk.core.network.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class RequestAdapter<R extends IOfflineCompoRequest> extends d {
    public abstract R getOfflineCompoRequest();
}
