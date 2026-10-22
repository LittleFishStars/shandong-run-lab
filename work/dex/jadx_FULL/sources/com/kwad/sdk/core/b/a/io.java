package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class io implements com.kwad.sdk.core.d<FeedPageInfo.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedPageInfo.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedPageInfo.a) bVar, jSONObject);
    }

    private static void a(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.creativeId = jSONObject.optLong("creative_id");
    }

    private static JSONObject b(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.materialType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", i);
        }
        String str = aVar.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        long j = aVar.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", j);
        }
        return jSONObject;
    }
}
