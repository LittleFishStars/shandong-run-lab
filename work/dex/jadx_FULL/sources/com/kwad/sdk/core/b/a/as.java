package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class as implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdSplashInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdSplashInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt(com.alibaba.ariver.jsapi.multimedia.video.a.f, new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        if (JSONObject.NULL.toString().equals(adSplashInfo.skipTips)) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (JSONObject.NULL.toString().equals(adSplashInfo.speakerMuteIconUrl)) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (JSONObject.NULL.toString().equals(adSplashInfo.speakerIconUrl)) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.impressionStatisticalChangeSwitch = jSONObject.optBoolean("impressionStatisticalChangeSwitch");
        adSplashInfo.impressionLimitSize = jSONObject.optDouble("impressionLimitSize");
        AdInfo.CutRuleInfo cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo = cutRuleInfo;
        cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    private static JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.ac.putValue(jSONObject, com.alibaba.ariver.jsapi.multimedia.video.a.f, adSplashInfo.mute);
        int i = adSplashInfo.skipType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "skipType", i);
        }
        String str = adSplashInfo.skipTips;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        String str2 = adSplashInfo.speakerMuteIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        String str3 = adSplashInfo.speakerIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        int i2 = adSplashInfo.countdownShow;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "countdownShow", i2);
        }
        int i3 = adSplashInfo.fullScreenClickSwitch;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fullScreenClickSwitch", i3);
        }
        int i4 = adSplashInfo.skipButtonPosition;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "skipButtonPosition", i4);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        int i5 = adSplashInfo.skipSecond;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "skipSecond", i5);
        }
        boolean z = adSplashInfo.impressionStatisticalChangeSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "impressionStatisticalChangeSwitch", z);
        }
        double d = adSplashInfo.impressionLimitSize;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "impressionLimitSize", d);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject;
    }
}
