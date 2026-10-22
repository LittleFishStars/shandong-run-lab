package com.kwad.components.core.innerEc.live.video.reconnect;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.sdk.core.b {
    public String Uu;
    public JSONObject Uv;
    public String XR;

    public final void a(String str, JSONObject jSONObject) {
        this.Uu = str;
        this.Uv = jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            this.XR = jSONObject.optString("livePlayData");
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return this.Uv;
    }
}
