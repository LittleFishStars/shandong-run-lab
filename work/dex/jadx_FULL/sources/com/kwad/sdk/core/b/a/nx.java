package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nx implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.d.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.d.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.creativeId = jSONObject.optLong("creative_id");
        aVar.authorId = jSONObject.optLong("ad_info_uid");
        aVar.aon = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(aVar.aon)) {
            aVar.aon = "";
        }
        aVar.aoo = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(com.kwad.components.core.video.a.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.code;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "code", i);
        }
        String str = aVar.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "msg", aVar.msg);
        }
        String str2 = aVar.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "video_url", aVar.videoUrl);
        }
        long j = aVar.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "llsid", j);
        }
        long j2 = aVar.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", j2);
        }
        long j3 = aVar.authorId;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_uid", j3);
        }
        String str3 = aVar.aon;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_user_name", aVar.aon);
        }
        int i2 = aVar.aoo;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_media_player_type", i2);
        }
        return jSONObject;
    }
}
