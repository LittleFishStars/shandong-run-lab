package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ku implements com.kwad.sdk.core.d<AdInfo.RewardFraudVerifyInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.RewardFraudVerifyInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.RewardFraudVerifyInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardFraudVerifyInfo.fraudVerifyAdvanceMs = jSONObject.optInt("fraudVerifyAdvanceMs", new Integer("2000").intValue());
        rewardFraudVerifyInfo.fraudVerifySwitch = jSONObject.optBoolean("fraudVerifySwitch");
    }

    private static JSONObject b(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "fraudVerifyAdvanceMs", rewardFraudVerifyInfo.fraudVerifyAdvanceMs);
        boolean z = rewardFraudVerifyInfo.fraudVerifySwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fraudVerifySwitch", z);
        }
        return jSONObject;
    }
}
