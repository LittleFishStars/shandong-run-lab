package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class em implements com.kwad.sdk.core.d<AdMatrixInfo.DynamicAdStyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.DynamicAdStyleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.DynamicAdStyleInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.SlideInfo slideInfo = new AdMatrixInfo.SlideInfo();
        dynamicAdStyleInfo.slideInfo = slideInfo;
        slideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
    }

    private static JSONObject b(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "slideInfo", dynamicAdStyleInfo.slideInfo);
        return jSONObject;
    }
}
