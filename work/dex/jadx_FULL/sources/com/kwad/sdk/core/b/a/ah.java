package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aKI = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.aLP = jSONObject.optInt("retry_error_code");
        bVar.aLQ = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.aLQ)) {
            bVar.aLQ = "";
        }
        bVar.aMa = jSONObject.optInt("cache_total_num");
        bVar.aMb = jSONObject.optInt("cache_num");
        bVar.aMc = jSONObject.optLong("cacheTimeMs");
        bVar.aLZ = jSONObject.optBoolean("retry_only");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
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
        int i3 = bVar.retryCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_count", i3);
        }
        int i4 = bVar.aLP;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_error_code", i4);
        }
        String str = bVar.aLQ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_error_msg", bVar.aLQ);
        }
        int i5 = bVar.aMa;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cache_total_num", i5);
        }
        int i6 = bVar.aMb;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cache_num", i6);
        }
        long j = bVar.aMc;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cacheTimeMs", j);
        }
        boolean z = bVar.aLZ;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retry_only", z);
        }
        return jSONObject;
    }
}
