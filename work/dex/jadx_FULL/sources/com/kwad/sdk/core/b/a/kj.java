package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class kj implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aXF = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aXG = jSONObject.optBoolean("enablePreload");
        aVar.aXH = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aXI = jSONObject.optInt("adLoadStrategy");
        aVar.aXJ = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.posId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "posId", j);
        }
        int i = aVar.aXF;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adPhotoCountForMedia", i);
        }
        boolean z = aVar.aXG;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enablePreload", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "increaseAdLoadTime", aVar.aXH);
        int i2 = aVar.aXI;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adLoadStrategy", i2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aXJ);
        return jSONObject;
    }
}
