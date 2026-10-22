package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class LiveDetailReward extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 2222514744395688920L;
    public long countDownSecond;
    public double hasRewardTime;
    public String pageDataKey;
    public boolean success;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ac.putValue(jSONObject, "success", this.success);
        ac.putValue(jSONObject, "countDownSecond", this.countDownSecond);
        ac.putValue(jSONObject, "hasRewardTime", this.hasRewardTime);
        ac.putValue(jSONObject, "pageDataKey", this.pageDataKey);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "LiveDetailReward{success=" + this.success + ", countDownSecond=" + this.countDownSecond + ", hasRewardTime=" + this.hasRewardTime + ", pageDataKey='" + this.pageDataKey + "'}";
    }
}
