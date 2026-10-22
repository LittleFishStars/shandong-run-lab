package com.kwad.sdk.core.b.a;

import com.baidu.mapapi.SDKInitializer;
import com.kwad.sdk.mobileid.UaidInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nn implements com.kwad.sdk.core.d<UaidInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((UaidInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((UaidInfo) bVar, jSONObject);
    }

    private static void a(UaidInfo uaidInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uaidInfo.status = jSONObject.optInt("status");
        uaidInfo.canRequest = jSONObject.optString("can_request");
        if (JSONObject.NULL.toString().equals(uaidInfo.canRequest)) {
            uaidInfo.canRequest = "";
        }
        uaidInfo.traceId = jSONObject.optString("trace_id");
        if (JSONObject.NULL.toString().equals(uaidInfo.traceId)) {
            uaidInfo.traceId = "";
        }
        uaidInfo.operatorType = jSONObject.optInt("operator_type");
        uaidInfo.networkType = jSONObject.optInt("network_type");
        uaidInfo.dcontrollerEnableNetwork = jSONObject.optBoolean("dcontroller_enable_network");
        uaidInfo.dcontrollerEnablePhoneState = jSONObject.optBoolean("dcontroller_enable_phone_state");
        uaidInfo.imsiNotEmpty = jSONObject.optBoolean("imsi_not_empty");
        uaidInfo.uaid = jSONObject.optString("uaid");
        if (JSONObject.NULL.toString().equals(uaidInfo.uaid)) {
            uaidInfo.uaid = "";
        }
        uaidInfo.result = jSONObject.optInt("result");
        uaidInfo.token = jSONObject.optString("token");
        if (JSONObject.NULL.toString().equals(uaidInfo.token)) {
            uaidInfo.token = "";
        }
        uaidInfo.errorCode = jSONObject.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE);
        if (JSONObject.NULL.toString().equals(uaidInfo.errorCode)) {
            uaidInfo.errorCode = "";
        }
        uaidInfo.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(uaidInfo.errorMsg)) {
            uaidInfo.errorMsg = "";
        }
    }

    private static JSONObject b(UaidInfo uaidInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = uaidInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        String str = uaidInfo.canRequest;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "can_request", uaidInfo.canRequest);
        }
        String str2 = uaidInfo.traceId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "trace_id", uaidInfo.traceId);
        }
        int i2 = uaidInfo.operatorType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "operator_type", i2);
        }
        int i3 = uaidInfo.networkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "network_type", i3);
        }
        boolean z = uaidInfo.dcontrollerEnableNetwork;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dcontroller_enable_network", z);
        }
        boolean z2 = uaidInfo.dcontrollerEnablePhoneState;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dcontroller_enable_phone_state", z2);
        }
        boolean z3 = uaidInfo.imsiNotEmpty;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imsi_not_empty", z3);
        }
        String str3 = uaidInfo.uaid;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaid", uaidInfo.uaid);
        }
        int i4 = uaidInfo.result;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "result", i4);
        }
        String str4 = uaidInfo.token;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "token", uaidInfo.token);
        }
        String str5 = uaidInfo.errorCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, uaidInfo.errorCode);
        }
        String str6 = uaidInfo.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_msg", uaidInfo.errorMsg);
        }
        return jSONObject;
    }
}
