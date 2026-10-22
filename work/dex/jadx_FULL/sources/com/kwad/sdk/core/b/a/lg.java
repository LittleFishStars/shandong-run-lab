package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lg implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.base.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.base.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.base.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.base.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.Tv = jSONObject.optString("accumulatedWatchCount");
        if (JSONObject.NULL.toString().equals(cVar.Tv)) {
            cVar.Tv = "";
        }
        cVar.Tw = jSONObject.optString("liteAccumulatedWatchCount");
        if (JSONObject.NULL.toString().equals(cVar.Tw)) {
            cVar.Tw = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.base.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.Tv;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "accumulatedWatchCount", cVar.Tv);
        }
        String str2 = cVar.Tw;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liteAccumulatedWatchCount", cVar.Tw);
        }
        return jSONObject;
    }
}
