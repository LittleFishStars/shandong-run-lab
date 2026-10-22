package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class od implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.z> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.rq = jSONObject.optInt("currentTime");
        zVar.auB = jSONObject.optBoolean(com.alipay.sdk.m.y.k.j);
        zVar.ajf = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = zVar.rq;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentTime", i);
        }
        boolean z = zVar.auB;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.m.y.k.j, z);
        }
        boolean z2 = zVar.ajf;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "finished", z2);
        }
        return jSONObject;
    }
}
