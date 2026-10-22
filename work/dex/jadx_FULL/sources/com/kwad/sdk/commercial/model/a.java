package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements b {
    public int adOperationType;
    public int campaignType;
    public int industryFirstLevelId;
    public int ocpcActionType;
    public int webUriSourceType;

    public a(AdInfo adInfo) {
        if (adInfo != null) {
            this.campaignType = com.kwad.sdk.core.response.helper.a.dw(adInfo);
            this.ocpcActionType = com.kwad.sdk.core.response.helper.a.dx(adInfo);
            this.industryFirstLevelId = com.kwad.sdk.core.response.helper.a.dy(adInfo);
            this.adOperationType = com.kwad.sdk.core.response.helper.a.aW(adInfo);
            this.webUriSourceType = com.kwad.sdk.core.response.helper.a.dz(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "campaign_type", this.campaignType);
        ac.putValue(jSONObject, "ocpc_action_type", this.ocpcActionType);
        ac.putValue(jSONObject, "industry_first_level_id", this.industryFirstLevelId);
        ac.putValue(jSONObject, "ad_operation_type", this.adOperationType);
        ac.putValue(jSONObject, "web_uri_source_type", this.webUriSourceType);
        return jSONObject;
    }
}
