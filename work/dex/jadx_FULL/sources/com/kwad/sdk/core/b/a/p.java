package com.kwad.sdk.core.b.a;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.kwad.sdk.core.response.model.AdCouponReceiveParam;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p implements com.kwad.sdk.core.d<AdCouponReceiveParam> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdCouponReceiveParam) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdCouponReceiveParam) bVar, jSONObject);
    }

    private static void a(AdCouponReceiveParam adCouponReceiveParam, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adCouponReceiveParam.receiveToast = jSONObject.optString("receiveToast");
        if (JSONObject.NULL.toString().equals(adCouponReceiveParam.receiveToast)) {
            adCouponReceiveParam.receiveToast = "";
        }
        adCouponReceiveParam.sign = jSONObject.optString(UserTrackConstant.SIGN);
        if (JSONObject.NULL.toString().equals(adCouponReceiveParam.sign)) {
            adCouponReceiveParam.sign = "";
        }
        adCouponReceiveParam.ext = jSONObject.optString(LoginConstants.EXT);
        if (JSONObject.NULL.toString().equals(adCouponReceiveParam.ext)) {
            adCouponReceiveParam.ext = "";
        }
        adCouponReceiveParam.receiveFailToast = jSONObject.optString("receiveFailToast");
        if (JSONObject.NULL.toString().equals(adCouponReceiveParam.receiveFailToast)) {
            adCouponReceiveParam.receiveFailToast = "";
        }
        adCouponReceiveParam.flowType = jSONObject.optInt("flowType");
    }

    private static JSONObject b(AdCouponReceiveParam adCouponReceiveParam, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adCouponReceiveParam.receiveToast;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "receiveToast", adCouponReceiveParam.receiveToast);
        }
        String str2 = adCouponReceiveParam.sign;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, UserTrackConstant.SIGN, adCouponReceiveParam.sign);
        }
        String str3 = adCouponReceiveParam.ext;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, LoginConstants.EXT, adCouponReceiveParam.ext);
        }
        String str4 = adCouponReceiveParam.receiveFailToast;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "receiveFailToast", adCouponReceiveParam.receiveFailToast);
        }
        int i = adCouponReceiveParam.flowType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "flowType", i);
        }
        return jSONObject;
    }
}
