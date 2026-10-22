package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b bcZ;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.bcZ = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "result", this.result);
        ac.a(jSONObject, "data", this.bcZ);
        return jSONObject;
    }
}
