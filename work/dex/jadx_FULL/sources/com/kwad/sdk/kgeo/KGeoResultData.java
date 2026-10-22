package com.kwad.sdk.kgeo;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class KGeoResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final long serialVersionUID = -4058631267047548112L;
    public KGeoInfo kGeoInfo = new KGeoInfo();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            this.kGeoInfo.parseJson(new JSONObject(responseData).optJSONObject("kGeoInfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        ac.a(json, "kGeoInfo", this.kGeoInfo);
        return json;
    }
}
