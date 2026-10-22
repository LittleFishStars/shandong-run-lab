package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hp implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.kwad.components.core.innerEc.live.config.net.i iVar = new com.kwad.components.core.innerEc.live.config.net.i();
        bVar.Ug = iVar;
        iVar.parseJson(jSONObject.optJSONObject("webSocketLiveServer"));
        com.kwad.components.core.innerEc.live.config.net.d dVar = new com.kwad.components.core.innerEc.live.config.net.d();
        bVar.Uh = dVar;
        dVar.parseJson(jSONObject.optJSONObject("commonData"));
        com.kwad.components.core.innerEc.live.config.net.e eVar = new com.kwad.components.core.innerEc.live.config.net.e();
        bVar.Ui = eVar;
        eVar.parseJson(jSONObject.optJSONObject("livePlayData"));
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "webSocketLiveServer", bVar.Ug);
        com.kwad.sdk.utils.ac.a(jSONObject, "commonData", bVar.Uh);
        com.kwad.sdk.utils.ac.a(jSONObject, "livePlayData", bVar.Ui);
        return jSONObject;
    }
}
