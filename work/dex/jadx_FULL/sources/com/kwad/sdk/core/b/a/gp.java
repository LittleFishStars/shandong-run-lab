package com.kwad.sdk.core.b.a;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.components.core.innerEc.logger.InnerEcEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gp implements com.kwad.sdk.core.d<InnerEcEvent> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InnerEcEvent) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InnerEcEvent) bVar, jSONObject);
    }

    private static void a(InnerEcEvent innerEcEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        innerEcEvent.clickCancelTime = jSONObject.optInt("click_cancel_time", new Integer("0").intValue());
        innerEcEvent.clickLiveCheckEnv = jSONObject.optBoolean("click_live_check_env", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        innerEcEvent.clickUserNowCancel = jSONObject.optBoolean("click_user_now_cancel", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        innerEcEvent.clickHasInnerecFailed = jSONObject.optBoolean("click_has_innerec_failed", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        innerEcEvent.authType = jSONObject.optString("auth_type");
        if (JSONObject.NULL.toString().equals(innerEcEvent.authType)) {
            innerEcEvent.authType = "";
        }
        innerEcEvent.payErrorMsg = jSONObject.optString("pay_error_msg");
        if (JSONObject.NULL.toString().equals(innerEcEvent.payErrorMsg)) {
            innerEcEvent.payErrorMsg = "";
        }
        innerEcEvent.payOrderNo = jSONObject.optString("pay_order_no");
        if (JSONObject.NULL.toString().equals(innerEcEvent.payOrderNo)) {
            innerEcEvent.payOrderNo = "";
        }
        innerEcEvent.payMerchantId = jSONObject.optString("pay_merchant_id");
        if (JSONObject.NULL.toString().equals(innerEcEvent.payMerchantId)) {
            innerEcEvent.payMerchantId = "";
        }
        innerEcEvent.payOriginalResultCode = jSONObject.optInt("pay_original_result_code", new Integer("0").intValue());
        innerEcEvent.payExtData = jSONObject.optString("pay_ext_data");
        if (JSONObject.NULL.toString().equals(innerEcEvent.payExtData)) {
            innerEcEvent.payExtData = "";
        }
    }

    private static JSONObject b(InnerEcEvent innerEcEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "click_cancel_time", innerEcEvent.clickCancelTime);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "click_live_check_env", innerEcEvent.clickLiveCheckEnv);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "click_user_now_cancel", innerEcEvent.clickUserNowCancel);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "click_has_innerec_failed", innerEcEvent.clickHasInnerecFailed);
        String str = innerEcEvent.authType;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "auth_type", innerEcEvent.authType);
        }
        String str2 = innerEcEvent.payErrorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_error_msg", innerEcEvent.payErrorMsg);
        }
        String str3 = innerEcEvent.payOrderNo;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_order_no", innerEcEvent.payOrderNo);
        }
        String str4 = innerEcEvent.payMerchantId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_merchant_id", innerEcEvent.payMerchantId);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_original_result_code", innerEcEvent.payOriginalResultCode);
        String str5 = innerEcEvent.payExtData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_ext_data", innerEcEvent.payExtData);
        }
        return jSONObject;
    }
}
