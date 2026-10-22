package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class kt implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardCheckMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardCheckMonitorInfo) bVar, jSONObject);
    }

    private static void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    private static JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = rewardCheckMonitorInfo.checkType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "check_type", i);
        }
        int i2 = rewardCheckMonitorInfo.requestStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_state", i2);
        }
        int i3 = rewardCheckMonitorInfo.code;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "code", i3);
        }
        long j = rewardCheckMonitorInfo.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", j);
        }
        long j2 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "data_load_interval_duration_ms", j2);
        }
        long j3 = rewardCheckMonitorInfo.posId;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pos_Id", j3);
        }
        int i4 = rewardCheckMonitorInfo.enviType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enviType", i4);
        }
        return jSONObject;
    }
}
