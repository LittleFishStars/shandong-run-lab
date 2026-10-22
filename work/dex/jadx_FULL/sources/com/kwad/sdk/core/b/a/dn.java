package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.LiveInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dn implements com.kwad.sdk.core.d<LiveInfo.CoverUrlCdn> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.CoverUrlCdn) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.CoverUrlCdn) bVar, jSONObject);
    }

    private static void a(LiveInfo.CoverUrlCdn coverUrlCdn, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverUrlCdn.coverUrlCdn = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(coverUrlCdn.coverUrlCdn)) {
            coverUrlCdn.coverUrlCdn = "";
        }
    }

    private static JSONObject b(LiveInfo.CoverUrlCdn coverUrlCdn, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = coverUrlCdn.coverUrlCdn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", coverUrlCdn.coverUrlCdn);
        }
        return jSONObject;
    }
}
