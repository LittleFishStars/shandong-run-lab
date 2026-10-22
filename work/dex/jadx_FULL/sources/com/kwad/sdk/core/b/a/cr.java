package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cr implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.f) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.aul = jSONObject.optInt("closeDelaySeconds");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = fVar.aul;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "closeDelaySeconds", i);
        }
        return jSONObject;
    }
}
