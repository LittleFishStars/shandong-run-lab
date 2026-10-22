package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b aXr;

    public static e Nv() {
        e eVar = new e();
        try {
            eVar.aXr = ((k) ServiceProvider.get(k.class)).Fp();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "modeInfo", this.aXr);
        return jSONObject;
    }
}
