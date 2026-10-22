package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.LiveRewardInfo;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kwad.sdk.core.b.a.if, reason: invalid class name */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class Cif implements com.kwad.sdk.core.d<LiveRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveRewardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveRewardInfo) bVar, jSONObject);
    }

    private static void a(LiveRewardInfo liveRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveRewardInfo.rewardTimeSecond = jSONObject.optLong("rewardTimeSecond");
        liveRewardInfo.rewardAmount = jSONObject.optLong("rewardAmount");
        liveRewardInfo.rewardType = jSONObject.optInt(MediationConstant.KEY_REWARD_TYPE);
        liveRewardInfo.rewardVerified = jSONObject.optBoolean("rewardVerified");
    }

    private static JSONObject b(LiveRewardInfo liveRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = liveRewardInfo.rewardTimeSecond;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardTimeSecond", j);
        }
        long j2 = liveRewardInfo.rewardAmount;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardAmount", j2);
        }
        int i = liveRewardInfo.rewardType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediationConstant.KEY_REWARD_TYPE, i);
        }
        boolean z = liveRewardInfo.rewardVerified;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardVerified", z);
        }
        return jSONObject;
    }
}
