package com.kwad.sdk.core.b.a;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kc.openset.advertisers.hl.HLADNID;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdConversionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdConversionInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString(ALPParamConstant.H5URL);
        if (JSONObject.NULL.toString().equals(adConversionInfo.h5Url)) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkUrl)) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkExtra)) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.adExt = jSONObject.optString("adExt");
        if (JSONObject.NULL.toString().equals(adConversionInfo.adExt)) {
            adConversionInfo.adExt = "";
        }
        adConversionInfo.appSecondConfirmationSwitch = jSONObject.optBoolean("appSecondConfirmationSwitch");
        adConversionInfo.h5SecondConfirmationSwitch = jSONObject.optBoolean("h5SecondConfirmationSwitch");
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.appDownloadUrl)) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.marketUrl)) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.playableUrl)) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.liveServiceToken = jSONObject.optString("liveServiceToken");
        if (JSONObject.NULL.toString().equals(adConversionInfo.liveServiceToken)) {
            adConversionInfo.liveServiceToken = "";
        }
        adConversionInfo.liveVisitorId = jSONObject.optLong("liveVisitorId");
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo = smallAppJumpInfo;
        smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrl)) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrlInfo)) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.interceptH5JumpAppMkt = jSONObject.optBoolean("interceptH5JumpAppMkt");
        adConversionInfo.interceptH5JumpTimeOut = jSONObject.optInt("interceptH5JumpTimeOut", new Integer(HLADNID.Reason.OTHER).intValue());
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long("3000").longValue());
    }

    private static JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ALPParamConstant.H5URL, adConversionInfo.h5Url);
        }
        int i = adConversionInfo.h5Type;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "h5Type", i);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        String str3 = adConversionInfo.deeplinkExtra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        String str4 = adConversionInfo.adExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adExt", adConversionInfo.adExt);
        }
        boolean z = adConversionInfo.appSecondConfirmationSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appSecondConfirmationSwitch", z);
        }
        boolean z2 = adConversionInfo.h5SecondConfirmationSwitch;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "h5SecondConfirmationSwitch", z2);
        }
        String str5 = adConversionInfo.appDownloadUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str6 = adConversionInfo.marketUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        }
        int i2 = adConversionInfo.supportThirdDownload;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "supportThirdDownload", i2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str7 = adConversionInfo.playableUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        String str8 = adConversionInfo.liveServiceToken;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveServiceToken", adConversionInfo.liveServiceToken);
        }
        long j = adConversionInfo.liveVisitorId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveVisitorId", j);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        int i3 = adConversionInfo.webUriSourceType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "webUriSourceType", i3);
        }
        String str9 = adConversionInfo.callbackUrl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str10 = adConversionInfo.callbackUrlInfo;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z3 = adConversionInfo.blockCallbackIfSpam;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blockCallbackIfSpam", z3);
        }
        boolean z4 = adConversionInfo.needDeeplinkReplaceAdapta;
        if (z4) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needDeeplinkReplaceAdapta", z4);
        }
        boolean z5 = adConversionInfo.interceptH5JumpAppMkt;
        if (z5) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interceptH5JumpAppMkt", z5);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "interceptH5JumpTimeOut", adConversionInfo.interceptH5JumpTimeOut);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        boolean z6 = adConversionInfo.isSupportKeepPlaying;
        if (z6) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isSupportKeepPlaying", z6);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
        return jSONObject;
    }
}
