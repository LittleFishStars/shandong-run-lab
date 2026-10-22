package com.kwad.components.core.urlReplace;

import androidx.annotation.Nullable;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.br;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class MarketUrlReplaceData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 4953795264697162439L;
    private urlInfo data;

    public class urlInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 201762827228761165L;
        public String miMarketUrl;
        public boolean replaceSuccess;

        private urlInfo() {
        }
    }

    public String getMiMarketUrl() {
        urlInfo urlinfo = this.data;
        return urlinfo == null ? "" : urlinfo.miMarketUrl;
    }

    public boolean isParseSuccess() {
        urlInfo urlinfo = this.data;
        return (urlinfo == null || urlinfo.miMarketUrl.equals("")) ? false : true;
    }

    public boolean isReplaceSuccess() {
        urlInfo urlinfo = this.data;
        if (urlinfo == null) {
            return false;
        }
        return urlinfo.replaceSuccess;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            e eVar = (e) d.f(e.class);
            if (br.isNullString(strOptString) || eVar == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(eVar.getResponseData(strOptString));
            urlInfo urlinfo = new urlInfo();
            this.data = urlinfo;
            urlinfo.miMarketUrl = jSONObject2.optString("miMarketUrl");
            this.data.replaceSuccess = jSONObject2.optBoolean("replaceSuccess");
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("json bug", e.toString());
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
