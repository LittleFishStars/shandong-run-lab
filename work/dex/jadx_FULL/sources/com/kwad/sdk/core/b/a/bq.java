package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bq implements com.kwad.sdk.core.d<com.kwad.components.core.request.model.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.request.model.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.request.model.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.request.model.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.ako = jSONObject.optInt("maxVolume");
        aVar.akp = jSONObject.optInt("minVolume");
        aVar.akq = jSONObject.optInt("currentVolume");
    }

    private static JSONObject b(com.kwad.components.core.request.model.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.streamType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "streamType", i);
        }
        int i2 = aVar.ako;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxVolume", i2);
        }
        int i3 = aVar.akp;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "minVolume", i3);
        }
        int i4 = aVar.akq;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentVolume", i4);
        }
        return jSONObject;
    }
}
