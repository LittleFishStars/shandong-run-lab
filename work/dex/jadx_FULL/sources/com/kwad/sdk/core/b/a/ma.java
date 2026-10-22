package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ma implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }

    private static void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    private static JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = spikeInfo.endTime;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "endTime", j);
        }
        int i = spikeInfo.soldStock;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soldStock", i);
        }
        int i2 = spikeInfo.originalStock;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "originalStock", i2);
        }
        return jSONObject;
    }
}
