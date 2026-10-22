package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hd implements com.kwad.sdk.core.d<InterstitialRealTimeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InterstitialRealTimeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InterstitialRealTimeInfo) bVar, jSONObject);
    }

    private static void a(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialRealTimeInfo.renderType = jSONObject.optLong("render_type");
        interstitialRealTimeInfo.monitorIndex = jSONObject.optLong("monitor_index");
        interstitialRealTimeInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(interstitialRealTimeInfo.materialUrl)) {
            interstitialRealTimeInfo.materialUrl = "";
        }
    }

    private static JSONObject b(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = interstitialRealTimeInfo.renderType;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "render_type", j);
        }
        long j2 = interstitialRealTimeInfo.monitorIndex;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "monitor_index", j2);
        }
        String str = interstitialRealTimeInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", interstitialRealTimeInfo.materialUrl);
        }
        return jSONObject;
    }
}
