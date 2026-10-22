package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ca implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.BaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.BaseInfo) bVar, jSONObject);
    }

    private static void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(baseInfo.sdkExtraData)) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(baseInfo.title)) {
            baseInfo.title = "";
        }
        baseInfo.photoDescribeSize = jSONObject.optInt("photoDescribeSize");
        baseInfo.photoTitleSize = jSONObject.optInt("photoTitleSize");
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (JSONObject.NULL.toString().equals(baseInfo.shareUrl)) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.waterMarkShowDuration = jSONObject.optLong("waterMarkShowDuration", new Long("-1").longValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (JSONObject.NULL.toString().equals(baseInfo.recoExt)) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (JSONObject.NULL.toString().equals(baseInfo.videoDesc)) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
        baseInfo.toolbarDisable = jSONObject.optBoolean("toolbarDisable");
    }

    private static JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = baseInfo.photoId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoId", j);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", baseInfo.title);
        }
        int i = baseInfo.photoDescribeSize;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoDescribeSize", i);
        }
        int i2 = baseInfo.photoTitleSize;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoTitleSize", i2);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "waterMarkShowDuration", baseInfo.waterMarkShowDuration);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j2 = baseInfo.likeCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "likeCount", j2);
        }
        long j3 = baseInfo.commentCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "commentCount", j3);
        }
        long j4 = baseInfo.viewCount;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "viewCount", j4);
        }
        long j5 = baseInfo.createTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "createTime", j5);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j6 = baseInfo.playTimes;
        if (j6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playTimes", j6);
        }
        long j7 = baseInfo.videoUrlCacheTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoUrlCacheTime", j7);
        }
        int i3 = baseInfo.contentSourceType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "contentSourceType", i3);
        }
        boolean z = baseInfo.toolbarDisable;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "toolbarDisable", z);
        }
        return jSONObject;
    }
}
