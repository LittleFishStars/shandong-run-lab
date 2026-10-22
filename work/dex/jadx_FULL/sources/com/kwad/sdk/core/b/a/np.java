package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class np implements com.kwad.sdk.core.d<AdInfo.UnDownloadRegionConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.UnDownloadRegionConf) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.UnDownloadRegionConf) bVar, jSONObject);
    }

    private static void a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    private static JSONObject b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = unDownloadRegionConf.materialJumpType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "materialJumpType", i);
        }
        int i2 = unDownloadRegionConf.actionBarType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actionBarType", i2);
        }
        int i3 = unDownloadRegionConf.describeBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "describeBarType", i3);
        }
        return jSONObject;
    }
}
