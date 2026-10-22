package com.kwad.sdk.core.b.a;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bm implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.au.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.au.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.au.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.au.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(bVar.appName)) {
            bVar.appName = "";
        }
        bVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(bVar.pkgName)) {
            bVar.pkgName = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.aro = jSONObject.optLong("appSize");
        bVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (JSONObject.NULL.toString().equals(bVar.md5)) {
            bVar.md5 = "";
        }
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString(RemoteMessageConst.Notification.ICON);
        if (JSONObject.NULL.toString().equals(bVar.icon)) {
            bVar.icon = "";
        }
        bVar.tU = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(bVar.tU)) {
            bVar.tU = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.au.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", bVar.appName);
        }
        String str2 = bVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pkgName", bVar.pkgName);
        }
        String str3 = bVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", bVar.version);
        }
        int i = bVar.versionCode;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "versionCode", i);
        }
        long j = bVar.aro;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appSize", j);
        }
        String str4 = bVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, bVar.md5);
        }
        String str5 = bVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", bVar.url);
        }
        String str6 = bVar.icon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, RemoteMessageConst.Notification.ICON, bVar.icon);
        }
        String str7 = bVar.tU;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "desc", bVar.tU);
        }
        return jSONObject;
    }
}
