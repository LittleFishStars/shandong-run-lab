package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hy implements com.kwad.sdk.core.d<LiveDetailReward> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveDetailReward) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveDetailReward) bVar, jSONObject);
    }

    private static void a(LiveDetailReward liveDetailReward, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveDetailReward.success = jSONObject.optBoolean("success");
        liveDetailReward.countDownSecond = jSONObject.optLong("countDownSecond");
        liveDetailReward.hasRewardTime = jSONObject.optDouble("hasRewardTime");
        liveDetailReward.pageDataKey = jSONObject.optString("pageDataKey");
        if (JSONObject.NULL.toString().equals(liveDetailReward.pageDataKey)) {
            liveDetailReward.pageDataKey = "";
        }
    }

    private static JSONObject b(LiveDetailReward liveDetailReward, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = liveDetailReward.success;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "success", z);
        }
        long j = liveDetailReward.countDownSecond;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "countDownSecond", j);
        }
        double d = liveDetailReward.hasRewardTime;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hasRewardTime", d);
        }
        String str = liveDetailReward.pageDataKey;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageDataKey", liveDetailReward.pageDataKey);
        }
        return jSONObject;
    }
}
