package com.kwad.sdk.core.b.a;

import com.baidu.mapapi.SDKInitializer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ky implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.retryReward.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.retryReward.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.retryReward.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.retryReward.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.status = jSONObject.optInt("status");
        cVar.Bz = jSONObject.optString("convert_url");
        if (JSONObject.NULL.toString().equals(cVar.Bz)) {
            cVar.Bz = "";
        }
        cVar.convertType = jSONObject.optInt("convert_type");
        cVar.BA = jSONObject.optString("ad_desc");
        if (JSONObject.NULL.toString().equals(cVar.BA)) {
            cVar.BA = "";
        }
        cVar.productName = jSONObject.optString("product_name");
        if (JSONObject.NULL.toString().equals(cVar.productName)) {
            cVar.productName = "";
        }
        cVar.tT = jSONObject.optString("icon_url");
        if (JSONObject.NULL.toString().equals(cVar.tT)) {
            cVar.tT = "";
        }
        cVar.errorCode = jSONObject.optInt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE);
        cVar.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(cVar.errorMsg)) {
            cVar.errorMsg = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.retryReward.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        String str = cVar.Bz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convert_url", cVar.Bz);
        }
        int i2 = cVar.convertType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convert_type", i2);
        }
        String str2 = cVar.BA;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_desc", cVar.BA);
        }
        String str3 = cVar.productName;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "product_name", cVar.productName);
        }
        String str4 = cVar.tT;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "icon_url", cVar.tT);
        }
        int i3 = cVar.errorCode;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i3);
        }
        String str5 = cVar.errorMsg;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_msg", cVar.errorMsg);
        }
        return jSONObject;
    }
}
