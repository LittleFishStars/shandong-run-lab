package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dp implements com.kwad.sdk.core.d<AdInfo.CutRuleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.CutRuleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.CutRuleInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cutRuleInfo.picHeight = jSONObject.optInt("picHeight");
        cutRuleInfo.viewTopMargin = jSONObject.optInt("viewTopMargin");
        cutRuleInfo.safeAreaHeight = jSONObject.optInt("safeAreaHeight");
    }

    private static JSONObject b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cutRuleInfo.picHeight;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "picHeight", i);
        }
        int i2 = cutRuleInfo.viewTopMargin;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "viewTopMargin", i2);
        }
        int i3 = cutRuleInfo.safeAreaHeight;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "safeAreaHeight", i3);
        }
        return jSONObject;
    }
}
