package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ba implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.i.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.i.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aKI = jSONObject.optInt("ad_action_type");
        bVar.aKA = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(bVar.aKA)) {
            bVar.aKA = "";
        }
        bVar.aKB = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(bVar.aKB)) {
            bVar.aKB = "";
        }
        bVar.requestType = jSONObject.optInt("request_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.aKI;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_action_type", i2);
        }
        String str = bVar.aKA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "origin_url", bVar.aKA);
        }
        String str2 = bVar.aKB;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_url", bVar.aKB);
        }
        int i3 = bVar.requestType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_type", i3);
        }
        return jSONObject;
    }
}
