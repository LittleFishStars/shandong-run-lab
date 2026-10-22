package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jt implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bgG = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(bVar.bgG)) {
            bVar.bgG = "";
        }
        bVar.bgH = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(bVar.bgH)) {
            bVar.bgH = "";
        }
        bVar.bgI = jSONObject.optString("zipPath");
        if (JSONObject.NULL.toString().equals(bVar.bgI)) {
            bVar.bgI = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aEX = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(bVar.aEX)) {
            bVar.aEX = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.bgK = jSONObject.optBoolean("public");
    }

    private static JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.bgG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageId", bVar.bgG);
        }
        String str2 = bVar.bgH;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "zipFileName", bVar.bgH);
        }
        String str3 = bVar.bgI;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "zipPath", bVar.bgI);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.aEX;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "checksum", bVar.aEX);
        }
        int i = bVar.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "loadType", i);
        }
        int i2 = bVar.packageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageType", i2);
        }
        boolean z = bVar.bgK;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "public", z);
        }
        return jSONObject;
    }
}
