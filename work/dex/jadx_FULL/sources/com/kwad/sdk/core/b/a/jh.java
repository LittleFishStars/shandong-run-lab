package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.apu = jSONObject.optInt("extra");
        cVar.apv = jSONObject.optLong("playDuration");
        cVar.apw = jSONObject.optBoolean("clickRewardDialog");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.errorCode;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "errorCode", i);
        }
        int i2 = cVar.apu;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extra", i2);
        }
        long j = cVar.apv;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playDuration", j);
        }
        boolean z = cVar.apw;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickRewardDialog", z);
        }
        return jSONObject;
    }
}
