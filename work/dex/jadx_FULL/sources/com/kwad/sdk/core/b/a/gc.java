package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gc implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bgw = jSONObject.optInt("apiLevel");
        aVar.bgx = jSONObject.optInt("colorModeSupport");
        aVar.bgy = jSONObject.optInt("screenHdrAvailable");
        aVar.bgz = jSONObject.optInt("hdrSupport");
    }

    private static JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bgw;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiLevel", i);
        }
        int i2 = aVar.bgx;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "colorModeSupport", i2);
        }
        int i3 = aVar.bgy;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHdrAvailable", i3);
        }
        int i4 = aVar.bgz;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hdrSupport", i4);
        }
        return jSONObject;
    }
}
