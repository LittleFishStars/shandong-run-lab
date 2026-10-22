package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nu implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aXy = jSONObject.optString("thirdUserId");
        if (JSONObject.NULL.toString().equals(gVar.aXy)) {
            gVar.aXy = "";
        }
        gVar.aXz = jSONObject.optString("thirdUserName");
        if (JSONObject.NULL.toString().equals(gVar.aXz)) {
            gVar.aXz = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
        gVar.aXA = jSONObject.optString("authCode");
        if (JSONObject.NULL.toString().equals(gVar.aXA)) {
            gVar.aXA = "";
        }
        gVar.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(gVar.serviceToken)) {
            gVar.serviceToken = "";
        }
        gVar.aXB = jSONObject.optString("authAppId");
        if (JSONObject.NULL.toString().equals(gVar.aXB)) {
            gVar.aXB = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.aXy;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdUserId", gVar.aXy);
        }
        String str2 = gVar.aXz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdUserName", gVar.aXz);
        }
        int i = gVar.thirdAge;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = gVar.thirdGender;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdGender", i2);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        String str4 = gVar.aXA;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authCode", gVar.aXA);
        }
        String str5 = gVar.serviceToken;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serviceToken", gVar.serviceToken);
        }
        String str6 = gVar.aXB;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authAppId", gVar.aXB);
        }
        return jSONObject;
    }
}
