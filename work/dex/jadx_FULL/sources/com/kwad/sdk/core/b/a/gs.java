package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gs implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.item.k.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.config.item.k.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.config.item.k.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.config.item.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aRb = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.aRc = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.config.item.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "horizontalShowDuration", aVar.aRb);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "verticalShowDuration", aVar.aRc);
        return jSONObject;
    }
}
