package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.j.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.j.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.apD = jSONObject.optInt("playableSrc");
        bVar.apE = jSONObject.optInt("isMiddleEnd");
        bVar.aaV = jSONObject.optInt("adType");
        bVar.apF = jSONObject.optString("showTime");
        if (JSONObject.NULL.toString().equals(bVar.apF)) {
            bVar.apF = "";
        }
        bVar.convertCount = jSONObject.optInt("convertCount");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.apD;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableSrc", i);
        }
        int i2 = bVar.apE;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isMiddleEnd", i2);
        }
        int i3 = bVar.aaV;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adType", i3);
        }
        String str = bVar.apF;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showTime", bVar.apF);
        }
        int i4 = bVar.convertCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convertCount", i4);
        }
        return jSONObject;
    }
}
