package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class oh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ay.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ay.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ay.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ay.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aru = jSONObject.optString("windowFocusEvent");
        if (JSONObject.NULL.toString().equals(aVar.aru)) {
            aVar.aru = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ay.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aru;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "windowFocusEvent", aVar.aru);
        }
        return jSONObject;
    }
}
