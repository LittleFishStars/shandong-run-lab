package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gf implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcL = jSONObject.optString("Access-Control-Allow-Origin");
        if (JSONObject.NULL.toString().equals(aVar.bcL)) {
            aVar.bcL = "";
        }
        aVar.bcM = jSONObject.optString(com.google.common.net.b.H0);
        if (JSONObject.NULL.toString().equals(aVar.bcM)) {
            aVar.bcM = "";
        }
        aVar.bcN = jSONObject.optString(com.alipay.sdk.m.t.e.f);
        if (JSONObject.NULL.toString().equals(aVar.bcN)) {
            aVar.bcN = "";
        }
        aVar.bcO = jSONObject.optString("Date");
        if (JSONObject.NULL.toString().equals(aVar.bcO)) {
            aVar.bcO = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.bcL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.bcL);
        }
        String str2 = aVar.bcM;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.google.common.net.b.H0, aVar.bcM);
        }
        String str3 = aVar.bcN;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.m.t.e.f, aVar.bcN);
        }
        String str4 = aVar.bcO;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "Date", aVar.bcO);
        }
        return jSONObject;
    }
}
