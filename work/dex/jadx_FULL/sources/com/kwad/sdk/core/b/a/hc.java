package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hc implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.interstitial.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.interstitial.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.kd = jSONObject.optLong("lastShowTimestamp");
        bVar.mA = jSONObject.optInt("currentDailyAdShowCount");
        bVar.mB = jSONObject.optInt("currentDailyRetainShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.kd;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = bVar.mA;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentDailyAdShowCount", i);
        }
        int i2 = bVar.mB;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentDailyRetainShowCount", i2);
        }
        return jSONObject;
    }
}
