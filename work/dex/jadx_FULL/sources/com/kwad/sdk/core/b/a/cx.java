package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cx implements com.kwad.sdk.core.d<AdMatrixInfo.ComponentTemplateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ComponentTemplateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ComponentTemplateInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        componentTemplateInfo.pageId = jSONObject.optLong(MediationConstant.KEY_USE_POLICY_PAGE_ID);
    }

    private static JSONObject b(AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = componentTemplateInfo.pageId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediationConstant.KEY_USE_POLICY_PAGE_ID, j);
        }
        return jSONObject;
    }
}
