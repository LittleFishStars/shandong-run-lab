package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jr implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.apm = jSONObject.optString("originalID");
        if (JSONObject.NULL.toString().equals(cVar.apm)) {
            cVar.apm = "";
        }
        cVar.apn = jSONObject.optString("path");
        if (JSONObject.NULL.toString().equals(cVar.apn)) {
            cVar.apn = "";
        }
        cVar.apo = jSONObject.optInt("adCacheId");
        cVar.PC = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(cVar.PC)) {
            cVar.PC = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.apm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "originalID", cVar.apm);
        }
        String str2 = cVar.apn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "path", cVar.apn);
        }
        int i = cVar.apo;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheId", i);
        }
        String str3 = cVar.PC;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", cVar.PC);
        }
        return jSONObject;
    }
}
