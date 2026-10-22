package com.kwad.sdk.core.b.a;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class er implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.beD = jSONObject.optInt("funcSwitch");
        bVar.beE = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.beE)) {
            bVar.beE = "";
        }
        bVar.beF = jSONObject.optString("maxSdkVersionExclude");
        if (JSONObject.NULL.toString().equals(bVar.beF)) {
            bVar.beF = "";
        }
        bVar.sdkType = jSONObject.optInt(UserTrackConstant.SDK_TYPE);
        bVar.beG = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.beG)) {
            bVar.beG = "";
        }
        bVar.beH = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.beH)) {
            bVar.beH = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.beI = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.beI)) {
            bVar.beI = "";
        }
        bVar.beJ = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.beJ)) {
            bVar.beJ = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.beD;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "funcSwitch", i);
        }
        String str = bVar.beE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "minSdkVersion", bVar.beE);
        }
        String str2 = bVar.beF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxSdkVersionExclude", bVar.beF);
        }
        int i2 = bVar.sdkType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, UserTrackConstant.SDK_TYPE, i2);
        }
        String str3 = bVar.beG;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "md5V7", bVar.beG);
        }
        String str4 = bVar.beH;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "md5V8", bVar.beH);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.beI;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "v7Url", bVar.beI);
        }
        String str7 = bVar.beJ;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "v8Url", bVar.beJ);
        }
        return jSONObject;
    }
}
