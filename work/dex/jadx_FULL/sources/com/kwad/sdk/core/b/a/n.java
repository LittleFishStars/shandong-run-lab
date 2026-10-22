package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.convert.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.convert.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.convert.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.convert.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.methodName = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.aKo = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.aKp = jSONObject.optBoolean("is_api_native");
        bVar.aKq = jSONObject.optString("ad_request_type");
        if (JSONObject.NULL.toString().equals(bVar.aKq)) {
            bVar.aKq = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (JSONObject.NULL.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.convert.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.methodName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "method_name", bVar.methodName);
        }
        boolean z = bVar.aKo;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_convert", z);
        }
        int i = bVar.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_num", i);
        }
        boolean z2 = bVar.aKp;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_api_native", z2);
        }
        String str2 = bVar.aKq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_request_type", bVar.aKq);
        }
        String str3 = bVar.adSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
