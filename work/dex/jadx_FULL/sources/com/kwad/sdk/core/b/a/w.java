package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class w implements com.kwad.sdk.core.d<AdGlobalConfigInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adGlobalConfigInfo.neoPageType = jSONObject.optInt("neoPageType");
        AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo = new AdGlobalConfigInfo.NeoScanAggregationSceneInfo();
        adGlobalConfigInfo.neoScanAggregationSceneInfo = neoScanAggregationSceneInfo;
        neoScanAggregationSceneInfo.parseJson(jSONObject.optJSONObject("neoScanAggregationSceneInfo"));
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo = new AdGlobalConfigInfo.CycleAggregationInfo();
        adGlobalConfigInfo.cycleAggregationInfo = cycleAggregationInfo;
        cycleAggregationInfo.parseJson(jSONObject.optJSONObject("cycleAggregationInfo"));
        adGlobalConfigInfo.uaidEnable = jSONObject.optBoolean("uaidEnable");
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adGlobalConfigInfo.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        AdGlobalConfigInfo.RefreshToken refreshToken = new AdGlobalConfigInfo.RefreshToken();
        adGlobalConfigInfo.refreshToken = refreshToken;
        refreshToken.parseJson(jSONObject.optJSONObject("refreshToken"));
        adGlobalConfigInfo.authError = jSONObject.optLong("authError");
    }

    private static JSONObject b(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adGlobalConfigInfo.neoPageType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neoPageType", i);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "neoScanAggregationSceneInfo", adGlobalConfigInfo.neoScanAggregationSceneInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "cycleAggregationInfo", adGlobalConfigInfo.cycleAggregationInfo);
        boolean z = adGlobalConfigInfo.uaidEnable;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaidEnable", z);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adVideoPreCacheConfig", adGlobalConfigInfo.adVideoPreCacheConfig);
        com.kwad.sdk.utils.ac.a(jSONObject, "refreshToken", adGlobalConfigInfo.refreshToken);
        long j = adGlobalConfigInfo.authError;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authError", j);
        }
        return jSONObject;
    }
}
