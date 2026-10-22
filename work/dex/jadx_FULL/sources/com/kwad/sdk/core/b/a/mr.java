package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mr implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.b.a.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.b.a.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(dVar.name)) {
            dVar.name = "";
        }
        dVar.bnC = jSONObject.optString("detect_info");
        if (JSONObject.NULL.toString().equals(dVar.bnC)) {
            dVar.bnC = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "name", dVar.name);
        }
        String str2 = dVar.bnC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "detect_info", dVar.bnC);
        }
        return jSONObject;
    }
}
