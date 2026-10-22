package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ak implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aLV = jSONObject.optBoolean("retrySwitch");
        cVar.aLW = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.aLX = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.aLY = jSONObject.optInt("retryQueueSize", new Integer("10").intValue());
        cVar.aLZ = jSONObject.optBoolean("retryCountFeeOnly");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = cVar.aLV;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retrySwitch", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "retryCountConfig", cVar.aLW);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cacheExpireTime", cVar.aLX);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "retryQueueSize", cVar.aLY);
        boolean z2 = cVar.aLZ;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retryCountFeeOnly", z2);
        }
        return jSONObject;
    }
}
