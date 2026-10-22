package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.d.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aKs = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(bVar.aKs)) {
            bVar.aKs = "";
        }
        bVar.aKt = jSONObject.optString("error_data");
        if (JSONObject.NULL.toString().equals(bVar.aKt)) {
            bVar.aKt = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aKs;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_name", bVar.aKs);
        }
        String str2 = bVar.aKt;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_data", bVar.aKt);
        }
        return jSONObject;
    }
}
