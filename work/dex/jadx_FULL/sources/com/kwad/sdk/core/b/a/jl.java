package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jl implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aXo = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(dVar.aXo)) {
            dVar.aXo = "";
        }
        dVar.aXp = jSONObject.optString("kMac");
        if (JSONObject.NULL.toString().equals(dVar.aXp)) {
            dVar.aXp = "";
        }
        dVar.aXq = jSONObject.optInt("connectionType");
        dVar.operatorType = jSONObject.optInt("operatorType");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aXo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mac", dVar.aXo);
        }
        String str2 = dVar.aXp;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kMac", dVar.aXp);
        }
        int i = dVar.aXq;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "connectionType", i);
        }
        int i2 = dVar.operatorType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "operatorType", i2);
        }
        return jSONObject;
    }
}
