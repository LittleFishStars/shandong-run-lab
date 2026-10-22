package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.height = jSONObject.optInt("height");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = eVar.height;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", i);
        }
        return jSONObject;
    }
}
