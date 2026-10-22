package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.x> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.x) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.x) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.auz = jSONObject.optInt("videoCloseTime", new Integer("0").intValue());
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "videoCloseTime", xVar.auz);
        return jSONObject;
    }
}
