package com.kwad.sdk.core.b.a;

import com.igexin.assist.sdk.AssistPushConsts;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.QY = jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD);
        if (JSONObject.NULL.toString().equals(gVar.QY)) {
            gVar.QY = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.apo = jSONObject.optInt("adCacheId");
        gVar.PC = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(gVar.PC)) {
            gVar.PC = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.QY;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, AssistPushConsts.MSG_TYPE_PAYLOAD, gVar.QY);
        }
        int i = gVar.actionType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actionType", i);
        }
        int i2 = gVar.apo;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheId", i2);
        }
        String str2 = gVar.PC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", gVar.PC);
        }
        return jSONObject;
    }
}
