package com.kwad.sdk.core.b.a;

import com.ali.auth.third.login.LoginConstants;
import com.kwad.components.core.request.InnerEcLocalLoginInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gq implements com.kwad.sdk.core.d<InnerEcLocalLoginInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InnerEcLocalLoginInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InnerEcLocalLoginInfo) bVar, jSONObject);
    }

    private static void a(InnerEcLocalLoginInfo innerEcLocalLoginInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        innerEcLocalLoginInfo.userId = jSONObject.optLong("userId");
        innerEcLocalLoginInfo.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(innerEcLocalLoginInfo.serviceToken)) {
            innerEcLocalLoginInfo.serviceToken = "";
        }
        innerEcLocalLoginInfo.expire = jSONObject.optLong("expire");
        innerEcLocalLoginInfo.sid = jSONObject.optString(LoginConstants.SID);
        if (JSONObject.NULL.toString().equals(innerEcLocalLoginInfo.sid)) {
            innerEcLocalLoginInfo.sid = "";
        }
    }

    private static JSONObject b(InnerEcLocalLoginInfo innerEcLocalLoginInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = innerEcLocalLoginInfo.userId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userId", j);
        }
        String str = innerEcLocalLoginInfo.serviceToken;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serviceToken", innerEcLocalLoginInfo.serviceToken);
        }
        long j2 = innerEcLocalLoginInfo.expire;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expire", j2);
        }
        String str2 = innerEcLocalLoginInfo.sid;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, LoginConstants.SID, innerEcLocalLoginInfo.sid);
        }
        return jSONObject;
    }
}
