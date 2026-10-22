package com.kwad.sdk.core.b.a;

import com.kwad.sdk.monitor.MediaMessageInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class is implements com.kwad.sdk.core.d<MediaMessageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((MediaMessageInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((MediaMessageInfo) bVar, jSONObject);
    }

    private static void a(MediaMessageInfo mediaMessageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mediaMessageInfo.Nq = jSONObject.optString("device_brand");
        if (JSONObject.NULL.toString().equals(mediaMessageInfo.Nq)) {
            mediaMessageInfo.Nq = "";
        }
        mediaMessageInfo.bjd = jSONObject.optString("permission_list");
        if (JSONObject.NULL.toString().equals(mediaMessageInfo.bjd)) {
            mediaMessageInfo.bjd = "";
        }
        mediaMessageInfo.bje = jSONObject.optString("appid");
        if (JSONObject.NULL.toString().equals(mediaMessageInfo.bje)) {
            mediaMessageInfo.bje = "";
        }
        mediaMessageInfo.bjf = jSONObject.optInt("device_os_id");
    }

    private static JSONObject b(MediaMessageInfo mediaMessageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = mediaMessageInfo.Nq;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_brand", mediaMessageInfo.Nq);
        }
        String str2 = mediaMessageInfo.bjd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "permission_list", mediaMessageInfo.bjd);
        }
        String str3 = mediaMessageInfo.bje;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appid", mediaMessageInfo.bje);
        }
        int i = mediaMessageInfo.bjf;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_os_id", i);
        }
        return jSONObject;
    }
}
