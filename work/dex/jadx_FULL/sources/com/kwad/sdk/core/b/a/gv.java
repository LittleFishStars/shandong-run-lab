package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.m.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.m.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.m.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt("progress");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.apI = jSONObject.optInt("realProgress");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.progress;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "progress", i2);
        }
        long j = bVar.soFarBytes;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soFarBytes", j);
        }
        long j2 = bVar.totalBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalBytes", j2);
        }
        int i3 = bVar.apI;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realProgress", i3);
        }
        return jSONObject;
    }
}
