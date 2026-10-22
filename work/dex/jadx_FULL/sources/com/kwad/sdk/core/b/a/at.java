package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class at implements com.kwad.sdk.core.d<AdStatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStatusInfo) bVar, jSONObject);
    }

    private static void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt("downloadStatus");
    }

    private static JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adStatusInfo.loadFromCache;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "loadFromCache", z);
        }
        long j = adStatusInfo.loadDataTime;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "loadDataTime", j);
        }
        long j2 = adStatusInfo.downloadFinishTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadFinishTime", j2);
        }
        int i = adStatusInfo.downloadType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadType", i);
        }
        long j3 = adStatusInfo.downloadSize;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadSize", j3);
        }
        int i2 = adStatusInfo.downloadStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadStatus", i2);
        }
        return jSONObject;
    }
}
