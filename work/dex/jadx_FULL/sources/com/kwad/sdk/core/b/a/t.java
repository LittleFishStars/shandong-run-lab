package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class t implements com.kwad.sdk.core.d<AdInfo.AdDrawInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdDrawInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdDrawInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDrawInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        AdInfo.AdLiveTypeInfo adLiveTypeInfo = new AdInfo.AdLiveTypeInfo();
        adDrawInfo.liveTypeInfo = adLiveTypeInfo;
        adLiveTypeInfo.parseJson(jSONObject.optJSONObject("liveTypeInfo"));
    }

    private static JSONObject b(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adDrawInfo.videoSoundType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoSoundType", i);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "liveTypeInfo", adDrawInfo.liveTypeInfo);
        return jSONObject;
    }
}
