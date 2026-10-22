package com.kwad.components.core.webview.tachikoma.c;

import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l extends com.kwad.sdk.core.response.a.a {
    public int aup;
    public int auq = -1;
    public int aur;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "insertScreenAdShowStrategy", this.aup);
        ac.putValue(jSONObject, "isAutoShow", this.aur);
        int i = this.auq;
        if (i != -1) {
            ac.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
