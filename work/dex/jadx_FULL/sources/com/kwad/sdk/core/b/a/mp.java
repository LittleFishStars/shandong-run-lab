package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mp implements com.kwad.sdk.core.d<com.kwad.sdk.wrapper.l.a.C1312a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.wrapper.l.a.C1312a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.wrapper.l.a.C1312a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.wrapper.l.a.C1312a c1312a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1312a.buh = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c1312a.buh)) {
            c1312a.buh = "";
        }
        c1312a.bui = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c1312a.bui)) {
            c1312a.bui = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.wrapper.l.a.C1312a c1312a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c1312a.buh;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "s_cn", c1312a.buh);
        }
        String str2 = c1312a.bui;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "s_mn", c1312a.bui);
        }
        return jSONObject;
    }
}
