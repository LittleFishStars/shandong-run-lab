package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lk implements com.kwad.sdk.core.d<com.kwad.sdk.monitor.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.monitor.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.monitor.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.monitor.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bjg = jSONObject.optInt("ds");
        aVar.sdkVersion = jSONObject.optString(com.alipay.sdk.m.w.a.v);
        if (JSONObject.NULL.toString().equals(aVar.sdkVersion)) {
            aVar.sdkVersion = "";
        }
        aVar.bdL = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(aVar.bdL)) {
            aVar.bdL = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.monitor.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bjg;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ds", i);
        }
        String str = aVar.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.m.w.a.v, aVar.sdkVersion);
        }
        String str2 = aVar.bdL;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "spv", aVar.bdL);
        }
        return jSONObject;
    }
}
