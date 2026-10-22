package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jm implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.i) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.i) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(iVar.url)) {
            iVar.url = "";
        }
        iVar.host = jSONObject.optString(com.alipay.sdk.m.n.c.f);
        if (JSONObject.NULL.toString().equals(iVar.host)) {
            iVar.host = "";
        }
        iVar.httpCode = jSONObject.optInt("http_code");
        iVar.aTv = jSONObject.optString("req_type");
        if (JSONObject.NULL.toString().equals(iVar.aTv)) {
            iVar.aTv = "";
        }
        iVar.aTw = jSONObject.optInt("use_ip");
    }

    private static JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = iVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", iVar.url);
        }
        String str2 = iVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.m.n.c.f, iVar.host);
        }
        int i = iVar.httpCode;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "http_code", i);
        }
        String str3 = iVar.aTv;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "req_type", iVar.aTv);
        }
        int i2 = iVar.aTw;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "use_ip", i2);
        }
        return jSONObject;
    }
}
