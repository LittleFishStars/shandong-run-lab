package com.kwad.components.core.innerEc.live.reconnect;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LiveGetNewWebsocketResult extends BaseResultData {
    private static final long serialVersionUID = -1989965251888471419L;
    public a mWebsocketConfig = new a();

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
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.mWebsocketConfig.a(responseData, jSONObject2);
            this.mWebsocketConfig.parseJson(jSONObject2);
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }
}
