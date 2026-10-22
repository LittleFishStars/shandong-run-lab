package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ew implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.bfw = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.bfw)) {
            bVar.bfw = "";
        }
        bVar.bfx = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.bfx)) {
            bVar.bfx = "";
        }
        bVar.bfy = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.bfy)) {
            bVar.bfy = "";
        }
        bVar.bfz = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bfz)) {
            bVar.bfz = "";
        }
        bVar.bfA = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bfA)) {
            bVar.bfA = "";
        }
        bVar.bfB = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.bfB)) {
            bVar.bfB = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", bVar.appId);
        }
        String str2 = bVar.bfw;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pluginListenerName", bVar.bfw);
        }
        String str3 = bVar.bfx;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reportMethodName", bVar.bfx);
        }
        String str4 = bVar.bfy;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "otherProxyClassName", bVar.bfy);
        }
        String str5 = bVar.bfz;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "otherFieldName", bVar.bfz);
        }
        String str6 = bVar.bfA;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "otherLevelFieldName", bVar.bfA);
        }
        String str7 = bVar.bfB;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blockTag", bVar.bfB);
        }
        return jSONObject;
    }
}
