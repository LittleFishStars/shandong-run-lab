package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    private final T mOfflineCompoResultData;

    public NormalResultDataAdapter(T t) {
        this.mOfflineCompoResultData = t;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(c cVar) {
        super.parseResponse(cVar);
        this.mOfflineCompoResultData.parseResponse(cVar);
    }
}
