package com.kwad.sdk.core.b.a;

import com.kwad.components.core.innerEc.logger.InnerEcError;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class go implements com.kwad.sdk.core.d<InnerEcError> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InnerEcError) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InnerEcError) bVar, jSONObject);
    }

    private static void a(InnerEcError innerEcError, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        innerEcError.errorUrl = jSONObject.optString("errorUrl");
        if (JSONObject.NULL.toString().equals(innerEcError.errorUrl)) {
            innerEcError.errorUrl = "";
        }
        innerEcError.payOrderNo = jSONObject.optString("pay_order_no");
        if (JSONObject.NULL.toString().equals(innerEcError.payOrderNo)) {
            innerEcError.payOrderNo = "";
        }
        innerEcError.payErrorMsg = jSONObject.optString("pay_error_msg");
        if (JSONObject.NULL.toString().equals(innerEcError.payErrorMsg)) {
            innerEcError.payErrorMsg = "";
        }
        innerEcError.payMerchantId = jSONObject.optString("pay_merchant_id");
        if (JSONObject.NULL.toString().equals(innerEcError.payMerchantId)) {
            innerEcError.payMerchantId = "";
        }
        innerEcError.payOriginalResultCode = jSONObject.optInt("pay_original_result_code", new Integer("0").intValue());
        innerEcError.payExtData = jSONObject.optString("pay_ext_data");
        if (JSONObject.NULL.toString().equals(innerEcError.payExtData)) {
            innerEcError.payExtData = "";
        }
    }

    private static JSONObject b(InnerEcError innerEcError, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = innerEcError.errorUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "errorUrl", innerEcError.errorUrl);
        }
        String str2 = innerEcError.payOrderNo;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_order_no", innerEcError.payOrderNo);
        }
        String str3 = innerEcError.payErrorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_error_msg", innerEcError.payErrorMsg);
        }
        String str4 = innerEcError.payMerchantId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_merchant_id", innerEcError.payMerchantId);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_original_result_code", innerEcError.payOriginalResultCode);
        String str5 = innerEcError.payExtData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_ext_data", innerEcError.payExtData);
        }
        return jSONObject;
    }
}
