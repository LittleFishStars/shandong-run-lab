package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdBannerInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdBannerInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBannerInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adBannerInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
        adBannerInfo.isSupportCarousel = jSONObject.optBoolean("isSupportCarousel");
    }

    private static JSONObject b(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adBannerInfo.videoSoundType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoSoundType", i);
        }
        int i2 = adBannerInfo.videoAutoPlayType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoAutoPlayType", i2);
        }
        boolean z = adBannerInfo.isSupportCarousel;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isSupportCarousel", z);
        }
        return jSONObject;
    }
}
