package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.v> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.v) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.v) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.rq = jSONObject.optInt("currentTime");
        vVar.ajf = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = vVar.rq;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentTime", i);
        }
        boolean z = vVar.ajf;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "finished", z);
        }
        return jSONObject;
    }
}
