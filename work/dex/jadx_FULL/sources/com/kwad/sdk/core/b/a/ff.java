package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ff implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.followuser.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.followuser.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.followuser.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.followuser.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Ti = jSONObject.optString("userId");
        if (JSONObject.NULL.toString().equals(bVar.Ti)) {
            bVar.Ti = "";
        }
        bVar.Tj = jSONObject.optBoolean("following");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.followuser.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.Ti;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userId", bVar.Ti);
        }
        boolean z = bVar.Tj;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "following", z);
        }
        return jSONObject;
    }
}
