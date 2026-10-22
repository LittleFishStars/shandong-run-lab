package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.br;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("impAdInfo");
            if (br.isNullString(strOptString)) {
                String strOptString2 = jSONObject.optString("data");
                if (br.isNullString(strOptString2)) {
                    return;
                }
                this.data = new JSONObject(d.getResponseData(strOptString2));
                return;
            }
            String responseData = d.getResponseData(strOptString);
            if (br.isNullString(responseData)) {
                return;
            }
            this.impAdInfo = new JSONArray(responseData);
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            ac.putValue(json, "data", jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            ac.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
