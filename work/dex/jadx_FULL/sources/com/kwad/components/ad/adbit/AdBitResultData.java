package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class AdBitResultData extends AdResultData {
    private static final long serialVersionUID = -3932631606478587475L;
    public List<AdBid> adBidList;
    public String adxId;

    public AdBitResultData(SceneImpl sceneImpl) {
        super(sceneImpl);
        this.adBidList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData, com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            this.adxId = jSONObject.optString("adxId");
            String strOptString = jSONObject.optString("adBids");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strOptString);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        AdBid adBid = new AdBid();
                        adBid.parseJson(jSONObjectOptJSONObject);
                        this.adBidList.add(adBid);
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
