package com.kwad.components.core.innerEc.live.reconnect;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements b {
    public int Ut;
    public String Uu;
    public JSONObject Uv;
    public String XH = "";

    public final void a(String str, JSONObject jSONObject) {
        this.Uu = str;
        this.Uv = jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.Ut = jSONObject.optInt("liveErrorCode");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("liveData");
            if (jSONObjectOptJSONObject != null) {
                this.XH = jSONObjectOptJSONObject.toString();
            }
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return this.Uv;
    }
}
