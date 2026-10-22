package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.LiveInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dm implements com.kwad.sdk.core.d<LiveInfo.CoverThumbnailUrl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.CoverThumbnailUrl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.CoverThumbnailUrl) bVar, jSONObject);
    }

    private static void a(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverThumbnailUrl.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(coverThumbnailUrl.cdn)) {
            coverThumbnailUrl.cdn = "";
        }
        coverThumbnailUrl.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(coverThumbnailUrl.url)) {
            coverThumbnailUrl.url = "";
        }
        coverThumbnailUrl.urlPattern = jSONObject.optString("urlPattern");
        if (JSONObject.NULL.toString().equals(coverThumbnailUrl.urlPattern)) {
            coverThumbnailUrl.urlPattern = "";
        }
    }

    private static JSONObject b(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = coverThumbnailUrl.cdn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cdn", coverThumbnailUrl.cdn);
        }
        String str2 = coverThumbnailUrl.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", coverThumbnailUrl.url);
        }
        String str3 = coverThumbnailUrl.urlPattern;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "urlPattern", coverThumbnailUrl.urlPattern);
        }
        return jSONObject;
    }
}
