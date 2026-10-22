package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bo implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aJY = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.aJY)) {
            bVar.aJY = "";
        }
        bVar.aKf = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.aKf)) {
            bVar.aKf = "";
        }
        bVar.aKg = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(bVar.aKg)) {
            bVar.aKg = "";
        }
        bVar.aKh = jSONObject.optInt("store_type");
        bVar.aKi = jSONObject.optInt("launch_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.aJY;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url_host", bVar.aJY);
        }
        String str3 = bVar.aKf;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url_path", bVar.aKf);
        }
        String str4 = bVar.aKg;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "market_pkg_name", bVar.aKg);
        }
        int i2 = bVar.aKh;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "store_type", i2);
        }
        int i3 = bVar.aKi;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "launch_type", i3);
        }
        return jSONObject;
    }
}
