package com.kwad.sdk.core.b.a;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ef implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.DownloadSafeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.DownloadSafeInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.permissionInfo)) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appName)) {
            downloadSafeInfo.appName = "";
        }
        downloadSafeInfo.corporationName = jSONObject.optString("corporationName");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.corporationName)) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        downloadSafeInfo.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appVersion)) {
            downloadSafeInfo.appVersion = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appPrivacyUrl)) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appPermissionInfoUrl)) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.introductionInfo = jSONObject.optString("introductionInfo");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.introductionInfo)) {
            downloadSafeInfo.introductionInfo = "";
        }
        downloadSafeInfo.introductionInfoUrl = jSONObject.optString("introductionInfoUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.introductionInfoUrl)) {
            downloadSafeInfo.introductionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.windowPopUrl)) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.webPageTipbarText)) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.autoDownloadUrl)) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        AdInfo.ComplianceInfo complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo = complianceInfo;
        complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
        downloadSafeInfo.recordNumber = jSONObject.optString("recordNumber");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.recordNumber)) {
            downloadSafeInfo.recordNumber = "";
        }
    }

    private static JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadSafeInfo.permissionInfo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        String str2 = downloadSafeInfo.appName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", downloadSafeInfo.appName);
        }
        String str3 = downloadSafeInfo.corporationName;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "corporationName", downloadSafeInfo.corporationName);
        }
        long j = downloadSafeInfo.packageSize;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageSize", j);
        }
        String str4 = downloadSafeInfo.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appVersion", downloadSafeInfo.appVersion);
        }
        String str5 = downloadSafeInfo.appPrivacyUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        String str6 = downloadSafeInfo.appPermissionInfoUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        String str7 = downloadSafeInfo.introductionInfo;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "introductionInfo", downloadSafeInfo.introductionInfo);
        }
        String str8 = downloadSafeInfo.introductionInfoUrl;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "introductionInfoUrl", downloadSafeInfo.introductionInfoUrl);
        }
        boolean z = downloadSafeInfo.secWindowPopNoWifiSwitch;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "secWindowPopNoWifiSwitch", z);
        }
        boolean z2 = downloadSafeInfo.secWindowPopSwitch;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "secWindowPopSwitch", z2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        String str9 = downloadSafeInfo.windowPopUrl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        String str10 = downloadSafeInfo.webPageTipbarText;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        String str11 = downloadSafeInfo.autoDownloadUrl;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        String str12 = downloadSafeInfo.recordNumber;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "recordNumber", downloadSafeInfo.recordNumber);
        }
        return jSONObject;
    }
}
