package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class x implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.y.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.y.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.y.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }
}
