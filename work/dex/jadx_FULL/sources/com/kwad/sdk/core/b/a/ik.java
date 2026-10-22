package com.kwad.sdk.core.b.a;

import com.igexin.assist.sdk.AssistPushConsts;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ik implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.convertType = jSONObject.optInt("convertType");
        dVar.QY = jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD);
        if (JSONObject.NULL.toString().equals(dVar.QY)) {
            dVar.QY = "";
        }
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        dVar.bdk = cVar;
        cVar.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.convertType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convertType", i);
        }
        String str = dVar.QY;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, AssistPushConsts.MSG_TYPE_PAYLOAD, dVar.QY);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "clickInfo", dVar.bdk);
        return jSONObject;
    }
}
