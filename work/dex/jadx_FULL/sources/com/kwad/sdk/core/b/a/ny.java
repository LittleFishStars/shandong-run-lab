package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ny implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.d.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aop = jSONObject.optLong("start_play_duration_ms");
        bVar.aoq = jSONObject.optLong("first_frame_duration_ms");
        bVar.aor = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.anU = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong("creative_id");
        bVar.authorId = jSONObject.optLong("ad_info_uid");
        bVar.aon = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(bVar.aon)) {
            bVar.aon = "";
        }
        bVar.adStyle = jSONObject.optInt("ad_style");
        bVar.aoo = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(com.kwad.components.core.video.a.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.aop;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "start_play_duration_ms", j);
        }
        long j2 = bVar.aoq;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "first_frame_duration_ms", j2);
        }
        long j3 = bVar.aor;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "block_total_duration_ms", j3);
        }
        long j4 = bVar.videoDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "video_duration_ms", j4);
        }
        int i = bVar.anU;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "block_times", i);
        }
        String str = bVar.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        long j5 = bVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "llsid", j5);
        }
        long j6 = bVar.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", j6);
        }
        long j7 = bVar.authorId;
        if (j7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_uid", j7);
        }
        String str2 = bVar.aon;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_info_user_name", bVar.aon);
        }
        int i2 = bVar.adStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", i2);
        }
        int i3 = bVar.aoo;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_media_player_type", i3);
        }
        return jSONObject;
    }
}
