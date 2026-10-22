package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ig implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.g) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.kwad.components.core.innerEc.live.config.net.b bVar = new com.kwad.components.core.innerEc.live.config.net.b();
        gVar.Ur = bVar;
        bVar.parseJson(jSONObject.optJSONObject("startPlayInfoFromLive"));
        com.kwad.components.core.innerEc.live.config.net.a aVar = new com.kwad.components.core.innerEc.live.config.net.a();
        gVar.Us = aVar;
        aVar.parseJson(jSONObject.optJSONObject("startPlayInfoFromLiveExt"));
        gVar.Ut = jSONObject.optInt("liveErrorCode");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "startPlayInfoFromLive", gVar.Ur);
        com.kwad.sdk.utils.ac.a(jSONObject, "startPlayInfoFromLiveExt", gVar.Us);
        int i = gVar.Ut;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveErrorCode", i);
        }
        return jSONObject;
    }
}
