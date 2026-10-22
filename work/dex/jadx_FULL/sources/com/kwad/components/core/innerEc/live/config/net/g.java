package com.kwad.components.core.innerEc.live.config.net;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class g extends com.kwad.sdk.core.response.a.a {
    public b Ur = new b();
    public a Us = new a();
    public int Ut;
    public String Uu;
    public JSONObject Uv;

    public final void a(String str, JSONObject jSONObject) {
        this.Uu = str;
        this.Uv = jSONObject;
    }

    public final boolean isValid() {
        return this.Ut == 1 && !TextUtils.isEmpty(this.Ur.Uh.liveStreamId);
    }

    public final boolean rG() {
        return this.Ut != 1;
    }

    public final boolean rH() {
        return this.Ut == 601;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return this.Uv;
    }
}
