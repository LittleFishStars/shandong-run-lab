package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class r implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.d.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.d.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.d.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aKu = jSONObject.optString("imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.aKu)) {
            cVar.aKu = "";
        }
        cVar.aKv = jSONObject.optString("final_imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.aKv)) {
            cVar.aKv = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.d.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.aKu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imp_ad_info", cVar.aKu);
        }
        String str2 = cVar.aKv;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "final_imp_ad_info", cVar.aKv);
        }
        return jSONObject;
    }
}
