package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class og implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.aos = jSONObject.optString("vse_msg");
        if (JSONObject.NULL.toString().equals(eVar.aos)) {
            eVar.aos = "";
        }
        eVar.aot = jSONObject.optString("vse_simple_msg");
        if (JSONObject.NULL.toString().equals(eVar.aot)) {
            eVar.aot = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = eVar.aos;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "vse_msg", eVar.aos);
        }
        String str2 = eVar.aot;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "vse_simple_msg", eVar.aot);
        }
        return jSONObject;
    }
}
