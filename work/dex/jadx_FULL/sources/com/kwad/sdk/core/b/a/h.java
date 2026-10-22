package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdAggregateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdAggregateInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        adAggregateInfo.upperTab = jSONObject.optString("upperTab");
        if (JSONObject.NULL.toString().equals(adAggregateInfo.upperTab)) {
            adAggregateInfo.upperTab = "";
        }
        adAggregateInfo.hotTagUrl = jSONObject.optString("hotTagUrl");
        if (JSONObject.NULL.toString().equals(adAggregateInfo.hotTagUrl)) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    private static JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adAggregateInfo.aggregateAdType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregateAdType", i);
        }
        String str = adAggregateInfo.upperTab;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "upperTab", adAggregateInfo.upperTab);
        }
        String str2 = adAggregateInfo.hotTagUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
        return jSONObject;
    }
}
