package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class h extends com.kwad.sdk.core.response.a.a {
    public int aVp;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h cI(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.helper.e.eY(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.helper.e.eL(adTemplate);
        int iFc = com.kwad.sdk.core.response.helper.e.fc(adTemplate);
        hVar.score = iFc;
        hVar.aVp = iFc > 0 ? 1 : 0;
        return hVar;
    }

    public final String Nb() {
        return toJson().toString();
    }
}
