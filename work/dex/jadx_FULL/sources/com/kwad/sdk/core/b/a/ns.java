package com.kwad.sdk.core.b.a;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ns implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.aj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.aj.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.aj.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.aqE = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.aqF = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.aqF)) {
            aVar.aqF = "";
        }
        aVar.icon = jSONObject.optString(RemoteMessageConst.Notification.ICON);
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.tU = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(aVar.tU)) {
            aVar.tU = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.aqG = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.aqG)) {
            aVar.aqG = "";
        }
        aVar.aqH = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.aqI = jSONObject.optBoolean("isLandscapeSupported");
        aVar.aqJ = jSONObject.optBoolean("isFromLive");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", aVar.version);
        }
        int i2 = aVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "versionCode", i2);
        }
        int i3 = aVar.aqE;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appSize", i3);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.aqF;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appLink", aVar.aqF);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, RemoteMessageConst.Notification.ICON, aVar.icon);
        }
        String str8 = aVar.tU;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "desc", aVar.tU);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", aVar.appId);
        }
        String str10 = aVar.aqG;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "marketUri", aVar.aqG);
        }
        boolean z = aVar.aqH;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = aVar.aqI;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = aVar.aqJ;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }
}
