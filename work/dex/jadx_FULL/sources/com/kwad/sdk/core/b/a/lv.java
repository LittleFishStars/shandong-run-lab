package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.u) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.u) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.aux = jSONObject.optBoolean("needPromopt");
        uVar.needReport = jSONObject.optBoolean("needReport");
        uVar.showTime = jSONObject.optInt("showTime");
        uVar.apv = jSONObject.optLong("playDuration");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = uVar.aux;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needPromopt", z);
        }
        boolean z2 = uVar.needReport;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needReport", z2);
        }
        int i = uVar.showTime;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showTime", i);
        }
        long j = uVar.apv;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playDuration", j);
        }
        return jSONObject;
    }
}
