package com.kwad.components.ad.reward.retryReward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class RewardRetryTaskParams extends BaseResultData {
    private final Map<Long, a> mTaskResultMap = new HashMap();

    public static class a {
        public int conversionStatus;
        public long creativeId;
        public long llsid;

        public a(long j, long j2, int i) {
            this.llsid = j;
            this.conversionStatus = i;
            this.creativeId = j2;
        }
    }

    public Map<Long, a> getTaskResultMap() {
        return this.mTaskResultMap;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            com.kwad.sdk.core.a.e eVar = (com.kwad.sdk.core.a.e) com.kwad.sdk.components.d.f(com.kwad.sdk.core.a.e.class);
            if (eVar != null) {
                strOptString = eVar.getResponseData(strOptString);
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strOptString).optJSONArray("taskInfoList");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i = 0; jSONArrayOptJSONArray.length() > i; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                long jOptLong = jSONObjectOptJSONObject.optLong("llsid");
                this.mTaskResultMap.put(Long.valueOf(jOptLong), new a(jOptLong, jSONObjectOptJSONObject.optLong("creativeId"), jSONObjectOptJSONObject.optInt("conversionStatus")));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
