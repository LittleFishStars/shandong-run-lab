package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.a.C1236a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.a.C1236a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.a.C1236a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.a.C1236a c1236a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1236a.arX = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c1236a.arX)) {
            c1236a.arX = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.a.C1236a c1236a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c1236a.arX;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "android", c1236a.arX);
        }
        return jSONObject;
    }
}
