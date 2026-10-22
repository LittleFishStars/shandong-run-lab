package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.br;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public final class a extends com.kwad.sdk.core.response.a.a {

    @Deprecated
    public boolean QK;
    public String Rk;
    public AdTemplate adTemplate;

    @Deprecated
    public boolean aqY;
    public int ara;
    public d arb;
    public int bdg;
    public int bdh;
    public int nm;
    public boolean needReport = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean bdi = false;
    public boolean bdj = false;

    public final boolean PM() {
        return 1 == this.ara;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.nm == 0 && this.bdh == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logParam");
                    this.nm = jSONObjectOptJSONObject.getInt("itemClickType");
                    this.bdh = jSONObjectOptJSONObject.getInt("sceneType");
                    this.bdi = jSONObjectOptJSONObject.optBoolean("isCallbackOnly");
                }
                String strOptString = jSONObject.optString("adTemplate");
                if (br.isNullString(strOptString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e) {
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
