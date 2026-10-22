package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class au implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdStyleConfInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdStyleConfInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        AdInfo.SlideConvertInfo slideConvertInfo = new AdInfo.SlideConvertInfo();
        adStyleConfInfo.slideConvertInfo = slideConvertInfo;
        slideConvertInfo.parseJson(jSONObject.optJSONObject("slideConvertInfo"));
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        AdInfo.AdShowVideoH5Info adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info = adShowVideoH5Info;
        adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = jSONObject.optInt("adPushIntervalTime", new Integer("900").intValue());
        AdInfo.NativeAdInfo nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo = nativeAdInfo;
        nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
        adStyleConfInfo.adPushDownloadJumpType = jSONObject.optInt("adPushDownloadJumpType");
        adStyleConfInfo.actionBarType = jSONObject.optInt("actionBarType");
        adStyleConfInfo.endCardType = jSONObject.optInt("endCardType");
        adStyleConfInfo.confirmCardType = jSONObject.optInt("confirmCardType");
        adStyleConfInfo.innerAdType = jSONObject.optInt("innerAdType");
    }

    private static JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j = adStyleConfInfo.closeDelaySeconds;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "closeDelaySeconds", j);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "slideConvertInfo", adStyleConfInfo.slideConvertInfo);
        long j2 = adStyleConfInfo.playableCloseSeconds;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableCloseSeconds", j2);
        }
        boolean z = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardVideoInteractSwitch", z);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z2 = adStyleConfInfo.adPushSwitch;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adPushSwitch", z2);
        }
        int i = adStyleConfInfo.adPushShowAfterTime;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adPushShowAfterTime", i);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.ac.a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z3 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "useNativeForOuterLiveAd", z3);
        }
        int i2 = adStyleConfInfo.adPushDownloadJumpType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adPushDownloadJumpType", i2);
        }
        int i3 = adStyleConfInfo.actionBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = adStyleConfInfo.endCardType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "endCardType", i4);
        }
        int i5 = adStyleConfInfo.confirmCardType;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "confirmCardType", i5);
        }
        int i6 = adStyleConfInfo.innerAdType;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "innerAdType", i6);
        }
        return jSONObject;
    }
}
