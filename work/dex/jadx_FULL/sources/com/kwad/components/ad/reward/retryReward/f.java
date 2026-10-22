package com.kwad.components.ad.reward.retryReward;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.sdk.core.response.a.a {
    public long BO;
    public long BP;
    public String key;
    public AdTemplate mAdTemplate;

    public f() {
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.key = jSONObject.optString(CachedContentIndex.a.e);
            String strOptString = jSONObject.optString("adTemplate");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(strOptString));
            this.BO = jSONObject.optLong("storeTime");
            this.BP = jSONObject.optLong("stageTime");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CachedContentIndex.a.e, this.key);
            ac.a(jSONObject, "adTemplate", this.mAdTemplate);
            ac.putValue(jSONObject, "storeTime", this.BO);
            ac.putValue(jSONObject, "stageTime", this.BP);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONObject;
    }

    public f(String str, AdTemplate adTemplate, long j) {
        this.key = str;
        this.mAdTemplate = adTemplate;
        this.BO = j;
        this.BP = System.currentTimeMillis();
    }
}
