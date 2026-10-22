package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bb implements com.kwad.sdk.core.d<AdVideoPreCacheConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdVideoPreCacheConfig) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdVideoPreCacheConfig) bVar, jSONObject);
    }

    private static void a(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adVideoPreCacheConfig.adVideoPreCacheSize = jSONObject.optInt("adVideoPreCacheSize", new Integer("800").intValue());
        adVideoPreCacheConfig.continueLoadingAll = jSONObject.optBoolean("continueLoadingAll");
    }

    private static JSONObject b(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adVideoPreCacheSize", adVideoPreCacheConfig.adVideoPreCacheSize);
        boolean z = adVideoPreCacheConfig.continueLoadingAll;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "continueLoadingAll", z);
        }
        return jSONObject;
    }
}
