package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dx implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DetailWebCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DetailWebCardInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt("style");
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (JSONObject.NULL.toString().equals(detailWebCardInfo.cardUrl)) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (JSONObject.NULL.toString().equals(detailWebCardInfo.cardData)) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = detailWebCardInfo.style;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "style", i);
        }
        long j = detailWebCardInfo.maxTimeOut;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxTimeOut", j);
        }
        long j2 = detailWebCardInfo.typeLandscape;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "typeLandscape", j2);
        }
        long j3 = detailWebCardInfo.typePortrait;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "typePortrait", j3);
        }
        String str = detailWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        String str2 = detailWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        long j4 = detailWebCardInfo.cardShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardShowTime", j4);
        }
        int i2 = detailWebCardInfo.cardType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardType", i2);
        }
        return jSONObject;
    }
}
