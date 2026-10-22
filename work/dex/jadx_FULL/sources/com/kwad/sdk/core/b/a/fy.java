package com.kwad.sdk.core.b.a;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fy implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.H5Config) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.H5Config) bVar, jSONObject);
    }

    private static void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        h5Config.tagTip = jSONObject.optString("tagTip");
        if (JSONObject.NULL.toString().equals(h5Config.tagTip)) {
            h5Config.tagTip = "";
        }
        h5Config.aggregateMiddlePageShowPathSwitch = jSONObject.optBoolean("aggregateMiddlePageShowPathSwitch");
        h5Config.deeplinkOptimizeSwitch = jSONObject.optBoolean("deepLinkEvokeOpt", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
    }

    private static JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = h5Config.apiMisTouch;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiMisTouch", i);
        }
        int i2 = h5Config.apiAdTag;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiAdTag", i2);
        }
        int i3 = h5Config.apiBreathLamp;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apiBreathLamp", i3);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        boolean z = h5Config.aggregateMiddlePageShowPathSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregateMiddlePageShowPathSwitch", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "deepLinkEvokeOpt", h5Config.deeplinkOptimizeSwitch);
        return jSONObject;
    }
}
