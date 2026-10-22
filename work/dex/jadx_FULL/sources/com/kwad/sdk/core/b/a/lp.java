package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.r> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.r) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.r) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.auw = jSONObject.optBoolean("userForce");
        rVar.type = jSONObject.optInt("type");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = rVar.auw;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userForce", z);
        }
        int i = rVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i);
        }
        return jSONObject;
    }
}
