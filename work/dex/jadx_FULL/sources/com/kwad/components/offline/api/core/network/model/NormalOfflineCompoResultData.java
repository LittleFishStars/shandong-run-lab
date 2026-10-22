package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.network.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class NormalOfflineCompoResultData extends BaseOfflineCompoResultData {
    public int code;
    public String data;
    public String header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.aSY;
        this.header = null;
    }
}
