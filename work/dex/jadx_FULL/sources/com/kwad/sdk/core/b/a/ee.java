package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ee implements com.kwad.sdk.core.d<DownloadParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((DownloadParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((DownloadParams) bVar, jSONObject);
    }

    private static void a(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        if (JSONObject.NULL.toString().equals(downloadParams.mDownloadid)) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (JSONObject.NULL.toString().equals(downloadParams.mAppName)) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (JSONObject.NULL.toString().equals(downloadParams.mPkgname)) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (JSONObject.NULL.toString().equals(downloadParams.mVersion)) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (JSONObject.NULL.toString().equals(downloadParams.mVersionCode)) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (JSONObject.NULL.toString().equals(downloadParams.mFileMd5)) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (JSONObject.NULL.toString().equals(downloadParams.mFileUrl)) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (JSONObject.NULL.toString().equals(downloadParams.mAppIcon)) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (JSONObject.NULL.toString().equals(downloadParams.mShortDesc)) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString("filePath");
        if (JSONObject.NULL.toString().equals(downloadParams.filePath)) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    private static JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadParams.mDownloadid;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        String str2 = downloadParams.mAppName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        String str3 = downloadParams.mPkgname;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        String str4 = downloadParams.mVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        String str5 = downloadParams.mVersionCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        long j = downloadParams.mAppSize;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mAppSize", j);
        }
        String str6 = downloadParams.mFileMd5;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        String str7 = downloadParams.mFileUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        String str8 = downloadParams.mAppIcon;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        String str9 = downloadParams.mShortDesc;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        int i = downloadParams.mTaskId;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mTaskId", i);
        }
        String str10 = downloadParams.filePath;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "filePath", downloadParams.filePath);
        }
        boolean z = downloadParams.requestInstallPermission;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestInstallPermission", z);
        }
        boolean z2 = downloadParams.downloadEnablePause;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadEnablePause", z2);
        }
        int i2 = downloadParams.downloadPlace;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadPlace", i2);
        }
        return jSONObject;
    }
}
