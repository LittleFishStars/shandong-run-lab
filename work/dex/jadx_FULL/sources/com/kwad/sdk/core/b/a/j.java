package com.kwad.sdk.core.b.a;

import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdBaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdBaseInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(adBaseInfo.liveStreamId)) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.roiType = jSONObject.optInt("roiType");
        adBaseInfo.liveDisplayWatchingCount = jSONObject.optLong("liveDisplayWatchingCount");
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(adBaseInfo.sdkExtraData)) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adDescription)) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (JSONObject.NULL.toString().equals(adBaseInfo.installAppLabel)) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (JSONObject.NULL.toString().equals(adBaseInfo.openAppLabel)) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adMarkIcon)) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adGrayMarkIcon)) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adSourceDescription)) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adActionDescription)) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adActionBarColor)) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appName)) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.realAppName = jSONObject.optString("realAppName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.realAppName)) {
            adBaseInfo.realAppName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appIconUrl)) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appPackageName)) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appDownloadCountDesc)) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appCategory)) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appVersion)) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.corporationName)) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                adBaseInfo.appImageUrl.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appDescription)) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.adRolloutSize = jSONObject.optInt("adRolloutSize");
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (JSONObject.NULL.toString().equals(adBaseInfo.videoPlayedNS)) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.videoPlayedNSConfig = jSONObject.optString("videoPlayedNSConfig");
        if (JSONObject.NULL.toString().equals(adBaseInfo.videoPlayedNSConfig)) {
            adBaseInfo.videoPlayedNSConfig = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.productName)) {
            adBaseInfo.productName = "";
        }
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.showUrl)) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString("clickUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.clickUrl)) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.convUrl)) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt(CollegeTownItemFragment.ITEM_TYPE);
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
        adBaseInfo.isClosure = jSONObject.optBoolean("isClosure");
    }

    private static JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adBaseInfo.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", j);
        }
        int i = adBaseInfo.adSourceType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adSourceType", i);
        }
        String str = adBaseInfo.liveStreamId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamId", adBaseInfo.liveStreamId);
        }
        int i2 = adBaseInfo.roiType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "roiType", i2);
        }
        long j2 = adBaseInfo.liveDisplayWatchingCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveDisplayWatchingCount", j2);
        }
        int i3 = adBaseInfo.universeLiveType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "universeLiveType", i3);
        }
        long j3 = adBaseInfo.viewCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "viewCount", j3);
        }
        String str2 = adBaseInfo.sdkExtraData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        String str3 = adBaseInfo.adDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        String str4 = adBaseInfo.installAppLabel;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        String str5 = adBaseInfo.openAppLabel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        String str6 = adBaseInfo.adMarkIcon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        String str7 = adBaseInfo.adGrayMarkIcon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        String str8 = adBaseInfo.adSourceDescription;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        int i4 = adBaseInfo.adOperationType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adOperationType", i4);
        }
        String str9 = adBaseInfo.adActionDescription;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        String str10 = adBaseInfo.adActionBarColor;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        int i5 = adBaseInfo.adShowDuration;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adShowDuration", i5);
        }
        String str11 = adBaseInfo.appName;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", adBaseInfo.appName);
        }
        String str12 = adBaseInfo.realAppName;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realAppName", adBaseInfo.realAppName);
        }
        String str13 = adBaseInfo.appIconUrl;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        String str14 = adBaseInfo.appPackageName;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        int i6 = adBaseInfo.appScore;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appScore", i6);
        }
        String str15 = adBaseInfo.appDownloadCountDesc;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        String str16 = adBaseInfo.appCategory;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        String str17 = adBaseInfo.appVersion;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        String str18 = adBaseInfo.corporationName;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        long j4 = adBaseInfo.packageSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageSize", j4);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.ac.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        String str19 = adBaseInfo.appDescription;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        int i7 = adBaseInfo.enableSkipAd;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableSkipAd", i7);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        int i8 = adBaseInfo.adRolloutSize;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adRolloutSize", i8);
        }
        int i9 = adBaseInfo.skipSecond;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "skipSecond", i9);
        }
        int i10 = adBaseInfo.ecpm;
        if (i10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ecpm", i10);
        }
        String str20 = adBaseInfo.videoPlayedNS;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        String str21 = adBaseInfo.videoPlayedNSConfig;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoPlayedNSConfig", adBaseInfo.videoPlayedNSConfig);
        }
        String str22 = adBaseInfo.productName;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        String str23 = adBaseInfo.showUrl;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        String str24 = adBaseInfo.clickUrl;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickUrl", adBaseInfo.clickUrl);
        }
        String str25 = adBaseInfo.convUrl;
        if (str25 != null && !str25.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        int i11 = adBaseInfo.adAttributeType;
        if (i11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adAttributeType", i11);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        int i12 = adBaseInfo.taskType;
        if (i12 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "taskType", i12);
        }
        int i13 = adBaseInfo.campaignType;
        if (i13 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "campaignType", i13);
        }
        int i14 = adBaseInfo.itemType;
        if (i14 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, CollegeTownItemFragment.ITEM_TYPE, i14);
        }
        int i15 = adBaseInfo.industryFirstLevelId;
        if (i15 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "industryFirstLevelId", i15);
        }
        boolean z = adBaseInfo.extraClickReward;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "extraClickReward", z);
        }
        boolean z2 = adBaseInfo.enableClientProofreadTime;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableClientProofreadTime", z2);
        }
        boolean z3 = adBaseInfo.isClosure;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isClosure", z3);
        }
        return jSONObject;
    }
}
