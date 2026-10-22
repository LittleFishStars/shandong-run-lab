package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ce implements com.kwad.sdk.core.d<com.kwad.components.ad.adbit.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.adbit.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.adbit.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.adbit.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.bG = jSONObject.optInt("common_base_request_used");
        dVar.bH = jSONObject.optLong("bid_token_get_duration");
        dVar.bI = jSONObject.optString("bid_version");
        if (JSONObject.NULL.toString().equals(dVar.bI)) {
            dVar.bI = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.adbit.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        int i2 = dVar.bG;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "common_base_request_used", i2);
        }
        long j = dVar.bH;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bid_token_get_duration", j);
        }
        String str = dVar.bI;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bid_version", dVar.bI);
        }
        return jSONObject;
    }
}
