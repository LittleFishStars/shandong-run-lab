package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lq implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.k.t.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.k.t.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.k.t.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.k.t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Ci = jSONObject.optBoolean("needCloseNeo");
    }

    private static JSONObject b(com.kwad.components.ad.reward.k.t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Ci;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needCloseNeo", z);
        }
        return jSONObject;
    }
}
