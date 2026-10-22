package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lu implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.f.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.f.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.f.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Xv = jSONObject.optString("areaCode");
        if (JSONObject.NULL.toString().equals(bVar.Xv)) {
            bVar.Xv = "";
        }
        bVar.Xw = jSONObject.optLong("pendantResourceId");
        bVar.Xx = jSONObject.optString("pendantCode");
        if (JSONObject.NULL.toString().equals(bVar.Xx)) {
            bVar.Xx = "";
        }
        bVar.action = jSONObject.optInt("action");
        bVar.Xy = jSONObject.optString("eventData");
        if (JSONObject.NULL.toString().equals(bVar.Xy)) {
            bVar.Xy = "";
        }
        bVar.XA = jSONObject.optBoolean("needServerProcess");
        bVar.XB = jSONObject.optBoolean("needBusinessHandle");
        bVar.XC = jSONObject.optString("callbackApi");
        if (JSONObject.NULL.toString().equals(bVar.XC)) {
            bVar.XC = "";
        }
        bVar.XD = jSONObject.optBoolean("needRandomCall");
        bVar.XE = jSONObject.optLong("randomRangeMillis");
        bVar.XF = jSONObject.optBoolean("needSignalFallback");
        bVar.XG = jSONObject.optString("callbackPath");
        if (JSONObject.NULL.toString().equals(bVar.XG)) {
            bVar.XG = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.Xv;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "areaCode", bVar.Xv);
        }
        long j = bVar.Xw;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pendantResourceId", j);
        }
        String str2 = bVar.Xx;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pendantCode", bVar.Xx);
        }
        int i = bVar.action;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "action", i);
        }
        String str3 = bVar.Xy;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "eventData", bVar.Xy);
        }
        boolean z = bVar.XA;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needServerProcess", z);
        }
        boolean z2 = bVar.XB;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needBusinessHandle", z2);
        }
        String str4 = bVar.XC;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callbackApi", bVar.XC);
        }
        boolean z3 = bVar.XD;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needRandomCall", z3);
        }
        long j2 = bVar.XE;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "randomRangeMillis", j2);
        }
        boolean z4 = bVar.XF;
        if (z4) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needSignalFallback", z4);
        }
        String str5 = bVar.XG;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callbackPath", bVar.XG);
        }
        return jSONObject;
    }
}
