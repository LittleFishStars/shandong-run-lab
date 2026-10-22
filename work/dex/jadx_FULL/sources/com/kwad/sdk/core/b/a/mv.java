package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mv implements com.kwad.sdk.core.d<AdMatrixInfo.StyleComponentInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.StyleComponentInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.StyleComponentInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.playCardInfo = componentTemplateInfo;
        componentTemplateInfo.parseJson(jSONObject.optJSONObject("playCardInfo"));
        AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo2 = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.endCardInfo = componentTemplateInfo2;
        componentTemplateInfo2.parseJson(jSONObject.optJSONObject("endCardInfo"));
        styleComponentInfo.styleComponentFlag = jSONObject.optBoolean("styleComponentFlag");
    }

    private static JSONObject b(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "playCardInfo", styleComponentInfo.playCardInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "endCardInfo", styleComponentInfo.endCardInfo);
        boolean z = styleComponentInfo.styleComponentFlag;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "styleComponentFlag", z);
        }
        return jSONObject;
    }
}
