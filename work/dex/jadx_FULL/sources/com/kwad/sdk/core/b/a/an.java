package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class an implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.C1235a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.C1235a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.C1235a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1235a.PC = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c1235a.PC)) {
            c1235a.PC = "";
        }
        c1235a.aps = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c1235a.aps)) {
            c1235a.aps = "";
        }
        c1235a.apt = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c1235a.apt)) {
            c1235a.apt = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.C1235a c1235a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c1235a.PC;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", c1235a.PC);
        }
        String str2 = c1235a.aps;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "targetMethod", c1235a.aps);
        }
        String str3 = c1235a.apt;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "methodParams", c1235a.apt);
        }
        return jSONObject;
    }
}
