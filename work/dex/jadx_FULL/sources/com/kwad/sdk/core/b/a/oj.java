package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class oj implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.i) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.i) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.Uw = jSONObject.optString("serverGroupPath");
        if (JSONObject.NULL.toString().equals(iVar.Uw)) {
            iVar.Uw = "";
        }
        iVar.Ux = jSONObject.optString("enableWss");
        if (JSONObject.NULL.toString().equals(iVar.Ux)) {
            iVar.Ux = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = iVar.Uw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serverGroupPath", iVar.Uw);
        }
        String str2 = iVar.Ux;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableWss", iVar.Ux);
        }
        return jSONObject;
    }
}
