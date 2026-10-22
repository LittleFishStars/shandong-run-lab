package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ih implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ba.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ba.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ba.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayWatchingUserCount)) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayLikeUserCount)) {
            aVar.displayLikeUserCount = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        long j = aVar.totalWatchingDuration;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalWatchingDuration", j);
        }
        int i2 = aVar.watchingUserCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "watchingUserCount", i2);
        }
        String str = aVar.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        long j2 = aVar.liveDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveDuration", j2);
        }
        int i3 = aVar.likeUserCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "likeUserCount", i3);
        }
        String str2 = aVar.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }
}
