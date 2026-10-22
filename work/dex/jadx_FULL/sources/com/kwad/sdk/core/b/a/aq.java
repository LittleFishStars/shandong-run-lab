package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class aq implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdRewardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdRewardInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer("30").intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("30").intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        AdInfo.CallBackStrategyInfo callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo = callBackStrategyInfo;
        callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
        AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo = new AdInfo.RewardFraudVerifyInfo();
        adRewardInfo.rewardFraudVerifyInfo = rewardFraudVerifyInfo;
        rewardFraudVerifyInfo.parseJson(jSONObject.optJSONObject("rewardFraudVerifyInfo"));
        AdInfo.RewardRetryTaskInfo rewardRetryTaskInfo = new AdInfo.RewardRetryTaskInfo();
        adRewardInfo.rewardRetryTaskInfo = rewardRetryTaskInfo;
        rewardRetryTaskInfo.parseJson(jSONObject.optJSONObject("rewardRetryTaskInfo"));
    }

    private static JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i = adRewardInfo.showLandingPage;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showLandingPage", i);
        }
        boolean z = adRewardInfo.rewardVideoEndCardSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardVideoEndCardSwitch", z);
        }
        boolean z2 = adRewardInfo.recommendAggregateSwitch;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "recommendAggregateSwitch", z2);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "rewardFraudVerifyInfo", adRewardInfo.rewardFraudVerifyInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "rewardRetryTaskInfo", adRewardInfo.rewardRetryTaskInfo);
        return jSONObject;
    }
}
