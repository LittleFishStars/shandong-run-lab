package com.kwad.components.core.webview.tachikoma.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdMatrixInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class i extends com.kwad.sdk.core.response.a.a {
    public int aun;
    public String auo;
    public int convertType;
    public AdMatrixInfo.AdInteractionInfo interactionInfo;

    public i() {
    }

    public i(int i, String str) {
        this.convertType = i;
        this.auo = str;
    }
}
