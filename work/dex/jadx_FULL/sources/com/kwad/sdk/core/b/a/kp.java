package com.kwad.sdk.core.b.a;

import com.ali.auth.third.login.LoginConstants;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class kp implements com.kwad.sdk.core.d<AdGlobalConfigInfo.RefreshToken> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo.RefreshToken) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo.RefreshToken) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo.RefreshToken refreshToken, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        refreshToken.userId = jSONObject.optLong("userId");
        refreshToken.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(refreshToken.serviceToken)) {
            refreshToken.serviceToken = "";
        }
        refreshToken.userName = jSONObject.optString("userName");
        if (JSONObject.NULL.toString().equals(refreshToken.userName)) {
            refreshToken.userName = "";
        }
        refreshToken.expire = jSONObject.optLong("expire");
        refreshToken.sid = jSONObject.optString(LoginConstants.SID);
        if (JSONObject.NULL.toString().equals(refreshToken.sid)) {
            refreshToken.sid = "";
        }
    }

    private static JSONObject b(AdGlobalConfigInfo.RefreshToken refreshToken, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = refreshToken.userId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userId", j);
        }
        String str = refreshToken.serviceToken;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serviceToken", refreshToken.serviceToken);
        }
        String str2 = refreshToken.userName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userName", refreshToken.userName);
        }
        long j2 = refreshToken.expire;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expire", j2);
        }
        String str3 = refreshToken.sid;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, LoginConstants.SID, refreshToken.sid);
        }
        return jSONObject;
    }
}
