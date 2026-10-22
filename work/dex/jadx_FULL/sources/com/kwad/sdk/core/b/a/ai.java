package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ai implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.aKB = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.aKB)) {
            dVar.aKB = "";
        }
        dVar.aKI = jSONObject.optInt("ad_action_type");
        dVar.aMd = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        String str = dVar.aKB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_url", dVar.aKB);
        }
        int i2 = dVar.aKI;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_action_type", i2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cache_type", dVar.aMd);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
