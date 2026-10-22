package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public f(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.helper.a.bZ(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        ac.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        try {
            String strCa = com.kwad.sdk.core.response.helper.a.ca(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
            if (TextUtils.isEmpty(strCa)) {
                return;
            }
            putBody("serverExt", new JSONObject(strCa));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.i.ES();
    }
}
