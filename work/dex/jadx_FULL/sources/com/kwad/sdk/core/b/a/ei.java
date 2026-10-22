package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ei implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.draw.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.draw.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.renderType = jSONObject.optInt("render_type");
        aVar.callbackType = jSONObject.optInt("callback_type");
        aVar.dO = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.dO)) {
            aVar.dO = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.renderType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "render_type", i);
        }
        int i2 = aVar.callbackType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callback_type", i2);
        }
        String str = aVar.dO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", aVar.dO);
        }
        return jSONObject;
    }
}
