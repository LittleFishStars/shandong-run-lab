package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dq implements com.kwad.sdk.core.d<AdMatrixInfo.CycleAggregateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.CycleAggregateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.CycleAggregateInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregateInfo.cutIconUrl = jSONObject.optString("cutIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.cutIconUrl)) {
            cycleAggregateInfo.cutIconUrl = "";
        }
        cycleAggregateInfo.refreshIconUrl = jSONObject.optString("refreshIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.refreshIconUrl)) {
            cycleAggregateInfo.refreshIconUrl = "";
        }
        cycleAggregateInfo.convertIconUrl = jSONObject.optString("convertIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.convertIconUrl)) {
            cycleAggregateInfo.convertIconUrl = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cycleAggregateInfo.cutIconUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cutIconUrl", cycleAggregateInfo.cutIconUrl);
        }
        String str2 = cycleAggregateInfo.refreshIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "refreshIconUrl", cycleAggregateInfo.refreshIconUrl);
        }
        String str3 = cycleAggregateInfo.convertIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convertIconUrl", cycleAggregateInfo.convertIconUrl);
        }
        return jSONObject;
    }
}
