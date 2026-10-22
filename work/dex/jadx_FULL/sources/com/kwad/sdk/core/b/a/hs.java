package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hs implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bsH = jSONObject.optInt("put_count");
        aVar.bsI = jSONObject.optInt("get_failed_count");
        aVar.bsJ = jSONObject.optInt("get_success_count");
    }

    private static JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bsH;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "put_count", i);
        }
        int i2 = aVar.bsI;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "get_failed_count", i2);
        }
        int i3 = aVar.bsJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "get_success_count", i3);
        }
        return jSONObject;
    }
}
