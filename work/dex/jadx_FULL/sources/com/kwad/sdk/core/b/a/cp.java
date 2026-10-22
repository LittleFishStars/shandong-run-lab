package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cp implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.h) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.h) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.llsid = jSONObject.optLong("llsid");
        hVar.creativeId = jSONObject.optLong("creative_id");
        hVar.score = jSONObject.optInt("score");
        hVar.aVp = jSONObject.optInt("is_bidding");
        hVar.source = jSONObject.optString("source");
        if (JSONObject.NULL.toString().equals(hVar.source)) {
            hVar.source = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = hVar.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "llsid", j);
        }
        long j2 = hVar.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", j2);
        }
        int i = hVar.score;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "score", i);
        }
        int i2 = hVar.aVp;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_bidding", i2);
        }
        String str = hVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "source", hVar.source);
        }
        return jSONObject;
    }
}
