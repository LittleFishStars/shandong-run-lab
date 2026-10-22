package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ht implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.a.o.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.a.o.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.a.o.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.a.o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TM = jSONObject.optString("kwaiUID");
        if (JSONObject.NULL.toString().equals(aVar.TM)) {
            aVar.TM = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.a.o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.TM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiUID", aVar.TM);
        }
        return jSONObject;
    }
}
