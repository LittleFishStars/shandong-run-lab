package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ch implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.block.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.block.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.bff = jSONObject.optString("printerName");
        if (JSONObject.NULL.toString().equals(dVar.bff)) {
            dVar.bff = "";
        }
        dVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(dVar.errorMsg)) {
            dVar.errorMsg = "";
        }
        dVar.bfg = jSONObject.optBoolean("isDisable");
        dVar.bfh = jSONObject.optBoolean("hasMatrix");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.bff;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "printerName", dVar.bff);
        }
        String str2 = dVar.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "errorMsg", dVar.errorMsg);
        }
        boolean z = dVar.bfg;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isDisable", z);
        }
        boolean z2 = dVar.bfh;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hasMatrix", z2);
        }
        return jSONObject;
    }
}
