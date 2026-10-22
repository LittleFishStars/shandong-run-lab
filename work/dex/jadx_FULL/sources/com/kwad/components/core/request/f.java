package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public long requestStartTime;

    public f(int i, AdTemplate adTemplate) {
        String strBZ = com.kwad.sdk.core.response.helper.a.bZ(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        try {
            String strCa = com.kwad.sdk.core.response.helper.a.ca(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
            try {
                if (!TextUtils.isEmpty(strCa)) {
                    putBody("serverExt", new JSONObject(strCa));
                    if (!TextUtils.isEmpty(strBZ) && strBZ != null) {
                        JSONObject jSONObject = new JSONObject(strBZ);
                        ac.putValue(jSONObject, "checkType", i);
                        putBody("callbackUrlInfo", jSONObject.toString());
                    }
                } else if (!TextUtils.isEmpty(strBZ)) {
                    JSONObject jSONObject2 = new JSONObject(strBZ);
                    ac.putValue(jSONObject2, "checkType", i);
                    putBody("callbackUrlInfo", jSONObject2.toString());
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        ac.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.i.EW();
    }
}
