package com.kwad.components.core.emotion;

import androidx.annotation.Nullable;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.br;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class EmotionPackageResponse extends BaseResultData {
    private static final String TAG = "EmotionPackageResponse";
    private static final long serialVersionUID = 2114619600151182932L;
    private JSONArray data;

    public String getFullJson() {
        return toJson().toString();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        String strOptString = jSONObject.optString("data");
        if (!br.isNullString(strOptString)) {
            strOptString = ((e) d.f(e.class)).getResponseData(strOptString);
        }
        try {
            this.data = new JSONArray(strOptString);
        } catch (JSONException e) {
            c.w(TAG, "parseJson error" + e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        ac.putValue(json, "data", this.data);
        return json;
    }
}
