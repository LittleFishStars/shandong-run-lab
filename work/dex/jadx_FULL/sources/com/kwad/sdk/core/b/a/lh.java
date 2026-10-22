package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lh implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.base.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.base.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.base.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.base.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.Tx = jSONObject.optString("displayLikeCount");
        if (JSONObject.NULL.toString().equals(dVar.Tx)) {
            dVar.Tx = "";
        }
        dVar.Ty = jSONObject.optString("displayWatchingCount");
        if (JSONObject.NULL.toString().equals(dVar.Ty)) {
            dVar.Ty = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.base.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.Tx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayLikeCount", dVar.Tx);
        }
        String str2 = dVar.Ty;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayWatchingCount", dVar.Ty);
        }
        return jSONObject;
    }
}
