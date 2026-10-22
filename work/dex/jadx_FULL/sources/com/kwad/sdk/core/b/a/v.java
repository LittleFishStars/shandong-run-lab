package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class v implements com.kwad.sdk.core.d<com.kwad.components.core.m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.m.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.abi = jSONObject.optInt("currentActiveCount");
        aVar.abj = jSONObject.optLong("lastForceActiveTimestamp");
    }

    private static JSONObject b(com.kwad.components.core.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.abi;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentActiveCount", i);
        }
        long j = aVar.abj;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastForceActiveTimestamp", j);
        }
        return jSONObject;
    }
}
