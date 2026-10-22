package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bs implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.mC = jSONObject.optLong("lastShowCardTimeStamp");
        bVar.mD = jSONObject.optInt("cardShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.mC;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastShowCardTimeStamp", j);
        }
        int i = bVar.mD;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardShowCount", i);
        }
        return jSONObject;
    }
}
