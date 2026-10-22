package com.kwad.components.core.innerEc.live.config.net;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    public i Ug;
    public d Uh;
    public e Ui;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        i iVar = new i();
        this.Ug = iVar;
        ac.a(iVar, jSONObject.optString("webSocketLiveServer"));
        d dVar = new d();
        this.Uh = dVar;
        ac.a(dVar, jSONObject.optString("commonData"));
        e eVar = new e();
        this.Ui = eVar;
        ac.a(eVar, jSONObject.optString("livePlayData"));
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "webSocketLiveServer", this.Ug);
        ac.a(jSONObject, "commonData", this.Uh);
        ac.a(jSONObject, "livePlayData", this.Ui);
        return jSONObject;
    }
}
