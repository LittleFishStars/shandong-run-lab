package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class aw implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        bVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        bVar.llsid = jSONObject.optString("llsid");
        if (JSONObject.NULL.toString().equals(bVar.llsid)) {
            bVar.llsid = "";
        }
        bVar.extra = jSONObject.optString("extra");
        if (JSONObject.NULL.toString().equals(bVar.extra)) {
            bVar.extra = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adTemplate", bVar.adTemplate);
        String str = bVar.llsid;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "llsid", bVar.llsid);
        }
        String str2 = bVar.extra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extra", bVar.extra);
        }
        return jSONObject;
    }
}
