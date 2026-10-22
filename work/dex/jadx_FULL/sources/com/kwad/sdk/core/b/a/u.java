package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class u implements com.kwad.sdk.core.d<AdInfo.AdFeedInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdFeedInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdFeedInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adFeedInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adFeedInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
    }

    private static JSONObject b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adFeedInfo.videoSoundType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoSoundType", i);
        }
        int i2 = adFeedInfo.videoAutoPlayType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoAutoPlayType", i2);
        }
        return jSONObject;
    }
}
