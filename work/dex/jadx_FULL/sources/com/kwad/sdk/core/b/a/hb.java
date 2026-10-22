package com.kwad.sdk.core.b.a;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hb implements com.kwad.sdk.core.d<AdMatrixInfo.InterstitialCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.InterstitialCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.InterstitialCardInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = new AdMatrixInfo.AdInteractionInfo();
        interstitialCardInfo.interactionInfo = adInteractionInfo;
        adInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
        AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo = new AdMatrixInfo.CycleAggregateInfo();
        interstitialCardInfo.cycleAggregateInfo = cycleAggregateInfo;
        cycleAggregateInfo.parseJson(jSONObject.optJSONObject("cycleAggregateInfo"));
        interstitialCardInfo.closeAfterClick = jSONObject.optBoolean("closeAfterClick", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
    }

    private static JSONObject b(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "interactionInfo", interstitialCardInfo.interactionInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "cycleAggregateInfo", interstitialCardInfo.cycleAggregateInfo);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "closeAfterClick", interstitialCardInfo.closeAfterClick);
        return jSONObject;
    }
}
