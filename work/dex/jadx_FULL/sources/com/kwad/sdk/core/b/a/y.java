package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdCouponReceiveParam;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class y implements com.kwad.sdk.core.d<AdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo) bVar, jSONObject);
    }

    private static void a(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.AdBaseInfo adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo = adBaseInfo;
        adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        AdInfo.AdvertiserInfo advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo = advertiserInfo;
        advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        AdInfo.AdConversionInfo adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo = adConversionInfo;
        adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        AdInfo.AdMaterialInfo adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo = adMaterialInfo;
        adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo = downloadSafeInfo;
        downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        AdInfo.UnDownloadConf unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf = unDownloadConf;
        unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        AdCouponReceiveParam adCouponReceiveParam = new AdCouponReceiveParam();
        adInfo.adCouponReceiveParam = adCouponReceiveParam;
        adCouponReceiveParam.parseJson(jSONObject.optJSONObject("adCouponReceiveParam"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt("progress");
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong("totalBytes");
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        if (JSONObject.NULL.toString().equals(adInfo.downloadFilePath)) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (JSONObject.NULL.toString().equals(adInfo.downloadId)) {
            adInfo.downloadId = "";
        }
        adInfo.mStartDownloadTime = jSONObject.optLong("mStartDownloadTime");
        adInfo.isAllowVideoAutoPlay = jSONObject.optBoolean("isAllowVideoAutoPlay");
        adInfo.convertCount = jSONObject.optInt("convertCount");
        adInfo.ksUaPattern = jSONObject.optBoolean("ksUaPattern");
        adInfo.unionMark = jSONObject.optBoolean("unionMark");
        AdInfo.AdPreloadInfo adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo = adPreloadInfo;
        adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        AdInfo.AdSplashInfo adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo = adSplashInfo;
        adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        AdInfo.AdBannerInfo adBannerInfo = new AdInfo.AdBannerInfo();
        adInfo.adBannerInfo = adBannerInfo;
        adBannerInfo.parseJson(jSONObject.optJSONObject("adBannerInfo"));
        AdInfo.AdDrawInfo adDrawInfo = new AdInfo.AdDrawInfo();
        adInfo.adDrawInfo = adDrawInfo;
        adDrawInfo.parseJson(jSONObject.optJSONObject("adDrawInfo"));
        AdStyleInfo adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo = adStyleInfo;
        adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        AdStyleInfo adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2 = adStyleInfo2;
        adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        AdInfo.AdAggregateInfo adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo = adAggregateInfo;
        adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        AdInfo.AdRewardInfo adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo = adRewardInfo;
        adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        adInfo.serverExt = jSONObject.optString("serverExt");
        if (JSONObject.NULL.toString().equals(adInfo.serverExt)) {
            adInfo.serverExt = "";
        }
        AdInfo.AdStyleConfInfo adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo = adStyleConfInfo;
        adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        AdInfo.FullScreenVideoInfo fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo = fullScreenVideoInfo;
        fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        AdInfo.AdFeedInfo adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo = adFeedInfo;
        adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        AdInfo.AdInsertScreenInfo adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo = adInsertScreenInfo;
        adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        AdProductInfo adProductInfo = new AdProductInfo();
        adInfo.adProductInfo = adProductInfo;
        adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        AdMatrixInfo adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo = adMatrixInfo;
        adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
        adInfo.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(adInfo.trace)) {
            adInfo.trace = "";
        }
    }

    private static JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.ac.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        com.kwad.sdk.utils.ac.a(jSONObject, "adCouponReceiveParam", adInfo.adCouponReceiveParam);
        int i = adInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        int i2 = adInfo.progress;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "progress", i2);
        }
        long j = adInfo.soFarBytes;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soFarBytes", j);
        }
        long j2 = adInfo.totalBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalBytes", j2);
        }
        String str = adInfo.downloadFilePath;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        }
        String str2 = adInfo.downloadId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadId", adInfo.downloadId);
        }
        long j3 = adInfo.mStartDownloadTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mStartDownloadTime", j3);
        }
        boolean z = adInfo.isAllowVideoAutoPlay;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isAllowVideoAutoPlay", z);
        }
        int i3 = adInfo.convertCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convertCount", i3);
        }
        boolean z2 = adInfo.ksUaPattern;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ksUaPattern", z2);
        }
        boolean z3 = adInfo.unionMark;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "unionMark", z3);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adBannerInfo", adInfo.adBannerInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adDrawInfo", adInfo.adDrawInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        com.kwad.sdk.utils.ac.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        String str3 = adInfo.serverExt;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serverExt", adInfo.serverExt);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        int i4 = adInfo.ocpcActionType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ocpcActionType", i4);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        String str4 = adInfo.trace;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "trace", adInfo.trace);
        }
        return jSONObject;
    }
}
