package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ey implements com.kwad.sdk.core.d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedErrorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedErrorInfo) bVar, jSONObject);
    }

    private static void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
        feedErrorInfo.errorType = jSONObject.optLong("error_type");
    }

    private static JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = feedErrorInfo.materialType;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", j);
        }
        long j2 = feedErrorInfo.width;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", j2);
        }
        long j3 = feedErrorInfo.feedType;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "feed_type", j3);
        }
        long j4 = feedErrorInfo.errorType;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_type", j4);
        }
        return jSONObject;
    }
}
