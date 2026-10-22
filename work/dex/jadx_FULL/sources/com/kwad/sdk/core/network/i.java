package com.kwad.sdk.core.network;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class i extends com.kwad.sdk.commercial.c.a {
    public String aTv;
    public int aTw = 0;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return toJson().toString();
    }
}
