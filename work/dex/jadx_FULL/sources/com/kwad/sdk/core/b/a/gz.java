package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.interstitial.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.interstitial.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.interstitial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kd = jSONObject.optLong("lastShowTimestamp");
        aVar.mz = jSONObject.optInt("aggregateAdShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.interstitial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.kd;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = aVar.mz;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregateAdShowCount", i);
        }
        return jSONObject;
    }
}
