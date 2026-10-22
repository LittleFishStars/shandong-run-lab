package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements com.kwad.sdk.core.b {
    public String bcX;
    public String bcY;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.bcX = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.bcY = jSONObject.optString(RenderCallContext.TYPE_CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "action", this.bcX);
        ac.putValue(jSONObject, "data", this.data);
        ac.putValue(jSONObject, RenderCallContext.TYPE_CALLBACK, this.bcY);
        return jSONObject;
    }
}
